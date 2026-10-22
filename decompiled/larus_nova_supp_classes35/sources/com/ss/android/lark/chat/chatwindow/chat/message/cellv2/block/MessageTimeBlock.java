package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageTimeBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public final int h;
    public final int i;

    public static final class a implements com.ss.android.lark.blueprint.k<AppCompatTextView>, com.ss.android.lark.blueprint.t {
        public final AppCompatTextView a;
        public final C0042a b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessageTimeBlock$a$a, reason: collision with other inner class name */
        public static final class C0042a implements StackSlot.b {
            public final /* synthetic */ a b;

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
                return new StackSlot.b.a(UIUtils.dp2px(this.b.a.getContext(), 4.0f));
            }

            public C0042a(a r1) {
                this.b = r1;
            }
        }

        public final com.ss.android.lark.blueprint.s a() {
            return this.b;
        }

        public final View getView() {
            return this.a;
        }

        public a(AppCompatTextView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = new C0042a(this);
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public MessageTimeBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.TIME;
        this.h = UIUtils.getColor(getContext(), 2131106620);
        this.i = com.ss.android.lark.chat.utils.p.b(getContext());
    }

    public final String h(long r13) {
        c7c.a r11 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r11.b(DisplayPattern.RELATIVE);
        r11.c(LengthType.LONG);
        ChatCoreModule.a().getTimeFormatDependency().a();
        r11.h = false;
        r11.d(TimePreciseness.SECOND);
        r11.j = true;
        return c7c.b.c(UIHelper.getContext(), new Date(r13), r11);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r6, com.ss.android.lark.blueprint.q<y6b.a<?>> r7, y6b.a<?> r8) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "layout");
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        if ((r8 instanceof y6b.c) == false) goto L5;
        y6b.c r9 = (y6b.c) r8;
    L6:
        if (r9 == null) goto L8;
        boolean r10 = r9.P2;
    L9:
        if (r10 == true) goto L12;
        g(r7, this.g, IMMessageKeys$Slots.BOTTOM);
        return;
    L12:
        AppCompatTextView r11 = ((a) r7.c(this.g, IMMessageKeys$Slots.BOTTOM, new MessageTimeBlock$update$blockView$1(this))).a;
        zz7.a.c(r11, 12);
        ChatThemeInfo r12 = this.c.r8();
        if (r12 != null) goto L15;
    L21:
        int r13 = this.h;
    L22:
        r11.setTextColor(r13);
        y6b.c r14 = (y6b.c) r8;
        StringBuilder r15 = new StringBuilder(h(r14.m * ((long) 1000)));
        MessageEditInfo r16 = r14.C;
        if (r16 != null) goto L25;
    L29:
        r11.setText(r15);
        return;
    L25:
        if (r16.isEdited() == false) goto L29;
        if (r16.getLastEditTime() <= 0) goto L29;
        r15.append(UIHelper.mustacheFormat(2131891077, "Time", h(r16.getLastEditTime())));
        goto L29
    L15:
        if (com.ss.android.lark.chat.utils.p.g(r12.getComponentScene()) == false) goto L21;
        if (com.ss.android.lark.chat.utils.p.f(r12.getComponentScene()) == false) goto L21;
        if ((!h18.f.a(getContext())) == false) goto L21;
        r13 = this.i;
        goto L22
    L8:
        r10 = false;
        goto L9
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
