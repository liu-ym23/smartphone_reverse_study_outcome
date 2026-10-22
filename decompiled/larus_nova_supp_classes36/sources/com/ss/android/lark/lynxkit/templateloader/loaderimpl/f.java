package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import com.ss.android.lark.notification.export.AbstractNotification;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public final boolean a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final int f;
    public final int g;
    public final long h;
    public final Map<String, String> i;
    public final boolean j;
    public final boolean k;
    public final List<String> l;
    public final int m;
    public final int n;
    public final boolean o;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (this.d == r9.d) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L27;
        return false;
    L27:
        if (this.f == r9.f) goto L30;
        return false;
    L30:
        if (this.g == r9.g) goto L33;
        return false;
    L33:
        if (this.h == r9.h) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L39;
        return false;
    L39:
        if (this.j == r9.j) goto L42;
        return false;
    L42:
        if (this.k == r9.k) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L48;
        return false;
    L48:
        if (this.m == r9.m) goto L51;
        return false;
    L51:
        if (this.n == r9.n) goto L54;
        return false;
    L54:
        if (this.o == r9.o) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        String r3 = this.b;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) * 31;
        String r6 = this.c;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r5 + r7) * 31) + 0) * 31;
        if (this.d == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((((((r8 + r9) * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g) * 31;
        long r11 = this.h;
        int r12 = (((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + this.i.hashCode()) * 31;
        if (this.j == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        if (this.k == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (((((((r14 + r15) * 31) + this.l.hashCode()) * 31) + this.m) * 31) + this.n) * 31;
        if (this.o == true) goto L31;
        r1 = 1237;
    L31:
        return r16 + r1;
    L25:
        r15 = 1237;
        goto L26
    L21:
        r13 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CdnTemplateLoaderConfig(enabled=" + this.a + ", cdnUrl=" + this.b + ", cdnBaseUrl=" + this.c + ", urlResolver=null, enableDiskCache=" + this.d + ", cacheDirName=" + this.e + ", connectTimeoutMillis=" + this.f + ", readTimeoutMillis=" + this.g + ", maxTemplateBytes=" + this.h + ", requestHeaders=" + this.i + ", cdnNoCache=" + this.j + ", onlyLocal=" + this.k + ", fallbackDomains=" + this.l + ", shuffle=" + this.m + ", loadRetryTimes=" + this.n + ", isDebugPackage=" + this.o + ')';
    }

    public f() {
        Map<String, String> r0 = MapsKt.emptyMap();
        List<String> r1 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter("rl_resource_offline", "cacheDirName");
        Intrinsics.checkNotNullParameter(r0, "requestHeaders");
        Intrinsics.checkNotNullParameter(r1, "fallbackDomains");
        this.a = true;
        this.b = null;
        this.c = null;
        this.d = true;
        this.e = "rl_resource_offline";
        this.f = AbstractNotification.NoticeType.DOCFEED;
        this.g = 30000;
        this.h = 52428800;
        this.i = r0;
        this.j = false;
        this.k = false;
        this.l = r1;
        this.m = 0;
        this.n = 0;
        this.o = false;
    }
}
