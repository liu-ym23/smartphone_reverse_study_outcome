package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileGiftExhibitionBanner;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.config.mg;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x implements com.bytedance.android.live.profile.ui.base.f {
    public x() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return new ComponentType.Exhibition(null, null, 3, null);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r3) {
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        ProfileGiftExhibitionBanner r0 = r3.getTargetUser().getGiftExhibitionBannerData();
        if (r0 == null) goto L9;
        if (r0.isGroupAnchor() != true) goto L9;
        return new y(r3);
    L9:
        return new ProfileGiftExhibitionComponent(r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380814, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r8, com.bytedance.android.live.profile.profilecontext.a r9) {
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r9, "profileContext");
        if (r8.getGiftExhibitionBannerData() != null) goto L5;
        return false;
    L5:
        if (((Boolean) rs0.f0.a.getValue()).booleanValue() == false) goto L15;
        ProfileStyleParams r0 = r8.getProfileStyleParams();
        if (r0 != null) goto L9;
    L10:
        ProfileStyleParams r1 = r8.getProfileStyleParams();
        if (r1 != null) goto L13;
    L23:
        boolean r2 = true;
    L25:
        if (r2 == true) goto L40;
        ProfileStyleParams r10 = r8.getProfileStyleParams();
        if (r10 != null) goto L29;
    L31:
        boolean r12 = false;
    L32:
        if (r12 == true) goto L34;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == true) goto L40;
        return false;
    L34:
        if (r9.isVertical() == true) goto L38;
        if (((Boolean) mg.a.getValue()).booleanValue() == false) goto L38;
        r13 = true;
        goto L39
    L29:
        if (r10.getProfileStyle() != ProfileStyleParams.ECOM) goto L31;
        r12 = true;
    L40:
        Intrinsics.checkNotNullParameter(r9, "$this$targetIsMicOfficialAnchor");
        if (r9.getPageTypeUseCase().b() == true) goto L46;
        return true;
    L46:
        return false;
    L13:
        if (r1.getProfileStyle() != ProfileStyleParams.ECOM) goto L23;
    L24:
        r2 = false;
        goto L25
    L9:
        if (r0.getProfileStyle() == ProfileStyleParams.LOCAL_LIFE) goto L24;
    L15:
        ProfileStyleParams r3 = r8.getProfileStyleParams();
        if (r3 != null) goto L18;
    L19:
        ProfileStyleParams r4 = r8.getProfileStyleParams();
        if (r4 == null) goto L24;
        if (r4.getProfileStyle() != ProfileStyleParams.GROUP_LIVE) goto L24;
    L18:
        if (r3.getProfileStyle() == ProfileStyleParams.HONOUR) goto L23;
        goto L19
    }
}
