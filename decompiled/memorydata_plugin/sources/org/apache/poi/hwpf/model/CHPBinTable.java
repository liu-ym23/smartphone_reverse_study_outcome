package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.sprm.SprmBuffer;
import org.apache.poi.hwpf.sprm.SprmIterator;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class CHPBinTable {
    private static final c LOG = null;
    protected List<CHPX> _textRuns;

    static {
        LOG = b.a(CHPBinTable.class);
    }

    public CHPBinTable() {
        this._textRuns = new ArrayList();
    }

    public CHPBinTable(byte[] r8, byte[] r9, int r10, int r11, CharIndexTranslator r12) {
        CharIndexTranslator r13 = (CharIndexTranslator) ZeusTransformUtils.wrapperContextForParams(r12, CharIndexTranslator.class, "com.obric.memorydata.plugin");
        this._textRuns = new ArrayList();
        long r2 = System.currentTimeMillis();
        PlexOfCps r0 = new PlexOfCps(r9, r10, r11, 4);
        int r14 = r0.length();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L11;
        Iterator<CHPX> r4 = new CHPFormattedDiskPage(r8, LittleEndian.getInt(r0.getProperty(r15).getBytes()) * 512, r13).getCHPXs().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        CHPX r5 = (CHPX) ZeusTransformUtils.preCheckCast(r4.next(), CHPX.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        this._textRuns.add(r5);
        goto L6
    L10:
        r15 = r15 + 1;
        goto L3
    L11:
        c r16 = LOG;
        r16.atDebug().a("CHPX FKPs loaded in {} ms ({} elements)", v.a(System.currentTimeMillis() - r2), v.a(this._textRuns.size()));
        if (this._textRuns.isEmpty() == false) goto L21;
        r16.atWarn().a("CHPX FKPs are empty");
        this._textRuns.add(new CHPX(0, 0, new SprmBuffer(0)));
        return;
    }

    private static int binarySearch(List<CHPX> r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r8.size() - 1;
        int r2 = 0;
    L3:
        if (r2 > r0) goto L11;
        int r3 = (r2 + r0) >>> 1;
        int r4 = ((CHPX) ZeusTransformUtils.preCheckCast(r8.get(r3), CHPX.class, "com.obric.memorydata.plugin")).getStart();
        if (r4 < r7) goto L6;
        if (r4 <= r7) goto L9;
        r0 = r3 - 1;
        goto L3
    L9:
        return r3;
    L6:
        r2 = r3 + 1;
        goto L3
    L11:
        return -(r2 + 1);
    }

    static /* synthetic */ int lambda$rebuild$0(Map r2, CHPX r3, CHPX r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return ((Integer) ZeusTransformUtils.preCheckCast(r5.get(r3), Integer.class, "com.obric.memorydata.plugin")).compareTo((Integer) ZeusTransformUtils.preCheckCast(r5.get(r4), Integer.class, "com.obric.memorydata.plugin"));
    }

    public List<CHPX> getTextRuns() {
        return this._textRuns;
    }

    public void insert(int r5, int r6, SprmBuffer r7) {
        CHPX r0 = new CHPX(0, 0, r7);
        r0.setStart(r6);
        r0.setEnd(r6);
        if (r5 != this._textRuns.size()) goto L5;
        this._textRuns.add(r0);
        return;
    L5:
        CHPX r8 = (CHPX) ZeusTransformUtils.preCheckCast(this._textRuns.get(r5), CHPX.class, "com.obric.memorydata.plugin");
        if (r8.getStart() >= r6) goto L8;
        CHPX r2 = new CHPX(0, 0, r8.getSprmBuf());
        r2.setStart(r6);
        r2.setEnd(r8.getEnd());
        r8.setEnd(r6);
        this._textRuns.add(r5 + 1, r0);
        this._textRuns.add(r5 + 2, r2);
        return;
    L8:
        this._textRuns.add(r5, r0);
    }

    public void rebuild(ComplexFileTable r17) {
        long r1 = System.currentTimeMillis();
        if (r17 == null) goto L26;
        SprmBuffer[] r6 = r17.getGrpprls();
        Iterator<TextPiece> r7 = r17.getTextPieceTable().getTextPieces().iterator();
    L6:
        if (r7.hasNext() == false) goto L25;
        TextPiece r8 = (TextPiece) ZeusTransformUtils.preCheckCast(r7.next(), TextPiece.class, "com.obric.memorydata.plugin");
        PropertyModifier r9 = r8.getPieceDescriptor().getPrm();
        if (r9.isComplex() == false) goto L6;
        short r10 = r9.getIgrpprl();
        if (r10 < 0) goto L24;
        if (r10 >= r6.length) goto L24;
        SprmBuffer r11 = r6[r10];
        SprmIterator r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L21;
        if (r12.next().getType() != 2) goto L17;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L6;
        this._textRuns.add(new CHPX(r8.getStart(), r8.getEnd(), r11.copy()));
        goto L6
    L21:
        r13 = false;
    L24:
        LOG.atWarn().a("{}'s PRM references to unknown grpprl", r8);
        goto L6
    L25:
        LOG.atDebug().a("Merged with CHPX from complex file table in {} ms ({} elements in total)", v.a(System.currentTimeMillis() - r1), v.a(this._textRuns.size()));
        r1 = System.currentTimeMillis();
    L26:
        ArrayList r14 = new ArrayList(this._textRuns);
        r14.sort(PropertyNode.StartComparator);
        LOG.atDebug().a("CHPX sorted by start position in {} ms", v.a(System.currentTimeMillis() - r1));
        long r2 = System.currentTimeMillis();
        final IdentityHashMap r15 = new IdentityHashMap();
        Iterator<CHPX> r16 = this._textRuns.iterator();
        int r18 = 0;
    L28:
        if (r16.hasNext() == false) goto L30;
        r15.put((CHPX) ZeusTransformUtils.preCheckCast(r16.next(), CHPX.class, "com.obric.memorydata.plugin"), Integer.valueOf(r18));
        r18 = r18 + 1;
        goto L28
    L30:
        Comparator r19 = new $$Lambda$CHPBinTable$t25wV60qGDYqcjJcZNsOTAuN4(r15);
        LOG.atDebug().a("CHPX's order map created in {} ms", v.a(System.currentTimeMillis() - r2));
        long r3 = System.currentTimeMillis();
        HashSet r20 = new HashSet();
        Iterator<CHPX> r21 = this._textRuns.iterator();
    L32:
        if (r21.hasNext() == false) goto L34;
        CHPX r110 = (CHPX) ZeusTransformUtils.preCheckCast(r21.next(), CHPX.class, "com.obric.memorydata.plugin");
        r20.add(Integer.valueOf(r110.getStart()));
        r20.add(Integer.valueOf(r110.getEnd()));
        goto L32
    L34:
        r20.remove(0);
        ArrayList r22 = new ArrayList(r20);
        Collections.sort(r22);
        LOG.atDebug().a("Texts CHPX boundaries collected in {} ms", v.a(System.currentTimeMillis() - r3));
        long r4 = System.currentTimeMillis();
        LinkedList r23 = new LinkedList();
        Iterator r24 = r22.iterator();
        int r111 = 0;
    L36:
        if (r24.hasNext() == false) goto L71;
        int r112 = ((Integer) ZeusTransformUtils.preCheckCast(r24.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r113 = Math.abs(binarySearch(r14, r112));
    L39:
        if (r113 < r14.size()) goto L41;
        r113 = r113 - 1;
    L41:
        if (r113 <= 0) goto L45;
        if (((CHPX) ZeusTransformUtils.preCheckCast(r14.get(r113), CHPX.class, "com.obric.memorydata.plugin")).getStart() < r112) goto L45;
        r113 = r113 - 1;
    L45:
        LinkedList r114 = new LinkedList();
    L47:
        if (r113 >= r14.size()) goto L56;
        CHPX r115 = (CHPX) ZeusTransformUtils.preCheckCast(r14.get(r113), CHPX.class, "com.obric.memorydata.plugin");
        if (r112 < r115.getStart()) goto L56;
        if (Math.max(r111, r115.getStart()) >= Math.min(r112, r115.getEnd())) goto L54;
        r114.add(r115);
    L54:
        r113 = r113 + 1;
    L56:
        if (r114.isEmpty() == false) goto L59;
        LOG.atWarn().a("Text piece [{}; {}) has no CHPX. Creating new one.", v.a(r111), v.a(r112));
        r23.add(new CHPX(r111, r112, new SprmBuffer(0)));
    L70:
        r111 = r112;
        goto L36
    L59:
        if (r114.size() != 1) goto L65;
        CHPX r5 = (CHPX) ZeusTransformUtils.preCheckCast(r114.get(0), CHPX.class, "com.obric.memorydata.plugin");
        if (r5.getStart() != r111) goto L65;
        if (r5.getEnd() != r112) goto L65;
        r23.add(r5);
    L65:
        r114.sort(r19);
        SprmBuffer r25 = new SprmBuffer(0);
        Iterator r116 = r114.iterator();
    L67:
        if (r116.hasNext() == false) goto L69;
        r25.append(((CHPX) ZeusTransformUtils.preCheckCast(r116.next(), CHPX.class, "com.obric.memorydata.plugin")).getGrpprl(), 0);
        goto L67
    L69:
        r23.add(new CHPX(r111, r112, r25));
        goto L70
    L71:
        this._textRuns = new ArrayList(r23);
        LOG.atDebug().a("CHPX rebuilt in {} ms ({} elements)", v.a(System.currentTimeMillis() - r4), v.a(this._textRuns.size()));
        long r26 = System.currentTimeMillis();
        CHPX r27 = null;
        Iterator<CHPX> r28 = this._textRuns.iterator();
    L73:
        if (r28.hasNext() == false) goto L83;
        CHPX r29 = (CHPX) ZeusTransformUtils.preCheckCast(r28.next(), CHPX.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L82;
        if (r27.getEnd() != r29.getStart()) goto L82;
        if (Arrays.equals(r27.getGrpprl(), r29.getGrpprl()) == false) goto L82;
        r27.setEnd(r29.getEnd());
        r28.remove();
    L82:
        r27 = r29;
        goto L73
    L83:
        LOG.atDebug().a("CHPX compacted in {} ms ({} elements)", v.a(System.currentTimeMillis() - r26), v.a(this._textRuns.size()));
    }
}
