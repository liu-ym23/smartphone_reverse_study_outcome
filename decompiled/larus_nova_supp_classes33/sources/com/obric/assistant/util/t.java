package com.obric.assistant.util;

import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t {
    public static final Object a = null;
    public static final Set<String> b = null;

    static {
        a = new Object();
        b = new LinkedHashSet();
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "ownerId");
        Object r0 = a;
        monitor-enter(r0);
        Set<String> r1 = b;     // Catch: Throwable -> L16
        if (r1.remove(r2) == false) goto L9;
        if (r1.isEmpty() == false) goto L9;
        boolean r3 = true;
    L10:
        monitor-exit(r0);
        if (r3 == false) goto L21;
        IObricStateDispatcherService r4 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r4 == null) goto L22;
        r4.k();
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r3 = false;
    L16:
        th = move-exception;
        throw th;
    }
}
