package com.larus.bmhome.chat.bubble.floating.report;

import com.larus.bmhome.chat.bubble.floating.network.BubbleBannerApi;
import com.larus.bmhome.chat.bubble.floating.network.BubbleBannerShowReportRequest;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import pc8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.report.BubbleBannerShowReporter$reportShowInternal$1", f = "BubbleBannerShowReporter.kt", i = {}, l = {MessageCellStateTransformerType.BLOCK}, m = "invokeSuspend", n = {}, s = {})
public final class BubbleBannerShowReporter$reportShowInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bannerSource;
    final /* synthetic */ sc8.b $event;
    final /* synthetic */ long $showTime;
    int label;

    public BubbleBannerShowReporter$reportShowInternal$1(String r1, long r2, sc8.b r4, Continuation<? super BubbleBannerShowReporter$reportShowInternal$1> r5) {
        this.$bannerSource = r1;
        this.$showTime = r2;
        this.$event = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BubbleBannerShowReporter$reportShowInternal$1(this.$bannerSource, this.$showTime, this.$event, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L17:
        dm9.a.a r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.b) == true) goto L25;
        if ((r14 instanceof dm9.a.a) == false) goto L23;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("bubble banner show report failed, promptId=");
        r3.append(this.$event.b);
        r3.append(", bannerSource=");
        r3.append(this.$bannerSource);
        r3.append(", showTime=");
        r3.append(this.$showTime);
        r3.append(", code=");
        dm9.a.a r15 = r14;
        r3.append(r15.a);
        r3.append(", msg=");
        r3.append(r15.b);
        r2.e("BubbleBannerShowReporter", r3.toString(), r15.c);
        goto L25
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        String r4 = this.$bannerSource;
        long r5 = this.$showTime;
        c r6 = this.$event.l;
        if (r6 == null) goto L11;
        String r7 = r6.a;
    L12:
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        BubbleBannerShowReportRequest r16 = new BubbleBannerShowReportRequest(r4, r5, null, MapsKt.mapOf(TuplesKt.to("server_required", r7)), 4, null);
        BubbleBannerApi.a r8 = BubbleBannerApi.a;
        BubbleBannerShowReporter$reportShowInternal$1$result$1 r9 = new BubbleBannerShowReporter$reportShowInternal$1$result$1(r16, null);
        this.label = 1;
        r8.getClass();
        r13 = BubbleBannerApi.a.a(r9, this);
        if (r13 != r0) goto L17;
        return r0;
    L11:
        r7 = null;
        goto L12
    }
}
