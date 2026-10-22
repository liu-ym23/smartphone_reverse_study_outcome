package com.lynx.tasm.behavior.ui.list;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ListLayoutManager {

    public static class ListGridLayoutManager extends GridLayoutManager implements a {
        public final UIList a;
        public int b;
        public float c;
        public float d;

        public final boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public final boolean canScrollHorizontally() {
            if (this.a.o == true) goto L7;
            return false;
        L7:
            return super/*androidx.recyclerview.widget.LinearLayoutManager*/.canScrollHorizontally();
        }

        public final boolean canScrollVertically() {
            if (this.a.o == true) goto L7;
            return false;
        L7:
            return super/*androidx.recyclerview.widget.LinearLayoutManager*/.canScrollVertically();
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.a
        public final float f() {
            return this.d;
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.a
        public final float g() {
            return this.c;
        }

        public final void onLayoutCompleted(RecyclerView.State r1) {
            super.onLayoutCompleted(r1);
            this.a.Y();
        }

        public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
            float r4 = super.scrollHorizontallyBy(r1, r2, r3);
            this.d = r4;
            this.a.i.m(r1, (int) r4);
            return (int) this.d;
        }

        public final int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
            float r4 = super.scrollVerticallyBy(r1, r2, r3);
            this.c = r4;
            this.a.i.m(r1, (int) r4);
            return (int) this.c;
        }

        public ListGridLayoutManager(LynxContext r1, int r2, int r3, UIList r4) {
            super(r1, r2);
            this.b = r3;
            this.a = r4;
        }

        public final void layoutDecoratedWithMargins(View r7, int r8, int r9, int r10, int r11) {
            if (1 == getOrientation()) goto L5;
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecoratedWithMargins(r7, r8, r9, r10, r11);
            return;
        L5:
            if (r7.getLayoutParams().getSpanSize() == getSpanCount()) goto L11;
            UIList r0 = this.a;
            if (r0.R == true) goto L9;
            r8 = ListLayoutManager.b(r0, getSpanCount(), this.b, r8, r10);
            r10 = r7.getMeasuredWidth() + r8;
        L9:
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecoratedWithMargins(r7, r8, r9, r10, r11);
            return;
        L11:
            ListLayoutManager.a(this, r7, r9, r11, this.a.R);
        }
    }

    public static class ListLinearLayoutManager extends LinearLayoutManager implements a {
        public final UIList a;
        public float b;
        public float c;

        public final boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public final boolean canScrollHorizontally() {
            if (this.a.o == true) goto L7;
            return false;
        L7:
            return super.canScrollHorizontally();
        }

        public final boolean canScrollVertically() {
            if (this.a.o == true) goto L7;
            return false;
        L7:
            return super.canScrollVertically();
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.a
        public final float f() {
            return this.c;
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.a
        public final float g() {
            return this.b;
        }

        public final void onLayoutCompleted(RecyclerView.State r1) {
            super.onLayoutCompleted(r1);
            this.a.Y();
        }

        public ListLinearLayoutManager(LynxContext r1, UIList r2) {
            super(r1);
            this.a = r2;
        }

        public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
            float r4 = super.scrollHorizontallyBy(r1, r2, r3);
            this.c = r4;
            this.a.i.m(r1, (int) r4);
            return (int) this.c;
        }

        public final int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
            float r4 = super.scrollVerticallyBy(r1, r2, r3);
            this.b = r4;
            this.a.i.m(r1, (int) r4);
            return (int) this.b;
        }

        public final void layoutDecoratedWithMargins(View r3, int r4, int r5, int r6, int r7) {
            if (1 != getOrientation()) goto L11;
            int r0 = r3.getLayoutParams().getViewAdapterPosition();
            UIListAdapter r1 = this.a.c;
            if (r1 != null) goto L7;
        L10:
            ListLayoutManager.a(this, r3, r5, r7, this.a.R);
            return;
        L7:
            if (r1.F2(r0) == true) goto L10;
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecoratedWithMargins(r3, r4, r5, r6, r7);
            return;
        L11:
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecoratedWithMargins(r3, r4, r5, r6, r7);
        }
    }

    public interface a {
        float f();

        float g();
    }

    public static class b extends StaggeredGridLayoutManager implements a {
        public final UIList a;
        public int b;

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.a
        public final float f() {
            return 0.0f;
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.a
        public final float g() {
            return 0.0f;
        }

        public final boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public final boolean canScrollHorizontally() {
            if (this.a.o == true) goto L7;
            return false;
        L7:
            return super.canScrollHorizontally();
        }

        public final boolean canScrollVertically() {
            if (this.a.o == true) goto L7;
            return false;
        L7:
            return super.canScrollVertically();
        }

        public final void onLayoutCompleted(RecyclerView.State r1) {
            super.onLayoutCompleted(r1);
            this.a.Y();
        }

        public final void onScrollStateChanged(int r2) {
            super.onScrollStateChanged(r2);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            LLog.e("ListStaggeredGridLayoutManager", e.getMessage());
        }

        public b(int r2, int r3, UIList r4) {
            super(r2, 1);
            this.b = r3;
            this.a = r4;
        }

        public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
            int r4 = super.scrollHorizontallyBy(r1, r2, r3);     // Catch: NullPointerException -> L4
            this.a.i.m(r1, r4);     // Catch: NullPointerException -> L4
            return r4;
        L4:
            return 0;
        }

        public final int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
            int r4 = super.scrollVerticallyBy(r1, r2, r3);     // Catch: NullPointerException -> L4
            this.a.i.m(r1, r4);     // Catch: NullPointerException -> L4
            return r4;
        L4:
            return 0;
        }

        public final void layoutDecoratedWithMargins(View r7, int r8, int r9, int r10, int r11) {
            StaggeredGridLayoutManager.LayoutParams r0 = r7.getLayoutParams();
            if (1 == getOrientation()) goto L5;
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecoratedWithMargins(r7, r8, r9, r10, r11);
            return;
        L5:
            if (r0.isFullSpan() == true) goto L10;
            UIList r1 = this.a;
            if (r1.R == true) goto L9;
            r8 = ListLayoutManager.b(r1, getSpanCount(), this.b, r8, r10);
            r10 = r7.getMeasuredWidth() + r8;
        L9:
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecoratedWithMargins(r7, r8, r9, r10, r11);
            return;
        L10:
            ListLayoutManager.a(this, r7, r9, r11, this.a.R);
        }
    }

    public static void a(RecyclerView.LayoutManager r9, View r10, int r11, int r12, boolean r13) {
        int r0 = r9.getWidth();
        int r1 = r10.getMeasuredWidth();
        int r2 = r9.getPaddingLeft();
        int r3 = r9.getPaddingRight();
        int r4 = r0 - r1;
        if (r4 > 0) goto L5;
        int r5 = 0;
    L10:
        int r7 = r5 + r10.getMeasuredWidth();
        if (r13 == false) goto L13;
        r9.layoutDecorated(r10, r5, r11, r7, r12);
        return;
    L13:
        r10.layout(r5, r11, r7, r12);
        return;
    L5:
        int r6 = r3 + r2;
        int r8 = r4 - r6;
        if (r8 >= 0) goto L9;
        r2 = r2 + ((int) (r8 * (((double) r2) / ((double) r6))));
    L9:
        r5 = r2;
        goto L10
    }

    public static int b(UIList r2, int r3, int r4, int r5, int r6) {
        if (r4 <= 0) goto L11;
        if (r2 != null) goto L5;
        return r5;
    L5:
        if (r2.V() == null) goto L13;
        RecyclerView r7 = r2.V();
        int r0 = r7.getPaddingLeft();
        int r1 = r7.getPaddingRight();
        int r8 = ((r7.getWidth() - r0) - r1) / r3;
        if (r8 != 0) goto L9;
        LLog.i("ListLayoutManager", "the width of list maybe 0 ");
        return r5;
    L9:
        int r9 = r4 + (r6 - r5);
        return (r9 * ((r5 - r0) / r8)) + r0;
    L13:
        return r5;
    L11:
        return r5;
    }
}
