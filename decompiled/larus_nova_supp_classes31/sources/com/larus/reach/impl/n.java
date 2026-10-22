package com.larus.reach.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n {
    public final CoroutineScope a;

    public static final class a {
    }

    static {
    }

    public n() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final void a(ns9.t r13) {
        Intrinsics.checkNotNullParameter(r13, "request");
        if (c.a(r13) == true) goto L5;
        return;
    L5:
        String r0 = r13.a.a;
        if (r0 != null) goto L8;
        return;
    L8:
        long r2 = System.currentTimeMillis();
        String r14 = r13.e.a.get("request_info");
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        Map r5 = MapsKt.mapOf(TuplesKt.to("server_required", r14));
        String r15 = StringsKt.trim(r0).toString();
        if (r15.length() <= 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        r15 = null;
    L18:
        String r4 = r15;
        if (r4 == null) goto L23;
        BuildersKt.launch$default(this.a, null, null, new ReachShowReporter$reportShow$1(r2, r4, r5, null), 3, null);
        return;
    L23:
        return;
    L14:
        r1 = false;
        goto L15
    }
}
