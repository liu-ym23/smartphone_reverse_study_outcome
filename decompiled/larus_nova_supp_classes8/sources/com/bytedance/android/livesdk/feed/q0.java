package com.bytedance.android.livesdk.feed;

import com.bytedance.android.livehostapi.platform.depend.user.ILivePermissionCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q0 implements ILivePermissionCallback {
    public final /* synthetic */ LiveDrawerFeedPageFragment a;

    public q0(LiveDrawerFeedPageFragment r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.a2;
        Boolean r0 = Boolean.FALSE;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r0);
    }

    public final void onSuccess(boolean r3) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.a2;
        Boolean r1 = Boolean.valueOf(r3);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        this.a.DP();
        if (r3 == false) goto L6;
        com.bytedance.android.livesdk.log.u.l().a(0);
        return;
    }
}
