package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.f0;
import com.ss.android.lark.chatwindow.view.widget.MessageBubbleBodyContainer;
import com.tencent.qqmusic.third.api.contract.Keys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a extends com.ss.android.lark.blueprint.a<y6b.a<?>> implements e, c, h3b.c, IBubbleBodyBgStyleProvider, f, g, d {
    public static final /* synthetic */ int l = 0;
    public final boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Map<v, Integer> j;
    public LKUIRoundLinearLayout k;

    public abstract void B(LKUIRoundLinearLayout r1, y6b.a<?> r2);

    public void v() {
    }

    public abstract LKUIRoundLinearLayout y(ViewGroup r1);

    public abstract Map<v, Integer> z();

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.e
    public final void e() {
        ((LKUIRoundableLayout) this.h.getValue()).setVisibility(0);
    }

    @Override // h3b.c
    public final List<v> g() {
        return CollectionsKt.toList(this.j.keySet());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.e
    public final void h() {
        ((LKUIRoundableLayout) this.h.getValue()).setVisibility(8);
    }

    public final m2b.a x() {
        return (m2b.a) this.g.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.view.InterceptConstraintLayout] */
    /* JADX WARN: Type inference failed for: r0v6 */
    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g
    public final Point i() {
        Object r0 = r();
        if ((r0 instanceof InterceptConstraintLayout) == false) goto L5;
        ?? r1 = (InterceptConstraintLayout) r0;
    L6:
        if (r1 == 0) goto L9;
        int[] r2 = new int[2];
        r1.getLocationInWindow(r2);
        Point r3 = r1.getLastTouchPoint();
        r3.offset(r2[0], r2[1]);
        return r3;
    L9:
        return new Point();
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c
    public final ViewGroup k() {
        return this.k;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble.IBubbleBodyBgStyleProvider
    public IBubbleBodyBgStyleProvider.Style m() {
        return IBubbleBodyBgStyleProvider.Style.Normal;
    }

    public final Map<v, Integer> t() {
        return this.j;
    }

    public void A(y6b.a<?> r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        super.l(r8);
        ViewGroup r9 = s(IMMessageKeys$Slots.CORNER_1);
        if (r9 == null) goto L5;
        r9.setVisibility(0);
    L5:
        ViewGroup r10 = s(IMMessageKeys$Slots.CORNER_2);
        if (r10 == null) goto L8;
        r10.setVisibility(0);
    L8:
        View r11 = (View) this.i.getValue();
        ViewGroup.LayoutParams r1 = r11.getLayoutParams();
        o3b.a r2 = x().H8();
        r1.width = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), r2.c()) + (zz7.b.g(((com.ss.android.lark.blueprint.a) this).a.getContext(), r2.a()) - UIUtils.dp2px(r11.getContext(), r2.a()));
        r11.setLayoutParams(r1);
        if (this.f == false) goto L23;
        q r12 = x().d0(q.class);
        if (r12 != null) goto L13;
    L15:
        boolean r13 = false;
    L16:
        if (r13 == true) goto L23;
        if (x().s8() == false) goto L23;
        ViewGroup r14 = s(IMMessageKeys$Slots.AVATAR);
        if (r14 == null) goto L22;
        r14.setVisibility(8);
    L22:
        ((View) this.i.getValue()).setVisibility(8);
        goto L23
    L13:
        if (r12.a != true) goto L15;
        r13 = true;
    L23:
        q r15 = x().d0(q.class);
        if (r15 != null) goto L26;
    L28:
        boolean r16 = false;
    L29:
        if (r16 == false) goto L65;
        View r17 = n(IMMessageKeys$Slots.AVATAR);
        if (r17 != null) goto L34;
    L36:
        boolean r18 = false;
    L37:
        View r3 = n(IMMessageKeys$Slots.SELECT);
        if (r3 == null) goto L55;
        ConstraintLayout.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L42;
        ConstraintLayout.LayoutParams r5 = r4;
    L43:
        if (r5 == null) goto L55;
        r5.leftToRight = 2131377811;
        if (r18 == false) goto L48;
        int r6 = 2131364910;
    L49:
        r5.topToTop = r6;
        if (r18 == false) goto L52;
        int r19 = 2131364910;
    L53:
        r5.bottomToBottom = r19;
        r5.rightToLeft = -1;
        r5.leftToLeft = -1;
        goto L55
    L52:
        r19 = -1;
        goto L53
    L48:
        r6 = 2131364922;
        goto L49
    L42:
        r5 = null;
    L55:
        if (this.f == true) goto L67;
        Context r20 = ((com.ss.android.lark.blueprint.a) this).a.getContext();
        if (x().s8() == false) goto L60;
        float r7 = 28.0f;
    L61:
        int r21 = UIUtils.dp2px(r20, r7);
        Iterator r0 = CollectionsKt.listOf(new Integer[]{2131364922, 2131364915, 2131364927, 2131364923, 2131364910, 2131364926, 2131364914, 2131364917}).iterator();
    L63:
        if (r0.hasNext() == false) goto L68;
        r().findViewById(((Number) r0.next()).intValue()).setTranslationX(r21);
        goto L63
    L68:
        return;
    L60:
        r7 = 0.0f;
        goto L61
    L67:
        return;
    L34:
        if (r17.getVisibility() != 0) goto L36;
        r18 = true;
        goto L37
    L65:
        return;
    L26:
        if (r15.a != true) goto L28;
        r16 = true;
        goto L29
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f
    public final void d(boolean r3) {
        Object r0 = r();
        if ((r0 instanceof InterceptConstraintLayout) == false) goto L5;
        InterceptConstraintLayout r1 = (InterceptConstraintLayout) r0;
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

    @Override // h3b.c
    public final View n(v r2) {
        Intrinsics.checkNotNullParameter(r2, "slotId");
        return s(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f
    public final void setSelected(boolean r2) {
        r().setSelected(r2);
    }

    public View u(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (this.f == false) goto L5;
        int r0 = 2131559307;
    L6:
        View r5 = LayoutInflater.from(r4.getContext()).inflate(r0, r4, false);
        MessageBubbleBodyContainer r1 = (MessageBubbleBodyContainer) r5.findViewById(2131364922);
        if (r1 == null) goto L9;
        r1.setRtl(this.f);
        LKUIRoundLinearLayout r2 = y(r1);
        this.k = r2;
        r1.addView(r2, 0);
    L9:
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        r0 = 2131559306;
        goto L6
    }

    public void update(y6b.a<?> r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        int r0 = b.a;
        com.ss.android.lark.blueprint.g r1 = ((com.ss.android.lark.blueprint.a) this).a;
        View r2 = r();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<*>");
        y6b.c r3 = (y6b.c) r8;
        Intrinsics.checkNotNullParameter(r1, "ctx");
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "item");
        i3b.d r4 = (i3b.d) r1.c.a(i3b.d.class);
        int r5 = 3;
        if (r4 == null) goto L31;
        m2b.a r6 = r4.a();
        if (r6 == null) goto L31;
        if (r6.Y() == false) goto L10;
        int r7 = b.d;
        r2.setPadding(0, r7, 0, r7);
        goto L31
    L10:
        int r9 = r3.R2;
        if (r9 != 0) goto L13;
        r2.setPadding(0, b.a(r6), 0, b.c);
        goto L31
    L13:
        if (r9 != 1) goto L15;
        int r10 = b.a(r6);
        if (r3.r != Message.Status.DELETED) goto L29;
        r3.R2 = 0;
        r2.setPadding(0, r10, 0, b.c);
        goto L31
    L29:
        r2.setPadding(0, r10, 0, b.b);
        goto L31
    L15:
        if (r9 == 2) goto L23;
        if (r9 == 3) goto L19;
        r2.setPadding(0, b.a(r6), 0, b.c);
        goto L31
    L19:
        if (r3.Q2 == false) goto L21;
        r2.setPadding(0, b.b, 0, b.c);
        goto L31
    L21:
        r3.R2 = 0;
        int r11 = b.c;
        r2.setPadding(0, r11, 0, r11);
        goto L31
    L23:
        if (r3.r != Message.Status.DELETED) goto L25;
        r2.setPadding(0, b.b, 0, b.c);
        goto L31
    L25:
        int r12 = b.b;
        r2.setPadding(0, r12, 0, r12);
    L31:
        LKUIRoundLinearLayout r13 = this.k;
        if (r13 != null) goto L34;
        return;
    L34:
        B(r13, r8);
        IMMessageKeys$Slots r14 = IMMessageKeys$Slots.BOTTOM;
        Object r15 = s(r14);
        StackSlot r16 = null;
        if ((r15 instanceof StackSlot) == false) goto L37;
        StackSlot r17 = (StackSlot) r15;
    L38:
        if (r17 == null) goto L40;
        r17.setSpacing(UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 8.0f));
    L40:
        Object r18 = s(r14);
        if ((r18 instanceof StackSlot) == false) goto L43;
        r16 = (StackSlot) r18;
    L43:
        if (r16 != null) goto L45;
    L48:
        ViewGroup r19 = s(IMMessageKeys$Slots.DING_ICON);
        if (r19 != null) goto L51;
        return;
    L51:
        if ((r19.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == true) goto L53;
        return;
    L53:
        return;
    L45:
        if (this.f == false) goto L47;
        r5 = 5;
    L47:
        r16.setGravity(r5);
        goto L48
    L37:
        r17 = null;
        goto L38
    }

    public /* bridge */ /* synthetic */ void update(Object r1) {
        update((y6b.a) r1);
    }

    public a(final com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3);
        this.f = r4;
        this.g = LazyKt.lazy(new AbsBubbleLayout$chatContext$2(r2));
        this.h = LazyKt.lazy(new AbsBubbleLayout$maskView$2(this));
        this.i = LazyKt.lazy(new AbsBubbleLayout$selectSpacer$2(this));
        Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(IMMessageKeys$Slots.AVATAR, 2131364910), TuplesKt.to(IMMessageKeys$Slots.TOP, 2131364927), TuplesKt.to(IMMessageKeys$Slots.CORNER_1, 2131364914), TuplesKt.to(IMMessageKeys$Slots.CORNER_2, 2131364926), TuplesKt.to(IMMessageKeys$Slots.BOTTOM, 2131364915), TuplesKt.to(IMMessageKeys$Slots.DING_ICON, 2131364917), TuplesKt.to(IMMessageKeys$Slots.ROOF, 2131364923), TuplesKt.to(IMMessageKeys$Slots.SELECT, 2131364924)});
        r5.putAll(z());
        this.j = MapsKt.toMap(r5);
    }

    public static void C(a r8, LKUIRoundLinearLayout r9, y6b.a r10) {
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "bodyLayout");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        float[] r11 = f0.a(r10, 10.0f, 2.0f);
        r9.setRadius(r11[0], r11[1], r11[2], r11[3]);
        ((LKUIRoundableLayout) r8.h.getValue()).setRadius(r11[0], r11[1], r11[2], r11[3]);
    }
}
