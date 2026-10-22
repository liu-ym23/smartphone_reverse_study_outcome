package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends mx.l {
    public d() {
        super("主播侧展示礼物特效", null, ((Boolean) com.bytedance.android.livesdk.sharedpref.b.d1.getValue()).booleanValue(), false, true, null, 106);
    }

    public final void d() {
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to("anchor_id", jc1.k.n(IUserService.class).user().n());
        RoomContext.a r3 = RoomContext.Companion;
        LiveMode r5 = null;
        RoomContext r8 = RoomContext.a.c(r3, null, 0, 3);
        if (r8 == null) goto L9;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L9;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L9;
        String r11 = r10.getIdStr();
    L10:
        r2[1] = TuplesKt.to("room_id", r11);
        RoomContext r1 = RoomContext.a.c(r3, null, 0, 3);
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.i r4 = r1.getLiveMode();
        if (r4 == null) goto L15;
        r5 = (LiveMode) r4.getValue();
    L15:
        int r6 = h1.a;
        r2[2] = TuplesKt.to("live_type", i1.a(r5));
        r0.sendLog("livesdk_anchor_gift_effect_setting_show", MapsKt.mapOf(r2), new Object[0]);
        return;
    L9:
        r11 = null;
        goto L10
    }

    public final void c(SwitchSettingViewHolder r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r10, "holder");
        ((mx.l) this).l = r11;
        RoomContext.a r12 = RoomContext.Companion;
        LiveMode r0 = null;
        RoomContext r4 = RoomContext.a.c(r12, null, 0, 3);
        if (r4 == null) goto L9;
        com.bytedance.live.datacontext.n r5 = r4.getDataCenter();
        if (r5 == null) goto L9;
        DataCenter r6 = (DataCenter) r5.getValue();
        if (r6 == null) goto L9;
        r6.put("cmd_toggle_gift_video_view", Boolean.valueOf(r11));
    L9:
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.b.d1;
        Boolean r8 = Boolean.valueOf(r11);
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r8);
        com.bytedance.android.livesdk.log.g r9 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r13 = new Pair[4];
        r13[0] = TuplesKt.to("anchor_id", jc1.k.n(IUserService.class).user().n());
        RoomContext r14 = RoomContext.a.c(r12, null, 0, 3);
        if (r14 == null) goto L16;
        com.bytedance.live.datacontext.m r15 = r14.getRoom();
        if (r15 == null) goto L16;
        Room r16 = (Room) r15.getValue();
        if (r16 == null) goto L16;
        String r17 = r16.getIdStr();
    L17:
        r13[1] = TuplesKt.to("room_id", r17);
        RoomContext r18 = RoomContext.a.c(r12, null, 0, 3);
        if (r18 == null) goto L22;
        com.bytedance.live.datacontext.i r19 = r18.getLiveMode();
        if (r19 == null) goto L22;
        r0 = (LiveMode) r19.getValue();
    L22:
        int r110 = h1.a;
        r13[2] = TuplesKt.to("live_type", i1.a(r0));
        if (r11 == false) goto L25;
        String r111 = "on";
    L26:
        r13[3] = TuplesKt.to("selection", r111);
        r9.sendLog("livesdk_anchor_gift_effect_setting_click", MapsKt.mapOf(r13), new Object[0]);
        return;
    L25:
        r111 = "off";
    L16:
        r17 = null;
        goto L17
    }
}
