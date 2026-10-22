package com.bytedance.android.live.livepkaudience.presenter;

import am2.x;
import com.bytedance.android.live.core.setting.e0;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import dl0.n;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements IShareCallback {
    public final /* synthetic */ int a;

    public j() {
        this.a = 1;
    }

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

    public final void onSuccess(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "platform");
        Intrinsics.checkNotNullParameter(r7, "shareType");
        HashMap r8 = new HashMap();
        r8.put("live_type", "video_live");
        if (this.a != 0) goto L5;
        r8.put("event_page", "apply_message_panel");
    L6:
        el0.j.k(r8);
        el0.j.n(r8, Integer.valueOf(n.a()));
        if (((Boolean) e0.a.getValue()).booleanValue() == false) goto L9;
        u.l().sendLog("livesdk_share", r8, new Object[]{am2.n.f(), x.class, Room.class});
        return;
    L9:
        u.l().sendLog("livesdk_share", r8, new Object[]{am2.n.f()});
        return;
    L5:
        r8.put("event_page", "invite_connection_panel");
        goto L6
    }
}
