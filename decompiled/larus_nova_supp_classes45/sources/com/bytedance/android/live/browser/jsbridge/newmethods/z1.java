package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z1 implements o60.e {
    public final /* synthetic */ a2 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ b2 c;

    @Override // o60.e
    public final void onPermissionDenied(String... r4) {
        Intrinsics.checkNotNullParameter(r4, "permissions");
        a2 r5 = this.a;
        r5.getClass();
        ClipScreenResultModel r0 = a2.j(false);
        ClipScreenResultModel.a r1 = r0.a();
        if (r1 == null) goto L5;
        r1.b(2);
    L5:
        Unit r2 = Unit.INSTANCE;
        r5.finishWithResult(r0);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r3) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        this.a.k(this.b, this.c);
    }

    public z1(a2 r1, Context r2, b2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
