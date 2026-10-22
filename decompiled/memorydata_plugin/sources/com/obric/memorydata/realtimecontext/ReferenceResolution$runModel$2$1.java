package com.obric.memorydata.realtimecontext;

import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.realtimecontext.ReferenceResolution$runModel$2$1", f = "ReferenceResolution.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
final class ReferenceResolution$runModel$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $code;
    final /* synthetic */ Ref.ObjectRef<String> $result;
    final /* synthetic */ kotlinx.coroutines.flow.i<Response<Object>> $stream;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.realtimecontext.ReferenceResolution$runModel$2$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f12439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f12440b;

        AnonymousClass1(Ref.ObjectRef<String> r1, Ref.IntRef r2) {
            this.f12439a = r1;
            this.f12440b = r2;
        }

        private static final Unit a(Ref.IntRef r6, int r7, String r8, JSONObject r9) {
            Intrinsics.checkNotNullParameter(r8, "errInfo");
            Intrinsics.checkNotNullParameter(r9, "<unused var>");
            r6.element = 1004;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "run model failed: code=" + r7 + ", msg=" + r8, null, 4, null);
            return Unit.INSTANCE;
        }

        private static final Unit a(Ref.ObjectRef r1, boolean r2, Object r3, JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "<unused var>");
            RunLog.INSTANCE.debug(RealTimeContextService.TAG, "query result " + r3);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.String");
            r1.element = (T) ((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$15LbpySB5ZfnOX11SLp_RHrr2uA(Ref.ObjectRef r0, boolean r1, Object r2, JSONObject r3) {
            return a(r0, r1, r2, r3);
        }

        public static /* synthetic */ Unit lambda$6NQ509D6j5OApvNuRGnoQ5vRKQ0(Ref.IntRef r0, int r1, String r2, JSONObject r3) {
            return a(r0, r1, r2, r3);
        }

        public final Object a(Response<Object> r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            final Ref.ObjectRef<String> r6 = this.f12439a;
            Response r7 = ResponseKt.ok(r3, new $$Lambda$ReferenceResolution$runModel$2$1$1$15LbpySB5ZfnOX11SLp_RHrr2uA(r6));
            final Ref.IntRef r2 = this.f12440b;
            ResponseKt.fail(r7, new $$Lambda$ReferenceResolution$runModel$2$1$1$6NQ509D6j5OApvNuRGnoQ5vRKQ0(r2));
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    ReferenceResolution$runModel$2$1(kotlinx.coroutines.flow.i<Response<Object>> r3, Ref.ObjectRef<String> r4, Ref.IntRef r5, Continuation<? super ReferenceResolution$runModel$2$1> r6) {
        kotlinx.coroutines.flow.i<Response<Object>> r7 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$stream = r7;
        this.$result = r4;
        this.$code = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ReferenceResolution$runModel$2$1(this.$stream, this.$result, this.$code, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ReferenceResolution$runModel$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ReferenceResolution$runModel$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.flow.i<Response<Object>> r7 = this.$stream;
        Intrinsics.checkNotNull(r7);
        kotlinx.coroutines.flow.j<? super Response<Object>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$result, this.$code), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r7.collect(r2, r3) != r0) goto L12;
        return r0;
    }
}
