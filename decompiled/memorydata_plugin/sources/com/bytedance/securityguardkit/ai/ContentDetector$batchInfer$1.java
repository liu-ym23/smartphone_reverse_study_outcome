package com.bytedance.securityguardkit.ai;

import android.util.Log;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.al;
import kotlinx.coroutines.da;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONArray;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.securityguardkit.ai.ContentDetector$batchInfer$1", f = "ContentDetector.kt", i = {0, 1}, l = {115, 123, 140}, m = "invokeSuspend", n = {"result", "result"}, s = {"L$0", "L$0"})
final class ContentDetector$batchInfer$1 extends SuspendLambda implements Function2<al, Continuation<? super JSONArray>, Object> {
    final /* synthetic */ String[] $batchContent;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.bytedance.securityguardkit.ai.ContentDetector$batchInfer$1$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONArray;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.securityguardkit.ai.ContentDetector$batchInfer$1$4", f = "ContentDetector.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super JSONArray>, Object> {
        final /* synthetic */ w<JSONArray> $result;
        int label;

        AnonymousClass4(w<JSONArray> r3, Continuation<? super AnonymousClass4> r4) {
            w<JSONArray> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$result = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.$result, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super JSONArray> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super JSONArray> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            w<JSONArray> r6 = this.$result;
            Continuation<? super JSONArray> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    ContentDetector$batchInfer$1(String[] r3, Continuation<? super ContentDetector$batchInfer$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$batchContent = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ContentDetector$batchInfer$1(this.$batchContent, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super JSONArray> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super JSONArray> r4) {
        return ((ContentDetector$batchInfer$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ContentDetector$batchInfer$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L12;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L9 TimeoutCancellationException -> L36
    L33:
    L41:
        return (JSONArray) ZeusTransformUtils.preCheckCast(r14, JSONArray.class, "com.obric.memorydata.plugin");
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        final w r2 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L24:
        Response r15 = (Response) ZeusTransformUtils.preCheckCast(r14, Response.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L30;
        Response r16 = ResponseKt.ok(r15, (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r2), Function3.class, "com.obric.memorydata.plugin"));
        if (r16 == null) goto L30;
        ResponseKt.fail(r16, (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r2), Function3.class, "com.obric.memorydata.plugin"));
    L30:
        Function2 r17 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r2, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9 TimeoutCancellationException -> L36
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9 TimeoutCancellationException -> L36
        this.L$0 = null;     // Catch: Exception -> L9 TimeoutCancellationException -> L36
        this.label = 3;     // Catch: Exception -> L9 TimeoutCancellationException -> L36
        r14 = da.a(5000, r17, r3);     // Catch: Exception -> L9 TimeoutCancellationException -> L36
        if (r14 != r0) goto L33;
        return r0;
    L14:
        r2 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L19:
        IBaseModel r18 = (IBaseModel) ZeusTransformUtils.preCheckCast(r14, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L30;
        final String[] r10 = this.$batchContent;
        RequestParams r8 = new RequestParams(null, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10), Function1.class, "com.obric.memorydata.plugin"), 1, null);
        Continuation<? super Response<Object>> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 2;
        r14 = r18.infer(r8, r5);
        if (r14 != r0) goto L24;
        return r0;
    L15:
        ResultKt.throwOnFailure(r14);
        w r19 = y.a(null, 1, null);
        IAIKernelManager r4 = AIKernelManager.INSTANCE.invoke();
        RequestParams r9 = new RequestParams(null, (Function1) ZeusTransformUtils.preCheckCast(ContentDetector$batchInfer$1$model$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 1, null);
        Continuation<? super IBaseModel> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r19;
        this.label = 1;
        Object r6 = r4.loadPackage("pico_content_security", false, r9, r11);
        if (r6 != r0) goto L18;
        return r0;
    L18:
        r2 = r19;
        r14 = r6;
    L36:
        String r13 = "Inference timed out";
    L37:
        Log.e("ContentDetector", r13);
        return null;
    L9:
        e = move-exception;
        r13 = "Inference failed: " + e.getMessage();
        goto L37
    }
}
