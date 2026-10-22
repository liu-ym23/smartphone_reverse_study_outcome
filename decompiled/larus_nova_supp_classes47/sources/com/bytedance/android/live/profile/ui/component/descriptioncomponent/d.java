package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements com.bytedance.android.live.profile.ui.base.f {
    public d() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.AnchorImageEntry.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new c(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380759, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r4, com.bytedance.android.live.profile.profilecontext.a r5) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        int r0 = l.a;
        boolean r1 = l.a.a(r5);
        boolean r6 = r5.isVertical();
        if (r4.liveAgentInfo == null) goto L5;
        boolean r7 = true;
    L6:
        if (r1 == true) goto L11;
        if (r6 == false) goto L12;
        if (r7 == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L11:
        return false;
    L5:
        r7 = false;
        goto L6
    }
}
