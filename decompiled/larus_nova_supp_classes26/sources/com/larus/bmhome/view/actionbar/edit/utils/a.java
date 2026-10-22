package com.larus.bmhome.view.actionbar.edit.utils;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static void a(CoroutineScope r4, Function2 r5) {
        EmptyCoroutineContext r0 = EmptyCoroutineContext.INSTANCE;
        CoroutineStart r1 = CoroutineStart.DEFAULT;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "start");
        Intrinsics.checkNotNullParameter(r5, "block");
        BuildersKt.launch(r4, r0, r1, new InstructionExtKt$launchSafely$1(r5, null));
    }
}
