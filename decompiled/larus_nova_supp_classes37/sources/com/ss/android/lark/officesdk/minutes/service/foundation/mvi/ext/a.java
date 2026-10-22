package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SubscribedSharedFlow;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static void a(i1 r7, CoroutineScope r8, final PropertyReference1Impl r9, final Function2 r10, Function2 r11, int r12) {
        if ((r12 & 8) == 0) goto L5;
        r10 = FlowExtKt$selectSubscribeLatest$1.INSTANCE;
    L5:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "prop1");
        Intrinsics.checkNotNullParameter(r10, "areEquivalent");
        Intrinsics.checkNotNullParameter(r11, "action");
        final SubscribedSharedFlow r1 = new SubscribedSharedFlow(r7, new FlowExtKt$selectSubscribeCustom$2(null, null));
        final boolean r13 = false;
        BuildersKt.launch$default(r8, null, null, new FlowExtKt$resolveSubscription$1(true, e.o(new FlowExtKt$selectSubscribeCustom$$inlined$map$1(r1, r9), new FlowExtKt$selectSubscribeCustom$4(r13, r10)), new FlowExtKt$selectSubscribeCustom$5(r11, null), null), 3, null);
    }
}
