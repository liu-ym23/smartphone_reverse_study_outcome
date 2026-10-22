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
public final class c implements IShareCallback {
    public final /* synthetic */ b a;
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

    public c(b r1) {
        this.a = r1;
        this.b = 0;
    }

    public final void onSuccess(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "platform");
        Intrinsics.checkNotNullParameter(r7, "shareType");
        HashMap r8 = new HashMap();
        Room r9 = this.a.f;
        if (r9 != null) goto L5;
    L7:
        r8.put("live_type", "video_live");
    L9:
        if (this.b != 0) goto L11;
        r8.put("event_page", "apply_message_panel");
    L12:
        el0.j.k(r8);
        el0.j.n(r8, Integer.valueOf(n.a()));
        if (((Boolean) e0.a.getValue()).booleanValue() == false) goto L15;
        u.l().sendLog("livesdk_share", r8, new Object[]{am2.n.f(), x.class, Room.class});
        return;
    L15:
        u.l().sendLog("livesdk_share", r8, new Object[]{am2.n.f()});
        return;
    L11:
        r8.put("event_page", "invite_connection_panel");
        goto L12
    L5:
        if (r9.isLiveTypeAudio() != true) goto L7;
        r8.put("live_type", "voice_live");
        goto L9
    }
}
