package com.ss.android.lark.flow.chat.message.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.n0;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.s;
import com.ss.android.lark.blueprint.t;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.l1;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;
import z5c.r;
import z5c.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowReplyInThreadExposureBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.c<v5b.a<?>>, v5b.a<?>> {
    public final IMMessageKeys.Blocks g;

    public static final class a {
    }

    public static final class b implements k<View>, t {
        public final View a;
        public final TextView b;
        public final ThreadReplyExposureView c;
        public final TextView d;
        public final View e;
        public final StackSlot.a.a.a f;

        public final s a() {
            return this.f;
        }

        public final View getView() {
            return this.a;
        }

        public b(View r6) {
            Intrinsics.checkNotNullParameter(r6, "view");
            this.a = r6;
            TextView r0 = (TextView) r6.findViewById(2131388594);
            this.b = r0;
            this.c = r6.findViewById(2131384338);
            TextView r1 = (TextView) r6.findViewById(2131384363);
            this.d = r1;
            this.e = r6.findViewById(2131369197);
            StackSlot.a.a.getClass();
            this.f = StackSlot.a.a.b;
            r0.setTextSize(1, vgb.a.a(14.0f));
            r1.setTextSize(1, vgb.a.a(14.0f));
            Context r7 = r6.getContext();
            int r2 = zz7.b.g(r7, 16);
            Drawable r3 = UDIconUtils.getIconDrawable(r7, 2131235447, y9c.d.c(r7, 2131102043));
            r3.setBounds(0, 0, r2, r2);
            r1.setCompoundDrawablePadding(UIUtils.dp2px(r7, 4.0f));
            r1.setCompoundDrawables(r3, null, null, null);
        }
    }

    public static final class c implements ThreadReplyExposureView.b {
        public final /* synthetic */ y6b.c<v5b.a<?>> a;
        public final /* synthetic */ FlowReplyInThreadExposureBlock b;
        public final /* synthetic */ View.OnLongClickListener c;
        public final /* synthetic */ b d;

        public final void a() {
            this.c.onLongClick(this.d.c);
        }

        public final void b(y6b.c<?> r10, n0 r11) {
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
            String r4 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.b).c.getChatId();
            int r13 = r11.b();
            FlowReplyInThreadExposureBlock r5 = this.b;
            v4b.c r6 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r5).f;
            if (r6 == null) goto L15;
            MessageLink.ChatInfo r8 = r6.g;
        L16:
            if (r8 == null) goto L24;
            MessageLink.ChatInfo r7 = r6.g;
            if (r7 != null) goto L20;
        L22:
            if (r1 == false) goto L30;
            FlowReplyInThreadExposureBlock.h(this.b, r12, r3, Integer.valueOf(r13), null);
            return;
        L30:
            return;
        L20:
            if (r7.isAuth() != true) goto L22;
            r1 = true;
            goto L22
        L24:
            b3b.f r9 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r5).d;
            if (r9 == null) goto L32;
            if (r12 != null) goto L28;
            r12 = "";
        L28:
            r9.D(r2, r12, r4, Integer.valueOf(r13), null, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.b).c.R());
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

        public c(y6b.c r1, FlowReplyInThreadExposureBlock r2, e r3, b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ y6b.c<v5b.a<?>> b;
        public final /* synthetic */ FlowReplyInThreadExposureBlock c;

        public d(b r1, y6b.c<v5b.a<?>> r2, FlowReplyInThreadExposureBlock r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            boolean r0 = Intrinsics.areEqual(r15, this.a.d);
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
            FlowReplyInThreadExposureBlock r6 = this.c;
            v4b.c r7 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r6).f;
            ChatDisplayModeSetting r13 = null;
            if (r7 == null) goto L18;
            MessageLink.ChatInfo r8 = r7.g;
        L19:
            if (r8 == null) goto L27;
            MessageLink.ChatInfo r9 = r7.g;
            if (r9 != null) goto L23;
        L25:
            if (r2 == false) goto L31;
            FlowReplyInThreadExposureBlock.h(this.c, r5, r3, null, Boolean.valueOf(r0));
        L31:
            if (Intrinsics.areEqual(r15, this.a.d) == false) goto L39;
            Chat r16 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.c).c.getChat();
            if (r16 == null) goto L36;
            r13 = r16.getChatDisplayModeSetting();
        L36:
            if (r13 != ChatDisplayModeSetting.THREAD) goto L40;
            s5c.a r17 = r.g1;
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
            b3b.f r11 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r6).d;
            if (r11 == null) goto L31;
            r11.D(r4.c, r5, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r6).c.getChatId(), null, Boolean.valueOf(r0), ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.c).c.R());
            goto L31
        L18:
            r8 = null;
            goto L19
        L12:
            r5 = r4.Q1;
            if (r5 != null) goto L15;
            r5 = "";
            goto L15
        L5:
            if (r1.length() == 0) goto L8;
            r3 = false;
            goto L9
        }
    }

    public static final class e implements View.OnLongClickListener {
        public final /* synthetic */ m<y6b.c<v5b.a<?>>> a;
        public final /* synthetic */ FlowReplyInThreadExposureBlock b;
        public final /* synthetic */ y6b.c<v5b.a<?>> c;

        public e(m<y6b.c<v5b.a<?>>> r1, FlowReplyInThreadExposureBlock r2, y6b.c<v5b.a<?>> r3) {
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

    public final j getKey() {
        return this.g;
    }

    public FlowReplyInThreadExposureBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE;
    }

    public final void a(m<y6b.c<v5b.a<?>>> r2, q<y6b.c<v5b.a<?>>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys.Slots.FOOTER);
    }

    public void update(m<y6b.c<v5b.a<?>>> r12, q<y6b.c<v5b.a<?>>> r13, y6b.c<v5b.a<?>> r14) {
        Intrinsics.checkNotNullParameter(r12, "cell");
        Intrinsics.checkNotNullParameter(r13, "layout");
        Intrinsics.checkNotNullParameter(r14, "data");
        boolean r1 = true;
        if (r14.d() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L13;
        g(r13, this.g, IMMessageKeys.Slots.FOOTER);
        return;
    L13:
        b r15 = (b) r13.c(this.g, IMMessageKeys.Slots.FOOTER, new FlowReplyInThreadExposureBlock$update$blockView$1(this));
        e r2 = new e(r12, this, r14);
        d r16 = new d(r15, r14, this);
        r15.a.setOnClickListener(r16);
        r15.a.setOnLongClickListener(r2);
        ThreadReplyExposureView r3 = r15.c;
        int r5 = 2131102043;
        if (r14.i == false) goto L16;
        int r4 = 2131102067;
    L17:
        r3.d(UIUtils.getColor(getContext(), r4), UIUtils.getColor(getContext(), r4));
        r15.c.setMaxShowingReplyCount(3);
        r15.c.f(r14, r14.g2);
        int r6 = r15.c.getShowingReplyCount();
        int r7 = r14.T1;
        if (r7 > r6) goto L20;
        r15.b.setOnClickListener(null);
        r15.b.setVisibility(8);
    L21:
        if (r6 >= 1) goto L23;
        r15.c.setVisibility(8);
    L24:
        r15.c.setOnClickReplyListener(new c(r14, this, r2, r15));
        r15.d.setOnClickListener(r16);
        r15.d.setOnLongClickListener(r2);
        r15.d.setText(UIHelper.getString(2131890196));
        if (r14.V2 == false) goto L27;
        r15.d.setText(UIHelper.getString(2131890204));
    L27:
        ViewGroup.LayoutParams r17 = r15.a.getLayoutParams();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        v5b.a r8 = r14.o;
        if ((r8 instanceof com.ss.android.lark.message.card.view.a) == false) goto L30;
    L32:
        r1 = false;
    L34:
        if (l1.a() == false) goto L45;
        if (r1 == true) goto L37;
        return;
    L37:
        if (r14.i == false) goto L39;
        r5 = 2131102067;
    L39:
        Drawable r9 = UDIconUtils.getIconDrawable(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), 2131235447, y9c.d.c(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), r5), new UDDimension.Dp(16));
        r15.d.setCompoundDrawablePadding(UIUtils.dp2px(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), 4.0f));
        r15.d.setCompoundDrawables(r9, null, null, null);
        r15.d.setTextColor(UDColorUtils.getColor(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), r5));
        r15.b.setTextColor(y9c.d.c(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), r5));
        View r10 = r15.e;
        if (r14.i == false) goto L42;
        int r19 = 2131102065;
    L43:
        r10.setBackgroundResource(r19);
        r18.width = -2;
        r15.a.setLayoutParams(r18);
        return;
    L42:
        r19 = 2131102046;
        goto L43
    L45:
        return;
    L30:
        if ((r8 instanceof LynxCardContentVO) == true) goto L32;
    L23:
        r15.c.setVisibility(0);
        goto L24
    L20:
        int r11 = r7 - r6;
        String r20 = ICUUtils.icuFormat(UIUtils.getQuantityString(getContext(), 2131755050, r11), "num", String.valueOf(r11));
        r15.b.setText(r20);
        r15.b.setOnClickListener(r16);
        r15.b.setVisibility(0);
        goto L21
    L16:
        r4 = 2131102043;
        goto L17
    L5:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.q8() == false) goto L7;
    L8:
        r0 = true;
        goto L10
    L7:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.e0() == false) goto L9;
        goto L8
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.c) r3);
    }

    public static final void h(FlowReplyInThreadExposureBlock r1, String r2, boolean r3, Integer r4, Boolean r5) {
        mya.t r6 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r1).c.j5().b(mya.t.class);
        if (r6 == null) goto L8;
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r6.o(r2, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r1).c.getChatId(), r4, r5);
        return;
    }
}
