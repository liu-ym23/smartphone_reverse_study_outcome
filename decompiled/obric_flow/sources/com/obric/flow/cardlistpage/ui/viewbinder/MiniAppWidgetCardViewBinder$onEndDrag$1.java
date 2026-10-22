package com.obric.flow.cardlistpage.ui.viewbinder;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.viewbinder.MiniAppWidgetCardViewBinder$onEndDrag$1", f = "MiniAppWidgetCardViewBinder.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppWidgetCardViewBinder$onEndDrag$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<BaseCardModel> $snapshot;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniAppWidgetCardViewBinder$onEndDrag$1(List<? extends BaseCardModel> r5, Continuation<? super MiniAppWidgetCardViewBinder$onEndDrag$1> r10) {
        this.$snapshot = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new MiniAppWidgetCardViewBinder$onEndDrag$1(this.$snapshot, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        List<BaseCardModel> r12 = this.$snapshot;
        if (r12 == null) goto L14;
        this.label = 1;
        if (m.b(r12, this) != r10) goto L14;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((MiniAppWidgetCardViewBinder$onEndDrag$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
