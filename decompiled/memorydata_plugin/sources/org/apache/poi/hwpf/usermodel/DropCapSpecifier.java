package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;

/* JADX INFO: loaded from: classes7.dex */
public final class DropCapSpecifier {
    private static final BitField _lines = null;
    private static final BitField _type = null;
    private short _fdct;

    static {
        _lines = BitFieldFactory.getInstance(248);
        _type = BitFieldFactory.getInstance(7);
    }

    public DropCapSpecifier() {
        this._fdct = 0;
    }

    public DropCapSpecifier(DropCapSpecifier r1) {
        this._fdct = r1._fdct;
    }

    public DropCapSpecifier(short r1) {
        this._fdct = r1;
    }

    public DropCapSpecifier copy() {
        return new DropCapSpecifier(this);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        DropCapSpecifier r6 = (DropCapSpecifier) ZeusTransformUtils.preCheckCast(r5, DropCapSpecifier.class, "com.obric.memorydata.plugin");
        if (this._fdct == r6._fdct) goto L14;
        return false;
    L14:
        return true;
    }

    public byte getCountOfLinesToDrop() {
        return (byte) _lines.getValue(this._fdct);
    }

    public byte getDropCapType() {
        return (byte) _type.getValue(this._fdct);
    }

    public int hashCode() {
        return this._fdct;
    }

    public boolean isEmpty() {
        if (this._fdct != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isEmpty() == false) goto L7;
        return "[DCS] EMPTY";
    L7:
        return "[DCS] (type: " + getDropCapType() + "; count: " + getCountOfLinesToDrop() + ")";
    }
}
