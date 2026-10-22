package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.util.DressType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements com.bytedance.android.live.profile.ui.base.f {
    public o() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.ExitEffect.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new n(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380806, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r2, com.bytedance.android.live.profile.profilecontext.a r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        int r4 = com.bytedance.android.live.profile.ui.util.t.a;
        if (((ss0.a) rs0.b0.a.getValue()).i() == true) goto L5;
    L11:
        return false;
    L5:
        if (r3.getDressImageModelWithFallback(DressType.PanelExitWebp) == null) goto L11;
        if (r3.isVertical() == false) goto L11;
        if (r3.isPad() == true) goto L11;
        return true;
    }
}
