package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttp$1", f = "FlowNetworkIDLStub.kt", i = {0, 0}, l = {152}, m = "invokeSuspend", n = {"prepareStats", "destination$iv$iv"}, s = {"L$0", "L$2"})
public final class FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ long $flowReceivedElapsedMs;
    final /* synthetic */ boolean $isNeedRetry;
    final /* synthetic */ List<OPushEvent> $list;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ FlowNetworkIDLStub this$0;

    public FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttp$1(FlowNetworkIDLStub r1, long r2, List<OPushEvent> r4, boolean r5, IFlowNetworkResultCallbackIDL r6, Continuation<? super FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttp$1> r7) {
        this.this$0 = r1;
        this.$flowReceivedElapsedMs = r2;
        this.$list = r4;
        this.$isNeedRetry = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttp$1(this.this$0, this.$flowReceivedElapsedMs, this.$list, this.$isNeedRetry, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0098 -> B:15:0x00a0). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Collection r2 = (Collection) this.L$4;
        Iterator r3 = (Iterator) this.L$3;
        Collection r4 = (Collection) this.L$2;
        FlowNetworkIDLStub r5 = (FlowNetworkIDLStub) this.L$1;
        f r6 = (f) this.L$0;
        ResultKt.throwOnFailure(r9);
        f r7 = r6;
        FlowNetworkIDLStub r8 = r5;
        Iterator r10 = r3;
        Collection r11 = r2;
        Object r12 = r0;
        FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttp$1 r13 = this;
    L15:
        r11.add((OPushEvent) r9);
        FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttp$1 r14 = r13;
        r0 = r12;
        Collection r15 = r4;
        Iterator r16 = r10;
        FlowNetworkIDLStub r17 = r8;
        f r18 = r7;
    L10:
        if (r16.hasNext() == false) goto L16;
        OPushEvent r19 = (OPushEvent) r16.next();
        r14.L$0 = r18;
        r14.L$1 = r17;
        r14.L$2 = r15;
        r14.L$3 = r16;
        r14.L$4 = r15;
        r14.label = 1;
        Object r20 = FlowNetworkIDLStub.access$injectScreenshotIfNeeded(r17, r19, r18, r14);
        if (r20 != r0) goto L14;
        return r0;
    L14:
        r7 = r18;
        r8 = r17;
        r10 = r16;
        r11 = r15;
        r12 = r0;
        r13 = r14;
        r9 = r20;
        r4 = r11;
        goto L15
    L16:
        List r21 = CollectionsKt.toMutableList((List) r15);
        IObricNetworkService r22 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r22 == null) goto L20;
        r22.l(r21, r14.$isNeedRetry, r14.$callback, r18.a());
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i(FlowNetworkIDLStub.access$getTAG$p(this.this$0), "sendIntentResultForAsyncNotifyByHttp, execute: " + ServiceManager.get().getService(IObricNetworkService.class));
        f r23 = new f(this.$flowReceivedElapsedMs);
        List<OPushEvent> r24 = this.$list;
        FlowNetworkIDLStub r25 = this.this$0;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        r18 = r23;
        r17 = r25;
        r14 = this;
        r16 = r24.iterator();
        r15 = r26;
        goto L10
    }
}
