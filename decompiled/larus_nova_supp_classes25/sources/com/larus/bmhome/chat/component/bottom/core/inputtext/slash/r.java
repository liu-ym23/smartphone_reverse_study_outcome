package com.larus.bmhome.chat.component.bottom.core.inputtext.slash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelDragController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.y0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public final Function0<Unit> a;
    public final InputPanelListView b;
    public final int c;
    public final com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n d;
    public final InputPanelDragController e;

    public r(ViewGroup r13, final y0 r14) {
        Intrinsics.checkNotNullParameter(r13, "panelContainer");
        Intrinsics.checkNotNullParameter(r14, "onCloseClick");
        this.a = r14;
        Context r0 = r13.getContext();
        InputPanelListView r1 = new InputPanelListView(r0);
        this.b = r1;
        int r2 = c7.b(4);
        this.c = r2;
        com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n r10 = new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n(r0);
        r10.setVisibility(8);
        View r3 = r1.g;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -1);
        r4.topMargin = r2;
        Unit r5 = Unit.INSTANCE;
        r10.addView(r3, r4);
        ImageView r6 = new ImageView(r0);
        r6.setImageResource(2131241416);
        r6.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(c7.b(24), c7.b(24));
        r7.gravity = 8388661;
        r7.topMargin = c7.b(16);
        r7.setMarginEnd(c7.b(16));
        r6.setLayoutParams(r7);
        r6.setOnClickListener(new q(r14));
        r10.addView(r6);
        this.d = r10;
        this.e = new InputPanelDragController(r10, r1.g, new p(this), r14, com.larus.bmhome.chat.component.bottom.core.inputtext.panel.h.a, new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.c());
        r13.addView(r10, new FrameLayout.LayoutParams(-1, -2));
    }
}
