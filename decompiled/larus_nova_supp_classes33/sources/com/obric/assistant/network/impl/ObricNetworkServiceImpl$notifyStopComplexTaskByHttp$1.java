package com.obric.assistant.network.impl;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.network.api.bean.ObricStopTaskRequest;
import com.obric.assistant.special_input.ISpecialInputTask;
import dm9.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {888, 896}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $msgId;
    final /* synthetic */ ObricStopTaskRequest $request;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.network.impl.ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $msgId;
        int label;

        public AnonymousClass1(long r1, Continuation<? super AnonymousClass1> r3) {
            this.$msgId = r1;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$msgId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            ISpecialInputTask r4 = com.obric.assistant.special_input.c.a();
            if (r4 == null) goto L8;
            r4.c(String.valueOf(this.$msgId));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1(ObricStopTaskRequest r1, long r2, Continuation<? super ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1> r4) {
        this.$request = r1;
        this.$msgId = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1(this.$request, this.$msgId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        a r9 = (a) r8;
        IAgentAppIntentIDL r2 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r2 == null) goto L16;
        r2.notifyStopComplexTask(String.valueOf(this.$request.getMsgId()));
    L16:
        FLogger.a.i("[ObricNetworkServiceImpl]", "notifyStopComplexTaskByHttp: response = " + r9);
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.$msgId, null);
        this.label = 2;
        if (BuildersKt.withContext(r10, r3, this) != r0) goto L20;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("[ObricNetworkServiceImpl]", "notifyStopComplexTaskByHttp: start");
        ObricProtocolApi.a r11 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1$response$1 r4 = new ObricNetworkServiceImpl$notifyStopComplexTaskByHttp$1$response$1(this.$request, null);
        this.label = 1;
        r11.getClass();
        r8 = ObricProtocolApi.a.a(r4, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
