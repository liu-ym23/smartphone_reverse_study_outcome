package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.profit.scoreboard.LinkMode;
import com.bytedance.android.live.profit.scoreboard.m1;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b1 extends BaseOpenMethod<JSONObject> {

    public static final class a implements m1 {
        public final /* synthetic */ b1 a;

        public a(b1 r1) {
            this.a = r1;
        }

        public final void onSuccess(String r4) {
            Intrinsics.checkNotNullParameter(r4, "counterId");
            b1 r0 = this.a;
            JSONObject r1 = new JSONObject();
            r1.put("counter_id", r4);
            Unit r5 = Unit.INSTANCE;
            r0.r(r1);
            this.a.d.k.a();
        }

        public final void onFailed(int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMsg");
            BaseOpenMethod.p(this.a, r4, r5, null, 12);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "startCounter";
    }

    public b1(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r27, CallContext r28) {
        Intrinsics.checkNotNullParameter(r27, "params");
        Intrinsics.checkNotNullParameter(r28, "context");
        int r2 = r27.optInt("duration", 0);
        r27.optLong("other_room_id", 0);
        JSONObject r4 = r27.optJSONObject("counter_settings");
        String r12 = r27.optString("prev_counter_id", "0");
        int r1 = r27.optInt("link_mode", 0);
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L6;
        LinkMode r3 = LinkMode.UN_KNOW;
    L9:
        if (r4 == null) goto L11;
    L14:
        a r14 = new a(this);
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, this.d.i, 0, 2);
        if (r5 == null) goto L21;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L21;
        Room r7 = (Room) r6.getValue();
        if (r7 == null) goto L21;
        String r8 = r7.getOwnerUserIdString();
    L22:
        String r9 = jc1.k.n(IUserService.class).user().b().getIdString();
        if ((!Intrinsics.areEqual(jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource(), "accepted_tool_invited")) == false) goto L40;
        TrackMiniGameService.a r11 = TrackMiniGameService.g;
        String r13 = String.valueOf(this.d.m.a);
        boolean r15 = this.d.o;
        String r16 = String.valueOf(r8);
        String r17 = String.valueOf(this.d.m.h);
        PluginContext r18 = this.d;
        String r19 = r18.m.b(r18.o);
        String r21 = ((BootInfoService) this.d.o(BootInfoService.class)).e();
        PluginContext r22 = this.d;
        if (r22 == null) goto L29;
        com.bytedance.android.live.broadcastgame.opengame.t r23 = r22.m;
        if (r23 == null) goto L29;
        String r24 = r23.i;
    L30:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "roomId");
        Intrinsics.checkNotNullParameter(r16, "anchorId");
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r17, "gameId");
        Intrinsics.checkNotNullParameter(r19, "gameName");
        Intrinsics.checkNotNullParameter(r21, "gameCategory");
        if (Intrinsics.areEqual(jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource(), "accepted_tool_invited") == false) goto L33;
        String r25 = "invited";
    L34:
        String r26 = r25;
        com.bytedance.android.livesdk.log.g r29 = com.bytedance.android.livesdk.log.u.l();
        Boolean r210 = Boolean.valueOf(r15);
        boolean r31 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r32 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevLinkControlService();
        if (r32 == null) goto L37;
        Map<String, String> r211 = r32.h();
    L38:
        r29.sendLog("livesdk_game_half_screen_click", TrackMiniGameService.a.a(r16, r9, r17, r19, r21, r13, r210, r24, r26, r211), new Object[]{am2.x.class, Room.class});
        goto L40
    L37:
        r211 = null;
        goto L38
    L33:
        r25 = "self_start";
    L29:
        r24 = null;
    L40:
        if (r4 == 0) goto L43;
        com.bytedance.android.live.profit.scoreboard.c r33 = (com.bytedance.android.live.profit.scoreboard.c) GsonProtectorUtils.fromJson(GsonHelper.get(), r4.toString(), com.bytedance.android.live.profit.scoreboard.c.class);
        boolean r34 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class).S(this.d.m.i, r3, r2, r33, "0", r14);
    L43:
        if ((!Intrinsics.areEqual(r12, "0")) == false) goto L46;
        boolean r35 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class).S(this.d.m.i, LinkMode.UN_KNOW, r2, null, r12, r14);
        return;
    L46:
        return;
    L21:
        r8 = null;
        goto L22
    L11:
        if (Intrinsics.areEqual(r12, "0") == false) goto L14;
        BaseOpenMethod.p(this, -1, "counter_settings is null and prev_counter_id = 0", null, 12);
        return;
    L6:
        r3 = LinkMode.TWIN;
        goto L9
    L7:
        r3 = LinkMode.SINGlE;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
