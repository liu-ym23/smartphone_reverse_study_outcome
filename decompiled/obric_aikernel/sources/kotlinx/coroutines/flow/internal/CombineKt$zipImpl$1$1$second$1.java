package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.l<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c<Object> $flow2;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.l<Object> f10480c;

        AnonymousClass1(kotlinx.coroutines.channels.l<Object> r10) {
            this.f10480c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(Object r10, Continuation<? super Unit> r11) {
            if ((r11 instanceof CombineKt$zipImpl$1$1$second$1$1$emit$1) == false) goto L7;
            CombineKt$zipImpl$1$1$second$1$1$emit$1 r12 = (CombineKt$zipImpl$1$1$second$1$1$emit$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            ResultKt.throwOnFailure(r14);
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            kotlinx.coroutines.channels.n<Object> r17 = this.f10480c.getChannel();
            if (r10 != null) goto L17;
            r10 = n.f10495a;
        L17:
            r12.label = 1;
            if (r17.H(r10, r12) != r15) goto L21;
            return r15;
        L7:
            r12 = new CombineKt$zipImpl$1$1$second$1$1$emit$1(this, r11);
            goto L8
        }
    }

    CombineKt$zipImpl$1$1$second$1(kotlinx.coroutines.flow.c<Object> r10, Continuation<? super CombineKt$zipImpl$1$1$second$1> r11) {
        this.$flow2 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CombineKt$zipImpl$1$1$second$1 r12 = new CombineKt$zipImpl$1$1$second$1(this.$flow2, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.l<? super Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.l<Object> r10, Continuation<? super Unit> r11) {
        return ((CombineKt$zipImpl$1$1$second$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        kotlinx.coroutines.channels.l r13 = (kotlinx.coroutines.channels.l) this.L$0;
        kotlinx.coroutines.flow.c<Object> r14 = this.$flow2;
        AnonymousClass1 r15 = new AnonymousClass1(r13);
        this.label = 1;
        if (r14.a(r15, this) != r11) goto L12;
        return r11;
    }
}
