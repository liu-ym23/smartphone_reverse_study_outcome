package org.koin.core;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21003b;

    public b() {
        this.f21002a = new a();
        this.f21003b = true;
    }

    public final void a(List r10) {
        Intrinsics.checkNotNullParameter(r10, "modules");
        a r5 = this.f21002a;
        um.a r11 = r5.f21001c;
        Level r12 = Level.INFO;
        if (r11.r(r12) == false) goto L5;
        long r13 = System.nanoTime();
        r5.d(r10, this.f21003b, false);
        double r14 = ((Number) new Pair(Unit.INSTANCE, Double.valueOf((System.nanoTime() - r13) / 1000000.0d)).getSecond()).doubleValue();
        int r15 = ((ConcurrentHashMap) r5.f21000b.d).size();
        r5.f21001c.p(r12, "Started " + r15 + " definitions in " + r14 + " ms");
        return;
    L5:
        r5.d(r10, this.f21003b, false);
    }
}
