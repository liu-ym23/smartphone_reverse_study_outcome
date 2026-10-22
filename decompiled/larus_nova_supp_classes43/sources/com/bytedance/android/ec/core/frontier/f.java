package com.bytedance.android.ec.core.frontier;

import android.os.SystemClock;
import android.util.SparseArray;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static boolean a;
    public static Long b;
    public static final a c = null;

    public static final class a {
        public a() {
        }

        public static void a(boolean r10) {
            JSONObject r0 = new JSONObject();
            if (r10 == false) goto L5;
            int r11 = 200;
        L6:
            r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r11);
            Unit r12 = Unit.INSTANCE;
            JSONObject r13 = new JSONObject();
            if (f.b == null) goto L9;
            long r14 = SystemClock.elapsedRealtime();
            Long r1 = f.b;
            Intrinsics.checkNotNull(r1);
            r13.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r14 - r1.longValue());
            f.b = null;
        L9:
            int r15 = ECMonitorService.b;
            ECMonitorService.a.a("ec_ws_connection", r0, r13, null);
            f.a = false;
            return;
        L5:
            r11 = 100;
            goto L6
        }
    }

    static {
        c = new a();
        new SparseArray();
    }
}
