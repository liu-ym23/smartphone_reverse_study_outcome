package com.larus.bmhome.chat.trace.imspan;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.trace.imspan.bean.SpanRecord;
import com.larus.trace.tracespan.span.b;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.imspan.IMSpanManager$reportRoot$1", f = "IMSpanManager.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class IMSpanManager$reportRoot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ String $msgId;
    final /* synthetic */ b $rootSpan;
    final /* synthetic */ JSONObject $trackParams;
    int label;

    public IMSpanManager$reportRoot$1(b r1, JSONObject r2, Integer r3, String r4, String r5, Continuation<? super IMSpanManager$reportRoot$1> r6) {
        this.$rootSpan = r1;
        this.$trackParams = r2;
        this.$errorCode = r3;
        this.$errorMsg = r4;
        this.$msgId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new IMSpanManager$reportRoot$1(this.$rootSpan, this.$trackParams, this.$errorCode, this.$errorMsg, this.$msgId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        this.$rootSpan.c(this.$trackParams);
        this.$rootSpan.g(this.$errorCode, this.$errorMsg);
        LruCache<String, String> r6 = IMSpanManager.a;
        String r7 = this.$msgId;
        SpanRecord r8 = (SpanRecord) IMSpanManager.b.remove(r7);
        FLogger r9 = FLogger.a;
        StringBuilder r2 = new StringBuilder("reportRoot, msg:");
        r2.append(this.$msgId);
        r2.append(", span:");
        int r3 = no8.b.a;
        r2.append(no8.b.a(this.$rootSpan, this.$errorCode, this.$errorMsg));
        r9.i("IM_SPAN_TRACING", r2.toString());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L11;
        return r0;
    }
}
