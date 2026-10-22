package com.obric.aikernel.service.res;

import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$checkShouldTriggerAutoUpdate$1", f = "PythonRuntimeService.kt", i = {}, l = {756}, m = "invokeSuspend", n = {}, s = {})
final class PythonRuntimeService$checkShouldTriggerAutoUpdate$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PythonRuntimeService.b $triggerSnapshot;
    int label;
    final /* synthetic */ PythonRuntimeService this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$checkShouldTriggerAutoUpdate$1$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$checkShouldTriggerAutoUpdate$1$1", f = "PythonRuntimeService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ PythonRuntimeService.b $triggerSnapshot;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ PythonRuntimeService this$0;

        AnonymousClass1(PythonRuntimeService r10, PythonRuntimeService.b r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$triggerSnapshot = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$triggerSnapshot, r11);
            r12.Z$0 = ((Boolean) r10).booleanValue();
            return r12;
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r10);
            boolean r11 = this.Z$0;
            g1 r12 = PythonRuntimeService.k(this.this$0);
            if (this.$triggerSnapshot.d() == false) goto L8;
            String r13 = this.$triggerSnapshot.b().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String r14 = l.a(r13, this.$triggerSnapshot.c(), this.$triggerSnapshot.a(), this.$triggerSnapshot.e());
        L12:
            r12.c(r14);
            return Unit.INSTANCE;
        L8:
            if (r11 == false) goto L10;
            StringBuilder r15 = new StringBuilder();
            String r16 = "timer start from ";
        L11:
            r15.append(r16);
            r15.append(this.$triggerSnapshot.c());
            r15.append(", interval: ");
            r15.append(this.$triggerSnapshot.a());
            r15.append("ms");
            r14 = r15.toString();
            goto L12
        L10:
            r15 = new StringBuilder();
            r16 = "network resumed, start from ";
            goto L11
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    PythonRuntimeService$checkShouldTriggerAutoUpdate$1(PythonRuntimeService r10, PythonRuntimeService.b r11, Continuation<? super PythonRuntimeService$checkShouldTriggerAutoUpdate$1> r12) {
        this.this$0 = r10;
        this.$triggerSnapshot = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PythonRuntimeService$checkShouldTriggerAutoUpdate$1(this.this$0, this.$triggerSnapshot, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PythonRuntimeService$checkShouldTriggerAutoUpdate$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        NetworkStateListener r13 = NetworkStateListener.f4510a;
        AnonymousClass1 r14 = new AnonymousClass1(this.this$0, this.$triggerSnapshot, null);
        this.label = 1;
        if (r13.d(r14, this) != r11) goto L12;
        return r11;
    }
}
