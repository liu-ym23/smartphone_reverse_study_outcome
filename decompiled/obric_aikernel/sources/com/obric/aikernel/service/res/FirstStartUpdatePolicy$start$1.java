package com.obric.aikernel.service.res;

import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.FirstStartUpdatePolicy$start$1", f = "FirstStartUpdatePolicy.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
final class FirstStartUpdatePolicy$start$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FirstStartUpdatePolicy this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.FirstStartUpdatePolicy$start$1$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.FirstStartUpdatePolicy$start$1$1", f = "FirstStartUpdatePolicy.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FirstStartUpdatePolicy this$0;

        AnonymousClass1(FirstStartUpdatePolicy r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean r10, Continuation<? super Unit> r11) {
            return invoke(r10.booleanValue(), r11);
        }

        public final Object invoke(boolean r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(Boolean.valueOf(r10), r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            FirstStartUpdatePolicy r13 = this.this$0;
            this.label = 1;
            if (FirstStartUpdatePolicy.a(r13, this) != r11) goto L12;
            return r11;
        }
    }

    FirstStartUpdatePolicy$start$1(FirstStartUpdatePolicy r10, Continuation<? super FirstStartUpdatePolicy$start$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FirstStartUpdatePolicy$start$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((FirstStartUpdatePolicy$start$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        NetworkStateListener r13 = NetworkStateListener.f4510a;
        if (r13.i().getValue().booleanValue() == true) goto L11;
        r13.l();
    L11:
        AnonymousClass1 r14 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (r13.d(r14, this) != r11) goto L15;
        return r11;
    }
}
