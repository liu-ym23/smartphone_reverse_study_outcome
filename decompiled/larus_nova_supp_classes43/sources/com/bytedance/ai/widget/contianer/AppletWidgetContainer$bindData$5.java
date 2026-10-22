package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.model.objects.Widget;
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
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer$bindData$5", f = "AppletWidgetContainer.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
public final class AppletWidgetContainer$bindData$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.ai.widget.cache.b $resourceLoader;
    final /* synthetic */ Widget $widgetInfo;
    int label;
    final /* synthetic */ AppletWidgetContainer this$0;

    public AppletWidgetContainer$bindData$5(AppletWidgetContainer r1, Widget r10, com.bytedance.ai.widget.cache.b r11, Continuation<? super AppletWidgetContainer$bindData$5> r12) {
        this.this$0 = r1;
        this.$widgetInfo = r10;
        this.$resourceLoader = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletWidgetContainer$bindData$5(this.this$0, this.$widgetInfo, this.$resourceLoader, r11);
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
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletWidgetContainer r11 = this.this$0;
        Widget r12 = this.$widgetInfo;
        com.bytedance.ai.widget.cache.b r13 = this.$resourceLoader;
        this.label = 1;
        int r14 = AppletWidgetContainer.O;
        if (r11.z(r12, r13, this) != r0) goto L12;
        return r0;
    }
}
