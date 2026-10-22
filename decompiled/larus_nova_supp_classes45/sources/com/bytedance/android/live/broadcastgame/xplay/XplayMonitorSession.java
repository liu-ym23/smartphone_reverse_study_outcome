package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayMonitorSession implements com.bytedance.android.scope.o {
    public static final Regex f = null;
    public long a;
    public Boolean b;
    public int c;
    public final Map<String, Long> d;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p e;

    public static final class Companion {
        public Companion() {
        }

        public static void c(k1 r1, final XplayMonitorSession r2) {
            Intrinsics.checkNotNullParameter(r1, "$this$monitorTaskDuration");
            Intrinsics.checkNotNullParameter(r2, "session");
            Function2<l1, m1.b, Unit> r0 = new XplayMonitorSession$Companion$monitorTaskDuration$1(r2);
            Intrinsics.checkNotNullParameter(r1, "$this$onComplete");
            Intrinsics.checkNotNullParameter(r0, "callback");
            r1.c(new XplayTasksDslKt$onComplete$1(r0));
        }

        public static /* synthetic */ void b(String r1, JSONObject r2, JSONObject r3) {
            a(r1, r2, new JSONObject(), r3);
        }

        public static void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
            int r0 = XplayLog.a;
            XplayLog.c("XplayMonitorSession", r2 + ": " + r3 + ' ' + r4 + ' ' + r5);
        L5:
            LiveTracingMonitor.f(r2, LiveTracingMonitor.EventModule.XPLAY, r3, r4, r5);
        }
    }

    public final void onStop() {
    }

    static {
        new Companion();
        f = new Regex("[^_0-9a-zA-Z]");
    }

    public final void onStart() {
        this.a = System.currentTimeMillis();
    }

    public XplayMonitorSession(com.bytedance.android.live.broadcastgame.api.xplay.p r2) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        this.e = r2;
        this.d = new LinkedHashMap();
    }

    public final void a(JSONObject r4) {
        r4.put(OpenPlatformBaseDebugger.APP_ID, this.e.h.b);
        com.bytedance.android.live.broadcastgame.api.model.q0 r0 = this.e.h.l;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.c();
        if (r2 == null) goto L6;
    L7:
        r4.put("game_id", r2);
        com.bytedance.android.live.broadcastgame.api.model.q0 r3 = this.e.h.l;
        if (r3 == null) goto L11;
        String r5 = r3.b();
        if (r5 == null) goto L11;
    L12:
        r4.put("channel", r5);
        String r6 = this.e.c;
        if (r6 == null) goto L16;
        r1 = r6;
    L16:
        r4.put("anchor_id", r1);
        r4.put("game_name", this.e.h.c);
        r4.put("scene_type", String.valueOf(this.e.f.getSceneId()));
        if (this.e.d == false) goto L19;
        String r7 = "anchor";
    L20:
        r4.put("launch_from", r7);
        r4.put("is_xplay", 1);
        r4.put("game_category", "barrage");
        r4.put("app_version", this.e.h.i);
        return;
    L19:
        r7 = "audience";
    L11:
        r5 = "";
    L6:
        r2 = "";
        goto L7
    }

    public final void d(Throwable r7) {
        Intrinsics.checkNotNullParameter(r7, "throwable");
        if (this.b == null) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - this.a;
        if ((r7 instanceof XplayException) == false) goto L8;
        XplayException r8 = (XplayException) r7;
        k(r0, 0, r8.getErrorInfo());
        c("xplay_exception", r8.getErrorInfo().a(), r8.getErrorInfo().b());
        return;
    L8:
        k(r0, 0, q.a.c(q.c, null, r7, 3));
        int r1 = com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r7);
        String r9 = com.bytedance.android.livesdk.utils.o1.a(r7);
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        c("launch_throwable", r1, r9);
    }

    public final void h(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("status", r3);
        a(r0);
        Unit r4 = Unit.INSTANCE;
        JSONObject r5 = new JSONObject();
        a(r5);
        Companion.b("ttlive_xplay_continue_play", r0, r5);
    }

    public final void i(int r13, int r14) {
        JSONObject r0 = new JSONObject();
        r0.put("status", 0);
        r0.put("code", r13);
        r0.put("reason", r14);
        a(r0);
        Unit r1 = Unit.INSTANCE;
        JSONObject r2 = new JSONObject();
        a(r2);
        Companion.b("ttlive_xplay_force_stop", r0, r2);
        n("xplayForceStop", r13, "code: " + r13 + ", reason: " + r14);
        if (this.e.f != XplayScene.TalkRoom) goto L10;
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.l r4 = r3.getLinkMicGameFullLinkMonitor();
        if (r4 == null) goto L12;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r4, LinkMonitorData.XplayForceStop, null, null, r13, Integer.valueOf(r14), null, null, null, null, 486);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(int r5, q r6) {
        com.bytedance.android.live.broadcastgame.api.xplay.p r0 = this.e;
        if (r0 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.xplay.s r1 = r0.j;
        if (r1 == null) goto L9;
        if (r1.g != true) goto L9;
        String r2 = "pod_merge";
    L10:
        JSONObject r3 = new JSONObject();
        r3.put("status", r5);
        r3.put("merge_type", r2);
        String r7 = null;
        if (r6 == null) goto L13;
        Integer r4 = Integer.valueOf(r6.a());
    L14:
        r3.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r4);
        if (r6 == null) goto L19;
        ErrorCodeException r8 = r6.b;
        if (r8 == null) goto L19;
        Integer r9 = Integer.valueOf(r8.getCode());
    L20:
        r3.put("cause_error_code", r9);
        a(r3);
        Unit r11 = Unit.INSTANCE;
        JSONObject r12 = new JSONObject();
        a(r12);
        if (r6 == null) goto L23;
        String r13 = r6.b();
    L24:
        r12.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r13);
        if (r6 == null) goto L29;
        ErrorCodeException r14 = r6.b;
        if (r14 == null) goto L29;
        String r15 = r14.getMsg();
    L30:
        r12.put("cause_error_msg", r15);
        Map.Entry r16 = (Map.Entry) CollectionsKt.lastOrNull(((LinkedHashMap) this.d).entrySet());
        if (r16 == null) goto L33;
        r7 = (String) r16.getKey();
    L33:
        if (r7 != null) goto L35;
        r7 = "";
    L35:
        r12.put("last_completed_task", r7);
        Companion.b("ttlive_xplay_server_merge_start", r3, r12);
        return;
    L29:
        r15 = null;
        goto L30
    L23:
        r13 = null;
    L19:
        r9 = null;
        goto L20
    L13:
        r4 = null;
    L9:
        r2 = "rtc_merge";
        goto L10
    }

    public final void c(String r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "failReason");
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        com.bytedance.android.live.broadcastgame.api.xplay.p r0 = this.e;
        if (r0.f == XplayScene.TalkRoom) goto L5;
        return;
    L5:
        if (r0.d == false) goto L18;
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.m r2 = r1.getLinkMicGameLogUtils();
        if (r2 == null) goto L11;
        r2.f(false, r4, String.valueOf(r5), r6);
    L11:
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L19;
        com.bytedance.android.live.liveinteract.utils.n r7 = r3.getLinkMicGameTraceUtils();
        if (r7 == null) goto L20;
        r7.a(this.e.d, r4, r5, r6);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void g(int r7, int r8, String r9) {
        JSONObject r0 = new JSONObject();
        r0.put("status", r7);
        r0.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r8);
        a(r0);
        Unit r3 = Unit.INSTANCE;
        JSONObject r4 = new JSONObject();
        a(r4);
        r4.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r9);
        Companion.b("ttlive_open_platform_app_start", r0, r4);
        JSONObject r1 = new JSONObject();
        r1.put("status", r7);
        r1.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r8);
        r1.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r9);
        n("appStartApi", r8, r1.toString());
    }

    public final void k(long r28, int r31, q r32) {
        JSONObject r5 = new JSONObject();
        r5.put("status", r31);
        if (r32 == null) goto L5;
        Integer r8 = Integer.valueOf(r32.a());
    L6:
        r5.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r8);
        if (r32 == null) goto L11;
        ErrorCodeException r9 = r32.b;
        if (r9 == null) goto L11;
        Integer r11 = Integer.valueOf(r9.getCode());
    L12:
        r5.put("cause_error_code", r11);
        a(r5);
        Unit r12 = Unit.INSTANCE;
        JSONObject r13 = new JSONObject();
        r13.put("duration", r28);
        r13.put("retry_count", this.c);
        JSONObject r14 = new JSONObject();
        a(r14);
        if (r32 == null) goto L15;
        String r15 = r32.b();
    L16:
        r14.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r15);
        if (r32 == null) goto L21;
        ErrorCodeException r16 = r32.b;
        if (r16 == null) goto L21;
        String r17 = r16.getMsg();
    L22:
        r14.put("cause_error_msg", r17);
        Map.Entry r7 = (Map.Entry) CollectionsKt.lastOrNull(((LinkedHashMap) this.d).entrySet());
        if (r7 == null) goto L25;
        String r18 = (String) r7.getKey();
    L27:
        if (r18 != null) goto L29;
        r18 = "";
        String r19 = r18;
    L30:
        r14.put("last_completed_task", r18);
        Companion.a("ttlive_xplay_start", r5, r13, r14);
        int r6 = 0;
        if (r31 != 1) goto L33;
        int r21 = 0;
    L34:
        JSONObject r110 = new JSONObject();
        r110.put("status", r31);
        if (r32 == null) goto L37;
        Integer r22 = Integer.valueOf(r32.a());
    L38:
        r110.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r22);
        if (r32 == null) goto L41;
        String r23 = r32.b();
    L42:
        r110.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r23);
        if (r32 == null) goto L47;
        ErrorCodeException r24 = r32.b;
        if (r24 == null) goto L47;
        Integer r25 = Integer.valueOf(r24.getCode());
    L48:
        r110.put("cause_error_code", r25);
        r110.put("duration", r28);
        r110.put("retry_count", this.c);
        Map.Entry r26 = (Map.Entry) CollectionsKt.lastOrNull(((LinkedHashMap) this.d).entrySet());
        if (r26 == null) goto L51;
        String r27 = (String) r26.getKey();
    L52:
        if (r27 != null) goto L54;
        r27 = r19;
    L54:
        r110.put("last_completed_task", r27);
        a(r110);
        n("xplayStart", r21, r110.toString());
        if (this.e.f != XplayScene.TalkRoom) goto L101;
        HashMap r29 = new HashMap();
        r29.put("xplay_duration", Long.valueOf(r28));
        Iterator r1 = ((LinkedHashMap) this.d).entrySet().iterator();
    L58:
        if (r1.hasNext() == false) goto L60;
        Map.Entry r2 = (Map.Entry) r1.next();
        r29.put(((String) r2.getKey()) + "_duration", Long.valueOf(((Number) r2.getValue()).longValue()));
        goto L58
    L60:
        if (r31 == 0) goto L75;
        if (r31 != 1) goto L63;
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L105;
        com.bytedance.android.live.liveinteract.utils.l r111 = r3.getLinkMicGameFullLinkMonitor();
        if (r111 == null) goto L106;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r111, LinkMonitorData.XplayLoad, null, null, 0, null, null, null, null, r29, 254);
        return;
    L106:
        return;
    L105:
        return;
    L63:
        if (r31 != 2) goto L110;
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L102;
        com.bytedance.android.live.liveinteract.utils.l r112 = r4.getLinkMicGameFullLinkMonitor();
        if (r112 == null) goto L103;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r112, LinkMonitorData.XplayLoad, null, null, -102, null, "canceled", null, null, r29, 214);
        return;
    L103:
        return;
    L102:
        return;
    L110:
        return;
    L75:
        if (r32 == null) goto L79;
        XplayErrorCode r33 = r32.a;
        if (r33 == null) goto L79;
        r6 = r33.getCode();
    L79:
        if (r6 != 0) goto L81;
        int r210 = -101;
    L82:
        IInteractService r34 = jc1.k.f(IInteractService.class);
        if (r34 == null) goto L108;
        com.bytedance.android.live.liveinteract.utils.l r113 = r34.getLinkMicGameFullLinkMonitor();
        if (r113 == null) goto L109;
        LinkMonitorData r114 = LinkMonitorData.XplayLoad;
        if (r32 == null) goto L91;
        ErrorCodeException r35 = r32.b;
        if (r35 == null) goto L91;
        Integer r211 = Integer.valueOf(r35.getCode());
    L92:
        if (r32 == null) goto L97;
        XplayErrorCode r36 = r32.a;
        if (r36 == null) goto L97;
        String r37 = r36.getErrorMsg();
        if (r37 == null) goto L97;
    L98:
        com.bytedance.android.live.liveinteract.utils.l.a.a(r113, r114, null, null, r210, r211, r37, null, null, r29, 198);
        return;
    L97:
        r37 = "unknown";
    L91:
        r211 = null;
        goto L92
    L109:
        return;
    L108:
        return;
    L81:
        r210 = r6;
        goto L82
    L101:
        return;
    L51:
        r27 = null;
    L47:
        r25 = null;
        goto L48
    L41:
        r23 = null;
        goto L42
    L37:
        r22 = null;
        goto L38
    L33:
        r21 = -1;
        goto L34
    L29:
        r19 = "";
        goto L30
    L25:
        r18 = null;
    L21:
        r17 = null;
        goto L22
    L15:
        r15 = null;
    L11:
        r11 = null;
        goto L12
    L5:
        r8 = null;
        goto L6
    }

    public final void n(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, "statusMsg");
        if (this.e.f != XplayScene.TalkRoom) goto L10;
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.n r1 = r0.getLinkMicGameTraceUtils();
        if (r1 == null) goto L12;
        r1.a(this.e.d, r3, r4, r5);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void f(XplayMonitorSession r2, String r3, Integer r4, String r5, a10.d r6, String r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        JSONObject r0 = new JSONObject();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        r0.put("code", r4);     // Catch: Throwable -> L20
        r0.put("type", r3);     // Catch: Throwable -> L20
        if (r5 != null) goto L18;
        r5 = GsonHelper.get().toJson(r6);     // Catch: Throwable -> L20
    L18:
        r0.put("message", r5);     // Catch: Throwable -> L20
        r0.put("seq", r7);     // Catch: Throwable -> L20
        r2.a(r0);     // Catch: Throwable -> L20
        Object r9 = Result.constructor-impl(r0);     // Catch: Throwable -> L20
    L22:
        JSONObject r11 = new JSONObject();
        if (Result.isFailure-impl(r9) == false) goto L25;
        r9 = r11;
    L25:
        JSONObject r12 = new JSONObject();
        r2.a(r12);
        Unit r13 = Unit.INSTANCE;
        Companion.b("ttlive_xplay_custom_message", (JSONObject) r9, r12);
        return;
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
