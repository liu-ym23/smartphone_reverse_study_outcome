package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import java.math.BigInteger;
import java.util.SimpleTimeZone;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f3574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3575b;
    private final String c;
    private final int d;
    private final int e;
    private int f;

    public b(String r1, String r2) {
        this.f3575b = r1;
        this.c = r2;
        this.d = r1.length();
        this.e = r2.length();
    }

    private void a(char r2) {
        if (e() != r2) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(this.c);
    }

    private static boolean b(char r1) {
        if ('0' <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > '9') goto L7;
        return true;
    }

    private char d() {
        int r0 = this.f3574a;
        if (r0 != this.e) goto L7;
        return CharCompanionObject.MAX_VALUE;
    L7:
        return this.c.charAt(r0);
    }

    private char e() {
        int r0 = this.f3574a;
        if (r0 == this.e) goto L7;
        String r1 = this.c;
        this.f3574a = r0 + 1;
        return r1.charAt(r0);
    L7:
        throw new IllegalArgumentException(this.c);
    }

    public final int a(int r4, int r5) {
        int r0 = this.f3574a;
    L4:
        if (b(d()) == false) goto L8;
        int r1 = this.f3574a;
        if ((r1 - r0) >= r5) goto L8;
        this.f3574a = r1 + 1;
    L8:
        int r6 = this.f3574a;
        if ((r6 - r0) < r4) goto L13;
        return Integer.parseInt(this.c.substring(r0, r6));
    L13:
        throw new IllegalArgumentException(this.c);
    }

    public void a() {
    L2:
        int r0 = this.f;
        if (r0 >= this.d) goto L49;
        String r1 = this.f3575b;
        this.f = r0 + 1;
        char r2 = r1.charAt(r0);
        if (r2 != '%') goto L6;
        String r3 = this.f3575b;
        int r4 = this.f;
        this.f = r4 + 1;
        char r5 = r3.charAt(r4);
        if (r5 != 'D') goto L10;
        d(a(2, 2));
        goto L2
    L10:
        if (r5 != 'M') goto L11;
        e(a(2, 2));
        goto L2
    L11:
        int r6 = -1;
        if (r5 != 'Y') goto L14;
        if (d() != '-') goto L44;
        this.f3574a++;
    L45:
        f(r6 * a(4, Integer.MAX_VALUE));
        goto L2
    L44:
        r6 = 1;
        goto L45
    L14:
        if (r5 != 'h') goto L16;
        c(a(2, 2));
        goto L2
    L16:
        if (r5 != 'm') goto L18;
        b(a(2, 2));
        goto L2
    L18:
        if (r5 != 's') goto L20;
        a(a(2, 2));
        if (d() != '.') goto L2;
        this.f3574a++;
        c();
        goto L2
    L20:
        if (r5 != 'z') goto L35;
        char r7 = d();
        if (r7 == 'Z') goto L23;
        if (r7 == '+') goto L30;
        if (r7 == '-') goto L30;
        java.util.TimeZone r8 = TimeZone.MISSING;
    L24:
        a(r8);
    L30:
        this.f3574a++;
        int r9 = a(2, 2);
        a(':');
        int r10 = (r9 * 60) + a(2, 2);
        if (r7 != '+') goto L33;
        r6 = 1;
    L33:
        a(new SimpleTimeZone(((r10 * r6) * 60) * 1000, ""));
        goto L2
    L23:
        this.f3574a++;
        r8 = TimeZone.ZERO;
        goto L24
    L35:
        throw new InternalError();
    L6:
        a(r2);
        goto L2
    L49:
        if (this.f3574a != this.e) goto L52;
        return;
    L52:
        throw new IllegalArgumentException(this.c);
    }

    public abstract void a(int r1);

    public abstract void a(java.util.TimeZone r1);

    public final BigInteger b(int r4, int r5) {
        int r0 = this.f3574a;
    L4:
        if (b(d()) == false) goto L9;
        int r1 = this.f3574a;
        if ((r1 - r0) > r5) goto L9;
        this.f3574a = r1 + 1;
    L9:
        if ((this.f3574a - r0) < r4) goto L13;
        return new BigInteger(this.c.substring(r0, this.f3574a));
    L13:
        throw new IllegalArgumentException(this.c);
    }

    public final void b() {
    L3:
        if (b(d()) == false) goto L5;
        this.f3574a++;
        goto L3
    }

    public abstract void b(int r1);

    public abstract void c();

    public abstract void c(int r1);

    public abstract void d(int r1);

    public abstract void e(int r1);

    public abstract void f(int r1);
}
