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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.report.BannerShowReportServiceImpl$reportShow$1", f = "BannerShowReportServiceImpl.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class BannerShowReportServiceImpl$reportShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bannerSource;
    final /* synthetic */ a $input;
    final /* synthetic */ String $serverRequired;
    int label;

    public BannerShowReportServiceImpl$reportShow$1(String r1, a r2, String r3, Continuation<? super BannerShowReportServiceImpl$reportShow$1> r4) {
        this.$bannerSource = r1;
        this.$input = r2;
        this.$serverRequired = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BannerShowReportServiceImpl$reportShow$1(this.$bannerSource, this.$input, this.$serverRequired, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L14:
        dm9.a.a r13 = (dm9.a) r12;
        if ((r13 instanceof dm9.a.b) == true) goto L22;
        if ((r13 instanceof dm9.a.a) == false) goto L20;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("push banner show report failed, bannerSource=");
        r3.append(this.$bannerSource);
        r3.append(", showTime=");
        r3.append(this.$input.b);
        r3.append(", code=");
        dm9.a.a r14 = r13;
        r3.append(r14.a);
        r3.append(", msg=");
        r3.append(r14.b);
        r2.e("BannerShowReportServiceImpl", r3.toString(), r14.c);
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        String r4 = this.$bannerSource;
        long r5 = this.$input.b;
        String r6 = this.$serverRequired;
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        BubbleBannerShowReportRequest r15 = new BubbleBannerShowReportRequest(r4, r5, null, MapsKt.mapOf(TuplesKt.to("server_required", r6)), 4, null);
        BubbleBannerApi.a r7 = BubbleBannerApi.a;
        BannerShowReportServiceImpl$reportShow$1$result$1 r8 = new BannerShowReportServiceImpl$reportShow$1$result$1(r15, null);
        this.label = 1;
        r7.getClass();
        r12 = BubbleBannerApi.a.a(r8, this);
        if (r12 != r0) goto L14;
        return r0;
    }
}
