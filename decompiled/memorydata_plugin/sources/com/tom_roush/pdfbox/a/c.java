package com.tom_roush.pdfbox.a;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f16045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f16046b = null;
    public static final c c = null;
    public static final c d = null;
    private final boolean e;

    static {
        f16045a = new byte[]{116, 114, 117, 101};
        f16046b = new byte[]{102, 97, 108, 115, 101};
        c = new c(true);
        d = new c(false);
    }

    private c(boolean r1) {
        this.e = r1;
    }

    public static c b(boolean r0) {
        if (r0 == false) goto L5;
        return c;
    L5:
        return d;
    }

    public boolean a() {
        return this.e;
    }

    public String toString() {
        return String.valueOf(this.e);
    }
}
