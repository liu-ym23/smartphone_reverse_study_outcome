package com.larus.agents.impl.webfetch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/impl/webfetch/WebFetchReportAck;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.webfetch.WebFetchCommandProcessor$report$2$ack$response$1", f = "WebFetchCommandProcessor.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
public final class WebFetchCommandProcessor$report$2$ack$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WebFetchReportAck>, Object> {
    final /* synthetic */ WebFetchCommandProcessor$b $entry;
    final /* synthetic */ l $outcome;
    int label;
    final /* synthetic */ WebFetchCommandProcessor this$0;

    public WebFetchCommandProcessor$report$2$ack$response$1(WebFetchCommandProcessor r1, WebFetchCommandProcessor$b r2, l r3, Continuation<? super WebFetchCommandProcessor$report$2$ack$response$1> r4) {
        this.this$0 = r1;
        this.$entry = r2;
        this.$outcome = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new WebFetchCommandProcessor$report$2$ack$response$1(this.this$0, this.$entry, this.$outcome, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super WebFetchReportAck> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        d r7 = this.this$0.b;
        i r2 = this.$entry.a;
        l r3 = this.$outcome;
        this.label = 1;
        r7.getClass();
        r6 = BuildersKt.withContext(Dispatchers.getIO(), new NetworkWebFetchReporter$report$2(r2, r3, null), this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
