package com.obric.aiagent.assistant.utils;

import android.content.Context;
import android.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1", f = "ObricAppStatusUtility.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class ObricAppStatusUtility$checkApprovalAsync$result$1 extends SuspendLambda implements Function2<al, Continuation<? super PrivacyApprovalStatus>, Object> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: renamed from: com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1$1", f = "ObricAppStatusUtility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ CancellationSignal $cancellationSignal;
        final /* synthetic */ Context $context;
        final /* synthetic */ w<PrivacyApprovalStatus> $deferred;
        int label;

        AnonymousClass1(Context r3, CancellationSignal r4, w<PrivacyApprovalStatus> r5, Continuation<? super AnonymousClass1> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            w<PrivacyApprovalStatus> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
            this.$cancellationSignal = r4;
            this.$deferred = r8;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$context, this.$cancellationSignal, this.$deferred, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            PrivacyApprovalStatus r4 = b.f5903a.a(this.$context, this.$cancellationSignal);
            this.$deferred.a(r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    ObricAppStatusUtility$checkApprovalAsync$result$1(Context r3, CancellationSignal r4, Continuation<? super ObricAppStatusUtility$checkApprovalAsync$result$1> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.$cancellationSignal = r4;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ObricAppStatusUtility$checkApprovalAsync$result$1(this.$context, this.$cancellationSignal, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super PrivacyApprovalStatus> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super PrivacyApprovalStatus> r4) {
        return ((ObricAppStatusUtility$checkApprovalAsync$result$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ObricAppStatusUtility$checkApprovalAsync$result$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        w r2 = y.a(null, 1, null);
        i.a(b.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$context, this.$cancellationSignal, r2, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r11 = r2.a(r12);
        if (r11 != r0) goto L11;
        return r0;
    }
}
