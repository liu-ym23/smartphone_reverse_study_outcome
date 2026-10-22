package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.profile.ui.base.f {
    public b() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.AnchorHomeland.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new a(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131383188, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r4, com.bytedance.android.live.profile.profilecontext.a r5) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        ProfileOpenArea r6 = r4.openArea;
        if (r6 == null) goto L23;
        ProfileBusinessArea r7 = r6.businessAreaV3;
        if (r7 == null) goto L24;
        com.bytedance.android.live.base.model.user.b r8 = r7.anchorHomelandBanner;
        if (r8 != null) goto L10;
        return false;
    L10:
        if (r8.c().length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        if (r8.b().length() <= 0) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L20;
        return false;
    L20:
        if (r5.isVertical() == false) goto L27;
        return true;
    L27:
        return false;
    L17:
        r9 = false;
        goto L18
    L12:
        r1 = false;
        goto L13
    L24:
        return false;
    L23:
        return false;
    }
}
