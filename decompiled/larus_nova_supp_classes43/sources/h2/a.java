package h2;

import android.content.Context;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Context a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final boolean n;
    public final String o;
    public final boolean p;
    public final String q;
    public final String r;
    public final Integer s;
    public final int t;
    public final String u;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
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
        if (this.j == r11.j) goto L39;
        return false;
    L39:
        if (this.k == r11.k) goto L42;
        return false;
    L42:
        if (this.l == r11.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r11.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r11.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r11.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r11.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r11.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r11.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r11.t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r11.u) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (((((((((((((((r0 + r11) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        int r13 = 1231;
        if (this.j == false) goto L9;
        int r14 = 1231;
    L10:
        int r15 = (r12 + r14) * 31;
        if (this.k == false) goto L13;
        int r16 = 1231;
    L14:
        int r17 = (r15 + r16) * 31;
        if (this.l == false) goto L17;
        int r18 = 1231;
    L18:
        int r19 = (((r17 + r18) * 31) + this.m.hashCode()) * 31;
        if (this.n == false) goto L21;
        int r20 = 1231;
    L22:
        int r21 = (((r19 + r20) * 31) + this.o.hashCode()) * 31;
        if (this.p == true) goto L26;
        r13 = 1237;
    L26:
        int r22 = (((((r21 + r13) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31;
        Integer r23 = this.s;
        if (r23 == null) goto L31;
        r10 = r23.hashCode();
    L31:
        return ((((r22 + r10) * 31) + this.t) * 31) + this.u.hashCode();
    L21:
        r20 = 1237;
        goto L22
    L17:
        r18 = 1237;
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
        return "AISDKConfig(application=" + this.a + ", deviceId=" + this.b + ", appName=" + this.c + ", appId=" + this.d + ", appVersion=" + this.e + ", appVersionCode=" + this.f + ", appPackageName=" + this.g + ", appChannel=" + this.h + ", updateVersionCode=" + this.i + ", isOversea=" + this.j + ", isDebug=" + this.k + ", isTestChannel=" + this.l + ", bid=" + this.m + ", boeEnable=" + this.n + ", boeEnv=" + this.o + ", ppeEnable=" + this.p + ", ppeEnv=" + this.q + ", language=" + this.r + ", fontSizeInPx=" + this.s + ", textZoom=" + this.t + ", settingsHost=" + this.u + ')';
    }

    public a(Context r15, String r16, String r17, int r18, String r19, String r20, String r21, String r22, String r23, boolean r24, boolean r25, boolean r26, String r27, boolean r28, String r29, boolean r30, String r31, String r32, Integer r33, int r34, String r35) {
        Intrinsics.checkNotNullParameter(r15, "application");
        Intrinsics.checkNotNullParameter(r17, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r19, "appVersion");
        Intrinsics.checkNotNullParameter(r20, "appVersionCode");
        Intrinsics.checkNotNullParameter(r21, "appPackageName");
        Intrinsics.checkNotNullParameter(r22, "appChannel");
        Intrinsics.checkNotNullParameter(r23, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r27, "bid");
        Intrinsics.checkNotNullParameter(r29, "boeEnv");
        Intrinsics.checkNotNullParameter(r31, "ppeEnv");
        Intrinsics.checkNotNullParameter(r32, "language");
        Intrinsics.checkNotNullParameter(r35, "settingsHost");
        this.a = r15;
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r22;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        this.l = r26;
        this.m = r27;
        this.n = r28;
        this.o = r29;
        this.p = r30;
        this.q = r31;
        this.r = r32;
        this.s = r33;
        this.t = r34;
        this.u = r35;
    }
}
