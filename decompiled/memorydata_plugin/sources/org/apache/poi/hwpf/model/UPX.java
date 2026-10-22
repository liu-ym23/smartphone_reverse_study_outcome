package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class UPX {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private byte[] _upx;

    static {
    }

    public UPX(byte[] r1) {
        this._upx = r1;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, UPX.class) == true) goto L6;
        return false;
    L6:
        UPX r4 = (UPX) ZeusTransformUtils.preCheckCast(r3, UPX.class, "com.obric.memorydata.plugin");
        return Arrays.equals(this._upx, r4._upx);
    }

    public byte[] getUPX() {
        return this._upx;
    }

    public int hashCode() {
        return 42;
    }

    public String toString() {
        return "[UPX] " + Arrays.toString(this._upx);
    }
}
