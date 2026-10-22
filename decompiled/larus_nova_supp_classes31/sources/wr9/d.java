package wr9;

import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d<T> {
    public static final /* synthetic */ int f = 0;
    public final T a;
    public final PowerMetricAvailability b;
    public final PowerMetricSource c;
    public final long d;
    public final String e;

    public static final class a {
        public static d a(PowerMetricAvailability r8, PowerMetricSource r9, long r10, String r12) {
            Intrinsics.checkNotNullParameter(r8, "availability");
            Intrinsics.checkNotNullParameter(r9, "source");
            return new d(null, r8, r9, r10, r12);
        }
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        T r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r4 = this.d;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        String r6 = this.e;
        if (r6 == null) goto L11;
        r1 = r6.hashCode();
    L11:
        return r5 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PowerMetric(value=" + this.a + ", availability=" + this.b + ", source=" + this.c + ", sampledAtElapsedRealtimeMs=" + this.d + ", reason=" + this.e + ')';
    }

    public /* synthetic */ d(Object r8, PowerMetricAvailability r9, PowerMetricSource r10, long r11) {
        this(r8, r9, r10, r11, null);
    }

    public static d a(d r9, PowerMetricAvailability r10, String r11, int r12) {
        PowerMetricSource r1 = null;
        if ((r12 & 1) == 0) goto L5;
        T r3 = r9.a;
    L7:
        if ((r12 & 2) == 0) goto L9;
        r10 = r9.b;
    L9:
        PowerMetricAvailability r4 = r10;
        if ((r12 & 4) == 0) goto L12;
        r1 = r9.c;
    L12:
        PowerMetricSource r5 = r1;
        if ((r12 & 8) == 0) goto L15;
        long r0 = r9.d;
    L16:
        long r6 = r0;
        if ((r12 & 16) == 0) goto L19;
        r11 = r9.e;
    L19:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r4, "availability");
        Intrinsics.checkNotNullParameter(r5, "source");
        return new d(r3, r4, r5, r6, r11);
    L15:
        r0 = 0;
        goto L16
    L5:
        r3 = null;
        goto L7
    }

    public d(T r2, PowerMetricAvailability r3, PowerMetricSource r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r3, "availability");
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }
}
