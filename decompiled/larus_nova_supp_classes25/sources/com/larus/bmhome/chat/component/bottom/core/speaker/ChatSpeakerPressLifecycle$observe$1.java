package com.larus.bmhome.chat.component.bottom.core.speaker;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class ChatSpeakerPressLifecycle$observe$1 extends FunctionReferenceImpl implements Function2<e.c, Continuation<? super Unit>, Object>, SuspendFunction {
    public ChatSpeakerPressLifecycle$observe$1(Object r8) {
        super(2, r8, Intrinsics.Kotlin.class, "suspendConversion0", "observe$suspendConversion0(Lkotlin/jvm/functions/Function1;Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(e.c r2, Continuation<? super Unit> r3) {
        Function1 r4 = (Function1) ((CallableReference) this).receiver;
        int r0 = e.k;
        r4.invoke(r2);
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((e.c) r1, (Continuation) r2);
    }
}
