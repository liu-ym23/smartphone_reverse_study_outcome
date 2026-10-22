package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/DragParentView;", "Landroid/widget/FrameLayout;", "Ld42/d;", "Ld42/b;", "callback", BuildConfig.FLAVOR, "setDragCallback", BuildConfig.FLAVOR, "h", "I", "getMDragAreaMarginTop", "()I", "setMDragAreaMarginTop", "(I)V", "mDragAreaMarginTop", "j", "getMDragAreaMarginBottom", "setMDragAreaMarginBottom", "mDragAreaMarginBottom", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DragParentView extends FrameLayout implements d42.d {
    public View a;
    public final View b;
    public View c;
    public View d;
    public d42.b e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final int[] k;
    public final int[] l;
    public final Rect m;
    public final Rect n;
    public boolean o;
    public boolean p;

    public DragParentView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DragParentView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getMDragAreaMarginBottom() {
        return this.j;
    }

    public final int getMDragAreaMarginTop() {
        return this.h;
    }

    @Override // d42.d
    public void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "dragView");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.topMargin = this.f;
        r0.leftMargin = this.g;
        addView(r3, r0);
        this.d = r3;
    }

    @Override // d42.c
    public final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "draggingView");
        l(8);
        d42.b r3 = this.e;
        if (r3 == null) goto L5;
        r3.Op(this.o);
    L5:
        this.p = true;
    }

    @Override // d42.c
    public final void f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "draggingView");
        l(8);
        d42.b r3 = this.e;
        if (r3 == null) goto L5;
        r3.Op(this.o);
    L5:
        this.p = true;
    }

    @Override // d42.c
    public final void g(View r5) {
        Intrinsics.checkNotNullParameter(r5, "draggingView");
        View r0 = this.a;
        if (r0 != null) goto L5;
        boolean r6 = false;
    L6:
        Boolean r7 = Boolean.valueOf(r6);
        if (r7.booleanValue() == this.o) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r7 = null;
    L13:
        if (r7 == null) goto L17;
        boolean r8 = r7.booleanValue();
        this.o = r8;
        d42.b r2 = this.e;
        if (r2 == null) goto L17;
        r2.kn(r8);
    L17:
        l(0);
        if (this.p == false) goto L24;
        d42.b r9 = this.e;
        if (r9 == null) goto L22;
        r9.onDragStart();
    L22:
        this.p = false;
        return;
    L24:
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r5.getLocationOnScreen(this.l);
        r0.getLocationOnScreen(this.k);
        k(r5, this.n, this.l);
        k(r0, this.m, this.k);
        r6 = this.n.intersect(this.m);
        goto L6
    }

    @Override // d42.d
    public Pair h(DragContainer r5) {
        Intrinsics.checkNotNullParameter(r5, "dragView");
        Float r0 = Float.valueOf(r5.getX() / getWidth());
        float r6 = r5.getY();
        View r1 = this.a;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.getHeight();
    L6:
        float r7 = r6 - r3;
        int r4 = getHeight();
        View r8 = this.a;
        if (r8 == null) goto L9;
        int r9 = r8.getHeight();
    L10:
        int r10 = r4 - r9;
        View r11 = this.c;
        if (r11 == null) goto L14;
        r2 = r11.getHeight();
    L14:
        return TuplesKt.to(r0, Float.valueOf(r7 / (r10 - r2)));
    L9:
        r9 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void l(int r2) {
        this.b.setVisibility(r2);
        View r0 = this.a;
        if (r0 == null) goto L5;
        r0.setVisibility(r2);
    L5:
        View r1 = this.c;
        if (r1 == null) goto L9;
        r1.setVisibility(r2);
        return;
    }

    @Override // d42.d
    public void setDragCallback(d42.b r1) {
        this.e = r1;
    }

    public final void setMDragAreaMarginBottom(int r1) {
        this.j = r1;
    }

    public final void setMDragAreaMarginTop(int r1) {
        this.h = r1;
    }

    @Override // d42.d
    public void d(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "deleteView");
        View r0 = this.a;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        r3.setVisibility(8);
        addView(r3, new FrameLayout.LayoutParams(-1, r4));
        int r1 = UtilityKotlinExtentionsKt.i(6) + r4;
        View r2 = this.d;
        if (r2 == null) goto L8;
        a1.o(r2, r1);
    L8:
        this.f = r1;
        a1.o(this.b, r4);
        this.a = r3;
    }

    @Override // d42.d
    public final boolean e(float r3, float r4) {
        if (r3 >= (getLeft() + this.g)) goto L5;
    L7:
        return false;
    L5:
        if ((r3 + r4) > (getRight() - this.i)) goto L7;
        return true;
    }

    @Override // d42.d
    public boolean i(float r3, float r4) {
        if (r3 < (getTop() + this.h)) goto L12;
        float r5 = r3 + r4;
        int r6 = getBottom();
        View r0 = this.c;
        if (r0 == null) goto L7;
        int r1 = r0.getHeight();
    L9:
        if (r5 > ((r6 - r1) - this.j)) goto L13;
        return true;
    L13:
        return false;
    L7:
        r1 = 0;
        goto L9
    L12:
        return false;
    }

    @Override // d42.d
    public void j(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "forbiddenView");
        View r0 = this.c;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        r4.setVisibility(8);
        addView(r4, new FrameLayout.LayoutParams(-1, r5, 80));
        a1.l(this.b, r5);
        this.c = r4;
    }

    public DragParentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = new int[2];
        this.l = new int[2];
        this.m = new Rect();
        this.n = new Rect();
        this.p = true;
        View r5 = new View(r2);
        r5.setVisibility(8);
        r5.setBackgroundResource(2131249073);
        Unit r6 = Unit.INSTANCE;
        this.b = r5;
        addView(r5, -1, -1);
    }

    public static void k(View r3, Rect r4, int[] r5) {
        int r0 = 0;
        int r1 = r5[0];
        r4.left = r1;
        r4.top = r5[1];
        if (r3 == null) goto L5;
        int r6 = r3.getMeasuredWidth();
    L6:
        r4.right = r1 + r6;
        int r7 = r4.top;
        if (r3 == null) goto L9;
        r0 = r3.getMeasuredHeight();
    L9:
        r4.bottom = r7 + r0;
        return;
    L5:
        r6 = 0;
        goto L6
    }

    @Override // d42.d
    public final void a(int r1, int r2, int r3) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = 0;
    }

    public /* synthetic */ DragParentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
