package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ApplyPermissionSwitchFragment a;

    public d(ApplyPermissionSwitchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ApplyPermissionSwitchFragment.ba0(this.a, true);
    }
}
