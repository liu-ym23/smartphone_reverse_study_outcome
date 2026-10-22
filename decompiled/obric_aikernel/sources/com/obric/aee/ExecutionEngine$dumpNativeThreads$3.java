package com.obric.aee;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class ExecutionEngine$dumpNativeThreads$3 extends Lambda implements Function1<Map.Entry<? extends Thread, ? extends StackTraceElement[]>, Comparable<?>> {
    public static final ExecutionEngine$dumpNativeThreads$3 INSTANCE = null;

    static {
        INSTANCE = new ExecutionEngine$dumpNativeThreads$3();
    }

    ExecutionEngine$dumpNativeThreads$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(Map.Entry<? extends Thread, StackTraceElement[]> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return Long.valueOf(r10.getKey().getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(Map.Entry<? extends Thread, ? extends StackTraceElement[]> r10) {
        return invoke2(r10);
    }
}
