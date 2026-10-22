package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.TTSMenuHandler$startTts$1", f = "TTSMenuItem.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
final class TTSMenuHandler$startTts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ ef8.b $menuContext;
    final /* synthetic */ com.larus.bmhome.chat.api.q0.a $modelProvider;
    final /* synthetic */ x1 $reader;
    int label;
    final /* synthetic */ c1 this$0;

    public TTSMenuHandler$startTts$1(com.larus.bmhome.chat.api.q0.a r1, x1 r2, c1 r3, Message r4, ef8.b r5, Continuation<? super TTSMenuHandler$startTts$1> r6) {
        this.$modelProvider = r1;
        this.$reader = r2;
        this.$data = r4;
        this.$menuContext = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new TTSMenuHandler$startTts$1(this.$modelProvider, this.$reader, null, this.$data, this.$menuContext, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.larus.bmhome.chat.api.q0.a r5 = this.$modelProvider;
        if (r5 == null) goto L13;
        com.larus.bmhome.chat.component.cvs.y r6 = r5.u0();
        if (r6 == null) goto L13;
        BotModel r7 = r6.j0();
    L15:
        if (ve8.c.c(r7) != true) goto L17;
        FLogger.a.i("[TTS] TTSMenuHandler", "should show tts loading or other state toast, should: " + this.$reader.n6() + '.');
        by7.e r8 = this.$menuContext.d;
        throw null;
    L13:
        r7 = null;
        goto L15
    }
}
