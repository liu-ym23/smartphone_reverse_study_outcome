package com.obric.aikernel.phx.core.api;

import android.content.Context;
import android.os.Bundle;
import com.obric.aikernel.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.ChildProcessLifecycleBinding;
import com.obric.aikernel.phx.core.conn.ProcessLifecycleHandle;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0018\u00010\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J)\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00160\u001a2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J#\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/obric/aikernel/phx/core/api/ScriptBizApi;", "Lcom/obric/aikernel/phx/core/api/AbsApi;", "bizName", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "remote", "Lcom/obric/aikernel/AIKBinder;", "servicePackage", "targetProcess", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lcom/obric/aikernel/AIKBinder;Ljava/lang/String;Ljava/lang/String;)V", "getBizName", "()Ljava/lang/String;", "getParams", "()Lcom/obric/aikernel/sdk/config/RequestParams;", IslandSession.REOPEN_VALUE_CLOSE, "", "ensureProcessLifecycleBinding", "Lcom/obric/aikernel/phx/core/conn/ProcessLifecycleHandle;", "getBinder", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infer", "Lcom/obric/aikernel/sdk/response/Response;", "", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferAsFlow", "Lkotlinx/coroutines/flow/Flow;", "inferenceAsFlow", "inferenceTo", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScriptBizApi extends AbsApi {
    public static final Companion Companion = null;
    private static final String TAG = "ScriptBizApi";
    private final String bizName;
    private final RequestParams params;
    private a remote;
    private final String servicePackage;
    private String targetProcess;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/phx/core/api/ScriptBizApi$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$getBinder$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0}, l = {32}, m = "getBinder", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass1(ScriptBizApi r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getBinder((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2", f = "ScriptBizApi.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Response<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass2(ScriptBizApi r3, RequestParams r4, Continuation<? super AnonymousClass2> r5) {
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
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ScriptBizApi r7 = this.this$0;
            RequestParams r2 = this.$params;
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r6 = ScriptBizApi.access$inferenceTo(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2", f = "ScriptBizApi.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class C10012 extends SuspendLambda implements Function1<Continuation<? super i<? extends Response<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        C10012(ScriptBizApi r3, RequestParams r4, Continuation<? super C10012> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10012(this.this$0, this.$params, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super i<? extends Response<Object>>> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super i<Response<Object>>> r3) {
            return ((C10012) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), C10012.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ScriptBizApi r7 = this.this$0;
            RequestParams r2 = this.$params;
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r6 = ScriptBizApi.access$inferenceAsFlow(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0, 0}, l = {63}, m = "inferenceAsFlow", n = {"this", TrackerImpl.PARAMS}, s = {"L$0", "L$1"})
    static final class C10021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        C10021(ScriptBizApi r3, Continuation<? super C10021> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ScriptBizApi.access$inferenceAsFlow(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$3", f = "ScriptBizApi.kt", i = {0, 1}, l = {67, 67}, m = "invokeSuspend", n = {"lifecycleHandle", "lifecycleHandle"}, s = {"L$0", "L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<j<? super Response<Object>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $binder;
        final /* synthetic */ RequestParams $params;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass3(ScriptBizApi r3, a r4, RequestParams r5, Continuation<? super AnonymousClass3> r6) {
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$binder = r7;
            this.$params = r5;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$binder, this.$params, r7);
            r0.L$0 = r5;
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
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            ProcessLifecycleHandle r13 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(this.L$0, ProcessLifecycleHandle.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L9
        L26:
            r13.close();
            return Unit.INSTANCE;
        L9:
            Throwable th = th;
        L30:
            r13.close();
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.L$3, a.class, "com.obric.memorydata.plugin");
            ScriptBizApi r5 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(this.L$2, ScriptBizApi.class, "com.obric.memorydata.plugin");
            j r6 = (j) ZeusTransformUtils.preCheckCast(this.L$1, j.class, "com.obric.memorydata.plugin");
            ProcessLifecycleHandle r7 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(this.L$0, ProcessLifecycleHandle.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L16
            Object r8 = r14;
            ProcessLifecycleHandle r15 = r7;
        L22:
            RequestParams r9 = this.$params;     // Catch: Throwable -> L28
            ScriptBizApi r10 = this.this$0;     // Catch: Throwable -> L28
            Bundle r11 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            BundleExtKt.setBizCall(r9.getBackend(), r10.getBizName(), ScriptBizApi.TAG, "inferenceAsFlow").putBoolean(IdlKeys.Args_StreamingCall, true);     // Catch: Throwable -> L28
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L28
            final i<Bundle> r4 = r5.callModelAsFlow(r2, (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
            i r12 = (i) ZeusTransformUtils.preCheckCast(new ScriptBizApi$inferenceAsFlow$3$invokeSuspend$$inlined$map$1(r4), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            this.L$0 = r15;     // Catch: Throwable -> L28
            this.L$1 = null;     // Catch: Throwable -> L28
            this.L$2 = null;     // Catch: Throwable -> L28
            this.L$3 = null;     // Catch: Throwable -> L28
            this.label = 2;     // Catch: Throwable -> L28
            if (k.a(r6, r12, r16) != r0) goto L25;
            return r0;
        L25:
            r13 = r15;
        L28:
            th = move-exception;
            ProcessLifecycleHandle r17 = r15;
            th = th;
            r13 = r17;
        L16:
            th = th;
            r13 = r7;
            goto L30
        L18:
            ResultKt.throwOnFailure(r14);
            r6 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            r15 = ScriptBizApi.access$ensureProcessLifecycleBinding(this.this$0);
            r5 = this.this$0;     // Catch: Throwable -> L28
            r2 = this.$binder;     // Catch: Throwable -> L28
            ParamsCompat r18 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L28
            RequestParams r19 = this.$params;     // Catch: Throwable -> L28
            Continuation<? super Bundle> r20 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            this.L$0 = r15;     // Catch: Throwable -> L28
            this.L$1 = r6;     // Catch: Throwable -> L28
            this.L$2 = r5;     // Catch: Throwable -> L28
            this.L$3 = r2;     // Catch: Throwable -> L28
            this.label = 1;     // Catch: Throwable -> L28
            r8 = r18.startCompat(r19, r20);     // Catch: Throwable -> L28
            if (r8 != r0) goto L22;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceTo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", i = {0, 0, 1, 1, 1, 2}, l = {50, 53, 53}, m = "inferenceTo", n = {"this", TrackerImpl.PARAMS, "this", TrackerImpl.PARAMS, "lifecycleHandle", "lifecycleHandle"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
    static final class C10041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptBizApi this$0;

        C10041(ScriptBizApi r3, Continuation<? super C10041> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ScriptBizApi.access$inferenceTo(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ScriptBizApi(String r3, RequestParams r4, a r5, String r6, String r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "bizName");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r8, "remote");
        Intrinsics.checkNotNullParameter(r6, "servicePackage");
        this.bizName = r3;
        this.params = r4;
        this.remote = r8;
        this.servicePackage = r6;
        this.targetProcess = r7;
    }

    public static final /* synthetic */ ProcessLifecycleHandle access$ensureProcessLifecycleBinding(ScriptBizApi r0) {
        return r0.ensureProcessLifecycleBinding();
    }

    public static final /* synthetic */ a access$getRemote$p(ScriptBizApi r0) {
        return r0.remote;
    }

    public static final /* synthetic */ Object access$inferenceAsFlow(ScriptBizApi r2, RequestParams r3, Continuation r4) {
        return r2.inferenceAsFlow(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$inferenceTo(ScriptBizApi r2, RequestParams r3, Continuation r4) {
        return r2.inferenceTo(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final ProcessLifecycleHandle ensureProcessLifecycleBinding() {
        ChildProcessLifecycleBinding r0 = ChildProcessLifecycleBinding.INSTANCE;
        AIKernelConfig r1 = com.obric.aikernel.core.a.f5987a.a();
        if (r1 == null) goto L5;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L7:
        return ChildProcessLifecycleBinding.bind$default(r0, r2, this.servicePackage, this.targetProcess, false, 8, null);
    L5:
        r2 = null;
        goto L7
    }

    private final Object inferenceAsFlow(RequestParams r8, Continuation<? super i<Response<Object>>> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, C10021.class) == false) goto L7;
        C10021 r0 = (C10021) ZeusTransformUtils.preCheckCast(r10, C10021.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (RequestParams) ZeusTransformUtils.preCheckCast(r0.L$1, RequestParams.class, "com.obric.memorydata.plugin");
        final ScriptBizApi this = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r0.L$0, ScriptBizApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L17:
        a r12 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L22;
        Object r7 = ZeusTransformUtils.preCheckCast(new ScriptBizApi$inferenceAsFlow$binder$1(null), Function2.class, "com.obric.memorydata.plugin");
    L21:
        return k.a((Function2) r7);
    L22:
        r7 = ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, r12, r8, null), Function2.class, "com.obric.memorydata.plugin");
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        ILog.Companion.a((ILog) ZeusTransformUtils.preCheckCast(AIKLog.INSTANCE, ILog.class, "com.obric.memorydata.plugin"), TAG, (Function0) ZeusTransformUtils.preCheckCast(new C10032(this), Function0.class, "com.obric.memorydata.plugin"));
        r0.L$0 = this;
        r0.L$1 = r8;
        r0.label = 1;
        r11 = getBinder(r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new C10021(this, r10);
        goto L8
    }

    static /* synthetic */ Object inferenceAsFlow$default(ScriptBizApi r1, RequestParams r2, Continuation r3, int r4, Object r5) {
        Continuation<? super i<Response<Object>>> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new RequestParams(null, null, 3, null);
    L6:
        return r1.inferenceAsFlow(r2, r6);
    }

    private final Object inferenceTo(RequestParams r21, Continuation<? super Response<Object>> r22) {
        ScriptBizApi r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C10041.class) == false) goto L7;
        C10041 r4 = (C10041) ZeusTransformUtils.preCheckCast(r2, C10041.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L26;
        if (r6 == 1) goto L25;
        if (r6 == 2) goto L20;
        if (r6 != 3) goto L19;
        ProcessLifecycleHandle r1 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(r4.L$0, ProcessLifecycleHandle.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L16
    L42:
        Response r7 = (Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r1.close();
        return r7;
    L16:
        th = th;
    L47:
        r1.close();
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        a r8 = (a) ZeusTransformUtils.preCheckCast(r4.L$4, a.class, "com.obric.memorydata.plugin");
        ScriptBizApi r9 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r4.L$3, ScriptBizApi.class, "com.obric.memorydata.plugin");
        ProcessLifecycleHandle r10 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(r4.L$2, ProcessLifecycleHandle.class, "com.obric.memorydata.plugin");
        RequestParams r11 = (RequestParams) ZeusTransformUtils.preCheckCast(r4.L$1, RequestParams.class, "com.obric.memorydata.plugin");
        ScriptBizApi r12 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r4.L$0, ScriptBizApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L23
        ScriptBizApi r13 = r9;
        ProcessLifecycleHandle r14 = r10;
    L38:
        Bundle r15 = (Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        BundleExtKt.setBizCall(r11.getBackend(), r12.bizName, TAG, "inferenceTo");     // Catch: Throwable -> L45
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L45
        Bundle r17 = (Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        Function1 r18 = (Function1) ZeusTransformUtils.preCheckCast(C10053.INSTANCE, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        r4.L$0 = r14;     // Catch: Throwable -> L45
        r4.L$1 = null;     // Catch: Throwable -> L45
        r4.L$2 = null;     // Catch: Throwable -> L45
        r4.L$3 = null;     // Catch: Throwable -> L45
        r4.L$4 = null;     // Catch: Throwable -> L45
        r4.label = 3;     // Catch: Throwable -> L45
        r3 = r13.callModelAsResponse(r8, r17, r18, r4);     // Catch: Throwable -> L45
        if (r3 != r5) goto L41;
        return r5;
    L41:
        r1 = r14;
    L45:
        th = th;
        r1 = r14;
    L23:
        th = th;
        r1 = r10;
        goto L47
    L25:
        RequestParams r19 = (RequestParams) ZeusTransformUtils.preCheckCast(r4.L$1, RequestParams.class, "com.obric.memorydata.plugin");
        ScriptBizApi r20 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r4.L$0, ScriptBizApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        RequestParams r23 = r19;
        r0 = r20;
    L29:
        a r24 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L32;
        r14 = r0.ensureProcessLifecycleBinding();
        ParamsCompat r25 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L45
        r4.L$0 = r0;     // Catch: Throwable -> L45
        r4.L$1 = r23;     // Catch: Throwable -> L45
        r4.L$2 = r14;     // Catch: Throwable -> L45
        r4.L$3 = r0;     // Catch: Throwable -> L45
        r4.L$4 = r24;     // Catch: Throwable -> L45
        r4.label = 2;     // Catch: Throwable -> L45
        Object r26 = r25.startCompat(r23, r4);     // Catch: Throwable -> L45
        if (r26 != r5) goto L37;
        return r5;
    L37:
        r11 = r23;
        r12 = r0;
        r8 = r24;
        r3 = r26;
        r13 = r12;
        goto L38
    L32:
        return new Response(102, null, null, false, false, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    L26:
        ResultKt.throwOnFailure(r3);
        r4.L$0 = r0;
        r23 = r21;
        r4.L$1 = r23;
        r4.label = 1;
        r3 = r0.getBinder(r4);
        if (r3 != r5) goto L29;
        return r5;
    L7:
        r4 = new C10041(r0, r2);
        goto L8
    }

    static /* synthetic */ Object inferenceTo$default(ScriptBizApi r1, RequestParams r2, Continuation r3, int r4, Object r5) {
        Continuation<? super Response<Object>> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new RequestParams(null, null, 3, null);
    L6:
        return r1.inferenceTo(r2, r6);
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi, com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ScriptBizApi$close$1$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Throwable -> L4
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi
    public Object getBinder(Continuation<? super a> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r12, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r7 = r1;
        Object r13 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ScriptBizApi this = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r7.L$0, ScriptBizApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L21:
        if (ZeusTransformUtils.instanceOf(r13, ScriptBizApi.class) == false) goto L23;
        ScriptBizApi r14 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r13, ScriptBizApi.class, "com.obric.memorydata.plugin");
    L24:
        if (r14 == null) goto L26;
        this.remote = r14.remote;
        this.targetProcess = r14.targetProcess;
    L26:
        return this.remote;
    L23:
        r14 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (this.remote.asBinder().isBinderAlive() == true) goto L26;
        IAIKernelManager r4 = AIKernelManager.INSTANCE.invoke();
        String r15 = this.bizName;
        RequestParams r6 = this.params;
        r7.L$0 = this;
        r7.label = 1;
        r13 = IAIKernelManager.DefaultImpls.loadPackage$default(r4, r15, false, r6, r7, 2, null);
        if (r13 != r2) goto L21;
        return r2;
    L7:
        r1 = new AnonymousClass1(this, r12);
        goto L8
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final RequestParams getParams() {
        return this.params;
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r6, Continuation<? super Response<Object>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return AIKernelManager.INSTANCE.getInstance$sdk_release().wrapApiCall(r6, this.remote, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r6, null), Function1.class, "com.obric.memorydata.plugin"), r8);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r6, Continuation<? super i<Response<Object>>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return AIKernelManager.INSTANCE.getInstance$sdk_release().wrapApiCall(r6, this.remote, (Function1) ZeusTransformUtils.preCheckCast(new C10012(this, r6, null), Function1.class, "com.obric.memorydata.plugin"), r8);
    }
}
