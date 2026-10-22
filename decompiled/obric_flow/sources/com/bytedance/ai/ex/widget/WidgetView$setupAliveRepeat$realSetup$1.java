package com.bytedance.ai.ex.widget;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView$setupAliveRepeat$realSetup$1", f = "WidgetView.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetView$setupAliveRepeat$realSetup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<LifecycleOwner, View, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    int label;
    final /* synthetic */ WidgetView this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetView$setupAliveRepeat$realSetup$1(Function3<? super LifecycleOwner, ? super View, ? super Continuation<? super Unit>, ? extends Object> r5, LifecycleOwner r10, WidgetView r11, Continuation<? super WidgetView$setupAliveRepeat$realSetup$1> r12) {
        this.$block = r5;
        this.$lifecycleOwner = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new WidgetView$setupAliveRepeat$realSetup$1(this.$block, this.$lifecycleOwner, this.this$0, r10);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Function3<LifecycleOwner, View, Continuation<? super Unit>, Object> r12 = this.$block;
        LifecycleOwner r13 = this.$lifecycleOwner;
        WidgetView r14 = this.this$0;
        this.label = 1;
        if (r12.invoke(r13, r14, this) != r10) goto L12;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((WidgetView$setupAliveRepeat$realSetup$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
