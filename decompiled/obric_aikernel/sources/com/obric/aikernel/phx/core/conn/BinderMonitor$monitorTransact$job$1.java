package com.obric.aikernel.phx.core.conn;

import com.obric.aikernel.core.log.AIKLog;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.BinderMonitor$monitorTransact$job$1", f = "BinderMonitor.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class BinderMonitor$monitorTransact$job$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $ctx;
    final /* synthetic */ Ref.ObjectRef<BinderMonitor.a> $info;
    final /* synthetic */ Function0<Unit> $onDied;
    private /* synthetic */ Object L$0;
    int label;

    static final class a<T> implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l0 f4773c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ CoroutineContext f4774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f4775h;

        a(l0 r10, CoroutineContext r11, Function0<Unit> r12) {
            this.f4773c = r10;
            this.f4774g = r11;
            this.f4775h = r12;
        }

        public final Object a(boolean r10, Continuation<? super Unit> r11) {
            if (r10 == true) goto L13;
            CoroutineContext r12 = this.f4774g;
            Function0<Unit> r13 = this.f4775h;
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L7
            AIKLog.INSTANCE.i("BinderMonitor", "monitorTransact: callback onDied: " + r12);     // Catch: Throwable -> L7
            r13.invoke();     // Catch: Throwable -> L7
            Object r15 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r16 = Result.m35exceptionOrNullimpl(r15);
            if (r16 == null) goto L13;
            AIKLog.INSTANCE.e("BinderMonitor", "monitorTransact: callback onDied error, " + r16);
        L7:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        L13:
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.d
        public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
            return a(((Boolean) r10).booleanValue(), r11);
        }
    }

    BinderMonitor$monitorTransact$job$1(Ref.ObjectRef<BinderMonitor.a> r10, CoroutineContext r11, Function0<Unit> r12, Continuation<? super BinderMonitor$monitorTransact$job$1> r13) {
        this.$info = r10;
        this.$ctx = r11;
        this.$onDied = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        BinderMonitor$monitorTransact$job$1 r12 = new BinderMonitor$monitorTransact$job$1(this.$info, this.$ctx, this.$onDied, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((BinderMonitor$monitorTransact$job$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L6;
        ResultKt.throwOnFailure(r10);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        l0 r13 = (l0) this.L$0;
        BinderMonitor.a r14 = this.$info.element;
        if (r14 == null) goto L18;
        g1<Boolean> r15 = r14.c();
        if (r15 == null) goto L18;
        CoroutineContext r16 = this.$ctx;
        AIKLog.INSTANCE.d("BinderMonitor", "monitorTransact: register onDied stateFlow: " + r16);
        a r17 = new a(r13, this.$ctx, this.$onDied);
        this.label = 1;
        if (r15.a(r17, this) != r11) goto L16;
        return r11;
    L18:
        return Unit.INSTANCE;
    }
}
