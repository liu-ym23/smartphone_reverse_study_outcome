package r49;

import com.larus.dora.impl.device.settings.lab.env.l;
import com.larus.dora.impl.device.settings.lab.env.m;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveOverrideChangeReason;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveWearState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final /* synthetic */ int j = 0;
    public final Function0<Long> a;
    public final r49.a b;
    public final Function0<Long> c;
    public final Function0<Long> d;
    public final Function2<String, EnvObserveOverrideChangeReason, Unit> e;
    public final Object f;
    public final Map<String, b> g;
    public final Map<String, EnvObserveWearState> h;
    public final Map<String, Long> i;

    public static final class a {
        public static EnvObserveWearState a(Integer r2, Integer r3) {
            if (r2 != null) goto L6;
        L7:
            if (r3 != null) goto L10;
        L12:
            if (r2 == null) goto L25;
            if (r2.intValue() != 0) goto L25;
            if (r3 == null) goto L25;
            if (r3.intValue() != 0) goto L25;
            return EnvObserveWearState.UNWORN;
        L25:
            return EnvObserveWearState.UNKNOWN;
        L10:
            if (r3.intValue() != 1) goto L12;
        L23:
            return EnvObserveWearState.WORN;
        L6:
            if (r2.intValue() == 1) goto L23;
            goto L7
        }
    }

    public static final class b {
        public final long a;
        public final Long b;
        public final long c;
        public final long d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            Long r2 = this.b;
            if (r2 != null) goto L5;
            int r3 = 0;
        L6:
            long r4 = this.c;
            int r5 = (((r1 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            long r6 = this.d;
            return r5 + ((int) (r6 ^ (r6 >>> 32)));
        L5:
            r3 = r2.hashCode();
            goto L6
        }

        public final String toString() {
            return "OverrideState(expiresAtMillis=" + this.a + ", unwornSinceMillis=" + this.b + ", unwornTimeoutMillis=" + this.c + ", generation=" + this.d + ')';
        }

        public b(long r1, Long r3, long r4, long r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r6;
        }
    }

    static {
    }

    public final boolean d(String r6) {
        Intrinsics.checkNotNullParameter(r6, "mac");
        Object r0 = this.f;
        monitor-enter(r0);
        b r1 = (b) ((LinkedHashMap) this.g).get(r6);     // Catch: Throwable -> L15
        boolean r2 = false;
        if (r1 != null) goto L7;
        EnvObserveOverrideChangeReason r3 = null;
    L11:
        monitor-exit(r0);
        if (r3 == null) goto L14;
        this.e.invoke(r6, r3);
    L14:
        return r2;
    L7:
        r3 = c(r1, ((Number) this.a.invoke()).longValue());     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
        r2 = true;
        goto L11
    L10:
        e(r6);     // Catch: Throwable -> L15
        this.g.remove(r6);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final long e(String r5) {
        Long r0 = (Long) ((LinkedHashMap) this.i).get(r5);
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        long r2 = r1 + 1;
        Long r3 = Long.valueOf(r2);
        this.i.put(r5, r3);
        return r2;
    L5:
        r1 = 0;
        goto L6
    }

    public static EnvObserveOverrideChangeReason c(b r3, long r4) {
        if (r4 >= r3.a) goto L5;
        Long r0 = r3.b;
        if (r0 != null) goto L9;
        return null;
    L9:
        if ((r4 - r0.longValue()) >= r3.c) goto L11;
        return null;
    L11:
        return EnvObserveOverrideChangeReason.UNWORN_TIMEOUT;
    L5:
        return EnvObserveOverrideChangeReason.EXPIRED;
    }

    public final void a(String r3, EnvObserveOverrideChangeReason r4) {
        Intrinsics.checkNotNullParameter(r3, "mac");
        Intrinsics.checkNotNullParameter(r4, "reason");
        Object r0 = this.f;
        monitor-enter(r0);
        e(r3);     // Catch: Throwable -> L12
        if (this.g.remove(r3) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);
        if (r1 == false) goto L17;
        this.e.invoke(r3, r4);
        return;
    L17:
        return;
    L7:
        r1 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final void f(final String r8, final b r9) {
        r49.a r0 = this.b;
        l r1 = (l) r0;
        r1.a(RangesKt.coerceAtLeast(r9.a - ((Number) this.a.invoke()).longValue(), 0), new r49.b(this, r8, r9));
        Long r2 = r9.b;
        if (r2 == null) goto L6;
        long r3 = r2.longValue();
        r49.a r4 = this.b;
        l r5 = (l) r4;
        r5.a(RangesKt.coerceAtLeast((r3 + r9.c) - ((Number) this.a.invoke()).longValue(), 0), new c(this, r8, r9));
        return;
    }

    public final void b(String r6, long r7, EnvObserveOverrideChangeReason r9) {
        Object r0 = this.f;
        monitor-enter(r0);
        b r1 = (b) ((LinkedHashMap) this.g).get(r6);     // Catch: Throwable -> L19
        if (r1 != null) goto L8;
    L13:
        boolean r8 = false;
    L14:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        if (r8 == false) goto L24;
        this.e.invoke(r6, r9);
        return;
    L24:
        return;
    L8:
        if (r1.d != r7) goto L13;
        if (c(r1, ((Number) this.a.invoke()).longValue()) != r9) goto L13;
        e(r6);     // Catch: Throwable -> L19
        this.g.remove(r6);     // Catch: Throwable -> L19
        r8 = true;
    L19:
        th = move-exception;
        throw th;
    }

    public d(Function0 r2, l r3, m r4, com.larus.dora.impl.device.settings.lab.env.b r5, com.larus.dora.impl.device.settings.lab.env.c r6) {
        Intrinsics.checkNotNullParameter(r2, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(r3, "scheduler");
        Intrinsics.checkNotNullParameter(r4, "overrideDurationMillis");
        Intrinsics.checkNotNullParameter(r5, "unwornTimeoutMillis");
        Intrinsics.checkNotNullParameter(r6, "onChanged");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = new Object();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
    }
}
