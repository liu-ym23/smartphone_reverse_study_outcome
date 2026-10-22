package com.larus.bmhome.chat.cell.slot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ChatRetryWithText;
import com.larus.bmhome.utils.z1;
import com.larus.chat.common.databinding.LarusWidgetChatRetryWithTextBinding;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.t0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(H\u0016J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010,\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageInBoxBottomRetrySlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageBottomRetryBlockState;", "<init>", "()V", "conversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationAbility$delegate", "Lkotlin/Lazy;", "chatTraceAbility", "Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "getChatTraceAbility", "()Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "chatTraceAbility$delegate", "chatListComponent", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListComponent", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListComponent$delegate", "shareAbility", "Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "getShareAbility", "()Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "shareAbility$delegate", "senderAbility", "Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "getSenderAbility", "()Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "senderAbility$delegate", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "", "getContainerId", "transformState", "state", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onBindView", "", "view", "position", "onRetry", "data", "Lcom/larus/im/bean/message/Message;", "beforeRetry", "performRetry", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageInBoxBottomRetrySlotCell extends BaseMessageSlotCell<com.larus.bmhome.chat.cell.slot.c> {
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a implements Function0<va8.a0> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.a0.class));
        }
    }

    public static final class b implements Function0<va8.x> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.x.class));
        }
    }

    public static final class c implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class d implements Function0<va8.t> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.t.class));
        }
    }

    public static final class e implements Function0<va8.s> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.s.class));
        }
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131379968;
    }

    public MessageInBoxBottomRetrySlotCell() {
        this.d = LazyKt.lazy(new a(this));
        this.e = LazyKt.lazy(new b(this));
        this.f = LazyKt.lazy(new c(this));
        this.g = LazyKt.lazy(new d(this));
        this.h = LazyKt.lazy(new e(this));
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        return new com.larus.bmhome.chat.cell.slot.c(r3, r3.e());
    }

    public final void l(Message r5) {
        va8.p r0 = (va8.p) this.f.getValue();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        va8.a0 r3 = (va8.a0) this.d.getValue();
        if (r3 == null) goto L11;
        wc9.e r4 = r3.h();
    L12:
        if (r2 == true) goto L27;
        if (r4 != null) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == false) goto L29;
        va8.p r6 = (va8.p) this.f.getValue();
        if (r6 == null) goto L23;
        r6.O5(false);
    L23:
        va8.s r7 = (va8.s) this.h.getValue();
        if (r7 == null) goto L28;
        r7.h40(r5);
        return;
    L28:
        return;
    L29:
        return;
    L15:
        if (r4.h() == true) goto L17;
    L27:
        return;
    L11:
        r4 = null;
        goto L12
    L5:
        if (r0.W1() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final View onCreateView(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        List r6 = ad8.a.b;
        if (z2.a.enablePreloadChatPageView().b() == false) goto L15;
        o37.c.e.getClass();
        if (o37.c.f("chat_slot_cell_nita") == false) goto L15;
        if ((r4 instanceof Activity) == false) goto L15;
        View r7 = o37.c.e("chat_slot_cell_nita").i(-1, (Activity) r4, true);     // Catch: Exception -> L13
        if ((r7 instanceof ChatRetryWithText) == true) goto L18;
        return new ChatRetryWithText(r4);
    L18:
        return r7;
    L19:
        return new ChatRetryWithText(r4);
    L15:
        return new ChatRetryWithText(r4);
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void onBindView(View r8, ei9.f r9, int r10) {
        com.larus.bmhome.chat.cell.slot.c r11 = (com.larus.bmhome.chat.cell.slot.c) r9;
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r11, "state");
        Integer r0 = null;
        if ((r8 instanceof ChatRetryWithText) == false) goto L5;
        ChatRetryWithText r3 = (ChatRetryWithText) r8;
    L6:
        if (r3 == null) goto L77;
        final Message r6 = r11.b.getMessage();
        if (r6.getMessageStatus() != MessageStatus.MessageStatus_NOTCOMPLIANT) goto L11;
        r3.a();
        return;
    L11:
        boolean r1 = false;
        if (r6.getMessageStatusLocal() != 10) goto L39;
        final String r12 = r6.getLocalMessageId();
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        dd8.b.a r13 = dd8.b.a;
        Intrinsics.checkNotNullParameter(r12, "localMessageId");
        if (dd8.b.a.get(r12) == null) goto L19;
        boolean r14 = true;
    L20:
        boolean r15 = !r14;
        if (dd8.b.a(r12, 0) == false) goto L35;
        LarusWidgetChatRetryWithTextBinding r16 = r3.a;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L25:
        r16.b.setVisibility(0);
        LarusWidgetChatRetryWithTextBinding r17 = r3.a;
        if (r17 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L28:
        r17.c.setVisibility(8);
        LarusWidgetChatRetryWithTextBinding r18 = r3.a;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L31:
        r18.d.setVisibility(8);
        r3.setVisibility(0);
        LarusWidgetChatRetryWithTextBinding r19 = r3.a;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L34:
        r19.a.setOnClickListener(null);
        return;
    L35:
        if (r15 == false) goto L37;
        t0.d(new l(this, r12, r6), 2000);
    L37:
        r3.a();
        return;
    L19:
        r14 = false;
        goto L20
    L39:
        if (ArraysKt.contains(new Integer[]{22, 12, 3}, Integer.valueOf(r6.getMessageStatusLocal())) == false) goto L69;
        va8.a0 r20 = (va8.a0) this.d.getValue();
        if (r20 == null) goto L43;
        r20.Z7(new m(this, r6));
    L43:
        ViewParent r21 = ((ChatRetryWithText) r8).getParent();
        if ((r21 instanceof ViewGroup) == false) goto L46;
        ViewGroup r22 = (ViewGroup) r21;
    L47:
        if (r22 == null) goto L49;
        View r23 = r22.findViewById(2131367862);
    L51:
        if ((r23 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L53;
        com.larus.bmhome.chat.layout.item.i r24 = (com.larus.bmhome.chat.layout.item.i) r23;
    L54:
        va8.t r110 = (va8.t) this.g.getValue();
        if (r110 != null) goto L57;
    L59:
        boolean r111 = com.larus.bmhome.chat.bean.d.J0(r6);
        if (r24 == null) goto L64;
        Lazy r2 = z1.a;
        if (z1.c(r24.getBoxType(), r24.getImmerseBgColor(), r1, r111) == false) goto L64;
        r22.getViewTreeObserver().addOnGlobalLayoutListener(new p(r24, r3, r22, this, r6));
        return;
    L64:
        if (r24 == null) goto L66;
        r0 = r24.getImmerseBgColor();
    L66:
        if (r0 == null) goto L68;
        r3.c(new n(this, r6));
        return;
    L68:
        r3.a();
        return;
    L57:
        if (r110.H1() != true) goto L59;
        r1 = true;
        goto L59
    L53:
        r24 = null;
        goto L54
    L49:
        r23 = null;
        goto L51
    L46:
        r22 = null;
        goto L47
    L69:
        r3.a();
        return;
    L77:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
