package jh;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.fps.RealFpsMonitor;
import com.bytedance.android.ec.core.monitor.q;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final HashMap<String, RealFpsMonitor> a = null;
    public static final HashMap<String, c> b = null;
    public static final a c = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static RealFpsMonitor a(q r10) {
            Intrinsics.checkNotNullParameter(r10, "monitorSceneWrapper");
            HashMap<String, RealFpsMonitor> r0 = b.a;
            RealFpsMonitor r1 = r0.get(r10.a);
            if (r1 == null) goto L5;
            return r1;
        L5:
            RealFpsMonitor r11 = new RealFpsMonitor(r10);
            r0.put(r10.a, r11);
            return r11;
        }

        @JvmStatic
        public static RealFpsMonitor b(MonitorScenes r10) {
            Intrinsics.checkNotNullParameter(r10, "monitorScene");
            return a(new q(r10, null, null));
        }

        @JvmStatic
        public static c c(q r10) {
            Intrinsics.checkNotNullParameter(r10, "monitorSceneWrapper");
            HashMap<String, c> r0 = b.b;
            c r1 = r0.get(r10.a);
            if (r1 == null) goto L5;
            return r1;
        L5:
            c r11 = new c(r10);
            r0.put(r10.a, r11);
            return r11;
        }

        @JvmStatic
        public static c d(MonitorScenes r10) {
            Intrinsics.checkNotNullParameter(r10, "monitorScene");
            return c(new q(r10, null, null));
        }
    }

    static {
        c = new a();
        a = new HashMap();
        b = new HashMap();
    }
}
