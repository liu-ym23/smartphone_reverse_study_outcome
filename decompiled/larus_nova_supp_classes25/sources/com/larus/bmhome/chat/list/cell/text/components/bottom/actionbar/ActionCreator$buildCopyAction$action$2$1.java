package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.bmhome.chat.component.push.a$a;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.OpenPushReminderScene;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.ActionCreator$buildCopyAction$action$2$1", f = "ActionCreator.kt", i = {0, 1}, l = {1041, 1052}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class ActionCreator$buildCopyAction$action$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Function0<Long> $chatKey;
    final /* synthetic */ CustomMarkdownTextView $markdownView;
    final /* synthetic */ Message $msg;
    final /* synthetic */ Function0<Unit> $onCopyClicked;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ z this$0;

    public ActionCreator$buildCopyAction$action$2$1(z r1, Message r2, Function0<Long> r3, CustomMarkdownTextView r4, Function0<Unit> r5, BotModel r6, Continuation<? super ActionCreator$buildCopyAction$action$2$1> r7) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$chatKey = r3;
        this.$markdownView = r4;
        this.$onCopyClicked = r5;
        this.$bot = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ActionCreator$buildCopyAction$action$2$1 r8 = new ActionCreator$buildCopyAction$action$2$1(this.this$0, this.$msg, this.$chatKey, this.$markdownView, this.$onCopyClicked, this.$bot, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        BotModel r5 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
    L26:
        Function0<Unit> r4 = this.$onCopyClicked;
        if (r4 == null) goto L29;
        r4.invoke();
    L29:
        com.larus.bmhome.chat.component.cvs.y r6 = this.this$0.e.u0();
        if (r6 == null) goto L32;
        wc9.e r8 = r6.h();
    L33:
        if (r8 == null) goto L35;
        String r7 = r8.a;
    L37:
        if (Intrinsics.areEqual(r7, this.$msg.getConversationId()) == true) goto L39;
    L51:
        a(this.$msg, this.this$0);
    L53:
        return Unit.INSTANCE;
    L39:
        if (ic8.n.v(r8) == true) goto L43;
        if (ic8.n.D(r8) == false) goto L51;
    L43:
        if (com.larus.bmhome.chat.bean.d.G0(this.$msg) == true) goto L51;
        com.larus.bmhome.chat.component.push.a r9 = this.this$0.e.a9();
        if (r9 == null) goto L50;
        OpenPushReminderScene r10 = OpenPushReminderScene.CopyMsgFromMainBot;
        com.larus.bmhome.chat.component.cvs.y r11 = this.this$0.e.u0();
        if (r11 == null) goto L49;
        r5 = r11.j0();
    L49:
        final Message r12 = this.$msg;
        final z r13 = this.this$0;
        a$a.a(r9, r10, r8, r5, null, new a0(r12, r13), 8);
        goto L53
    L50:
        a(this.$msg, this.this$0);
        goto L53
    L35:
        r7 = null;
        goto L37
    L32:
        r8 = null;
        goto L33
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r15 = r18;
    L17:
        List<? extends lw8.l> r16 = (List) r15;
        LruCache r17 = ko8.a.a;
        Message r19 = this.$msg;
        by7.e r20 = com.larus.utils.e1.k(this.this$0.b);
        if ((r20 instanceof by7.e) == false) goto L20;
        by7.e r21 = r20;
    L21:
        ko8.a.j("answer", r19, r21, ((Number) this.$chatKey.invoke()).longValue(), r16, this.$markdownView, null, null, ChatDraftItem.TYPE_TEXT, 192);
        com.larus.bmhome.chat.layout.holder.helper.s0 r22 = ILegacyChatUiServiceDelegate.b.X8();
        if (r22 == null) goto L26;
        Context r23 = this.this$0.c;
        this.L$0 = r14;
        this.label = 2;
        if (r22.e(r23, r16, null, this) != r1) goto L26;
        return r1;
    L20:
        r21 = null;
        goto L21
    L10:
        ResultKt.throwOnFailure(r18);
        r14 = (CoroutineScope) this.L$0;
        if (((Boolean) this.this$0.f.getValue()).booleanValue() == false) goto L13;
        MainCoroutineDispatcher r24 = Dispatchers.getMain();
    L14:
        ActionCreator$buildCopyAction$action$2$1$markdownContentList$1 r25 = new ActionCreator$buildCopyAction$action$2$1$markdownContentList$1(this.this$0, this.$msg, this.$bot, null);
        this.L$0 = r14;
        this.label = 1;
        r15 = BuildersKt.withContext(r24, r25, this);
        if (r15 != r1) goto L17;
        return r1;
    L13:
        r24 = Dispatchers.getIO();
        goto L14
    }

    public static final void a(Message r4, z r5) {
        if (com.larus.bmhome.chat.bean.d.v0(r4) == false) goto L6;
        t19.s r6 = t19.s.a;
        Context r7 = r5.c;
        r6.getClass();
        t19.s.o(r7, 2131910467, false);
        return;
    L6:
        ld8.n r0 = r5.e.K9();
        if (r0 == null) goto L14;
        CollectFrom r3 = CollectFrom.COPY;
        String r8 = r4.getMessageId();
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        boolean r9 = r0.Ho(r3, r8);
        boolean r1 = true;
        if (r9 != true) goto L14;
    L15:
        if (r1 == true) goto L18;
        t19.s r10 = t19.s.a;
        Context r11 = r5.c;
        r10.getClass();
        t19.s.o(r11, 2131910467, false);
        return;
    L18:
        return;
    L14:
        r1 = false;
        goto L15
    }
}
