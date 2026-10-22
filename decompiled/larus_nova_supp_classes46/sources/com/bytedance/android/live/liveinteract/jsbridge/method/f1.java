package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendJoinMatrixInvitationResultModel;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f1 implements IMiddlewareHostAction.LiveMatrixInviteCallback {
    public final /* synthetic */ g1 a;

    public f1(g1 r1) {
        this.a = r1;
    }

    public final void onResult(boolean r3) {
        SendJoinMatrixInvitationResultModel r0 = new SendJoinMatrixInvitationResultModel();
        if (r3 == false) goto L6;
        r0.a(SendJoinMatrixInvitationResultModel.Code.Success);
        SendJoinMatrixInvitationResultModel.a r1 = new SendJoinMatrixInvitationResultModel.a();
        r1.a(Boolean.valueOf(r3));
        r0.b(r1);
        this.a.finishWithResult(r0);
        return;
    }
}
