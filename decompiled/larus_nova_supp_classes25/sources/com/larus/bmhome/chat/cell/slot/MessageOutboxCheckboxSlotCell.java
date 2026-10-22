package com.larus.bmhome.chat.cell.slot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0019\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0016J \u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0007H\u0016J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010(\u001a\u0004\u0018\u00010\u001cH\u0002J(\u0010-\u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020/2\u0006\u0010*\u001a\u00020\u0007H\u0002J(\u00100\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020/2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u00064"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageOutboxCheckboxSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageCheckboxBlockState;", "Lcom/larus/bmhome/chat/cell/view/IMessageCheckBoxSlotCell;", "<init>", "()V", "SINGLE_LINE_MAX_HEIGHT", "", "CHECK_BOX_WEITH", "CHECK_BOX_HEIGHT", "checkBox", "Lcom/larus/bmhome/chat/layout/widget/ChatCheckBox;", "verticalMargin", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "Lkotlin/Lazy;", "messageShareAbility", "Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "getMessageShareAbility", "()Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "messageShareAbility$delegate", "checkBoxClickListener", "com/larus/bmhome/chat/cell/slot/MessageOutboxCheckboxSlotCell$checkBoxClickListener$1", "Lcom/larus/bmhome/chat/cell/slot/MessageOutboxCheckboxSlotCell$checkBoxClickListener$1;", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "onSlotViewCreated", "", "slotCellView", "getContainerId", "transformState", "data", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onBindView", "view", "state", "position", "getGestureInterceptor", "Lcom/larus/bmhome/chat/cell/view/GestureInterceptor;", "setupCheckBox", "Lcom/larus/im/bean/message/Message;", "Lcom/larus/bmhome/chat/cell/utils/CheckBoxClickListener;", "setupCheckBoxInShareMode", "initCheckBoxPos", "adjustTopMargin", "cardView", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageOutboxCheckboxSlotCell extends BaseMessageSlotCell<e> implements ed8.f {
    public final int d;
    public final int e;
    public final int f;
    public ChatCheckBox g;
    public int h;
    public final Lazy i;
    public final Lazy j;
    public final a k;

    public static final class a implements dd8.a {
        public final /* synthetic */ MessageOutboxCheckboxSlotCell a;

        public a(MessageOutboxCheckboxSlotCell r1) {
            this.a = r1;
        }

        @Override // dd8.a
        public final void a(boolean r8, int r9) {
            va8.t r0 = this.a.l();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.H1() != true) goto L7;
        L8:
            if (r1 == false) goto L17;
            va8.t r2 = this.a.l();
            if (r2 == null) goto L18;
            Integer r3 = Integer.valueOf(r9);
            va8.p r10 = (va8.p) this.a.i.getValue();
            if (r10 == null) goto L14;
            List r11 = r10.getCurrentList();
        L15:
            r2.Pj(r8, r3, r11, false, false);
            return;
        L14:
            r11 = null;
            goto L15
        L18:
            return;
        L17:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class b implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
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

    public static final class c implements Function0<va8.t> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131379991;
    }

    public final va8.t l() {
        return (va8.t) this.j.getValue();
    }

    public MessageOutboxCheckboxSlotCell() {
        this.d = i5.k0();
        this.e = i5.A();
        this.f = i5.A();
        this.h = i5.k();
        this.i = LazyKt.lazy(new b(this));
        this.j = LazyKt.lazy(new c(this));
        this.k = new a(this);
    }

    @Override // ed8.f
    public final void b(View r6) {
        Intrinsics.checkNotNullParameter(r6, "cardView");
        va8.t r0 = l();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L9;
        return;
    L9:
        ChatCheckBox r2 = this.g;
        if (r2 == null) goto L27;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L14;
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
    L15:
        if (r4 != null) goto L17;
        return;
    L17:
        if (r6.getTop() < 0) goto L20;
        int r7 = this.h;
    L24:
        if (((ViewGroup.MarginLayoutParams) r4).topMargin == r7) goto L29;
        ((ViewGroup.MarginLayoutParams) r4).topMargin = r7;
        r2.setLayoutParams(r4);
        return;
    L29:
        return;
    L20:
        if (r6.getHeight() <= (((this.h * 2) + this.f) - r6.getTop())) goto L22;
        r7 = this.h - r6.getTop();
        goto L24
    L22:
        r7 = (r6.getHeight() - this.h) - this.f;
        goto L24
    L14:
        r4 = null;
        goto L15
    L27:
        return;
    L5:
        if (r0.H1() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void h(View r3) {
        Intrinsics.checkNotNullParameter(r3, "slotCellView");
        ConstraintLayout.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r5 = r4;
    L6:
        if (r5 == null) goto L9;
        ((ViewGroup.MarginLayoutParams) r5).width = this.e;
        ((ViewGroup.MarginLayoutParams) r5).height = this.f;
        r5.setMarginStart(i5.h());
        r5.setMarginEnd(i5.h());
        r5.topToTop = 0;
        r5.bottomToBottom = -1;
        r5.startToStart = 0;
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        return new e(r3, r3.e());
    }

    public final View onCreateView(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        List r6 = ad8.a.b;
        if (z2.a.enablePreloadChatPageView().b() == false) goto L14;
        o37.c.e.getClass();
        if (o37.c.f("chat_slot_cell_nita") == false) goto L14;
        if ((r4 instanceof Activity) == false) goto L14;
        ChatCheckBox r7 = o37.c.e("chat_slot_cell_nita").i(-2, (Activity) r4, true);     // Catch: Exception -> L13
        if ((r7 instanceof ChatCheckBox) == true) goto L15;
        r7 = new ChatCheckBox(r4);     // Catch: Exception -> L13
    L15:
        this.g = r7;
        return r7;
    L13:
        r7 = new ChatCheckBox(r4);
    L14:
        r7 = new ChatCheckBox(r4);
        goto L15
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void onBindView(View r10, ei9.f r11, final int r12) {
        e r13 = (e) r11;
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r13, "state");
        super.onBindView(r10, r13, r12);
        boolean r0 = r10 instanceof ChatCheckBox;
        com.larus.bmhome.chat.cell.slot.a r1 = null;
        if (r0 == false) goto L5;
        ChatCheckBox r2 = (ChatCheckBox) r10;
    L6:
        if (r2 == null) goto L31;
        ed8.g r3 = this.c;
        if ((r3 instanceof ed8.g) == false) goto L11;
        ed8.g r4 = r3;
    L12:
        if (r4 == null) goto L20;
        if (r0 == false) goto L15;
        ChatCheckBox r14 = (ChatCheckBox) r10;
    L16:
        if (r14 == null) goto L19;
        r1 = new com.larus.bmhome.chat.cell.slot.a(r14);
    L19:
        r4.setGestureInterceptor(r1);
        goto L20
    L15:
        r14 = null;
    L20:
        final Message r6 = r13.a.getMessage();
        final a r7 = this.k;
        va8.t r15 = l();
        if (r15 == null) goto L25;
        boolean r5 = true;
        if (r15.H1() != true) goto L25;
    L26:
        if (r5 == false) goto L28;
        final ChatCheckBox r8 = r2;
        r2.post(new c0(this, r8, r6, r7, r12));
        return;
    L28:
        r2.setInterceptTouchEvent(false);
        r2.a();
        return;
    L25:
        r5 = false;
        goto L26
    L11:
        r4 = null;
        goto L12
    L31:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
