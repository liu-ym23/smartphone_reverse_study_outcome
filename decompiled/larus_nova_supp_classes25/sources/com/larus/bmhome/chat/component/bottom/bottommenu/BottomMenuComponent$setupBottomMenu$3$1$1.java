package com.larus.bmhome.chat.component.bottom.bottommenu;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$setupBottomMenu$3$1$1", f = "BottomMenuComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BottomMenuComponent$setupBottomMenu$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $fileClickContinuation;
    int label;
    final /* synthetic */ BottomMenuComponent this$0;

    public BottomMenuComponent$setupBottomMenu$3$1$1(BottomMenuComponent r1, Function0<Unit> r2, Continuation<? super BottomMenuComponent$setupBottomMenu$3$1$1> r3) {
        this.this$0 = r1;
        this.$fileClickContinuation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BottomMenuComponent$setupBottomMenu$3$1$1(this.this$0, this.$fileClickContinuation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        if (s1a.a.c(this.this$0).getParentFragmentManager().isStateSaved() == false) goto L8;
        FLogger.a.w("MultimodalInputWrapper", "[setupBottomMenu] Skip queued file click because FragmentManager state is saved");
        return Unit.INSTANCE;
    L8:
        FLogger.a.i("MultimodalInputWrapper", "[setupBottomMenu] Execute queued file click after host resumed");
        final Function0<Unit> r4 = this.$fileClickContinuation;
        com.larus.utils.t0.c(new e1(r4));
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
