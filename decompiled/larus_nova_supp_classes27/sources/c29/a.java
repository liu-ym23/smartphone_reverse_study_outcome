package c29;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final View a;
    public final Context b;
    public final GradientDrawable c;
    public final GradientDrawable d;
    public int e;
    public List<Integer> f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public final float[] v;

    /* JADX INFO: renamed from: c29.a$a, reason: collision with other inner class name */
    public static final class C0005a {
    }

    static {
    }

    public final void c() {
        StateListDrawable r0 = new StateListDrawable();
        if (this.s == true) goto L5;
        f(this.c, this.e, this.n, this.f);
        r0.addState(new int[]{-16842919}, this.c);
        int r1 = this.g;
        if (r1 == Integer.MAX_VALUE) goto L12;
    L13:
        GradientDrawable r8 = this.d;
        if (r1 != Integer.MAX_VALUE) goto L16;
        int r9 = this.e;
    L17:
        int r10 = this.o;
        if (r10 != Integer.MAX_VALUE) goto L20;
        r10 = this.n;
    L20:
        if (r1 != Integer.MAX_VALUE) goto L22;
        List<Integer> r2 = this.f;
    L23:
        f(r8, r9, r10, r2);
        r0.addState(new int[]{R.attr.state_pressed}, this.d);
    L24:
        this.a.setBackground(r0);
    L25:
        View r3 = this.a;
        if ((r3 instanceof TextView) == true) goto L28;
        return;
    L28:
        if (this.p == Integer.MAX_VALUE) goto L32;
        ColorStateList r4 = ((TextView) r3).getTextColors();
        ((TextView) this.a).setTextColor(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{R.attr.state_pressed}}, new int[]{r4.getDefaultColor(), this.p}));
        return;
    L32:
        return;
    L22:
        r2 = CollectionsKt.emptyList();
        goto L23
    L16:
        r9 = r1;
        goto L17
    L12:
        if (this.o == Integer.MAX_VALUE) goto L24;
    L5:
        if (this.t == false) goto L7;
        f(this.c, this.e, 0, this.f);
        GradientDrawable r5 = new GradientDrawable();
        r5.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        f(r5, this.e, 0, CollectionsKt.listOf(new Integer[]{Integer.valueOf(this.u), Integer.valueOf(this.u)}));
        LayerDrawable r6 = new LayerDrawable(new GradientDrawable[]{this.c, r5});
        int r14 = this.m;
        r6.setLayerInset(1, r14, r14, r14, r14);
        Drawable r7 = r6;
    L8:
        int r11 = this.e;
        int r12 = this.g;
        this.a.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_activated}, new int[0]}, new int[]{r12, r12, r12, r11}), r7, null));
        goto L25
    L7:
        f(this.c, this.e, this.n, this.f);
        r7 = this.c;
        goto L8
    }

    public final void a(int r1) {
        this.e = r1;
        this.f = CollectionsKt.emptyList();
        c();
    }

    public final void b(int r1) {
        this.g = r1;
        c();
    }

    public final void d(int r3) {
        Resources r0 = this.b.getResources();
        this.h = (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
        c();
    }

    public final void e(int r1) {
        this.h = r1;
        c();
    }

    public final void g(int r1) {
        this.n = r1;
        c();
    }

    public final void h(int r1) {
        this.o = r1;
        c();
    }

    public final void i(int r1) {
        this.m = r1;
        c();
    }

    public final void j(int r1) {
        this.p = r1;
        c();
    }

    public a(View r5, Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.a = r5;
        this.b = r6;
        this.c = new GradientDrawable();
        this.d = new GradientDrawable();
        this.f = CollectionsKt.emptyList();
        this.v = new float[8];
        if (r7 == null) goto L24;
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130973909, 2130973910, 2130973911, 2130973912, 2130973913, 2130973914, 2130973915, 2130973916, 2130973917, 2130973918, 2130973920, 2130973921, 2130973922, 2130973923});
        this.e = r8.getColor(0, 0);
        this.g = r8.getColor(1, -1);
        this.h = r8.getDimensionPixelSize(2, 0);
        this.m = r8.getDimensionPixelSize(12, 0);
        this.n = r8.getColor(10, 0);
        this.o = r8.getColor(11, -1);
        this.p = r8.getColor(13, -1);
        this.q = r8.getBoolean(7, false);
        this.r = r8.getBoolean(9, false);
        this.i = r8.getDimensionPixelSize(5, 0);
        this.j = r8.getDimensionPixelSize(6, 0);
        this.k = r8.getDimensionPixelSize(3, 0);
        this.l = r8.getDimensionPixelSize(4, 0);
        this.s = r8.getBoolean(8, true);
        if (this.g != (-1)) goto L8;
        this.g = this.e;
    L8:
        if (this.o != (-1)) goto L11;
        this.o = this.n;
    L11:
        if (this.p == (-1)) goto L13;
    L22:
        r8.recycle();
        return;
    L13:
        if ((r5 instanceof TextView) == false) goto L15;
        TextView r9 = (TextView) r5;
    L16:
        if (r9 == null) goto L20;
        ColorStateList r10 = r9.getTextColors();
        if (r10 == null) goto L20;
        int r11 = r10.getDefaultColor();
    L21:
        this.p = r11;
    L20:
        r11 = Integer.MAX_VALUE;
        goto L21
    L15:
        r9 = null;
        goto L16
    }

    public final void f(GradientDrawable r6, int r7, int r8, List<Integer> r9) {
        if (r9.isEmpty() == false) goto L5;
    L8:
        r6.setColors(new int[]{r7, r7});
    L9:
        int r10 = this.i;
        if (r10 <= 0) goto L12;
    L19:
        float[] r11 = this.v;
        float r12 = r10;
        r11[0] = r12;
        r11[1] = r12;
        float r13 = this.j;
        r11[2] = r13;
        r11[3] = r13;
        float r14 = this.l;
        r11[4] = r14;
        r11[5] = r14;
        float r15 = this.k;
        r11[6] = r15;
        r11[7] = r15;
        r6.setCornerRadii(r11);
    L20:
        r6.setStroke(this.m, r8);
        return;
    L12:
        if (this.j > 0) goto L19;
        if (this.l > 0) goto L19;
        if (this.k > 0) goto L19;
        r6.setCornerRadius(this.h);
        goto L20
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r6.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r6.setColors(CollectionsKt.toIntArray(r9));
        goto L9
    }
}
