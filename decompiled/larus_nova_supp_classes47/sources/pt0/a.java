package pt0;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.base.d;
import com.bytedance.android.live.profile.ui.base.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements g {
    public final ComponentType a;

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(d r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return this.a;
    }

    public a(ComponentType.StandardHonourWall r2) {
        Intrinsics.checkNotNullParameter(r2, "componentType");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }
}
