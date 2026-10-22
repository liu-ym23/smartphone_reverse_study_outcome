package com.larus.bmhome.chat.component.title;

import androidx.lifecycle.LiveData;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.IMConnectState;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.api.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import s1a.a;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$initTitleByBot$1$2", f = "ChatTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleComponent$initTitleByBot$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    public ChatTitleComponent$initTitleByBot$1$2(ChatTitleComponent r1, BotModel r2, Continuation<? super ChatTitleComponent$initTitleByBot$1$2> r3) {
        this.this$0 = r1;
        this.$bot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTitleComponent$initTitleByBot$1$2(this.this$0, this.$bot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r6);
        ChatTitleComponent r7 = this.this$0;
        com.larus.platform.api.g0 r0 = r7.n;
        if (r0 == null) goto L7;
        LiveData r8 = (LiveData) r7.V.getValue();
        SpeakerVoice r1 = null;
        if (r8 == null) goto L11;
        IMConnectState r9 = (IMConnectState) r8.getValue();
    L13:
        if (r9 != IMConnectState.CONNECTED) goto L15;
        this.this$0.i5();
    L15:
        BotModel r10 = this.$bot;
        if (r10 == null) goto L18;
        r1 = r10.getVoiceType();
    L18:
        boolean r11 = false;
        if (r1 == null) goto L21;
        boolean r2 = true;
    L23:
        if (this.this$0.f1().C() == true) goto L25;
    L26:
        AudioServiceDelegate.a.i0().l(this.$bot);
    L27:
        u7 r3 = this.this$0.X3();
        if (r3 != null) goto L30;
    L32:
        if (r11 == false) goto L40;
        if (r2 == false) goto L40;
        u7 r12 = this.this$0.X3();
        if (r12 == null) goto L37;
        r12.Rc();
    L37:
        u7 r13 = this.this$0.X3();
        if (r13 == null) goto L40;
        r13.ye(true);
    L40:
        e r14 = this.this$0.V3();
        if (r14 == null) goto L54;
        j r4 = this.this$0.h3();
        String r5 = "";
        if (r4 == null) goto L49;
        String r15 = r14.c;
        if (r15 == null) goto L48;
        r5 = r15;
    L48:
        r0.Ia(r5, r4, r14.g());
        goto L54
    L49:
        String r16 = r14.c;
        if (r16 == null) goto L53;
        r5 = r16;
    L53:
        com.larus.platform.api.g0.a.b(r0, r5, r14.g(), 2);
    L54:
        ChatTitleComponent.Y2(this.this$0);
        return Unit.INSTANCE;
    L30:
        if (r3.Qf() != true) goto L32;
        r11 = true;
        goto L32
    L25:
        if (a.c(this.this$0).isResumed() == false) goto L27;
    L21:
        r2 = false;
        goto L23
    L11:
        r9 = null;
        goto L13
    L7:
        return Unit.INSTANCE;
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
