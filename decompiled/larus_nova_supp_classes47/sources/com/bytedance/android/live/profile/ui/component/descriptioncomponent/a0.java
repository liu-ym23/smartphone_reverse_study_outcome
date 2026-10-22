package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 implements com.bytedance.android.live.profile.ui.base.f {
    public a0() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.GroupLiveMember.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new z(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131374526, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r2, com.bytedance.android.live.profile.profilecontext.a r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        if (com.bytedance.android.live.profile.ui.base.i.l(r3) == true) goto L5;
        return false;
    L5:
        ProfileOpenArea r4 = r2.openArea;
        if (r4 == null) goto L18;
        ProfileBusinessArea r5 = r4.businessAreaV3;
        if (r5 == null) goto L19;
        com.bytedance.android.live.base.model.user.h r6 = r5.groupLiveBanner;
        if (r6 == null) goto L20;
        List r7 = r6.a();
        if (r7 == null) goto L14;
        int r8 = r7.size();
    L15:
        if (r8 <= 0) goto L21;
        return true;
    L21:
        return false;
    L14:
        r8 = 0;
        goto L15
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    }
}
