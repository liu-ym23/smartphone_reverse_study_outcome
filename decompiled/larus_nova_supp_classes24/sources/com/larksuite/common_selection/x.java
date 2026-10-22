package com.larksuite.common_selection;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x implements s {
    public final Point a;

    @Override // com.larksuite.common_selection.s
    public final int a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return 1;
    }

    @Override // com.larksuite.common_selection.s
    public final boolean h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return true;
    }

    @Override // com.larksuite.common_selection.s
    public final boolean i(View r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return true;
    }

    public x() {
        this.a = new Point();
    }

    @Override // com.larksuite.common_selection.s
    public final float j(o r2) {
        Intrinsics.checkNotNullParameter(r2, "point");
        return 0.0f;
    }

    @Override // com.larksuite.common_selection.s
    public final Point d(o r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "point");
        View r7 = r5.a;
        if (r7 == null) goto L5;
        int r0 = r7.getLeft();
        int r1 = r7.getTop();
        int r2 = 0;
        if (r5.b <= 0) goto L9;
        boolean r8 = true;
    L10:
        Point r3 = this.a;
        if (r8 == false) goto L13;
        r2 = r7.getWidth();
    L13:
        r3.x = r0 + r2;
        Point r9 = this.a;
        r9.y = r1 + r7.getHeight();
        return this.a;
    L9:
        r8 = false;
        goto L10
    L5:
        return new Point();
    }

    @Override // com.larksuite.common_selection.s
    public final p b(View r2, o r3, SelectionGranularity r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "point");
        Intrinsics.checkNotNullParameter(r4, "granularity");
        return new p(new o(r2, 0), new o(r2, 1));
    }

    @Override // com.larksuite.common_selection.s
    public final e c(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        int r5 = w.a;
        Intrinsics.checkNotNullParameter(r2, "view");
        Object r6 = r2.getTag(2131388132);
        if ((r6 instanceof e) == false) goto L5;
        e r7 = (e) r6;
    L6:
        if (r7 == null) goto L9;
        return r7;
    L9:
        if ((r2 instanceof ImageView) == true) goto L11;
        return null;
    L11:
        return new e(((ImageView) r2).getContext().getString(2131891845));
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larksuite.common_selection.s
    public final o g(View r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r2 >= (r1.getWidth() / 2)) goto L5;
        int r4 = 0;
    L7:
        return new o(r1, r4);
    L5:
        r4 = 1;
        goto L7
    }

    @Override // com.larksuite.common_selection.s
    public final void e(View r2, int r3, int r4, Path r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "outPath");
        RectF r6 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        r5.reset();
        r5.addRect(r6, Path.Direction.CW);
    }

    @Override // com.larksuite.common_selection.s
    public final float f(View r8, float r9, float r10, o r11) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r11, "point");
        float r0 = RangesKt.coerceAtLeast(r8.getWidth(), 1.0f);
        float r12 = RangesKt.coerceAtLeast(r8.getHeight(), 1.0f);
        float r2 = RangesKt.coerceIn(r9, 0.0f, r0);
        double r5 = 2;
        float r13 = ((float) Math.pow(r9 - r2, r5)) + ((float) Math.pow(r10 - RangesKt.coerceIn(r10, 0.0f, r12), r5));
        if (r11.b <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L10;
        r0 = 0.0f;
    L10:
        return r13 + (((float) Math.pow(r2 - r0, r5)) * 0.5f);
    L5:
        r14 = false;
        goto L6
    }
}
