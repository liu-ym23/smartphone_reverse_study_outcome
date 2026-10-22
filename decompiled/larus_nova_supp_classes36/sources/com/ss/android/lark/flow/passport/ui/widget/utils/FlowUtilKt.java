package com.ss.android.lark.flow.passport.ui.widget.utils;

import androidx.core.app.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowUtilKt {

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

    public static final void a(ComponentActivity r2, i1 r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "flow");
        Intrinsics.checkNotNullParameter(r4, "collect");
        LifecycleOwnerKt.getLifecycleScope(r2).launchWhenResumed(new FlowUtilKt$collectLatestLifecycleFlow$2(r3, r4, null));
    }

    public static final void b(ComponentActivity r2, d1 r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "flow");
        Intrinsics.checkNotNullParameter(r4, "collect");
        LifecycleOwnerKt.getLifecycleScope(r2).launchWhenResumed(new FlowUtilKt$collectLifecycleFlow$2(r3, r4, null));
    }

    public static final <T> void c(Fragment r2, Flow<? extends T> r3, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "flow");
        Intrinsics.checkNotNullParameter(r4, "collect");
        LifecycleOwnerKt.getLifecycleScope(r2).launchWhenResumed(new FlowUtilKt$collectLifecycleFlow$1(r3, r4, null));
    }
}
