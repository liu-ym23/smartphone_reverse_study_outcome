package cyb;

import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OPMonitorLevel.values().length];
            a = r0;
            r0[OPMonitorLevel.FATAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[OPMonitorLevel.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[OPMonitorLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[OPMonitorLevel.NORMAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[OPMonitorLevel.TRACE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public c() {
    }
}
