package com.larus.platform.model.chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final boolean a;
    public final long b;
    public final boolean c;

    public c() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r3 = this.b;
        int r2 = ((r0 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BDImageXUploadOptConfig(enable=" + this.a + ", sdkTimeout=" + this.b + ", enableLogPrint=" + this.c + ')';
    }

    public /* synthetic */ c(int r3) {
        this(false, 60000, false);
    }

    public c(boolean r1, long r2, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
