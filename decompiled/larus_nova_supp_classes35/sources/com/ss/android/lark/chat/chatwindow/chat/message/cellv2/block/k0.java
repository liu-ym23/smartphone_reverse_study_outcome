package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTnsInfo;
import com.ss.android.lark.chat.entity.chat.ChatTnsOpKind;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k0 implements TextClickListenerProviderV2.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ TextContentBlock b;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> c;

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2.a
    public final boolean a(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        e6b.b r0 = this.c;
        if ((r0 instanceof e6b.b) == false) goto L5;
        e6b.b r1 = r0;
    L6:
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.e(this.b, r3);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2.a
    public final void b(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r7) {
        Intrinsics.checkNotNullParameter(r7, Keys.API_RETURN_KEY_DATA);
        e6b.b r1 = null;
        b3b.f r2 = null;
        if (this.a == true) goto L5;
    L43:
        com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r0 = this.c;
        if ((r0 instanceof e6b.b) == false) goto L46;
        r1 = (e6b.b) r0;
    L46:
        if (r1 == null) goto L50;
        r1.j(this.b, r7);
        return;
    L50:
        return;
    L5:
        if ((r7 instanceof y6b.c) == false) goto L43;
        Chat r3 = this.b.g().getChat();
        if (r3 == null) goto L11;
        ChatTnsInfo r4 = r3.getChatTnsInfo();
        if (r4 == null) goto L11;
        ChatTnsOpKind r5 = r4.getTnsOpKind();
    L12:
        boolean r6 = true;
        if (r5 != ChatTnsOpKind.TNS_OP_BANNED) goto L15;
        boolean r8 = true;
    L16:
        y6b.c r9 = (y6b.c) r7;
        if (r9.K2 == true) goto L19;
    L22:
        r6 = false;
    L23:
        if (r6 == false) goto L43;
        xza.a r10 = this.c;
        if ((r10 instanceof xza.a) == false) goto L27;
        xza.a r11 = r10;
    L28:
        if (r11 == null) goto L32;
        BlueprintCellViewHolder r12 = r11.i();
        if (r12 == null) goto L32;
        Integer r13 = Integer.valueOf(r12.getLayoutPosition());
    L33:
        if (r13 == null) goto L43;
        TextContentBlock r14 = this.b;
        r13.intValue();
        b3b.f r15 = r14.f();
        if ((r15 instanceof b3b.q) == false) goto L37;
        r2 = r15;
    L37:
        if (r2 == null) goto L39;
        r2.t(r9.c, r13.intValue());
    L39:
        b3b.f r16 = r14.f();
        if (r16 == null) goto L49;
        r16.t(r9.c, r13.intValue());
        return;
    L49:
        return;
    L32:
        r13 = null;
        goto L33
    L27:
        r11 = null;
        goto L28
    L19:
        if (r9.i == false) goto L22;
        if (r8 == true) goto L22;
    L15:
        r8 = false;
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2.a
    public final void c(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        e6b.b r0 = this.c;
        if ((r0 instanceof e6b.b) == false) goto L5;
        e6b.b r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.f(this.b, r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public k0(boolean r1, TextContentBlock r2, com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
