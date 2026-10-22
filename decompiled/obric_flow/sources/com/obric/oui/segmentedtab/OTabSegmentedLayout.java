package com.obric.oui.segmentedtab;

import ai.j0;
import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b=\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004qr\u0018\u0014B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u0013R\"\u00103\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010.\u001a\u0004\b3\u00100\"\u0004\b4\u0010\u0013R(\u0010=\u001a\b\u0012\u0004\u0012\u000206058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010B\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010A\"\u0004\bD\u0010\u001dR$\u0010E\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010#\"\u0004\bG\u0010HR$\u0010J\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u00100\"\u0004\bK\u0010\u0013R$\u0010L\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010#\"\u0004\bN\u0010HR$\u0010O\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010A\"\u0004\bQ\u0010\u001dR$\u0010R\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010#\"\u0004\bT\u0010HR$\u0010U\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010#\"\u0004\bW\u0010HR$\u0010X\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010A\"\u0004\bZ\u0010\u001dR$\u0010[\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\\\u0010#\"\u0004\b]\u0010HR$\u0010^\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010#\"\u0004\b`\u0010HR$\u0010d\u001a\u00020\u001e2\u0006\u0010a\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bb\u0010#\"\u0004\bc\u0010HR$\u0010e\u001a\u00020\b2\u0006\u0010e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010A\"\u0004\bg\u0010\u001dR$\u0010h\u001a\u00020\b2\u0006\u0010h\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010A\"\u0004\bj\u0010\u001dR$\u0010k\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010A\"\u0004\bm\u0010\u001dR$\u0010o\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u00100\"\u0004\bp\u0010\u0013¨\u0006s"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "Landroid/widget/FrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "", "enabled", "", "setEnabled", "(Z)V", "Lcom/obric/oui/segmentedtab/i;", "listener", "setOnTabSelectListener", "(Lcom/obric/oui/segmentedtab/i;)V", "Lcom/obric/oui/segmentedtab/h;", "setOnTabSelectAnimListener", "(Lcom/obric/oui/segmentedtab/h;)V", "index", "setFragments", "(I)V", "", "<set-?>", "l", "F", "getIndicatorSpacing", "()F", "indicatorSpacing", "", "m", "J", "getIndicatorAnimDuration", "()J", "setIndicatorAnimDuration", "(J)V", "indicatorAnimDuration", "n", "Z", "isIndicatorAnimEnable", "()Z", "setIndicatorAnimEnable", "o", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "", "Landroid/view/View;", "y", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "tabCount", "I", "getTabCount", "()I", "currentTab", "getCurrentTab", "setCurrentTab", "tabPadding", "getTabPadding", "setTabPadding", "(F)V", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextsize", "setTextsize", "textsize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textBold", "getTextBold", "setTextBold", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "com/obric/oui/segmentedtab/g", "com/obric/oui/segmentedtab/d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTabSegmentedLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public final g A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f14338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14339c;
    public int d;
    public final Rect e;
    public float f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14340h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14342j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f14344l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f14345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14348p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f14349q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f14350r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14351t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14352u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14353v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ValueAnimator f14354w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PathInterpolator f14355x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f14356y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g f14357z;

    @JvmOverloads
    public OTabSegmentedLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final void setFragments(int r5) {
    }

    public final int a(float r5) {
        return (int) ((r5 * this.f14337a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final Fragment getCurrentFragment() {
        return null;
    }

    public final int getCurrentTab() {
        return this.f14339c;
    }

    public final int getDividerColor() {
        return this.f14348p;
    }

    public final float getDividerPadding() {
        return this.f14350r;
    }

    public final float getDividerWidth() {
        return this.f14349q;
    }

    public final long getIndicatorAnimDuration() {
        return this.f14345m;
    }

    public final int getIndicatorColor() {
        return this.f14341i;
    }

    public final float getIndicatorCornerRadius() {
        return this.f14343k;
    }

    public final float getIndicatorHeight() {
        return this.f14342j;
    }

    public final float getIndicatorSpacing() {
        return this.f14344l;
    }

    public final int getTabCount() {
        return 0;
    }

    public final List<View> getTabList() {
        return this.f14356y;
    }

    public final float getTabPadding() {
        return this.f;
    }

    public final float getTabWidth() {
        return this.f14340h;
    }

    public final int getTextBold() {
        return this.f14353v;
    }

    public final int getTextSelectColor() {
        return this.f14351t;
    }

    public final int getTextUnselectColor() {
        return this.f14352u;
    }

    public final float getTextsize() {
        return this.s;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        Object r10 = r5.getAnimatedValue();
        if (r10 == null) goto L7;
        g r11 = (g) r10;
        int r12 = (int) r11.f14376a;
        Rect r13 = this.e;
        r13.left = r12;
        r13.right = (int) r11.f14377b;
        invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        com.lynx.tasm.utils.a.E(10, this);
        com.lynx.tasm.utils.a.E(0, this);
        com.lynx.tasm.utils.a.E(4, this);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        isInEditMode();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if ((r5 instanceof Bundle) == false) goto L7;
        Bundle r10 = (Bundle) r5;
        this.f14339c = r10.getInt("mCurrentTab");
        r5 = r10.getParcelable("instanceState");
        if (this.f14339c == 0) goto L7;
        this.f14338b.getChildCount();
    L7:
        super.onRestoreInstanceState(r5);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r5 = new Bundle();
        r5.putParcelable("instanceState", super.onSaveInstanceState());
        r5.putInt("mCurrentTab", this.f14339c);
        return r5;
    }

    public final void setCurrentTab(int r5) {
        int r10 = this.f14339c;
        if (r5 != r10) goto L5;
        return;
    L5:
        this.d = r10;
        this.f14339c = r5;
        StringBuilder r11 = j0.s(r5, "setCurrentTab, currentTab: ", ", lastTab: ");
        r11.append(this.d);
        Log.d("OTabSegmentedLayout", r11.toString());
        setFragments(r5);
        if (this.f14346n == false) goto L16;
        LinearLayout r12 = this.f14338b;
        View r13 = r12.getChildAt(this.f14339c);
        float r14 = r13.getLeft();
        g r15 = this.f14357z;
        r15.f14376a = r14;
        r15.f14377b = r13.getRight();
        View r16 = r12.getChildAt(this.d);
        float r17 = r16.getLeft();
        g r18 = this.A;
        r18.f14376a = r17;
        float r19 = r16.getRight();
        r18.f14377b = r19;
        if (r18.f14376a == r15.f14376a) goto L10;
    L12:
        ValueAnimator r20 = this.f14354w;
        r20.setObjectValues(new Object[]{r18, r15});
        if (this.f14347o == false) goto L15;
        r20.setInterpolator(this.f14355x);
    L15:
        r20.setDuration(350);
        r20.start();
        return;
    L10:
        if (r19 != r15.f14377b) goto L12;
        invalidate();
        return;
    L16:
        invalidate();
    }

    public final void setDividerColor(int r5) {
        this.f14348p = r5;
        invalidate();
    }

    public final void setDividerPadding(float r5) {
        this.f14350r = a(r5);
        invalidate();
    }

    public final void setDividerWidth(float r5) {
        this.f14349q = a(r5);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        Iterator r10 = this.f14356y.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((View) r10.next()).setEnabled(r5);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r5) {
        this.f14345m = r5;
    }

    public final void setIndicatorAnimEnable(boolean r5) {
        this.f14346n = r5;
    }

    public final void setIndicatorBounceEnable(boolean r5) {
        this.f14347o = r5;
    }

    public final void setIndicatorColor(int r5) {
        this.f14341i = r5;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r5) {
        this.f14343k = a(r5);
        invalidate();
    }

    public final void setIndicatorHeight(float r5) {
        this.f14342j = a(r5);
        invalidate();
    }

    public final void setOnTabSelectAnimListener(h r5) {
    }

    public final void setOnTabSelectListener(i r5) {
    }

    public final void setTabList(List<View> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14356y = r5;
    }

    public final void setTabPadding(float r5) {
        this.f = a(r5);
    }

    public final void setTabSpaceEqual(boolean r5) {
        this.g = r5;
    }

    public final void setTabWidth(float r5) {
        this.f14340h = a(r5);
    }

    public final void setTextAllCaps(boolean r5) {
    }

    public final void setTextBold(int r5) {
        this.f14353v = r5;
    }

    public final void setTextSelectColor(int r5) {
        this.f14351t = r5;
    }

    public final void setTextUnselectColor(int r5) {
        this.f14352u = r5;
    }

    public final void setTextsize(float r5) {
        this.s = (int) ((r5 * this.f14337a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @JvmOverloads
    public OTabSegmentedLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OTabSegmentedLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OTabSegmentedLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.e = new Rect();
        new Rect();
        new Paint();
        new Paint(1);
        this.f14345m = 350;
        this.f14346n = true;
        this.f14355x = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        new Paint(1).setStyle(Paint.Style.FILL);
        new Paint(1).setStyle(Paint.Style.STROKE);
        new RectF();
        new RectF();
        this.f14356y = new ArrayList();
        new Paint(1);
        new SparseArray();
        Intrinsics.checkNotNullParameter(this, "this$0");
        g r13 = new g();
        this.f14357z = r13;
        Intrinsics.checkNotNullParameter(this, "this$0");
        g r5 = new g();
        this.A = r5;
        com.lynx.tasm.utils.a.E(10, this);
        com.lynx.tasm.utils.a.E(0, this);
        com.lynx.tasm.utils.a.E(4, this);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f14337a = r10;
        LinearLayout r14 = new LinearLayout(r10);
        this.f14338b = r14;
        addView(r14);
        TypedArray r15 = r10.obtainStyledAttributes(r11, R$styleable.OTabLayout);
        this.f14341i = r15.getColor(R$styleable.OTabLayout_indicator_color, getResources().getColor(R$color.oui_fill_seg_selected));
        this.f14342j = r15.getDimension(R$styleable.OTabLayout_indicator_height, -1.0f);
        this.f14343k = r15.getDimension(R$styleable.OTabLayout_indicator_corner_radius, -1.0f);
        this.f14344l = r15.getDimension(R$styleable.OTabLayout_indicator_spacing, a(4.0f));
        int r16 = (int) (getIndicatorSpacing() / 2);
        r14.setPadding(r16, 0, r16, 0);
        this.f14346n = r15.getBoolean(R$styleable.OTabLayout_indicator_anim_enable, false);
        this.f14347o = r15.getBoolean(R$styleable.OTabLayout_indicator_bounce_enable, true);
        this.f14348p = r15.getColor(R$styleable.OTabLayout_divider_color, this.f14341i);
        this.f14349q = r15.getDimension(R$styleable.OTabLayout_divider_width, a(1.0f));
        this.f14350r = r15.getDimension(R$styleable.OTabLayout_divider_padding, 0.0f);
        this.s = r15.getDimension(R$styleable.OTabLayout_tab_textSize, (int) ((13.0f * r10.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
        this.f14351t = r15.getColor(R$styleable.OTabLayout_tab_textSelectColor, Color.parseColor("#ffffff"));
        this.f14352u = r15.getColor(R$styleable.OTabLayout_tab_textUnselectColor, this.f14341i);
        this.f14353v = r15.getInt(R$styleable.OTabLayout_tab_textBold, 0);
        r15.getBoolean(R$styleable.OTabLayout_tab_textAllCaps, false);
        this.g = r15.getBoolean(R$styleable.OTabLayout_tab_space_equal, true);
        float r17 = r15.getDimension(R$styleable.OTabLayout_tab_width, a(-1.0f));
        this.f14340h = r17;
        int r18 = R$styleable.OTabLayout_tab_padding;
        if (this.g == false) goto L5;
    L8:
        int r19 = a(0.0f);
    L9:
        this.f = r15.getDimension(r18, r19);
        r15.getColor(R$styleable.OTabLayout_bar_stroke_color, r15.getColor(R$styleable.OTabLayout_bar_color, 0));
        r15.getDimension(R$styleable.OTabLayout_bar_stroke_width, a(0.0f));
        r15.getBoolean(R$styleable.OTabLayout_vibrate_on_tab_selected, true);
        r15.recycle();
        Intrinsics.checkNotNull(r11);
        String r20 = r11.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r20, "-1") == false) goto L13;
    L16:
        ValueAnimator r110 = ValueAnimator.ofObject(new d(this), new Object[]{r5, r13});
        this.f14354w = r110;
        r110.addUpdateListener(this);
        r110.addListener(this);
        return;
    L13:
        if (Intrinsics.areEqual(r20, "-2") == true) goto L16;
        TypedArray r111 = r10.obtainStyledAttributes(r11, new int[]{R.attr.layout_height});
        r111.getDimensionPixelSize(0, -2);
        r111.recycle();
        goto L16
    L5:
        if (r17 > 0.0f) goto L8;
        r19 = a(10.0f);
        goto L9
    }
}
