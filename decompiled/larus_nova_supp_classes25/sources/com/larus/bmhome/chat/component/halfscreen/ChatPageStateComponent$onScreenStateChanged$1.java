package com.larus.bmhome.chat.component.halfscreen;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.halfscreen.ChatPageStateComponent$onScreenStateChanged$1", f = "ChatPageStateComponent.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class ChatPageStateComponent$onScreenStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $action;
    int label;
    final /* synthetic */ ChatPageStateComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            ScreenState r4 = (ScreenState) r2;
            if (r4 == ScreenState.UNINITIALIZED) goto L10;
            Function1<Boolean, Unit> r5 = this.a;
            if (r4 != ScreenState.FULL) goto L7;
            boolean r6 = true;
        L8:
            r5.invoke(Boxing.boxBoolean(r6));
            goto L10
        L7:
            r6 = false;
        L10:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatPageStateComponent$onScreenStateChanged$1(ChatPageStateComponent r1, Function1<? super Boolean, Unit> r2, Continuation<? super ChatPageStateComponent$onScreenStateChanged$1> r3) {
        this.this$0 = r1;
        this.$action = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatPageStateComponent$onScreenStateChanged$1(this.this$0, this.$action, r4);
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
        b1 r6 = this.this$0.j;
        a r2 = new a(this.$action);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
