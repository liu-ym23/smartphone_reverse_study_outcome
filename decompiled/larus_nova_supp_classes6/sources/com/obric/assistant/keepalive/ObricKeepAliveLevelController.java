package com.obric.assistant.keepalive;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ObricKeepAliveLevelController {
    public static final ObricKeepAliveLevelController a = null;
    public static volatile boolean b;
    public static volatile String c;
    public static volatile String d;
    public static final CopyOnWriteArrayList<Function1<String, Unit>> e = null;
    public static final CoroutineScope f = null;
    public static Job g;

    public ObricKeepAliveLevelController() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        Job r0 = g;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L9
    L6:
        g = BuildersKt.launch$default(f, null, null, new ObricKeepAliveLevelController$scheduleClearDoraPrivateLinkOverlay$1(null), 3, null);     // Catch: Throwable -> L9
        FLogger.a.i("ObricKeepAliveLevel", "schedule clear dora private link overlay after 5000ms");     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        a = new ObricKeepAliveLevelController();
        e = new CopyOnWriteArrayList();
        f = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    public final synchronized boolean b(String r7) {
        String r2 = "dora_private_link";
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("dora_private_link", "scene");     // Catch: Throwable -> L35
        String r3 = c;     // Catch: Throwable -> L35
        if (r3 != null) goto L8;
        r3 = ObricFeatureServiceDelegate.b.f();     // Catch: Throwable -> L35
    L8:
        if (Intrinsics.areEqual(c, r7) == false) goto L13;
        FLogger.a.i("ObricKeepAliveLevel", "setKeepAliveLevelOverlay skip, scene=dora_private_link, overlay=" + r7 + ", overlayScene=" + d + ", level=" + r3);     // Catch: Throwable -> L35
        monitor-exit(this);
        return false;
    L13:
        c = r7;     // Catch: Throwable -> L35
        if (r7 != null) goto L16;
        r2 = null;
    L16:
        d = r2;     // Catch: Throwable -> L35
        String r1 = c;     // Catch: Throwable -> L35
        if (r1 != null) goto L19;
        r1 = ObricFeatureServiceDelegate.b.f();     // Catch: Throwable -> L35
    L19:
        FLogger.a.i("ObricKeepAliveLevel", "setKeepAliveLevelOverlay scene=dora_private_link, overlay=" + r7 + ", oldLevel=" + r3 + ", newLevel=" + r1);     // Catch: Throwable -> L35
        boolean r8 = Intrinsics.areEqual(r3, r1) ^ true;     // Catch: Throwable -> L35
        if (r8 == false) goto L33;
        Iterator<Function1<String, Unit>> r0 = e.iterator();     // Catch: Throwable -> L35
    L23:
        if (r0.hasNext() == false) goto L33;
        Function1<String, Unit> r4 = r0.next();     // Catch: Throwable -> L35
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L27
        r4.invoke(r1);     // Catch: Throwable -> L27
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r9 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L35
        if (r9 == null) goto L23;
        FLogger.a.e("ObricKeepAliveLevel", "notify keep alive level listener failed", r9);     // Catch: Throwable -> L35
        goto L23
    L27:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L35
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);
        return r8;
    L35:
        th = move-exception;
        throw th;
    }
}
