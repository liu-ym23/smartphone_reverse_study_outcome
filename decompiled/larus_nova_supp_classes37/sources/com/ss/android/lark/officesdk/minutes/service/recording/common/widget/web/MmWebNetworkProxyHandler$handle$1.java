package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyClientError;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyErrorCode;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyRequest;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyResponse;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.e0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import xwb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.MmWebNetworkProxyHandler$handle$1", f = "MmWebNetworkProxyHandler.kt", i = {0}, l = {56}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class MmWebNetworkProxyHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $callback;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a $networkProxy;
    final /* synthetic */ WebProxyRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.MmWebNetworkProxyHandler$handle$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.MmWebNetworkProxyHandler$handle$1$1", f = "MmWebNetworkProxyHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ j $callback;
        final /* synthetic */ WebProxyResponse $response;
        int label;

        public AnonymousClass1(j r1, WebProxyResponse r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$response = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$response, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            int r6 = c.a;
            j r7 = this.$callback;
            WebProxyResponse r0 = this.$response;
            String r1 = e0.c(r0);
            lvb.a.e("RecordUX_D_WebProxyHandler", "[sendResponse] json=" + r1);
            if (r0.getSuccess() == false) goto L7;
            r7.a(Status.SUCCESS, r1);
        L9:
            return Unit.INSTANCE;
        L7:
            r7.a(Status.FAILURE, r1);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmWebNetworkProxyHandler$handle$1(com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a r1, WebProxyRequest r2, j r3, Continuation<? super MmWebNetworkProxyHandler$handle$1> r4) {
        this.$networkProxy = r1;
        this.$request = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MmWebNetworkProxyHandler$handle$1 r0 = new MmWebNetworkProxyHandler$handle$1(this.$networkProxy, this.$request, this.$callback, r6);
        r0.L$0 = r5;
        return r0;
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
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L13:
        if (Result.isFailure-impl(r8) == false) goto L15;
        r8 = null;
    L15:
        WebProxyResponse r9 = (WebProxyResponse) r8;
        if (r9 != null) goto L21;
        WebProxyResponse.a r10 = WebProxyResponse.Companion;
        String r3 = this.$request.getProxyRequestId();
        if (r3 != null) goto L20;
        r3 = "unknown";
    L20:
        WebProxyClientError.a r4 = WebProxyClientError.Companion;
        WebProxyErrorCode r5 = WebProxyErrorCode.NETWORK_ERROR;
        r4.getClass();
        WebProxyClientError r6 = WebProxyClientError.a.a(r5);
        r10.getClass();
        r9 = WebProxyResponse.a.a(r3, r6);
    L21:
        BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new AnonymousClass1(this.$callback, r9, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a r12 = this.$networkProxy;
        WebProxyRequest r13 = this.$request;
        this.L$0 = r11;
        this.label = 1;
        Object r14 = r12.a(r13);
        if (r14 != r0) goto L11;
        return r0;
    L11:
        r2 = r11;
        r8 = r14;
        goto L13
    }
}
