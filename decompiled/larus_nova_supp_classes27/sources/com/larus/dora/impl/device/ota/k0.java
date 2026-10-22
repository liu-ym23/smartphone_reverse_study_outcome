package com.larus.dora.impl.device.ota;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k0 {
    public String a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public l0 f;
    public String g;
    public long h;

    public k0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r9 = (k0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r1 = this.h;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "OtaEvent(udid=" + this.a + ", event=" + this.b + ", model=" + this.c + ", osVersion=" + this.d + ", product=" + this.e + ", property=" + this.f + ", traceId=" + this.g + ", timestamp=" + this.h + ')';
    }

    public k0(int r4) {
        l0 r5 = new l0(0);
        Intrinsics.checkNotNullParameter("", "udid");
        Intrinsics.checkNotNullParameter("ota_progress", "event");
        Intrinsics.checkNotNullParameter("", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter("", "osVersion");
        Intrinsics.checkNotNullParameter("", "product");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter("", "traceId");
        this.a = "";
        this.b = "ota_progress";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = r5;
        this.g = "";
        this.h = 0;
    }
}
