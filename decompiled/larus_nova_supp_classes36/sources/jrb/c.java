package jrb;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends OPMonitor {
    public static final fyb.e a = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OPMonitorLogLevel.values().length];
            a = r0;
            r0[OPMonitorLogLevel.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[OPMonitorLogLevel.FATAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[OPMonitorLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[OPMonitorLogLevel.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[OPMonitorLogLevel.DEBUG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        a = new fyb.e(new dyb.a(new jrb.a(), new b()));
    }

    public c(OPMonitorCode r3) {
        super(a, "op_messagecard", r3);
        addCategoryValue("tenant_id", e.b(com.ss.android.lark.message.card.b.a().getLoginTenantId()));
        addCategoryValue("user_id", e.b(com.ss.android.lark.message.card.b.a().getLoginUserId()));
    }

    public static OPMonitor a(d r2) {
        return new c(r2).addCategoryValue("tenant_id", e.b(com.ss.android.lark.message.card.b.a().getLoginTenantId())).addCategoryValue("user_id", e.b(com.ss.android.lark.message.card.b.a().getLoginUserId()));
    }

    public c(d r2) {
        super(a, r2);
    }

    public static void d(d r3, int r4, String r5, long r6, String r8, String r9) {
        c r0 = new c(r3);
        r0.addCategoryValue("result_type", "success");
        if (((OPMonitorCode) r3).code != 10022) goto L9;
        r0.addCategoryValue("message_id", r9).addCategoryValue("action_type", Integer.valueOf(r4)).setDuration(System.currentTimeMillis() - r6).addCategoryValue("action_id", r8);
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r0.tracing(r5);
        goto L9
    L8:
        Log.w("CardOPMonitor", "action success traceId is null");
    L9:
        r0.flush();
    }

    public static void b(OPMonitorCode r5, int r6, int r7, String r8, String r9, String r10, String r11) {
        c r0 = new c(r5);
        r0.addCategoryValue("result_type", "fail");
        if (TextUtils.isEmpty(r8) == true) goto L5;
        r0.tracing(r8);
    L6:
        int r12 = r5.code;
        if (r12 != 10014) goto L9;
    L18:
        r0.addCategoryValue("message_id", r10).addCategoryValue("action_type", Integer.valueOf(r7)).addCategoryValue("error_msg", r11).addCategoryValue("action_id", r9);
    L19:
        r0.flush();
        return;
    L9:
        if (r12 == 10020) goto L18;
        if (r12 != 10021) goto L13;
        r0.addCategoryValue("message_id", r10).addCategoryValue("action_type", Integer.valueOf(r7)).addCategoryValue("error_msg", r11).addCategoryValue("action_id", r9);
        r0.addCategoryValue("CODE", Integer.valueOf(r6));
        goto L19
    L13:
        if (r12 == 10028) goto L18;
        if (r12 == 10029) goto L18;
    L5:
        Log.w("CardOPMonitor", "action fail traceId is null");
        goto L6
    }

    public static void c(d r2, int r3, String r4, String r5, String r6, int r7, int r8, String r9, String r10) {
        c r0 = new c(r2);
        r0.addCategoryValue("result_type", "fail").addCategoryValue("message_id", r6).addCategoryValue("action_type", Integer.valueOf(r3)).addCategoryValue("error_msg", r9).addCategoryValue("action_id", r5).addCategoryValue("status", Integer.valueOf(r7)).addCategoryValue("error_code", Integer.valueOf(r8)).addCategoryValue("log_id", r10);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.tracing(r4);
    L6:
        r0.flush();
        return;
    L5:
        Log.w("CardOPMonitor", "action fail traceId is null");
        goto L6
    }
}
