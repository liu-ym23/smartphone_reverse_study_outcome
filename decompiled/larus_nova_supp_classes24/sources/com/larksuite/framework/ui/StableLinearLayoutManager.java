package com.larksuite.framework.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class StableLinearLayoutManager extends LinearLayoutManager {
    public final boolean a;
    public b b;
    public boolean c;

    public void p(Throwable r1) {
    }

    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public final void requestLayout() {
        if (this.c == false) goto L5;
        return;
    L5:
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.requestLayout();
    }

    public StableLinearLayoutManager(Context r1) {
        super(r1);
    }

    public final void onLayoutCompleted(RecyclerView.State r1) {
        super.onLayoutCompleted(r1);
        b r2 = this.b;
        if (r2 == null) goto L6;
        r2.onLayoutComplete();
        return;
    }

    public StableLinearLayoutManager(Context r2, Object r3) {
        super(r2, 1, false);
        this.a = false;
    }

    public void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        if (r3 != null) goto L5;
        p(new NullPointerException("RecyclerView.State is null during layout"));
        return;
    L5:
        b r0 = this.b;
        if (r0 == null) goto L15;
        r0.a();
    L15:
        super.onLayoutChildren(r2, r3);     // Catch: IndexOutOfBoundsException -> L10
    L12:
        if (r0 == null) goto L17;
        r0.b();
        return;
    L17:
        return;
    L10:
        e = move-exception;
        p(e);
        goto L12
    }

    public StableLinearLayoutManager(Context r2, int r3) {
        super(r2, 1, false);
    }

    public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        super.scrollHorizontallyBy(r1, r2, r3);     // Catch: IndexOutOfBoundsException -> L4
        return 0;
    L4:
        e = move-exception;
        e.printStackTrace();
        p(e);
        return 0;
    }

    public int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return super.scrollVerticallyBy(r1, r2, r3);
    L4:
        e = move-exception;
        e.printStackTrace();
        p(e);
        return 0;
    }

    public StableLinearLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    public final boolean requestChildRectangleOnScreen(RecyclerView r2, View r3, Rect r4, boolean r5) {
        if (this.a == true) goto L5;
        return false;
    L5:
        return super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.requestChildRectangleOnScreen(r2, r3, r4, r5);
    }

    public final boolean requestChildRectangleOnScreen(RecyclerView r2, View r3, Rect r4, boolean r5, boolean r6) {
        if (this.a == true) goto L5;
        return false;
    L5:
        return super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.requestChildRectangleOnScreen(r2, r3, r4, r5, r6);
    }
}
