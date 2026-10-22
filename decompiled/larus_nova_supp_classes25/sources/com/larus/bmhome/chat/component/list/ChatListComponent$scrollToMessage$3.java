package com.larus.bmhome.chat.component.list;

import android.content.Context;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$scrollToMessage$3", f = "ChatListComponent.kt", i = {0}, l = {2942}, m = "invokeSuspend", n = {"lastCursor"}, s = {"J$0"})
final class ChatListComponent$scrollToMessage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $alignTop;
    final /* synthetic */ String $targetMsgId;
    final /* synthetic */ boolean $toastWhenFailed;
    long J$0;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$scrollToMessage$3(ChatListComponent r1, String r2, boolean r3, boolean r4, Continuation<? super ChatListComponent$scrollToMessage$3> r5) {
        this.this$0 = r1;
        this.$targetMsgId = r2;
        this.$toastWhenFailed = r3;
        this.$alignTop = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatListComponent$scrollToMessage$3(this.this$0, this.$targetMsgId, this.$toastWhenFailed, this.$alignTop, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r3 = this.J$0;
        ResultKt.throwOnFailure(r11);
    L32:
        Message r12 = (Message) r11;
        if (r12 != null) goto L35;
    L62:
        if (r2 == false) goto L64;
        long r4 = ((r3 - r12.getLocalIndex()) / ((long) 1000)) + ((long) 5);
        if (r4 <= 0) goto L71;
        ChatListComponent r13 = this.this$0;
        int r5 = ChatListComponent.W3;
        ChatListComponentViewModel r14 = r13.U5();
        final ChatListComponent r6 = this.this$0;
        final String r7 = this.$targetMsgId;
        final boolean r8 = this.$alignTop;
        r14.appendLoadMessageList(new AnonymousClass1(r6, r7, r8), Boxing.boxInt((int) r4));
        return Unit.INSTANCE;
    L71:
        return Unit.INSTANCE;
    L64:
        if (this.$toastWhenFailed == false) goto L67;
        t19.s r15 = t19.s.a;
        Context r9 = this.this$0.getContext();
        r15.getClass();
        t19.s.s(r9, 2131900251);
    L67:
        return Unit.INSTANCE;
    L35:
        if (d.i0(r12) == false) goto L40;
        if (d.w(r12) == true) goto L40;
    L59:
        boolean r10 = false;
    L60:
        if (r10 != true) goto L62;
        r2 = true;
    L40:
        if (d.T(r12) == true) goto L59;
        if (d.p0(r12) == true) goto L59;
        if (d.C0(r12) == true) goto L47;
    L49:
        MessageStatus r16 = r12.getMessageStatus();
        if (r16 != null) goto L52;
    L54:
        boolean r17 = false;
    L55:
        if (r17 == false) goto L57;
    L58:
        r10 = true;
        goto L60
    L57:
        if (com.larus.bmhome.social.userchat.model.b0.f(r12) == false) goto L59;
    L52:
        if (r16.isVisible() != true) goto L54;
        r17 = true;
        goto L55
    L47:
        if (r12.getRegenVisible() == true) goto L49;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MessageAdapter r18 = this.this$0.O;
        b r19 = null;
        if (r18 == null) goto L11;
        List<b> r110 = r18.z2();
    L12:
        if (r110 == null) goto L27;
        ListIterator<b> r111 = r110.listIterator(r110.size());
    L15:
        if (r111.hasPrevious() == false) goto L22;
        b r20 = r111.previous();
        if (r20.getMessage().getLocalIndex() <= 0) goto L19;
        boolean r21 = true;
    L20:
        if (r21 == false) goto L15;
        r19 = r20;
        goto L22
    L19:
        r21 = false;
    L22:
        b r22 = r19;
        if (r22 == null) goto L27;
        Message r112 = r22.getMessage();
        if (r112 == null) goto L27;
        long r23 = r112.getLocalIndex();
    L28:
        RepoDispatcher.a.getClass();
        ChatRepo r113 = RepoDispatcher.d;
        String r24 = this.$targetMsgId;
        this.J$0 = r23;
        this.label = 1;
        r11 = r113.E1(r24, this);
        if (r11 != r0) goto L31;
        return r0;
    L31:
        r3 = r23;
    L27:
        r23 = -1;
        goto L28
    L11:
        r110 = null;
        goto L12
    }
}
