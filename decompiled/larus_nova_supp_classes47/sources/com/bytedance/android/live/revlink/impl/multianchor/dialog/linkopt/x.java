package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkLaunchViewModelNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x implements h31.g {
    public final /* synthetic */ MultiAnchorPersonalPkLaunchFragmentNew a;

    @Override // h31.g
    public final void onFailed() {
        MultiAnchorPersonalPkLaunchFragmentNew r0 = this.a;
        int r1 = MultiAnchorPersonalPkLaunchFragmentNew.m;
        MultiAnchorPkLaunchViewModelNew r2 = r0.S90();
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }

    @Override // h31.g
    public final void onSuccess() {
        MultiAnchorPersonalPkLaunchFragmentNew r0 = this.a;
        int r1 = MultiAnchorPersonalPkLaunchFragmentNew.m;
        MultiAnchorPkLaunchViewModelNew r2 = r0.S90();
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }

    public x(MultiAnchorPersonalPkLaunchFragmentNew r1) {
        this.a = r1;
    }
}
