package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.config.mg;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements com.bytedance.android.live.profile.ui.base.f {
    public t() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.FansClubVip.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new p(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380807, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r8, com.bytedance.android.live.profile.profilecontext.a r9) {
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r9, "profileContext");
        if (((Boolean) rs0.f0.a.getValue()).booleanValue() == false) goto L13;
        ProfileStyleParams r0 = r8.getProfileStyleParams();
        if (r0 != null) goto L7;
    L8:
        ProfileStyleParams r1 = r8.getProfileStyleParams();
        if (r1 != null) goto L11;
    L21:
        boolean r2 = true;
    L23:
        if (r2 == true) goto L39;
        ProfileStyleParams r3 = r8.getProfileStyleParams();
        if (r3 != null) goto L27;
    L29:
        boolean r4 = false;
    L30:
        if (r4 == true) goto L32;
    L36:
        boolean r5 = false;
    L37:
        if (r5 == true) goto L39;
        return false;
    L32:
        if (r9.isVertical() == true) goto L36;
        if (((Boolean) mg.a.getValue()).booleanValue() == false) goto L36;
        r5 = true;
        goto L37
    L27:
        if (r3.getProfileStyle() != ProfileStyleParams.ECOM) goto L29;
        r4 = true;
    L39:
        if (r8.useStandardHonorWallV3() == true) goto L41;
        return false;
    L41:
        if (((ss0.c) rs0.y.a.getValue()).a() == false) goto L62;
        ProfileOpenArea r10 = r8.openArea;
        if (r10 == null) goto L47;
        ProfileBusinessArea r12 = r10.businessAreaV3;
        if (r12 == null) goto L47;
        List r13 = r12.topElementList;
    L48:
        List r14 = r13;
        if (r14 != null) goto L51;
    L54:
        boolean r15 = true;
    L55:
        if (r15 == true) goto L63;
        Intrinsics.checkNotNullParameter(r9, "$this$targetIsMicOfficialAnchor");
        if (r9.getPageTypeUseCase().b() == true) goto L64;
        return true;
    L64:
        return false;
    L63:
        return false;
    L51:
        if (r14.isEmpty() == true) goto L54;
        r15 = false;
    L47:
        r13 = null;
        goto L48
    L62:
        return false;
    L11:
        if (r1.getProfileStyle() != ProfileStyleParams.ECOM) goto L21;
    L22:
        r2 = false;
        goto L23
    L7:
        if (r0.getProfileStyle() == ProfileStyleParams.LOCAL_LIFE) goto L22;
    L13:
        ProfileStyleParams r6 = r8.getProfileStyleParams();
        if (r6 != null) goto L16;
    L17:
        ProfileStyleParams r7 = r8.getProfileStyleParams();
        if (r7 == null) goto L22;
        if (r7.getProfileStyle() != ProfileStyleParams.GROUP_LIVE) goto L22;
    L16:
        if (r6.getProfileStyle() == ProfileStyleParams.HONOUR) goto L21;
        goto L17
    }
}
