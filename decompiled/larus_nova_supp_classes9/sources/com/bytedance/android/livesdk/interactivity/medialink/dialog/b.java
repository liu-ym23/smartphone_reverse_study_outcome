package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ MediaAnchorInteractContainerFragment a;

    public b(MediaAnchorInteractContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        MediaAnchorInteractContainerFragment r4 = this.a;
        int r0 = MediaAnchorInteractContainerFragment.h;
        t82.f r5 = r4.d;
        MediaAnchorInteractSettingFragment r1 = new MediaAnchorInteractSettingFragment();
        r1.f = new u82.a(r1);
        r1.d = r5;
        r5.v20(r1);
    }
}
