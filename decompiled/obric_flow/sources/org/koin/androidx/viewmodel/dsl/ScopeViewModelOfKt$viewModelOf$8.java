package org.koin.androidx.viewmodel.dsl;

import androidx.lifecycle.ViewModel;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000e\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u0001\"\u0006\b\u0004\u0010\u0005\u0018\u0001\"\u0006\b\u0005\u0010\u0006\u0018\u0001\"\u0006\b\u0006\u0010\u0007\u0018\u0001\"\u0006\b\u0007\u0010\b\u0018\u0001*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Landroidx/lifecycle/ViewModel;", "R", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "Lorg/koin/core/scope/a;", "Lvu/a;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Landroidx/lifecycle/ViewModel;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScopeViewModelOf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScopeViewModelOf.kt\norg/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt$viewModelOf$8\n+ 2 New.kt\norg/koin/core/module/dsl/NewKt\n+ 3 Scope.kt\norg/koin/core/scope/Scope\n*L\n1#1,224:1\n84#2:225\n132#3,5:226\n*S KotlinDebug\n*F\n+ 1 ScopeViewModelOf.kt\norg/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt$viewModelOf$8\n*L\n104#1:225\n104#1:226,5\n*E\n"})
public final class ScopeViewModelOfKt$viewModelOf$8 extends Lambda implements Function2<a, vu.a, ViewModel> {
    final /* synthetic */ Function7<Object, Object, Object, Object, Object, Object, Object, ViewModel> $constructor;

    public ScopeViewModelOfKt$viewModelOf$8(Function7<Object, Object, Object, Object, Object, Object, Object, ViewModel> r5) {
        this.$constructor = r5;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewModel invoke2(a r10, vu.a r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$viewModel");
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        Function7<Object, Object, Object, Object, Object, Object, Object, ViewModel> r5 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object r12 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object r13 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object r14 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object r15 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        Object r16 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        Object r17 = r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        return r5.invoke(r12, r13, r14, r15, r16, r17, r10.b(null, Reflection.getOrCreateKotlinClass(Object.class), null));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ ViewModel mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }
}
