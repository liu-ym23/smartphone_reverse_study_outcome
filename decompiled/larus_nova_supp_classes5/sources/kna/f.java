package kna;

import android.content.Context;
import com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final Context a;
    public final ObricPerformancePowerMonitorConfig b;
    public final d c;
    public final c d;
    public final e e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        d r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "PowerMonitorInitConfig(context=" + this.a + ", settings=" + this.b + ", reportDelegate=" + this.c + ", appBackgroundDelegate=" + this.d + ", screenStateDelegate=" + this.e + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public f(Context r2, ObricPerformancePowerMonitorConfig r3, ObricPerformanceMonitorServiceImpl.AnonymousClass1.a r4, ObricPerformanceMonitorServiceImpl.AnonymousClass1.b r5, ObricPerformanceMonitorServiceImpl.AnonymousClass1.c r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "settings");
        Intrinsics.checkNotNullParameter(r5, "appBackgroundDelegate");
        Intrinsics.checkNotNullParameter(r6, "screenStateDelegate");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
