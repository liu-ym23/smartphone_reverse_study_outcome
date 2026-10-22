package com.bytedance.ai.infra.thread_pool;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AISdkCoroutineUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Function2 r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(b.a), null, null, new AISdkCoroutineUtil$runInCommonIOPool$1(r10, null), 3, null);
    }
}
