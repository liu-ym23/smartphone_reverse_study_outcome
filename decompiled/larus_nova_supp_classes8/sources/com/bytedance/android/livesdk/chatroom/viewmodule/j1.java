package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j1 implements View.OnClickListener {
    public final /* synthetic */ k1 a;

    public j1(k1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r22) {
        Bundle r1 = this.a.i;
        if (r1 != null) goto L5;
        return;
    L5:
        long r2 = r1.getLong("live.intent.extra.ROOM_ID", 0);
        com.bytedance.android.livesdk.log.filter.o r5 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        HashMap r7 = new HashMap();
        r7.put("banner_type", com.bytedance.android.livesdk.log.l0.a("enter_method", r6));
        ObjectAnimator r9 = this.a.g;
        if (r9 != null) goto L8;
        long r10 = 0;
    L9:
        r7.put("process_duration", String.valueOf(r10));
        String[] r12 = {"room_id", "anchor_id"};
        if (r12.length < 1) goto L15;
        int r13 = r12.length;
        int r3 = 0;
    L13:
        if (r3 >= r13) goto L15;
        String r4 = r12[r3];
        r7.put(r4, com.bytedance.android.livesdk.log.l0.a(r4, r5));
        r3 = r3 + 1;
    L15:
        r7.put("to_room_id", String.valueOf(r2));
        r7.put("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.a.i, "anchor_id"));
        r7.put("orientation", String.valueOf(this.a.i.getInt("orientation", 0)));
        com.bytedance.android.livesdk.log.g r8 = com.bytedance.android.livesdk.log.u.l();
        am2.o r14 = new am2.o();
        r14.a = this.a.f;
        r8.sendLog("livesdk_return_click", r7, new Object[]{r14});
        com.bytedance.android.livesdk.log.m0 r11 = new com.bytedance.android.livesdk.log.m0();
        ObjectAnimator r15 = this.a.g;
        if (r15 != null) goto L18;
        long r16 = 0;
    L19:
        r11.b("process_duration", String.valueOf(r16));
        r11.a(r5, new String[]{"room_id", "anchor_id"});
        r11.b("to_room_id", String.valueOf(r2));
        r11.b("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.a.i, "anchor_id"));
        r11.b("orientation", String.valueOf(this.a.i.getInt("orientation", 0)));
        r11.a(r6, new String[]{"enter_from_merge", "enter_method", "action_type"});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_return_last_click", r11.a, new Object[0]);
        Activity r17 = ContextUtil.contextToActivity(this.a.h);
        if (tb1.c.a == false) goto L29;
        if (r17 == null) goto L29;
        if (com.bytedance.android.livesdk.chatroom.c0.b().getBackRoomInfo(r2).intValue() == (-1)) goto L29;
        if (r17.hashCode() == com.bytedance.android.livesdk.chatroom.c0.b().getBackRoomInfo(r2).intValue()) goto L29;
        boolean r18 = false;
    L30:
        if (r18 == true) goto L33;
        xs2.b.a().post(new zg1.h1(6));
        return;
    L33:
        JumpToOtherRoomEvent r19 = new JumpToOtherRoomEvent(r2, com.bytedance.android.livesdk.chatroom.helper.a.a(this.a.i), true);
        r19.source = "sourceJumpToOtherLiveBackRoomViewController";
        xs2.b.a().post(r19);
        return;
    L29:
        r18 = true;
        goto L30
    L18:
        r16 = r15.getCurrentPlayTime();
        goto L19
    L8:
        r10 = r9.getCurrentPlayTime();
        goto L9
    }
}
