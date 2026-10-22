package nt0;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.base.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.live.profile.ui.base.b {
    public c() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final List<ComponentType> c() {
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.b, com.bytedance.android.live.profile.ui.base.f
    public final ComponentType getComponentType() {
        return ComponentType.LocalLifeGroupShop.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.b, com.bytedance.android.live.profile.ui.base.f
    public final a a(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        return new a(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final com.bytedance.android.live.profile.ui.base.c b(com.bytedance.android.live.profile.profilecontext.a r4) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return new com.bytedance.android.live.profile.ui.base.c(2131380761, 0, 6);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final /* bridge */ /* synthetic */ g a(com.bytedance.android.live.profile.profilecontext.a r1) {
        return a(r1);
    }

    @Override // com.bytedance.android.live.profile.ui.base.f
    public final boolean d(NewProfileUser r4, com.bytedance.android.live.profile.profilecontext.a r5) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        ProfileStyleParams r6 = r4.getProfileStyleParams();
        if (r6 != null) goto L5;
    L7:
        return false;
    L5:
        if (r6.getProfileStyle() != ProfileStyleParams.LOCAL_LIFE) goto L7;
        return true;
    }
}
