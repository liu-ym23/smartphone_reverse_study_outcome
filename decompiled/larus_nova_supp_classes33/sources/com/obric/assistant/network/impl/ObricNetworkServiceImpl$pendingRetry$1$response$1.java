package com.obric.assistant.network.impl;

import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.bean.IntentShortLinkType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/obric/assistant/network/impl/ObricProtocolApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$pendingRetry$1$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {555, 558}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$pendingRetry$1$response$1 extends SuspendLambda implements Function2<ObricProtocolApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $seqId;
    final /* synthetic */ IntentShortLinkType $type;
    final /* synthetic */ vea.i $uplinkIntentRequest;
    private /* synthetic */ Object L$0;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IntentShortLinkType.values().length];
            r0[IntentShortLinkType.COMPENSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IntentShortLinkType.ASYNC_NOTIFY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IntentShortLinkType.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public ObricNetworkServiceImpl$pendingRetry$1$response$1(IntentShortLinkType r1, String r2, vea.i r3, Continuation<? super ObricNetworkServiceImpl$pendingRetry$1$response$1> r4) {
        this.$type = r1;
        this.$seqId = r2;
        this.$uplinkIntentRequest = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricNetworkServiceImpl$pendingRetry$1$response$1 r0 = new ObricNetworkServiceImpl$pendingRetry$1$response$1(this.$type, this.$seqId, this.$uplinkIntentRequest, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ObricProtocolApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ObricProtocolApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L28:
        return (BizResponse) r7;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L26:
        return (BizResponse) r7;
    L10:
        ResultKt.throwOnFailure(r7);
        ObricProtocolApi r8 = (ObricProtocolApi) this.L$0;
        FLogger.a.i("[ObricNetworkServiceImpl]", "pendingRetry: type: " + this.$type + ", seqId: " + this.$seqId + ", request = " + this.$uplinkIntentRequest);
        int r2 = a.a[this.$type.ordinal()];
        if (r2 == 1) goto L22;
        if (r2 != 2) goto L14;
        vea.i r3 = this.$uplinkIntentRequest;
        this.label = 2;
        r7 = r8.uploadIntentResultForAsyncNotify(r3, this);
        if (r7 != r0) goto L28;
        return r0;
    L14:
        if (r2 != 3) goto L17;
        return null;
    L17:
        throw new NoWhenBranchMatchedException();
    L22:
        vea.i r4 = this.$uplinkIntentRequest;
        this.label = 1;
        r7 = r8.uploadIntentResultForCompensation(r4, this);
        if (r7 != r0) goto L26;
        return r0;
    }
}
