package com.larus.bmhome.chat.component.bottom.core.inputtext.project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.x0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public final InputPanelListView a;
    public Function0<Unit> b;
    public int c;
    public int d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final FrameLayout i;

    public static final class a {
    }

    static {
    }

    public final void a() {
        int r0 = this.d;
        if (r0 > 0) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceAtMost(r0, this.c);
        ViewGroup.LayoutParams r2 = this.h.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L8;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
    L9:
        if (r3 != null) goto L12;
        this.h.setLayoutParams(new FrameLayout.LayoutParams(-1, r1));
        return;
    L12:
        if (r3.height == r1) goto L16;
        r3.height = r1;
        this.h.setLayoutParams(r3);
        return;
    L16:
        return;
    L8:
        r3 = null;
        goto L9
    }

    public h(ViewGroup r17, final x0 r18) {
        Intrinsics.checkNotNullParameter(r17, "panelContainer");
        Intrinsics.checkNotNullParameter(r18, "onCloseClick");
        Context r3 = r17.getContext();
        this.a = new InputPanelListView(r3);
        this.c = c7.b(360);
        LinearLayout r4 = new LinearLayout(r3);
        r4.setOrientation(1);
        this.e = r4;
        final ScrollView r6 = new ScrollView(r3);
        r6.setOnScrollChangeListener(new f(r6, this));
        r6.addView(r4, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout r5 = new LinearLayout(r3);
        r5.setOrientation(1);
        r5.setPadding(0, c7.b(4), 0, 0);
        this.f = r5;
        LinearLayout r7 = new LinearLayout(r3);
        r7.setOrientation(1);
        this.g = r7;
        LinearLayout r11 = new LinearLayout(r3);
        r11.setOrientation(1);
        FrameLayout r12 = new FrameLayout(r11.getContext());
        View r13 = new View(r12.getContext());
        r13.setBackgroundColor(ContextCompat.getColor(r13.getContext(), v19.c.b(2130972086, r13.getContext(), 2131103159)));
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, 1);
        r9.gravity = 16;
        r9.setMarginStart(c7.b(18));
        r9.setMarginEnd(c7.b(18));
        Unit r10 = Unit.INSTANCE;
        r12.addView(r13, r9);
        r11.addView(r12, new LinearLayout.LayoutParams(-1, c7.b(6)));
        r11.addView(r7, new LinearLayout.LayoutParams(-1, -2));
        r11.setPadding(0, 0, 0, c7.b(6));
        LinearLayout r8 = new LinearLayout(r3);
        r8.setOrientation(1);
        r8.addView(r5, new LinearLayout.LayoutParams(-1, -2));
        r8.addView(r6, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r8.addView(r11, new LinearLayout.LayoutParams(-1, -2));
        this.h = r8;
        FrameLayout r14 = new FrameLayout(r3);
        r14.setVisibility(8);
        r14.addView(r8, new FrameLayout.LayoutParams(-1, -2));
        ImageView r15 = new ImageView(r14.getContext());
        r15.setImageResource(2131241416);
        r15.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(c7.b(24), c7.b(24));
        r16.gravity = 8388661;
        r16.topMargin = c7.b(12);
        r16.setMarginEnd(c7.b(12));
        r15.setLayoutParams(r16);
        r15.setOnClickListener(new g(r18));
        r14.addView(r15);
        this.i = r14;
        r17.addView(r14, new FrameLayout.LayoutParams(-1, -2));
    }
}
