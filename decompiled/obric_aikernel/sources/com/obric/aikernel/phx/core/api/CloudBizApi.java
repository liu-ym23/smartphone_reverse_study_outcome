package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.sdk.config.RequestParams;
import java.io.Closeable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes2.dex */
public final class CloudBizApi extends AbsApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4756c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$infer$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$infer$2", f = "CloudBizApi.kt", i = {}, l = {21, 21}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super f8.a<Object>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        AnonymousClass2(CloudBizApi r10, RequestParams r11, Continuation<? super AnonymousClass2> r12) {
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
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L16:
            return r10;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r13 = (CloudBizApi) this.L$0;
            ResultKt.throwOnFailure(r10);
        L13:
            this.L$0 = null;
            this.label = 2;
            r10 = r13.l((Bundle) r10, this);
            if (r10 != r11) goto L16;
            return r11;
        L10:
            ResultKt.throwOnFailure(r10);
            r13 = this.this$0;
            ParamsCompat r14 = ParamsCompat.f4752a;
            RequestParams r15 = this.$params;
            this.L$0 = r13;
            this.label = 1;
            r10 = r14.f(r15, this);
            if (r10 != r11) goto L13;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2", f = "CloudBizApi.kt", i = {}, l = {26, 26}, m = "invokeSuspend", n = {}, s = {})
    static final class C03762 extends SuspendLambda implements Function1<Continuation<? super c<? extends f8.a<Object>>>, Object> {
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;
        final /* synthetic */ CloudBizApi this$0;

        C03762(CloudBizApi r10, RequestParams r11, Continuation<? super C03762> r12) {
            this.this$0 = r10;
            this.$params = r11;
            super(1, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            return new C03762(this.this$0, this.$params, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super c<? extends f8.a<Object>>> r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super c<f8.a<Object>>> r10) {
            return ((C03762) create(r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L16:
            return r10;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CloudBizApi r13 = (CloudBizApi) this.L$0;
            ResultKt.throwOnFailure(r10);
        L13:
            this.L$0 = null;
            this.label = 2;
            r10 = r13.o((Bundle) r10, this);
            if (r10 != r11) goto L16;
            return r11;
        L10:
            ResultKt.throwOnFailure(r10);
            r13 = this.this$0;
            ParamsCompat r14 = ParamsCompat.f4752a;
            RequestParams r15 = this.$params;
            this.L$0 = r13;
            this.label = 1;
            r10 = r14.f(r15, this);
            if (r10 != r11) goto L13;
            return r11;
        }
    }

    static {
        new a(null);
    }

    public CloudBizApi(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        this.f4756c = r10;
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object infer(RequestParams r10, Continuation<? super f8.a<Object>> r11) {
        return AIKernelApi.w(AIKernelManager.INSTANCE.getInstance$sdk_release(), r10, null, new AnonymousClass2(this, r10, null), r11, 2, null);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public Object inferAsFlow(RequestParams r10, Continuation<? super c<f8.a<Object>>> r11) {
        return AIKernelApi.w(AIKernelManager.INSTANCE.getInstance$sdk_release(), r10, null, new C03762(this, r10, null), r11, 2, null);
    }

    public final Object l(Bundle r25, Continuation<? super f8.a<Object>> r26) {
        CloudBizApi r10 = this;
        Bundle r11 = r25;
        if ((r26 instanceof CloudBizApi$inference$1) == false) goto L7;
        CloudBizApi$inference$1 r12 = (CloudBizApi$inference$1) r26;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L20;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Closeable r17 = (Closeable) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L31:
        f8.a r18 = (f8.a) r14;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r17, null);
        return r18;
    L15:
        th = th;
    L16:
        Throwable r19 = th;
        throw r19;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r17, r19);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Bundle r20 = (Bundle) r12.L$1;
        CloudBizApi r21 = (CloudBizApi) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r11 = r20;
        r10 = r21;
    L23:
        ServiceConnector.b r22 = (ServiceConnector.b) r14;
        if (r22 == null) goto L26;
        com.obric.aikernel.a r23 = r22.a();     // Catch: Throwable -> L34
        CloudBizApi$inference$3$1 r24 = CloudBizApi$inference$3$1.INSTANCE;     // Catch: Throwable -> L34
        r12.L$0 = r22;     // Catch: Throwable -> L34
        r12.L$1 = null;     // Catch: Throwable -> L34
        r12.label = 2;     // Catch: Throwable -> L34
        Object r27 = r10.f(r23, r11, r24, r12);     // Catch: Throwable -> L34
        if (r27 != r15) goto L30;
        return r15;
    L30:
        r17 = r22;
        r14 = r27;
    L34:
        th = th;
        r17 = r22;
        goto L16
    L26:
        return new f8.a(102, null, null, false, false, null, null, 126, null);
    L20:
        ResultKt.throwOnFailure(r14);
        e8.a.x(r11, r10.f4756c, "CloudBizApi", "inference").putBoolean(IdlKeys.Args_UseCloud, true);
        AIKernelApi r28 = AIKernelManager.INSTANCE.getInstance$sdk_release();
        r12.L$0 = r10;
        r12.L$1 = r11;
        r12.label = 1;
        r14 = AIKernelApi.m(r28, 0, r12, 1, null);
        if (r14 != r15) goto L23;
        return r15;
    L7:
        r12 = new CloudBizApi$inference$1(r10, r26);
        goto L8
    }

    public final Object o(Bundle r10, Continuation<? super c<f8.a<Object>>> r11) {
        Bundle r12 = e8.a.x(r10, this.f4756c, "CloudBizApi", "inferenceAsFlow");
        r12.putBoolean(IdlKeys.Args_UseCloud, true);
        r12.putBoolean(IdlKeys.Args_StreamingCall, true);
        return e.v(new CloudBizApi$inferenceAsFlow$3(this, r10, null));
    }
}
