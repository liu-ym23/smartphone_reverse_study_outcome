package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1", f = "WidgetManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ String $packageName;
    int label;
    final /* synthetic */ WidgetManager this$0;

    public WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1(String r1, String r10, WidgetManager r11, Continuation<? super WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1> r12) {
        this.$packageName = r1;
        this.$appId = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1(this.$packageName, this.$appId, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        com.bytedance.ai.applet.base.log.b r11 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "onCompleteUpdate " + this.$packageName + ' ' + this.$appId);
        this.this$0.d.add(TuplesKt.to(this.$packageName, this.$appId));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
