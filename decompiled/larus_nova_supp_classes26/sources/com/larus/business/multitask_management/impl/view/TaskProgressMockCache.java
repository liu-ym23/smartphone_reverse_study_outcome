package com.larus.business.multitask_management.impl.view;

import android.animation.ValueAnimator;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TaskProgressMockCache {
    public static final Lazy a = null;
    public static final CoroutineScope b = null;
    public static volatile Job c;
    public static final AtomicBoolean d = null;
    public static final StateFlowImpl e = null;
    public static final TaskProgressMockCache$map$1 f = null;

    public TaskProgressMockCache() {
    }

    static {
        a = LazyKt.lazy(new c0());
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        d = new AtomicBoolean(false);
        e = j1.a(Boolean.FALSE);
        f = new TaskProgressMockCache$map$1();
    }

    public static void c() {
        if (((Boolean) e.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (c != null) goto L9;
        c = BuildersKt.launch$default(b, null, null, new TaskProgressMockCache$saveProgressCache$1(null), 3, null);
        return;
    }

    public static int a(String r10) {
        int r1 = 0;
        if (r10 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return 0;
    L12:
        if (d.compareAndSet(false, true) == false) goto L14;
        FLogger.a.i("multitask-TaskProgressMockCache", "loadProgressCache");
        BuildersKt.launch$default(b, null, null, new TaskProgressMockCache$loadProgressCache$1(null), 3, null);
    L14:
        TaskProgressMockCache$map$1 r0 = f;
        monitor-enter(r0);
        a0 r11 = (a0) r0.get(r10);     // Catch: Throwable -> L21
        if (r11 == null) goto L19;
        r1 = r11.a;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r0);
        return r1;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (r10.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void b(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        TaskProgressMockCache$map$1 r2 = f;
        monitor-enter(r2);
        a0 r6 = (a0) r2.remove(r5);     // Catch: Throwable -> L24
        if (r6 == null) goto L22;
        c r3 = r6.b;     // Catch: Throwable -> L24
        ValueAnimator r4 = r3.f;     // Catch: Throwable -> L24
        if (r4 == null) goto L18;
        r4.cancel();     // Catch: Throwable -> L24
    L18:
        r3.f = null;     // Catch: Throwable -> L24
        ValueAnimator r7 = r3.g;     // Catch: Throwable -> L24
        if (r7 == null) goto L21;
        r7.cancel();     // Catch: Throwable -> L24
    L21:
        r3.g = null;     // Catch: Throwable -> L24
        r3.c = null;     // Catch: Throwable -> L24
        r3.d = null;     // Catch: Throwable -> L24
        r6.a = 0;     // Catch: Throwable -> L24
        c();     // Catch: Throwable -> L24
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        monitor-exit(r2);
        return;
    L24:
        th = move-exception;
        throw th;
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static void d(String r2, int r3) {
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        int r4 = RangesKt.coerceIn(r3, 0, 500);
        TaskProgressMockCache$map$1 r0 = f;
        monitor-enter(r0);
        a0 r5 = (a0) r0.get(r2);     // Catch: Throwable -> L22
        if (r5 != null) goto L17;
        r5 = new a0();     // Catch: Throwable -> L22
        r0.put(r2, r5);     // Catch: Throwable -> L22
    L17:
        if (r4 <= r5.a) goto L19;
        r5.a = r4;     // Catch: Throwable -> L22
        c();     // Catch: Throwable -> L22
    L19:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return;
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r2.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
