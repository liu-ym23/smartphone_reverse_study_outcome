package com.larus.reach.impl;

import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachShowReporter$reportShow$1", f = "ReachShowReportLifecycleListener.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
final class ReachShowReporter$reportShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $extraParams;
    final /* synthetic */ long $showTime;
    final /* synthetic */ String $validPushId;
    int label;

    /* JADX INFO: renamed from: com.larus.reach.impl.ReachShowReporter$reportShow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/reach/impl/ReachShowReportApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.reach.impl.ReachShowReporter$reportShow$1$1", f = "ReachShowReportLifecycleListener.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ReachShowReportApi, Continuation<? super BizResponse<Object>>, Object> {
        final /* synthetic */ Map<String, String> $extraParams;
        final /* synthetic */ long $showTime;
        final /* synthetic */ String $validPushId;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(long r1, String r3, Map<String, String> r4, Continuation<? super AnonymousClass1> r5) {
            this.$showTime = r1;
            this.$validPushId = r3;
            this.$extraParams = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$showTime, this.$validPushId, this.$extraParams, r9);
            r6.L$0 = r8;
            return r6;
        }

        public final Object invoke(ReachShowReportApi r1, Continuation<? super BizResponse<Object>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ReachShowReportApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L15:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            ReachShowReportApi r14 = (ReachShowReportApi) this.L$0;
            long r5 = this.$showTime;
            String r8 = this.$validPushId;
            Map<String, String> r2 = this.$extraParams;
            if ((!r2.isEmpty()) == true) goto L12;
            r2 = null;
        L12:
            ReachBannerShowReportRequest r3 = new ReachBannerShowReportRequest(null, r5, null, r8, r2, 5, null);
            this.label = 1;
            r13 = r14.reportBannerShow(r3, this);
            if (r13 != r0) goto L15;
            return r0;
        }
    }

    public ReachShowReporter$reportShow$1(long r1, String r3, Map<String, String> r4, Continuation<? super ReachShowReporter$reportShow$1> r5) {
        this.$showTime = r1;
        this.$validPushId = r3;
        this.$extraParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ReachShowReporter$reportShow$1(this.$showTime, this.$validPushId, this.$extraParams, r8);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        ReachShowReportApi.a r14 = ReachShowReportApi.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.$showTime, this.$validPushId, this.$extraParams, null);
        this.label = 1;
        r14.getClass();
        FlowHttpConnection r15 = FlowHttpConnection.a;
        if (FlowHttpConnection.g("Basic", ReachShowReportApi.class, r2, true, null, null, null, this, 240) != r0) goto L12;
        return r0;
    }
}
