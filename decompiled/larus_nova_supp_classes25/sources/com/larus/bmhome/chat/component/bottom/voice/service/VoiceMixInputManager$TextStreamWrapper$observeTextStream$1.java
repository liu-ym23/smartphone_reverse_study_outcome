package com.larus.bmhome.chat.component.bottom.voice.service;

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
final /* synthetic */ class VoiceMixInputManager$TextStreamWrapper$observeTextStream$1 extends FunctionReferenceImpl implements Function2<h, Continuation<? super Unit>, Object>, SuspendFunction {
    public VoiceMixInputManager$TextStreamWrapper$observeTextStream$1(Object r8) {
        super(2, r8, Intrinsics.Kotlin.class, "suspendConversion0", "observeTextStream$suspendConversion0(Lkotlin/jvm/functions/Function1;Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$TextStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(h r1, Continuation<? super Unit> r2) {
        ((Function1) ((CallableReference) this).receiver).invoke(r1);
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((h) r1, (Continuation) r2);
    }
}
