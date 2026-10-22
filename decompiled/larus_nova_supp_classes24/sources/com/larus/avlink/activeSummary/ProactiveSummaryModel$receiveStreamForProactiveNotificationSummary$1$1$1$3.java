package com.larus.avlink.activeSummary;

import android.os.SystemClock;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.avlink.n1;
import java.io.BufferedReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "chunkPackage", "Lcom/larus/avlink/activeSummary/ChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3", f = "ProactiveSummaryModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3 extends SuspendLambda implements Function2<a, Continuation<? super Unit>, Object> {
    final /* synthetic */ BufferedReader $br;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProactiveSummaryModel this$0;

    public ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3(ProactiveSummaryModel r1, BufferedReader r2, Continuation<? super ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3> r3) {
        this.this$0 = r1;
        this.$br = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3 r0 = new ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1$1$1$3(this.this$0, this.$br, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(a r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((a) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r7);
        a r8 = (a) this.L$0;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] ChunkParser.parseStream " + r8.b + " -> " + r8.c);
        if (Intrinsics.areEqual(r8.b, "done") == false) goto L16;
        this.this$0.b = false;
        if (this.this$0.d == true) goto L9;
    L11:
        boolean r9 = false;
    L12:
        this.this$0.d = false;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receive END package");
        this.$br.close();
        if (r9 == false) goto L24;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:SSE_DONE_Reconnect: reconnect after done....");
        this.this$0.h("SSE_DONE_Reconnect", false);
    L24:
        return Unit.INSTANCE;
    L9:
        if (SystemClock.elapsedRealtime() >= this.this$0.c) goto L11;
        r9 = true;
        goto L12
    L16:
        if (Intrinsics.areEqual(r8.b, "json") == false) goto L24;
        JSONObject r0 = new JSONObject(r8.c);
        String r10 = r0.optString("command_name", "");
        if (Intrinsics.areEqual(r10, "dora_notification_summary") == false) goto L21;
        String r11 = r0.optString("summary_id", "");
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] onNotificationSummaryGenerated summaryId ---> " + r11);
        ProactiveSummaryModel r1 = this.this$0;
        Intrinsics.checkNotNull(r11);
        r1.d(r11, ProactiveSummarySource.SSE_FRONTIER);
        goto L24
    L21:
        if (Intrinsics.areEqual(r10, "dora_auto_greet") == false) goto L24;
        String r12 = r0.optString("summary_id", "");
        n1.a("ProactiveSummaryRecords", "[AutoGreetTracer] onAutoGreetReceived summaryId ---> " + r12);
        ProactiveSummaryModel r2 = this.this$0;
        Intrinsics.checkNotNull(r12);
        r2.d(r12, ProactiveSummarySource.SSE_FRONTIER);
        goto L24
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
