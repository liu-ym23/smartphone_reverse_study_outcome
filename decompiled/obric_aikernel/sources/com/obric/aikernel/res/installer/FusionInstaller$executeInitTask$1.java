package com.obric.aikernel.res.installer;

import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.installer.FusionInstaller$executeInitTask$1", f = "FusionInstaller.kt", i = {}, l = {24, 24}, m = "invokeSuspend", n = {}, s = {})
final class FusionInstaller$executeInitTask$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<List<a.b>, Continuation<? super Unit>, Object> $task;
    Object L$0;
    int label;
    final /* synthetic */ FusionInstaller this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.res.installer.FusionInstaller$executeInitTask$1$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.res.installer.FusionInstaller$executeInitTask$1$1", f = "FusionInstaller.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super List<? extends a.b>>, Object> {
        int label;
        final /* synthetic */ FusionInstaller this$0;

        AnonymousClass1(FusionInstaller r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super List<? extends a.b>> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super List<a.b>> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
            w r13 = FusionInstaller.d(this.this$0);
            this.label = 1;
            r10 = r13.r(this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    FusionInstaller$executeInitTask$1(Function2<? super List<a.b>, ? super Continuation<? super Unit>, ? extends Object> r10, FusionInstaller r11, Continuation<? super FusionInstaller$executeInitTask$1> r12) {
        this.$task = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FusionInstaller$executeInitTask$1(this.$task, this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((FusionInstaller$executeInitTask$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Function2 r13 = (Function2) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r13.invoke(r10, this) != r11) goto L17;
        return r11;
    L10:
        ResultKt.throwOnFailure(r10);
        r13 = this.$task;
        AnonymousClass1 r14 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r13;
        this.label = 1;
        r10 = TimeoutKt.d(VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER, r14, this);
        if (r10 != r11) goto L13;
        return r11;
    }
}
