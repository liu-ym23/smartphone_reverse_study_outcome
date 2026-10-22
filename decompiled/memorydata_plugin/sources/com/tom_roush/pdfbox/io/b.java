package com.tom_roush.pdfbox.io;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16114b;
    private final long c;
    private final long d;
    private File e;

    private b(boolean r7, boolean r8, long r9, long r11) {
        boolean r0 = false;
        if (r8 == false) goto L7;
        if (r7 == true) goto L7;
        boolean r1 = false;
    L9:
        if (r7 == true) goto L13;
        r9 = -1;
    L13:
        if (r11 > 0) goto L17;
        r11 = -1;
    L17:
        if (r9 >= (-1)) goto L19;
        r9 = -1;
    L19:
        if (r1 == true) goto L21;
    L25:
        r0 = r1;
    L26:
        if (r0 == true) goto L28;
    L34:
        this.f16113a = r0;
        this.f16114b = r8;
        this.c = r9;
        this.d = r11;
        return;
    L28:
        if (r11 <= (-1)) goto L34;
        if (r9 != (-1)) goto L32;
    L33:
        r11 = r9;
        goto L34
    L32:
        if (r9 <= r11) goto L34;
    L21:
        if (r9 != 0) goto L25;
        if (r8 == true) goto L26;
        r9 = r11;
    L7:
        r1 = true;
        goto L9
    }

    public static b a() {
        return a(-1);
    }

    public static b a(long r8) {
        return new b(true, false, r8, r8);
    }

    public boolean b() {
        return this.f16113a;
    }

    public boolean c() {
        return this.f16114b;
    }

    public boolean d() {
        if (this.c < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.d <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long f() {
        return this.c;
    }

    public long g() {
        return this.d;
    }

    public File h() {
        return this.e;
    }

    public String toString() {
        if (this.f16113a == false) goto L16;
        if (this.f16114b == false) goto L12;
        StringBuilder r0 = new StringBuilder().append("Mixed mode with max. of ").append(this.c).append(" main memory bytes");
        if (e() == false) goto L9;
        String r4 = " and max. of " + this.d + " storage bytes";
    L10:
        StringBuilder r5 = r0.append(r4);
    L23:
        return r5.toString();
    L9:
        r4 = " and unrestricted scratch file size";
        goto L10
    L12:
        if (d() == false) goto L14;
        StringBuilder r1 = new StringBuilder().append("Main memory only with max. of ");
        long r2 = this.c;
    L18:
        r5 = r1.append(r2).append(" bytes");
        goto L23
    L14:
        return "Main memory only with no size restriction";
    L16:
        if (e() == false) goto L20;
        r1 = new StringBuilder().append("Scratch file only with max. of ");
        r2 = this.d;
        goto L18
    L20:
        return "Scratch file only with no size restriction";
    }
}
