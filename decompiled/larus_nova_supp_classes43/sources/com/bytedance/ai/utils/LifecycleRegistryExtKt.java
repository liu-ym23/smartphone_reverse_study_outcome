package com.bytedance.ai.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LifecycleRegistryExtKt {
    public static final void a(LifecycleRegistry r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "event");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new LifecycleRegistryExtKt$changeTo$1(r11, r10, null), 3, null);
    }
}
