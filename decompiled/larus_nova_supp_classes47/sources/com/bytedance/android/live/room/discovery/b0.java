package com.bytedance.android.live.room.discovery;

import android.app.Dialog;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTag;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTagParams;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ LiveHashtagWidget a;

    public b0(LiveHashtagWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        LiveHashtagWidget r12 = this.a;
        if (r12.i == false) goto L14;
        String r13 = r12.h.getOwnerUserIdString();
        HashMap r0 = new HashMap();
        r0.put("anchor_id", String.valueOf(r13));
        r0.put("entrance_type", "live_room");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_challenge_click", r0, new Object[]{new am2.x(), Room.class});
        LiveHashtagWidget r1 = this.a;
        Dialog r6 = r1.n;
        if (r6 != null) goto L7;
    L9:
        long r7 = r1.k;
        HashMap r8 = new HashMap();
        r8.put("anchor_id", String.valueOf(r7));
        r8.put("entrance_type", "live_room");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_challenge_list_show", r8, new Object[]{new am2.x(), Room.class});
        r1.n = TTLiveSDK.hostService().hostApp().selectHashTag(((Widget) r1).context, new LiveHashTagParams.Builder().setRoomId(r1.h.getIdStr()).setNeedLoadCircleData(false).setCurrentHashTag(new LiveHashTag(r1.k + "", r1.l)).setIsLiving(true).setEntranceType("live_room").build(), new c0(r1));
        if (((Boolean) ((Widget) r1).dataCenter.get("data_need_show_task_challenge_toast", Boolean.FALSE)).booleanValue() == true) goto L12;
        return;
    L12:
        if (r1.q == false) goto L17;
        f2.c(s1.B(2131915895), 0);
        r1.q = false;
        return;
    L17:
        return;
    L7:
        if (r6.isShowing() == false) goto L9;
        return;
    L14:
        long r4 = r12.k;
        HashMap r14 = new HashMap();
        r14.put("tag_id", String.valueOf(r4));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_challenge_click", r14, new Object[]{new am2.x(), Room.class});
        LiveHashtagWidget r15 = this.a;
        r15.yq(r15.k);
    }
}
