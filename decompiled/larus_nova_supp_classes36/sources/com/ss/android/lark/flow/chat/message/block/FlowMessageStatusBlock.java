package com.ss.android.lark.flow.chat.message.block;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b3b.o;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chatbase.view.ChatMessageEditStatusView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMessageStatusBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public static final /* synthetic */ int j = 0;
    public final IMMessageKeys.Blocks g;
    public final IMMessageKeys.Slots h;
    public final b3b.f i;

    public static final class a {
    }

    public static final class b implements k<View> {
        public final View a;
        public final ImageView b;
        public final TextView c;
        public final ChatMessageEditStatusView d;

        public final View getView() {
            return this.a;
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = (ImageView) r2.findViewById(2131373035);
            this.c = (TextView) r2.findViewById(2131380015);
            this.d = r2.findViewById(2131379981);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SendStatus.values().length];
            r0[SendStatus.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SendStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SendStatus.FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ FlowMessageStatusBlock a;
        public final /* synthetic */ y6b.a<?> b;

        public d(FlowMessageStatusBlock r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b3b.f r3 = this.a.i;
            if (r3 == null) goto L6;
            r3.A(this.b.getId());
            return;
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public FlowMessageStatusBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.MESSAGE_STATUS;
        this.h = IMMessageKeys.Slots.BOTTOM;
        b3b.f r3 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).d;
        if ((r3 instanceof o) == true) goto L6;
        r3 = null;
    L6:
        this.i = r3;
    }

    public final void h(q<?> r6) {
        k r0 = r6.f(this.g, this.h);
        if ((r0 instanceof b) == false) goto L5;
        b r1 = (b) r0;
    L6:
        if (r1 == null) goto L8;
        r1.b.setVisibility(8);
        r1.c.setText("");
        r1.d.setVisibility(8);
    L8:
        k r2 = r6.f(this.g, this.h);
        if (r2 == null) goto L13;
        View r3 = r2.getView();
        if (r3 == null) goto L13;
        r3.setOnClickListener(null);
    L13:
        g(r6, this.g, this.h);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final b i(q<?> r4) {
        return (b) r4.c(this.g, IMMessageKeys.Slots.BOTTOM, new FlowMessageStatusBlock$requireReadAndSendStatusView$1(this));
    }

    public void update(m<y6b.a<?>> r12, q<y6b.a<?>> r13, final y6b.a<?> r14) {
        Intrinsics.checkNotNullParameter(r12, "cell");
        Intrinsics.checkNotNullParameter(r13, "layout");
        Intrinsics.checkNotNullParameter(r14, "data");
        y6b.c r0 = null;
        boolean r2 = true;
        if (r14.h() == true) goto L6;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L29;
        return;
    L29:
        boolean r16 = r14 instanceof y6b.c;
        if (r16 == false) goto L32;
        y6b.c r4 = (y6b.c) r14;
    L33:
        if (r4 != null) goto L35;
    L37:
        boolean r5 = false;
    L38:
        if (r5 == true) goto L40;
    L42:
        boolean r6 = false;
    L43:
        String r8 = "";
        if (r6 == false) goto L47;
    L75:
        String r7 = "";
    L77:
        if (r7.length() != 0) goto L79;
        boolean r9 = true;
    L81:
        if (r9 == false) goto L143;
        if (r16 == false) goto L84;
        r0 = (y6b.c) r14;
    L84:
        if (r0 == null) goto L137;
        y6b.c r17 = (y6b.c) r14;
        if (r17.isPreMessage() == false) goto L93;
        SendStatus r18 = r17.s;
        if (r18 != SendStatus.SENDING) goto L91;
    L92:
        boolean r19 = true;
    L95:
        if (r0.i == true) goto L97;
    L120:
        boolean r110 = false;
    L121:
        if (r110 == false) goto L137;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.B8() == true) goto L137;
        int r111 = r0.P0 - 1;
        int r112 = r0.V0;
        int r1 = r111 + r112;
        if (r111 != 0) goto L127;
        String r113 = UIUtils.getString(getContext(), 2131889994);
    L134:
        r8 = r113;
    L135:
        Intrinsics.checkNotNull(r8);
        goto L137
    L127:
        if (r111 >= r1) goto L129;
        r113 = ICUUtils.icuFormat(UIUtils.getQuantityString(getContext(), 2131755049, r111), "num", Long.valueOf(r111));
        goto L134
    L129:
        if (r112 != 0) goto L135;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.isGroup() == false) goto L133;
        r113 = UIUtils.getString(getContext(), 2131890151);
        goto L134
    L133:
        r113 = UIUtils.getString(getContext(), 2131889992);
        goto L134
    L97:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.X() == true) goto L120;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.h() == true) goto L120;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.o() == true) goto L120;
        if (r0.D == MessageDLPState.BLOCK) goto L120;
        if (r0.z == true) goto L120;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.isAIChat() == true) goto L120;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.e0() == true) goto L120;
        if (r0.K2 == false) goto L120;
        if (r19 == true) goto L120;
        if (r0.isPreMessage() == true) goto L120;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.Y() == true) goto L118;
    L119:
        r110 = true;
        goto L121
    L118:
        if (r17.Y() == true) goto L120;
    L91:
        if (r18 == SendStatus.FAIL) goto L92;
    L93:
        r19 = false;
    L137:
        if (r8.length() == 0) goto L140;
        r2 = false;
    L140:
        if (r2 == false) goto L142;
        h(r13);
        return;
    L142:
        b r114 = i(r13);
        r114.c.setTextColor(UIUtils.getColor(getContext(), 2131102042));
        r114.c.setText(r8);
        r114.c.setVisibility(0);
        r114.b.setVisibility(8);
        r114.d.setVisibility(8);
        r114.a.setVisibility(0);
        return;
    L143:
        int r115 = c.a[r14.G().ordinal()];
        if (r115 == 1) goto L149;
        if (r115 == 2) goto L149;
        if (r115 == 3) goto L148;
        h(r13);
        return;
    L148:
        b r116 = i(r13);
        r116.c.setTextColor(UIUtils.getColor(getContext(), 2131102036));
        r116.c.setText(r7);
        r116.c.setVisibility(0);
        r116.a.setVisibility(0);
        r116.b.setVisibility(0);
        r116.d.setVisibility(8);
        r116.a.setVisibility(0);
        r116.a.setOnClickListener(new d(this, r14));
        return;
    L149:
        b r117 = i(r13);
        r117.c.setTextColor(UIUtils.getColor(getContext(), 2131102042));
        r117.c.setText(r7);
        r117.c.setVisibility(0);
        r117.a.setVisibility(0);
        r117.b.setVisibility(8);
        r117.d.setVisibility(8);
        r117.a.setVisibility(0);
        return;
    L79:
        r9 = false;
        goto L81
    L47:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.s8() == true) goto L75;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.o() == true) goto L75;
        if (r14.h() == true) goto L53;
    L55:
        boolean r10 = false;
    L56:
        if (r10 == true) goto L75;
        if (r14.h() == false) goto L75;
        if (r14.isPreMessage() == false) goto L75;
        int r11 = c.a[r14.G().ordinal()];
        if (r11 == 1) goto L70;
        if (r11 == 2) goto L69;
        if (r11 != 3) goto L75;
        r7 = UIUtils.getString(getContext(), 2131889993);
        goto L77
    L69:
        r7 = UIUtils.getString(getContext(), 2131889994);
        goto L77
    L70:
        if (r16 == true) goto L72;
    L74:
        r7 = UIUtils.getString(getContext(), 2131890172);
        goto L77
    L72:
        if (((y6b.c) r14).K2 == true) goto L74;
    L53:
        if (MessageDLPState.BLOCK != r14.t()) goto L55;
        r10 = true;
        goto L56
    L40:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.Y() == false) goto L42;
        r6 = true;
        goto L43
    L35:
        if (r4.Y() != true) goto L37;
        r5 = true;
        goto L38
    L32:
        r4 = null;
        goto L33
    L6:
        if (r14.u() == null) goto L26;
        if (r14.j() == true) goto L26;
        MessageEditInfo r118 = r14.u();
        if (r118 == null) goto L13;
        MessageEditInfo.EditStatus r119 = r118.getEditStatus();
    L15:
        if (r119 == MessageEditInfo.EditStatus.None) goto L26;
        if (r119 == MessageEditInfo.EditStatus.NoRequest) goto L26;
        b r20 = i(r13);
        ChatMessageEditStatusView r21 = r20.d;
        if (r119 != MessageEditInfo.EditStatus.Failed) goto L23;
        r20.c.setVisibility(8);
        r20.b.setVisibility(8);
        r20.d.setVisibility(0);
        r20.a.setVisibility(0);
        r21.a(new FlowMessageStatusBlock$showUpdateEditStatus$1(this, r14));
    L25:
        r15 = true;
        goto L27
    L23:
        if (r119 != MessageEditInfo.EditStatus.Waiting) goto L26;
        r20.c.setVisibility(8);
        r20.b.setVisibility(8);
        r20.d.setVisibility(0);
        r20.a.setVisibility(0);
        r21.b();
        goto L25
    L13:
        r119 = null;
        goto L15
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
