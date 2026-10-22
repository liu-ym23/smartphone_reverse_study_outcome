package k2;

import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements com.bytedance.assem.arch.extensions.a {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Callable<String> i;
    public final Callable<List<String>> j;
    public final List<String> k;
    public final boolean l;
    public final boolean m;
    public j n;
    public KClass<?> o;
    public boolean p;
    public final boolean q;
    public final boolean r;

    public b() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r11.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r11.l) goto L45;
        return false;
    L45:
        if (this.m == r11.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r11.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r11.p) goto L57;
        return false;
    L57:
        if (this.q == r11.q) goto L60;
        return false;
    L60:
        if (this.r == r11.r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        int r13 = 1231;
        if (this.c == false) goto L9;
        int r14 = 1231;
    L10:
        int r15 = (r12 + r14) * 31;
        if (this.d == false) goto L13;
        int r16 = 1231;
    L14:
        int r17 = (((((((((r15 + r16) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        Callable<String> r18 = this.i;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        Callable<List<String>> r21 = this.j;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (((r20 + r22) * 31) + this.k.hashCode()) * 31;
        if (this.l == false) goto L25;
        int r24 = 1231;
    L26:
        int r25 = (r23 + r24) * 31;
        if (this.m == false) goto L29;
        int r26 = 1231;
    L30:
        int r27 = (r25 + r26) * 31;
        j r28 = this.n;
        if (r28 != null) goto L33;
        int r29 = 0;
    L34:
        int r30 = (r27 + r29) * 31;
        KClass<?> r31 = this.o;
        if (r31 == null) goto L38;
        r10 = r31.hashCode();
    L38:
        int r32 = (r30 + r10) * 31;
        if (this.p == false) goto L41;
        int r33 = 1231;
    L42:
        int r34 = (r32 + r33) * 31;
        if (this.q == false) goto L45;
        int r35 = 1231;
    L46:
        int r36 = (r34 + r35) * 31;
        if (this.r == true) goto L51;
        r13 = 1237;
    L51:
        return r36 + r13;
    L45:
        r35 = 1237;
        goto L46
    L41:
        r33 = 1237;
        goto L42
    L33:
        r29 = r28.hashCode();
        goto L34
    L29:
        r26 = 1237;
        goto L30
    L25:
        r24 = 1237;
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = 1237;
        goto L14
    L9:
        r14 = 1237;
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIViewRenderData(schema=" + this.a + ", url=" + this.b + ", boeEnable=" + this.c + ", ppeEnable=" + this.d + ", boeEnv=" + this.e + ", ppeEnv=" + this.f + ", boeHost=" + this.g + ", onlineHost=" + this.h + ", xTTToken=" + this.i + ", websiteHostWhiteList=" + this.j + ", webWhiteList=" + this.k + ", disableBounce=" + this.l + ", useRelax=" + this.m + ", aiContainer=" + this.n + ", renderClass=" + this.o + ", isPopup=" + this.p + ", acceptPermissionRequest=" + this.q + ", openHttpBySystem=" + this.r + ')';
    }

    public b(String r10, String r11, boolean r12, boolean r13, String r14, String r15, String r16, String r17, Callable r18, Callable r19, List r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r14, "boeEnv");
        Intrinsics.checkNotNullParameter(r15, "ppeEnv");
        Intrinsics.checkNotNullParameter(r16, "boeHost");
        Intrinsics.checkNotNullParameter(r17, "onlineHost");
        Intrinsics.checkNotNullParameter(r110, "webWhiteList");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = false;
        this.q = false;
        this.r = false;
    }
}
