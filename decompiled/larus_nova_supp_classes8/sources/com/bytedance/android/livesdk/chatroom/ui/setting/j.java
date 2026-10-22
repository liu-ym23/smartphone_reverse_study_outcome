package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.ReplayDetailSettingDialog;
import com.bytedance.android.livesdk.utils.m5;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import nz.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends mx.b {
    public final Room m;
    public final Lazy n;
    public final ReplayDetailSettingDialog o;
    public final ListDialogAbility p;
    public final Function0<Boolean> q;
    public final String r;

    public static final void c(j r3, boolean r4) {
        r3.getClass();
        com.bytedance.android.livesdk.log.g r5 = com.bytedance.android.livesdk.log.u.l();
        HashMap r0 = new HashMap();
        if (r4 == false) goto L5;
        String r6 = "1";
    L6:
        r0.put("action_type", r6);
        r0.put("event_page", "live_take_page");
        r0.put("user_id", jc1.k.n(IUserService.class).user().n());
        Unit r7 = Unit.INSTANCE;
        r5.sendLog("livesdk_live_replay_is_auto_publish", r0, new Object[]{Room.class});
        return;
    L5:
        r6 = "0";
        goto L6
    }

    public static final void d(j r5, boolean r6) {
        r5.getClass();
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        HashMap r1 = new HashMap();
        if (r6 == false) goto L5;
        String r7 = "open";
    L6:
        r1.put("is_open", r7);
        r1.put("request_page", "live_room");
        Room r8 = r5.m;
        if (r8 != null) goto L9;
    L11:
        String r9 = "0";
    L12:
        r1.put("is_ecom", r9);
        Room r10 = r5.m;
        String r3 = null;
        if (r10 == null) goto L15;
        String r11 = r10.getOwnerUserIdString();
    L16:
        r1.put("anchor_id", String.valueOf(r11));
        r1.put("live_status_type", "live_on");
        Room r12 = r5.m;
        if (r12 == null) goto L19;
        r3 = r12.getIdStr();
    L19:
        r1.put("room_id", String.valueOf(r3));
        r1.put("_param_live_platform", "live");
        Unit r13 = Unit.INSTANCE;
        r0.sendLog("livesdk_click_explain_replay_toggle_button", r1, new Object[]{Room.class});
        return;
    L15:
        r11 = null;
        goto L16
    L9:
        if (r8.isHasCommerceGoods() != true) goto L11;
        r9 = "1";
        goto L12
    L5:
        r7 = "close";
        goto L6
    }

    public static final void e(j r6, boolean r7) {
        r6.getClass();
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        HashMap r1 = new HashMap();
        if (r7 == false) goto L5;
        String r2 = "open";
    L6:
        r1.put("is_open", r2);
        r1.put("request_page", "live_room");
        Room r3 = r6.m;
        if (r3 != null) goto L9;
    L11:
        String r4 = "0";
    L12:
        r1.put("is_ecom", r4);
        Room r5 = r6.m;
        String r8 = null;
        if (r5 == null) goto L15;
        String r9 = r5.getOwnerUserIdString();
    L16:
        r1.put("anchor_id", String.valueOf(r9));
        r1.put("live_status_type", "live_on");
        Room r10 = r6.m;
        if (r10 == null) goto L19;
        r8 = r10.getIdStr();
    L19:
        r1.put("room_id", String.valueOf(r8));
        r1.put("_param_live_platform", "live");
        if (r7 == false) goto L22;
        String r11 = "on";
    L23:
        r1.put("to_status", r11);
        Unit r12 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_record_status", r1, new Object[]{Room.class});
        return;
    L22:
        r11 = "off";
        goto L23
    L15:
        r9 = null;
        goto L16
    L9:
        if (r3.isHasCommerceGoods() != true) goto L11;
        r4 = "1";
        goto L12
    L5:
        r2 = "close";
        goto L6
    }

    public static final void b(final j r7, final boolean r8, Context r9) {
        r7.getClass();
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(r9);
        if (r0 == null) goto L10;
        int r10 = a0.a;
        Room r11 = r7.m;
        if (r11 == null) goto L7;
        long r2 = r11.id;
    L8:
        a0.c(r0, 0, r8, r2, new ECReplaySettingItem$doCheckStateChangedNew$$inlined$let$lambda$1(r7, r8), ECReplaySettingItem$doCheckStateChangedNew$1$2.INSTANCE);
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public j(final Context r3, ListDialogAbility r4, Function0 r5, LiveMode r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "ability");
        Intrinsics.checkNotNullParameter(r6, "liveMode");
        Intrinsics.checkNotNullParameter(r7, "anchorId");
        super(s1.B(2131919976), s1.B(2131914863));
        this.p = r4;
        this.q = r5;
        this.r = r7;
        Room r8 = null;
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L7;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L7;
        r8 = (Room) r10.getValue();
    L7:
        this.m = r8;
        this.n = LazyKt.lazy(new ECReplaySettingItem$mRealtimeTitleIntroduceDialog$2(r3));
        i r11 = new i(this);
        ReplayDetailSettingDialog r12 = new ReplayDetailSettingDialog(r3, m5.a(r6), r11);
        r12.B = new ECReplaySettingItem$playToggleAction$1(this);
        Function3<Boolean, Boolean, Context, Unit> r13 = new ECReplaySettingItem$replayActionEC$1(this);
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.C = r13;
        ECReplaySettingItem$supportActionEC$1 r14 = new ECReplaySettingItem$supportActionEC$1(this);
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r12.D = r14;
        ECReplaySettingItem$publishActionEC$1 r15 = new ECReplaySettingItem$publishActionEC$1(this);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r12.E = r15;
        ECReplaySettingItem$onRealTimePlaybackSwitch$1 r16 = ECReplaySettingItem$onRealTimePlaybackSwitch$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r12.F = r16;
        new ECReplaySettingItem$$special$$inlined$apply$lambda$1(this);
        Unit r17 = Unit.INSTANCE;
        this.o = r12;
        ((mx.b) this).l = new h(this, r3);
    }
}
