package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements com.bytedance.android.live.profile.ui.base.f {
    public i() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.TabsComponent.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new ProfileTabsComponent(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380852, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r2, com.bytedance.android.live.profile.profilecontext.a r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        return r3.isMyLive();
    }
}
