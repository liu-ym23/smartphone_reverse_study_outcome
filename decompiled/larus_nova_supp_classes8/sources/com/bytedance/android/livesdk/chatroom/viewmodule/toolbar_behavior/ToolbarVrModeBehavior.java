package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.config.su0;
import com.bytedance.android.livesdk.config.tu0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarVrModeBehavior extends t5 {
    public long j;
    public final long k;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public ToolbarVrModeBehavior(DataCenter r3) {
        super(r3);
        this.k = 15000;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r8) {
        Intrinsics.checkNotNullParameter(r8, "command");
        Context r1 = null;
        String r2 = null;
        r2 = null;
        if ((r8 instanceof pp1.m) == false) goto L34;
        if (((pp1.m) r8).a != 0) goto L53;
        int r9 = VrUtils.l(this.i);
        DataCenter r0 = this.i;
        if (r0 == null) goto L9;
        Integer r3 = (Integer) r0.get("cmd_last_vr_toolbar_orientation", null);
    L10:
        if (r3 != null) goto L13;
    L14:
        DataCenter r4 = this.i;
        if (r4 == null) goto L17;
        r4.put("cmd_last_vr_toolbar_orientation", Integer.valueOf(r9));
    L17:
        String r10 = String.valueOf(VrUtils.l(this.i));
        com.bytedance.android.livesdk.log.g r5 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r6 = new Pair[6];
        DataCenter r7 = this.i;
        if (r7 == null) goto L24;
        Room r11 = com.bytedance.android.live.core.utils.z.o(r7);
        if (r11 == null) goto L24;
        User r12 = r11.getOwner();
        if (r12 == null) goto L24;
        String r13 = r12.getIdString();
    L25:
        r6[0] = TuplesKt.to("anchor_id", r13);
        DataCenter r14 = this.i;
        if (r14 == null) goto L30;
        Room r15 = com.bytedance.android.live.core.utils.z.o(r14);
        if (r15 == null) goto L30;
        r2 = r15.getIdStr();
    L30:
        r6[1] = TuplesKt.to("room_id", r2);
        r6[2] = TuplesKt.to("vr_type", VrUtils.n());
        r6[3] = TuplesKt.to("is_vr_machine", "1");
        r6[4] = TuplesKt.to("is_original_vr", "1");
        r6[5] = TuplesKt.to("screen_direction", r10);
        r5.sendLog("livesdk_live_vr_label_show", MapsKt.mapOf(r6), new Object[]{am2.x.class});
        JSONObject r16 = new JSONObject();
        r16.put("vr_icon_show", true);     // Catch: JSONException -> L50
    L32:
        com.bytedance.android.livesdk.log.b0.o().k("LiveVRMonitor_live_play", r16);
        return;
    L24:
        r13 = null;
        goto L25
    L13:
        if (r9 != r3.intValue()) goto L14;
        return;
    L9:
        r3 = null;
        goto L10
    L53:
        return;
    L34:
        if ((r8 instanceof pp1.c) == false) goto L56;
        RoomContext r17 = this.a;
        if (r17 == null) goto L40;
        com.bytedance.live.datacontext.j r18 = r17.getToolbarBubbleManager();
        if (r18 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0 r19 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0) r18.getValue();
    L41:
        View r20 = this.b;
        if (r20 == null) goto L44;
        r1 = r20.getContext();
    L44:
        if (r1 == null) goto L57;
        View r21 = this.b;
        if (r19 == null) goto L58;
        if (r21 == null) goto L59;
        r19.addBubble(r8, ((pp1.c) r8).k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.i, r1, r21), new ToolbarVrModeBehavior$onCommand$$inlined$lets$lambda$1(this, r8));
        this.j = System.currentTimeMillis();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L40:
        r19 = null;
        goto L41
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        String r0 = null;
        if (r11 == null) goto L5;
        Context r12 = r11.getContext();
    L6:
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r1 = LiveVrContext.c.a();
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.m r2 = r1.getShouldShowBreathForReset();
        if (r2 == null) goto L15;
        if ((System.currentTimeMillis() - this.j) > this.k) goto L13;
        boolean r4 = true;
    L14:
        r2.setValue(Boolean.valueOf(r4));
        goto L15
    L13:
        r4 = false;
    L15:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r3 = LiveVrContext.c.a();
        if (r3 == null) goto L18;
        r3.showVrControlDialog(r12);
    L18:
        long r5 = System.currentTimeMillis();
        String r13 = String.valueOf(VrUtils.l(this.i));
        long r6 = com.bytedance.android.livesdk.chatroom.tetris.vr.r.a;
        if (r5 > (r6 - ((long) 20000))) goto L21;
    L23:
        boolean r7 = false;
    L24:
        com.bytedance.android.livesdk.log.g r8 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r9 = new Pair[8];
        DataCenter r10 = this.i;
        if (r10 == null) goto L31;
        Room r14 = com.bytedance.android.live.core.utils.z.o(r10);
        if (r14 == null) goto L31;
        User r15 = r14.getOwner();
        if (r15 == null) goto L31;
        String r16 = r15.getIdString();
    L32:
        r9[0] = TuplesKt.to("anchor_id", r16);
        DataCenter r17 = this.i;
        if (r17 == null) goto L37;
        Room r18 = com.bytedance.android.live.core.utils.z.o(r17);
        if (r18 == null) goto L37;
        r0 = r18.getIdStr();
    L37:
        r9[1] = TuplesKt.to("room_id", r0);
        r9[2] = TuplesKt.to("vr_type", VrUtils.n());
        String r19 = "1";
        r9[3] = TuplesKt.to("is_vr_machine", "1");
        r9[4] = TuplesKt.to("is_switch_model", "0");
        r9[5] = TuplesKt.to("is_original_vr", "1");
        if (r7 == true) goto L41;
        r19 = "0";
    L41:
        r9[6] = TuplesKt.to("bubble_show", r19);
        r9[7] = TuplesKt.to("screen_direction", r13);
        r8.sendLog("livesdk_live_vr_label_click", MapsKt.mapOf(r9), new Object[]{am2.x.class});
        return;
    L31:
        r16 = null;
        goto L32
    L21:
        if (r5 >= r6) goto L23;
        r7 = true;
        goto L24
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L10;
        IAnimationScheduler r4 = IAnimationScheduler.Companion.a(this.i);
        if (r4 == null) goto L9;
        r4.unRegisterListener(this.h);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.a = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        this.b = r5.findViewById(2131387276);
        int r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.b(Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(r6, false))) == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(this.b);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r5.findViewById(2131392872));
        View r1 = this.b;
        if (r1 == null) goto L8;
        r1.setBackgroundResource(2131251626);
    L8:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L12;
        View r2 = this.b;
        if (r2 == null) goto L12;
        r2.setBackgroundResource(2131243772);
    L12:
        this.c = r5.findViewById(2131362952);
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == true) goto L36;
    L27:
        HSImageView r7 = this.c;
        if (r7 != null) goto L30;
        return;
    L30:
        Intrinsics.checkNotNull(r7);
        r7.post(new ToolbarVrModeBehavior$onLoad$1(this));
        com.bytedance.android.livesdk.log.filter.u r8 = com.bytedance.android.livesdk.log.j0.l().c(IRoom.class);
        if (r8 != null) goto L33;
        return;
    L33:
        if ((r8 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L39;
        r8.y(VrUtils.o(r6));
        return;
    L39:
        return;
    L36:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L25
        if (su0.a.getValue().booleanValue() == false) goto L19;
        ALogger.i("ToolbarVrModeBehavior", "register group purchase by delay");     // Catch: Throwable -> L25
        Boolean r10 = Boolean.valueOf(com.bytedance.android.live.core.utils.i0.c().postDelayed(new u5(this), tu0.a.getValue().longValue()));     // Catch: Throwable -> L25
    L23:
        Result.constructor-impl(r10);     // Catch: Throwable -> L25
        goto L27
    L19:
        ALogger.i("ToolbarVrModeBehavior", "register group purchase by no delay");     // Catch: Throwable -> L25
        IAnimationScheduler r11 = IAnimationScheduler.Companion.a(this.i);     // Catch: Throwable -> L25
        if (r11 == null) goto L22;
        r11.registerListener(this.h);     // Catch: Throwable -> L25
        r10 = Unit.INSTANCE;     // Catch: Throwable -> L25
        goto L23
    L22:
        r10 = null;
    L25:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
