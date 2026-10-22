package com.obric.aikernel.phx.core.api;

import android.content.Context;
import android.os.Bundle;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.ChildProcessLifecycleBinding;
import com.obric.aikernel.phx.core.conn.b;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class ScriptBizApi extends AbsApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4759c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RequestParams f4760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.obric.aikernel.a f4761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f4762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4763j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2", f = "ScriptBizApi.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super f8.a<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        AnonymousClass2(ScriptBizApi r10, RequestParams r11, Continuation<? super AnonymousClass2> r12) {
            this.this$0 = r10;
            this.$params = r11;
            super(1, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            return new AnonymousClass2(this.this$0, this.$params, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super f8.a<Object>> r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super f8.a<Object>> r10) {
            return ((AnonymousClass2) create(r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            ScriptBizApi r13 = this.this$0;
            RequestParams r14 = this.$params;
            this.label = 1;
            r10 = ScriptBizApi.r(r13, r14, this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2", f = "ScriptBizApi.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    static final class C03772 extends SuspendLambda implements Function1<Continuation<? super c<? extends f8.a<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        int label;
        final /* synthetic */ ScriptBizApi this$0;

        C03772(ScriptBizApi r10, RequestParams r11, Continuation<? super C03772> r12) {
            this.this$0 = r10;
            this.$params = r11;
            super(1, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            return new C03772(this.this$0, this.$params, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super c<? extends f8.a<Object>>> r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super c<f8.a<Object>>> r10) {
            return ((C03772) create(r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            ScriptBizApi r13 = this.this$0;
            RequestParams r14 = this.$params;
            this.label = 1;
            r10 = ScriptBizApi.p(r13, r14, this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    static {
        new a(null);
    }

    public ScriptBizApi(String r10, RequestParams r11, com.obric.aikernel.a r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "remote");
        Intrinsics.checkNotNullParameter(r13, "servicePackage");
        this.f4759c = r10;
        this.f4760g = r11;
        this.f4761h = r12;
        this.f4762i = r13;
        this.f4763j = r14;
    }

    private final Object A(RequestParams r10, Continuation<? super c<f8.a<Object>>> r11) {
        if ((r11 instanceof ScriptBizApi$inferenceAsFlow$1) == false) goto L7;
        ScriptBizApi$inferenceAsFlow$1 r12 = (ScriptBizApi$inferenceAsFlow$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (RequestParams) r12.L$1;
        ScriptBizApi this = (ScriptBizApi) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        com.obric.aikernel.a r17 = (com.obric.aikernel.a) r14;
        if (r17 != null) goto L22;
        return e.v(new ScriptBizApi$inferenceAsFlow$binder$1(null));
    L22:
        return e.v(new ScriptBizApi$inferenceAsFlow$2(this, r17, r10, null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        AIKLog.INSTANCE.i("ScriptBizApi", "call inferenceAsFlow " + this.f4759c);
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 1;
        r14 = u(r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new ScriptBizApi$inferenceAsFlow$1(this, r11);
        goto L8
    }

    private final Object B(RequestParams r19, Continuation<? super f8.a<Object>> r20) {
        ScriptBizApi r10 = this;
        if ((r20 instanceof ScriptBizApi$inferenceTo$1) == false) goto L7;
        ScriptBizApi$inferenceTo$1 r11 = (ScriptBizApi$inferenceTo$1) r20;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L26;
        if (r15 == 1) goto L25;
        if (r15 == 2) goto L20;
        if (r15 != 3) goto L19;
        b r16 = (b) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L16
    L42:
        f8.a r17 = (f8.a) r13;     // Catch: Throwable -> L16
        r16.close();
        return r17;
    L16:
        th = th;
    L47:
        r16.close();
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        com.obric.aikernel.a r18 = (com.obric.aikernel.a) r11.L$4;
        ScriptBizApi r21 = (ScriptBizApi) r11.L$3;
        b r22 = (b) r11.L$2;
        RequestParams r23 = (RequestParams) r11.L$1;
        ScriptBizApi r24 = (ScriptBizApi) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L23
    L38:
        Bundle r25 = (Bundle) r13;     // Catch: Throwable -> L23
        e8.a.x(r23.getBackend(), r24.f4759c, "ScriptBizApi", "inferenceTo");     // Catch: Throwable -> L23
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L23
        ScriptBizApi$inferenceTo$3 r27 = ScriptBizApi$inferenceTo$3.INSTANCE;     // Catch: Throwable -> L23
        r11.L$0 = r22;     // Catch: Throwable -> L23
        r11.L$1 = null;     // Catch: Throwable -> L23
        r11.L$2 = null;     // Catch: Throwable -> L23
        r11.L$3 = null;     // Catch: Throwable -> L23
        r11.L$4 = null;     // Catch: Throwable -> L23
        r11.label = 3;     // Catch: Throwable -> L23
        r13 = r21.f(r18, (Bundle) r13, r27, r11);     // Catch: Throwable -> L23
        if (r13 != r14) goto L41;
        return r14;
    L41:
        r16 = r22;
    L23:
        th = th;
        r16 = r22;
        goto L47
    L25:
        RequestParams r28 = (RequestParams) r11.L$1;
        ScriptBizApi r29 = (ScriptBizApi) r11.L$0;
        ResultKt.throwOnFailure(r13);
        RequestParams r30 = r28;
        r10 = r29;
        Object r31 = r13;
    L29:
        com.obric.aikernel.a r32 = (com.obric.aikernel.a) r31;
        if (r32 == null) goto L32;
        b r33 = r10.s();
        ParamsCompat r34 = ParamsCompat.f4752a;     // Catch: Throwable -> L45
        r11.L$0 = r10;     // Catch: Throwable -> L45
        r11.L$1 = r30;     // Catch: Throwable -> L45
        r11.L$2 = r33;     // Catch: Throwable -> L45
        r11.L$3 = r10;     // Catch: Throwable -> L45
        r11.L$4 = r32;     // Catch: Throwable -> L45
        r11.label = 2;     // Catch: Throwable -> L45
        Object r35 = r34.f(r30, r11);     // Catch: Throwable -> L45
        if (r35 != r14) goto L37;
        return r14;
    L37:
        r24 = r10;
        r18 = r32;
        r21 = r24;
        r23 = r30;
        r13 = r35;
        r22 = r33;
    L45:
        th = th;
        r16 = r33;
        goto L47
    L32:
        return new f8.a(102, null, null, false, false, null, null, 126, null);
    L26:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = r10;
        r30 = r19;
        r11.L$1 = r30;
        r11.label = 1;
        r31 = r10.u(r11);
        if (r31 != r14) goto L29;
        return r14;
    L7:
        r11 = new ScriptBizApi$inferenceTo$1(r10, r20);
        goto L8
    }

    public static final /* synthetic */ b l(ScriptBizApi r10) {
        return r10.s();
    }

    public static final /* synthetic */ com.obric.aikernel.a o(ScriptBizApi r10) {
        return r10.f4761h;
    }

    public static final /* synthetic */ Object p(ScriptBizApi r10, RequestParams r11, Continuation r12) {
        return r10.A(r11, r12);
    }

    public static final /* synthetic */ Object r(ScriptBizApi r10, RequestParams r11, Continuation r12) {
        return r10.B(r11, r12);
    }

    private final b s() {
        ChildProcessLifecycleBinding r10 = ChildProcessLifecycleBinding.f4776a;
        AIKernelConfig r11 = f7.a.f8866a.a();
        if (r11 == null) goto L5;
        Context r12 = r11.getContext();
    L7:
        return ChildProcessLifecycleBinding.e(r10, r12, this.f4762i, this.f4763j, false, 8, null);
    L5:
        r12 = null;
        goto L7
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi, com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        h.f(null, new ScriptBizApi$close$1$1(this, null), 1, null);     // Catch: Throwable -> L4
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r10, Continuation<? super f8.a<Object>> r11) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().v(r10, this.f4761h, new AnonymousClass2(this, r10, null), r11);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r10, Continuation<? super c<f8.a<Object>>> r11) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().v(r10, this.f4761h, new C03772(this, r10, null), r11);
    }

    public Object u(Continuation<? super com.obric.aikernel.a> r10) {
        if ((r10 instanceof ScriptBizApi$getBinder$1) == false) goto L7;
        ScriptBizApi$getBinder$1 r11 = (ScriptBizApi$getBinder$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        ScriptBizApi$getBinder$1 r13 = r11;
        Object r14 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ScriptBizApi this = (ScriptBizApi) r13.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        if ((r14 instanceof ScriptBizApi) == false) goto L23;
        ScriptBizApi r17 = (ScriptBizApi) r14;
    L24:
        if (r17 == null) goto L26;
        this.f4761h = r17.f4761h;
        this.f4763j = r17.f4763j;
    L26:
        return this.f4761h;
    L23:
        r17 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (this.f4761h.asBinder().isBinderAlive() == true) goto L26;
        IAIKernelManager r18 = AIKernelManager.INSTANCE.invoke();
        String r19 = this.f4759c;
        RequestParams r20 = this.f4760g;
        r13.L$0 = this;
        r13.label = 1;
        r14 = IAIKernelManager.b.a(r18, r19, false, r20, r13, 2, null);
        if (r14 != r15) goto L21;
        return r15;
    L7:
        r11 = new ScriptBizApi$getBinder$1(this, r10);
        goto L8
    }

    public final String v() {
        return this.f4759c;
    }
}
