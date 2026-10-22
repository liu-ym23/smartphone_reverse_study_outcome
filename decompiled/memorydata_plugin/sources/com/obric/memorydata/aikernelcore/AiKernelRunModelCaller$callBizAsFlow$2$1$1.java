package com.obric.memorydata.aikernelcore;

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
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$callBizAsFlow$2$1$1", f = "AiKernelRunModelCaller.kt", i = {}, l = {892}, m = "invokeSuspend", n = {}, s = {})
final class AiKernelRunModelCaller$callBizAsFlow$2$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $modelName;
    final /* synthetic */ Ref.ObjectRef<String> $outputResult;
    final /* synthetic */ i<Response<Object>> $stream;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$callBizAsFlow$2$1$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f8428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8429b;

        AnonymousClass1(Ref.ObjectRef<String> r1, String r2) {
            this.f8428a = r1;
            this.f8429b = r2;
        }

        private static final Unit a(String r6, Ref.ObjectRef r7, int r8, String r9, JSONObject r10) {
            Intrinsics.checkNotNullParameter(r9, "errInfo");
            Intrinsics.checkNotNullParameter(r10, "<unused var>");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "call " + r6 + " error: " + r8 + ", " + r9, null, 4, null);
            r7.element = "";
            a.b().remove(r6);
            return Unit.INSTANCE;
        }

        private static final Unit a(Ref.ObjectRef r3, String r4, boolean r5, Object r6, JSONObject r7) {
            Intrinsics.checkNotNullParameter(r7, "<unused var>");
            StringBuilder r8 = new StringBuilder().append((String) ZeusTransformUtils.preCheckCast(r3.element, String.class, "com.obric.memorydata.plugin"));
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.String");
            r3.element = (T) r8.append((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")).toString();
            if (r5 == false) goto L6;
            RunLog.INSTANCE.debug("AiKernelRunModelCaller", "call " + r4 + " success");
        L6:
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$Pa-6l36_o3pMGRw-NqjrK3InLso, reason: not valid java name */
        public static /* synthetic */ Unit m444lambda$Pa6l36_o3pMGRwNqjrK3InLso(String r0, Ref.ObjectRef r1, int r2, String r3, JSONObject r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Unit lambda$kZW6t4Y9HZDhK1hoiW_Na9NJfas(Ref.ObjectRef r0, String r1, boolean r2, Object r3, JSONObject r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public final Object a(Response<Object> r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            final Ref.ObjectRef<String> r6 = this.f8428a;
            final String r0 = this.f8429b;
            Response r7 = ResponseKt.ok(r3, new $$Lambda$AiKernelRunModelCaller$callBizAsFlow$2$1$1$1$kZW6t4Y9HZDhK1hoiW_Na9NJfas(r6, r0));
            final String r8 = this.f8429b;
            final Ref.ObjectRef<String> r2 = this.f8428a;
            ResponseKt.fail(r7, new $$Lambda$AiKernelRunModelCaller$callBizAsFlow$2$1$1$1$Pa6l36_o3pMGRwNqjrK3InLso(r8, r2));
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    AiKernelRunModelCaller$callBizAsFlow$2$1$1(i<Response<Object>> r3, Ref.ObjectRef<String> r4, String r5, Continuation<? super AiKernelRunModelCaller$callBizAsFlow$2$1$1> r6) {
        i<Response<Object>> r7 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$stream = r7;
        this.$outputResult = r4;
        this.$modelName = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlow$2$1$1(this.$stream, this.$outputResult, this.$modelName, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AiKernelRunModelCaller$callBizAsFlow$2$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$callBizAsFlow$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
        i<Response<Object>> r7 = this.$stream;
        Intrinsics.checkNotNull(r7);
        j<? super Response<Object>> r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$outputResult, this.$modelName), j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r7.collect(r2, r3) != r0) goto L12;
        return r0;
    }
}
