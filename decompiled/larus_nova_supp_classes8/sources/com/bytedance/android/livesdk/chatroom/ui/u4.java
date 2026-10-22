package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u4 implements IShareCallback {
    public final /* synthetic */ Boolean a;
    public final /* synthetic */ AbsInteractionFragment b;

    public final boolean interceptReportAction(IShareParams r1) {
        return false;
    }

    public final void onFail(Throwable r1) {
    }

    public final /* synthetic */ void onShareUiDismiss() {
        IShareCallback.-CC.$default$onShareUiDismiss(this);
    }

    public final /* synthetic */ void onShareUiShow() {
        IShareCallback.-CC.$default$onShareUiShow(this);
    }

    public u4(AbsInteractionFragment r1, Boolean r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onSuccess(String r5, String r6) {
        if (this.b.q != null) goto L5;
        return;
    L5:
        if (this.a.booleanValue() == false) goto L11;
        long r7 = System.currentTimeMillis();
        AbsInteractionFragment r0 = this.b;
        if ((r7 - r0.B) < 2000) goto L12;
        r0.B = System.currentTimeMillis();
        AbsInteractionFragment r8 = this.b;
        AbsInteractionFragment.ca0(r8, r8.q.getId(), this.b.q.getLabels());
        return;
    L12:
        return;
    }
}
