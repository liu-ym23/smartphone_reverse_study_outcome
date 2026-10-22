package com.obric.aikernel.runtime;

import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$inrWatchDog$1$1", f = "VmEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$vmExecuteRaw$inrWatchDog$1$1 extends SuspendLambda implements Function1<Continuation<? super bx>, Object> {
    final /* synthetic */ String $event;
    final /* synthetic */ long $inrTimeMills;
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ com.obric.aee.res.b $pkg;
    int label;
    final /* synthetic */ e this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$inrWatchDog$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$inrWatchDog$1$1$1", f = "VmEngine.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $event;
        final /* synthetic */ long $inrTimeMills;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ com.obric.aee.res.b $pkg;
        int label;
        final /* synthetic */ e this$0;

        AnonymousClass1(long r3, e r5, RequestParams r6, com.obric.aee.res.b r7, String r8, Continuation<? super AnonymousClass1> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            this.$inrTimeMills = r3;
            this.this$0 = r5;
            this.$params = r6;
            this.$pkg = r7;
            this.$event = r8;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$inrTimeMills, this.this$0, this.$params, this.$pkg, this.$event, r8), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            AIInferRuntime.b r8 = e.b(this.this$0).d();
            if (r8 == null) goto L14;
            r8.a(this.$params);
        L14:
            JSONObject r9 = new JSONObject();
            RequestParams r2 = this.$params;
            com.obric.aee.res.b r3 = this.$pkg;
            long r4 = this.$inrTimeMills;
            String r6 = this.$event;
            r9.put("caller_pkg", BundleExtKt.getPackageName(r2.getBackend()));
            r9.put("biz", BundleExtKt.getBizName(r2.getBackend()));
            r9.put("version", r3.b());
            r9.put("method", BundleExtKt.getMethod(r2.getBackend()));
            r9.put("sdk_ver", BundleExtKt.getSdkVer(r2.getBackend()));
            r9.put("inr_interval", r4);
            r9.put("trace_id", BundleExtKt.getAIKTraceId(r2.getBackend()));
            r9.put("event", r6);
            r9.put(AILabCheckPermissionTask.KEY_SOURCE, "vmExecuteRaw");
            r9.put("trace", BundleExtKt.getPackageName(r2.getBackend()));
            r9.put("checktime", String.valueOf(r4 / ((long) 1000)));
            r9.put("slardar", "1");
            com.obric.aikernel.runtime.utils.d.f6216a.f("VmEngine", "[STUCK_TRACING] inr_events: " + r9);
            com.obric.aikernel.runtime.utils.d.f6216a.a("may_stuck", r9);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            long r5 = this.$inrTimeMills;
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (au.a(r5, r10) != r0) goto L11;
            return r0;
        }
    }

    VmEngine$vmExecuteRaw$inrWatchDog$1$1(e r3, long r4, RequestParams r6, com.obric.aee.res.b r7, String r8, Continuation<? super VmEngine$vmExecuteRaw$inrWatchDog$1$1> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$inrTimeMills = r4;
        this.$params = r6;
        this.$pkg = r7;
        this.$event = r8;
        super(1, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r11) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new VmEngine$vmExecuteRaw$inrWatchDog$1$1(this.this$0, this.$inrTimeMills, this.$params, this.$pkg, this.$event, r9), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super bx> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super bx> r3) {
        return ((VmEngine$vmExecuteRaw$inrWatchDog$1$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), VmEngine$vmExecuteRaw$inrWatchDog$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r12);
        final bx r13 = i.a(e.a(this.this$0), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$inrTimeMills, this.this$0, this.$params, this.$pkg, this.$event, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        ca.b(getContext()).a((Function1) ZeusTransformUtils.preCheckCast(new VmEngine$vmExecuteRaw$inrWatchDog$1$1$2$1(r13), Function1.class, "com.obric.memorydata.plugin"));
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
