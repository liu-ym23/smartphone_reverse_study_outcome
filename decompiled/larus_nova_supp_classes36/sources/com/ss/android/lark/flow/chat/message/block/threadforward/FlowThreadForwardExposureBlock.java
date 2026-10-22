package com.ss.android.lark.flow.chat.message.block.threadforward;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.s;
import com.ss.android.lark.blueprint.t;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.l1;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadForwardExposureBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ThreadForwardContentVOV2>, ThreadForwardContentVOV2> {
    public static final /* synthetic */ int j = 0;
    public final IMMessageKeys.Blocks g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b implements k<View>, t {
        public final View a;
        public final View b;
        public final TextView c;
        public final ThreadReplyExposureView d;
        public final TextView e;
        public final View f;
        public final StackSlot.a.a.a g;

        public final s a() {
            return this.g;
        }

        public final View getView() {
            return this.a;
        }

        public b(View r7) {
            Intrinsics.checkNotNullParameter(r7, "view");
            this.a = r7;
            this.b = r7.findViewById(2131384837);
            TextView r0 = (TextView) r7.findViewById(2131388594);
            this.c = r0;
            this.d = r7.findViewById(2131384338);
            TextView r1 = (TextView) r7.findViewById(2131384363);
            this.e = r1;
            View r2 = r7.findViewById(2131369197);
            this.f = r2;
            StackSlot.a.a.getClass();
            this.g = StackSlot.a.a.b;
            zz7.a.c(r0, 14);
            zz7.a.c(r1, 14);
            Context r3 = r7.getContext();
            int r4 = zz7.b.g(r3, 16);
            Drawable r5 = UDIconUtils.getIconDrawable(r3, 2131235447, y9c.d.c(r3, 2131102043));
            r5.setBounds(0, 0, r4, r4);
            r1.setCompoundDrawablePadding(UIUtils.dp2px(r3, 4.0f));
            r1.setCompoundDrawables(r5, null, null, null);
            r2.setBackgroundColor(UIUtils.getColor(r7.getContext(), 2131102046));
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public FlowThreadForwardExposureBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_THREAD_FORWARD_EXPOSURE;
        this.h = LazyKt.lazy(new FlowThreadForwardExposureBlock$replyInThreadCallback$2(this));
        this.i = LazyKt.lazy(new FlowThreadForwardExposureBlock$threadCallback$2(this));
    }

    public final void a(m<y6b.a<ThreadForwardContentVOV2>> r2, q<y6b.a<ThreadForwardContentVOV2>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys.Slots.FOOTER);
    }

    public void update(m<y6b.a<ThreadForwardContentVOV2>> r9, q<y6b.a<ThreadForwardContentVOV2>> r10, y6b.a<ThreadForwardContentVOV2> r11) {
        Intrinsics.checkNotNullParameter(r9, "cell");
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r11, "data");
        b r12 = (b) r10.c(this.g, IMMessageKeys.Slots.INNER_EXPOSURE, new FlowThreadForwardExposureBlock$update$blockView$1(this));
        String r0 = r11.getId();
        ThreadForwardContentVOV2 r1 = r11.b();
        Thread r2 = ((v5b.a) r1).a.getThread();
        if (r2 == null) goto L6;
        String r3 = r2.id;
        if (r3 == null) goto L6;
    L7:
        r12.b.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.threadforward.a(r1, this, r3, r0));
        r12.b.setOnLongClickListener(new com.ss.android.lark.flow.chat.message.block.threadforward.b(r9, this, r11));
        r12.d.d(UIUtils.getColor(getContext(), 2131102043), UIUtils.getColor(getContext(), 2131102043));
        ThreadForwardContentVOV2 r13 = r11.b();
        r12.d.setMaxShowingReplyCount(3);
        r12.d.f(null, r13.o);
        int r4 = r12.d.getShowingReplyCount();
        int r5 = r13.n;
        if (r5 > r4) goto L10;
        r12.c.setOnClickListener(null);
        r12.c.setVisibility(8);
    L11:
        boolean r6 = true;
        if (r4 >= 1) goto L14;
        r12.d.setVisibility(8);
    L15:
        ViewGroup.LayoutParams r7 = r12.a.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r8.width = -1;
        r12.a.setLayoutParams(r8);
        if (r13.h.isNoTraceDelete() == false) goto L19;
        r12.e.setVisibility(8);
        r12.f.setVisibility(8);
        r12.a.setVisibility(8);
        return;
    L19:
        r12.a.setVisibility(0);
        r12.f.setVisibility(0);
        if (r13.f() == true) goto L22;
    L33:
        r12.e.setVisibility(8);
        return;
    L22:
        if (r11.d() == true) goto L33;
        if ((r13 instanceof com.ss.android.lark.message.card.view.a) == false) goto L26;
    L28:
        r6 = false;
    L29:
        r12.e.setVisibility(0);
        if (l1.a() == false) goto L35;
        if (r6 == false) goto L36;
        Drawable r14 = UDIconUtils.getIconDrawable(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), 2131235447, y9c.d.c(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), 2131102043), new UDDimension.Dp(16));
        r12.e.setCompoundDrawablePadding(UIUtils.dp2px(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), 4.0f));
        r12.e.setCompoundDrawables(r14, null, null, null);
        r12.e.setTextColor(UDColorUtils.getColor(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.getContext(), 2131102043));
        return;
    L36:
        return;
    L35:
        return;
    L26:
        if ((r13 instanceof LynxCardContentVO) == true) goto L28;
    L14:
        r12.d.setVisibility(0);
        goto L15
    L10:
        int r15 = r5 - r4;
        String r16 = ICUUtils.icuFormat(UIUtils.getQuantityString(getContext(), 2131755050, r15), "num", String.valueOf(r15));
        r12.c.setText(r16);
        r12.c.setVisibility(0);
    L6:
        r3 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
