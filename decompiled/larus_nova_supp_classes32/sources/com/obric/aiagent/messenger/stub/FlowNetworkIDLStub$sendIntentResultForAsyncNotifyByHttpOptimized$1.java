package com.obric.aiagent.messenger.stub;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttpOptimized$1", f = "FlowNetworkIDLStub.kt", i = {0, 0}, l = {169}, m = "invokeSuspend", n = {"prepareStats", "destination$iv$iv"}, s = {"L$0", "L$2"})
public final class FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttpOptimized$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ List<OPushEvent> $events;
    final /* synthetic */ long $flowReceivedElapsedMs;
    final /* synthetic */ boolean $isNeedRetry;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ FlowNetworkIDLStub this$0;

    public FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttpOptimized$1(long r1, List<OPushEvent> r3, FlowNetworkIDLStub r4, IFlowNetworkResultCallbackIDL r5, boolean r6, Continuation<? super FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttpOptimized$1> r7) {
        this.$flowReceivedElapsedMs = r1;
        this.$events = r3;
        this.this$0 = r4;
        this.$callback = r5;
        this.$isNeedRetry = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttpOptimized$1(this.$flowReceivedElapsedMs, this.$events, this.this$0, this.$callback, this.$isNeedRetry, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0074 -> B:15:0x007c). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Collection r2 = (Collection) this.L$4;
        Iterator r4 = (Iterator) this.L$3;
        Collection r5 = (Collection) this.L$2;
        FlowNetworkIDLStub r6 = (FlowNetworkIDLStub) this.L$1;
        f r7 = (f) this.L$0;
        ResultKt.throwOnFailure(r10);
        f r8 = r7;
        FlowNetworkIDLStub r9 = r6;
        Iterator r11 = r4;
        Collection r12 = r2;
        Object r3 = r0;
        FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttpOptimized$1 r13 = this;
    L15:
        r12.add((OPushEvent) r10);
        FlowNetworkIDLStub$sendIntentResultForAsyncNotifyByHttpOptimized$1 r14 = r13;
        r0 = r3;
        Collection r15 = r5;
        Iterator r16 = r11;
        FlowNetworkIDLStub r17 = r9;
        f r18 = r8;
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
        r8 = r18;
        r9 = r17;
        r11 = r16;
        r12 = r15;
        r3 = r0;
        r13 = r14;
        r10 = r20;
        r5 = r12;
        goto L15
    L16:
        List r21 = (List) r15;
        Lazy r22 = o1.a;
        Intrinsics.checkNotNullParameter(r21, "events");
        List r23 = r21;     // Catch: Throwable -> L23
        Gson r24 = (Gson) o1.a.getValue();     // Catch: Throwable -> L23
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));     // Catch: Throwable -> L23
        Iterator r26 = r23.iterator();     // Catch: Throwable -> L23
    L19:
        if (r26.hasNext() == false) goto L21;
        r25.add(r24.toJson(r26.next()));     // Catch: Throwable -> L23
        goto L19
    L21:
        String r27 = ((Gson) o1.a.getValue()).toJson(new vea.i(r25));     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r27);     // Catch: Throwable -> L23
        Object r28 = new n1(r27.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L23
    L24:
        m1 r29 = null;
        if ((r28 instanceof n1) == false) goto L27;
        n1 r30 = (n1) r28;
    L28:
        if (r30 == null) goto L30;
        FLogger.a.i(FlowNetworkIDLStub.access$getTAG$p(r14.this$0), "sendIntentResultForAsyncNotifyByHttpOptimized, eventCount=" + r14.$events.size() + ", bodyBytes=" + r30.a.length);
        IObricNetworkService r31 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r31 == null) goto L46;
        r31.g(r30.a, r14.$isNeedRetry, r14.$callback, r18.a());
    L46:
        return Unit.INSTANCE;
    L30:
        if ((r28 instanceof m1) == false) goto L32;
        r29 = (m1) r28;
    L32:
        if (r29 == null) goto L36;
        String r32 = r29.a;
        if (r32 == null) goto L36;
    L37:
        FLogger.a.e(FlowNetworkIDLStub.access$getTAG$p(r14.this$0), "notifyOptimized: encode failed, reason=".concat(r32));
        IFlowNetworkResultCallbackIDL r110 = r14.$callback;
        if (r110 == null) goto L41;
        r110.onResult(false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(LynxResourceModule.CODE_KEY, Boxing.boxInt(-1)), TuplesKt.to("msg", "notify request serialization failed")}));
    L41:
        return Unit.INSTANCE;
    L36:
        r32 = "unknown";
        goto L37
    L27:
        r30 = null;
    L23:
        r28 = new m1();
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        f r111 = new f(this.$flowReceivedElapsedMs);
        List<OPushEvent> r33 = this.$events;
        FlowNetworkIDLStub r34 = this.this$0;
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        r18 = r111;
        r17 = r34;
        r14 = this;
        r16 = r33.iterator();
        r15 = r35;
        goto L10
    }
}
