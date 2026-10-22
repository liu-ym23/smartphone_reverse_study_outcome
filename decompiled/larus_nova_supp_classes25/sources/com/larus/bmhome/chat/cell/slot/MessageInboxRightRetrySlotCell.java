package com.larus.bmhome.chat.cell.slot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ChatRetry;
import com.larus.bmhome.utils.z1;
import com.larus.chat.common.databinding.LarusWidgetChatRetryBinding;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.t0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(H\u0016J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010,\u001a\u00020$H\u0016J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageInboxRightRetrySlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageRetryBlockState;", "<init>", "()V", "conversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationAbility$delegate", "Lkotlin/Lazy;", "chatTraceAbility", "Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "getChatTraceAbility", "()Lcom/larus/bmhome/ability/IChatTraceCoreAbility;", "chatTraceAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "shareAbility", "Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "getShareAbility", "()Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "shareAbility$delegate", "chatSenderAbility", "Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "getChatSenderAbility", "()Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "chatSenderAbility$delegate", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "", "getContainerId", "transformState", "state", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onBindView", "", "view", "position", "onRetry", "data", "Lcom/larus/im/bean/message/Message;", "beforeRetry", "performRetry", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class MessageInboxRightRetrySlotCell extends BaseMessageSlotCell<g0> {
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ com.larus.bmhome.chat.layout.item.i a;
        public final /* synthetic */ ChatRetry b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ MessageInboxRightRetrySlotCell d;
        public final /* synthetic */ Message e;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.a.getWidth() < this.a.getMaxWidth()) goto L5;
            this.b.b();
        L6:
            this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L5:
            ChatRetry r0 = this.b;
            final MessageInboxRightRetrySlotCell r1 = this.d;
            final Message r2 = this.e;
            r0.d(new z(r1, r2));
            goto L6
        }

        public a(com.larus.bmhome.chat.layout.item.i r1, ChatRetry r2, ViewGroup r3, MessageInboxRightRetrySlotCell r4, Message r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class b implements Function0<va8.a0> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
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

    public static final class c implements Function0<va8.x> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<va8.t> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    public static final class f implements Function0<va8.s> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
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
    public int f() {
        return 2131380010;
    }

    public MessageInboxRightRetrySlotCell() {
        this.d = LazyKt.lazy(new b(this));
        this.e = LazyKt.lazy(new c(this));
        this.f = LazyKt.lazy(new d(this));
        this.g = LazyKt.lazy(new e(this));
        this.h = LazyKt.lazy(new f(this));
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        return new g0(r3, r3.e());
    }

    public final void m(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
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
        View r7 = o37.c.e("chat_slot_cell_nita").i(-3, (Activity) r4, true);     // Catch: Exception -> L13
        if ((r7 instanceof ChatRetry) == true) goto L18;
        return new ChatRetry(r4);
    L18:
        return r7;
    L19:
        return new ChatRetry(r4);
    L15:
        return new ChatRetry(r4);
    }

    public void l(View r8, g0 r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "state");
        com.larus.bmhome.chat.layout.item.i r0 = null;
        if ((r8 instanceof ChatRetry) == false) goto L5;
        ChatRetry r3 = (ChatRetry) r8;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        final Message r6 = r9.b.getMessage();
        boolean r1 = true;
        if (r6.getMessageStatusLocal() != 10) goto L44;
        final String r11 = r6.getLocalMessageId();
        if (r11 != null) goto L13;
        r11 = "";
    L13:
        dd8.b.a r12 = dd8.b.a;
        Intrinsics.checkNotNullParameter(r11, "localMessageId");
        if (dd8.b.a.get(r11) == null) goto L16;
        boolean r13 = true;
    L17:
        boolean r14 = !r13;
        Map r15 = r6.getExt();
        if (r15 == null) goto L22;
        String r16 = (String) r15.get("delay_request_interval_ms");
        if (r16 == null) goto L22;
        int r17 = l3.e(r16, 0);
    L24:
        if (dd8.b.a(r11, r17) == false) goto L40;
        LarusWidgetChatRetryBinding r18 = r3.a;
        if (r18 == null) goto L30;
        ProgressBar r19 = r18.b;
        if (r19 == null) goto L30;
        r19.setVisibility(0);
    L30:
        LarusWidgetChatRetryBinding r20 = r3.a;
        if (r20 == null) goto L35;
        ImageView r21 = r20.c;
        if (r21 == null) goto L35;
        r21.setVisibility(8);
    L35:
        r3.setVisibility(0);
        LarusWidgetChatRetryBinding r22 = r3.a;
        if (r22 == null) goto L72;
        ImageView r23 = r22.c;
        if (r23 == null) goto L73;
        r23.setOnClickListener(null);
        return;
    L73:
        return;
    L72:
        return;
    L40:
        if (r14 == false) goto L42;
        t0.d(new w(this, r11, r6), 2000);
    L42:
        r3.b();
        return;
    L22:
        r17 = 0;
        goto L24
    L16:
        r13 = false;
        goto L17
    L44:
        if (ArraysKt.contains(new Integer[]{22, 12, 3}, Integer.valueOf(r6.getMessageStatusLocal())) == false) goto L70;
        va8.a0 r24 = (va8.a0) this.d.getValue();
        if (r24 == null) goto L48;
        r24.Z7(new x(this, r6));
    L48:
        ViewParent r25 = ((ChatRetry) r8).getParent();
        if ((r25 instanceof ViewGroup) == false) goto L51;
        ViewGroup r26 = (ViewGroup) r25;
    L52:
        if (r26 == null) goto L54;
        View r27 = r26.findViewById(2131367862);
    L56:
        if ((r27 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L58;
        r0 = (com.larus.bmhome.chat.layout.item.i) r27;
    L58:
        va8.t r28 = (va8.t) this.g.getValue();
        if (r28 != null) goto L61;
    L63:
        r1 = false;
    L64:
        boolean r29 = com.larus.bmhome.chat.bean.d.J0(r6);
        if (r0 == null) goto L69;
        Lazy r110 = z1.a;
        if (z1.c(r0.getBoxType(), r0.getImmerseBgColor(), r1, r29) == false) goto L69;
        r26.getViewTreeObserver().addOnGlobalLayoutListener(new a(r0, r3, r26, this, r6));
        return;
    L69:
        r3.d(new y(this, r6));
        return;
    L61:
        if (r28.H1() != true) goto L63;
    L54:
        r27 = null;
        goto L56
    L51:
        r26 = null;
        goto L52
    L70:
        r3.b();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public /* bridge */ /* synthetic */ void onBindView(View r1, ei9.f r2, int r3) {
        l(r1, (g0) r2, r3);
    }
}
