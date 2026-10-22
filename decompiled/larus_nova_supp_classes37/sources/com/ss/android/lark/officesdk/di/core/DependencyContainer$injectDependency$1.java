package com.ss.android.lark.officesdk.di.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/officesdk/di/core/DependencyContainer$ContextDependencyBuilder;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class DependencyContainer$injectDependency$1 extends Lambda implements Function1<DependencyContainer.a, Unit> {
    final /* synthetic */ Class<? extends c<b>> $providerClass;
    final /* synthetic */ Class<b> $type;

    public DependencyContainer$injectDependency$1(Class<b> r1, Class<? extends c<b>> r2) {
        this.$type = r1;
        this.$providerClass = r2;
        super(1);
    }

    public final void invoke(DependencyContainer.a r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$injectDependency");
        r3.a(this.$type, this.$providerClass);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((DependencyContainer.a) r1);
        return Unit.INSTANCE;
    }
}
