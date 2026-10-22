package com.obric.aikernel.res.update;

import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$checkToResumeUpdateTask$1", f = "PackageUpdater.kt", i = {}, l = {937}, m = "invokeSuspend", n = {}, s = {})
final class PackageUpdater$checkToResumeUpdateTask$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PackageUpdater this$0;

    static final class a<T> implements kotlinx.coroutines.flow.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PackageUpdater f5131c;

        a(PackageUpdater r10) {
            this.f5131c = r10;
        }

        public final Object a(Pair<Boolean, String> r10, Continuation<? super Unit> r11) {
            this.f5131c.w("allowBackgroundUpdate:" + r10.getSecond());
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.d
        public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
            return a((Pair) r10, r11);
        }
    }

    PackageUpdater$checkToResumeUpdateTask$1(PackageUpdater r10, Continuation<? super PackageUpdater$checkToResumeUpdateTask$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PackageUpdater$checkToResumeUpdateTask$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PackageUpdater$checkToResumeUpdateTask$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L6;
        ResultKt.throwOnFailure(r10);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        g1<Pair<Boolean, String>> r13 = PackageUpdater.b(this.this$0).getConfig().getAppConfig().getAllowBackgroundUpdate();
        a r14 = new a(this.this$0);
        this.label = 1;
        if (r13.a(r14, this) != r11) goto L12;
        return r11;
    }
}
