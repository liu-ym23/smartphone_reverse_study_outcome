package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.channel.receiver.helper.ImAlignHelper;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver;
import com.bytedance.android.live.broadcastgame.opengame.message.o0;
import com.bytedance.android.live.broadcastgame.opengame.network.outer.GamePlayApi;
import com.bytedance.android.live.broadcastgame.opengame.service.AudienceMiniGameIntroCardService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.event.d0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends OpenApiSupportPluginRuntime {
    public com.bytedance.android.live.broadcastgame.opengame.message.g v;
    public final a0 w;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ Map b;

        public b(d r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;     // Catch: Throwable -> L4
            com.bytedance.android.live.broadcastgame.opengame.q.f("AudiencePluginRuntime", new Object[]{"show plugin checked"});     // Catch: Throwable -> L4
            d.y(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r2) {
            com.bytedance.android.livesdk.event.z r3 = (com.bytedance.android.livesdk.event.z) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if ((r3.a instanceof d0) == true) goto L5;
        L7:
            return false;
        L5:
            if (r3.b == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.runtime.d$d, reason: collision with other inner class name */
    public static final class C0079d<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ long b;

        public C0079d(d r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r14) {
            com.bytedance.android.livesdk.event.z r15 = (com.bytedance.android.livesdk.event.z) r14;
            d r16 = this.a;
            String r0 = String.valueOf(this.b);
            r16.getClass();
            Map r17 = (Map) com.bytedance.android.livesdk.sharedpref.b.F2.getValue();
            Integer r4 = null;
            if (r17.size() >= 3) goto L5;
        L20:
            String r1 = (String) r17.get(r0);
            int r5 = 0;
            if (r1 != null) goto L29;
        L27:
            JSONObject r2 = new JSONObject();
            r2.put("count", r5 + 1);
            r2.put("timestamp", System.currentTimeMillis());
            Unit r3 = Unit.INSTANCE;
            r17.put(r0, r2.toString());
            com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.F2;
            r6.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r6, r17);
            return;
        L29:
            LiveSeiUtil.i.getClass();     // Catch: Exception -> L24
            r4 = Integer.valueOf(LiveSeiUtil.c(r1).optInt("count", 0));     // Catch: Exception -> L24
        L25:
            if (r4 == null) goto L27;
            r5 = r4.intValue();
            goto L27
        L5:
            if (r17.containsKey(r0) == true) goto L20;
            Iterator r7 = r17.entrySet().iterator();
            String r8 = null;
            long r9 = Long.MAX_VALUE;
        L8:
            if (r7.hasNext() == false) goto L18;
            Map.Entry r11 = (Map.Entry) r7.next();
            String r12 = (String) r11.getValue();
            if (r12 == null) goto L8;
            LiveSeiUtil.i.getClass();     // Catch: Exception -> L16
            long r13 = LiveSeiUtil.c(r12).optLong("timestamp");     // Catch: Exception -> L16
            if (r13 >= r9) goto L14;
            r8 = (String) r11.getKey();     // Catch: Exception -> L16
            r9 = r13;
        L14:
            Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L16
            goto L8
        L18:
            if (r9 == Long.MAX_VALUE) goto L20;
            r17.remove(r8);
            goto L20
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AudiencePluginRuntime", new Object[]{"ready to start, init audience open api"});
        k r1 = t();
        com.bytedance.android.live.broadcastgame.opengame.openapi.d r2 = new com.bytedance.android.live.broadcastgame.opengame.openapi.d(u(), w(), (CloudExecutor) this.p.getValue());
        v r3 = (v) r1;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "openApi");
        r3.b = r2;
        super.start();
        if (this.f == false) goto L11;
        Object r4 = u().n.get("is_debug");
        if ((r4 instanceof Boolean) == true) goto L8;
        r4 = null;
    L8:
        if (Intrinsics.areEqual((Boolean) r4, Boolean.TRUE) == false) goto L12;
        g(null);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        super.launch();
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r0 = AudienceGameContext.a.a();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r1 = r0.getGameIntroCardInfo();
        if (r1 == null) goto L11;
        com.bytedance.android.live.broadcastgame.api.openplatform.a r2 = (com.bytedance.android.live.broadcastgame.api.openplatform.a) r1.getValue();
        if (r2 == null) goto L12;
        z(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        super.stop();
        if (u().m() != PluginType.LYNX) goto L5;
    L6:
        AudienceMiniGameIntroCardService.a((AudienceMiniGameIntroCardService) u().o(AudienceMiniGameIntroCardService.class), false, true, 1);
    L7:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r0 = AudienceGameContext.a.a();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r1 = r0.getGameIntroCardInfo();
        if (r1 == null) goto L12;
        r1.setValue(null);
    L12:
        ((u10.e) w()).f();
        com.bytedance.android.live.broadcastgame.opengame.message.g r2 = this.v;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("gameMessageChannel");
    L15:
        r2.i.b();
        com.bytedance.android.live.broadcastgame.opengame.message.q r3 = r2.b;
        r3.b = null;
        r3.a = null;
        o0 r4 = r2.c;
        monitor-enter(r4);
        r4.a.clear();     // Catch: Throwable -> L21
        monitor-exit(r4);
        r2.g.b();
        r2.a.d();
        this.w.a(null);
        return;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (u().m() != PluginType.SONIC_GAME) goto L7;
        goto L6
    }

    public final void A(long r7) {
        com.bytedance.android.live.broadcastgame.opengame.message.g r0 = this.v;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gameMessageChannel");
    L5:
        Iterator r1 = ((ArrayList) r0.d).iterator();
    L7:
        if (r1.hasNext() == false) goto L17;
        ImAlignHelper r2 = (ImAlignHelper) ((BaseAnchorMessageReceiver) r1.next()).b.getValue();
        com.bytedance.android.live.broadcastgame.channel.receiver.helper.a r3 = (com.bytedance.android.live.broadcastgame.channel.receiver.helper.a) r2.b.getValue();
        if (r7 != 0) goto L11;
        r3.getClass();
    L13:
        if ((!((PriorityQueue) r2.c.getValue()).isEmpty()) == false) goto L7;
        ImAlignHelper.b r4 = (ImAlignHelper.b) ((PriorityQueue) r2.c.getValue()).peek();
        if (r4.a.a() > r7) goto L7;
        ((PriorityQueue) r2.c.getValue()).remove(r4);
        r2.a.removeCallbacks(r4);
        r2.d.invoke(r4.a);
        goto L13
    L11:
        r3.c = r7;
        r3.b = System.currentTimeMillis();
        goto L13
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.d(r2);
        if ((r2 instanceof com.bytedance.android.live.broadcastgame.api.openplatform.a) == false) goto L6;
        z(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void g(Map<String, String> r4) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AudiencePluginRuntime", new Object[]{"show plugin if boot info is not null, boot info: ", u().m.l});
        this.w.a(new b(this, r4));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime
    public void onEventEnter(y.b r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginEvent");
        super.onEventEnter(r2);
        if ((r2 instanceof y.b.a) == false) goto L9;
        a0 r3 = this.w;
        r3.b = true;
        Runnable r0 = r3.a;
        if (r0 == null) goto L7;
        r0.run();
    L7:
        r3.a(null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w
    public final PluginContext q(Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "params");
        Context r2 = getContext();
        DataCenter r3 = this.i;
        com.bytedance.android.live.broadcastgame.opengame.i r4 = this.l;
        com.bytedance.android.live.broadcastgame.opengame.message.g r6 = this.v;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("gameMessageChannel");
    L6:
        return new PluginContext(r2, r3, r4, this, r6, r(), r13, this.k, false, null);
    }

    public final void z(com.bytedance.android.live.broadcastgame.api.openplatform.a r8) {
        if (u().m() != PluginType.LYNX) goto L5;
    L6:
        Object r0 = u().m.k.get("OPEN_APP_ICON_URL");
        if ((r0 instanceof String) == true) goto L9;
        r0 = null;
    L9:
        String r1 = (String) r0;
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        String r2 = r1;
        if (r8.a == false) goto L15;
        ((AudienceMiniGameIntroCardService) u().o(AudienceMiniGameIntroCardService.class)).b(com.bytedance.android.live.broadcastgame.api.openplatform.a.a(r8, r2, u().m.c(), u().m.n, 0, 3829));
        return;
    L15:
        AudienceMiniGameIntroCardService.a((AudienceMiniGameIntroCardService) u().o(AudienceMiniGameIntroCardService.class), false, false, 3);
        return;
    L5:
        if (u().m() == PluginType.SONIC_GAME) goto L6;
    }

    public static final /* synthetic */ void y(d r0, Map r1) {
        super.g(r1);
    }

    public d(Context r11, long r12, DataCenter r13, com.bytedance.android.live.broadcastgame.opengame.f r14, com.bytedance.android.live.broadcastgame.opengame.i r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "gameIMManager");
        super(r11, r13, r12, false, r15, r14);
        this.w = new a0();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void e(String r21, PluginType r22, Map<String, ? extends Object> r23, boolean r24, r r25) {
        Intrinsics.checkNotNullParameter(r21, "schema");
        Intrinsics.checkNotNullParameter(r22, "pluginType");
        Intrinsics.checkNotNullParameter(r23, "params");
        Object r1 = r23.get(OpenPlatformBaseDebugger.APP_ID);
        Object r3 = null;
        if ((r1 instanceof String) == true) goto L5;
        r1 = null;
    L5:
        String r8 = (String) r1;
        if (r8 != null) goto L8;
        return;
    L8:
        Object r2 = r23.get("game_id");
        if ((r2 instanceof Long) == true) goto L11;
        r2 = null;
    L11:
        Long r4 = (Long) r2;
        if (r4 == null) goto L14;
        long r16 = r4.longValue();
    L15:
        Object r5 = r23.get("conn_id");
        if ((r5 instanceof Long) == true) goto L18;
        r5 = null;
    L18:
        Long r6 = (Long) r5;
        if (r6 == null) goto L21;
        long r7 = r6.longValue();
    L22:
        Object r9 = r23.get("app_version");
        if ((r9 instanceof String) == true) goto L25;
        r9 = null;
    L25:
        String r11 = (String) r9;
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        DataCenter r12 = this.i;
        Intrinsics.checkNotNull(r12);
        Room r15 = (Room) r12.get("data_room", new Room());
        Object r13 = r23.get("game");
        if ((r13 instanceof com.bytedance.android.live.broadcastgame.api.model.u) == false) goto L32;
        r3 = r13;
    L32:
        com.bytedance.android.live.broadcastgame.api.model.u r14 = (com.bytedance.android.live.broadcastgame.api.model.u) r3;
        if (r15.getRoomId() == 0) goto L35;
        this.v = new com.bytedance.android.live.broadcastgame.opengame.message.g(r8, r7, this.t, r15);
        Disposable r17 = xs2.b.a().b(com.bytedance.android.livesdk.event.z.class).filter(c.a).subscribe(new C0079d(this, r7));
        Intrinsics.checkNotNullParameter(r17, "$this$autoDispose");
        this.m.a(r17);
        this.e = r25;
        if (r14 == null) goto L43;
        r14.c();
    L43:
        x(r16, r8, r11, r21, r22, r23, r24);
        Disposable r0 = ((GamePlayApi) com.bytedance.android.live.network.c.b().e(GamePlayApi.class)).fetchCollectStatus(r8, Long.valueOf(r16)).subscribe(new e(this), f.a);
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.m.a(r0);
        return;
    L35:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L37;
        f2.c("room is null", 0);
    L37:
        if (r25 == null) goto L45;
        r25.p("room is null");
        return;
    L45:
        return;
    L21:
        r7 = -1;
        goto L22
    L14:
        r16 = 0;
        goto L15
    }
}
