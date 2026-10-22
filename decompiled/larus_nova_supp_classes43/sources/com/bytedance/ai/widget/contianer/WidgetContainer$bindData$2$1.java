package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AppletResourceTool;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer$bindData$2$1", f = "WidgetContainer.kt", i = {}, l = {773}, m = "invokeSuspend", n = {}, s = {})
final class WidgetContainer$bindData$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $widgetContainerData;
    Object L$0;
    int label;
    final /* synthetic */ WidgetContainer this$0;

    public WidgetContainer$bindData$2$1(WidgetContainer r1, m r10, Continuation<? super WidgetContainer$bindData$2$1> r11) {
        this.this$0 = r1;
        this.$widgetContainerData = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WidgetContainer$bindData$2$1(this.this$0, this.$widgetContainerData, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        WidgetContainer r11 = (WidgetContainer) this.L$0;
        ResultKt.throwOnFailure(r10);
    L12:
        r11.h = (Widget) r10;
        WidgetContainer r12 = this.this$0;
        Widget r13 = r12.h;
        if (r13 == null) goto L16;
        int r14 = com.bytedance.ai.utils.b.a;
        r12.i = com.bytedance.ai.utils.b.a(r13.T);
        AppletResourceTool.m(AppletResourceTool.a, r13, r13.L);
        r12.w(r12.j);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WidgetContainer r15 = this.this$0;
        WidgetContainer r16 = this.this$0;
        m r17 = this.$widgetContainerData;
        this.L$0 = r15;
        this.label = 1;
        Object r18 = WidgetContainer.p(r16, r17, this);
        if (r18 != r0) goto L11;
        return r0;
    L11:
        r11 = r15;
        r10 = r18;
        goto L12
    }
}
