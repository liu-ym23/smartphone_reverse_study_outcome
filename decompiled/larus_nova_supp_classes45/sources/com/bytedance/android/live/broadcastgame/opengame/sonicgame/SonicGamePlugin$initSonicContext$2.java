package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import android.view.ViewGroup;
import android.view.Window;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.api.interactgame.p;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.GameFpsMonitor;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.PerformanceChecker;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.je0;
import com.bytedance.android.livesdk.config.o41;
import com.bytedance.android.livesdk.config.ph1;
import com.bytedance.android.livesdk.config.r20;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/h;", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/opengame/panel/h;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class SonicGamePlugin$initSonicContext$2 extends Lambda implements Function1<com.bytedance.android.live.broadcastgame.opengame.panel.h, Unit> {
    final /* synthetic */ SonicGamePlugin this$0;

    public static final class a implements com.bytedance.bdp.live.livecontainer.sonicgame.b {
        public final /* synthetic */ SonicGamePlugin$initSonicContext$2 a;
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.opengame.panel.h b;
        public final /* synthetic */ p c;

        public final void b() {
            int r0 = q.a;
            q.f("SonicGamePlugin", new Object[]{"onFloatViewFirstFrame"});
        }

        public final void onFirstFrame() {
            int r0 = q.a;
            q.f("SonicGamePlugin", new Object[]{"receive first frame"});
            this.a.this$0.A = true;
            SonicGamePlugin r1 = this.a.this$0;
            if (r1.H == true) goto L17;
            r1.H = true;
            PluginContext r2 = r1.K;
            if (r2.m.g == false) goto L17;
            GameCastStrategy r3 = r2.h(true);
            if (r3 != GameCastStrategy.VIDEO_CHATROOM) goto L11;
            long r4 = ((ph1) je0.a.getValue()).a();
        L16:
            MainThreadPostUtils.c(new h(r1), r4);
            goto L17
        L11:
            if (r3 != GameCastStrategy.VIDEO_SINGLE) goto L13;
            Long r5 = Long.valueOf(((o41) r20.a.getValue()).a());
        L14:
            if (r5 == null) goto L17;
            r4 = r5.longValue();
            goto L16
        L13:
            r5 = null;
        L17:
            ((OpenPlatformMonitorService) this.a.this$0.K.o(OpenPlatformMonitorService.class)).e();
            ((GameFpsMonitor) ((PerformanceChecker) this.a.this$0.G.getValue()).a.getValue()).a();
        }

        public final void a(String r11, com.bytedance.bdp.live.livecontainer.sonicgame.h r12) {
            Intrinsics.checkNotNullParameter(r12, "instance");
            int r1 = q.a;
            q.f("SonicGamePlugin", new Object[]{"on launch success, appId: ", r11, ", get sonic instance: ", r12});
            this.a.this$0.B = "sonic_game_load_success";
            ((OpenPlatformMonitorService) this.a.this$0.K.o(OpenPlatformMonitorService.class)).a("ttlive_open_platform_resource_load", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, null, null).c();
            Function0<Unit> r13 = this.a.this$0.k;
            if (r13 == null) goto L5;
            Unit r14 = (Unit) r13.invoke();
        L5:
            UtilityKotlinExtentionsKt.s(0, false, false, new SonicGamePlugin$initSonicContext$2$1$onLoadSuccess$1(this), 7);
            SonicGamePlugin r15 = this.a.this$0;
            r15.t = null;
            r15.r = r12;
            r15.u(SonicGamePlugin.SonicState.RESUME, false);
            com.bytedance.android.live.broadcastgame.openplatform.miniapp.b r16 = this.a.this$0.u;
            r16.getClass();
            Intrinsics.checkNotNullParameter(r12, "gameInstance");
            t10.a r17 = r16.a;
            r17.getClass();
            Intrinsics.checkNotNullParameter(r12, "instance");
            r17.a = r12;
            r12.e(r17);
            p r18 = this.c;
            if (r18 == null) goto L9;
            r18.onSuccess();
            return;
        }

        public final void onFail(String r11, String r12) {
            int r0 = q.a;
            q.f("SonicGamePlugin", new Object[]{"on launch fail, appId: ", r11, ", error msg: ", r12});
            this.a.this$0.B = "sonic_game_load_fail";
            ((OpenPlatformMonitorService) this.a.this$0.K.o(OpenPlatformMonitorService.class)).a("ttlive_open_platform_resource_load", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, 1, r12).c();
            Function1<? super String, Unit> r1 = this.a.this$0.l;
            if (r1 == null) goto L8;
            StringBuilder r2 = new StringBuilder("launch fail, appId: ");
            if (r11 != null) goto L7;
            r11 = "null";
        L7:
            r2.append(r11);
            r2.append(", error msg: ");
            r2.append(r12);
            Unit r13 = (Unit) r1.invoke(r2.toString());
        L8:
            p r14 = this.c;
            if (r14 == null) goto L12;
            r14.onFail(new Throwable("load sonic plugin failed：" + r12));
            return;
        }

        public a(SonicGamePlugin$initSonicContext$2 r1, com.bytedance.android.live.broadcastgame.opengame.panel.h r2, p r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public SonicGamePlugin$initSonicContext$2(SonicGamePlugin r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.live.broadcastgame.opengame.panel.h r24) {
        Intrinsics.checkNotNullParameter(r24, "$receiver");
        int r2 = q.a;
        q.f("SonicGamePlugin", new Object[]{"with panel, open sonic"});
        ViewGroup r7 = r24.getContentView();
        if (r7 == null) goto L5;
        r7.removeAllViews();
    L5:
        CommercialService r3 = (CommercialService) this.this$0.K.o(CommercialService.class);
        PanelType r6 = PanelType.PANEL_TYPE_X_SCREEN;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.a = r6;
        q.f("SonicGamePlugin", new Object[]{"set panel type, type: " + r6});
        r24.r(r6);
        if (r7 != null) goto L11;
        q.f("SonicGamePlugin", new Object[]{"panel view is null"});
        Function1<? super String, Unit> r1 = this.this$0.l;
        if (r1 == null) goto L70;
        Unit r4 = (Unit) r1.invoke("panel view is null");
        return;
    L70:
        return;
    L11:
        Window r8 = r24.v0();
        if (r8 != null) goto L17;
        q.f("SonicGamePlugin", new Object[]{"panel window is null"});
        Function1<? super String, Unit> r5 = this.this$0.l;
        if (r5 == null) goto L71;
        Unit r9 = (Unit) r5.invoke("panel window is null");
        return;
    L71:
        return;
    L17:
        q.f("SonicGamePlugin", new Object[]{"get panel view and window, open sonic"});
        q.f("SonicGamePlugin", new Object[]{"is anchor: ", Boolean.valueOf(this.this$0.K.o), ", live start mode: ", Integer.valueOf(this.this$0.n())});
        boolean r11 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.profit.scoreboard.h r12 = com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class);
        PluginContext r13 = this.this$0.K;
        ViewGroup r14 = r12.G5(r13.m.i, r13.getContext());
        SonicGamePlugin r15 = this.this$0;
        boolean r16 = r15.F;
        if (r16 == false) goto L25;
        if (r14 != null) goto L25;
        p r17 = (p) r15.K.n.get("listener");
        if (r17 == null) goto L72;
        r17.onFail(new Throwable("load sonic plugin failed：floatView is null"));
        return;
    L72:
        return;
    L25:
        if (r16 == false) goto L47;
        int r18 = s1.f(118.0f);
        int r19 = s1.f(86.0f);
        PluginContext r21 = this.this$0.K;
        if (r21.o == true) goto L29;
    L32:
        int r110 = s1.y();
        int r111 = s1.f(484.0f);
        boolean r112 = true;
    L33:
        com.bytedance.android.live.profit.scoreboard.h r22 = com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class);
        PluginContext r23 = this.this$0.K;
        com.bytedance.bdp.live.livecontainer.sonicgame.k r25 = new com.bytedance.bdp.live.livecontainer.sonicgame.k(r7, r8, r22.G5(r23.m.i, r23.getContext()), r112, r110, r111, true, r18, r19, 28);
        ((na4.f) r25).c = this.this$0.K.getContext();
        Map r26 = ((na4.f) r25).a;
        JSONObject r27 = new JSONObject();
        r27.put("anchor", this.this$0.K.o);
        r27.put("startMode", this.this$0.n());
        r27.put("live_start_mode", this.this$0.n());
        Unit r28 = Unit.INSTANCE;
        r26.put("key_ext_config_json", r27);
        if (v.a() == true) goto L36;
    L38:
        boolean r29 = false;
    L39:
        r25.h = r29;
        if (r29 == false) goto L42;
    L45:
        boolean r31 = true;
    L46:
        r25.g = r31;
        com.bytedance.bdp.live.livecontainer.sonicgame.k r32 = r25;
    L61:
        LruCache r33 = LiveSchemaInfo.r;
        LiveSchemaInfo r34 = LiveSchemaInfo.c.a(this.this$0.s);
        if (r34 != null) goto L66;
        Function1<? super String, Unit> r35 = this.this$0.l;
        if (r35 == null) goto L73;
        Unit r36 = (Unit) r35.invoke("schema parse error");
        return;
    L73:
        return;
    L66:
        this.this$0.u(SonicGamePlugin.SonicState.DESTROY, false);
        p r37 = (p) this.this$0.K.n.get("listener");
        na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> r38 = this.this$0.x();
        if (r38 == null) goto L75;
        r38.c(r34, r32, new a(this, r24, r37));
        return;
    L75:
        return;
    L42:
        if (this.this$0.a != LaunchMode.FROM_PANEL) goto L45;
        r31 = false;
        goto L46
    L36:
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.t3.getValue(), Boolean.TRUE) == false) goto L38;
        r29 = true;
        goto L39
    L29:
        if (Intrinsics.areEqual(r21.m.k.get("launch_from"), "invite") == true) goto L32;
        r112 = false;
        r110 = 0;
        r111 = 0;
        goto L33
    L47:
        com.bytedance.bdp.live.livecontainer.sonicgame.k r39 = new com.bytedance.bdp.live.livecontainer.sonicgame.k(r7, r8, null, false, 0, 0, false, 0, 0, 4092);
        ((na4.f) r39).c = this.this$0.K.getContext();
        Map r41 = ((na4.f) r39).a;
        JSONObject r42 = new JSONObject();
        r42.put("anchor", this.this$0.K.o);
        r42.put("startMode", this.this$0.n());
        r42.put("live_start_mode", this.this$0.n());
        Unit r43 = Unit.INSTANCE;
        r41.put("key_ext_config_json", r42);
        if (v.a() == true) goto L50;
    L52:
        boolean r44 = false;
    L53:
        r39.h = r44;
        if (r44 == false) goto L56;
    L59:
        boolean r45 = true;
    L60:
        r39.g = r45;
        r32 = r39;
        goto L61
    L56:
        if (this.this$0.a != LaunchMode.FROM_PANEL) goto L59;
        r45 = false;
        goto L60
    L50:
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.t3.getValue(), Boolean.TRUE) == false) goto L52;
        r44 = true;
        goto L53
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.broadcastgame.opengame.panel.h) r1);
        return Unit.INSTANCE;
    }
}
