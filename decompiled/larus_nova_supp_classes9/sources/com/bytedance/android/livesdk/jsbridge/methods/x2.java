package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x2 implements o60.e {
    public final /* synthetic */ w2.a a;
    public final /* synthetic */ Context b;

    public final void onPermissionDenied(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L7:
        this.a.a();
        return;
    L5:
        if (m60.c.d(this.b, new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}) == false) goto L7;
        this.a.b();
    }

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.a.b();
    }

    public x2(a3 r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
