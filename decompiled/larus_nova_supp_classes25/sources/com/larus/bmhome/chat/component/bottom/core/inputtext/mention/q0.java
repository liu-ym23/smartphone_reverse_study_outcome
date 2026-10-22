package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelDragController;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 {
    public final MentionPanelListView a;
    public final com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n b;
    public final TextView c;
    public final InputPanelDragController d;
    public boolean e;

    public final void b() {
        MentionPanelListView r0 = this.a;
        if (r0.h != null) goto L31;
        Integer r1 = Integer.valueOf(r0.u.getHeight());
        boolean r3 = false;
        if (r1.intValue() <= 0) goto L8;
        boolean r2 = true;
    L9:
        Integer r5 = null;
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 != null) goto L28;
        ViewGroup.LayoutParams r4 = r0.u.getLayoutParams();
        if (r4 == null) goto L22;
        r1 = Integer.valueOf(r4.height);
        if (r1.intValue() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
    L23:
        if (r1 != null) goto L28;
        r1 = Integer.valueOf(r0.i);
        if (r1.intValue() <= 0) goto L27;
        r3 = true;
    L27:
        if (r3 == true) goto L28;
    L29:
        r0.h = r5;
        return;
    L19:
        r6 = false;
    L22:
        r1 = null;
    L28:
        r5 = r1;
        goto L29
    L8:
        r2 = false;
        goto L9
    }

    public final MentionPanelListView.f a(MentionPanelSection r15) {
        Intrinsics.checkNotNullParameter(r15, "section");
        MentionPanelListView r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r15, "section");
        r1.u.stopScroll();
        LinearLayoutManager r0 = r1.u.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r2 = r0;
    L6:
        if (r2 == null) goto L63;
        int r3 = r1.u.getPaddingTop() + r1.e;
        int r4 = r1.u.getChildCount();
        int r6 = Integer.MAX_VALUE;
        MentionPanelListView.f r8 = null;
        int r7 = 0;
    L9:
        if (r7 >= r4) goto L53;
        View r9 = r1.u.getChildAt(r7);
        int r10 = r2.getDecoratedTop(r9);
        if (r10 < r3) goto L51;
        if (r10 >= r1.u.getHeight()) goto L51;
        if (r10 >= r6) goto L51;
        int r11 = r1.u.getChildAdapterPosition(r9);
        Object r12 = CollectionsKt.getOrNull(r1.d.a, r11);
        if ((r12 instanceof y.d) == false) goto L19;
        y.d r13 = (y.d) r12;
    L20:
        if (r13 == null) goto L22;
        g0 r14 = r13.c;
    L23:
        if (r14 == null) goto L51;
        boolean r16 = true;
        if (r14.a != r15) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == true) goto L31;
        r14 = null;
    L31:
        if (r14 == null) goto L51;
        MentionPanelListView.PanelAdapter r18 = r1.d;
    L34:
        if ((-1) >= r11) goto L39;
        if ((CollectionsKt.getOrNull(r18.a, r11) instanceof y.a) == true) goto L37;
        r11 = r11 - 1;
        goto L34
    L37:
        Integer r19 = Integer.valueOf(r11);
    L40:
        if (r19 == null) goto L42;
        View r20 = r2.findViewByPosition(r19.intValue());
    L43:
        int r110 = r10 - r1.u.getPaddingTop();
        if (r19 == null) goto L49;
        if (r20 != null) goto L47;
    L50:
        r8 = new MentionPanelListView.f(r14, r110, r16);
        r6 = r10;
        goto L51
    L47:
        if (r20.getTop() <= r1.u.getPaddingTop()) goto L50;
    L49:
        r16 = false;
        goto L50
    L42:
        r20 = null;
        goto L43
    L39:
        r18.getClass();
        r19 = null;
        goto L40
    L27:
        r17 = false;
        goto L28
    L22:
        r14 = null;
        goto L23
    L19:
        r13 = null;
    L51:
        r7 = r7 + 1;
        goto L9
    L53:
        return r8;
    L63:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public final void c(MentionPanelListView.f r3) {
        MentionPanelListView r0 = this.a;
        r0.f(true);
        if (r3 != null) goto L5;
    L7:
        MentionPanelListView.f r1 = null;
    L8:
        r0.p = r1;
        r0.d(r3);
        return;
    L5:
        if (r3.c == false) goto L7;
        r1 = r3;
        goto L8
    }

    public q0(ViewGroup r11, final com.larus.bmhome.chat.component.bottom.core.inputtext.t0 r12) {
        Intrinsics.checkNotNullParameter(r11, "panelContainer");
        Intrinsics.checkNotNullParameter(r12, "onCloseClick");
        Context r0 = r11.getContext();
        MentionPanelListView r1 = new MentionPanelListView(r0, new MentionPanelView$listView$1(this));
        this.a = r1;
        com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n r4 = new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n(r0);
        r4.setVisibility(8);
        this.b = r4;
        View r3 = LayoutInflater.from(r0).inflate(2131562603, r4, false);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.TextView");
        TextView r5 = (TextView) r3;
        r5.setVisibility(8);
        r5.setTypeface(Typeface.create("sans-serif-medium", 0));
        r5.setPaddingRelative(r5.getPaddingStart(), r5.getPaddingTop() + r1.t, r5.getPaddingEnd(), r5.getPaddingBottom());
        this.c = r5;
        r4.addView(r1.u, new FrameLayout.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r2 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r2;
        r6.topMargin = 0;
        r6.height += r1.t;
        Unit r7 = Unit.INSTANCE;
        r4.addView(r5, r6);
        ImageView r8 = new ImageView(r0);
        r8.setImageResource(2131241416);
        r8.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r8.setContentDescription("关闭");
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(c7.b(24), c7.b(24));
        r9.gravity = 8388661;
        r9.topMargin = c7.b(16);
        r9.setMarginEnd(c7.b(16));
        r8.setLayoutParams(r9);
        r8.setOnClickListener(new p0(r12));
        r4.addView(r8);
        r11.addView(r4, new FrameLayout.LayoutParams(-1, -2));
        this.d = new InputPanelDragController(r4, r1.u, new MentionPanelView$2(r1), r12, new o0(this), new MentionPanelView$3(r1));
    }
}
