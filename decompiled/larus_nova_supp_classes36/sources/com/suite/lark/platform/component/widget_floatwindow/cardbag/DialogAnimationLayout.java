package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class DialogAnimationLayout extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public int a;
    public int b;
    public int c;
    public LayoutTransition d;
    public List<View> e;
    public int f;
    public ValueAnimator g;
    public int h;

    public class a implements e.a {
        public final int a;
        public final /* synthetic */ DialogAnimationLayout b;

        public final void a() {
            boolean r1 = true;
            if (this.a != 1) goto L5;
            return;
        L5:
            if (this.b.getChildCount() <= 3) goto L30;
            DialogAnimationLayout r0 = this.b;
            int r3 = DialogAnimationLayout.i;
            r0.getClass();
            if (r0.e.size() < 3) goto L9;
            int r4 = (r0.e.size() - 3) + 0;
            if (r4 >= 0) goto L14;
        L16:
            r4 = -1;
        L17:
            DialogAnimationLayout r2 = this.b;
            int r5 = r2.a(r4);
            if (r5 < 0) goto L21;
            if (r5 >= 3) goto L21;
        L22:
            if (r1 == true) goto L25;
            return;
        L25:
            if (r2.getChildCount() == 0) goto L32;
            r2.setLayoutTransition(null);
            r2.c();
            r2.removeViewAt(r2.a(r4));
            return;
        L32:
            return;
        L21:
            r1 = false;
            goto L22
        L14:
            if (r4 >= r0.e.size()) goto L16;
        L9:
            if (r0.e.size() <= 0) goto L16;
            r4 = 0;
            goto L17
        }

        public a(DialogAnimationLayout r1, int r2) {
            this.b = r1;
            this.a = 0;
            this.a = r2;
        }
    }

    public interface b {
    }

    private Animator getAppearAnimation() {
        return ObjectAnimator.ofFloat(null, "translationY", new float[]{-this.a, 0.0f}).setDuration(500);
    }

    private Animator getDisAppearAnimation() {
        return ObjectAnimator.ofFloat(null, "translationY", new float[]{0.0f, -this.a}).setDuration(300);
    }

    public void setFinishListener(b r1) {
    }

    public final void c() {
        ValueAnimator r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.g.end();
        this.g = null;
        return;
    }

    public final void b() {
        this.f = (int) getResources().getDimension(2131165478);
        this.a = (int) getResources().getDimension(2131168485);
        LayoutTransition r0 = this.d;
        if (r0 == null) goto L5;
        setLayoutTransition(r0);
        return;
    L5:
        LayoutTransition r1 = new LayoutTransition();
        this.d = r1;
        r1.setStartDelay(2, 0);
        this.d.setStartDelay(3, 0);
        this.d.setAnimator(2, getAppearAnimation());
        this.d.setAnimator(3, getDisAppearAnimation());
        this.d.addTransitionListener(new f(this));
        setLayoutTransition(this.d);
    }

    public int getAppearHeight() {
        return this.a;
    }

    public List<View> getPackageViews() {
        return this.e;
    }

    public DialogAnimationLayout(Context r1) {
        super(r1);
        this.b = -1;
        this.c = 1;
        this.e = new ArrayList();
        b();
    }

    public final int a(int r4) {
        if (r4 >= 0) goto L5;
    L14:
        return -1;
    L5:
        if (r4 > (this.e.size() - 1)) goto L14;
        if (this.e.size() >= 3) goto L10;
        return r4;
    L10:
        int r5 = r4 - (this.e.size() - 3);
        if (r5 < 0) goto L14;
        if (r5 >= 3) goto L14;
        return r5;
    }

    public void setAppearHeight(int r1) {
        this.a = r1;
    }

    public void setAppearWidth(int r1) {
        this.b = r1;
    }

    public void setGravity(int r1) {
        this.c = r1;
    }

    public void setPackageViews(List<View> r1) {
        this.e = r1;
    }

    public DialogAnimationLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = -1;
        this.c = 1;
        this.e = new ArrayList();
        b();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        int r4 = getMeasuredHeight();
        int r0 = this.h;
        if (r4 >= r0) goto L6;
        setMeasuredDimension(r2, r0);
        return;
    }

    public DialogAnimationLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = -1;
        this.c = 1;
        this.e = new ArrayList();
        b();
    }
}
