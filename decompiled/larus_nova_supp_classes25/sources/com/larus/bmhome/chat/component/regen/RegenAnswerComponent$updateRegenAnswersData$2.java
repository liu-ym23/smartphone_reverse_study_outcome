package com.larus.bmhome.chat.component.regen;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.a;
import com.larus.utils.logger.FLogger;
import de8.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.regen.RegenAnswerComponent$updateRegenAnswersData$2", f = "RegenAnswerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RegenAnswerComponent$updateRegenAnswersData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $answers;
    final /* synthetic */ boolean $noRegenAction;
    final /* synthetic */ String $question;
    final /* synthetic */ String $selected;
    int label;
    final /* synthetic */ RegenAnswerComponent this$0;

    public RegenAnswerComponent$updateRegenAnswersData$2(String r1, String r2, List<String> r3, boolean r4, RegenAnswerComponent r5, Continuation<? super RegenAnswerComponent$updateRegenAnswersData$2> r6) {
        this.$question = r1;
        this.$selected = r2;
        this.$answers = r3;
        this.$noRegenAction = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RegenAnswerComponent$updateRegenAnswersData$2(this.$question, this.$selected, this.$answers, this.$noRegenAction, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        h r6 = new h(this.$question, this.$selected, this.$answers, this.$noRegenAction);
        FLogger.a.i("RegenAnswerComponent", "update regen answer " + r6);
        this.this$0.i.setValue(r6);
        c r0 = (c) this.this$0.k.getValue();
        if (r0 == null) goto L10;
        long r1 = r0.n;
        ChatControlTrace.b.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        a r2 = (a) ChatControlTrace.C.get(Long.valueOf(r1));
        if (r2 == null) goto L14;
        r2.n = r6;
    L14:
        return Unit.INSTANCE;
    L10:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
