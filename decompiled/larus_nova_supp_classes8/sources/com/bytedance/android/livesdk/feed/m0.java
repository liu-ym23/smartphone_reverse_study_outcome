package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.ILivePermissionCallback;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 implements ILoginCallback {
    public final /* synthetic */ LiveDrawerFeedPageFragment a;

    public static final class a implements ILivePermissionCallback {
        public final /* synthetic */ m0 a;

        public a(m0 r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.a2;
            Boolean r0 = Boolean.FALSE;
            r3.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r3, r0);
            this.a.a.DP();
        }

        public final void onSuccess(boolean r2) {
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.a2;
            Boolean r3 = Boolean.valueOf(r2);
            r0.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
            this.a.a.DP();
        }
    }

    public final void onCancel(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
    }

    public m0(LiveDrawerFeedPageFragment r1) {
        this.a = r1;
    }

    public final void onSuccess(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        TTLiveSDK.hostService().user().requestLivePermission(new a(this));
    }
}
