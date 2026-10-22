package org.koin.androidx.scope;

import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import wn.h;
import wu.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/koin/core/a;", "k", "Lorg/koin/core/scope/a;", "invoke", "(Lorg/koin/core/a;)Lorg/koin/core/scope/a;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class LifecycleViewModelScopeDelegate$1 extends Lambda implements Function1<org.koin.core.a, org.koin.core.scope.a> {
    final /* synthetic */ ComponentActivity $lifecycleOwner;

    public LifecycleViewModelScopeDelegate$1(ComponentActivity r5) {
        this.$lifecycleOwner = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ org.koin.core.scope.a invoke(org.koin.core.a r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final org.koin.core.scope.a invoke2(org.koin.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "k");
        c r10 = h.l(this.$lifecycleOwner);
        c r11 = h.l(this.$lifecycleOwner);
        return r5.b(r10.f22909b, r11, null);
    }
}
