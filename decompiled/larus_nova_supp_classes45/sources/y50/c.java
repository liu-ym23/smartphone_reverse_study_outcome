package y50;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.livesdk.chatroom.utils.g4;
import com.bytedance.android.livesdk.config.b0;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.utils.h {
    public static boolean a;
    public static final HashMap<String, q> b = null;
    public static final PriorityQueue<r> c = null;
    public static final c d = null;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((r) r2).a - ((r) r1).a;
        }
    }

    public c() {
    }

    static {
        d = new c();
        b = new HashMap();
        c = new PriorityQueue(100, a.a);
    }

    public static void d() {
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        Map r0 = WidgetPerfManager.getInstance().getWidgetMap();
        c.clear();
        Iterator r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r1.next();
        r r3 = new r((String) r2.getKey(), (WidgetCostModule) r2.getValue());
        if (r3.a >= 9999) goto L7;
        c.offer(r3);
        goto L7
    L11:
        int r4 = Math.min(c.size(), 10);
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L17;
        r r6 = c.poll();
        if (r6 == null) goto L15;
        HashMap<String, q> r7 = b;
        String r8 = "widget_main_cost_" + r6.b;
        q r9 = new q();
        r9.c = r6.a;
        Unit r11 = Unit.INSTANCE;
        r7.put(r8, r9);
        r5 = r5 + 1;
        goto L12
    L15:
        return;
    L17:
        c.clear();
    }

    public static void e() {
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        LiveMonitor.a r0 = new LiveMonitor.a("ttlive_anchor_inter_biz_cost_monitor", LiveTracingMonitor.EventModule.OPEN_LIVE);
        r0.l(0);
        r0.g = true;
        r0.f = true;
        c(r0);
        Iterator<Map.Entry<String, q>> r1 = b.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<String, q> r2 = r1.next();
        if (r2.getValue().c <= 0) goto L7;
        r0.g(r2.getKey(), r2.getValue().c);
        goto L7
    L11:
        r0.a().report();
        b.clear();
    }

    public static void c(LiveMonitor.a r6) {
        r6.c(GamePromoteDataContext.LIVE);
        float r0 = z0.b(true);
        if (r0 < 8.0d) goto L6;
        String r1 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L12:
        r6.e("is_continue_room", m2.b(a));
        r6.e("device_score", r1);
        r6.e("load_opt_config", m2.b(b0.a()));
        return;
    L6:
        if (r0 < 6.0f) goto L9;
        r1 = GamePromoteDataContext.GAME_TYPE_MINI;
        goto L12
    L9:
        if (r0 <= 0) goto L11;
        r1 = "3";
        goto L12
    L11:
        r1 = "0";
        goto L12
    }

    public static void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        ALogger.i("RoomContextInitError", r4);
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L6;
        return;
    L6:
        if (b0.a() == true) goto L8;
        return;
    L8:
        LiveMonitor.a r1 = new LiveMonitor.a("ttlive_anchor_inter_biz_error_monitor", LiveTracingMonitor.EventModule.OPEN_LIVE);
        r1.l(0);
        r1.g = true;
        r1.f = true;
        r1.e("is_anchor", m2.b(b0.a));
        r1.e("error_type", r4);
        r1.i("error_reason", r4);
        c(r1);
        r1.a().report();
        SafetyGuard.a(null, new Exception("RoomContextInitError"), "RoomContextInitError ".concat(r4));
    }

    public static long g(String r11) {
        Intrinsics.checkNotNullParameter(r11, "name");
        long r1 = -1;
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return -1;
    L5:
        HashMap<String, q> r0 = b;
        q r3 = r0.get("inter_load_total");
        if (r3 != null) goto L8;
    L24:
        return r1;
    L8:
        if (r3.a > 0) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 != true) goto L24;
        if (r0.get(r11) != null) goto L18;
        r0.put(r11, new q());
    L18:
        r1 = System.currentTimeMillis();
        q r5 = r0.get(r11);
        if (r5 == null) goto L21;
        r5.a = r1;
    L21:
        q r12 = r0.get(r11);
        if (r12 == null) goto L24;
        r12.d = r1;
        goto L24
    L10:
        if (r3.b != 0) goto L12;
        r4 = true;
        goto L13
    }

    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "name");
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        q r7 = b.get(r6);
        if (r7 != null) goto L8;
        return;
    L8:
        if (r7.a == 0) goto L12;
        long r0 = System.currentTimeMillis();
        r7.b = r0;
        r7.c = r0 - r7.a;
        return;
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L6;
        return;
    L6:
        if (g4.a != null) goto L8;
        g4.a = this;
    L8:
        b.put(r3, new q());
    }

    public static void h(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "name");
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L5;
        return;
    L5:
        if (r9 == (-1)) goto L27;
        HashMap<String, q> r0 = b;
        q r1 = r0.get("inter_load_total");
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.a > 0) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 != true) goto L28;
        q r11 = r0.get(r8);
        if (r11 != null) goto L20;
        return;
    L20:
        if (r11.d != r9) goto L26;
        long r12 = System.currentTimeMillis();
        r11.b = r12;
        r11.c += r12 - r11.a;
        return;
    L26:
        return;
    L28:
        return;
    L12:
        if (r1.b != 0) goto L14;
        r2 = true;
        goto L15
    }
}
