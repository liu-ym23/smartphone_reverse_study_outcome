package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J'\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/phx/core/api/CloudBizApi;", "Lcom/obric/aikernel/phx/core/api/AbsApi;", "bizName", "", "(Ljava/lang/String;)V", "infer", "Lcom/obric/aikernel/sdk/response/Response;", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferAsFlow", "Lkotlinx/coroutines/flow/Flow;", "inference", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferenceAsFlow", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CloudBizApi extends AbsApi {
    public static final Companion Companion = null;
    private static final String TAG = "CloudBizApi";
    private final String bizName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/phx/core/api/CloudBizApi$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$infer$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$infer$2", f = "CloudBizApi.kt", i = {}, l = {21, 21}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Response<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass2(CloudBizApi r3, RequestParams r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$params, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super Response<Object>> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Response<Object>> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L16:
            return r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r2 = (CloudBizApi) ZeusTransformUtils.preCheckCast(this.L$0, CloudBizApi.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r8);
        L13:
            Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin");
            Continuation<? super Response<Object>> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            r8 = r2.inference(r9, r3);
            if (r8 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            r2 = this.this$0;
            ParamsCompat r10 = ParamsCompat.INSTANCE;
            RequestParams r5 = this.$params;
            Continuation<? super Bundle> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r2;
            this.label = 1;
            r8 = r10.startCompat(r5, r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2", f = "CloudBizApi.kt", i = {}, l = {26, 26}, m = "invokeSuspend", n = {}, s = {})
    static final class C10002 extends SuspendLambda implements Function1<Continuation<? super i<? extends Response<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        C10002(CloudBizApi r3, RequestParams r4, Continuation<? super C10002> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10002(this.this$0, this.$params, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super i<? extends Response<Object>>> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super i<Response<Object>>> r3) {
            return ((C10002) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10002.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L16:
            return r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r2 = (CloudBizApi) ZeusTransformUtils.preCheckCast(this.L$0, CloudBizApi.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r8);
        L13:
            Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin");
            Continuation<? super i<Response<Object>>> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            r8 = r2.inferenceAsFlow(r9, r3);
            if (r8 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            r2 = this.this$0;
            ParamsCompat r10 = ParamsCompat.INSTANCE;
            RequestParams r5 = this.$params;
            Continuation<? super Bundle> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r2;
            this.label = 1;
            r8 = r10.startCompat(r5, r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inference$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi", f = "CloudBizApi.kt", i = {0, 0}, l = {33, 37}, m = "inference", n = {"this", "args"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass1(CloudBizApi r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.inference(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$3", f = "CloudBizApi.kt", i = {0}, l = {50, 52, 56}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<j<? super Response<Object>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $args;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass3(CloudBizApi r3, Bundle r4, Continuation<? super AnonymousClass3> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$args = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$args, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(j<? super Response<Object>> r3, Continuation<? super Unit> r4) {
            return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(j<? super Response<Object>> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L14;
            if (r2 != 3) goto L13;
            Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(this.L$0, Closeable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L10
        L31:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
            CloseableKt.closeFinally(r3, null);
            return Unit.INSTANCE;
        L10:
            th = move-exception;
            Throwable r4 = th;
        L42:
            throw r4;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            CloseableKt.closeFinally(r3, r4);
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r19);
        L25:
            return Unit.INSTANCE;
        L15:
            j r5 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r19);
            Object r6 = r19;
        L19:
            ServiceConnector.MainProcessIpcBinding r7 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r6, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L26;
            Response r8 = new Response(102, null, null, false, false, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
            Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            if (r5.emit(r8, r9) != r1) goto L25;
            return r1;
        L26:
            Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin");
            CloudBizApi r11 = this.this$0;
            Bundle r12 = this.$args;
            final i<Bundle> r13 = r11.callModelAsFlow(((ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r10, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin")).getBinder(), r12);     // Catch: Throwable -> L34
            i r14 = (i) ZeusTransformUtils.preCheckCast(new CloudBizApi$inferenceAsFlow$3$invokeSuspend$lambda$1$$inlined$map$1(r13), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
            this.L$0 = r10;     // Catch: Throwable -> L34
            this.label = 3;     // Catch: Throwable -> L34
            if (k.a(r5, r14, this) != r1) goto L30;
            return r1;
        L30:
            r3 = r10;
        L34:
            th = move-exception;
            r4 = th;
            r3 = r10;
            goto L42
        L16:
            ResultKt.throwOnFailure(r19);
            r5 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            AIKernelApi r15 = AIKernelManager.INSTANCE.getInstance$sdk_release();
            Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r5;
            this.label = 1;
            r6 = AIKernelApi.getMainProcessIpcBinding$sdk_release$default(r15, 0, r16, 1, null);
            if (r6 != r1) goto L19;
            return r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CloudBizApi(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        this.bizName = r2;
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r10, Continuation<? super Response<Object>> r11) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return AIKernelApi.wrapApiCall$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), r10, null, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r10, null), Function1.class, "com.obric.memorydata.plugin"), r6, 2, null);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r10, Continuation<? super i<Response<Object>>> r11) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return AIKernelApi.wrapApiCall$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), r10, null, (Function1) ZeusTransformUtils.preCheckCast(new C10002(this, r10, null), Function1.class, "com.obric.memorydata.plugin"), r6, 2, null);
    }

    public final Object inference(Bundle r26, Continuation<? super Response<Object>> r27) {
        CloudBizApi r0 = this;
        Bundle r1 = r26;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r2, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r4.label;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r4.L$0, Closeable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L15
    L32:
        Response r7 = (Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r6, null);
        return r7;
    L15:
        th = th;
    L16:
        Throwable r8 = th;
        throw r8;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r6, r8);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$1, Bundle.class, "com.obric.memorydata.plugin");
        CloudBizApi r10 = (CloudBizApi) ZeusTransformUtils.preCheckCast(r4.L$0, CloudBizApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r1 = r9;
        r0 = r10;
    L23:
        ServiceConnector.MainProcessIpcBinding r12 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r3, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L26;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");
        a r14 = ((ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r13, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin")).getBinder();     // Catch: Throwable -> L35
        Function1 r15 = (Function1) ZeusTransformUtils.preCheckCast(CloudBizApi$inference$3$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        r4.L$0 = r13;     // Catch: Throwable -> L35
        r4.L$1 = null;     // Catch: Throwable -> L35
        r4.label = 2;     // Catch: Throwable -> L35
        Object r16 = r0.callModelAsResponse(r14, r1, r15, r4);     // Catch: Throwable -> L35
        if (r16 != r11) goto L31;
        return r11;
    L31:
        r6 = r13;
        r3 = r16;
    L35:
        th = th;
        r6 = r13;
        goto L16
    L26:
        return new Response(102, null, null, false, false, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    L20:
        ResultKt.throwOnFailure(r3);
        BundleExtKt.setBizCall(r1, r0.bizName, TAG, "inference").putBoolean(IdlKeys.Args_UseCloud, true);
        AIKernelApi r17 = AIKernelManager.INSTANCE.getInstance$sdk_release();
        r4.L$0 = r0;
        r4.L$1 = r1;
        r4.label = 1;
        r3 = AIKernelApi.getMainProcessIpcBinding$sdk_release$default(r17, 0, r4, 1, null);
        if (r3 != r11) goto L23;
        return r11;
    L7:
        r4 = new AnonymousClass1(r0, r2);
        goto L8
    }

    public final Object inferenceAsFlow(Bundle r4, Continuation<? super i<Response<Object>>> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Bundle r7 = BundleExtKt.setBizCall(r4, this.bizName, TAG, "inferenceAsFlow");
        r7.putBoolean(IdlKeys.Args_UseCloud, true);
        r7.putBoolean(IdlKeys.Args_StreamingCall, true);
        return k.a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, r4, null), Function2.class, "com.obric.memorydata.plugin"));
    }
}
