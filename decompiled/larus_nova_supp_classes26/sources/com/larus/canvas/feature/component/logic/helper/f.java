package com.larus.canvas.feature.component.logic.helper;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final void a(StateFlowImpl r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "reducer");
        r1.setValue(r2.invoke(r1.getValue()));
    }
}
