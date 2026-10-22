package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.random.AbsRoomBattleRandonMatchVM;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ih0.h;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\"\u0010\u0011\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/dynamic/DynamicRoomBattleRandomMatchVM;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/random/AbsRoomBattleRandonMatchVM;", "", "onMatchStart", "", "from", "onMatchEnd", "", "isMatching", "operatorUserId", "onGetMatchInfo", "Lcom/google/gson/JsonObject;", "updateExtraInfo", "Lih0/h;", "updateCallback", "handleLynxCmd", "onDestroy", "mIsMatching", "Z", "getMIsMatching$liveinteract_impl_saasRelease", "()Z", "setMIsMatching$liveinteract_impl_saasRelease", "(Z)V", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", PbRequest.SwitchType.ROOM, "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicRoomBattleRandomMatchVM extends AbsRoomBattleRandonMatchVM {
    private final DataCenter dataCenter;
    private boolean mIsMatching;
    private final IRoom room;

    private final void onMatchStart() {
        if (this.mIsMatching == true) goto L35;
        DataCenter r1 = this.dataCenter;
        if (r1 == null) goto L7;
        r1.put("cmd_show_self_waiting_behavior", MapsKt.mapOf(new Pair[]{TuplesKt.to("play_mode", "room_battle"), TuplesKt.to("ringing", Boolean.TRUE)}));
    L7:
        int r2 = com.bytedance.android.live.liveinteract.e.a;
        pp1.c r15 = new pp1.c("跨房匹配中", null, com.bytedance.android.live.liveinteract.e.a(0, null).toString(), 10, null, null, 1, (int) 14, null, 0, 7986);
        DataCenter r3 = this.dataCenter;
        if (r3 == null) goto L12;
        Boolean r4 = (Boolean) r3.get("cmd_multi_scene_game_behavior_shown");
        if (r4 == null) goto L12;
        boolean r5 = r4.booleanValue();
    L13:
        DataCenter r6 = this.dataCenter;
        if (r6 == null) goto L18;
        Boolean r7 = (Boolean) r6.get("cmd_multi_interact_behavior_shown");
        if (r7 == null) goto L18;
        boolean r16 = r7.booleanValue();
    L19:
        DataCenter r8 = this.dataCenter;
        if (r8 == null) goto L24;
        Boolean r9 = (Boolean) r8.get("cmd_multi_room_link_behavior_shown");
        if (r9 == null) goto L24;
        r9.booleanValue();
    L24:
        if (r5 == false) goto L28;
        DataCenter r10 = this.dataCenter;
        if (r10 == null) goto L35;
        r10.put("cmd_show_self_bubble_on_scene_game", r15);
        goto L35
    L28:
        if (r16 == false) goto L32;
        DataCenter r11 = this.dataCenter;
        if (r11 == null) goto L35;
        r11.put("cmd_show_self_bubble_on_openplatform_behavior", r15);
        goto L35
    L32:
        DataCenter r12 = this.dataCenter;
        if (r12 == null) goto L35;
        r12.put("cmd_show_self_bubble_on_more", r15);
    L18:
        r16 = false;
    L12:
        r5 = false;
    L35:
        this.mIsMatching = true;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.random.AbsRoomBattleRandonMatchVM
    public void onDestroy() {
        onMatchEnd("onDestroy");
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final boolean getMIsMatching$liveinteract_impl_saasRelease() {
        return this.mIsMatching;
    }

    public final IRoom getRoom() {
        return this.room;
    }

    private final void onMatchEnd(String r5) {
        ALogger.i("DynamicRoomBattleRandomMatchVM", "onMatchEnd from: " + r5);
        DataCenter r6 = this.dataCenter;
        if (r6 == null) goto L5;
        r6.put("cmd_show_self_waiting_behavior", MapsKt.mapOf(new Pair[]{TuplesKt.to("play_mode", "room_battle"), TuplesKt.to("ringing", Boolean.FALSE)}));
    L5:
        this.mIsMatching = false;
    }

    public final void setMIsMatching$liveinteract_impl_saasRelease(boolean r1) {
        this.mIsMatching = r1;
    }

    public DynamicRoomBattleRandomMatchVM(DataCenter r1, IRoom r2) {
        this.dataCenter = r1;
        this.room = r2;
    }

    private final void onGetMatchInfo(boolean r4, String r5) {
        this.mIsMatching = r4;
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L8;
        String r2 = r1.n();
        if (r2 == null) goto L8;
    L9:
        if (r4 == true) goto L11;
    L12:
        DataCenter r6 = this.dataCenter;
        if (r6 == null) goto L17;
        r6.put("cmd_show_self_waiting_behavior", MapsKt.mapOf(new Pair[]{TuplesKt.to("play_mode", "room_battle"), TuplesKt.to("ringing", Boolean.valueOf(r4))}));
        return;
    L17:
        return;
    L11:
        if (Intrinsics.areEqual(r2, r5) == true) goto L12;
        return;
    L8:
        r2 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.random.AbsRoomBattleRandonMatchVM
    public void handleLynxCmd(JsonObject r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "updateExtraInfo");
        JsonElement r0 = r3.get("type");
        if (r0 == null) goto L5;
        String r1 = r0.getAsString();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        switch(r1.hashCode()) {
            case -1529565272: goto L53;
            case -1326754011: goto L48;
            case -563217108: goto L45;
            case -302323862: goto L42;
            case -282943616: goto L39;
            case -27011313: goto L36;
            case 645106545: goto L24;
            case 675037128: goto L21;
            case 781465000: goto L18;
            case 1277826251: goto L15;
            case 1945793889: goto L12;
            default: goto L72;
        };
    L72:
        return;
    L12:
        if (r1.equals("end_match") == false) goto L56;
        onMatchEnd("handleLynxCmd");
        return;
    L56:
        return;
    L15:
        if (r1.equals("result_invite_cross_room_link") == false) goto L58;
    L49:
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r2 = LinkRoomFightContext.Companion.a();
        if (r2 == null) goto L68;
        r2.Ui(r1, r3, r4);
        return;
    L68:
        return;
    L58:
        return;
    L18:
        if (r1.equals("result_reply_cross_room_link") == true) goto L49;
        return;
    L21:
        if (r1.equals("result_invite_room_battle") == true) goto L49;
        return;
    L24:
        if (r1.equals("get_match_info") == false) goto L61;
        JsonElement r5 = r3.get("isMatching");
        if (r5 == null) goto L28;
        boolean r6 = r5.getAsBoolean();
    L29:
        JsonElement r7 = r3.get("operatorUserId");
        if (r7 == null) goto L33;
        String r8 = r7.getAsString();
        if (r8 == null) goto L33;
    L34:
        onGetMatchInfo(r6, r8);
        return;
    L33:
        r8 = "";
        goto L34
    L28:
        r6 = false;
        goto L29
    L61:
        return;
    L36:
        if (r1.equals("show_feedback_reply_room_battle") == true) goto L49;
        return;
    L39:
        if (r1.equals("check_invite_cross_room_link") == true) goto L49;
        return;
    L42:
        if (r1.equals("lifecycle") == true) goto L49;
        return;
    L45:
        if (r1.equals("result_cancel_invite_cross_room_link") == true) goto L49;
        return;
    L48:
        if (r1.equals("result_reply_room_battle") == true) goto L49;
        return;
    L53:
        if (r1.equals("start_match") == false) goto L70;
        onMatchStart();
        return;
    L70:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void onMatchEnd$default(DynamicRoomBattleRandomMatchVM r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onMatchEnd(r1);
    }
}
