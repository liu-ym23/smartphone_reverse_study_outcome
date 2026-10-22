package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class Notes extends SheetContainer {
    private static long _type = 1008;
    private ColorSchemeAtom _colorScheme;
    private byte[] _header;
    private NotesAtom notesAtom;
    private PPDrawing ppDrawing;

    static {
    }

    public Notes(byte[] r4, int r5, int r6) {
        int r0 = r5 + 8;
        this._header = Arrays.copyOfRange(r4, r5, r0);
        this._children = Record.findChildRecords(r4, r0, r6 - 8);
        Record[] r7 = this._children;
        int r8 = r7.length;
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L16;
        Record r1 = r7[r9];
        if (ZeusTransformUtils.instanceOf(r1, NotesAtom.class) == false) goto L8;
        this.notesAtom = (NotesAtom) ZeusTransformUtils.preCheckCast(r1, NotesAtom.class, "com.obric.memorydata.plugin");
    L8:
        if (ZeusTransformUtils.instanceOf(r1, PPDrawing.class) == false) goto L11;
        this.ppDrawing = (PPDrawing) ZeusTransformUtils.preCheckCast(r1, PPDrawing.class, "com.obric.memorydata.plugin");
    L11:
        if (this.ppDrawing == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r1, ColorSchemeAtom.class) == false) goto L15;
        this._colorScheme = (ColorSchemeAtom) ZeusTransformUtils.preCheckCast(r1, ColorSchemeAtom.class, "com.obric.memorydata.plugin");
    L15:
        r9 = r9 + 1;
        goto L3
    }

    public NotesAtom getNotesAtom() {
        return this.notesAtom;
    }

    @Override // org.apache.poi.hslf.record.SheetContainer
    public PPDrawing getPPDrawing() {
        return this.ppDrawing;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], _type, this._children, r10);
    }
}
