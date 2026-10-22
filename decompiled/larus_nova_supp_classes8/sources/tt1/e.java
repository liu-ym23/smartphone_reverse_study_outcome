package tt1;

import am2.x;
import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.net.URLEncoder;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r18, IBaseCallbackSchemaHandler.SchemaCallback r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "callback");
        HashMap r2 = com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS);
        String r3 = (String) r2.get("report_from_pre");
        if (r3 != null) goto L5;
        r3 = "16";
    L5:
        String r4 = (String) r2.get("report_from_label");
        if (r4 != null) goto L8;
        r4 = "16131";
    L8:
        String r5 = (String) r2.get("report_from_action");
        if (r5 != null) goto L11;
        r5 = "1613105";
    L11:
        DispatchLogUtil.a("invokeFollow start");
        HashMap r6 = new HashMap();
        RoomContext.a r7 = RoomContext.Companion;
        RoomContext r11 = RoomContext.a.c(r7, null, 0, 3);
        if (r11 == null) goto L67;
        com.bytedance.live.datacontext.m r12 = r11.getRoom();
        if (r12 == null) goto L67;
        Room r13 = (Room) r12.getValue();
        if (r13 == null) goto L67;
        com.bytedance.android.livesdk.log.filter.o r14 = u.l().c(x.class);
        if (r14.getMap().containsKey("enter_from_merge") == false) goto L21;
        String r15 = (String) r14.getMap().get("enter_from_merge");
    L23:
        if (r14.getMap().containsKey("enter_method") == false) goto L25;
        String r8 = (String) r14.getMap().get("enter_method");
    L27:
        if (r14.getMap().containsKey("action_type") == false) goto L29;
        String r9 = (String) r14.getMap().get("action_type");
    L31:
        if (r14.getMap().containsKey("video_id") == false) goto L33;
        String r16 = (String) r14.getMap().get("video_id");
    L35:
        if (tb1.c.a == false) goto L37;
        String r17 = k1.c();
    L38:
        r6.put("enter_from_merge", r17);
        r6.put("enter_method", r8);
        r6.put("action_type", r9);
        r6.put("request_page", "long_press");
        r6.put("to_user_id", r13.getOwnerUserIdString().toString());
        r6.put("event_page", "live_detail");
        r6.put("video_id", r16);
        String r10 = "0";
        if (jc1.k.n(IBroadcastService.class).isPlayingGame() == false) goto L41;
        Object r20 = "1";
    L42:
        r6.put("is_gaming", r20);
        LiveMode r21 = r13.getStreamType();
        int r110 = h1.a;
        r6.put("live_type", i1.a(r21));
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue() == false) goto L45;
        Object r22 = "1";
    L46:
        r6.put("is_screen_clear", r22);
        r6.putAll(h1.a(r13));
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r23 = AudienceGameContext.a.a();
        if (r23 == null) goto L51;
        com.bytedance.live.datacontext.n r24 = r23.getCurrentGame();
        if (r24 == null) goto L51;
        r r25 = (r) r24.getValue();
    L52:
        if (r25 == null) goto L54;
        Long r111 = Long.valueOf(r25.p());
    L55:
        r6.put("game_id", String.valueOf(r111));
        if (r25 == null) goto L58;
        String r26 = r25.q();
    L59:
        r6.put("game_name", String.valueOf(r26));
        r6.put("connection_type", jc1.k.n(IInteractService.class).getLinkConnectionType());
        r6.put("anchor_cnt", jc1.k.n(ILinkServiceExternal.class).getLinkAnchorCount());
        RoomContext r27 = RoomContext.a.c(r7, null, 0, 3);
        if (r27 == null) goto L66;
        com.bytedance.live.datacontext.m r28 = r27.isCleanMode();
        if (r28 == null) goto L66;
        if (((Boolean) r28.getValue()).booleanValue() != true) goto L66;
        r10 = "1";
    L66:
        r6.put("if_clear_mode", r10);
        com.bytedance.android.livesdk.log.filter.h.J(r6, FollowLog.Scene.LongPressPanel.getFollowEntrancePage(), "audience_to_anchor", "1");
        goto L67
    L58:
        r26 = null;
        goto L59
    L54:
        r111 = null;
    L51:
        r25 = null;
        goto L52
    L45:
        r22 = "0";
        goto L46
    L41:
        r20 = "0";
        goto L42
    L37:
        r17 = r15;
        goto L38
    L33:
        r16 = "";
        goto L35
    L29:
        r9 = "";
        goto L31
    L25:
        r8 = "";
        goto L27
    L21:
        r15 = "";
    L67:
        String r29 = URLEncoder.encode(com.bytedance.android.livesdk.jsbridge.methods.draft.m.a(r6));
        int r30 = com.bytedance.android.livesdk.dispatch.utils.f.a;
        com.bytedance.android.livesdk.dispatch.utils.f.a(r18, "User/follow", "report_from_pre=" + r3 + "&report_from_label=" + r4 + "&report_from_action=" + r5 + "&track_params=" + r29, r19);
    }

    public static void b(Context r13, IBaseCallbackSchemaHandler.SchemaCallback r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "callback");
        HashMap r0 = com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS);
        String r1 = (String) r0.get("report_from_pre");
        if (r1 != null) goto L5;
        r1 = "16";
    L5:
        String r2 = (String) r0.get("report_from_label");
        if (r2 != null) goto L8;
        r2 = "16131";
    L8:
        String r3 = (String) r0.get("report_from_action");
        if (r3 != null) goto L11;
        r3 = "1613105";
    L11:
        DispatchLogUtil.a("invokeUnfollow start");
        HashMap r4 = new HashMap();
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L33;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L33;
        Room r7 = (Room) r6.getValue();
        if (r7 == null) goto L33;
        com.bytedance.android.livesdk.log.filter.o r8 = u.l().c(x.class);
        String r9 = "";
        if (r8.getMap().containsKey("enter_from_merge") == false) goto L21;
        String r10 = (String) r8.getMap().get("enter_from_merge");
    L23:
        if (r8.getMap().containsKey("enter_method") == false) goto L25;
        String r11 = (String) r8.getMap().get("enter_method");
    L27:
        if (r8.getMap().containsKey("action_type") == false) goto L30;
        r9 = (String) r8.getMap().get("action_type");
    L30:
        if (tb1.c.a == false) goto L32;
        r10 = k1.c();
    L32:
        r4.put("enter_from_merge", r10);
        r4.put("enter_method", r11);
        r4.put("action_type", r9);
        r4.put("request_page", "long_press");
        r4.put("to_user_id", r7.getOwnerUserIdString().toString());
        r4.put("event_page", "live_detail");
        goto L33
    L25:
        r11 = "";
        goto L27
    L21:
        r10 = "";
    L33:
        String r12 = URLEncoder.encode(com.bytedance.android.livesdk.jsbridge.methods.draft.m.a(r4));
        int r15 = com.bytedance.android.livesdk.dispatch.utils.f.a;
        com.bytedance.android.livesdk.dispatch.utils.f.a(r13, "User/unfollow", "report_from_pre=" + r1 + "&report_from_label=" + r2 + "&report_from_action=" + r3 + "&track_params=" + r12, r14);
    }
}
