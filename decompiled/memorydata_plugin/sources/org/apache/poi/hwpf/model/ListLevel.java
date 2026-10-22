package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.model.types.LVLFAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class ListLevel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private byte[] _grpprlChpx;
    private byte[] _grpprlPapx;
    private LVLF _lvlf;
    private Xst _xst;

    static {
        LOG = b.a(ListLevel.class);
    }

    ListLevel() {
        this._xst = new Xst();
    }

    @Deprecated
    public ListLevel(byte[] r2, int r3) {
        this._xst = new Xst();
        read(r2, r3);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ListLevel.class) == true) goto L5;
        return false;
    L5:
        ListLevel r5 = (ListLevel) ZeusTransformUtils.preCheckCast(r4, ListLevel.class, "com.obric.memorydata.plugin");
        if (r5._lvlf.equals(this._lvlf) == true) goto L8;
        return false;
    L8:
        if (Arrays.equals(r5._grpprlChpx, this._grpprlChpx) == true) goto L10;
        return false;
    L10:
        if (Arrays.equals(r5._grpprlPapx, this._grpprlPapx) == true) goto L12;
        return false;
    L12:
        if (r5._xst.equals(this._xst) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public byte[] getGrpprlPapx() {
        return this._grpprlPapx;
    }

    public int getSizeInBytes() {
        return ((LVLFAbstractType.getSize() + this._lvlf.getCbGrpprlChpx()) + this._lvlf.getCbGrpprlPapx()) + this._xst.getSize();
    }

    public int hashCode() {
        return 42;
    }

    int read(byte[] r5, int r6) {
        this._lvlf = new LVLF(r5, r6);
        int r0 = LVLFAbstractType.getSize() + r6;
        byte[] r1 = new byte[this._lvlf.getCbGrpprlPapx()];
        this._grpprlPapx = r1;
        System.arraycopy(r5, r0, r1, 0, this._lvlf.getCbGrpprlPapx());
        int r2 = r0 + this._lvlf.getCbGrpprlPapx();
        byte[] r3 = new byte[this._lvlf.getCbGrpprlChpx()];
        this._grpprlChpx = r3;
        System.arraycopy(r5, r2, r3, 0, this._lvlf.getCbGrpprlChpx());
        int r4 = r2 + this._lvlf.getCbGrpprlChpx();
        Xst r7 = new Xst(r5, r4);
        this._xst = r7;
        int r8 = r4 + r7.getSize();
        if (this._lvlf.getNfc() != 23) goto L8;
        if (this._xst.getCch() == 1) goto L8;
        LOG.atWarn().a("LVL at offset {} has nfc == 0x17 (bullets), but cch != 1 ({})", v.a(r6), v.a(this._xst.getCch()));
    L8:
        return r8 - r6;
    }

    public String toString() {
        return "LVL: " + ("\n" + this._lvlf).replace("\n", "\n    ") + "\nPAPX's grpprl: " + Arrays.toString(this._grpprlPapx) + "\nCHPX's grpprl: " + Arrays.toString(this._grpprlChpx) + "\nxst: " + this._xst + "\n";
    }
}
