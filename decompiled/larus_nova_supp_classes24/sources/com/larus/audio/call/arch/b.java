package com.larus.audio.call.arch;

import com.larus.audio.call.plugins.s0;
import com.larus.audio.call.plugins.t0;
import com.larus.audio.call.plugins.v0;
import com.larus.audio.call.plugins.y0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final t0 a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (t0) r2.b(Reflection.getOrCreateKotlinClass(t0.class), null);
    }

    public static final v0 b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (v0) r2.c(Reflection.getOrCreateKotlinClass(v0.class), null);
    }

    public static final s0 c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (s0) r2.b(Reflection.getOrCreateKotlinClass(s0.class), null);
    }

    public static final y0 d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (y0) r2.c(Reflection.getOrCreateKotlinClass(y0.class), null);
    }

    public static final void e(c r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "block");
        CoroutineScope r1 = r7.r();
        if (r1 != null) goto L6;
        com.larus.audio.call.util.e.a.e("RealtimePluginKtx", "runInMain called, scope == null");
        return;
    L6:
        BuildersKt.launch$default(r1, Dispatchers.getMain(), null, new CommonLLMPluginKtxKt$runInMain$1(r8, null), 2, null);
    }
}
