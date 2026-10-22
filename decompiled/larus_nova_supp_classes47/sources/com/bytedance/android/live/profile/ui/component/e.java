package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ProfileCommonComponent a;
    public final /* synthetic */ int b;

    public e(ProfileCommonComponent r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.a.i.b().recordBusinessClick("small_shop_entrance", null);
        ProfileCommonComponent r6 = this.a;
        int r0 = this.b;
        Context r1 = r6.a.getActivity();
        if (r1 == null) goto L6;
        r6.i.a().clickShopEntrance(r1, r0, ProfileCommonComponent.class, "live_personal_card");
        return;
    }
}
