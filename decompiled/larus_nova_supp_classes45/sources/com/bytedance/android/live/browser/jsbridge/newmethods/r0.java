package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r0 implements o60.e {
    public final /* synthetic */ q0 a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ List c;

    @Override // o60.e
    public final void onPermissionDenied(String... r6) {
        Intrinsics.checkNotNullParameter(r6, "permissions");
        this.b.b("H5_authorizationChange", MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("type", this.c.toString()), TuplesKt.to("isAuthorization", Boolean.FALSE)}));
        q0 r7 = this.a;
        r7.getClass();
        r7.finishWithResult(q0.j(false));
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "permissions");
        this.b.b("H5_authorizationChange", MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("type", this.c.toString()), TuplesKt.to("isAuthorization", Boolean.TRUE)}));
        q0 r6 = this.a;
        r6.getClass();
        r6.finishWithResult(q0.j(true));
    }

    public r0(q0 r1, CallContext r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
