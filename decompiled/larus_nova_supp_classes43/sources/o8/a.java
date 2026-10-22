package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public final String f;
    public final boolean g;
    public final String h;
    public final String i;
    public boolean j;
    public boolean k;

    public a() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r11.j) goto L39;
        return false;
    L39:
        if (this.k == r11.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.c;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.d;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.e;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.f;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        int r25 = 1231;
        if (this.g == false) goto L25;
        int r26 = 1231;
    L26:
        int r27 = (r24 + r26) * 31;
        String r28 = this.h;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        String r31 = this.i;
        if (r31 == null) goto L34;
        r10 = r31.hashCode();
    L34:
        int r32 = (r30 + r10) * 31;
        if (this.j == false) goto L37;
        int r33 = 1231;
    L38:
        int r34 = (r32 + r33) * 31;
        if (this.k == true) goto L43;
        r25 = 1237;
    L43:
        return r34 + r25;
    L37:
        r33 = 1237;
        goto L38
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = 1237;
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppInfo(appId=" + this.a + ", appName=" + this.b + ", versionCode=" + this.c + ", versionName=" + this.d + ", channel=" + this.e + ", language=" + this.f + ", isTeenMode=" + this.g + ", appTheme=" + this.h + ", updateVersionCode=" + this.i + ", isVsFullScreen=" + this.j + ", isDouyinLightMode=" + this.k + ')';
    }

    public a(int r10) {
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
    }
}
