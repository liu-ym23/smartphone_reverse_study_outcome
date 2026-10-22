package com.larus.agents.impl.webfetch;

import com.bytedance.retrofit2.HttpException;
import com.bytedance.retrofit2.SsResponse;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.im.FlowRuntime;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/impl/webfetch/WebFetchReportAck;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.webfetch.NetworkWebFetchReporter$report$2", f = "WebFetchResultApi.kt", i = {0}, l = {46}, m = "invokeSuspend", n = {"commandId"}, s = {"L$0"})
final class NetworkWebFetchReporter$report$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WebFetchReportAck>, Object> {
    final /* synthetic */ i $command;
    final /* synthetic */ l $outcome;
    Object L$0;
    int label;

    public NetworkWebFetchReporter$report$2(i r1, l r2, Continuation<? super NetworkWebFetchReporter$report$2> r3) {
        this.$command = r1;
        this.$outcome = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NetworkWebFetchReporter$report$2(this.$command, this.$outcome, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super WebFetchReportAck> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r2 = this.label;
        boolean r3 = false;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        Object r7 = r19;
        r2 = r4;
    L30:
        m r8 = (m) r7;     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        if (r8 == null) goto L38;
        Long r1 = r8.a();     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        if (r1 == null) goto L38;
        if (r1.longValue() != 0) goto L38;
        boolean r5 = true;
    L39:
        if (r5 == false) goto L41;
        WebFetchReportAck r6 = WebFetchReportAck.ACCEPTED;     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
    L42:
        FLogger r9 = FLogger.a;     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        StringBuilder r10 = new StringBuilder("command_id=");     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        r10.append(r2);     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        r10.append(" result_transport_complete ack_code=");     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        if (r8 == null) goto L45;
        Long r11 = r8.a();     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
    L46:
        r10.append(r11);     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        r10.append(" result=");     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        r10.append(r6);     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        r9.i("WebPageFetch", r10.toString());     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
    L72:
        return r6;
    L45:
        r11 = null;
        goto L46
    L41:
        r6 = WebFetchReportAck.REJECTED;     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
    L38:
        r5 = false;
        goto L39
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r19);
        String r12 = k.a(this.$command.a);
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("command_id=");
        r14.append(r12);
        r14.append(" result_transport_start success=");
        if (this.$outcome.b == null) goto L21;
        boolean r15 = true;
    L22:
        r14.append(r15);
        r14.append(" reason=");
        r14.append(this.$outcome.c);
        r14.append(" status=");
        r14.append(this.$outcome.a);
        r13.i("WebPageFetch", r14.toString());
        String r16 = com.larus.platform.service.o.a.getDeviceId();
        int r17 = FlowRuntime.b().a().appId();
        if (StringsKt.isBlank(r16) == true) goto L65;
        if (r17 <= 0) goto L65;
        WebFetchResultApi r20 = (WebFetchResultApi) FlowHttpConnection.c(FlowHttpConnection.a, "Basic", WebFetchResultApi.class, null, null, null, 28);
        s r21 = q.a(this.$command, this.$outcome, r16, r17);     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        this.L$0 = r12;     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        this.label = 1;     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        r7 = r20.report(r21, this);     // Catch: Exception -> L8 IOException -> L10 HttpException -> L12 CancellationException -> L14
        r2 = r12;
        if (r7 != r0) goto L30;
        return r0;
    L65:
        r13.i("WebPageFetch", "command_id=" + r12 + " result_transport_failed reason=local_identity_unavailable");
        return WebFetchReportAck.REJECTED;
    L21:
        r15 = false;
    L10:
        e = move-exception;
        FLogger.a.i("WebPageFetch", "command_id=" + r2 + " result_transport_failed reason=io exception_type=" + e.getClass().getSimpleName());
        return WebFetchReportAck.RETRYABLE;
    L14:
        e = move-exception;
        FLogger.a.i("WebPageFetch", "command_id=" + r2 + " result_transport_cancelled");
        throw e;
    L8:
        e = move-exception;
        FLogger.a.i("WebPageFetch", "command_id=" + r2 + " result_transport_failed reason=exception exception_type=" + e.getClass().getSimpleName());
        return WebFetchReportAck.REJECTED;
    L12:
        e = move-exception;
        SsResponse r22 = e.response();
        if (r22 == null) goto L53;
        int r23 = r22.code();
    L54:
        FLogger.a.i("WebPageFetch", "command_id=" + r2 + " result_transport_failed reason=http status=" + r23);
        if (500 <= r23) goto L57;
    L59:
        if (r3 == false) goto L62;
        return WebFetchReportAck.RETRYABLE;
    L62:
        return WebFetchReportAck.REJECTED;
    L57:
        if (r23 >= 600) goto L59;
        r3 = true;
        goto L59
    L53:
        r23 = 0;
        goto L54
    }
}
