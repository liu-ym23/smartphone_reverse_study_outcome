package xr9;

import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import com.larus.power.state.api.ThermalLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public static final ThermalLevel b(int r0) {
        switch(r0) {
            case 0: goto L11;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L12;
        };
    L12:
        return ThermalLevel.UNKNOWN;
    L13:
        return ThermalLevel.SHUTDOWN;
    L14:
        return ThermalLevel.EMERGENCY;
    L15:
        return ThermalLevel.CRITICAL;
    L16:
        return ThermalLevel.SEVERE;
    L17:
        return ThermalLevel.MODERATE;
    L18:
        return ThermalLevel.LIGHT;
    L11:
        return ThermalLevel.NONE;
    }

    public static final <T> wr9.d<T> a(T r7, PowerMetricSource r8, long r9) {
        return new wr9.d(r7, PowerMetricAvailability.AVAILABLE, r8, r9);
    }

    public static final <T> wr9.d<T> c(PowerMetricAvailability r1, PowerMetricSource r2, long r3, String r5) {
        int r0 = wr9.d.f;
        return wr9.d.a.a(r1, r2, r3, r5);
    }
}
