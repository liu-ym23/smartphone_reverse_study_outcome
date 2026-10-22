package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.broadcast.api.model.d1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/d1;", "it", "", "invoke", "(Lcom/bytedance/android/live/broadcast/api/model/d1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RecordReplayHighlightsSetting$doCheckStateChangedNew$1 extends Lambda implements Function1<d1, Unit> {
    final /* synthetic */ SwitchSettingViewHolder $holder;
    final /* synthetic */ boolean $newChecked;
    final /* synthetic */ Room $room;
    final /* synthetic */ x this$0;

    public RecordReplayHighlightsSetting$doCheckStateChangedNew$1(x r1, SwitchSettingViewHolder r2, boolean r3, Room r4) {
        this.this$0 = r1;
        this.$holder = r2;
        this.$newChecked = r3;
        this.$room = r4;
        super(1);
    }

    public final void invoke(d1 r19) {
        Intrinsics.checkNotNullParameter(r19, "it");
        int r2 = mx.l.o;
        mx.l.a.a(this.this$0, this.$holder, this.$newChecked);
        if (this.$newChecked == false) goto L5;
        f2.b(2131919683, 0);
    L5:
        IUserService r3 = jc1.k.f(IUserService.class);
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.user.f r4 = r3.user();
        if (r4 == null) goto L10;
        String r5 = r4.n();
    L11:
        com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
        HashMap r7 = new HashMap();
        String r8 = "open";
        if (this.$newChecked == false) goto L14;
        Object r9 = "open";
    L15:
        r7.put("is_open", r9);
        r7.put("request_page", "live_room");
        r7.put("live_status_type", "live_on");
        String r15 = "on";
        if (this.$newChecked == false) goto L18;
        Object r14 = "on";
    L19:
        r7.put("to_status", r14);
        r7.put("anchor_id", String.valueOf(r5));
        Room r10 = this.$room;
        if (r10 == null) goto L22;
        String r17 = r10.getIdStr();
    L23:
        r7.put("room_id", String.valueOf(r17));
        Unit r11 = Unit.INSTANCE;
        r6.sendLog("livesdk_live_record_status", r7, new Object[]{Room.class});
        x r12 = this.this$0;
        Pair[] r13 = new Pair[4];
        if (this.$newChecked == true) goto L27;
        r8 = "close";
    L27:
        r13[0] = TuplesKt.to("is_open", r8);
        r13[1] = TuplesKt.to("request_page", "live_room");
        r13[2] = TuplesKt.to("live_status_type", "live_on");
        if (this.$newChecked == true) goto L31;
        r15 = "off";
    L31:
        r13[3] = TuplesKt.to("to_status", r15);
        Map r16 = MapsKt.mapOf(r13);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r16, "map");
        ((com.bytedance.android.live.ui.s) r12).d.putAll(r16);
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.b.L0;
        Boolean r20 = Boolean.valueOf(r19.replayEnabled);
        r18.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r20);
        com.bytedance.android.livesdk.sharedpref.e r21 = com.bytedance.android.livesdk.sharedpref.b.N0;
        Boolean r22 = Boolean.valueOf(r19.replayAutoPost);
        r21.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r21, r22);
        com.bytedance.android.livesdk.sharedpref.e r23 = com.bytedance.android.livesdk.sharedpref.b.Q0;
        Boolean r24 = Boolean.valueOf(r19.replaySyncProduct);
        r23.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r23, r24);
        com.bytedance.android.livesdk.sharedpref.e r25 = com.bytedance.android.livesdk.sharedpref.b.M0;
        Boolean r26 = Boolean.valueOf(r19.realTimePlaybackEnable);
        r25.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r25, r26);
        if (this.this$0.s == true) goto L34;
    L36:
        this.this$0.r.refreshSettingItems();
        return;
    L34:
        if (r19.replayEnabled == true) goto L36;
        com.bytedance.android.livesdk.sharedpref.f.d(r21, Boolean.valueOf(r19.replayAutoPost));
        com.bytedance.android.livesdk.sharedpref.e r27 = com.bytedance.android.livesdk.sharedpref.b.O0;
        Boolean r1 = Boolean.valueOf(r19.replaySyncXitou);
        r27.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r27, r1);
        com.bytedance.android.livesdk.log.g r28 = com.bytedance.android.livesdk.log.u.l();
        HashMap r29 = new HashMap();
        r29.put("action_type", "0");
        r29.put("event_page", "live_take_page");
        r29.put("user_id", jc1.k.n(IUserService.class).user().n());
        r28.sendLog("livesdk_live_replay_is_auto_publish", r29, new Object[0]);
        goto L36
    L22:
        r17 = null;
        goto L23
    L18:
        r14 = "off";
        goto L19
    L14:
        r9 = "close";
    L10:
        r5 = null;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((d1) r1);
        return Unit.INSTANCE;
    }
}
