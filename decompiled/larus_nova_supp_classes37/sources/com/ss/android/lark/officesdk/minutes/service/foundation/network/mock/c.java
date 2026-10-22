package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final gvb.a a;
    public final String b;
    public final MmHttpMethod c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmMockHttpRequestContext(request=" + this.a + ", path=" + this.b + ", method=" + this.c + ", query=" + this.d + ", body=" + this.e + ", rawBody=" + this.f + ')';
    }

    public c(gvb.a r2, String r3, MmHttpMethod r4, Map<String, String> r5, Map<String, String> r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        Intrinsics.checkNotNullParameter(r4, "method");
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
        Intrinsics.checkNotNullParameter(r6, "body");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
