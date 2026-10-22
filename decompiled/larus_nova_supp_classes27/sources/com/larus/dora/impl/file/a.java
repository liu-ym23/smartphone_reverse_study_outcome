package com.larus.dora.impl.file;

import com.larus.dora.impl.DoraBuryPointManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void a(String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "params");
        g49.d.a("DoraDefaultEventReporter", "report event=" + r4 + ", params=" + r5);
        DoraBuryPointManager.J(DoraBuryPointManager.a, r4, r5, false, 12);
    }
}
