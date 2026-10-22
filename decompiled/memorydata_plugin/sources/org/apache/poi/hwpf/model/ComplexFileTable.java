package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.sprm.SprmBuffer;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class ComplexFileTable {
    private SprmBuffer[] _grpprls;
    protected TextPieceTable _tpt;

    public ComplexFileTable() {
        this._tpt = new TextPieceTable();
    }

    public ComplexFileTable(byte[] r7, byte[] r8, int r9, int r10) {
        this(r7, r8, r9, r10, StringUtil.WIN_1252);
    }

    public ComplexFileTable(byte[] r8, byte[] r9, int r10, int r11, Charset r12) {
        LinkedList r0 = new LinkedList();
    L4:
        if (r9[r10] != 1) goto L6;
        int r13 = r10 + 1;
        short r1 = LittleEndian.getShort(r9, r13);
        int r14 = r13 + 2;
        byte[] r2 = IOUtils.safelyClone(r9, r14, r1, HWPFDocument.getMaxRecordLength());
        r10 = r14 + r1;
        r0.add(new SprmBuffer(r2, false, 0));
        goto L4
    L6:
        this._grpprls = (SprmBuffer[]) ZeusTransformUtils.preCheckCast(r0.toArray(new SprmBuffer[0]), SprmBuffer[].class, "com.obric.memorydata.plugin");
        if (r9[r10] != 2) goto L11;
        int r15 = r10 + 1;
        this._tpt = newTextPieceTable(r8, r9, r15 + 4, LittleEndian.getInt(r9, r15), r11, r12);
        return;
    L11:
        throw new IOException("The text piece table is corrupted, expected byte value 2 but had " + r9[r10]);
    }

    public SprmBuffer[] getGrpprls() {
        return this._grpprls;
    }

    public TextPieceTable getTextPieceTable() {
        return this._tpt;
    }

    public TextPieceTable newTextPieceTable(byte[] r7, byte[] r8, int r9, int r10, int r11, Charset r12) {
        return new TextPieceTable(r7, r8, r9, r10, r11);
    }
}
