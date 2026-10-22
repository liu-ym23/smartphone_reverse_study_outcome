package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ PkApplyPermissionSwitchDialog a;

    public h(PkApplyPermissionSwitchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        PkApplyPermissionSwitchDialog.M0(this.a, true);
    }
}
