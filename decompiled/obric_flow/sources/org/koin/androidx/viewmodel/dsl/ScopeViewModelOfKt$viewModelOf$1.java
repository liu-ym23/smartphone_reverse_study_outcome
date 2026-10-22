package org.koin.androidx.viewmodel.dsl;

import androidx.lifecycle.ViewModel;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/lifecycle/ViewModel;", "R", "Lorg/koin/core/scope/a;", "Lvu/a;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Landroidx/lifecycle/ViewModel;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScopeViewModelOf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScopeViewModelOf.kt\norg/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt$viewModelOf$1\n+ 2 New.kt\norg/koin/core/module/dsl/NewKt\n*L\n1#1,224:1\n35#2:225\n*S KotlinDebug\n*F\n+ 1 ScopeViewModelOf.kt\norg/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt$viewModelOf$1\n*L\n48#1:225\n*E\n"})
public final class ScopeViewModelOfKt$viewModelOf$1 extends Lambda implements Function2<a, vu.a, ViewModel> {
    final /* synthetic */ Function0<ViewModel> $constructor;

    public ScopeViewModelOfKt$viewModelOf$1(Function0<ViewModel> r5) {
        this.$constructor = r5;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewModel invoke2(a r5, vu.a r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$viewModel");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        return this.$constructor.invoke();
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ ViewModel mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }
}
