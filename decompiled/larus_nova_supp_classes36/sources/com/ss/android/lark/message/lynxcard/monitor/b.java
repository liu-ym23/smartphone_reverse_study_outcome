package com.ss.android.lark.message.lynxcard.monitor;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.view.j;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends OPMonitor {
    public static final fyb.e a = null;

    public static final class a implements byb.d {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(String r2, HashMap<String, Object> r3, HashMap<String, Object> r4) {
            j.a(r2, new JSONObject(r4), new JSONObject(r3));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.message.lynxcard.monitor.b$b, reason: collision with other inner class name */
    public static final class C0183b implements byb.c {
        public static final C0183b a = null;

        /* JADX INFO: renamed from: com.ss.android.lark.message.lynxcard.monitor.b$b$a */
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
            a = new C0183b();
        }

        public C0183b() {
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
        public static b a(ncb.c r2) {
            b r0 = new b(r2);
            r0.addCategoryValue("tenant_id", jrb.e.b(com.ss.android.lark.message.card.b.a().getLoginTenantId()));
            r0.addCategoryValue("user_id", jrb.e.b(com.ss.android.lark.message.card.b.a().getLoginUserId()));
            return r0;
        }
    }

    static {
        a = new fyb.e(new dyb.a(a.a, C0183b.a));
    }

    public b(ncb.c r3) {
        super(a, "op_open_card", r3);
    }
}
