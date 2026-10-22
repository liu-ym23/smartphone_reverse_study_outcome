package com.larus.business.markdown.impl.widget;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import pw8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$updateWidgetFromNode$1$1", f = "MarkdownWidgetHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownWidgetHelper$updateWidgetFromNode$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ ViewGroup $currentParentViewGroup;
    final /* synthetic */ int $index;
    int label;

    public MarkdownWidgetHelper$updateWidgetFromNode$1$1(a r1, int r2, ViewGroup r3, Continuation<? super MarkdownWidgetHelper$updateWidgetFromNode$1$1> r4) {
        this.$callback = r1;
        this.$index = r2;
        this.$currentParentViewGroup = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MarkdownWidgetHelper$updateWidgetFromNode$1$1(this.$callback, this.$index, this.$currentParentViewGroup, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        a r4 = this.$callback;
        if (r4 == null) goto L8;
        r4.b(this.$index, this.$currentParentViewGroup);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
