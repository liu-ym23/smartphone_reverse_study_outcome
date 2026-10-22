package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Comparator;
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
public class PAPBinTable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    protected final ArrayList<PAPX> _paragraphs;

    static {
        LOG = b.a(PAPBinTable.class);
    }

    public PAPBinTable() {
        this._paragraphs = new ArrayList();
    }

    public PAPBinTable(byte[] r8, byte[] r9, byte[] r10, int r11, int r12, CharIndexTranslator r13) {
        CharIndexTranslator r14 = (CharIndexTranslator) ZeusTransformUtils.wrapperContextForParams(r13, CharIndexTranslator.class, "com.obric.memorydata.plugin");
        this._paragraphs = new ArrayList();
        long r2 = System.currentTimeMillis();
        PlexOfCps r0 = new PlexOfCps(r9, r11, r12, 4);
        int r15 = r0.length();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L11;
        Iterator<PAPX> r4 = new PAPFormattedDiskPage(r8, r10, LittleEndian.getInt(r0.getProperty(r16).getBytes()) * 512, r14).getPAPXs().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        PAPX r5 = (PAPX) ZeusTransformUtils.preCheckCast(r4.next(), PAPX.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        this._paragraphs.add(r5);
        goto L6
    L10:
        r16 = r16 + 1;
        goto L3
    L11:
        c r17 = LOG;
        r17.atDebug().a("PAPX tables loaded in {} ms ({} elements)", v.a(System.currentTimeMillis() - r2), v.a(this._paragraphs.size()));
        if (this._paragraphs.isEmpty() == false) goto L21;
        r17.atWarn().a("PAPX FKPs are empty");
        this._paragraphs.add(new PAPX(0, 0, new SprmBuffer(2)));
        return;
    }

    static /* synthetic */ int lambda$rebuild$0(Map r2, PAPX r3, PAPX r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return ((Integer) ZeusTransformUtils.preCheckCast(r5.get(r3), Integer.class, "com.obric.memorydata.plugin")).compareTo((Integer) ZeusTransformUtils.preCheckCast(r5.get(r4), Integer.class, "com.obric.memorydata.plugin"));
    }

    static void rebuild(StringBuilder r18, ComplexFileTable r19, List<PAPX> r20) {
        String r1 = "com.obric.memorydata.plugin";
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        char r4 = 2;
        boolean r6 = true;
        if (r19 == null) goto L26;
        SprmBuffer[] r7 = r19.getGrpprls();
        Iterator<TextPiece> r8 = r19.getTextPieceTable().getTextPieces().iterator();
    L6:
        if (r8.hasNext() == false) goto L25;
        TextPiece r9 = (TextPiece) ZeusTransformUtils.preCheckCast(r8.next(), TextPiece.class, "com.obric.memorydata.plugin");
        PropertyModifier r10 = r9.getPieceDescriptor().getPrm();
        if (r10.isComplex() == false) goto L6;
        short r11 = r10.getIgrpprl();
        if (r11 < 0) goto L24;
        if (r11 >= r7.length) goto L24;
        SprmBuffer r12 = r7[r11];
        SprmIterator r13 = r12.iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        if (r13.next().getType() != 1) goto L17;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L6;
        SprmBuffer r15 = new SprmBuffer(2);
        r15.append(r12.toByteArray());
        r0.add(new PAPX(r9.getStart(), r9.getEnd(), r15));
        goto L6
    L21:
        r14 = false;
    L24:
        LOG.atWarn().a("{}'s PRM references to unknown grpprl", r9);
        goto L6
    L25:
        LOG.atDebug().a("Merged (?) with PAPX from complex file table in {} ms ({} elements in total)", v.a(System.currentTimeMillis() - r2), v.a(r0.size()));
        r2 = System.currentTimeMillis();
    L26:
        ArrayList r16 = new ArrayList(r0);
        r16.sort(PropertyNode.EndComparator);
        LOG.atDebug().a("PAPX sorted by end position in {} ms", v.a(System.currentTimeMillis() - r2));
        long r3 = System.currentTimeMillis();
        final IdentityHashMap r17 = new IdentityHashMap();
        Iterator r21 = r0.iterator();
        int r110 = 0;
    L28:
        if (r21.hasNext() == false) goto L30;
        r17.put((PAPX) ZeusTransformUtils.preCheckCast(r21.next(), PAPX.class, "com.obric.memorydata.plugin"), Integer.valueOf(r110));
        r110 = r110 + 1;
        goto L28
    L30:
        Comparator r22 = new $$Lambda$PAPBinTable$CkvIxZSVEJ4ytiZiRrQHuok_RM(r17);
        LOG.atDebug().a("PAPX's order map created in {} ms", v.a(System.currentTimeMillis() - r3));
        long r5 = System.currentTimeMillis();
        LinkedList r23 = new LinkedList();
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
    L32:
        if (r111 >= r18.length()) goto L77;
        char r114 = r18.charAt(r111);
        if (r114 != '\r') goto L36;
    L40:
        int r115 = r111 + 1;
        LinkedList r116 = new LinkedList();
        int r24 = r113;
    L42:
        if (r24 >= r16.size()) goto L47;
        PAPX r25 = (PAPX) ZeusTransformUtils.preCheckCast(r16.get(r24), PAPX.class, r1);
        if ((r25.getEnd() - 1) > r111) goto L45;
        r116.add(r25);
        r24 = r24 + 1;
        r6 = true;
        goto L42
    L45:
        r113 = r24;
        boolean r26 = true;
    L48:
        if (r26 == true) goto L51;
        r113 = r16.size() - 1;
    L51:
        if (r116.isEmpty() == false) goto L55;
        LOG.atWarn().a("Paragraph [{}; {}) has no PAPX. Creating new one.", v.a(r112), v.a(r115));
        PAPX r27 = new PAPX(r112, r115, new SprmBuffer(2));
    L53:
        r23.add(r27);
        String r117 = r1;
        char r28 = 2;
    L75:
        r112 = r115;
    L76:
        r111 = r111 + 1;
        r4 = r28;
        r1 = r117;
        r6 = true;
        goto L32
    L55:
        if (r116.size() != 1) goto L61;
        r27 = (PAPX) ZeusTransformUtils.preCheckCast(r116.get(0), PAPX.class, r1);
        if (r27.getStart() != r112) goto L61;
        if (r27.getEnd() == r115) goto L53;
    L61:
        r116.sort(r22);
        SprmBuffer r29 = null;
        Iterator r30 = r116.iterator();
    L63:
        if (r30.hasNext() == false) goto L74;
        PAPX r31 = (PAPX) ZeusTransformUtils.preCheckCast(r30.next(), PAPX.class, r1);
        if (r31.getGrpprl() == null) goto L72;
        String r118 = r1;
        if (r31.getGrpprl().length <= 2) goto L73;
        if (r29 != null) goto L71;
        r29 = r31.getSprmBuf().copy();
        goto L73
    L71:
        r29.append(r31.getGrpprl(), 2);
    L73:
        r1 = r118;
        goto L63
    L72:
        r118 = r1;
        goto L73
    L74:
        r117 = r1;
        r28 = 2;
        r23.add(new PAPX(r112, r115, r29));
        goto L75
    L47:
        r26 = false;
        goto L48
    L36:
        if (r114 == 7) goto L40;
        if (r114 == '\f') goto L40;
        r117 = r1;
        r28 = r4;
        goto L76
    L77:
        r0.clear();
        r0.addAll(r23);
        LOG.atDebug().a("PAPX rebuilded from document text in {} ms ({} elements)", v.a(System.currentTimeMillis() - r5), v.a(r0.size()));
    }

    public ArrayList<PAPX> getParagraphs() {
        return this._paragraphs;
    }

    public void insert(int r5, int r6, SprmBuffer r7) {
        PAPX r0 = new PAPX(0, 0, r7);
        r0.setStart(r6);
        r0.setEnd(r6);
        if (r5 != this._paragraphs.size()) goto L5;
        this._paragraphs.add(r0);
        return;
    L5:
        PAPX r8 = (PAPX) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r5), PAPX.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L8;
    L10:
        this._paragraphs.add(r5, r0);
        return;
    L8:
        if (r8.getStart() >= r6) goto L10;
        PAPX r3 = new PAPX(0, 0, r8.getSprmBuf().copy());
        r3.setStart(r6);
        r3.setEnd(r8.getEnd());
        r8.setEnd(r6);
        this._paragraphs.add(r5 + 1, r0);
        this._paragraphs.add(r5 + 2, r3);
    }

    public void rebuild(StringBuilder r1, ComplexFileTable r2) {
        rebuild(r1, r2, this._paragraphs);
    }
}
