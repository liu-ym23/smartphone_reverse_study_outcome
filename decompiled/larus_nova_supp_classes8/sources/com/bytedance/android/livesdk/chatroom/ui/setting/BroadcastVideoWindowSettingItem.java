package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.adapter.binding.BaseSettingViewHolder;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BroadcastVideoWindowSettingItem extends mx.l {
    public boolean p;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ BroadcastVideoWindowSettingItem a;
        public final /* synthetic */ SwitchSettingViewHolder b;

        public a(BroadcastVideoWindowSettingItem r1, SwitchSettingViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r3) {
            BroadcastVideoWindowSettingItem r4 = this.a;
            if (r4.p == false) goto L6;
            int r0 = mx.l.o;
            mx.l.a.a(r4, this.b, false);
            return;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public final void d() {
        Boolean r0 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.d2.getValue();
        int r1 = LiveRoomManageAppLogger.b;
        String r2 = null;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L7;
        Room r5 = (Room) r4.getValue();
    L8:
        boolean r6 = r0.booleanValue();
        long r7 = System.currentTimeMillis();
        if ((r7 - LiveRoomManageAppLogger.a) <= 2000) goto L24;
        LiveRoomManageAppLogger.a = r7;
        Pair[] r8 = new Pair[3];
        if (r5 == null) goto L14;
        String r9 = r5.getIdStr();
    L15:
        r8[0] = TuplesKt.to("room_id", r9);
        if (r5 == null) goto L18;
        r2 = r5.getOwnerUserIdString();
    L18:
        r8[1] = TuplesKt.to("anchor_id", r2);
        if (r6 == false) goto L21;
        String r10 = "on";
    L22:
        r8[2] = TuplesKt.to("mini_window_status", r10);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_mini_window_setting_show", MapsKt.mapOf(r8), new Object[0]);
        return;
    L21:
        r10 = "off";
        goto L22
    L14:
        r9 = null;
        goto L15
    L24:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public BroadcastVideoWindowSettingItem() {
        String r2 = s1.B(2131918908);
        String r3 = s1.B(2131918905);
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).broadcastFloatWindowManager();
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.A0;
        super(r2, r3, false, ((Boolean) r0.getValue()).booleanValue(), false, null, 112);
        this.p = true;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L8;
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.D0;
        Integer r5 = (Integer) r4.getValue();
        if (r5.intValue() < 6) goto L7;
        com.bytedance.android.livesdk.sharedpref.f.d(r0, Boolean.FALSE);
    L7:
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Integer.valueOf(r5.intValue() + 1));
    L8:
        boolean r1 = rx1.m.e(s1.getContext());
        Boolean r6 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.d2.getValue();
        if (r1 == false) goto L12;
        r6.booleanValue();
        return;
    }

    public final void c(SwitchSettingViewHolder r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r11, "holder");
        ((mx.l) this).l = r12;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.A0;
        Boolean r2 = Boolean.FALSE;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(this, "item");
        ((mx.a) this).h = false;
        ((BaseSettingViewHolder) r11).c.setVisibility(8);
        boolean r3 = rx1.m.e(s1.getContext());
        String r6 = null;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L7;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L7;
        Room r7 = (Room) r5.getValue();
    L8:
        int r8 = LiveRoomManageAppLogger.b;
        Pair[] r9 = new Pair[4];
        if (r7 == null) goto L11;
        String r10 = r7.getIdStr();
    L12:
        r9[0] = TuplesKt.to("room_id", r10);
        if (r7 == null) goto L15;
        r6 = r7.getOwnerUserIdString();
    L15:
        r9[1] = TuplesKt.to("anchor_id", r6);
        if (r12 == false) goto L18;
        String r13 = "on";
    L19:
        r9[2] = TuplesKt.to("click_type", r13);
        if (r3 == false) goto L22;
        String r14 = "1";
    L23:
        r9[3] = TuplesKt.to("mini_window_status", r14);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_mini_window_setting_click", MapsKt.mapOf(r9), new Object[0]);
        if (r12 == true) goto L26;
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.d2;
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r2);
        return;
    L26:
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.d2;
        Boolean r17 = Boolean.TRUE;
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r17);
        if (r3 == true) goto L50;
        Disposable r18 = ((mx.l) this).m;
        if (r18 != null) goto L31;
    L35:
        this.p = true;
        final Context r19 = r11.d.getContext();
        z0.a().getClass();
        x0.d r20 = new x0.d();
        r20.b = r19;
        r20.a = 4;
        r20.c = "开启悬浮窗权限";
        r20.d = "该功能需打开权限，点击「去开启」可能会短暂离开直播画面，前往设置页";
        DialogInterface.OnClickListener r21 = new BroadcastVideoWindowSettingItem$onCheckStateChanged$1(this, r19);
        x0.c[] r110 = r20.g;
        x0.c r22 = r110[0];
        if (r22 != null) goto L38;
        r22 = new x0.c();
        r110[0] = r22;
    L38:
        r22.a = "去开启";
        r22.b = r21;
        r20.i = new a(this, r11);
        b r111 = b.a;
        x0.c[] r112 = r20.g;
        x0.c r0 = r112[1];
        if (r0 != null) goto L41;
        r0 = new x0.c();
        r112[1] = r0;
    L41:
        r0.a = "以后再说";
        r0.b = r111;
        x0.b.g(new x0(r20.b, r20));
        Disposable r113 = ((mx.l) this).m;
        if (r113 != null) goto L44;
        return;
    L44:
        if (r113.isDisposed() == true) goto L52;
        Disposable r114 = ((mx.l) this).m;
        if (r114 == null) goto L53;
        r114.dispose();
        return;
    L53:
        return;
    L52:
        return;
    L31:
        if (r18.isDisposed() == true) goto L35;
        Disposable r115 = ((mx.l) this).m;
        if (r115 == null) goto L35;
        r115.dispose();
        goto L35
    L50:
        return;
    L22:
        r14 = "0";
        goto L23
    L18:
        r13 = "off";
        goto L19
    L11:
        r10 = null;
    L7:
        r7 = null;
        goto L8
    }
}
