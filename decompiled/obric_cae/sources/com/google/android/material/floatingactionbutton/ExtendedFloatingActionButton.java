package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;
import h9.g;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f4749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f4750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4751c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f4750b = false;
            this.f4751c = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ boolean a(View r8) {
            ExtendedFloatingActionButton r10 = (ExtendedFloatingActionButton) r8;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void c(CoordinatorLayout.f r8) {
            if (r8.f1570h != 0) goto L6;
            r8.f1570h = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean d(CoordinatorLayout r8, View r10, View r11) {
            ExtendedFloatingActionButton r12 = (ExtendedFloatingActionButton) r10;
            if ((r11 instanceof AppBarLayout) == false) goto L5;
            y(r8, (AppBarLayout) r11, r12);
        L11:
            return false;
        L5:
            ViewGroup.LayoutParams r13 = r11.getLayoutParams();
            if ((r13 instanceof CoordinatorLayout.f) == false) goto L8;
            boolean r14 = ((CoordinatorLayout.f) r13).f1563a instanceof BottomSheetBehavior;
        L9:
            if (r14 == false) goto L11;
            z(r11, r12);
            goto L11
        L8:
            r14 = false;
            goto L9
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout r8, View r10, int r11) {
            ExtendedFloatingActionButton r12 = (ExtendedFloatingActionButton) r10;
            ArrayList r13 = r8.e(r12);
            int r14 = r13.size();
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L14;
            View r16 = (View) r13.get(r15);
            if ((r16 instanceof AppBarLayout) == false) goto L7;
            y(r8, (AppBarLayout) r16, r12);
        L13:
            r15 = r15 + 1;
            goto L3
        L7:
            ViewGroup.LayoutParams r17 = r16.getLayoutParams();
            if ((r17 instanceof CoordinatorLayout.f) == false) goto L10;
            boolean r18 = ((CoordinatorLayout.f) r17).f1563a instanceof BottomSheetBehavior;
        L11:
            if (r18 == false) goto L13;
            z(r16, r12);
            goto L13
        L10:
            r18 = false;
            goto L11
        L14:
            r8.q(r12, r11);
            return true;
        }

        public final void y(CoordinatorLayout r8, AppBarLayout r10, ExtendedFloatingActionButton r11) {
            CoordinatorLayout.f r12 = (CoordinatorLayout.f) r11.getLayoutParams();
            boolean r13 = this.f4750b;
            int r14 = 1;
            int r15 = 0;
            boolean r16 = this.f4751c;
            if (r13 == true) goto L7;
            if (r16 == true) goto L7;
        L8:
            boolean r17 = false;
        L10:
            if (r17 == true) goto L13;
            return;
        L13:
            if (this.f4749a != null) goto L15;
            this.f4749a = new Rect();
        L15:
            Rect r18 = this.f4749a;
            com.google.android.material.internal.d.a(r8, r10, r18);
            if (r18.bottom > r10.getMinimumHeightForVisibleOverlappingContent()) goto L21;
            if (r16 == false) goto L19;
            r14 = 2;
        L19:
            ExtendedFloatingActionButton.e(r11, r14);
            throw null;
        L21:
            if (r16 == false) goto L23;
            r15 = 3;
        L23:
            ExtendedFloatingActionButton.e(r11, r15);
            throw null;
        L7:
            if (r12.f1568f != r10.getId()) goto L8;
            r17 = true;
            goto L10
        }

        public final void z(View r8, ExtendedFloatingActionButton r10) {
            CoordinatorLayout.f r11 = (CoordinatorLayout.f) r10.getLayoutParams();
            boolean r12 = this.f4750b;
            int r13 = 1;
            int r14 = 0;
            boolean r15 = this.f4751c;
            if (r12 == true) goto L7;
            if (r15 == true) goto L7;
        L8:
            boolean r16 = false;
        L10:
            if (r16 == true) goto L13;
            return;
        L13:
            if (r8.getTop() >= ((r10.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) r10.getLayoutParams())).topMargin)) goto L18;
            if (r15 == false) goto L16;
            r13 = 2;
        L16:
            ExtendedFloatingActionButton.e(r10, r13);
            throw null;
        L18:
            if (r15 == false) goto L20;
            r14 = 3;
        L20:
            ExtendedFloatingActionButton.e(r10, r14);
            throw null;
        L7:
            if (r11.f1568f != r8.getId()) goto L8;
            r16 = true;
            goto L10
        }

        public ExtendedFloatingActionButtonBehavior(Context r8, AttributeSet r10) {
            super(r8, r10);
            TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7766g);
            this.f4750b = r11.getBoolean(0, false);
            this.f4751c = r11.getBoolean(1, true);
            r11.recycle();
        }
    }

    public class a extends Property<View, Float> {
        public a() {
            super(Float.class, AIMediaEventSchema.FIELD_WIDTH);
        }

        @Override // android.util.Property
        public final Float get(View r8) {
            return Float.valueOf(r8.getLayoutParams().width);
        }

        @Override // android.util.Property
        public final void set(View r8, Float r10) {
            View r11 = r8;
            ViewGroup.LayoutParams r12 = r11.getLayoutParams();
            r12.width = r10.intValue();
            r11.requestLayout();
        }
    }

    public class b extends Property<View, Float> {
        public b() {
            super(Float.class, AIMediaEventSchema.FIELD_HEIGHT);
        }

        @Override // android.util.Property
        public final Float get(View r8) {
            return Float.valueOf(r8.getLayoutParams().height);
        }

        @Override // android.util.Property
        public final void set(View r8, Float r10) {
            View r11 = r8;
            ViewGroup.LayoutParams r12 = r11.getLayoutParams();
            r12.height = r10.intValue();
            r11.requestLayout();
        }
    }

    public class c extends Property<View, Float> {
        public c() {
            super(Float.class, "paddingStart");
        }

        @Override // android.util.Property
        public final Float get(View r8) {
            WeakHashMap<View, h0> r10 = w.f8437a;
            return Float.valueOf(w.e.f(r8));
        }

        @Override // android.util.Property
        public final void set(View r8, Float r10) {
            View r11 = r8;
            int r12 = r10.intValue();
            int r13 = r11.getPaddingTop();
            WeakHashMap<View, h0> r14 = w.f8437a;
            w.e.k(r11, r12, r13, w.e.e(r11), r11.getPaddingBottom());
        }
    }

    public class d extends Property<View, Float> {
        public d() {
            super(Float.class, "paddingEnd");
        }

        @Override // android.util.Property
        public final Float get(View r8) {
            WeakHashMap<View, h0> r10 = w.f8437a;
            return Float.valueOf(w.e.e(r8));
        }

        @Override // android.util.Property
        public final void set(View r8, Float r10) {
            View r11 = r8;
            WeakHashMap<View, h0> r12 = w.f8437a;
            w.e.k(r11, w.e.f(r11), r11.getPaddingTop(), r10.intValue(), r11.getPaddingBottom());
        }
    }

    static {
        new a();
        new b();
        new c();
        new d();
    }

    public static void e(ExtendedFloatingActionButton r8, int r10) {
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L12;
        if (r10 == 2) goto L12;
        if (r10 == 3) goto L12;
        throw new IllegalStateException(defpackage.a.d("Unknown strategy type: ", r10));
    L12:
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return 0;
    }

    public g getExtendMotionSpec() {
        throw null;
    }

    public g getHideMotionSpec() {
        throw null;
    }

    public g getShowMotionSpec() {
        throw null;
    }

    public g getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAnimateShowBeforeLayout(boolean r8) {
    }

    public void setExtendMotionSpec(g r8) {
        throw null;
    }

    public void setExtendMotionSpecResource(int r8) {
        setExtendMotionSpec(g.a(getContext(), r8));
    }

    public void setExtended(boolean r8) {
        if (r8 == true) goto L5;
        return;
    L5:
        throw null;
    }

    public void setHideMotionSpec(g r8) {
        throw null;
    }

    public void setHideMotionSpecResource(int r8) {
        setHideMotionSpec(g.a(getContext(), r8));
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r8, int r10, int r11, int r12) {
        super.setPadding(r8, r10, r11, r12);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int r8, int r10, int r11, int r12) {
        super.setPaddingRelative(r8, r10, r11, r12);
    }

    public void setShowMotionSpec(g r8) {
        throw null;
    }

    public void setShowMotionSpecResource(int r8) {
        setShowMotionSpec(g.a(getContext(), r8));
    }

    public void setShrinkMotionSpec(g r8) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int r8) {
        setShrinkMotionSpec(g.a(getContext(), r8));
    }

    @Override // android.widget.TextView
    public void setTextColor(int r8) {
        super.setTextColor(r8);
        getTextColors();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList r8) {
        super.setTextColor(r8);
        getTextColors();
    }
}
