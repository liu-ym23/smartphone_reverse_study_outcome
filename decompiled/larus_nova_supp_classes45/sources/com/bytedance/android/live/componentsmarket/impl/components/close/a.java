package com.bytedance.android.live.componentsmarket.impl.components.close;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdkapi.depend.live.IRoomAction;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ d90.a a;

    public a(d90.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        d90.a r8 = this.a;
        n0 r0 = null;
        if (r8 == null) goto L5;
        DataCenter r1 = r8.h;
    L6:
        if (r8 == null) goto L12;
        IAbilityCenter r9 = r8.a();
        if (r9 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r11 = r9.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r11 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r12 = r11.wl();
    L13:
        if (r12 == null) goto L15;
        r12.report("exit_btn_click", null);
    L15:
        if (r1 != null) goto L17;
        return;
    L17:
        IRoomService r2 = k.f(IRoomService.class);
        if (r2 != null) goto L20;
    L24:
        IRoomAction r3 = (IRoomAction) r1.get("data_room_action", null);
        if ((r3 instanceof IRoomAction) == true) goto L27;
    L31:
        if (r12 == null) goto L33;
        r12.report("exit_event_send", null);
    L33:
        xs2.b r13 = xs2.b.a();
        h1 r4 = new h1(6);
        HashMap r5 = new HashMap();
        r5.put("exit_type", "cross");
        r4.e = r5;
        Unit r6 = Unit.INSTANCE;
        r13.post(r4);
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("leave_type", "click");
        int r15 = b.a;
        Intrinsics.checkNotNullParameter(r14, "logMap");
        n0 r16 = u.l().c(x.class);     // Catch: Exception -> L49
        if ((r16 instanceof n0) == false) goto L38;
        r0 = r16;
    L38:
        n0 r17 = r0;     // Catch: Exception -> L49
        if (r17 == null) goto L51;
        String r18 = r17.z;     // Catch: Exception -> L49
        if (r18 == null) goto L51;
        JSONObject r19 = s2.a(r18);     // Catch: Exception -> L49
        String r21 = r19.optString("video_id");     // Catch: Exception -> L49
        if (r21 == null) goto L45;
        r14.put("video_id", r21);     // Catch: Exception -> L49
    L45:
        String r22 = r19.optString("video_live_label");     // Catch: Exception -> L49
        if (r22 == null) goto L51;
        r14.put("video_live_label", r22);     // Catch: Exception -> L49
    L51:
        u.l().sendLog("live_leave", r14, new Object[]{x.class, Room.class});
        return;
    L49:
        e = move-exception;
        ALogger.e("LiveSdkLogUti", "can't parse json for relevant log", e);
        goto L51
    L27:
        if (r3.interceptRoomClose() == false) goto L31;
        if (r12 == null) goto L56;
        r12.report("exit_event_intercepted", "RoomAction");
        return;
    L56:
        return;
    L20:
        if (r2.shouldFeedbackInterceptLeaveRoom(r1, 6) != true) goto L24;
        if (r12 == null) goto L55;
        r12.report("exit_event_intercepted", "Feedback");
        return;
    L55:
        return;
    L12:
        r12 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
