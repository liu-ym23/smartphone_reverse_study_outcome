package com.obric.memorydata.aikernelcore;

import com.obric.aikernel.sdk.ext.BundleExtKt;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1", f = "AiKernelRunModelCaller.kt", i = {}, l = {956}, m = "invokeSuspend", n = {}, s = {})
final class AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $logId;
    final /* synthetic */ String $modelName;
    final /* synthetic */ Ref.ObjectRef<String> $outputResult;
    final /* synthetic */ Ref.IntRef $resultCode;
    final /* synthetic */ Ref.ObjectRef<String> $resultMsg;
    final /* synthetic */ i<Response<Object>> $stream;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f8430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8431b;
        final /* synthetic */ Ref.IntRef c;
        final /* synthetic */ Ref.ObjectRef<String> d;
        final /* synthetic */ Ref.ObjectRef<String> e;

        AnonymousClass1(Ref.ObjectRef<String> r1, String r2, Ref.IntRef r3, Ref.ObjectRef<String> r4, Ref.ObjectRef<String> r5) {
            this.f8430a = r1;
            this.f8431b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final Unit a(String r6, Ref.IntRef r7, Ref.ObjectRef r8, Ref.ObjectRef r9, int r10, String r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r11, "errInfo");
            Intrinsics.checkNotNullParameter(r12, "<unused var>");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "call " + r6 + " error: " + r10 + ", " + r11, null, 4, null);
            r7.element = r10;
            r8.element = r11;
            r9.element = "";
            a.b().remove(r6);
            return Unit.INSTANCE;
        }

        private static final Unit a(Ref.ObjectRef r6, String r7, Ref.IntRef r8, Ref.ObjectRef r9, boolean r10, Object r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r12, "<unused var>");
            StringBuilder r13 = new StringBuilder().append((String) ZeusTransformUtils.preCheckCast(r6.element, String.class, "com.obric.memorydata.plugin"));
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");
            r6.element = (T) r13.append((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin")).toString();
            if (r10 == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "call " + r7 + " success", false, 4, null);
            r8.element = 0;
            r9.element = "SUCCESS";
        L6:
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$JQ2hYgBGNs8xLh0bE9WY3o6iD0Q(String r0, Ref.IntRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, int r4, String r5, JSONObject r6) {
            return a(r0, r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: lambda$mi-Uox5wdthybe-oG6EENIstcqc, reason: not valid java name */
        public static /* synthetic */ Unit m446lambda$miUox5wdthybeoG6EENIstcqc(Ref.ObjectRef r0, String r1, Ref.IntRef r2, Ref.ObjectRef r3, boolean r4, Object r5, JSONObject r6) {
            return a(r0, r1, r2, r3, r4, r5, r6);
        }

        public final Object a(Response<Object> r5, Continuation<? super Unit> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            final Ref.ObjectRef<String> r8 = this.f8430a;
            final String r0 = this.f8431b;
            final Ref.IntRef r1 = this.c;
            final Ref.ObjectRef<String> r2 = this.d;
            Response r9 = ResponseKt.ok(r5, new $$Lambda$AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1$1$miUox5wdthybeoG6EENIstcqc(r8, r0, r1, r2));
            final String r10 = this.f8431b;
            final Ref.IntRef r3 = this.c;
            final Ref.ObjectRef<String> r4 = this.d;
            final Ref.ObjectRef<String> r11 = this.f8430a;
            Response r12 = ResponseKt.fail(r9, new $$Lambda$AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1$1$JQ2hYgBGNs8xLh0bE9WY3o6iD0Q(r10, r3, r4, r11));
            Ref.ObjectRef<String> r13 = this.e;
            T r14 = (T) BundleExtKt.getLogId(r12);
            if (r14 != null) goto L5;
            r14 = (T) "";
        L5:
            r13.element = r14;
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1(i<Response<Object>> r3, Ref.ObjectRef<String> r4, String r5, Ref.IntRef r6, Ref.ObjectRef<String> r7, Ref.ObjectRef<String> r8, Continuation<? super AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1> r9) {
        i<Response<Object>> r10 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$stream = r10;
        this.$outputResult = r4;
        this.$modelName = r5;
        this.$resultCode = r6;
        this.$resultMsg = r7;
        this.$logId = r8;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1(this.$stream, this.$outputResult, this.$modelName, this.$resultCode, this.$resultMsg, this.$logId, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        i<Response<Object>> r11 = this.$stream;
        if (r11 == null) goto L14;
        j<? super Response<Object>> r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$outputResult, this.$modelName, this.$resultCode, this.$resultMsg, this.$logId), j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r11.collect(r2, r3) != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
