package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdkapi.floatview.InnerFloatWindowHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends rx1.c {
    public final /* synthetic */ LinkmicOnlineFloatWindowManager a;

    public final void onDismiss() {
        LinkmicOnlineFloatWindowManager r0 = this.a;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.T("onRealDismissFromViewStateListener", 13);
        LinkmicOnlineFloatWindowManager.t("call onRealDismissFromViewStateListener");
        r0.X.clear();
        r0.U = false;
    }

    public final void onHide() {
        this.a.getClass();
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.T("onRealHideFromViewStateListener", 12);
        LinkmicOnlineFloatWindowManager.t("call onRealHideFromViewStateListener");
    }

    public final void onShow() {
        LinkmicOnlineFloatWindowManager r0 = this.a;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.T("onRealShowFromViewStateListener", 11);
        LinkmicOnlineFloatWindowManager.t("call onRealShowFromViewStateListener");
        if (r0.U == true) goto L5;
        r0.U = true;
        r0.w();
    L5:
        InnerFloatWindowHelper.triggerWindowCallBack$default(InnerFloatWindowHelper.INSTANCE, this.a.H, InnerFloatWindowHelper.ActionType.SHOW, false, 4, null);
    }

    public f(LinkmicOnlineFloatWindowManager r1) {
        this.a = r1;
    }
}
