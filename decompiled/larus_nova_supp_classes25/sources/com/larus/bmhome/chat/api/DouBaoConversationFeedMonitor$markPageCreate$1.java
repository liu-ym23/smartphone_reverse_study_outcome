package com.larus.bmhome.chat.api;

import android.os.SystemClock;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.DouBaoConversationFeedMonitor$markPageCreate$1", f = "DouBaoConversationFeedMonitor.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
final class DouBaoConversationFeedMonitor$markPageCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ o this$0;

    public DouBaoConversationFeedMonitor$markPageCreate$1(o r1, Continuation<? super DouBaoConversationFeedMonitor$markPageCreate$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DouBaoConversationFeedMonitor$markPageCreate$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        o r8 = this.this$0;
        r8.q = null;
        if (r8.n == true) goto L20;
        if (r8.l == true) goto L20;
        if (((Boolean) r8.f.invoke()).booleanValue() == false) goto L20;
        long r2 = SystemClock.elapsedRealtime();
        JSONObject r3 = new JSONObject();
        r3.put("scene", r8.a);
        r3.put("feed_error_status", !((Boolean) r8.e.invoke()).booleanValue() ? 1 : 0);
        r3.put("enter_duration", RangesKt.coerceAtLeast(r2 - r8.o, 0));
        r8.a(r3);
        FLogger.a.i("DouBaoConversationFeedMonitor", "report event=cvs_list_page_empty payload=" + r3);
        com.larus.platform.service.o.a.reportEvent("cvs_list_page_empty", r3);
        r8.l = true;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        o r9 = this.this$0;
        int r4 = o.r;
        r9.getClass();
        long r5 = z2.a.getLarkMixedFeedMonitorConfig().a();
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L11;
        return r0;
    }
}
