package com.larus.bmhome.chat.cell.slot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
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
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\"J\u000e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020(J\b\u0010-\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\u0010\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0007H\u0016J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00104\u001a\u0004\u0018\u00010\u000eH\u0002J(\u00109\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020:2\u0006\u0010\u001a\u001a\u00020;2\u0006\u00106\u001a\u00020\u0007H\u0002J(\u0010<\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020:2\u0006\u0010\u001a\u001a\u00020;2\u0006\u00106\u001a\u00020\u0007H\u0002J\u0010\u0010=\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\"H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageInStubInboxCheckboxSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageCheckboxBlockState;", "Lcom/larus/bmhome/chat/cell/view/IMessageStubCheckBoxSlotCell;", "<init>", "()V", "SINGLE_LINE_MAX_HEIGHT", "", "CHECK_BOX_WEITH", "CHECK_BOX_HEIGHT", "checkBox", "Lcom/larus/bmhome/chat/layout/widget/ChatCheckBox;", "verticalMargin", "slotCellView", "Landroid/view/View;", "messageShareAbility", "Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "getMessageShareAbility", "()Lcom/larus/bmhome/ability/IChatShareCoreAbility;", "messageShareAbility$delegate", "Lkotlin/Lazy;", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "checkBoxClickListener", "com/larus/bmhome/chat/cell/slot/MessageInStubInboxCheckboxSlotCell$checkBoxClickListener$1", "Lcom/larus/bmhome/chat/cell/slot/MessageInStubInboxCheckboxSlotCell$checkBoxClickListener$1;", "onCreateView", "context", "Landroid/content/Context;", "viewType", "needShowCheckBox", "", "getNeedShowCheckBox", "()Z", "setNeedShowCheckBox", "(Z)V", "attachCompositeType", "Lcom/larus/bmhome/chat/layout/item/CompositeBoxType;", "updateCheckBoxNeedShow", "", "setUpAttachAttachBoxType", "boxType", "updateCheckBoxLayoutParams", "onSlotViewCreated", "getContainerId", "transformState", "data", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "onBindView", "view", "state", "position", "getGestureInterceptor", "Lcom/larus/bmhome/chat/cell/view/GestureInterceptor;", "setupCheckBox", "Lcom/larus/im/bean/message/Message;", "Lcom/larus/bmhome/chat/cell/utils/CheckBoxClickListener;", "setupCheckBoxInShareMode", "initCheckBoxPos", "adjustStubCheckVisible", "visible", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageInStubInboxCheckboxSlotCell extends BaseMessageSlotCell<e> {
    public final int d;
    public final int e;
    public final int f;
    public ChatCheckBox g;
    public View h;
    public final Lazy i;
    public final Lazy j;
    public final a k;
    public boolean l;
    public CompositeBoxType m;

    public static final class a implements dd8.a {
        public final /* synthetic */ MessageInStubInboxCheckboxSlotCell a;

        public a(MessageInStubInboxCheckboxSlotCell r1) {
            this.a = r1;
        }

        @Override // dd8.a
        public final void a(boolean r8, int r9) {
            va8.t r0 = (va8.t) this.a.i.getValue();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.H1() != true) goto L7;
        L8:
            if (r1 == false) goto L17;
            va8.t r2 = (va8.t) this.a.i.getValue();
            if (r2 == null) goto L18;
            Integer r3 = Integer.valueOf(r9);
            va8.p r10 = (va8.p) this.a.j.getValue();
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

    public static final class b implements Function0<va8.t> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
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

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131379991;
    }

    public final void l() {
        View r0 = this.h;
        ConstraintLayout.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        r1 = (ConstraintLayout.LayoutParams) r2;
    L9:
        if (r1 == null) goto L24;
        int r3 = this.e;
        ((ViewGroup.MarginLayoutParams) r1).width = r3;
        ((ViewGroup.MarginLayoutParams) r1).height = r3;
        ((ViewGroup.MarginLayoutParams) r1).leftMargin = i5.h();
        ((ViewGroup.MarginLayoutParams) r1).rightMargin = i5.h();
        r1.topToTop = 0;
        r1.bottomToBottom = -1;
        if (this.l == false) goto L19;
        ChatCheckBox r4 = this.g;
        if (r4 == null) goto L16;
        r4.setAlpha(1.0f);
    L16:
        if (this.m != CompositeBoxType.CompositeMiddleBox) goto L18;
        ((ViewGroup.MarginLayoutParams) r1).topMargin = i5.b();
        return;
    L18:
        ((ViewGroup.MarginLayoutParams) r1).topMargin = i5.k();
        return;
    L19:
        ChatCheckBox r5 = this.g;
        if (r5 == null) goto L22;
        r5.setAlpha(0.0f);
    L22:
        ((ViewGroup.MarginLayoutParams) r1).height = i5.b();
        ((ViewGroup.MarginLayoutParams) r1).topMargin = 0;
        return;
    L24:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public MessageInStubInboxCheckboxSlotCell() {
        this.d = i5.k0();
        this.e = i5.A();
        this.f = i5.A();
        i5.k();
        this.i = LazyKt.lazy(new b(this));
        this.j = LazyKt.lazy(new c(this));
        this.k = new a(this);
        this.l = true;
        this.m = CompositeBoxType.CompositeBottomBox;
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "slotCellView");
        this.h = r2;
        l();
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final ei9.f k(xc8.b r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        return new e(r3, r3.e());
    }

    public final void m(boolean r1) {
        this.l = r1;
        l();
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
        va8.t r15 = (va8.t) this.i.getValue();
        if (r15 == null) goto L25;
        boolean r5 = true;
        if (r15.H1() != true) goto L25;
    L26:
        if (r5 == false) goto L28;
        final ChatCheckBox r8 = r2;
        r2.post(new q(this, r8, r6, r7, r12));
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
