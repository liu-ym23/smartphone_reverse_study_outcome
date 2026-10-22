package com.ss.android.lark.flow.chat.message.layout;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.q;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble.IBubbleBodyBgStyleProvider;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.view.InterceptConstraintLayout;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.view.FlowBubbleMainContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a extends com.ss.android.lark.blueprint.a<y6b.a<?>> implements com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.e, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c, h3b.c, IBubbleBodyBgStyleProvider, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.d {
    public static final /* synthetic */ int m = 0;
    public final boolean f;
    public BubbleLayoutAlphaMode g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Map<v, Integer> k;
    public LKUIRoundLinearLayout l;

    public abstract void B(LKUIRoundLinearLayout r1, y6b.a<?> r2);

    public void v() {
    }

    public abstract LKUIRoundLinearLayout y(ViewGroup r1);

    public abstract Map<v, Integer> z();

    public final void e() {
        ((LKUIRoundableLayout) this.i.getValue()).setVisibility(0);
    }

    public final List<v> g() {
        return CollectionsKt.toList(this.k.keySet());
    }

    public final void h() {
        ((LKUIRoundableLayout) this.i.getValue()).setVisibility(8);
    }

    public final m2b.a x() {
        return (m2b.a) this.h.getValue();
    }

    public final Point i() {
        InterceptConstraintLayout r0 = r();
        if ((r0 instanceof InterceptConstraintLayout) == false) goto L5;
        InterceptConstraintLayout r1 = r0;
    L6:
        if (r1 == null) goto L9;
        int[] r2 = new int[2];
        r1.getLocationInWindow(r2);
        Point r3 = r1.getLastTouchPoint();
        r3.offset(r2[0], r2[1]);
        return r3;
    L9:
        return new Point();
    L5:
        r1 = null;
        goto L6
    }

    public final ViewGroup k() {
        return this.l;
    }

    public IBubbleBodyBgStyleProvider.Style m() {
        return IBubbleBodyBgStyleProvider.Style.Normal;
    }

    public final Map<v, Integer> t() {
        return this.k;
    }

    public void A(y6b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        super.l(r6);
        View r7 = (View) this.j.getValue();
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        o3b.a r1 = x().H8();
        r0.width = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), r1.c()) + (zz7.b.g(((com.ss.android.lark.blueprint.a) this).a.getContext(), r1.a()) - UIUtils.dp2px(r7.getContext(), r1.a()));
        r7.setLayoutParams(r0);
        q r8 = x().d0(q.class);
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == false) goto L20;
        Context r10 = ((com.ss.android.lark.blueprint.a) this).a.getContext();
        if (x().s8() == true) goto L13;
    L15:
        float r2 = 0.0f;
    L16:
        int r11 = UIUtils.dp2px(r10, r2);
        Iterator r3 = CollectionsKt.listOf(new Integer[]{2131364922, 2131364915, 2131364927, 2131364923, 2131364910}).iterator();
    L18:
        if (r3.hasNext() == false) goto L22;
        r().findViewById(((Number) r3.next()).intValue()).setTranslationX(r11);
        goto L18
    L22:
        return;
    L13:
        if (this.f == true) goto L15;
        r2 = 28.0f;
        goto L16
    L20:
        return;
    L5:
        if (r8.a != true) goto L7;
        r9 = true;
        goto L8
    }

    public final void d(boolean r3) {
        InterceptConstraintLayout r0 = r();
        if ((r0 instanceof InterceptConstraintLayout) == false) goto L5;
        InterceptConstraintLayout r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.setShouldInterceptTouchEvent(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void l(Object r1) {
        A((y6b.a) r1);
    }

    public final View n(v r2) {
        Intrinsics.checkNotNullParameter(r2, "slotId");
        return s(r2);
    }

    public final void setSelected(boolean r2) {
        r().setSelected(r2);
    }

    public final View u(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (this.f == false) goto L5;
        int r0 = 2131561136;
    L6:
        View r7 = LayoutInflater.from(r6.getContext()).inflate(r0, r6, false);
        View r1 = r7.findViewById(2131389126);
        if (r1 == null) goto L9;
        r7.setTag(2131373020, r1);
    L9:
        View r2 = r7.findViewById(2131364411);
        if (r2 == null) goto L12;
        r7.setTag(2131373019, r2);
    L12:
        FlowBubbleMainContainer r3 = (FlowBubbleMainContainer) r7.findViewById(2131364922);
        if (r3 == null) goto L15;
        r3.setRtl(this.f);
        LKUIRoundLinearLayout r4 = y(r3);
        this.l = r4;
        r4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r3.addView(r4, 0);
    L15:
        Intrinsics.checkNotNull(r7);
        return r7;
    L5:
        r0 = 2131561135;
        goto L6
    }

    public void update(y6b.a<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        int r0 = c.a;
        com.ss.android.lark.blueprint.g r1 = ((com.ss.android.lark.blueprint.a) this).a;
        View r2 = r();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<*>");
        y6b.c r3 = (y6b.c) r8;
        Intrinsics.checkNotNullParameter(r1, "ctx");
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "item");
        i3b.d r4 = r1.c.a(i3b.d.class);
        int r5 = 3;
        if (r4 == null) goto L28;
        m2b.a r6 = r4.a();
        if (r6 == null) goto L28;
        int r7 = r3.R2;
        if (r7 != 0) goto L10;
        r2.setPadding(0, c.a(r6), 0, 0);
        goto L28
    L10:
        if (r7 != 1) goto L12;
        int r9 = c.a(r6);
        if (r3.r != Message.Status.DELETED) goto L26;
        r3.R2 = 0;
        r2.setPadding(0, r9, 0, 0);
        goto L28
    L26:
        r2.setPadding(0, r9, 0, c.b);
        goto L28
    L12:
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L16;
        r2.setPadding(0, c.a(r6), 0, 0);
        goto L28
    L16:
        if (r3.Q2 == false) goto L18;
        r2.setPadding(0, c.b, 0, 0);
        goto L28
    L18:
        r3.R2 = 0;
        r2.setPadding(0, c.c, 0, 0);
        goto L28
    L20:
        if (r3.r != Message.Status.DELETED) goto L22;
        r2.setPadding(0, c.b, 0, c.c);
        goto L28
    L22:
        int r10 = c.b;
        r2.setPadding(0, r10, 0, r10);
    L28:
        LKUIRoundLinearLayout r11 = this.l;
        if (r11 != null) goto L31;
        return;
    L31:
        B(r11, r8);
        IMMessageKeys.Slots r12 = IMMessageKeys.Slots.BOTTOM;
        StackSlot r13 = s(r12);
        StackSlot r14 = null;
        if ((r13 instanceof StackSlot) == false) goto L34;
        StackSlot r15 = r13;
    L35:
        if (r15 == null) goto L37;
        r15.setSpacing(UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 6.0f));
    L37:
        ViewGroup r16 = s(r12);
        if ((r16 instanceof StackSlot) == false) goto L40;
        r14 = (StackSlot) r16;
    L40:
        if (r14 == null) goto L46;
        if (this.f == false) goto L44;
        r5 = 5;
    L44:
        r14.setGravity(r5);
    L46:
        if ((r8 instanceof y6b.c) == true) goto L48;
        return;
    L48:
        if (r3.L2 == true) goto L50;
        BubbleLayoutAlphaMode r17 = this.g;
        if (r17 != BubbleLayoutAlphaMode.EDIT_MASK) goto L79;
        r().setAlpha(1.0f);
    L86:
        this.g = BubbleLayoutAlphaMode.NORMAL;
        return;
    L79:
        if (r17 != BubbleLayoutAlphaMode.AVATAR_HIGHLIGHT) goto L86;
        Iterator<Map.Entry<v, Integer>> r18 = this.k.entrySet().iterator();
    L82:
        if (r18.hasNext() == false) goto L86;
        View r19 = n(r18.next().getKey());
        if (r19 == null) goto L82;
        r19.setAlpha(1.0f);
        goto L82
    L50:
        if (r3.M2 == false) goto L66;
        Iterator<Map.Entry<v, Integer>> r20 = this.k.entrySet().iterator();
    L53:
        if (r20.hasNext() == false) goto L63;
        Map.Entry<v, Integer> r21 = r20.next();
        IMMessageKeys.Slots r22 = r21.getKey();
        IMMessageKeys.Slots r23 = IMMessageKeys.Slots.AVATAR;
        if (r22 == r23) goto L56;
        View r24 = n(r21.getKey());
        if (r24 == null) goto L53;
        r24.setAlpha(0.3f);
        goto L53
    L56:
        View r25 = n(r23);
        if (r25 == null) goto L53;
        r25.setAlpha(1.0f);
        goto L53
    L63:
        if (this.g != BubbleLayoutAlphaMode.EDIT_MASK) goto L65;
        r().setAlpha(1.0f);
    L65:
        this.g = BubbleLayoutAlphaMode.AVATAR_HIGHLIGHT;
        return;
    L66:
        r().setAlpha(0.3f);
        if (this.g != BubbleLayoutAlphaMode.AVATAR_HIGHLIGHT) goto L74;
        Iterator<Map.Entry<v, Integer>> r26 = this.k.entrySet().iterator();
    L70:
        if (r26.hasNext() == false) goto L74;
        View r27 = n(r26.next().getKey());
        if (r27 == null) goto L70;
        r27.setAlpha(1.0f);
    L74:
        this.g = BubbleLayoutAlphaMode.EDIT_MASK;
        return;
    L34:
        r15 = null;
        goto L35
    }

    public /* bridge */ /* synthetic */ void update(Object r1) {
        update((y6b.a) r1);
    }

    public a(final com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3);
        this.f = r4;
        this.g = BubbleLayoutAlphaMode.NORMAL;
        this.h = LazyKt.lazy(new FlowAbsBubbleLayout$chatContext$2(r2));
        this.i = LazyKt.lazy(new FlowAbsBubbleLayout$maskView$2(this));
        this.j = LazyKt.lazy(new FlowAbsBubbleLayout$selectSpacer$2(this));
        Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(IMMessageKeys.Slots.AVATAR, 2131364910), TuplesKt.to(IMMessageKeys.Slots.TOP, 2131364927), TuplesKt.to(IMMessageKeys.Slots.BOTTOM, 2131364915), TuplesKt.to(IMMessageKeys.Slots.ROOF, 2131364923), TuplesKt.to(IMMessageKeys.Slots.SELECT, 2131364924)});
        r5.putAll(z());
        this.k = MapsKt.toMap(r5);
    }

    public final void C(LKUIRoundLinearLayout r8, y6b.a r9, float r10) {
        Intrinsics.checkNotNullParameter(r8, "bodyLayout");
        Intrinsics.checkNotNullParameter(r9, "data");
        float[] r0 = new float[4];
        int r2 = 0;
    L3:
        if (r2 >= 4) goto L5;
        r0[r2] = r10;
        r2 = r2 + 1;
        goto L3
    L5:
        r8.setRadius(r0[0], r0[1], r0[2], r0[3]);
        ((LKUIRoundableLayout) this.i.getValue()).setRadius(r0[0], r0[1], r0[2], r0[3]);
    }
}
