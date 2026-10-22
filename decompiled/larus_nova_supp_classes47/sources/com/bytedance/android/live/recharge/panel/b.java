package com.bytedance.android.live.recharge.panel;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final RechargeBizScene a(com.bytedance.android.live.recharge.model.d r1) {
        Intrinsics.checkNotNullParameter(r1, "entranceParams");
        NoPasswordScene r2 = com.bytedance.android.live.recharge.core.f.g(RechargeServices.b()).B1(r1);
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L13;
        if (r3 == 3) goto L13;
        return RechargeBizScene.SCENE_NORMAL;
    L13:
        return RechargeBizScene.SCENE_FANS_NOPASSWORD;
    L11:
        return RechargeBizScene.SCENE_PK_NOPASSWORD;
    }
}
