package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.list.u7$a;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.NewCvsMenuHandler$handleAction$1", f = "NewCvsMenuItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NewCvsMenuHandler$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $chatUniqueKey;
    final /* synthetic */ BotModel $currentBot;
    final /* synthetic */ Message $data;
    final /* synthetic */ com.larus.bmhome.chat.api.q0.a $modelProvider;
    final /* synthetic */ View $view;
    int label;

    public NewCvsMenuHandler$handleAction$1(Message r1, BotModel r2, com.larus.bmhome.chat.api.q0.a r3, long r4, View r6, Continuation<? super NewCvsMenuHandler$handleAction$1> r7) {
        this.$data = r1;
        this.$currentBot = r2;
        this.$modelProvider = r3;
        this.$chatUniqueKey = r4;
        this.$view = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new NewCvsMenuHandler$handleAction$1(this.$data, this.$currentBot, this.$modelProvider, this.$chatUniqueKey, this.$view, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L44;
        ResultKt.throwOnFailure(r12);
        String r13 = this.$data.getConversationId();
        BotModel r0 = this.$currentBot;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getBotId();
    L8:
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L42;
        com.larus.bmhome.chat.api.q0.a r4 = this.$modelProvider;
        if (r4 == null) goto L23;
        u7 r5 = r4.u3();
        if (r5 == null) goto L23;
        String r6 = this.$data.getMessageId();
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        u7$a.b(r5, r6, null, null, 14);
    L23:
        ChatControlTrace r7 = ChatControlTrace.b;
        if (com.larus.bmhome.chat.bean.d.G0(this.$data) == false) goto L26;
        String r8 = "long_press_user";
    L27:
        String r9 = r8;
        if (r13 != null) goto L30;
        String r10 = "";
    L31:
        long r11 = this.$chatUniqueKey;
        Message r14 = this.$data;
        Fragment r15 = e1.k(this.$view);
        if (r15 == null) goto L40;
        com.larus.bmhome.chat.mode.e r16 = s1a.a.g(r15).getAbility(com.larus.bmhome.chat.mode.e.class);
        if (r16 == null) goto L40;
        i1 r17 = r16.Si();
        if (r17 == null) goto L40;
        ConversationMode r18 = (ConversationMode) r17.getValue();
        if (r18 == null) goto L40;
        r1 = r18.a();
    L40:
        r7.getClass();
        ChatControlTrace.P(r9, r10, r11, r14, null, r1);
        goto L42
    L30:
        r10 = r13;
        goto L31
    L26:
        r8 = "long_press_answer";
    L42:
        return Unit.INSTANCE;
    L10:
        if (StringsKt.isBlank(r2) == true) goto L13;
        r3 = false;
        goto L14
    L7:
        r2 = null;
        goto L8
    L44:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
