package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class TextPieceTable implements CharIndexTranslator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private static int MAX_RECORD_LENGTH;
    int _cpMin;
    protected ArrayList<TextPiece> _textPieces;
    protected ArrayList<TextPiece> _textPiecesFCOrder;

    static {
        LOG = b.a(TextPieceTable.class);
        MAX_RECORD_LENGTH = 100000000;
    }

    public TextPieceTable() {
        this._textPieces = new ArrayList();
        this._textPiecesFCOrder = new ArrayList();
    }

    public TextPieceTable(byte[] r6, byte[] r7, int r8, int r9, int r10) {
        this._textPieces = new ArrayList();
        this._textPiecesFCOrder = new ArrayList();
        PlexOfCps r0 = new PlexOfCps(r7, r8, r9, PieceDescriptor.getSizeInBytes());
        int r11 = r0.length();
        PieceDescriptor[] r12 = new PieceDescriptor[r11];
        int r13 = 0;
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L5;
        r12[r1] = new PieceDescriptor(r0.getProperty(r1).getBytes(), 0);
        r1 = r1 + 1;
        goto L3
    L5:
        this._cpMin = r12[0].getFilePosition() - r10;
        int r2 = 0;
    L6:
        if (r2 >= r11) goto L11;
        int r3 = r12[r2].getFilePosition() - r10;
        if (r3 >= this._cpMin) goto L10;
        this._cpMin = r3;
    L10:
        r2 = r2 + 1;
    L11:
        if (r13 >= r11) goto L17;
        int r14 = r12[r13].getFilePosition();
        GenericPropertyNode r4 = r0.getProperty(r13);
        int r5 = r4.getStart();
        int r15 = r4.getEnd();
        if (r12[r13].isUnicode() == false) goto L15;
        int r16 = 2;
    L16:
        this._textPieces.add(newTextPiece(r5, r15, IOUtils.safelyClone(r6, r14, (r15 - r5) * r16, MAX_RECORD_LENGTH), r12[r13]));
        r13 = r13 + 1;
        goto L11
    L15:
        r16 = 1;
        goto L16
    L17:
        Collections.sort(this._textPieces);
        ArrayList<TextPiece> r17 = new ArrayList(this._textPieces);
        this._textPiecesFCOrder = r17;
        r17.sort(byFilePosition());
    }

    static Comparator<TextPiece> byFilePosition() {
        return Comparator.comparing($$Lambda$TextPieceTable$dwugrlueBtXpje8FFxQuvxxs2g.INSTANCE);
    }

    static /* synthetic */ Integer lambda$byFilePosition$0(TextPiece r0) {
        return Integer.valueOf(r0.getPieceDescriptor().getFilePosition());
    }

    public void add(TextPiece r2) {
        this._textPieces.add(r2);
        this._textPiecesFCOrder.add(r2);
        Collections.sort(this._textPieces);
        this._textPiecesFCOrder.sort(byFilePosition());
    }

    public boolean equals(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, TextPieceTable.class) == true) goto L5;
        return false;
    L5:
        TextPieceTable r8 = (TextPieceTable) ZeusTransformUtils.preCheckCast(r7, TextPieceTable.class, "com.obric.memorydata.plugin");
        int r0 = r8._textPieces.size();
        if (r0 != this._textPieces.size()) goto L15;
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L13;
        if (((TextPiece) ZeusTransformUtils.preCheckCast(r8._textPieces.get(r3), TextPiece.class, "com.obric.memorydata.plugin")).equals(this._textPieces.get(r3)) == false) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    L15:
        return false;
    }

    @Override // org.apache.poi.hwpf.model.CharIndexTranslator
    public int[][] getCharIndexRanges(int r8, int r9) {
        LinkedList r0 = new LinkedList();
        Iterator<TextPiece> r1 = this._textPiecesFCOrder.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        TextPiece r2 = (TextPiece) ZeusTransformUtils.preCheckCast(r1.next(), TextPiece.class, "com.obric.memorydata.plugin");
        int r4 = r2.getPieceDescriptor().getFilePosition();
        if (r9 <= r4) goto L16;
        int r3 = r2.getPieceDescriptor().getFilePosition() + r2.bytesLength();
        if (r8 > r3) goto L4;
        int r5 = Math.max(r4, r8);
        int r6 = Math.min(r3, r9);
        if (r5 > r6) goto L4;
        int r7 = getEncodingMultiplier(r2);
        int r10 = r2.getStart() + ((r5 - r4) / r7);
        r0.add(new int[]{r10, ((r6 - r5) / r7) + r10});
    L16:
        return (int[][]) ZeusTransformUtils.preCheckCast(r0.toArray(new int[r0.size()][]), int[][].class, "com.obric.memorydata.plugin");
    }

    public int getEncodingMultiplier(TextPiece r1) {
        if (r1.isUnicode() == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    public StringBuilder getText() {
        long r0 = System.currentTimeMillis();
        StringBuilder r2 = new StringBuilder();
        Iterator<TextPiece> r11 = this._textPieces.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        TextPiece r3 = (TextPiece) ZeusTransformUtils.preCheckCast(r11.next(), TextPiece.class, "com.obric.memorydata.plugin");
        String r4 = r3.getStringBuilder().toString();
        int r5 = r4.length();
        if (r5 == (r3.getEnd() - r3.getStart())) goto L8;
        LOG.atWarn().a("Text piece has boundaries [{}; {}) but length {}", v.a(r3.getStart()), v.a(r3.getEnd()), v.a(r3.getEnd() - r3.getStart()));
    L8:
        r2.replace(r3.getStart(), r3.getStart() + r5, r4);
        goto L4
    L9:
        LOG.atDebug().a("Document text were rebuilt in {} ms ({} chars)", v.a(System.currentTimeMillis() - r0), v.a(r2.length()));
        return r2;
    }

    public List<TextPiece> getTextPieces() {
        return this._textPieces;
    }

    public int hashCode() {
        return this._textPieces.hashCode();
    }

    public TextPiece newTextPiece(int r1, int r2, byte[] r3, PieceDescriptor r4) {
        return new TextPiece(r1, r2, r3, r4);
    }
}
