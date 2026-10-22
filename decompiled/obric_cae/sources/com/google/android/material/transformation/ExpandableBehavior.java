package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5159a;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5161b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ t9.a f5162m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ExpandableBehavior f5163n;

        public a(ExpandableBehavior r8, View r10, int r11, t9.a r12) {
            this.f5163n = r8;
            this.f5160a = r10;
            this.f5161b = r11;
            this.f5162m = r12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            View r8 = this.f5160a;
            r8.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior r10 = this.f5163n;
            if (r10.f5159a != this.f5161b) goto L5;
            t9.a r11 = this.f5162m;
            r10.y((View) r11, r8, r11.a(), false);
        L5:
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f5159a = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean b(CoordinatorLayout r8, View r10, View r11);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean d(CoordinatorLayout r8, View r10, View r11) {
        t9.a r12 = (t9.a) r11;
        boolean r13 = r12.a();
        int r14 = this.f5159a;
        int r15 = 2;
        if (r13 == false) goto L9;
        if (r14 == 0) goto L8;
        if (r14 == 2) goto L8;
    L7:
        boolean r16 = false;
    L11:
        if (r16 == true) goto L13;
        return false;
    L13:
        if (r12.a() == false) goto L15;
        r15 = 1;
    L15:
        this.f5159a = r15;
        y((View) r12, r10, r12.a(), true);
        return true;
    L8:
        r16 = true;
        goto L11
    L9:
        if (r14 != 1) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout r8, View r10, int r11) {
        WeakHashMap<View, h0> r12 = w.f8437a;
        if (w.g.c(r10) == true) goto L26;
        ArrayList r13 = r8.e(r10);
        int r14 = r13.size();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        View r16 = (View) r13.get(r15);
        if (b(r8, r10, r16) == true) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        t9.a r17 = (t9.a) r16;
    L11:
        if (r17 == null) goto L26;
        boolean r18 = r17.a();
        int r19 = this.f5159a;
        int r20 = 2;
        if (r18 == false) goto L19;
        if (r19 == 0) goto L18;
        if (r19 == 2) goto L18;
    L17:
        boolean r21 = false;
    L21:
        if (r21 == false) goto L26;
        if (r17.a() == false) goto L25;
        r20 = 1;
    L25:
        this.f5159a = r20;
        r10.getViewTreeObserver().addOnPreDrawListener(new a(this, r10, r20, r17));
    L18:
        r21 = true;
        goto L21
    L19:
        if (r19 != 1) goto L17;
    L10:
        r17 = null;
    L26:
        return false;
    }

    public abstract void y(View r8, View r10, boolean r11, boolean r12);

    public ExpandableBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f5159a = 0;
    }
}
