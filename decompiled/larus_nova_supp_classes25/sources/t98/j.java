package t98;

import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.ThermalLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ThermalLevel.values().length];
            r0[ThermalLevel.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ThermalLevel.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ThermalLevel.MODERATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ThermalLevel.SEVERE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ThermalLevel.CRITICAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ThermalLevel.EMERGENCY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ThermalLevel.SHUTDOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ThermalLevel.UNKNOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final <T> T a(wr9.d<T> r2) {
        T r0 = (T) r2.a;
        if (r2.b != PowerMetricAvailability.AVAILABLE) goto L6;
        if (r0 == null) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L11;
        return null;
    L11:
        return r0;
    L6:
        r3 = false;
        goto L7
    }
}
