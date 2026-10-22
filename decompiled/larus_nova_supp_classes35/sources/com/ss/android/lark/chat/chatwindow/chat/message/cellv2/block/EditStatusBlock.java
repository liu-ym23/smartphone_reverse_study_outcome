package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chatbase.view.ChatMessageEditStatusView;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class EditStatusBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final b3b.f g;
    public final IMMessageKeys$Blocks h;

    public static final class a implements com.ss.android.lark.blueprint.k<ChatMessageEditStatusView>, com.ss.android.lark.blueprint.t {
        public final ChatMessageEditStatusView a;
        public final int b;
        public final C0041a c;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.EditStatusBlock$a$a, reason: collision with other inner class name */
        public static final class C0041a implements StackSlot.b {
            public final StackSlot.b.a b;

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void a() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void f() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void g() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final StackSlot.b.a b() {
                return this.b;
            }

            public C0041a(a r2) {
                this.b = new StackSlot.b.a(r2.b);
            }
        }

        public final com.ss.android.lark.blueprint.s a() {
            return this.c;
        }

        public final View getView() {
            return this.a;
        }

        public a(ChatMessageEditStatusView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = UIUtils.dp2px(r2.getContext(), 4.0f);
            this.c = new C0041a(this);
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.h;
    }

    public EditStatusBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        b3b.f r3 = this.d;
        if ((r3 instanceof b3b.n) == true) goto L6;
        r3 = null;
    L6:
        this.g = r3;
        this.h = IMMessageKeys$Blocks.EDIT_STATUS;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.h, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r4, com.ss.android.lark.blueprint.q<y6b.a<?>> r5, final y6b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "layout");
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        if (r6.u() != null) goto L5;
    L27:
        g(r5, this.h, IMMessageKeys$Slots.BOTTOM);
        return;
    L5:
        if (Intrinsics.areEqual(this.c.D8(), r6.getId()) == true) goto L27;
        if (r6.j() == true) goto L27;
        MessageEditInfo r7 = r6.u();
        if (r7 == null) goto L12;
        MessageEditInfo.EditStatus r8 = r7.getEditStatus();
    L14:
        if (r8 != MessageEditInfo.EditStatus.None) goto L16;
    L25:
        g(r5, this.h, IMMessageKeys$Slots.BOTTOM);
        return;
    L16:
        if (r8 == MessageEditInfo.EditStatus.NoRequest) goto L25;
        ChatMessageEditStatusView r9 = ((a) r5.c(this.h, IMMessageKeys$Slots.BOTTOM, new EditStatusBlock$update$blockView$1(this))).a;
        if (r8 != MessageEditInfo.EditStatus.Failed) goto L22;
        r9.a(new AnonymousClass1(this, r6));
        return;
    L22:
        if (r8 != MessageEditInfo.EditStatus.Waiting) goto L30;
        r9.b();
        return;
    L30:
        return;
    L12:
        r8 = null;
        goto L14
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
