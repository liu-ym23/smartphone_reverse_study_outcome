package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import android.widget.ImageView;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chatwindow.view.readstate.ReadStateView;
import com.ss.android.lark.chatwindow.view.widget.DelayDisplayProgressbar;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public static final e6b.c i = null;
    public static final e6b.c j = null;
    public static final e6b.c k = null;
    public final IMMessageKeys$Slots g;
    public final b3b.f h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SendStatus.values().length];
            r0[SendStatus.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SendStatus.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        i = new e6b.c("KEY_READ_STATUS");
        j = new e6b.c("KEY_SENDING_STATUS");
        k = new e6b.c("KEY_SEND_FAIL_STATUS");
    }

    public z(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        IMMessageKeys$Blocks r3 = IMMessageKeys$Blocks.UNKNOWN_CONTENT;
        this.g = IMMessageKeys$Slots.CORNER_1;
        b3b.f r4 = this.d;
        if ((r4 instanceof b3b.o) == true) goto L6;
        r4 = null;
    L6:
        this.h = r4;
    }

    public final void h(com.ss.android.lark.blueprint.q<?> r5) {
        e6b.c r0 = i;
        ReadStateView r1 = r5.f(r0, this.g);
        if ((r1 instanceof ReadStateView) == false) goto L5;
        ReadStateView r2 = r1;
    L6:
        if (r2 == null) goto L8;
        r2.setProgress(0.0f);
    L8:
        com.ss.android.lark.blueprint.k r3 = r5.f(r0, this.g);
        if (r3 == null) goto L13;
        View r4 = r3.getView();
        if (r4 == null) goto L13;
        r4.setOnClickListener(null);
    L13:
        com.ss.android.lark.blueprint.k r6 = r5.f(r0, this.g);
        if (r6 == null) goto L18;
        View r7 = r6.getView();
        if (r7 == null) goto L18;
        r7.setOnLongClickListener(null);
    L18:
        g(r5, r0, this.g);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void i(com.ss.android.lark.blueprint.q<?> r5) {
        e6b.c r0 = j;
        com.ss.android.lark.blueprint.k r1 = r5.f(r0, this.g);
        DelayDisplayProgressbar r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.getView();
    L7:
        if ((r3 instanceof DelayDisplayProgressbar) == false) goto L9;
        r2 = (DelayDisplayProgressbar) r3;
    L9:
        if (r2 == null) goto L11;
        r2.setTag(2131368776, Boolean.FALSE);
        r2.removeCallbacks(r2.a);
        r2.setVisibility(8);
    L11:
        g(r5, r0, this.g);
        return;
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v23, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v20, types: [android.view.View$OnClickListener] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.view.View, com.ss.android.lark.chatwindow.view.readstate.ReadStateView] */
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r11, com.ss.android.lark.blueprint.q<y6b.a<?>> r12, y6b.a<?> r13) {
        Intrinsics.checkNotNullParameter(r11, "cell");
        Intrinsics.checkNotNullParameter(r12, "layout");
        Intrinsics.checkNotNullParameter(r13, Keys.API_RETURN_KEY_DATA);
        ?? r1 = 0;
        if ((r13 instanceof y6b.c) == false) goto L5;
        y6b.c r0 = (y6b.c) r13;
    L6:
        boolean r2 = true;
        int r3 = 0;
        if (r0 == null) goto L56;
        y6b.c r4 = (y6b.c) r13;
        if (r4.isPreMessage() == false) goto L16;
        SendStatus r5 = r4.s;
        if (r5 != SendStatus.SENDING) goto L14;
    L15:
        boolean r6 = true;
    L18:
        if (r0.i == true) goto L20;
    L37:
        boolean r7 = false;
    L38:
        if (r7 == true) goto L40;
        h(r12);
        goto L56
    L40:
        Chat r8 = this.c.getChat();
        if (r8 == null) goto L56;
        int r9 = r0.P0 - 1;
        int r10 = r0.V0;
        int r14 = r9 + r10;
        Log.i("MessageStatusBlock", r0.c + ", unread:" + r14 + '/' + r9 + '/' + r10);
        if (this.c.B8() == false) goto L46;
        h(r12);
        goto L56
    L46:
        com.ss.android.lark.blueprint.k r15 = r12.c(i, this.g, new MessageStatusBlock$requireReadStatusView$1(this));
        if (r14 <= 0) goto L49;
        ((ReadStateView) r15.getView()).setProgress((r9 * 1.0f) / r14);
    L52:
        ((ReadStateView) r15.getView()).setTag(Boolean.FALSE);
        b0 r16 = new b0(r0, r8, this);
        ?? r17 = (ReadStateView) r15.getView();
        if (this.c.isGroup() == false) goto L55;
        r1 = r16;
    L55:
        r17.setOnClickListener(r1);
        ((ReadStateView) r15.getView()).setOnLongClickListener(new a0(this, r11, r0));
        goto L56
    L49:
        if (r14 != 0) goto L51;
        ((ReadStateView) r15.getView()).setProgress(1.0f);
        goto L52
    L51:
        h(r12);
        goto L52
    L20:
        if (this.c.X() == true) goto L37;
        if (this.c.B8() == true) goto L37;
        if (this.c.h() == true) goto L37;
        if (this.c.o() == true) goto L37;
        if (r0.D == MessageDLPState.BLOCK) goto L37;
        if (r0.z == true) goto L37;
        if (this.c.isAIChat() == true) goto L37;
        if (this.c.e0() == true) goto L37;
        if (r6 == true) goto L37;
        r7 = true;
        goto L38
    L14:
        if (r5 == SendStatus.FAIL) goto L15;
    L16:
        r6 = false;
    L56:
        boolean r18 = this.c.s8();
        e6b.c r19 = k;
        if (r18 == false) goto L59;
    L103:
        g(r12, r19, this.g);
        i(r12);
        return;
    L59:
        if (this.c.o() == true) goto L103;
        if (r13.h() == true) goto L63;
    L65:
        boolean r110 = false;
    L66:
        if (r110 == true) goto L103;
        Object r111 = r13.b();
        if (r13.G() != SendStatus.SUCCESS) goto L71;
        boolean r20 = true;
    L73:
        if (r13.isPreMessage() == false) goto L102;
        if (r20 == true) goto L102;
        int r21 = b.a[r13.G().ordinal()];
        if (r21 != 1) goto L78;
        h(r12);
        g(r12, r19, this.g);
        Message.Type r22 = r13.getType();
        if (r22 == Message.Type.MEDIA) goto L84;
        boolean r23 = true;
    L86:
        if ((r111 instanceof AudioContentVO) == false) goto L93;
        if (((AudioContentVO) r111).s != AudioContent.AudioState.RECORDING) goto L91;
        r2 = false;
    L91:
        r23 = r23 & r2;
    L93:
        if (r22 != Message.Type.IMAGE) goto L95;
        r23 = false;
    L95:
        if (r23 == false) goto L101;
        com.ss.android.lark.blueprint.k r112 = r12.c(j, this.g, new MessageStatusBlock$requireSendingStatusView$1(this));
        ((DelayDisplayProgressbar) r112.getView()).setVisibility(0);
        DelayDisplayProgressbar r113 = (DelayDisplayProgressbar) r112.getView();
        if ((System.currentTimeMillis() - (r13.getCreateTime() * ((long) 1000))) > 2000) goto L100;
        r3 = h7b.l.c();
    L100:
        r113.setTag(2131368776, Boolean.TRUE);
        r113.setVisibility(4);
        r113.postDelayed(r113.a, r3);
        return;
    L101:
        i(r12);
        return;
    L84:
        r23 = false;
        goto L86
    L78:
        if (r21 != 2) goto L109;
        h(r12);
        i(r12);
        g(r12, r19, this.g);
        com.ss.android.lark.blueprint.k r114 = r12.c(r19, this.g, new MessageStatusBlock$requireSendFailStatusView$1(this));
        ((ImageView) r114.getView()).setVisibility(0);
        ((ImageView) r114.getView()).setOnClickListener(new c0(this, r13));
        return;
    L109:
        return;
    L102:
        i(r12);
        g(r12, r19, this.g);
        return;
    L71:
        r20 = false;
        goto L73
    L63:
        if (MessageDLPState.BLOCK != r13.t()) goto L65;
        r110 = true;
        goto L66
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
