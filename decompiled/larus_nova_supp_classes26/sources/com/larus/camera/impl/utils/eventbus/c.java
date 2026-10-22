package com.larus.camera.impl.utils.eventbus;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final MutableSharedFlow<g> a = null;
    public static final a1 b = null;

    static {
        MutableSharedFlow<g> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        a = r0;
        b = kotlinx.coroutines.flow.e.a(r0);
    }

    public static void a(CoroutineScope r7, g r8) {
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r8, "event");
        BuildersKt.launch$default(r7, null, null, new CameraEventBus$post$1(r8, null), 3, null);
    }
}
