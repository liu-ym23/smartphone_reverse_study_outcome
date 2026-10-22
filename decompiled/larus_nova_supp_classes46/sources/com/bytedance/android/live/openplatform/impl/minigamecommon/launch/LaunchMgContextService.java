package com.bytedance.android.live.openplatform.impl.minigamecommon.launch;

import am2.x;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.ParticipateStatus;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.live.profit.lottery.t;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livehostapi.business.depend.openplatform.IAppStatusListener;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nr0.b;
import nr0.d;
import nr0.e;
import nr0.f;
import nr0.h;
import org.json.JSONException;
import org.json.JSONObject;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/launch/LaunchMgContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LaunchMgContextService extends OpenPlatformContextService {

    public static final class a implements IAppStatusListener {
        public final /* synthetic */ LaunchMgContextService a;
        public final /* synthetic */ Function1 b;

        public final void onScreenStateChange(int r1) {
        }

        public final void onAppExit() {
            Function1 r0 = this.b;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke("exit");
        L5:
            OpenPlatformContext r2 = this.a.getOpenPlatformContext();
            if (r2 == null) goto L10;
            ((MiniGameContext) r2).tryClearMiniGameInstance(MiniGameContext.StopType.ON_GAME_EXIT);
            h.e.b(this.a.getOpenPlatformContext().getContext());
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
        }

        public final void onLaunchFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "errMsg");
            Function1 r3 = this.b;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke("fail");
        L5:
            h.e.b(this.a.getOpenPlatformContext().getContext());
        }

        public final void onLaunchSuccess(MiniAppInstance r4) {
            Intrinsics.checkNotNullParameter(r4, "miniAppInstance");
            OpenPlatformContext r1 = this.a.getOpenPlatformContext();
            if (r1 == null) goto L22;
            ((MiniGameContext) r1).setMiniGameInstance(r4);
            Function1 r2 = this.b;
            if (r2 == null) goto L7;
            Unit r3 = (Unit) r2.invoke("success");
        L7:
            CompositeDisposable r5 = h.a;
            Intrinsics.checkNotNullParameter(r4, "miniAppInstance");
            h.a = new CompositeDisposable();
            i r0 = c.f();
            if (r0 == null) goto L19;
            g r6 = (g) r0.getCurrentLottery().getValue();
            if (r6 == null) goto L18;
            PublishSubject r7 = r6.a();
            if (r7 == null) goto L18;
            Observable r8 = r7.map(b.a);
            if (r8 == null) goto L18;
            Disposable r9 = r8.subscribe(nr0.c.a);
            if (r9 == null) goto L18;
            RxUtilKt.c(r9, h.a);
        L18:
            RxUtilKt.c(r0.getCurCandidateState().a().filter(new d(r0)).subscribe(new e(r0)), h.a);
            RxUtilKt.c(r0.getOnPopupSchemaFailed().onEvent().subscribe(f.a), h.a);
        L19:
            r4.registerEventListener("show_live_lottery_task", new nr0.g());
            return;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
        }

        public a(LaunchMgContextService r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public LaunchMgContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public Map<String, String> f(HashMap<String, String> r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = n.a;
        n.d(getOpenPlatformContext().getRoom(), r0);
        n.e(r0);
        String r2 = n.c();
        if (r2 == null) goto L5;
        String r3 = (String) r0.put("live_enter_from_merge", r2);
    L5:
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, getOpenPlatformContext().getDataCenter(), 0, 2);
        if (r4 == null) goto L10;
        com.bytedance.live.datacontext.i r5 = r4.getLiveMode();
        if (r5 == null) goto L10;
        LiveMode r6 = (LiveMode) r5.getValue();
    L11:
        int r8 = h1.a;
        r0.put("live_type", i1.a(r6));
        if (r7 == null) goto L14;
        r0.putAll(r7);
    L14:
        return r0;
    L10:
        r6 = null;
        goto L11
    }

    public Map<String, String> g(String r17) {
        Intrinsics.checkNotNullParameter(r17, "openSchema");
        LinkedHashMap r5 = new LinkedHashMap();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L100
        SchemaInfo.b r7 = SchemaInfo.s;     // Catch: Throwable -> L100
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L100
        Room r10 = getOpenPlatformContext().getRoom();     // Catch: Throwable -> L100
        String r11 = "";
        if (r10 == null) goto L8;
        String r12 = r10.buildPullUrl();     // Catch: Throwable -> L100
        if (r12 == null) goto L8;
    L9:
        r8.put("live_url", r12);     // Catch: Throwable -> L100
        Room r13 = getOpenPlatformContext().getRoom();     // Catch: Throwable -> L100
        if (r13 == null) goto L24;
        User r14 = r13.getOwner();     // Catch: Throwable -> L100
        if (r14 == null) goto L24;
        ImageModel r15 = r14.getAvatarThumb();     // Catch: Throwable -> L100
        if (r15 == null) goto L24;
        List r16 = r15.getUrls();     // Catch: Throwable -> L100
        if (r16 == null) goto L24;
        if ((!r16.isEmpty()) == true) goto L21;
        r16 = null;
    L21:
        if (r16 == null) goto L24;
        String r18 = (String) ListProtector.get(r16, 0);     // Catch: Throwable -> L100
        if (r18 == null) goto L24;
    L25:
        r8.put("live_user_avatar", r18);     // Catch: Throwable -> L100
        Room r19 = getOpenPlatformContext().getRoom();     // Catch: Throwable -> L100
        if (r19 == null) goto L33;
        User r110 = r19.getOwner();     // Catch: Throwable -> L100
        if (r110 == null) goto L33;
        String r111 = r110.getNickName();     // Catch: Throwable -> L100
        if (r111 == null) goto L33;
        r11 = r111;
    L33:
        r8.put("live_user_name", r11);     // Catch: Throwable -> L100
        Room r112 = getOpenPlatformContext().getRoom();     // Catch: Throwable -> L100
        if (r112 == null) goto L36;
        Long r113 = Long.valueOf(r112.getRoomId());     // Catch: Throwable -> L100
    L37:
        r8.put("room_id", r113);     // Catch: Throwable -> L100
        RoomContext r114 = RoomContext.a.c(RoomContext.Companion, getOpenPlatformContext().getDataCenter(), 0, 2);     // Catch: Throwable -> L100
        if (r114 == null) goto L42;
        com.bytedance.live.datacontext.i r115 = r114.getLiveMode();     // Catch: Throwable -> L100
        if (r115 == null) goto L42;
        LiveMode r116 = (LiveMode) r115.getValue();     // Catch: Throwable -> L100
    L43:
        int r117 = h1.a;     // Catch: Throwable -> L100
        r8.put("live_type", i1.a(r116));     // Catch: Throwable -> L100
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L100
        r7.getClass();     // Catch: Throwable -> L100
        r5.put("live_info", SchemaInfo.b.c(r8));     // Catch: Throwable -> L100
        i r20 = c.f();     // Catch: Throwable -> L100
        if (r20 == null) goto L80;
        com.bytedance.live.datacontext.n r21 = r20.getCurrentLottery();     // Catch: Throwable -> L100
        if (r21 == null) goto L80;
        g r22 = (g) r21.getValue();     // Catch: Throwable -> L100
        if (r22 == null) goto L80;
        t r23 = l.a(r22.getState());     // Catch: Throwable -> L100
        if (r23 == null) goto L80;
        if (r23.d != 52) goto L80;
        if ((r22.getState() instanceof LotteryState.g) == false) goto L80;
        JSONObject r24 = new JSONObject();     // Catch: Throwable -> L100
        t r118 = l.a(r22.getState());     // Catch: Throwable -> L100
        if (r118 == null) goto L58;
        Long r119 = Long.valueOf(r118.a);     // Catch: Throwable -> L100
    L59:
        r24.put("lottery_id", r119);     // Catch: Throwable -> L100
        t r120 = l.a(r22.getState());     // Catch: Throwable -> L100
        if (r120 == null) goto L62;
        Long r121 = Long.valueOf(r120.c);     // Catch: Throwable -> L100
    L63:
        r24.put("lottery_draw_time", r121);     // Catch: Throwable -> L100
        CompositeDisposable r122 = h.a;     // Catch: Throwable -> L100
        t r25 = l.a(r22.getState());     // Catch: Throwable -> L100
        if (r25 == null) goto L66;
        String r26 = r25.i;     // Catch: Throwable -> L100
    L67:
        Integer r27 = h.c(r26);     // Catch: Throwable -> L100
        if (r27 == null) goto L70;
        int r28 = r27.intValue();     // Catch: Throwable -> L100
    L71:
        r24.put("lottery_condition", r28 * 1000);     // Catch: Throwable -> L100
        i r29 = c.f();     // Catch: Throwable -> L100
        if (r29 == null) goto L78;
        m r30 = r29.getCurCandidateState();     // Catch: Throwable -> L100
        if (r30 == null) goto L78;
        ParticipateStatus r31 = (ParticipateStatus) r30.getValue();     // Catch: Throwable -> L100
        if (r31 == null) goto L78;
        Integer r32 = Integer.valueOf(r31.getStatus());     // Catch: Throwable -> L100
    L79:
        r24.put("lottery_state", r32);     // Catch: Throwable -> L100
        r5.put("lottery_info", SchemaInfo.b.c(r24));     // Catch: Throwable -> L100
    L78:
        r32 = null;
        goto L79
    L70:
        r28 = 0;
        goto L71
    L66:
        r26 = null;
        goto L67
    L62:
        r121 = null;
        goto L63
    L58:
        r119 = null;
    L80:
        SchemaInfo r33 = new SchemaInfo.a(r17).c();     // Catch: Throwable -> L100
        if (r33 == null) goto L95;
        String r34 = r33.c("launch_config");     // Catch: Throwable -> L100
        if (r34 == null) goto L95;
        JSONObject r35 = new JSONObject(r34);     // Catch: JSONException -> L93 Throwable -> L100
        JSONObject r36 = r35.optJSONObject("xscreen_config");     // Catch: JSONException -> L93 Throwable -> L100
        if (r36 == null) goto L95;
        double r37 = r36.optDouble("rate");     // Catch: JSONException -> L93 Throwable -> L100
        if (r37 > 0) goto L89;
    L91:
        r35.put("xscreen_config", r36);     // Catch: JSONException -> L93 Throwable -> L100
        r5.put("launch_config", SchemaInfo.b.c(r35));     // Catch: JSONException -> L93 Throwable -> L100
    L89:
        if (Intrinsics.areEqual(r33.d(), "smallrocker_exp") == false) goto L91;
        double r123 = ((double) s1.y()) * r37;     // Catch: JSONException -> L93 Throwable -> L100
        r36.put("rate", Float.valueOf(((float) r123) / (((s1.w() + x1.k()) - x1.j(getOpenPlatformContext().getContext())) - 10)));     // Catch: JSONException -> L93 Throwable -> L100
    L93:
        int r1 = qo0.a.a;     // Catch: Throwable -> L100
        qo0.a.b("LaunchMg", "insert launchConfig error, schema=" + r17, null);     // Catch: Throwable -> L100
    L95:
        if (zq0.b.a() == false) goto L97;
        String r2 = "1";
    L98:
        Result.constructor-impl((String) r5.put("is_multilink", r2));     // Catch: Throwable -> L100
    L102:
        return r5;
    L97:
        r2 = "0";
    L42:
        r116 = null;
        goto L43
    L36:
        r113 = null;
    L24:
        r18 = "";
    L8:
        r12 = "";
    L100:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L102
    }

    public final ko0.b h(MountedMiniGameSource r23, String r24, HashMap<String, String> r25) {
        Intrinsics.checkNotNullParameter(r23, "source");
        Intrinsics.checkNotNullParameter(r24, "schema");
        String r5 = null;
        if (r25 == null) goto L7;
        String r3 = r25.get("schema");
        if (r3 == null) goto L7;
        SchemaInfo r4 = new SchemaInfo.a(r3).c();
    L8:
        boolean r6 = false;
        if (r4 == null) goto L19;
        String r8 = r4.d;
        if (r8 == "UNINITIALIZED_STRING") goto L13;
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        r5 = r8;
    L16:
        if (r5 != null) goto L29;
        r5 = String.valueOf(r4.c("scene"));
        r4.d = r5;
    L29:
        if (am2.n.f().d().length() <= 0) goto L31;
        r6 = true;
    L31:
        if (r6 == false) goto L33;
        String r7 = "ad";
    L34:
        String r10 = r7;
        String r12 = "anchor_game_live_btn";
        if (r4 == null) goto L40;
        String r16 = r4.d();
        if (r16 == null) goto L40;
        String r11 = r16;
    L52:
        String r13 = n.c();
        if (r13 != null) goto L55;
        String r21 = "";
    L56:
        if (r4 == null) goto L61;
        String r14 = r4.d();
        if (r14 == null) goto L61;
        r12 = r14;
    L80:
        return new ko0.b(r5, r10, r11, "live", r21, r12, f(r25), null, g(r24), false, false, null, 15168);
    L61:
        int r15 = mr0.a.b[r23.ordinal()];
        if (r15 == 1) goto L77;
        if (r15 != 2) goto L65;
        String r17 = kr0.a.a("mg_card");
    L78:
        r12 = r17;
        goto L80
    L65:
        if (r15 == 3) goto L80;
        if (r15 != 4) goto L69;
        r12 = "anchor";
        goto L80
    L69:
        if (r15 == 5) goto L71;
        r17 = kr0.a.a("mg_detail");
        goto L78
    L71:
        if (r4 == null) goto L74;
        r17 = r4.d();
        if (r17 != null) goto L78;
    L74:
        r12 = "";
        goto L80
    L77:
        r17 = kr0.a.a("mg_link");
        goto L78
    L55:
        r21 = r13;
    L40:
        int r18 = mr0.a.a[r23.ordinal()];
        if (r18 == 1) goto L50;
        if (r18 == 2) goto L49;
        if (r18 != 3) goto L45;
        r11 = "anchor_game_live_btn";
        goto L52
    L45:
        if (r18 == 4) goto L47;
        String r19 = kr0.a.a("mg_detail");
    L51:
        r11 = r19;
        goto L52
    L47:
        r11 = "anchor";
        goto L52
    L49:
        r19 = kr0.a.a("mg_card");
        goto L51
    L50:
        r19 = kr0.a.a("mg_link");
        goto L51
    L33:
        r7 = "live";
        goto L34
    L13:
        r9 = false;
        goto L14
    L19:
        if (getOpenPlatformContext().isAnchor() == false) goto L22;
        r5 = LaunchParamConstant$Scene.a;
        goto L29
    L22:
        if (am2.n.f().d().length() <= 0) goto L24;
        boolean r20 = true;
    L25:
        if (r20 == false) goto L27;
        r5 = LaunchParamConstant$Scene.d;
        goto L29
    L27:
        r5 = LaunchParamConstant$Scene.b;
        goto L29
    L24:
        r20 = false;
    L7:
        r4 = null;
        goto L8
    }

    public final void i(String r9, ko0.b r10, Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "schema");
        Intrinsics.checkNotNullParameter(r10, "launchParams");
        IHostLiveOpenPlatform r0 = TTLiveSDK.hostService().hostOpenPlatform();
        SchemaInfo.a r1 = new SchemaInfo.a(r9);
        String r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "scene");
        r1.a.put("scene", r12);
        String r13 = r10.b;
        Intrinsics.checkNotNullParameter(r13, "launchFrom");
        r1.b("launch_from", r13);
        String r14 = r10.c;
        Intrinsics.checkNotNullParameter(r14, "location");
        r1.b("location", r14);
        r1.b("entrance_form", r10.d);
        r1.b("enter_from_merge", r10.e);
        r1.b("enter_position", r10.f);
        r1.b("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        int r15 = n.a;
        r1.b("live_enter_method", l0.a("enter_method", u.l().c(x.class)));
        r1.b("live_action_type", l0.a("action_type", u.l().c(x.class)));
        RoomContext.a r16 = RoomContext.Companion;
        RoomContext r6 = RoomContext.a.c(r16, null, 0, 3);
        if (r6 == null) goto L11;
        m r7 = r6.getEnterRoomParams();
        if (r7 == null) goto L11;
        Map r8 = (Map) r7.getValue();
        if (r8 == null) goto L11;
        String r17 = (String) r8.get("enter_from_uid_by_shared");
        if (r17 == null) goto L11;
        r1.b("from_user_id", r17);
    L11:
        RoomContext r18 = RoomContext.a.c(r16, null, 0, 3);
        if (r18 == null) goto L20;
        m r19 = r18.getEnterRoomParams();
        if (r19 == null) goto L20;
        Map r20 = (Map) r19.getValue();
        if (r20 == null) goto L20;
        String r21 = (String) r20.get("chat_type");
        if (r21 == null) goto L20;
        r1.b("chat_type", r21);
    L20:
        Iterator<Map.Entry<String, String>> r22 = r10.g.entrySet().iterator();
    L22:
        if (r22.hasNext() == false) goto L24;
        Map.Entry<String, String> r2 = r22.next();
        r1.b(r2.getKey(), r2.getValue());
        goto L22
    L24:
        Iterator<Map.Entry<String, String>> r23 = r10.j.entrySet().iterator();
    L26:
        if (r23.hasNext() == false) goto L28;
        Map.Entry<String, String> r110 = r23.next();
        r1.e(r110.getKey(), r110.getValue());
        goto L26
    L28:
        SchemaInfo r24 = r1.c();
        if (r24 == null) goto L32;
        String r25 = r24.h();
        if (r25 == null) goto L32;
    L33:
        r0.openMiniGame(r25, new a(this, r11));
        return;
    L32:
        r25 = "";
        goto L33
    }
}
