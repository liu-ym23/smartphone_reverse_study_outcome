package com.larus.dispatcher.askhuman.handler;

import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dispatcher.api.UploadToolCallRequest;
import com.larus.dispatcher.api.UploadToolCallResultApi;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor$uploadToolCallResult$1", f = "IQuickReplyClickInterceptor.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class IQuickReplyClickInterceptor$uploadToolCallResult$1 extends SuspendLambda implements Function1<Continuation<? super dm9.a<? extends Unit>>, Object> {
    final /* synthetic */ UploadToolCallRequest $request;
    int label;

    /* JADX INFO: renamed from: com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor$uploadToolCallResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/dispatcher/api/UploadToolCallResultApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor$uploadToolCallResult$1$1", f = "IQuickReplyClickInterceptor.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<UploadToolCallResultApi, Continuation<? super BizResponse<Unit>>, Object> {
        final /* synthetic */ UploadToolCallRequest $request;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(UploadToolCallRequest r1, Continuation<? super AnonymousClass1> r2) {
            this.$request = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$request, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(UploadToolCallResultApi r1, Continuation<? super BizResponse<Unit>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((UploadToolCallResultApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            UploadToolCallResultApi r5 = (UploadToolCallResultApi) this.L$0;
            UploadToolCallRequest r2 = this.$request;
            this.label = 1;
            r4 = r5.uploadToolCallResult(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public IQuickReplyClickInterceptor$uploadToolCallResult$1(UploadToolCallRequest r1, Continuation<? super IQuickReplyClickInterceptor$uploadToolCallResult$1> r2) {
        this.$request = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new IQuickReplyClickInterceptor$uploadToolCallResult$1(this.$request, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super dm9.a<Unit>> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        UploadToolCallResultApi.a r14 = UploadToolCallResultApi.a;
        AnonymousClass1 r5 = new AnonymousClass1(this.$request, null);
        this.label = 1;
        r14.getClass();
        FlowHttpConnection r15 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("MainBot", UploadToolCallResultApi.class, r5, true, null, null, null, this, BaiduNaviStatus.NO_PERMISSION);
        if (r13 != r0) goto L11;
        return r0;
    }
}
