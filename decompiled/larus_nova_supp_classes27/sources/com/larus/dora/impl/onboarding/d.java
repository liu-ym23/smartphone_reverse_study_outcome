package com.larus.dora.impl.onboarding;

import android.os.SystemClock;
import com.larus.avlink.api.IDoraAVLinkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static long d;
    public static volatile int e;
    public static Function1<? super z98.f, Unit> f;

    static {
    }

    public static boolean a() {
        if ((SystemClock.elapsedRealtime() - d) > 3000) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(Function1 r2) {
        f = r2;
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 == null) goto L6;
        r0.m(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(final WeakReference r2) {
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 == null) goto L9;
        if (r2 != null) goto L6;
        b r3 = 0;
    L7:
        r0.K(r3);
        return;
    L6:
        r3 = new b(r2);
        goto L7
    }
}
