package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import org.apache.poi.hwpf.util.DoubleByteUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class TextPiece extends PropertyNode<TextPiece> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final PieceDescriptor _pd;
    private final boolean _usesUnicode;

    static {
    }

    public TextPiece(int r2, int r3, byte[] r4, PieceDescriptor r5) {
        super(r2, r3, buildInitSB(r4, r5));
        this._usesUnicode = r5.isUnicode();
        this._pd = r5;
        int r1 = ((CharSequence) ZeusTransformUtils.preCheckCast(this._buf, CharSequence.class, "com.obric.memorydata.plugin")).length();
        if ((r3 - r2) != r1) goto L9;
        if (r3 < r2) goto L7;
        return;
    L7:
        throw new IllegalStateException("Told we're of negative size! start=" + r2 + " end=" + r3);
    L9:
        throw new IllegalStateException("Told we're for characters " + r2 + " -> " + r3 + ", but actually covers " + r1 + " characters!");
    }

    private static StringBuilder buildInitSB(byte[] r4, PieceDescriptor r5) {
        if (DoubleByteUtil.BIG5.equals(r5.getCharset()) == true) goto L5;
        int r2 = r4.length;
        if (r5.isUnicode() == false) goto L9;
        Charset r6 = StringUtil.UTF16LE;
    L11:
        return new StringBuilder(new String(r4, 0, r2, r6));
    L9:
        r6 = r5.getCharset();
        goto L11
    L5:
        return new StringBuilder(DoubleByteUtil.cp950ToString(r4, 0, r4.length));
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    @Deprecated
    public void adjustForDelete(int r6, int r7) {
        int r0 = getStart();
        int r1 = getEnd();
        int r2 = r6 + r7;
        if (r6 > r1) goto L6;
        if (r2 < r0) goto L6;
        int r3 = Math.max(r0, r6);
        int r4 = r3 - r0;
        int r5 = Math.min(r1, r2) - r0;
        ((StringBuilder) ZeusTransformUtils.preCheckCast(this._buf, StringBuilder.class, "com.obric.memorydata.plugin")).delete(r4, r5);
    L6:
        super.adjustForDelete(r6, r7);
    }

    public int bytesLength() {
        int r0 = getEnd() - getStart();
        if (this._usesUnicode == false) goto L5;
        int r2 = 2;
    L7:
        return r0 * r2;
    L5:
        r2 = 1;
        goto L7
    }

    @Deprecated
    public int characterLength() {
        return getEnd() - getStart();
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, TextPiece.class) == true) goto L5;
        return false;
    L5:
        TextPiece r0 = (TextPiece) ZeusTransformUtils.preCheckCast(r4, TextPiece.class, "com.obric.memorydata.plugin");
        if (limitsAreEqual(r4) == true) goto L8;
        return false;
    L8:
        if (r0._usesUnicode == this._usesUnicode) goto L10;
        return false;
    L10:
        if (r0._buf.toString().equals(this._buf.toString()) == true) goto L12;
        return false;
    L12:
        if (r0._pd.equals(this._pd) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public PieceDescriptor getPieceDescriptor() {
        return this._pd;
    }

    public StringBuilder getStringBuilder() {
        return (StringBuilder) ZeusTransformUtils.preCheckCast(this._buf, StringBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public int hashCode() {
        return 42;
    }

    public boolean isUnicode() {
        return this._usesUnicode;
    }

    public String toString() {
        return "TextPiece from " + getStart() + " to " + getEnd() + " (" + getPieceDescriptor() + ")";
    }
}
