package do0;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.fm0;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static /* synthetic */ void b(RechargeVerifyTraceStep r6, int r7, String r8, String r9, String r10) {
        a(r6, r7, r8, r9, r10, MapsKt.emptyMap());
    }

    public static void a(RechargeVerifyTraceStep r6, int r7, String r8, String r9, String r10, Map r11) {
        Intrinsics.checkNotNullParameter(r6, "step");
        JSONObject r0 = new JSONObject();
        d60.b.a(r0, "error_code", Integer.valueOf(r7));
        d60.b.a(r0, "scene", String.valueOf(r8));
        d60.b.a(r0, "flow", String.valueOf(r9));
        d60.b.a(r0, "url", String.valueOf(r10));
        d60.b.a(r0, "is_v3", String.valueOf(((Boolean) fm0.a.getValue()).booleanValue()));
        if (r11 == null) goto L8;
        Iterator r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry r13 = (Map.Entry) r12.next();
        d60.b.a(r0, (String) r13.getKey(), r13.getValue());
    L8:
        String r14 = r6.getValue();
        int r15 = sp2.a.a;
        if (((Boolean) LiveInfraSettingKeys.LIVE_RECHARGE_VERIFY_TRACE_ENABLE.getValue()).booleanValue() == true) goto L11;
        ALogger.e("RechargeVerifyTraceMonitor", "disable report trace. due to setting disabled");
        return;
    L11:
        LiveTracingMonitor.EventModule r16 = LiveTracingMonitor.EventModule.RECHARGE;
        ILiveRoomService r17 = k.f(ILiveRoomService.class);
        String r18 = null;
        if (r17 == null) goto L14;
        Room r19 = r17.getCurrentRoom();
    L15:
        IUserService r110 = k.f(IUserService.class);
        if (r110 == null) goto L20;
        f r111 = r110.user();
        if (r111 == null) goto L20;
        IUser r112 = r111.b();
    L21:
        int r1 = e.m;
        e.a r20 = e.b.a("recharge_verify", r16.getName());
        IUserService r2 = k.f(IUserService.class);
        if (r2 == null) goto L28;
        f r3 = r2.user();
        if (r3 == null) goto L28;
        IUser r4 = r3.b();
        if (r4 == null) goto L28;
        String r5 = r4.getUserId();
    L29:
        r20.a = r5 + System.currentTimeMillis() + new SecureRandom().nextInt(1000);
        r20.c = "webcast_client_recharge_verify";
        r20.h = Integer.valueOf(r7);
        if (r112 == null) goto L32;
        String r113 = r112.getUserId();
    L33:
        r20.g = r113;
        r20.h = Integer.valueOf(r7);
        r20.i = "";
        r20.d = r14;
        if (r19 == null) goto L38;
        User r21 = r19.getOwner();
        if (r21 == null) goto L38;
        String r22 = r21.getIdString();
    L39:
        r20.f = String.valueOf(r22);
        if (r19 == null) goto L42;
        r18 = r19.getIdStr();
    L42:
        r20.e = r18;
        r20.b = "";
        c.b(r20.a(), r0);
        return;
    L38:
        r22 = null;
        goto L39
    L32:
        r113 = null;
    L28:
        r5 = null;
    L20:
        r112 = null;
        goto L21
    L14:
        r19 = null;
        goto L15
    }
}
