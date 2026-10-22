package com.bytedance.android.live.profile.ui.component;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ ProfileDynamicOperateComponent a;

    public q(ProfileDynamicOperateComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.C.a().clickDynamicSpaceView();
    }
}
