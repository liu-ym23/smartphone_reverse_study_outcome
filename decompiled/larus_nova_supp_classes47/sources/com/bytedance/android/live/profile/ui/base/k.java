package com.bytedance.android.live.profile.ui.base;

import android.view.View;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class k implements g {
    public d a;

    public k() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void b(d r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void f() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public abstract /* synthetic */ void update(NewProfileUser r1);

    public void h() {
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeAllViews();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    public final <T extends View> T i(int r2) {
        d r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.a(r2);
    }
}
