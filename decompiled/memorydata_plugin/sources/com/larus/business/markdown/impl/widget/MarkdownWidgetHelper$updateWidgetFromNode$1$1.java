package com.larus.business.markdown.impl.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$updateWidgetFromNode$1$1", f = "MarkdownWidgetHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownWidgetHelper$updateWidgetFromNode$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.business.markdown.api.d.a $callback;
    final /* synthetic */ ViewGroup $currentParentViewGroup;
    final /* synthetic */ int $index;
    int label;

    MarkdownWidgetHelper$updateWidgetFromNode$1$1(com.larus.business.markdown.api.d.a r3, int r4, ViewGroup r5, Continuation<? super MarkdownWidgetHelper$updateWidgetFromNode$1$1> r6) {
        com.larus.business.markdown.api.d.a r7 = (com.larus.business.markdown.api.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.d.a.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$callback = r7;
        this.$index = r4;
        this.$currentParentViewGroup = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MarkdownWidgetHelper$updateWidgetFromNode$1$1(this.$callback, this.$index, this.$currentParentViewGroup, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MarkdownWidgetHelper$updateWidgetFromNode$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MarkdownWidgetHelper$updateWidgetFromNode$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        com.larus.business.markdown.api.d.a r3 = this.$callback;
        if (r3 == null) goto L8;
        r3.a(this.$index, this.$currentParentViewGroup);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
