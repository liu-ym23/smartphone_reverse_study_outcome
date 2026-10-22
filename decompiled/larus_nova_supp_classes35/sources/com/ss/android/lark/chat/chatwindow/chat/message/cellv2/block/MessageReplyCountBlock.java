package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageReplyCountBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public final Lazy h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MessageReplyCountBlock a;
        public final /* synthetic */ y6b.c<?> b;

        public b(MessageReplyCountBlock r1, y6b.c<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            b3b.f r4 = (b3b.f) this.a.h.getValue();
            if (r4 == null) goto L6;
            r4.z(this.b.c, z5c.u0.c.b);
            return;
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public MessageReplyCountBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.REPLY_COUNT;
        this.h = LazyKt.lazy(new MessageReplyCountBlock$replyClickListener$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r9, com.ss.android.lark.blueprint.q<y6b.a<?>> r10, y6b.a<?> r11) {
        Intrinsics.checkNotNullParameter(r9, "cell");
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        y6b.c r12 = (y6b.c) r11;
        int r13 = r12.l;
        Boolean r0 = ReplyInThreadUtil.a;
        Intrinsics.checkNotNullParameter(r12, "messageVO");
        boolean r1 = ReplyInThreadUtil.b(r12);
        if (r1 == false) goto L8;
        if (r12.T1 > 0) goto L8;
        Log.i("ReplyInThreadUtil", "message is thread message, but reply count = " + r12.T1);
    L8:
        if (r1 == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L52;
        if (r13 == 0) goto L52;
        com.ss.android.lark.blueprint.k r14 = r10.c(this.g, IMMessageKeys$Slots.BOTTOM, new MessageReplyCountBlock$update$blockView$1(this));
        ReplyInThreadUtil.ReplyOptimizeFGState r3 = ReplyInThreadUtil.e(com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).C(), this.c.getChat());
        int[] r4 = a.a;
        int r5 = r4[r3.ordinal()];
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L23;
        if (r13 != 1) goto L22;
        r14.getView().setText(UIHelper.mustacheFormat(2131891571, "count", String.valueOf(r13)));
    L24:
        r14.getView().setOnClickListener(new b(this, r12));
        ChatThemeInfo r15 = this.c.r8();
        if (r15 == null) goto L27;
        ChatThemeInfo.Scene r16 = r15.getComponentScene();
    L28:
        boolean r17 = com.ss.android.lark.chat.utils.p.g(r16);
        if (r17 == false) goto L37;
        ChatThemeInfo r6 = this.c.r8();
        if (r6 == null) goto L33;
        ChatThemeInfo.Scene r7 = r6.getComponentScene();
    L35:
        if (com.ss.android.lark.chat.utils.p.f(r7) == false) goto L37;
        boolean r8 = true;
    L38:
        int r18 = zz7.b.g(getContext(), 12);
        int r19 = r4[ReplyInThreadUtil.e(com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).C(), this.c.getChat()).ordinal()];
        if (r19 == 1) goto L42;
        if (r19 == 2) goto L42;
        Drawable r20 = UIUtils.getDrawable(getContext(), 2131237569);
    L43:
        r20.setBounds(0, 0, r18, r18);
        if (r17 == true) goto L46;
    L49:
        int r21 = com.ss.android.lark.chat.utils.p.d(getContext());
        r14.getView().setTextColor(r21);
        r20.setTint(r21);
    L50:
        r14.getView().setCompoundDrawables(r20, null, null, null);
        return;
    L46:
        if (h18.f.a(getContext()) == true) goto L48;
        if (r8 == false) goto L49;
    L48:
        Context r22 = getContext();
        Intrinsics.checkNotNullParameter(r22, "context");
        int r23 = UIUtils.getColor(r22, 2131106617);
        r14.getView().setTextColor(r23);
        r20.setTint(r23);
    L42:
        r20 = UIUtils.getDrawable(getContext(), 2131237591);
        goto L43
    L33:
        r7 = null;
    L37:
        r8 = false;
        goto L38
    L27:
        r16 = null;
        goto L28
    L22:
        r14.getView().setText(UIHelper.mustacheFormat(2131891570, "count", String.valueOf(r13)));
    L23:
        r14.getView().setText(ICUUtils.icuFormat(UIHelper.getQuantityString(2131755065, r13), "num", String.valueOf(r13)));
    L52:
        g(r10, this.g, IMMessageKeys$Slots.BOTTOM);
        return;
    L10:
        if (r12.T1 <= 0) goto L12;
        r2 = true;
        goto L13
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
