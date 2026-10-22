package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkLaunchViewModelNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 implements h31.g {
    public final /* synthetic */ MultiAnchorTeamPkLaunchFragmentNew a;

    @Override // h31.g
    public final void onFailed() {
        MultiAnchorTeamPkLaunchFragmentNew r0 = this.a;
        int r1 = MultiAnchorTeamPkLaunchFragmentNew.l;
        MultiAnchorPkLaunchViewModelNew r2 = r0.T90();
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }

    @Override // h31.g
    public final void onSuccess() {
        MultiAnchorTeamPkLaunchFragmentNew r0 = this.a;
        int r1 = MultiAnchorTeamPkLaunchFragmentNew.l;
        MultiAnchorPkLaunchViewModelNew r2 = r0.T90();
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }

    public b0(MultiAnchorTeamPkLaunchFragmentNew r1) {
        this.a = r1;
    }
}
