package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.avlink.n1;
import com.larus.network.http.HttpExtKt;
import java.io.BufferedReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1", f = "ProactiveSummaryModel.kt", i = {0, 1, 1}, l = {653, 657, 713}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "br"}, s = {"L$0", "L$0", "L$1"})
public final class ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $bodyJson;
    final /* synthetic */ String $trigger;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ProactiveSummaryModel this$0;

    public ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1(String r1, JSONObject r2, ProactiveSummaryModel r3, Continuation<? super ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1> r4) {
        this.$trigger = r1;
        this.$bodyJson = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1 r0 = new ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1(this.$trigger, this.$bodyJson, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ProactiveSummaryModel r2 = (ProactiveSummaryModel) this.L$0;
        ResultKt.throwOnFailure(r12);
    L42:
        int r13 = ProactiveSummaryModel.g;
        r2.h("call_stream_is_null", true);
    L44:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ProactiveSummaryModel r3 = (ProactiveSummaryModel) this.L$2;
        BufferedReader r4 = (BufferedReader) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L13
    L26:
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L32:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L44;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] e : " + r15);
        r3.b = false;
        r3.d = false;
        r4.close();
        r3.h("CoroutineException_(Timeout)_Exception", false);
    L13:
        Throwable th = th;
        ProactiveSummaryModel r6 = r3;
    L31:
        Result.Companion r7 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        r3 = r6;
        goto L32
    L15:
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        final BufferedReader r16 = ((com.larus.network.http.g) r12).f;
        if (r16 == null) goto L36;
        r6 = this.this$0;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L29
        ChunkParser r10 = ChunkParser.a;     // Catch: Throwable -> L29
        Function0<String> r11 = new g(r16);     // Catch: Throwable -> L29
        Function0<Unit> r17 = new h(r16);     // Catch: Throwable -> L29
        ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3 r19 = new ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3(r6, r16, null);     // Catch: Throwable -> L29
        this.L$0 = r8;     // Catch: Throwable -> L29
        this.L$1 = r16;     // Catch: Throwable -> L29
        this.L$2 = r6;     // Catch: Throwable -> L29
        this.label = 2;     // Catch: Throwable -> L29
        if (r10.a(r11, r17, r19, this) != r0) goto L25;
        return r0;
    L25:
        r4 = r16;
        r3 = r6;
    L29:
        th = move-exception;
        r4 = r16;
        th = th;
        goto L31
    L36:
        ProactiveSummaryModel r110 = this.this$0;
        r110.b = false;
        r110.d = false;
        n1.b("ProactiveSummaryRecords", "[NotificationTracer] httpStreamPull call.stream is null");
        int r20 = r110.a;
        if (r20 >= 2) goto L44;
        r110.a = r20 + 1;
        this.L$0 = r110;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (DelayKt.delay(100, this) != r0) goto L41;
        return r0;
    L41:
        r2 = r110;
        goto L42
    L16:
        ResultKt.throwOnFailure(r12);
        r8 = (CoroutineScope) this.L$0;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary exec trigger:" + this.$trigger);
        JSONObject r111 = this.$bodyJson;
        this.L$0 = r8;
        this.label = 1;
        r12 = HttpExtKt.n("/alice/audio/notification_summary", r111, null, 28);
        if (r12 != r0) goto L19;
        return r0;
    }
}
