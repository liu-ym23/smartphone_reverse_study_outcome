package com.ss.android.lark.flow.chat.message.block;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.c0;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.AvatarBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UsernameBlock;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowUsernameBlock extends UsernameBlock {

    public static final class a implements k<View> {
        public final View a;
        public final TextView b;
        public final ViewGroup c;
        public View d;

        public final View getView() {
            return this.a;
        }

        public a(View r2, TextView r3, ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "nameTv");
            Intrinsics.checkNotNullParameter(r4, "tagContainer");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = null;
        }
    }

    public FlowUsernameBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
    }

    public final void j(q<y6b.c<?>> r13, y6b.c<?> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "layout");
        Intrinsics.checkNotNullParameter(r14, "data");
        a r16 = (a) r13.c(((UsernameBlock) this).g, ((UsernameBlock) this).h, new FlowUsernameBlock$renderUsername$blockView$1(this));
        TextView r1 = r16.b;
        c0 r2 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.d0(c0.class);
        if (r2 == null) goto L5;
        r1.setPadding(UIUtils.dp2px(getContext(), r2.b), r1.getPaddingTop(), r1.getPaddingRight(), r1.getPaddingBottom());
    L5:
        boolean r4 = true;
        if (r15 == false) goto L13;
        if (r2 == null) goto L11;
        Integer r17 = r2.a;
        if (r17 == null) goto L11;
        int r18 = r17.intValue();
    L12:
        r1.setTextColor(UDColorUtils.getColor(getContext(), r18));
        i3b.c.b(r1, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a, 14.0f);
        r1.getPaint().setFakeBoldText(true);
    L19:
        int r19 = AvatarBlock.j;
        y6b.b r110 = AvatarBlock.b.a(r14);
        if (r110 != null) goto L22;
        r1.setText(getContext().getString(2131892298));
        r1.setTextColor(UIUtils.getColor(getContext(), 2131106620));
    L30:
        if (r110 == null) goto L32;
        boolean r3 = r110.q;
    L34:
        if (r3 == true) goto L82;
        FlowTagBuilder r5 = new FlowTagBuilder(getContext());
        Intrinsics.checkNotNullParameter(r14, "data");
        long r6 = cac.b.a.a.a(30000) / 1000;
        ChatterCustomStatus.a r0 = ChatterCustomStatus.Companion;
        y6b.b r111 = r14.t;
        if (r111 == null) goto L39;
        List r112 = r111.C;
    L40:
        r0.getClass();
        List r113 = ChatterCustomStatus.a.c(r112);
        if (r113 != null) goto L43;
    L64:
        boolean r114 = false;
    L65:
        r5.h = r114;
        if (r110 == null) goto L68;
        boolean r115 = r110.m;
    L69:
        r5.f = r115;
        if (r110 != null) goto L72;
    L78:
        r4 = false;
    L79:
        r5.j = r4;
        FlowTagView r116 = r5.b();
        if (r116 == null) goto L82;
        r116.setTagStyle(new ahb.a(10.0f, 4.0f, 18.0f, 5.0f, 48));
    L83:
        View r117 = r16.d;
        if (r117 == null) goto L86;
        r16.c.removeView(r117);
        r16.d = null;
    L86:
        if (r116 != null) goto L88;
        r16.c.setVisibility(8);
        return;
    L88:
        r16.d = r116;
        r16.c.addView(r116);
        r16.c.setVisibility(0);
        return;
    L72:
        if (r110.j != Chatter.ChatterType.BOT) goto L78;
        if ("bot".equals(r110.s) == false) goto L78;
        if (r110.t == false) goto L78;
    L68:
        r115 = false;
        goto L69
    L43:
        if (r113.isEmpty() == true) goto L64;
        Iterator r118 = r113.iterator();
    L47:
        if (r118.hasNext() == false) goto L64;
        com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus r7 = (com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus) r118.next();
        StatusEffectiveInterval r8 = r7.effective_interval;
        if (r8 != null) goto L52;
    L61:
        boolean r9 = false;
    L62:
        if (r9 == false) goto L47;
        r114 = true;
        goto L65
    L52:
        if (Intrinsics.areEqual(r7.icon_key, "GeneralVacation") == false) goto L61;
        Long r10 = r8.start_time;
        if (r6 <= r8.end_time.longValue()) goto L56;
    L58:
        boolean r11 = false;
    L59:
        if (r11 == false) goto L61;
        r9 = true;
        goto L62
    L56:
        if (r10.longValue() > r6) goto L58;
        r11 = true;
        goto L59
    L39:
        r112 = null;
    L82:
        r116 = null;
        goto L83
    L32:
        r3 = false;
        goto L34
    L22:
        r1.setText(r110.i);
        if (((UsernameBlock) this).o == false) goto L30;
        if ((!h18.f.a(getContext())) == true) goto L27;
        r1.setTextColor(p.e(getContext()));
        goto L30
    L27:
        if (((UsernameBlock) this).n == false) goto L30;
        r1.setTextColor(p.b(getContext()));
    L11:
        r18 = 2131106622;
        goto L12
    L13:
        if (r2 == null) goto L17;
        Integer r119 = r2.a;
        if (r119 == null) goto L17;
        int r120 = r119.intValue();
    L18:
        r1.setTextColor(UDColorUtils.getColor(getContext(), r120));
        i3b.c.b(r1, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a, 12.0f);
        r1.getPaint().setFakeBoldText(false);
    L17:
        r120 = 2131106620;
        goto L18
    }
}
