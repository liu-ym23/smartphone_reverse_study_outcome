package in0;

import am2.x;
import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.c;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.config.an0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import j40.f4;
import java.util.LinkedHashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements c0.b {
    public b() {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void p4(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final boolean showRedDot() {
        return !((Boolean) f4.e.getValue()).booleanValue();
    }

    public final void onClick(View r5) {
        Uri r6 = UriProtector.parse((String) an0.a.getValue());
        if (k.f(IBaseBrowserService.class) == null) goto L7;
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        if (r0 == null) goto L7;
        IBaseBrowserService.b.a(k.n(IBaseBrowserService.class), r0, r6);
        com.bytedance.android.livesdk.sharedpref.e r7 = f4.e;
        Boolean r1 = Boolean.TRUE;
        r7.getClass();
        f.d(r7, r1);
    L7:
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("icon_name", "permanent_guest");
        TalkRoomLogUtils.J0(r8);
        TalkRoomLogUtils.u0(r8);
        TalkRoomLogUtils.B0(r8, null, null, 6);
        j0.l().sendLog("livesdk_anchor_more_permanent_guest_icon_click", r8, new Object[]{IRoom.class, x.class, c.class});
    }
}
