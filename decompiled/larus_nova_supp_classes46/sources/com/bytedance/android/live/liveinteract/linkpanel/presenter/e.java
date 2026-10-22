package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import am2.n;
import am2.x;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements IShareCallback {
    public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;
    public final /* synthetic */ int b;

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

    public e(BaseTalkInviteListWidgetPresenter r1) {
        this.a = r1;
        this.b = 1;
    }

    public final void onSuccess(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "platform");
        Intrinsics.checkNotNullParameter(r7, "shareType");
        HashMap r8 = new HashMap();
        this.a.getClass();
        r8.put("live_type", "voice_live");
        if (this.b != 0) goto L5;
        r8.put("event_page", "apply_message_panel");
    L6:
        m.B(r8, null, 6);
        if (vm2.c.d() == false) goto L9;
        j0.l().sendLog("livesdk_share", r8, new Object[]{n.f(), x.class, Room.class});
        return;
    L9:
        j0.l().sendLog("livesdk_share", r8, new Object[]{n.f()});
        return;
    L5:
        r8.put("event_page", "invite_connection_panel");
        goto L6
    }
}
