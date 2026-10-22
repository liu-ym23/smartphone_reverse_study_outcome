package com.larus.common_ui.dbx.component;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v extends FrameLayout {
    public static final Rect x = null;
    public final View a;
    public final TextView b;
    public final Path c;
    public final t d;
    public WeakReference<View> e;
    public int f;
    public Integer g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final FrameLayout j;
    public int k;
    public final FrameLayout l;
    public final w m;
    public final u n;
    public final d o;
    public final d p;
    public Rect q;
    public boolean r;
    public CharSequence s;
    public boolean t;
    public boolean u;
    public boolean v;
    public CharSequence w;

    public static final class a {
        public static Pair a(int r2, int r3) {
            int r4 = Math.max(0, r2);
            float r0 = r4;
            int r1 = (int) (0.5f * r0);
            int r5 = Math.max(r4 - RangesKt.coerceIn(r3, 0, r4), (int) (r0 * 0.9f));
            return TuplesKt.to(Integer.valueOf(Math.min(r1, r5)), Integer.valueOf(r5));
        }
    }

    static {
        x = new Rect(0, 0, 0, 0);
    }

    public final void a() {
        if (this.m.getChildCount() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Rect r2 = this.q;
        int r3 = r2.bottom + this.k;
        FrameLayout r4 = this.i;
        int r5 = r2.left;
        int r6 = r2.top;
        int r7 = r2.right;
        if (r0 == false) goto L9;
        int r8 = 0;
    L10:
        r4.setPadding(r5, r6, r7, r8);
        if (this.r == false) goto L13;
        Rect r9 = this.q;
    L14:
        FrameLayout r10 = this.j;
        int r11 = r9.left;
        int r12 = r9.right;
        if (r0 == true) goto L18;
        r3 = 0;
    L18:
        r10.setPadding(r11, 0, r12, r3);
        return;
    L13:
        r9 = x;
        goto L14
    L9:
        r8 = r3;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final void e() {
        this.b.setText(this.s);
        TextView r0 = this.b;
        CharSequence r1 = this.s;
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r2 = 4;
    L11:
        r0.setVisibility(r2);
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        View r0 = this.e.get();
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.d);
    L5:
        this.m.removeCallbacks(this.n);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = this.e.get();
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.d);
        r0.addOnLayoutChangeListener(this.d);
    L5:
        d(true);
    }

    public final boolean getAppliesFooterInsets() {
        return this.r;
    }

    public final CharSequence getCloseAccessibilityLabel() {
        return this.w;
    }

    public final ImageButton getCloseButton() {
        return this.p;
    }

    public final Rect getContentInsets() {
        return this.q;
    }

    public final FrameLayout getContentView() {
        return this.l;
    }

    public final FrameLayout getFooterView() {
        return this.m;
    }

    public final boolean getShowsCloseButton() {
        return this.v;
    }

    public final CharSequence getTitle() {
        return this.s;
    }

    public final boolean getWrapsContentHeight() {
        return this.u;
    }

    public final void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "relativeTo");
        View r0 = this.e.get();
        if (r0 == r3) goto L7;
        if (r0 == null) goto L6;
        r0.removeOnLayoutChangeListener(this.d);
    L6:
        r3.addOnLayoutChangeListener(this.d);
    L7:
        this.e = new WeakReference(r3);
        d(true);
    }

    public final int c(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void d(boolean r5) {
        View r0 = this.e.get();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getHeight();
        if (r1 > 0) goto L8;
        return;
    L8:
        WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r0);
        int r3 = 0;
        if (r2 == null) goto L13;
        Insets r4 = r2.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r4 == null) goto L13;
        int r6 = r4.top;
    L14:
        Pair r7 = a.a(r1, r6);
        int r8 = ((Number) r7.component1()).intValue();
        int r9 = ((Number) r7.component2()).intValue();
        if (this.f != r8) goto L23;
        Integer r10 = this.g;
        if (r10 == null) goto L23;
        if (r10.intValue() != r9) goto L23;
        boolean r11 = false;
    L24:
        this.f = r8;
        this.g = Integer.valueOf(r9);
        if (this.u == true) goto L28;
        r3 = r8;
    L28:
        setMinimumHeight(r3);
        if (r11 == false) goto L33;
        if (r5 == false) goto L34;
        requestLayout();
        return;
    L34:
        return;
    L33:
        return;
    L23:
        r11 = true;
    L13:
        r6 = 0;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        int r0 = r3.save();
        r3.clipPath(this.c);
        super.dispatchDraw(r3);
        r3.restoreToCount(r0);
    }

    public final void setAppliesFooterInsets(boolean r1) {
        this.r = r1;
        a();
    }

    public final void setCloseAccessibilityLabel(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        this.w = r2;
        this.p.setContentDescription(r2);
        return;
    L7:
        throw new IllegalArgumentException("关闭按钮必须提供非空无障碍文案".toString());
    }

    public final void setContentInsets(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.q = new Rect(r2);
        a();
    }

    public final void setHeightResizable(boolean r2) {
        this.t = r2;
        View r0 = this.a;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setOnCloseRequestListener$common_ui_mainlandRelease(Function0<Unit> r2) {
        this.o.a = r2;
    }

    public final void setShowsCloseButton(boolean r2) {
        this.v = r2;
        d r0 = this.p;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTitle(CharSequence r1) {
        this.s = r1;
        e();
    }

    public final void setWrapsContentHeight(boolean r2) {
        if (this.u != r2) goto L5;
        return;
    L5:
        this.u = r2;
        d(true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = 0;
        d(false);
        Integer r1 = this.g;
        if (r1 == null) goto L15;
        int r2 = r1.intValue();
        if (this.u == true) goto L8;
        r0 = Math.min(this.f, r2);
    L8:
        int r3 = View.MeasureSpec.getSize(r7);
        int r8 = View.MeasureSpec.getMode(r7);
        if (r8 != Integer.MIN_VALUE) goto L11;
        r7 = View.MeasureSpec.makeMeasureSpec(Math.min(r3, r2), Integer.MIN_VALUE);
        goto L15
    L11:
        if (r8 == 1073741824) goto L13;
        r7 = View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE);
        goto L15
    L13:
        r7 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(r3, r0, r2), 1073741824);
    L15:
        super.onMeasure(r6, r7);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.common_ui.dbx.component.u] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.common_ui.dbx.component.t] */
    public v(FragmentActivity r110, CharSequence r20, CharSequence r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r20, "closeAccessibilityLabel");
        super(r110);
        View r3 = new View(r110);
        this.a = r3;
        TextView r4 = new TextView(r110);
        this.b = r4;
        this.c = new Path();
        this.d = new t(this);
        this.e = new WeakReference(null);
        LinearLayout r5 = new LinearLayout(r110);
        FrameLayout r7 = new FrameLayout(r110);
        this.h = r7;
        FrameLayout r8 = new FrameLayout(r110);
        this.i = r8;
        FrameLayout r9 = new FrameLayout(r110);
        this.j = r9;
        FrameLayout r10 = new FrameLayout(r110);
        this.l = r10;
        w r11 = new w(r110, this);
        this.m = r11;
        this.n = new u(this);
        d r12 = new d(r110);
        this.o = r12;
        this.p = r12;
        int r13 = 0;
        this.q = new Rect(0, 0, 0, 0);
        this.r = true;
        this.s = r21;
        this.t = r22;
        this.v = true;
        this.w = r20;
        if ((!StringsKt.isBlank(r20)) == false) goto L41;
        GradientDrawable r14 = new GradientDrawable();
        r14.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), 2130971009));
        float r6 = c(24);
        r14.setCornerRadii(new float[]{r6, r6, r6, r6, 0.0f, 0.0f, 0.0f, 0.0f});
        setBackground(r14);
        r5.setOrientation(1);
        addView(r5, new FrameLayout.LayoutParams(-1, -1));
        r5.addView(r7, new LinearLayout.LayoutParams(-1, c(56)));
        r8.addView(r10, new FrameLayout.LayoutParams(-1, -1));
        r5.addView(r8, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r9.addView(r11, new FrameLayout.LayoutParams(-1, -2));
        r5.addView(r9, new LinearLayout.LayoutParams(-1, -2));
        r4.setGravity(17);
        r4.setMaxLines(1);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        r4.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT < 28) goto L7;
        Typeface r2 = Typeface.create(Typeface.create("sans-serif", 0), 600, false);
        Intrinsics.checkNotNull(r2);
    L8:
        r4.setTypeface(r2);
        r4.setTextSize(2, 17.0f);
        r4.setTextColor(com.larus.common_ui.dbx.theme.a.b(getContext(), 2130971068));
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(c(166), c(44), 49);
        r15.topMargin = c(12);
        Unit r16 = Unit.INSTANCE;
        r7.addView(r4, r15);
        GradientDrawable r17 = new GradientDrawable();
        r17.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), 2130971079));
        r17.setShape(1);
        r12.setBackground(new InsetDrawable(r17, c(4)));
        c19.a r18 = c19.a.a;
        int r23 = c(20);
        int r24 = com.larus.common_ui.dbx.theme.a.b(getContext(), 2130971068);
        Intrinsics.checkNotNullParameter("close", "name");
        monitor-enter(r18);
        Intrinsics.checkNotNullParameter("close", "name");     // Catch: Throwable -> L37
        Integer r111 = (Integer) ((Map) c19.f.d.getValue()).get("close");     // Catch: Throwable -> L37
        if (r111 == null) goto L23;
        int r112 = r111.intValue();     // Catch: Throwable -> L37
        SparseArray<c19.b> r113 = c19.a.b;     // Catch: Throwable -> L37
        c19.b r114 = r113.get(r112);     // Catch: Throwable -> L37
        if (r114 == null) goto L16;
        monitor-exit(r18);
        c19.b r115 = r114;
    L25:
        if (r115 != null) goto L28;
        c19.c r25 = null;
    L31:
        r12.setImageDrawable(r25);
        r12.setScaleType(ImageView.ScaleType.CENTER);
        r12.setPadding(0, 0, 0, 0);
        r12.setMinimumWidth(0);
        r12.setMinimumHeight(0);
        r12.setClickable(true);
        r12.setFocusable(true);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(c(44), c(44), 8388659);
        r0.setMarginStart(c(12));
        r0.topMargin = c(12);
        r7.addView(r12, r0);
        GradientDrawable r1 = new GradientDrawable();
        r1.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), 2130971075));
        r1.setCornerRadius(c(2));
        r3.setBackground(r1);
        FrameLayout.LayoutParams r26 = new FrameLayout.LayoutParams(c(36), c(4), 49);
        r26.topMargin = c(6);
        r7.addView(r3, r26);
        e();
        if (this.t == true) goto L35;
        r13 = 8;
    L35:
        r3.setVisibility(r13);
        a();
        r12.setContentDescription(r20);
        return;
    L28:
        if (r23 > 0) goto L30;
        r23 = 1;
    L30:
        Intrinsics.checkNotNullParameter("close", "name");
        r25 = new c19.c(r115, r24, r23, c19.f.c.contains("close"));
        goto L31
    L16:
        r115 = c19.f.a(r112);     // Catch: Throwable -> L37
        if (r115 != null) goto L20;
        monitor-exit(r18);
    L24:
        r115 = null;
        goto L25
    L20:
        r113.put(r112, r115);     // Catch: Throwable -> L37
        monitor-exit(r18);
        goto L25
    L23:
        monitor-exit(r18);
    L37:
        th = move-exception;
        throw th;
    L7:
        r2 = Typeface.create("sans-serif-medium", 0);
        Intrinsics.checkNotNull(r2);
        goto L8
    L41:
        throw new IllegalArgumentException("关闭按钮必须提供非空无障碍文案".toString());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        float r7 = c(24);
        this.c.reset();
        this.c.addRoundRect(new RectF(0.0f, 0.0f, r3, r4), new float[]{r7, r7, r7, r7, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
    }
}
