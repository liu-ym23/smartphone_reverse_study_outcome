package com.larus.bmhome.floatchat.component;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.floatchat.component.FloatChatFoldHandlerComponent$observeFloatChatKeyboardAvoidance$1", f = "FloatChatFoldHandlerComponent.kt", i = {}, l = {710}, m = "invokeSuspend", n = {}, s = {})
final class FloatChatFoldHandlerComponent$observeFloatChatKeyboardAvoidance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i1<Integer> $inputStatusFlow;
    int label;
    final /* synthetic */ FloatChatFoldHandlerComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ FloatChatFoldHandlerComponent a;

        public a(FloatChatFoldHandlerComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ((Number) r1).intValue();
            FloatChatFoldHandlerComponent r3 = this.a;
            int r4 = FloatChatFoldHandlerComponent.H1;
            r3.Z3();
            return Unit.INSTANCE;
        }
    }

    public FloatChatFoldHandlerComponent$observeFloatChatKeyboardAvoidance$1(i1<Integer> r1, FloatChatFoldHandlerComponent r2, Continuation<? super FloatChatFoldHandlerComponent$observeFloatChatKeyboardAvoidance$1> r3) {
        this.$inputStatusFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FloatChatFoldHandlerComponent$observeFloatChatKeyboardAvoidance$1(this.$inputStatusFlow, this.this$0, r4);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1<Integer> r6 = this.$inputStatusFlow;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
