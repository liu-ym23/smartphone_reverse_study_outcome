package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 implements com.bytedance.android.live.profile.ui.base.f {
    public d0() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.MultiLinkPermanentRoom.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new b0(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380434, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r4, com.bytedance.android.live.profile.profilecontext.a r5) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        ProfileOpenArea r6 = r4.openArea;
        IBaseUser r7 = null;
        if (r6 == null) goto L7;
        ProfileBusinessArea r8 = r6.businessAreaV3;
        if (r8 == null) goto L7;
        com.bytedance.android.live.base.model.user.i0 r9 = r8.residentGuestBanner;
    L8:
        if (r9 == null) goto L10;
        List r0 = r9.a();
    L11:
        List r1 = r0;
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        boolean r3 = !r2;
        if (r9 == null) goto L21;
        r7 = r9.b();
    L21:
        if (r7 == null) goto L23;
        boolean r10 = true;
    L24:
        if (r9 == null) goto L29;
        if (r3 == true) goto L27;
        if (r10 == true) goto L27;
        return false;
    L27:
        return true;
    L29:
        return false;
    L23:
        r10 = false;
        goto L24
    L14:
        if (r1.isEmpty() == true) goto L17;
        r2 = false;
        goto L18
    L10:
        r0 = null;
    L7:
        r9 = null;
        goto L8
    }
}
