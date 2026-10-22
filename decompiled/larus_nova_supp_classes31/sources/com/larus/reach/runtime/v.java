package com.larus.reach.runtime;

import com.larus.reach.api.ReachBannerHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static long b() {
        ns9.k r0 = ns9.k.a;
        monitor-enter(r0);
        long r1 = ns9.k.c;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c() {
        ns9.k r0 = ns9.k.a;
        monitor-enter(r0);
        ns9.k.c++;     // Catch: Throwable -> L9
        Function0<Unit> r1 = ns9.k.b;     // Catch: Throwable -> L9
        ns9.k.b = null;     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r1 == null) goto L14;
        r1.invoke();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static ReachBannerHost d(final ns9.t r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Set r0 = ServiceManager.get().getServices(ReachBannerHost.class, true);
        if (r0 != null) goto L6;
        r0 = SetsKt.emptySet();
    L6:
        return (ReachBannerHost) SequencesKt.firstOrNull(SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.toList(r0)), new u(r3)));
    }

    public static boolean a(long r4, Function0 r6) {
        Intrinsics.checkNotNullParameter(r6, "waiter");
        ns9.k r0 = ns9.k.a;
        Intrinsics.checkNotNullParameter(r6, "waiter");
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (ns9.k.c == r4) goto L7;
        boolean r5 = false;
    L9:
        monitor-exit(r0);
        return r5;
    L7:
        ns9.k.b = r6;     // Catch: Throwable -> L11
        r5 = true;
        goto L9
    }
}
