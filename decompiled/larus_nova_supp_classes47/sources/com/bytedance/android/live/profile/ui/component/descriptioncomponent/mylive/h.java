package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements ProfileNestedScrollView.b {
    public final /* synthetic */ ProfileTabsComponent a;

    public h(ProfileTabsComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.profile.customview.ProfileNestedScrollView.b
    public final void a(int r1, int r2, int r3) {
        if (r2 < r3) goto L6;
        View r4 = this.a.f;
        if (r4 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r4);
        return;
    L10:
        return;
    L6:
        View r5 = this.a.f;
        if (r5 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    }
}
