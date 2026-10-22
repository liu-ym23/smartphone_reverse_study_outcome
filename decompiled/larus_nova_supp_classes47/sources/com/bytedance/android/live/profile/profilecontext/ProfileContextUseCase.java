package com.bytedance.android.live.profile.profilecontext;

import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.model.LifecycleStateType;
import com.bytedance.android.live.profit.dress.config.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileContextUseCase {
    public final Map<String, x> a;
    public final PropertyOwner<com.bytedance.android.live.profile.model.a> b;
    public final PropertyOwner<com.bytedance.android.live.profile.model.b> c;
    public final com.bytedance.android.live.profile.usecase.a d;

    public final x a() {
        ProfileSkin r0 = this.d.getTargetUser().mProfileSkin;
        x r1 = null;
        if (r0 == null) goto L19;
        ProfileCustomSkin r2 = r0.skin;
        if (r2 == null) goto L19;
        String r3 = r2.dressId;
        if (r3 == null) goto L19;
        if (((LinkedHashMap) this.a).get(r3) != null) goto L18;
        Map<String, x> r4 = this.a;
        zt0.d r5 = yt0.c.b();
        if (r5 == null) goto L16;
        zt0.c r6 = r5.d2();
        if (r6 == null) goto L16;
        r1 = (x) r6.a(r3, Reflection.getOrCreateKotlinClass(x.class));
    L16:
        r4.put(r3, r1);
    L18:
        return (x) ((LinkedHashMap) this.a).get(r3);
    L19:
        return null;
    }

    public ProfileContextUseCase(com.bytedance.android.live.profile.usecase.a r3) {
        Intrinsics.checkNotNullParameter(r3, "profileViewModel");
        this.d = r3;
        this.a = new LinkedHashMap();
        this.b = new PropertyOwner(new com.bytedance.android.live.profile.model.a(EnterExitStateType.INIT), ProfileContextUseCase$enterExitState$1.INSTANCE);
        this.c = new PropertyOwner(new com.bytedance.android.live.profile.model.b(LifecycleStateType.INIT), ProfileContextUseCase$lifecycleState$1.INSTANCE);
    }
}
