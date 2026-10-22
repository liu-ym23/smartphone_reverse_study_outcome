package com.bytedance.android.live.core.tetris.layer.view.staticlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import d80.d;
import h70.c;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/view/staticlayout/StaticFullScreenViewLayer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StaticFullScreenViewLayer extends ConstraintLayout {
    public final boolean a;
    public final Set<View> b;
    public final Set<View> c;

    public final void requestLayout() {
        super.requestLayout();
    }

    public StaticFullScreenViewLayer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        int r3 = d.a;
        boolean r0 = true;
        if ((d.a & 1) > 0) goto L6;
        r0 = false;
    L6:
        this.a = r0;
        this.b = new HashSet();
        this.c = new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addView(View r1) {
        super/*android.view.ViewGroup*/.addView(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addView(View r1, int r2) {
        super/*android.view.ViewGroup*/.addView(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r12, int r13) {
        if (this.a == false) goto L27;
        int r0 = c.a;
        int r1 = View.MeasureSpec.getSize(r13);
        int r2 = View.MeasureSpec.getSize(r12);
        int r3 = getChildCount();
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L26;
        View r5 = getChildAt(r4);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ConstraintLayout.LayoutParams) == true) goto L9;
        r6 = null;
    L9:
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        if (r7 == null) goto L25;
        if (((ViewGroup.MarginLayoutParams) r7).width != (-1)) goto L18;
        if (((ViewGroup.MarginLayoutParams) r7).height != (-1)) goto L18;
        ((HashSet) this.c).add(r5);
        ((ViewGroup.MarginLayoutParams) r7).width = (r2 - ((ViewGroup.MarginLayoutParams) r7).leftMargin) - ((ViewGroup.MarginLayoutParams) r7).rightMargin;
        ((ViewGroup.MarginLayoutParams) r7).height = (r1 - ((ViewGroup.MarginLayoutParams) r7).topMargin) - ((ViewGroup.MarginLayoutParams) r7).bottomMargin;
        int r8 = c.a;
    L18:
        if (((HashSet) this.b).contains(r5) == false) goto L25;
        int r9 = ((ViewGroup.MarginLayoutParams) r7).width;
        int r11 = ((ViewGroup.MarginLayoutParams) r7).leftMargin;
        int r14 = ((ViewGroup.MarginLayoutParams) r7).rightMargin;
        if (r9 == ((r2 - r11) - r14)) goto L22;
    L24:
        ((ViewGroup.MarginLayoutParams) r7).width = (r2 - r11) - r14;
        ((ViewGroup.MarginLayoutParams) r7).height = (r1 - ((ViewGroup.MarginLayoutParams) r7).topMargin) - ((ViewGroup.MarginLayoutParams) r7).bottomMargin;
        ((HashSet) this.c).add(r5);
        goto L25
    L22:
        if (((ViewGroup.MarginLayoutParams) r7).height != ((r1 - ((ViewGroup.MarginLayoutParams) r7).topMargin) - ((ViewGroup.MarginLayoutParams) r7).bottomMargin)) goto L24;
        ((HashSet) this.c).add(r5);
    L25:
        r4 = r4 + 1;
        goto L5
    L26:
        ((HashSet) this.b).clear();
        this.b.addAll(this.c);
        ((HashSet) this.c).clear();
    L27:
        super.onMeasure(r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addView(View r1, ViewGroup.LayoutParams r2) {
        super/*android.view.ViewGroup*/.addView(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addView(View r1, int r2, int r3) {
        super/*android.view.ViewGroup*/.addView(r1, r2, r3);
    }

    public final void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
    }
}
