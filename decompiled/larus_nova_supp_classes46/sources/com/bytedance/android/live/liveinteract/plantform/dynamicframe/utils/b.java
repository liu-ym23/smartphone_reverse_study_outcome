package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements o60.e {
    public final /* synthetic */ a a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Bitmap c;
    public final /* synthetic */ ih0.h d;

    public final void onPermissionDenied(String... r4) {
        Intrinsics.checkNotNullParameter(r4, "permissions");
        this.d.a(UpdateLinkmicStatusResultModel.Code.Failed, this.b.getResources().getString(2131922317), null);
    }

    public final void onPermissionGrant(String... r4) {
        Intrinsics.checkNotNullParameter(r4, "permissions");
        a.a(this.a, this.b, this.c, this.d);
    }

    public b(a r1, Context r2, Bitmap r3, com.bytedance.android.live.liveinteract.jsbridge.method.j r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
