package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m4 {
    public final boolean a;
    public final List<String> b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final c q;
    public final o3 r;

    public m4() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m4) == true) goto L8;
        return false;
    L8:
        m4 r6 = (m4) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        List<String> r3 = this.b;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.c == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.d == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.e == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.f == false) goto L25;
        int r12 = 1231;
    L26:
        int r13 = (r11 + r12) * 31;
        if (this.g == false) goto L29;
        int r14 = 1231;
    L30:
        int r15 = (r13 + r14) * 31;
        if (this.h == false) goto L33;
        int r16 = 1231;
    L34:
        int r17 = (r15 + r16) * 31;
        if (this.i == false) goto L37;
        int r18 = 1231;
    L38:
        int r19 = (r17 + r18) * 31;
        if (this.j == false) goto L41;
        int r20 = 1231;
    L42:
        int r21 = (r19 + r20) * 31;
        if (this.k == false) goto L45;
        int r22 = 1231;
    L46:
        int r23 = (r21 + r22) * 31;
        if (this.l == false) goto L49;
        int r24 = 1231;
    L50:
        int r25 = (r23 + r24) * 31;
        if (this.m == false) goto L53;
        int r26 = 1231;
    L54:
        int r27 = (r25 + r26) * 31;
        if (this.n == false) goto L57;
        int r28 = 1231;
    L58:
        int r29 = (r27 + r28) * 31;
        if (this.o == false) goto L61;
        int r30 = 1231;
    L62:
        int r31 = (r29 + r30) * 31;
        if (this.p == true) goto L67;
        r1 = 1237;
    L67:
        return ((((r31 + r1) * 31) + this.q.hashCode()) * 31) + this.r.hashCode();
    L61:
        r30 = 1237;
        goto L62
    L57:
        r28 = 1237;
        goto L58
    L53:
        r26 = 1237;
        goto L54
    L49:
        r24 = 1237;
        goto L50
    L45:
        r22 = 1237;
        goto L46
    L41:
        r20 = 1237;
        goto L42
    L37:
        r18 = 1237;
        goto L38
    L33:
        r16 = 1237;
        goto L34
    L29:
        r14 = 1237;
        goto L30
    L25:
        r12 = 1237;
        goto L26
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SettingOptionConfig(enableOptionWhiteList=" + this.a + ", optionWhiteList=" + this.b + ", forceNewStyle=" + this.c + ", enableEditItem=" + this.d + ", enableIconEdit=" + this.e + ", enableSetBotLanguage=" + this.f + ", enableShareBot=" + this.g + ", enableTheme=" + this.h + ", enableFeedback=" + this.i + ", enableAboutApp=" + this.j + ", enableAccountSetting=" + this.k + ", enableLogout=" + this.l + ", enablePrivacyPermission=" + this.m + ", enableNotifySettings=" + this.n + ", enableRelatedVideo=" + this.o + ", enableBindAccount=" + this.p + ", aboutAppDisplayConfig=" + this.q + ", officeTaskSettingsDisplayConfig=" + this.r + ')';
    }

    public m4(Object r4) {
        c r5 = new c(null);
        o3 r1 = new o3(null);
        Intrinsics.checkNotNullParameter(r5, "aboutAppDisplayConfig");
        Intrinsics.checkNotNullParameter(r1, "officeTaskSettingsDisplayConfig");
        this.a = true;
        this.b = null;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.p = false;
        this.q = r5;
        this.r = r1;
    }
}
