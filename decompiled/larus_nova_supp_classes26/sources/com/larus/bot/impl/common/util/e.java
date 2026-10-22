package com.larus.bot.impl.common.util;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.Function;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {

    public static final class a implements FlowCollector, FunctionAdapter {
        public final /* synthetic */ Function2 a;

        public a(Function2 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final /* synthetic */ Object emit(Object r2, Continuation r3) {
            return this.a.invoke(r2, r3);
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    public static final c1 b(MutableSharedFlow r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new c1(new FlowExtKt$throttleFirst$1(r4, 1000, null));
    }

    public static final void a(d1 r7, LifecycleCoroutineScope r8, Function2 r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "action");
        BuildersKt.launch$default(r8, null, null, new FlowExtKt$collectIn$1(r7, r9, null), 3, null);
    }
}
