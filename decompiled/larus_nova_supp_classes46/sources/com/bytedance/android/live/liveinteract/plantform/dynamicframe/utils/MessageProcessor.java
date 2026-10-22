package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.base.model.message.w1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureState;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.r8;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/utils/MessageProcessor;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MessageProcessor implements vlc.l, Observer<KVData> {
    public boolean a;
    public boolean b;
    public final vlc.d c;
    public final DataCenter d;

    public final void b() {
        vlc.d r0 = this.c;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINK_ADVENTURE_MESSAGE.getKey(), this);
    L5:
        vlc.d r1 = this.c;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.LINKER.getKey(), this);
    L8:
        vlc.d r2 = this.c;
        if (r2 == null) goto L11;
        r2.addMessageListener(MessageType.CONTROL.getKey(), this);
    L11:
        DataCenter r3 = this.d;
        if (r3 == null) goto L14;
        r3.observe("cmd_anchor_broadcast_end", this);
    L14:
        DataCenter r4 = this.d;
        if (r4 == null) goto L17;
        r4.observe("cmd_finish_video_talk_room_result", this);
    L17:
        ALogger.e("MessageProcessor", "onCreate.addMessageListener:" + this);
    }

    public MessageProcessor(DataCenter r2) {
        this.d = r2;
        if (r2 == null) goto L5;
        vlc.d r3 = (vlc.d) r2.get("data_message_manager");
    L6:
        this.c = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r6 = r5.getKey();
    L6:
        if (r6 == null) goto L35;
        int r0 = r6.hashCode();
        if (r0 == (-1677062600)) goto L22;
        if (r0 == 819116313) goto L14;
        return;
    L14:
        if (r6.equals("cmd_finish_video_talk_room_result") == false) goto L30;
        ai0.e r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService();
        if (r7 == null) goto L31;
        ai0.c r8 = (ai0.c) r7;
        AdventureState r9 = r8.a(this.d);
        if (r9 == null) goto L37;
        this.a = true;
        a(r9, "chatroom_end");
        return;
    L37:
        return;
    L31:
        return;
    L30:
        return;
    L22:
        if (r6.equals("cmd_anchor_broadcast_end") == false) goto L33;
        ai0.e r10 = ((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService();
        if (r10 == null) goto L34;
        ai0.c r11 = (ai0.c) r10;
        AdventureState r12 = r11.a(this.d);
        if (r12 == null) goto L38;
        this.b = true;
        a(r12, "live_end");
        return;
    L38:
        return;
    L34:
        return;
    L33:
        return;
    L35:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onMessage(tlc.d r5) {
        ai0.e r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService();
        if (r0 == null) goto L19;
        ai0.c r1 = (ai0.c) r0;
        AdventureState r2 = r1.a(this.d);
        if (r2 != null) goto L8;
        return;
    L8:
        if ((r5 instanceof r8) == false) goto L20;
        StringBuilder r3 = new StringBuilder("onMessage.ILinkMicAdventureMessage:");
        r8 r6 = (r8) r5;
        r3.append(r6.getMsgType());
        ALogger.i("MessageProcessor", r3.toString());
        String r4 = jc1.k.n(IMiddlewareUserService.class).user().n();
        if (r6.getMsgType() != 2) goto L21;
        w1 r7 = r6.getFinishContent();
        if (r7 == null) goto L14;
        Long r8 = Long.valueOf(r7.getOperatorId());
    L16:
        if (Intrinsics.areEqual(String.valueOf(r8), r4) == false) goto L22;
        a(r2, "act");
        return;
    L22:
        return;
    L14:
        r8 = null;
        goto L16
    L21:
        return;
    L20:
        return;
    }

    public final void a(AdventureState r18, String r19) {
        com.bytedance.android.livesdk.chatroom.model.interact.h r1 = r18.adventureInfo;
        if (r1 == null) goto L60;
        com.bytedance.android.livesdk.chatroom.model.interact.i r2 = r1.getSettingContent();
        if (r2 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.model.interact.j r3 = r2.getCallStageInfo();
        List r4 = r2.getNormalStageInfoList();
        if (r4 == null) goto L10;
        CollectionsKt.removeAll(r4, MessageProcessor$onAdventureFinishMessage$1.INSTANCE);
    L10:
        LinkedHashMap r5 = new LinkedHashMap();
        String r6 = TalkRoomLogUtils.i;
        if (r6.length() != 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        String r8 = TalkRoomLogUtils.h;
    L17:
        r5.put("function_type", r8);
        if (r6.length() != 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L23;
        r6 = TalkRoomLogUtils.h;
    L23:
        r5.put("function_type2", r6);
        if (this.a == false) goto L26;
    L28:
        String r10 = "";
    L29:
        r5.put("request_page", r10);
        r5.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n().toString());
        if (gh0.a.d() == false) goto L32;
        String r11 = "anchor";
    L33:
        r5.put("user_type", r11);
        IInteractService r12 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r12 == null) goto L36;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r13 = r12.getLinkUserInfoCenter();
    L37:
        if (r13 == null) goto L41;
        List<T> r14 = r13.getOnlineUserList();
        if (r14 == 0) goto L41;
        int r15 = r14.size();
    L42:
        r5.put("user_cnt", String.valueOf(r15));
        if (r4 == null) goto L46;
        String r16 = CollectionsKt.joinToString$default(r4, ",", "[", "]", 0, null, MessageProcessor$onAdventureFinishMessage$4.INSTANCE, 24, null);
        if (r16 == null) goto L46;
    L47:
        r5.put("firework_score", r16);
        String r17 = "0";
        if (r3 == null) goto L51;
        String r20 = String.valueOf(r3.getStageLowerLimitScore());
        if (r20 == null) goto L51;
    L52:
        r5.put("call_score", r20);
        if (r3 == null) goto L58;
        String r21 = String.valueOf(r3.getStageCallDuration());
        if (r21 == null) goto L58;
        r17 = r21;
    L58:
        r5.put("call_setting_time", r17);
        r5.put("reason", r19);
        j0.l().sendLog("livesdk_room_meetgame_over", r5, new Object[]{IRoom.class, am2.x.class});
        return;
    L51:
        r20 = "0";
    L46:
        r16 = "[]";
    L41:
        r15 = 1;
        goto L42
    L36:
        r13 = null;
        goto L37
    L32:
        r11 = "admin";
        goto L33
    L26:
        if (this.b == true) goto L28;
        r10 = bi0.a.a;
        goto L29
    L20:
        r9 = false;
        goto L21
    L16:
        r8 = r6;
        goto L17
    L13:
        r7 = false;
        goto L14
    L61:
        return;
    }
}
