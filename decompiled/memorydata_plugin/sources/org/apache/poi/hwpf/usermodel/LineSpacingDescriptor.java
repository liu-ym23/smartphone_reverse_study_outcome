package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class LineSpacingDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    short _dyaLine;
    short _fMultiLinespace;

    static {
    }

    public LineSpacingDescriptor() {
        this._dyaLine = 240;
        this._fMultiLinespace = 1;
    }

    public LineSpacingDescriptor(LineSpacingDescriptor r2) {
        this._dyaLine = r2._dyaLine;
        this._fMultiLinespace = r2._fMultiLinespace;
    }

    public LineSpacingDescriptor(byte[] r2, int r3) {
        this._dyaLine = LittleEndian.getShort(r2, r3);
        this._fMultiLinespace = LittleEndian.getShort(r2, r3 + 2);
    }

    public LineSpacingDescriptor copy() {
        return new LineSpacingDescriptor(this);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, LineSpacingDescriptor.class) == true) goto L5;
        return false;
    L5:
        LineSpacingDescriptor r5 = (LineSpacingDescriptor) ZeusTransformUtils.preCheckCast(r4, LineSpacingDescriptor.class, "com.obric.memorydata.plugin");
        if (this._dyaLine == r5._dyaLine) goto L8;
        return false;
    L8:
        if (this._fMultiLinespace != r5._fMultiLinespace) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return 42;
    }

    public boolean isEmpty() {
        if (this._dyaLine == 0) goto L5;
    L7:
        return false;
    L5:
        if (this._fMultiLinespace != 0) goto L7;
        return true;
    }

    public String toString() {
        if (isEmpty() == false) goto L7;
        return "[LSPD] EMPTY";
    L7:
        return "[LSPD] (dyaLine: " + this._dyaLine + "; fMultLinespace: " + this._fMultiLinespace + ")";
    }
}
