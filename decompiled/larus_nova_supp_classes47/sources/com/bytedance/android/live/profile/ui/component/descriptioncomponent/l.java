package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements com.bytedance.android.live.profile.ui.base.f {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static boolean a(com.bytedance.android.live.profile.profilecontext.a r1) {
            Intrinsics.checkNotNullParameter(r1, "profileContext");
            com.bytedance.android.live.profit.player.d r0 = yt0.c.h();
            if (r0 == null) goto L5;
            uu0.b r2 = r0.Me();
        L6:
            if (r2 != null) goto L8;
        L10:
            return false;
        L8:
            if (com.bytedance.android.live.profile.ui.base.i.m(r1) == true) goto L10;
            return true;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public l() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType.CommentComponent> c() {
        return CollectionsKt.listOf(ComponentType.CommentComponent.INSTANCE);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return new ComponentType.DressSuspension(null, null, 3, null);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        com.bytedance.android.live.profit.player.d r0 = yt0.c.h();
        if (r0 == null) goto L5;
        uu0.b r1 = r0.Me();
    L6:
        if (r1 == null) goto L9;
        return new i(r2);
    L9:
        return new k(r2);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380787, 2131380789, 4);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r2, com.bytedance.android.live.profile.profilecontext.a r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        if (a.a(r3) == true) goto L12;
        ProfileSkin r4 = r2.mProfileSkin;
        if (r4 == null) goto L10;
        ProfileCustomSkin r5 = r4.skin;
        if (r5 == null) goto L10;
        ProfileCustomSkin.SuitShopEnterButton r6 = r5.suitShopEnterButton;
    L11:
        if (r6 != null) goto L12;
        return false;
    L10:
        r6 = null;
    L12:
        return true;
    }
}
