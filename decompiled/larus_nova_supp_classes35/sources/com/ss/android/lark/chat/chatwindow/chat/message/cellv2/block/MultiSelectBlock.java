package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MultiSelectBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public MultiSelectBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.MULTI_SELECT;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.SELECT);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r5, com.ss.android.lark.blueprint.q<y6b.a<?>> r6, y6b.a<?> r7) {
        Intrinsics.checkNotNullParameter(r5, "cell");
        Intrinsics.checkNotNullParameter(r6, "layout");
        Intrinsics.checkNotNullParameter(r7, Keys.API_RETURN_KEY_DATA);
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f r0 = null;
        int r1 = 0;
        if (this.c.s8() == true) goto L16;
        g(r6, this.g, IMMessageKeys$Slots.SELECT);
        boolean r8 = r6 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f;
        if (r8 == false) goto L7;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f r9 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) r6;
    L8:
        if (r9 == null) goto L10;
        r9.setSelected(false);
    L10:
        if (r8 == false) goto L12;
        r0 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) r6;
    L12:
        if (r0 == null) goto L47;
        r0.d(false);
        return;
    L47:
        return;
    L7:
        r9 = null;
        goto L8
    L16:
        if ((r7 instanceof y6b.c) == false) goto L18;
        y6b.c r10 = (y6b.c) r7;
    L19:
        if (r10 != null) goto L22;
        return;
    L22:
        if ((r6 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) == false) goto L24;
        r0 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) r6;
    L24:
        if (r0 != null) goto L26;
        return;
    L26:
        com.ss.android.lark.blueprint.k r11 = r6.c(this.g, IMMessageKeys$Slots.SELECT, new MultiSelectBlock$update$blockView$1(this));
        com.ss.android.lark.biz.im.api.message.params.p r12 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.p.class);
        if (r12 == null) goto L31;
        Integer r13 = r12.a;
        if (r13 == null) goto L31;
        r11.getView().setUncheckedBorderColor(UIUtils.getColor(getContext(), r13.intValue()));
    L31:
        boolean r14 = lpc.a.d(r10);
        if (this.c.s8() == true) goto L34;
        r0.setSelected(false);
        if (this.c.isClickable() == false) goto L41;
        r0.d(false);
    L41:
        UDCheckBox r15 = r11.getView();
        if (this.c.y8(r10) == true) goto L45;
        r1 = 4;
    L45:
        r15.setVisibility(r1);
        return;
    L34:
        if (r14 == false) goto L36;
        r11.getView().setEnabled(false);
        r0.setSelected(false);
    L37:
        r0.d(true);
        goto L41
    L36:
        r11.getView().setEnabled(true);
        r11.getView().setChecked(this.c.E8(r10));
        r0.setSelected(this.c.E8(r10));
        goto L37
    L18:
        r10 = null;
        goto L19
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
