package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements h31.g {
    public final /* synthetic */ MultiAnchorTeamPkLaunchDialogV2 a;

    @Override // h31.g
    public final void onFailed() {
        MultiAnchorTeamPkLaunchDialogV2 r0 = this.a;
        int r1 = MultiAnchorTeamPkLaunchDialogV2.m;
        r0.U90().dismiss();
    }

    @Override // h31.g
    public final void onSuccess() {
        MultiAnchorTeamPkLaunchDialogV2 r0 = this.a;
        int r1 = MultiAnchorTeamPkLaunchDialogV2.m;
        r0.U90().dismiss();
    }

    public b(MultiAnchorTeamPkLaunchDialogV2 r1) {
        this.a = r1;
    }
}
