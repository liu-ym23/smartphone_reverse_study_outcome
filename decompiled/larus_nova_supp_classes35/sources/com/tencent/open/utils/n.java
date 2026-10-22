package com.tencent.open.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements Cloneable {
    private long a;

    public byte[] a() {
        long r1 = this.a;
        return new byte[]{(byte) (255 & r1), (byte) ((65280 & r1) >> 8), (byte) ((16711680 & r1) >> 16), (byte) ((r1 & 4278190080L) >> 24)};
    }

    public int hashCode() {
        return (int) this.a;
    }

    public long b() {
        return this.a;
    }

    public n(long r1) {
        this.a = r1;
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if ((r6 instanceof n) == true) goto L8;
        return false;
    L8:
        if (this.a != ((n) r6).b()) goto L12;
        return true;
    L12:
        return false;
    }
}
