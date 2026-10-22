package com.larus.uaigc.chat;

import com.larus.bmhome.chat.component.list.u7;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationComponent$bindObservers$1", f = "CreationComponent.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
final class CreationComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.chat.CreationComponent$bindObservers$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ CreationComponent a;

        public AnonymousClass1(CreationComponent r1) {
            this.a = r1;
        }

        public final Object a(Pair<Boolean, Integer> r7, Continuation<? super Unit> r8) {
            if ((r8 instanceof CreationComponent$bindObservers$1$1$emit$1) == false) goto L7;
            CreationComponent$bindObservers$1$1$emit$1 r0 = (CreationComponent$bindObservers$1$1$emit$1) r8;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L18;
            if (r3 == 1) goto L17;
            if (r3 == 2) goto L16;
            if (r3 != 3) goto L15;
            ResultKt.throwOnFailure(r9);
        L34:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r9);
        L29:
            return Unit.INSTANCE;
        L17:
            ResultKt.throwOnFailure(r9);
        L25:
            CreationComponent r10 = this.a;
            int r11 = CreationComponent.n;
            CreationVideoManagerViewModel r12 = ((CreationViewModel) r10.i.getValue()).getVideoManagerViewModel();
            r0.label = 2;
            if (r12.f(r0) != r2) goto L29;
            return r2;
        L18:
            ResultKt.throwOnFailure(r9);
            if (((Number) r7.getSecond()).intValue() != 0) goto L36;
            if (((Boolean) r7.getFirst()).booleanValue() == false) goto L30;
            r0.label = 1;
            if (DelayKt.delay(50, r0) != r2) goto L25;
            return r2;
        L30:
            CreationComponent r13 = this.a;
            int r14 = CreationComponent.n;
            CreationVideoManagerViewModel r15 = ((CreationViewModel) r13.i.getValue()).getVideoManagerViewModel();
            r0.label = 3;
            if (r15.f(r0) != r2) goto L34;
            return r2;
        L36:
            return Unit.INSTANCE;
        L7:
            r0 = new CreationComponent$bindObservers$1$1$emit$1(this, r8);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((Pair) r1, r2);
        }
    }

    public CreationComponent$bindObservers$1(CreationComponent r1, Continuation<? super CreationComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationComponent$bindObservers$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationComponent r6 = this.this$0;
        int r2 = CreationComponent.n;
        u7 r7 = (u7) r6.j.getValue();
        if (r7 == null) goto L18;
        MutableSharedFlow r8 = r7.m30();
        if (r8 == null) goto L18;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
