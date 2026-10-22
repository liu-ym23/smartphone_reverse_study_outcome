package fyb;

import android.text.TextUtils;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a implements byb.e {
    public static final String COMMA = ",";
    public static final C0141a Companion = null;
    public static final String KEY_DATA = "data:";
    public static final String KEY_MONITOR_EVENT = "monitor_event:";

    /* JADX INFO: renamed from: fyb.a$a, reason: collision with other inner class name */
    public static final class C0141a {
        public C0141a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OPMonitorLevel.values().length];
            r0[OPMonitorLevel.TRACE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[OPMonitorLevel.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[OPMonitorLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[OPMonitorLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[OPMonitorLevel.FATAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
        Companion = new C0141a();
    }

    public a() {
    }

    public final String getEventName(OPMonitor r3, dyb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "monitor");
        Intrinsics.checkNotNullParameter(r4, "config");
        String r0 = r3.getName();
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L9:
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        if (r3.getMonitorCode() == null) goto L7;
        r4.getClass();
    L8:
        r0 = "op_monitor_event";
        goto L9
    L7:
        r4.getClass();
        goto L8
    }

    public final void log(OPMonitor r9, dyb.a r10) {
        Intrinsics.checkNotNullParameter(r9, "monitor");
        if (r10 != null) goto L6;
        return;
    L6:
        if (r9.getLevel() != null) goto L9;
        OPMonitorLogLevel r0 = OPMonitorLogLevel.INFO;
    L8:
        OPMonitorLogLevel r3 = r0;
        String r1 = getEventName(r9, r10);
        if ((r9.getValue("monitor_file") instanceof String) == false) goto L31;
        Object r2 = r9.getValue("monitor_file");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.String");
        String r4 = (String) r2;
    L33:
        if ((r9.getValue("monitor_function") instanceof String) == false) goto L35;
        Object r5 = r9.getValue("monitor_function");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.String");
        String r6 = (String) r5;
    L37:
        if ((r9.getValue("monitor_line") instanceof Integer) == false) goto L39;
        Object r11 = r9.getValue("monitor_line");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Int");
        int r7 = ((Integer) r11).intValue();
    L40:
        r10.b.a(r3, r4, r6, r7, KEY_MONITOR_EVENT + r1 + ",data:" + new JSONObject(r9.getData()));
        return;
    L39:
        r7 = -1;
        goto L40
    L35:
        r6 = null;
        goto L37
    L31:
        r4 = null;
        goto L33
    L9:
        OPMonitorLevel r8 = r9.getLevel();
        if (r8 != null) goto L12;
        int r12 = -1;
    L14:
        if (r12 != 1) goto L16;
    L27:
        r0 = OPMonitorLogLevel.INFO;
        goto L8
    L16:
        if (r12 == 2) goto L27;
        if (r12 != 3) goto L20;
        r0 = OPMonitorLogLevel.WARN;
        goto L8
    L20:
        if (r12 != 4) goto L22;
        r0 = OPMonitorLogLevel.ERROR;
        goto L8
    L22:
        if (r12 == 5) goto L24;
        r0 = OPMonitorLogLevel.INFO;
        goto L8
    L24:
        r0 = OPMonitorLogLevel.FATAL;
        goto L8
    L12:
        r12 = b.a[r8.ordinal()];
        goto L14
    }
}
