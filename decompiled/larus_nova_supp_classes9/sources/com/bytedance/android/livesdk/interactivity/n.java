package com.bytedance.android.livesdk.interactivity;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ LeftAvatarWidget a;
    public final /* synthetic */ com.bytedance.android.live.base.model.user.e b;

    public n(LeftAvatarWidget r1, com.bytedance.android.live.base.model.user.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LeftAvatarWidget.xq(this.a, this.b);
    }
}
