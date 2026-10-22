package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.view.View;
import com.ss.android.lark.statistics.Statistics;
import com.suite.lark.platform.component.widget.floatingpanel.impl.FloatPanelHitPoint;
import kotlin.jvm.internal.Intrinsics;
import z5c.b0;
import z5c.l2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements FloatingPanelScrollView.a {
    public final /* synthetic */ FloatingCardContainer a;

    public c(FloatingCardContainer r1) {
        this.a = r1;
    }

    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelScrollView.a
    public final void a(FloatingPanelScrollView r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (r5.getChildCount() == 0) goto L37;
        FloatingCardContainer r0 = this.a;
        if (r0.d == r0.getChildCount()) goto L40;
        int r1 = 0;
        int r2 = (r5.getChildAt(0).getHeight() - r5.getHeight()) - r6;
        if (r6 > r7) goto L10;
        return;
    L10:
        if (r2 < r5.getHeight()) goto L12;
        return;
    L12:
        if (this.a.c != 0) goto L14;
        int r8 = 15;
    L15:
        int r9 = this.a.getChildCount();
        int r10 = 0;
        int r3 = 0;
    L16:
        if (r1 >= r9) goto L30;
        View r4 = this.a.getChildAt(r1);
        if ((r4 instanceof d) == false) goto L20;
        d r11 = (d) r4;
    L21:
        if (r11 == null) goto L29;
        if (r11.b() == false) goto L28;
        r3 = r3 + 1;
        if (r3 < r8) goto L29;
    L28:
        r10 = r10 + 1;
    L29:
        r1 = r1 + 1;
        goto L16
    L20:
        r11 = null;
    L30:
        this.a.d = r10 + r3;
        Long r12 = FloatPanelHitPoint.a;
        Statistics.sendEvent("im_floating_panel_scroll_load_more_click", s5c.d.b.b(b0.c.a(String.valueOf(r10)), l2.c.a(String.valueOf(r3))).toJson());
        return;
    L14:
        r8 = (int) Math.ceil((r5.getHeight() * 1.0f) / this.a.c);
        goto L15
    L40:
        return;
    }
}
