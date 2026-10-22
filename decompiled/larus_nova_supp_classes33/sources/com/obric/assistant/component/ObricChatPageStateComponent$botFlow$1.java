package com.obric.assistant.component;

import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/larus/im/bean/bot/BotModel;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricChatPageStateComponent$botFlow$1", f = "ObricChatPageStateComponent.kt", i = {}, l = {1447}, m = "invokeSuspend", n = {}, s = {})
final class ObricChatPageStateComponent$botFlow$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super BotModel>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.cvs.y $this_botFlow;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
        public final /* synthetic */ kotlinx.coroutines.channels.k<BotModel> a;

        public a(kotlinx.coroutines.channels.k<? super BotModel> r1) {
            this.a = r1;
        }

        public final void c(Object r4) {
            BotModel r5 = (BotModel) r4;
            Intrinsics.checkNotNullParameter(r5, "new");
            FLogger.a.i("OrionChatPageStateComponent", "onChange, BotModel: " + r5);
            this.a.trySend-JP2dKIU(r5);
            SendChannel.a.a(this.a);
        }
    }

    public ObricChatPageStateComponent$botFlow$1(com.larus.bmhome.chat.component.cvs.y r1, Continuation<? super ObricChatPageStateComponent$botFlow$1> r2) {
        this.$this_botFlow = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricChatPageStateComponent$botFlow$1 r0 = new ObricChatPageStateComponent$botFlow$1(this.$this_botFlow, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<? super BotModel> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) this.L$0;
        final a r2 = new a(r7);
        com.larus.bmhome.chat.component.cvs.y.b.a(this.$this_botFlow, r2);
        BotModel r3 = this.$this_botFlow.j0();
        if (r3 == null) goto L11;
        r7.trySend-JP2dKIU(r3);
        Boxing.boxBoolean(r7.close(null));
    L11:
        final com.larus.bmhome.chat.component.cvs.y r4 = this.$this_botFlow;
        Function0 r5 = new b1(r4, r2);
        this.label = 1;
        if (ProduceKt.a(r7, r5, this) != r0) goto L15;
        return r0;
    }
}
