package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.l1;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;
import z5c.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReplyInThreadExposureBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.c<v5b.a<?>>, v5b.a<?>> {
    public final IMMessageKeys$Blocks g;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<ConstraintLayout>, com.ss.android.lark.blueprint.t {
        public final ConstraintLayout a;
        public final Group b;
        public final TextView c;
        public final View d;
        public final ThreadReplyExposureView e;
        public final TextView f;
        public final ConstraintLayout g;
        public final View h;
        public final StackSlot.a.C0045a.C0046a i;

        public final com.ss.android.lark.blueprint.s a() {
            return this.i;
        }

        public final View getView() {
            return this.a;
        }

        public b(ConstraintLayout r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            this.a = r5;
            this.b = r5.findViewById(2131388595);
            TextView r0 = (TextView) r5.findViewById(2131388594);
            this.c = r0;
            this.d = r5.findViewById(2131380929);
            this.e = (ThreadReplyExposureView) r5.findViewById(2131384338);
            TextView r1 = (TextView) r5.findViewById(2131384363);
            this.f = r1;
            this.g = r5;
            this.h = r5.findViewById(2131384348);
            StackSlot.a.a.getClass();
            this.i = StackSlot.a.C0045a.b;
            zz7.a.c(r0, 12);
            zz7.a.c(r1, 14);
            Context r6 = r5.getContext();
            int r2 = zz7.b.g(r6, 16);
            Drawable r3 = UDIconUtils.getIconDrawable(r6, 2131255541, y9c.d.c(r6, 2131106620));
            r3.setBounds(0, 0, r2, r2);
            r1.setCompoundDrawablePadding(UIUtils.dp2px(r6, 7.0f));
            r1.setCompoundDrawables(r3, null, null, null);
        }
    }

    public static final class c implements ThreadReplyExposureView.b {
        public final /* synthetic */ y6b.c<v5b.a<?>> a;
        public final /* synthetic */ ReplyInThreadExposureBlock b;
        public final /* synthetic */ View.OnLongClickListener c;
        public final /* synthetic */ b d;

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView.b
        public final void a() {
            this.c.onLongClick(this.d.e);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView.b
        public final void b(y6b.c<?> r10, com.ss.android.lark.biz.im.api.n0 r11) {
            Intrinsics.checkNotNullParameter(r10, "rootMessage");
            Intrinsics.checkNotNullParameter(r11, "replyMessage");
            String r2 = this.a.c;
            String r0 = r10.Q1;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            String r12 = r10.c;
        L12:
            String r4 = this.b.c.getChatId();
            int r13 = r11.b();
            ReplyInThreadExposureBlock r5 = this.b;
            v4b.c r6 = r5.f;
            if (r6 == null) goto L15;
            MessageLink.ChatInfo r8 = r6.g;
        L16:
            if (r8 == null) goto L24;
            MessageLink.ChatInfo r7 = r6.g;
            if (r7 != null) goto L20;
        L22:
            if (r1 == false) goto L30;
            ReplyInThreadExposureBlock.h(this.b, r12, r3, Integer.valueOf(r13), null);
            return;
        L30:
            return;
        L20:
            if (r7.isAuth() != true) goto L22;
            r1 = true;
            goto L22
        L24:
            b3b.f r9 = r5.d;
            if (r9 == null) goto L32;
            if (r12 != null) goto L28;
            r12 = BuildConfig.FLAVOR;
        L28:
            r9.D(r2, r12, r4, Integer.valueOf(r13), null, this.b.c.R());
            return;
        L32:
            return;
        L15:
            r8 = null;
            goto L16
        L11:
            r12 = r10.Q1;
            goto L12
        L5:
            if (r0.length() == 0) goto L8;
            r3 = false;
            goto L9
        }

        public c(y6b.c r1, ReplyInThreadExposureBlock r2, e r3, b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ y6b.c<v5b.a<?>> b;
        public final /* synthetic */ ReplyInThreadExposureBlock c;

        public d(b r1, y6b.c<v5b.a<?>> r2, ReplyInThreadExposureBlock r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            boolean r0 = Intrinsics.areEqual(r15, this.a.f);
            String r1 = this.b.Q1;
            boolean r2 = false;
            if (r1 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            y6b.c<v5b.a<?>> r4 = this.b;
            if (r3 == false) goto L12;
            String r5 = r4.c;
        L15:
            ReplyInThreadExposureBlock r6 = this.c;
            v4b.c r7 = r6.f;
            ChatDisplayModeSetting r13 = null;
            if (r7 == null) goto L18;
            MessageLink.ChatInfo r8 = r7.g;
        L19:
            if (r8 == null) goto L27;
            MessageLink.ChatInfo r9 = r7.g;
            if (r9 != null) goto L23;
        L25:
            if (r2 == false) goto L31;
            ReplyInThreadExposureBlock.h(this.c, r5, r3, null, Boolean.valueOf(r0));
        L31:
            if (Intrinsics.areEqual(r15, this.a.f) == false) goto L39;
            Chat r16 = this.c.c.getChat();
            if (r16 == null) goto L36;
            r13 = r16.getChatDisplayModeSetting();
        L36:
            if (r13 != ChatDisplayModeSetting.THREAD) goto L40;
            s5c.a r17 = z5c.r.g1;
            s5c.a r10 = p3.g;
            r17.getClass();
            Statistics.sendEvent("im_chat_main_click", s5c.d.b.b(r17, r10).plus(t3.c.a(r5)).plus(ChatParamUtils.e()).toJson());
            return;
        L40:
            return;
        L39:
            return;
        L23:
            if (r9.isAuth() != true) goto L25;
            r2 = true;
            goto L25
        L27:
            b3b.f r11 = r6.d;
            if (r11 == null) goto L31;
            r11.D(r4.c, r5, r6.c.getChatId(), null, Boolean.valueOf(r0), this.c.c.R());
            goto L31
        L18:
            r8 = null;
            goto L19
        L12:
            r5 = r4.Q1;
            if (r5 != null) goto L15;
            r5 = BuildConfig.FLAVOR;
            goto L15
        L5:
            if (r1.length() == 0) goto L8;
            r3 = false;
            goto L9
        }
    }

    public static final class e implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> a;
        public final /* synthetic */ ReplyInThreadExposureBlock b;
        public final /* synthetic */ y6b.c<v5b.a<?>> c;

        public e(com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r1, ReplyInThreadExposureBlock r2, y6b.c<v5b.a<?>> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 == null) goto L10;
            r5.e(this.b, this.c);
            return true;
        L10:
            return true;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ReplyInThreadExposureBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.REPLY_IN_THREAD_EXPOSURE;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r2, com.ss.android.lark.blueprint.q<y6b.c<v5b.a<?>>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.FOOTER);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r10, com.ss.android.lark.blueprint.q<y6b.c<v5b.a<?>>> r11, y6b.c<v5b.a<?>> r12) {
        Intrinsics.checkNotNullParameter(r10, "cell");
        Intrinsics.checkNotNullParameter(r11, "layout");
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
        boolean r1 = true;
        if (r12.d() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L13;
        g(r11, this.g, IMMessageKeys$Slots.FOOTER);
        return;
    L13:
        b r13 = (b) r11.c(this.g, IMMessageKeys$Slots.FOOTER, new ReplyInThreadExposureBlock$update$blockView$1(this));
        e r2 = new e(r10, this, r12);
        d r14 = new d(r13, r12, this);
        r13.a.setOnClickListener(r14);
        r13.a.setOnLongClickListener(r2);
        r13.e.f(r12, r12.g2);
        int r3 = r13.e.getShowingReplyCount();
        if (r12.T1 > r3) goto L16;
        r13.b.setVisibility(8);
        r13.d.setVisibility(0);
        r13.c.setOnClickListener(null);
    L17:
        if (r3 >= 1) goto L19;
        r13.e.setVisibility(8);
    L20:
        r13.e.setOnClickReplyListener(new c(r12, this, r2, r13));
        r13.f.setOnClickListener(r14);
        r13.f.setOnLongClickListener(r2);
        ViewGroup.LayoutParams r15 = r13.g.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        int r4 = com.ss.android.lark.chat.utils.f0.a;
        Intrinsics.checkNotNullParameter(r12, "messageVO");
        if (r12.b2 != ChatDisplayModeSetting.THREAD) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L35;
        T r17 = r12.o;
        if ((r17 instanceof com.ss.android.lark.message.card.view.a) == false) goto L28;
    L30:
        r1 = false;
    L32:
        if (l1.a() == false) goto L37;
        if (r1 == false) goto L38;
        Drawable r18 = UDIconUtils.getIconDrawable(this.c.getContext(), 2131255541, y9c.d.c(this.c.getContext(), 2131102419), new UDDimension.Dp(16));
        r13.f.setCompoundDrawablePadding(UIUtils.dp2px(this.c.getContext(), 7.0f));
        r13.f.setCompoundDrawables(r18, null, null, null);
        r13.f.setTextColor(UDColorUtils.getColor(this.c.getContext(), 2131102419));
        r16.width = -2;
        r13.g.setLayoutParams(r16);
        return;
    L38:
        return;
    L37:
        return;
    L28:
        if ((r17 instanceof LynxCardContentVO) == true) goto L30;
    L35:
        r13.e.getLayoutParams().width = -1;
        r13.d.getLayoutParams().width = -1;
        r13.h.getLayoutParams().width = 0;
        r16.width = -1;
        r13.g.setLayoutParams(r16);
        return;
    L23:
        r5 = false;
        goto L24
    L19:
        r13.e.setVisibility(0);
        goto L20
    L16:
        r13.b.setVisibility(0);
        r13.d.setVisibility(8);
        int r6 = r12.T1 - r3;
        r13.c.setText(UIHelper.getQuantityString(2131755067, r6));
        r13.c.setOnClickListener(r14);
        goto L17
    L5:
        if (this.c.q8() == false) goto L7;
    L8:
        r0 = true;
        goto L10
    L7:
        if (this.c.e0() == false) goto L9;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r1, com.ss.android.lark.blueprint.q<y6b.c<v5b.a<?>>> r2, y6b.c<v5b.a<?>> r3) {
        update2(r1, r2, r3);
    }

    public static final void h(ReplyInThreadExposureBlock r1, String r2, boolean r3, Integer r4, Boolean r5) {
        mya.t r6 = r1.c.j5().b(mya.t.class);
        if (r6 == null) goto L8;
        if (r2 != null) goto L6;
        r2 = BuildConfig.FLAVOR;
    L6:
        r6.o(r2, r1.c.getChatId(), r4, r5);
        return;
    }
}
