package com.bytedance.ai.api;

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
        if (Intrinsics.areEqual(this.q, r11.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = (((((((((((((((r0 + r10) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        int r12 = 1231;
        if (this.j == false) goto L9;
        int r13 = 1231;
    L10:
        int r14 = (r11 + r13) * 31;
        if (this.k == false) goto L13;
        int r15 = 1231;
    L14:
        int r16 = (r14 + r15) * 31;
        if (this.l == false) goto L17;
        int r17 = 1231;
    L18:
        int r18 = (((r16 + r17) * 31) + this.m.hashCode()) * 31;
        if (this.n == false) goto L21;
        int r19 = 1231;
    L22:
        int r20 = (((r18 + r19) * 31) + this.o.hashCode()) * 31;
        if (this.p == true) goto L27;
        r12 = 1237;
    L27:
        return ((r20 + r12) * 31) + this.q.hashCode();
    L21:
        r19 = 1237;
        goto L22
    L17:
        r17 = 1237;
        goto L18
    L13:
        r15 = 1237;
        goto L14
    L9:
        r13 = 1237;
        goto L10
    L5:
        r10 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletAppConfig(application=" + this.a + ", deviceId=" + this.b + ", appName=" + this.c + ", appId=" + this.d + ", appVersion=" + this.e + ", appVersionCode=" + this.f + ", appPackageName=" + this.g + ", appChannel=" + this.h + ", updateVersionCode=" + this.i + ", isOversea=" + this.j + ", isDebug=" + this.k + ", isTestChannel=" + this.l + ", bid=" + this.m + ", boeEnable=" + this.n + ", boeEnv=" + this.o + ", ppeEnable=" + this.p + ", ppeEnv=" + this.q + ')';
    }

    public a(Context r13, String r14, String r15, int r16, String r17, String r18, String r19, String r20, String r21, boolean r22, boolean r23, boolean r24, String r25, boolean r26, String r27, boolean r28, String r29) {
        Intrinsics.checkNotNullParameter(r13, "application");
        Intrinsics.checkNotNullParameter(r15, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r17, "appVersion");
        Intrinsics.checkNotNullParameter(r18, "appVersionCode");
        Intrinsics.checkNotNullParameter(r19, "appPackageName");
        Intrinsics.checkNotNullParameter(r20, "appChannel");
        Intrinsics.checkNotNullParameter(r21, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r25, "bid");
        Intrinsics.checkNotNullParameter(r27, "boeEnv");
        Intrinsics.checkNotNullParameter(r29, "ppeEnv");
        this.a = r13;
        this.b = r14;
        this.c = r15;
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = r21;
        this.j = r22;
        this.k = r23;
        this.l = r24;
        this.m = r25;
        this.n = r26;
        this.o = r27;
        this.p = r28;
        this.q = r29;
    }
}
