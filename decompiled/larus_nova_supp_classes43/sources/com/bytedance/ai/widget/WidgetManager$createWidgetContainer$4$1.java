package com.bytedance.ai.widget;

import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.PendingWidgetPerformanceTracker;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager$createWidgetContainer$4$1", f = "WidgetManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetManager$createWidgetContainer$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Throwable $cause;
    final /* synthetic */ PendingWidgetPerformanceTracker $pendingTracker;
    final /* synthetic */ AppletWidgetContainer $widgetContainer;
    int label;

    public WidgetManager$createWidgetContainer$4$1(PendingWidgetPerformanceTracker r1, Throwable r10, AppletWidgetContainer r11, Continuation<? super WidgetManager$createWidgetContainer$4$1> r12) {
        this.$pendingTracker = r1;
        this.$cause = r10;
        this.$widgetContainer = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WidgetManager$createWidgetContainer$4$1(this.$pendingTracker, this.$cause, this.$widgetContainer, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        PendingWidgetPerformanceTracker r11 = this.$pendingTracker;
        AppletPerformanceErrorCode r0 = AppletPerformanceErrorCode.CANCELLED;
        String r1 = ((CancellationException) this.$cause).getMessage();
        if (r1 != null) goto L7;
        r1 = this.$cause.getClass().getSimpleName();
    L7:
        r11.c(r0, "createWidgetContainer interrupted: ".concat(r1));
        this.$widgetContainer.onDestroy();
        this.$widgetContainer.onHostDestroy();
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
