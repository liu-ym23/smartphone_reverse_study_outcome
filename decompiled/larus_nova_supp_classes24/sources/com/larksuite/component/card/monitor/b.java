package com.larksuite.component.card.monitor;

import byb.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import fyb.e;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends OPMonitor {
    public static final e a = null;

    public static final class a implements d {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(String r3, HashMap<String, Object> r4, HashMap<String, Object> r5) {
            int r0 = UniversalCardMonitorUtils.a;
            JSONObject r1 = new JSONObject(r5);
            JSONObject r6 = new JSONObject(r4);
            Intrinsics.checkNotNullParameter(r1, "category");
            Intrinsics.checkNotNullParameter(r6, "metric");
            ty7.a.a().monitorEvent(r3, r1, r6, null);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.card.monitor.b$b, reason: collision with other inner class name */
    public static final class C0022b implements byb.c {
        public static final C0022b a = null;

        /* JADX INFO: renamed from: com.larksuite.component.card.monitor.b$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[OPMonitorLogLevel.values().length];
                r0[OPMonitorLogLevel.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[OPMonitorLogLevel.FATAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[OPMonitorLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[OPMonitorLogLevel.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[OPMonitorLogLevel.DEBUG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        static {
            a = new C0022b();
        }

        public C0022b() {
        }

        public final void a(OPMonitorLogLevel r3, String r4, String r5, int r6, String r7) {
            StringBuilder r0 = new StringBuilder("filePath:");
            r0.append(r4);
            r0.append("\tfunction:");
            r0.append(r5);
            r0.append("\tline:");
            r0.append(r6);
            r0.append("\tcontent");
            r0.append(r7);
            if (r3 != null) goto L5;
            int r8 = -1;
        L7:
            if (r8 != 1) goto L9;
        L20:
            Log.e("op_monitor", r0.toString());
            return;
        L9:
            if (r8 == 2) goto L20;
            if (r8 != 3) goto L13;
            Log.w("op_monitor", r0.toString());
            return;
        L13:
            if (r8 != 4) goto L15;
            Log.i("op_monitor", r0.toString());
            return;
        L15:
            if (r8 == 5) goto L17;
            Log.d("op_monitor", r0.toString());
            return;
        L17:
            Log.d("op_monitor", r0.toString());
            return;
        L5:
            r8 = a.a[r3.ordinal()];
            goto L7
        }
    }

    public static final class c {
        public static b a(OPMonitorCode r3) {
            return new b(null, r3, 3);
        }
    }

    static {
        a = new e(new dyb.a(a.a, C0022b.a));
    }

    public b(String r2, OPMonitorCode r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        e r0 = a;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r2 = "op_open_card";
    L9:
        super(r0, r2, r3);
        return;
    L5:
        r0 = null;
        goto L7
    }
}
