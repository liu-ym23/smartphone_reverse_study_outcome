package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e6 extends i4 {
    public final int a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        setClipChildren(false);
        setClipToPadding(false);
        ViewParent r1 = getParent();
        int r2 = 0;
    L4:
        if ((r1 instanceof ViewGroup) == false) goto L8;
        if (r2 >= 3) goto L11;
        ViewGroup r3 = (ViewGroup) r1;
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        r1 = r3.getParent();
        r2 = r2 + 1;
        goto L4
    L11:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        post(new d6(this));
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r2) {
        super.onViewAdded(r2);
        a();
        if ((r2 instanceof ViewGroup) == false) goto L5;
        ViewGroup r3 = (ViewGroup) r2;
    L6:
        if (r3 == null) goto L9;
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public e6(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        a();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r5);
        if (r0 == Integer.MIN_VALUE) goto L8;
        if (r0 != 0) goto L10;
        r5 = View.MeasureSpec.makeMeasureSpec(this.a, 1073741824);
    L10:
        super.onMeasure(r4, r5);
        return;
    L8:
        if (View.MeasureSpec.getSize(r5) != 0) goto L10;
        r5 = View.MeasureSpec.makeMeasureSpec(this.a, 1073741824);
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        a();
    }
}
