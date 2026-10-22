package gs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.tab.OTabLayoutBase;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends OUILinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f17185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f17187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f17190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f17192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f17193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f17194r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f17195t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f17196u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Paint f17197v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Paint f17198w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f17199x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f17200y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ OTabLayoutBase f17201z;

    public i(OTabLayoutBase r5, Context r10) {
        this.f17201z = r5;
        super(r10);
        this.f17186j = -1;
        this.f17188l = -1;
        this.f17189m = -1;
        r5.m(27);
        this.f17191o = Integer.MAX_VALUE;
        setChangeAlphaWhenPress(false);
        setClipChildren(false);
        setClipToPadding(false);
        setWillNotDraw(false);
        this.f17185i = new Paint();
        this.f17199x = (r5.getResources().getDisplayMetrics().density * 0.6f) + 0.5f;
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
    public final void draw(Canvas r21) {
        super.draw(r21);
        boolean r5 = this.s;
        OTabLayoutBase r10 = this.f17201z;
        if (r5 == false) goto L7;
        r21.drawLine(getLeft(), getBottom() - ((r10.getResources().getDisplayMetrics().density * 0.6f) + 0.5f), getRight() * 2, getBottom(), this.f17197v);
    L7:
        if (this.f17195t == false) goto L9;
        float r11 = getLeft();
        float r12 = getTop();
        float r13 = this.f17199x;
        r21.drawLine(r11, r12 + r13, getRight() * 2, getTop() + r13, this.f17198w);
    L9:
        int r14 = this.f17188l;
        if (r14 >= 0) goto L12;
        return;
    L12:
        if (this.f17189m > r14) goto L14;
        return;
    L14:
        if (this.f17196u == false) goto L36;
        View r15 = getChildAt(r10.getSelectedTabPosition());
        Paint r16 = this.f17185i;
        if (r15 == null) goto L27;
        View r17 = r15.findViewById(R$id.layout_tab_indicator);
        if (r17 == null) goto L27;
        if (r10.R != null) goto L22;
    L23:
        int r18 = this.f17188l;
        float r19 = (((this.f17189m - r18) - r17.getWidth()) / 2) + r18;
        this.f17192p = r19;
        this.f17193q = r19 + r17.getWidth();
    L24:
        Path r20 = new Path();
        r20.addRoundRect(new RectF(((this.f17192p + this.f17193q) / 2.0f) - r10.m(3), (getHeight() - getPaddingBottom()) - r10.m(4), ((this.f17192p + this.f17193q) / 2.0f) + r10.m(3), getHeight() - getPaddingBottom()), new float[]{r10.m(3), r10.m(3), r10.m(3), r10.m(3), r10.m(1), r10.m(1), r10.m(1), r10.m(1)}, Path.Direction.CCW);
        r21.drawPath(r20, r16);
        return;
    L22:
        if (this.f17194r == true) goto L24;
    L27:
        if (this.f17200y == false) goto L29;
    L31:
        float r22 = this.f17188l;
        float r23 = this.f17189m;
    L32:
        Path r24 = new Path();
        float r25 = (r22 + r23) / 2.0f;
        r24.addRoundRect(new RectF(r25 - r10.m(3), (getHeight() - getPaddingBottom()) - r10.m(4), r25 + r10.m(3), getHeight() - getPaddingBottom()), new float[]{r10.m(3), r10.m(3), r10.m(3), r10.m(3), r10.m(1), r10.m(1), r10.m(1), r10.m(1)}, Path.Direction.CCW);
        r21.drawPath(r24, r16);
        return;
    L29:
        if ((r15 instanceof k) == false) goto L31;
        float r26 = (this.f17188l + this.f17189m) * 0.5f;
        k r27 = (k) r15;
        r22 = r26 - (r27.getContentWidth() * 0.5f);
        r23 = (r27.getContentWidth() * 0.5f) + r26;
        goto L32
    }

    public final void e(int r10, int r11) {
        ValueAnimator r5 = this.f17190n;
        if (r5 == null) goto L8;
        if (r5.isRunning() == false) goto L8;
        this.f17190n.cancel();
    L8:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        boolean r12 = true;
    L11:
        View r13 = getChildAt(r10);
        if (r13 != null) goto L15;
        o();
        return;
    L15:
        int r14 = r13.getLeft();
        int r15 = r13.getRight();
        if (Math.abs(r10 - this.f17186j) > 1) goto L18;
        int r16 = this.f17188l;
        int r17 = this.f17189m;
    L26:
        if (r16 != r14) goto L28;
        if (r17 != r15) goto L28;
        return;
    L28:
        ValueAnimator r18 = new ValueAnimator();
        this.f17190n = r18;
        r18.setInterpolator(OTabLayoutBase.F0);
        r18.setDuration(r11);
        r18.setFloatValues(new float[]{0.0f, 1.0f});
        r18.addUpdateListener(new h(this, r16, r14, r17, r15));
        r18.addListener(new com.obric.oui.dialog.base.c(this, r10, 1));
        r18.start();
        return;
    L18:
        int r19 = this.f17201z.m(24);
        if (r10 >= this.f17186j) goto L24;
        if (r12 == false) goto L23;
    L21:
        r16 = r14 - r19;
    L22:
        r17 = r16;
    L23:
        r16 = r19 + r15;
        goto L22
    L24:
        if (r12 == false) goto L21;
    L10:
        r12 = false;
        goto L11
    }

    public final void n(boolean r5) {
        this.f17195t = r5;
        if (r5 == false) goto L6;
        Paint r10 = new Paint();
        this.f17198w = r10;
        r10.setColor(ContextCompat.getColor(getContext(), R$color.oui_line_2));
        this.f17198w.setStyle(Paint.Style.FILL);
        this.f17198w.setStrokeWidth(this.f17199x);
        return;
    }

    public final void o() {
        View r5 = getChildAt(this.f17186j);
        if (r5 != null) goto L5;
    L11:
        int r10 = -1;
        int r11 = -1;
    L13:
        if (r10 == this.f17188l) goto L15;
    L16:
        this.f17188l = r10;
        this.f17189m = r11;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L15:
        if (r11 != this.f17189m) goto L16;
        return;
    L5:
        if (r5.getWidth() <= 0) goto L11;
        r10 = r5.getLeft();
        r11 = r5.getRight();
        if (this.f17187k <= 0.0f) goto L13;
        if (this.f17186j >= (getChildCount() - 1)) goto L13;
        View r12 = getChildAt(this.f17186j + 1);
        float r13 = this.f17187k * r12.getLeft();
        float r14 = this.f17187k;
        r10 = (int) (((1.0f - r14) * r10) + r13);
        r11 = (int) (((1.0f - this.f17187k) * r11) + (r14 * r12.getRight()));
        goto L13
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        ValueAnimator r14 = this.f17190n;
        if (r14 != null) goto L5;
    L7:
        o();
        return;
    L5:
        if (r14.isRunning() == false) goto L7;
        this.f17190n.cancel();
        e(this.f17186j, Math.round((1.0f - this.f17190n.getAnimatedFraction()) * this.f17190n.getDuration()));
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        int r5 = getChildCount();
        int r10 = View.MeasureSpec.getMode(r11);
        OTabLayoutBase r13 = this.f17201z;
        int r14 = 0;
        boolean r15 = true;
        if (r10 != 1073741824) goto L5;
        Drawable r16 = getDividerDrawable();
        if (r16 == null) goto L28;
        int r17 = r16.getIntrinsicWidth();
    L29:
        int r18 = 0;
        int r19 = 0;
    L30:
        if (r18 >= r5) goto L35;
        View r20 = getChildAt(r18);
        if (r20.getVisibility() != 0) goto L34;
        r19 = Math.max(r19, r20.getMeasuredWidth());
        this.f17191o = Math.min(this.f17191o, r20.getMeasuredWidth());
    L34:
        r18 = r18 + 1;
        goto L30
    L35:
        int r21 = ((r5 - 1) * r17) + (getPaddingRight() + getPaddingLeft());
        int r22 = r13.K;
        if (r22 == 1) goto L38;
    L55:
        if (r22 == 0) goto L57;
        return;
    L57:
        if (r13.M == true) goto L59;
        return;
    L59:
        if (r13.C0 == getResources().getConfiguration().orientation) goto L61;
        return;
    L61:
        if (r19 > 0) goto L63;
        return;
    L63:
        int r23 = 0;
        int r24 = 0;
    L65:
        if (r23 >= r5) goto L70;
        View r25 = getChildAt(r23);
        if (r25.getVisibility() == 8) goto L69;
        r24 = r24 + r25.getMeasuredWidth();
    L69:
        r23 = r23 + 1;
        goto L65
    L70:
        if (r24 > 0) goto L72;
        return;
    L72:
        int r26 = getMeasuredWidth() - r21;
        if (r24 < r26) goto L75;
    L91:
        if (r14 == 0) goto L122;
        super.onMeasure(r11, r12);
        return;
    L122:
        return;
    L75:
        if ((r19 * r5) >= r26) goto L85;
        int r27 = 0;
        int r28 = 0;
    L77:
        if (r27 >= r5) goto L84;
        LinearLayout.LayoutParams r29 = (LinearLayout.LayoutParams) getChildAt(r27).getLayoutParams();
        if (r29.width == 0) goto L81;
    L82:
        r29.width = 0;
        r29.weight = 1.0f;
        r28 = 1;
    L83:
        r27 = r27 + 1;
        goto L77
    L81:
        if (r29.weight == 1.0f) goto L83;
    L84:
        r14 = r28;
        goto L91
    L85:
        int r30 = (r26 - r24) / (r5 * 2);
        r28 = 0;
    L86:
        if (r14 >= r5) goto L84;
        if (getChildAt(r14).getVisibility() == 8) goto L90;
        LinearLayout.LayoutParams r31 = (LinearLayout.LayoutParams) getChildAt(r14).getLayoutParams();
        r31.leftMargin = r30;
        r31.rightMargin = r30;
        r28 = 1;
    L90:
        r14 = r14 + 1;
        goto L86
    L38:
        if (r13.J != 1) goto L55;
        if (r19 > 0) goto L42;
        return;
    L42:
        if ((r19 * r5) > (getMeasuredWidth() - r21)) goto L52;
        boolean r32 = false;
    L44:
        if (r14 >= r5) goto L51;
        LinearLayout.LayoutParams r33 = (LinearLayout.LayoutParams) getChildAt(r14).getLayoutParams();
        if (r33.width == r19) goto L48;
    L49:
        r33.width = r19;
        r33.weight = 0.0f;
        r32 = true;
    L50:
        r14 = r14 + 1;
        goto L44
    L48:
        if (r33.weight == 0.0f) goto L50;
    L51:
        r15 = r32;
    L53:
        if (r15 == false) goto L118;
        super.onMeasure(r11, r12);
        return;
    L118:
        return;
    L52:
        r13.J = 0;
        r13.x(false);
        goto L53
    L28:
        r17 = 0;
        goto L29
    L5:
        if (r13.K == 1) goto L7;
        return;
    L7:
        if (r13.J != 1) goto L116;
        int r34 = 0;
        int r35 = 0;
    L9:
        if (r34 >= r5) goto L14;
        View r36 = getChildAt(r34);
        if (r36.getVisibility() != 0) goto L13;
        r35 = Math.max(r35, r36.getMeasuredWidth());
        this.f17191o = Math.min(this.f17191o, r36.getMeasuredWidth());
    L13:
        r34 = r34 + 1;
        goto L9
    L14:
        int r37 = Math.min(r13.F, r35);
        boolean r38 = false;
    L15:
        if (r14 >= r5) goto L22;
        LinearLayout.LayoutParams r39 = (LinearLayout.LayoutParams) getChildAt(r14).getLayoutParams();
        if (r39.width == r37) goto L19;
    L20:
        r39.width = r37;
        r39.weight = 0.0f;
        r38 = true;
    L21:
        r14 = r14 + 1;
        goto L15
    L19:
        if (r39.weight == 0.0f) goto L21;
    L22:
        if (r38 == false) goto L117;
        super.onMeasure(r11, r12);
        return;
    L117:
        return;
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
    public final void setEnabled(boolean r5) {
        super.setEnabled(r5);
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f17201z.f14665r.getChildAt(r11).setEnabled(r5);
        r11 = r11 + 1;
        goto L3
    }
}
