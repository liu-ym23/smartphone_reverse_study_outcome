package com.obric.capability.schedulekit;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static final CoroutineScope a = null;
    public static final List<a> b = null;
    public static final CopyOnWriteArraySet<Function0<Unit>> c = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new a())));
        b = new ArrayList();
        c = new CopyOnWriteArraySet();
    }

    public static void a() {
        ScheduleServiceConnection r0 = ScheduleServiceConnection.a;
        throw new RuntimeException("you need to invoke CapabilityScheduleSdk.init!");
    }

    public static void b() {
        via.b r0 = via.b.a;
        Intrinsics.checkNotNullParameter("CapabilityScheduleSdk", "tag");
        int r1 = via.a.a;
        List<a> r2 = b;
        monitor-enter(r2);
        Iterator r3 = ((ArrayList) r2).iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L8;
        a r4 = (a) r3.next();     // Catch: Throwable -> L12
        via.b r5 = via.b.a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("CapabilityScheduleSdk", "tag");     // Catch: Throwable -> L12
        int r6 = via.a.a;     // Catch: Throwable -> L12
        r4.call();     // Catch: Throwable -> L12
        goto L6
    L8:
        ((ArrayList) b).clear();     // Catch: Throwable -> L12
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r2);
        throw new RuntimeException("you need to invoke CapabilityScheduleSdk.init!");
    L12:
        th = move-exception;
        throw th;
    }

    public static void c() {
        Iterator<Function0<Unit>> r0 = c.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Function0<Unit> r1 = r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.invoke();     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        via.b r5 = via.b.a;
        ExceptionsKt.stackTraceToString(r4);
        Intrinsics.checkNotNullParameter("CapabilityScheduleSdk", "tag");
        int r6 = via.a.a;
        Intrinsics.checkNotNullParameter("ac_".concat("CapabilityScheduleSdk"), "tag");
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
