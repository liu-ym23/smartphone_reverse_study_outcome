package dy;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.qd1;
import com.bytedance.android.livesdk.config.y7;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import ey.g;
import gy.c;
import gy.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public static void a(JSONObject r3) {
        IMiddleWareHostContext r0 = k.n(IMiddleWareHostContext.class);
        if (r3 == null) goto L5;
        r3.put("update_version_code", r0.getUpdateVersionCode());
    L5:
        if (r3 == null) goto L7;
        r3.put("version_code", r0.getVersionCode());
    L7:
        if (r3 == null) goto L9;
        r3.put(OpenPlatformBaseDebugger.APP_ID, r0.appId());
    L9:
        String r1 = "";
        if (r3 == null) goto L19;
        c.c2.getClass();
        c r2 = c.a.a();
        if (r2 == null) goto L17;
        f r4 = r2.getRtcManager();
        if (r4 == null) goto L17;
        String r5 = r4.O();
        if (r5 == null) goto L17;
    L18:
        r3.put("rtc_channel_id", r5);
    L17:
        r5 = "";
    L19:
        if (r3 == null) goto L30;
        c.c2.getClass();
        c r6 = c.a.a();
        if (r6 == null) goto L28;
        f r7 = r6.getRtcManager();
        if (r7 == null) goto L28;
        String r8 = r7.c0();
        if (r8 == null) goto L28;
        r1 = r8;
    L28:
        r3.put("linker_session_id", r1);
        return;
    }

    public static boolean c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        return ((List) y7.a.getValue()).contains(r1);
    }

    public final void f(String r12, LiveTracingMonitor.EventModule r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "module");
        if (((Boolean) qd1.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (c(r12) == false) goto L8;
        return;
    L8:
        a(r14);
        com.bytedance.android.live.core.monitor.trace.c.b(b(this, r12, r13, new HashMap(), 0, null, null, 0, 120), r14);
    }

    public static void e(String r11, LiveTracingMonitor.EventModule r12, Map r13, JSONObject r14) {
        b r0 = a;
        Intrinsics.checkNotNullParameter(r11, "event");
        Intrinsics.checkNotNullParameter(r12, "module");
        Intrinsics.checkNotNullParameter(r13, "index");
        if (((Boolean) qd1.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (c(r11) == true) goto L11;
        a(r14);
        JSONObject r15 = new JSONObject();
        r15.put("device_radio", Float.valueOf(z0.b(true)));
        e r16 = b(r0, r11, r12, r13, 0, null, null, 0, 56);
        JSONObject r17 = new JSONObject();
        a60.e r18 = com.bytedance.android.live.core.monitor.trace.c.a;
        Intrinsics.checkNotNullParameter(r16, "traceMeta");
        TraceMonitor.i(r16, r17, r15, r14);
        return;
    }

    public final void d(String r12, LiveTracingMonitor.EventModule r13, int r14, String r15, Map<String, Object> r16, JSONObject r17) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "module");
        Intrinsics.checkNotNullParameter(r16, "index");
        if (((Boolean) qd1.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (c(r12) == false) goto L8;
        return;
    L8:
        a(r17);
        com.bytedance.android.live.core.monitor.trace.c.b(b(this, r12, r13, r16, r14, r15, null, 0, 96), r17);
    }

    public static e b(b r6, String r7, LiveTracingMonitor.EventModule r8, Map r9, int r11, String r12, String r13, long r14, int r15) {
        if ((r15 & 8) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r15 & 16) == 0) goto L9;
        r12 = "";
    L9:
        if ((r15 & 32) == 0) goto L12;
        r13 = "";
    L12:
        if ((r15 & 64) == 0) goto L14;
        r14 = 0;
    L14:
        r6.getClass();
        Room r16 = m.i().getCurrentRoom();
        String r17 = null;
        if (r16 == null) goto L17;
        Room r18 = (Room) jm2.a.e(r16);
    L18:
        HashMap r3 = (HashMap) r9;
        r3.put(OpenPlatformBaseDebugger.APP_ID, Integer.valueOf(TTMiddlewareLiveSDK.hostMiddlewareService().appContext().appId()));
        if (r3.containsKey("role_type") == true) goto L33;
        Room r4 = m.i().getCurrentRoom();
        if (r4 == null) goto L23;
        Room r5 = (Room) jm2.a.e(r4);
    L24:
        String r19 = k.n(IMiddlewareUserService.class).user().n();
        if (r5 == null) goto L27;
        String r21 = r5.getOwnerUserIdString();
    L29:
        if (Intrinsics.areEqual(r21, r19) == false) goto L31;
        String r22 = GamePromoteDataContext.GAME_TYPE_MINI;
    L32:
        r3.put("role_type", r22);
        goto L33
    L31:
        r22 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L32
    L27:
        r21 = null;
        goto L29
    L23:
        r5 = null;
    L33:
        int r2 = e.m;
        e.a r23 = e.b.a(r7, r8.getName());
        if (r14 != 0) goto L44;
        g.a.getClass();
        nc0.b r24 = g.a.a();
        if (r24 == null) goto L42;
        LiveData<ey.f> r25 = r24.c();
        if (r25 == null) goto L42;
        ey.f r26 = (ey.f) r25.getValue();
        if (r26 == null) goto L42;
        Long r27 = Long.valueOf(r26.a);
    L43:
        String r28 = String.valueOf(r27);
    L45:
        r23.a = r28;
        r23.c = "webcast_client_revenue_interact";
        com.bytedance.android.livesdk.user.e r29 = k.n(IMiddlewareUserService.class).user();
        if (r29 == null) goto L48;
        String r31 = r29.n();
    L49:
        r23.g = r31;
        Intrinsics.checkNotNullParameter(r9, "index");
        r23.j = r9;
        r23.h = Integer.valueOf(r11);
        r23.i = r12;
        if (r18 == null) goto L52;
        String r32 = r18.getOwnerUserIdString();
    L53:
        r23.f = r32;
        if (r18 == null) goto L56;
        r17 = r18.getIdStr();
    L56:
        r23.e = r17;
        r23.b = r13;
        return r23.a();
    L52:
        r32 = null;
        goto L53
    L48:
        r31 = null;
    L42:
        r27 = null;
        goto L43
    L44:
        r28 = String.valueOf(r14);
        goto L45
    L17:
        r18 = null;
        goto L18
    }
}
