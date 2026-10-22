package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class Ffn {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static BitField _fTrueType;
    private static BitField _ff;
    private static BitField _prq;
    private int _cbFfnM1;
    private byte _chs;
    private byte[] _fontSig;
    private byte _info;
    private byte _ixchSzAlt;
    private byte[] _panose;
    private short _wWeight;
    private char[] _xszFfn;
    private int _xszFfnLength;

    static {
        _prq = BitFieldFactory.getInstance(3);
        _fTrueType = BitFieldFactory.getInstance(4);
        _ff = BitFieldFactory.getInstance(112);
    }

    public Ffn(byte[] r5, int r6) {
        this._panose = new byte[10];
        this._fontSig = new byte[24];
        this._cbFfnM1 = LittleEndian.getUByte(r5, r6);
        int r0 = r6 + 1;
        this._info = r5[r0];
        int r1 = r0 + 1;
        this._wWeight = LittleEndian.getShort(r5, r1);
        int r2 = r1 + 2;
        this._chs = r5[r2];
        int r3 = r2 + 1;
        this._ixchSzAlt = r5[r3];
        int r4 = r3 + 1;
        byte[] r7 = this._panose;
        int r8 = 0;
        System.arraycopy(r5, r4, r7, 0, r7.length);
        int r9 = r4 + this._panose.length;
        byte[] r10 = this._fontSig;
        System.arraycopy(r5, r9, r10, 0, r10.length);
        int r11 = r9 + this._fontSig.length;
        int r12 = r11 - r6;
        int r13 = (getSize() - r12) / 2;
        this._xszFfnLength = r13;
        if (r13 < 0) goto L10;
        this._xszFfn = new char[r13];
    L6:
        if (r8 >= this._xszFfnLength) goto L8;
        this._xszFfn[r8] = (char) LittleEndian.getShort(r5, r11);
        r11 = r11 + 2;
        r8 = r8 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Had invalid computed size: " + this._xszFfnLength + " with size " + getSize() + " and offsetTmp: " + r12);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Ffn.class) == true) goto L5;
        return false;
    L5:
        Ffn r5 = (Ffn) ZeusTransformUtils.preCheckCast(r4, Ffn.class, "com.obric.memorydata.plugin");
        if (r5._cbFfnM1 == this._cbFfnM1) goto L8;
        return false;
    L8:
        if (r5._info == this._info) goto L10;
        return false;
    L10:
        if (r5._wWeight == this._wWeight) goto L12;
        return false;
    L12:
        if (r5._chs == this._chs) goto L14;
        return false;
    L14:
        if (r5._ixchSzAlt == this._ixchSzAlt) goto L16;
        return false;
    L16:
        if (Arrays.equals(r5._panose, this._panose) == true) goto L18;
        return false;
    L18:
        if (Arrays.equals(r5._fontSig, this._fontSig) == true) goto L20;
        return false;
    L20:
        if (Arrays.equals(r5._xszFfn, this._xszFfn) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int getSize() {
        return this._cbFfnM1 + 1;
    }

    public int hashCode() {
        return 42;
    }
}
