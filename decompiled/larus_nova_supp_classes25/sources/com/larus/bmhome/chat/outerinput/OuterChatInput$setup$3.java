package com.larus.bmhome.chat.outerinput;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.f9;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInput$setup$3", f = "OuterChatInput.kt", i = {}, l = {DoraCallStateCode.RTOS_STOP_SI_BY_GESTURE}, m = "invokeSuspend", n = {}, s = {})
public final class OuterChatInput$setup$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ wc9.e $info;
    int label;
    final /* synthetic */ OuterChatInput this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ wc9.e a;
        public final /* synthetic */ OuterChatInput b;
        public final /* synthetic */ BotModel c;

        public a(wc9.e r1, OuterChatInput r2, BotModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r5, Continuation r6) {
            Integer r7 = (Integer) r5;
            Lazy r8 = f9.a;
            wc9.e r9 = this.a;
            List r0 = null;
            if (r9 == null) goto L5;
            String r1 = r9.a;
        L6:
            if (r9 == null) goto L8;
            Integer r2 = r9.v;
        L9:
            Integer r10 = f9.b(r9, r1, r2);
            OuterChatInput r3 = this.b;
            if (r7 != null) goto L12;
            Integer r4 = r10;
        L13:
            r3.g = r4;
            if (r10 == null) goto L16;
            FLogger.a.i("OuterChatInput", "[MainConversationInputFallback] outerReplay eventStyle=" + r7 + " fallbackStyle=" + r10 + " finalStyle=" + this.b.g);
        L16:
            OuterChatInput r11 = this.b;
            BotModel r12 = this.c;
            if (r12 == null) goto L19;
            r0 = r12.getBotConf();
        L19:
            OuterChatInput.T5(r11, r0);
            return Unit.INSTANCE;
        L12:
            r4 = r7;
            goto L13
        L8:
            r2 = null;
            goto L9
        L5:
            r1 = null;
            goto L6
        }
    }

    public OuterChatInput$setup$3(wc9.e r1, OuterChatInput r2, BotModel r3, Continuation<? super OuterChatInput$setup$3> r4) {
        this.$info = r1;
        this.this$0 = r2;
        this.$botModel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OuterChatInput$setup$3(this.$info, this.this$0, this.$botModel, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MutableSharedFlow<Integer> r8 = OuterInputEventBus.a;
        MutableSharedFlow<Integer> r9 = OuterInputEventBus.b;
        a r2 = new a(this.$info, this.this$0, this.$botModel);
        this.label = 1;
        if (r9.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
