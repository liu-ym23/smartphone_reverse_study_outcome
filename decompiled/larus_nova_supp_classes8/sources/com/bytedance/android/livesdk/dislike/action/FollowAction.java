package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.config.sr;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FollowAction extends OptionAction {
    public final ActionsManager e;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.g.c;
    }

    public FollowAction(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "v");
        if (com.bytedance.android.livesdk.dispatch.utils.a.a() == false) goto L5;
        Lazy r12 = DispatchLogUtil.a;
        DispatchLogUtil.d(0, DispatchLogUtil.InstanceType.FOLLOW);
        xs2.b.a().post(new mt1.a(0, this.b, this.e.e, null, true, 8));
        return;
    L5:
        xs2.b.a().post(new mt1.a(0, this.b, this.e.e, null, false, 24));
        com.bytedance.android.livesdk.log.filter.o r13 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r3 = "";
        if (r13.getMap().containsKey("enter_from_merge") == false) goto L8;
        String r1 = (String) r13.getMap().get("enter_from_merge");
    L10:
        if (r13.getMap().containsKey("enter_method") == false) goto L12;
        String r4 = (String) r13.getMap().get("enter_method");
    L14:
        if (r13.getMap().containsKey("action_type") == false) goto L16;
        String r6 = (String) r13.getMap().get("action_type");
    L18:
        if (r13.getMap().containsKey("video_id") == false) goto L21;
        r3 = (String) r13.getMap().get("video_id");
    L21:
        if (tb1.c.a == false) goto L23;
        r1 = k1.c();
    L23:
        HashMap r14 = new HashMap();
        r14.put("enter_from_merge", r1);
        r14.put("enter_method", r4);
        r14.put("action_type", r6);
        r14.put("request_page", "long_press");
        Room r2 = this.b;
        if (r2 == null) goto L26;
        String r5 = r2.getOwnerUserIdString();
    L27:
        r14.put("to_user_id", String.valueOf(r5));
        r14.put("event_page", "live_detail");
        r14.put("video_id", r3);
        String r7 = "0";
        if (jc1.k.n(IBroadcastService.class).isPlayingGame() == false) goto L30;
        Object r8 = "1";
    L31:
        r14.put("is_gaming", r8);
        Room r9 = this.b;
        if (r9 == null) goto L34;
        LiveMode r10 = r9.getStreamType();
    L35:
        int r15 = h1.a;
        r14.put("live_type", i1.a(r10));
        r14.put("is_vr_machine", VrUtils.o(this.e.f));
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue() == false) goto L38;
        Object r16 = "1";
    L39:
        r14.put("is_screen_clear", r16);
        r14.putAll(h1.a(this.b));
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r17 = AudienceGameContext.a.a();
        if (r17 == null) goto L44;
        com.bytedance.live.datacontext.n r18 = r17.getCurrentGame();
        if (r18 == null) goto L44;
        com.bytedance.android.live.broadcastgame.api.model.r r19 = (com.bytedance.android.live.broadcastgame.api.model.r) r18.getValue();
    L45:
        if (r19 == null) goto L47;
        Long r20 = Long.valueOf(r19.p());
    L48:
        r14.put("game_id", String.valueOf(r20));
        if (r19 == null) goto L51;
        String r21 = r19.q();
    L52:
        r14.put("game_name", String.valueOf(r21));
        r14.put("connection_type", jc1.k.n(IInteractService.class).getLinkConnectionType());
        r14.put("anchor_cnt", jc1.k.n(ILinkServiceExternal.class).getLinkAnchorCount());
        RoomContext r22 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r22 == null) goto L59;
        com.bytedance.live.datacontext.m r23 = r22.isCleanMode();
        if (r23 == null) goto L59;
        if (((Boolean) r23.getValue()).booleanValue() != true) goto L59;
        r7 = "1";
    L59:
        r14.put("if_clear_mode", r7);
        com.bytedance.android.livesdk.log.filter.h.J(r14, FollowLog.Scene.LongPressPanel.getFollowEntrancePage(), "audience_to_anchor", "1");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_follow", r14, new Object[]{am2.x.class, Room.class, am2.n.f(), am2.q.class});
        return;
    L51:
        r21 = null;
        goto L52
    L47:
        r20 = null;
    L44:
        r19 = null;
        goto L45
    L38:
        r16 = "0";
        goto L39
    L34:
        r10 = null;
        goto L35
    L30:
        r8 = "0";
        goto L31
    L26:
        r5 = null;
        goto L27
    L16:
        r6 = "";
        goto L18
    L12:
        r4 = "";
        goto L14
    L8:
        r1 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void d(Function1<? super Map<String, ? extends Object>, Unit> r4) {
        if (sr.a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        Room r0 = this.b;
        if (r0 == null) goto L8;
        User r1 = r0.getOwner();
    L9:
        com.bytedance.android.live.room.api.follow.b.c(r1, "FollowAction-onShow", this.b, new FollowAction$onShow$1(this, r4));
        return;
    L8:
        r1 = null;
        goto L9
    }
}
