package com.tencent.open.utils;

import com.ss.ttvideoengine.utils.ScreenUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements Cloneable {
    private int a;

    public byte[] a() {
        int r1 = this.a;
        return new byte[]{(byte) (r1 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS), (byte) ((r1 & 65280) >> 8)};
    }

    public int b() {
        return this.a;
    }

    public int hashCode() {
        return this.a;
    }

    public o(int r1) {
        this.a = r1;
    }

    public boolean equals(Object r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if ((r3 instanceof o) == true) goto L8;
        return false;
    L8:
        if (this.a != ((o) r3).b()) goto L12;
        return true;
    L12:
        return false;
    }

    public o(byte[] r2) {
        this(r2, 0);
    }

    public o(byte[] r3, int r4) {
        this.a = ((r3[r4 + 1] << 8) & 65280) + (r3[r4] & 255);
    }
}
