package com.obric.oui.segmentedtab;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.obric.oui.common.style.n;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b:\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001b\u0017B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010 R(\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010.\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R*\u00107\u001a\u00020/2\u0006\u00100\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b8\u0010+\u001a\u0004\b9\u0010-R\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b:\u0010<\"\u0004\b=\u0010\u0012R(\u0010>\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b>\u0010;\u0012\u0004\b@\u0010A\u001a\u0004\b>\u0010<\"\u0004\b?\u0010\u0012R$\u0010B\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010-\"\u0004\bD\u0010 R$\u0010E\u001a\u00020/2\u0006\u0010E\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u00104\"\u0004\bG\u00106R$\u0010I\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010\u0012R$\u0010K\u001a\u00020/2\u0006\u0010K\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u00104\"\u0004\bM\u00106R$\u0010N\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010-\"\u0004\bP\u0010 R$\u0010S\u001a\u00020/2\u0006\u00100\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u00104\"\u0004\bR\u00106R$\u0010T\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010-\"\u0004\bV\u0010 R$\u0010W\u001a\u00020/2\u0006\u0010W\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u00104\"\u0004\bY\u00106R$\u0010Z\u001a\u00020/2\u0006\u0010Z\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R$\u0010]\u001a\u00020/2\u0006\u0010]\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u00104\"\u0004\b_\u00106R$\u0010`\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010-\"\u0004\bb\u0010 R$\u0010c\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010-\"\u0004\be\u0010 R$\u0010g\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010<\"\u0004\bh\u0010\u0012¨\u0006i"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "", "enabled", "", "setEnabled", "(Z)V", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "Lcom/obric/oui/segmentedtab/b;", "listener", "setOnTabSelectListener", "(Lcom/obric/oui/segmentedtab/b;)V", "Lcom/obric/oui/segmentedtab/a;", "setOnTabSelectAnimListener", "(Lcom/obric/oui/segmentedtab/a;)V", "index", "setFragments", "(I)V", "", "l", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "<set-?>", "q", "I", "getIndicatorSpacing", "()I", "indicatorSpacing", "", "value", "H", "F", "getIndicatorCornerRadius", "()F", "setIndicatorCornerRadius", "(F)V", "indicatorCornerRadius", "tabCount", "getTabCount", "isIndicatorAnimEnable", "Z", "()Z", "setIndicatorAnimEnable", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "isIndicatorBounceEnable$annotations", "()V", "currentTab", "getCurrentTab", "setCurrentTab", "tabPadding", "getTabPadding", "setTabPadding", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "getIndicatorHeight", "setIndicatorHeight", "indicatorHeight", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextSize", "setTextSize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavActionBar extends OUIFrameLayout implements com.obric.oui.material.d {
    public jp.d A;
    public final float B;
    public final float C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public float H;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f14294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f14295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OUIFrameLayout f14296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f14298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f14299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f14301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f f14302p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14303q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14304r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f14305t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f14306u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14307v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14308w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List f14309x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f14310y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public jp.d f14311z;

    @JvmOverloads
    public OBottomNavActionBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final void setFragments(int r5) {
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.F = r5;
        a.a.F(this, r5);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r10 = r5.getAction();
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L6;
    L8:
        n(false);
    L11:
        return super.dispatchTouchEvent(r5);
    L6:
        if (r10 == 3) goto L8;
    L9:
        n(true);
        goto L11
    }

    public final Fragment getCurrentFragment() {
        return null;
    }

    public final int getCurrentTab() {
        return this.f14297k;
    }

    public final int getDividerColor() {
        return this.f14304r;
    }

    public final float getDividerPadding() {
        return this.f14305t;
    }

    public final float getDividerWidth() {
        return this.s;
    }

    public final int getIndicatorColor() {
        return this.f14302p.f;
    }

    public final float getIndicatorCornerRadius() {
        return this.H;
    }

    public final float getIndicatorHeight() {
        return this.f14302p.f14372i;
    }

    public final int getIndicatorSpacing() {
        return this.f14303q;
    }

    public final int getTabCount() {
        return 0;
    }

    public final List<View> getTabList() {
        return this.f14298l;
    }

    public final float getTabPadding() {
        return this.f14299m;
    }

    public final float getTabWidth() {
        return this.f14301o;
    }

    public final int getTextSelectColor() {
        return this.f14307v;
    }

    public final float getTextSize() {
        return this.f14306u;
    }

    public final int getTextUnselectColor() {
        return this.f14308w;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        super.invalidateDrawable(r5);
        if (Intrinsics.areEqual(r5, this.f14302p) == false) goto L6;
        invalidate();
        return;
    }

    public final void n(boolean r5) {
        jp.d r10 = this.f14311z;
        if (r10 == null) goto L6;
        int r11 = jp.d.d;
        r10.a(false);
    L6:
        jp.d r12 = this.A;
        if (r12 == null) goto L10;
        int r13 = jp.d.d;
        r12.a(false);
    L10:
        float r14 = this.B;
        float r15 = this.C;
        if (r5 == false) goto L13;
        this.f14311z = n.c(this, r15, r14, getCurrentShadows(), this.f14310y);
        return;
    L13:
        this.A = n.c(this, r14, r15, getCurrentShadows(), this.f14309x);
    }

    public final int o(float r5) {
        return (int) ((r5 * this.f14294h.getResources().getDisplayMetrics().density) + 0.5f);
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
        int r14 = getHeight();
        int r15 = this.f14303q;
        f r16 = this.f14302p;
        if (r16.f14372i >= 0.0f) goto L5;
        r16.a(r14 - (r15 * 2.0f));
    L5:
        float r17 = r16.g;
        if (r17 >= 0.0f) goto L8;
    L9:
        float r18 = r16.f14372i;
        if (r17 == r18) goto L14;
        r16.g = r18;
        r16.invalidateSelf();
    L14:
        if (getWidth() == this.G) goto L17;
        this.G = getWidth();
        return;
    L17:
        return;
    L8:
        if (r17 <= (r16.f14372i / 2)) goto L14;
        goto L9
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if ((r5 instanceof Bundle) == false) goto L7;
        Bundle r10 = (Bundle) r5;
        this.f14297k = r10.getInt("mCurrentTab");
        r5 = r10.getParcelable("instanceState");
        if (this.f14297k == 0) goto L7;
        this.f14295i.getChildCount();
    L7:
        super.onRestoreInstanceState(r5);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r5 = new Bundle();
        r5.putInt("mCurrentTab", this.f14297k);
        r5.putParcelable("instanceState", super.onSaveInstanceState());
        return r5;
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.obric.oui.material.n.r(r5, this);
    }

    public final void setCurrentTab(int r5) {
        if (r5 != this.f14297k) goto L5;
        return;
    L5:
        this.f14297k = r5;
        setFragments(r5);
        if (this.f14302p.f14373j == true) goto L9;
        invalidate();
        return;
    L9:
        Intrinsics.checkNotNull(null);
        throw null;
    }

    public final void setDividerColor(int r5) {
        this.f14304r = r5;
        invalidate();
    }

    public final void setDividerPadding(float r5) {
        this.f14305t = o(r5);
        invalidate();
    }

    public final void setDividerWidth(float r5) {
        this.s = o(r5);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        Iterator r10 = this.f14298l.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((View) r10.next()).setEnabled(r5);
        goto L4
    }

    public final void setIndicatorAnimEnable(boolean r5) {
    }

    public final void setIndicatorBounceEnable(boolean r5) {
    }

    public final void setIndicatorColor(int r5) {
        f r10 = this.f14302p;
        if (r10.f == r5) goto L6;
        r10.f = r5;
        r10.f14368a.setColor(r5);
        r10.invalidateSelf();
        return;
    }

    public final void setIndicatorCornerRadius(float r5) {
        float r10 = o(r5);
        f r11 = this.f14302p;
        if (r11.g == r10) goto L6;
        r11.g = r10;
        r11.invalidateSelf();
    L6:
        this.H = r11.g;
    }

    public final void setIndicatorHeight(float r5) {
        this.f14302p.a(o(r5));
    }

    public final void setOnTabSelectAnimListener(a r5) {
        this.f14302p.getClass();
    }

    public final void setOnTabSelectListener(b r5) {
    }

    public final void setTabList(List<View> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14298l = r5;
    }

    public final void setTabPadding(float r5) {
        this.f14299m = o(r5);
    }

    public final void setTabSpaceEqual(boolean r5) {
        this.f14300n = r5;
    }

    public final void setTabWidth(float r5) {
        this.f14301o = o(r5);
    }

    public final void setTextAllCaps(boolean r5) {
    }

    public final void setTextSelectColor(int r5) {
        this.f14307v = r5;
    }

    public final void setTextSize(float r5) {
        this.f14306u = (int) ((r5 * this.f14294h.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final void setTextUnselectColor(int r5) {
        this.f14308w = r5;
    }

    @JvmOverloads
    public OBottomNavActionBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBottomNavActionBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OBottomNavActionBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11, 8);
        this.f14298l = new ArrayList();
        new Paint(1);
        this.f14302p = new f();
        new Paint(1).setStyle(Paint.Style.FILL);
        new Paint(1).setStyle(Paint.Style.STROKE);
        new RectF();
        new RectF();
        this.B = 0.988f;
        this.C = 1.0f;
        this.F = -1;
        this.G = -1;
        if (a.a.w(this) == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        this.D = r12;
        this.E = r12;
        new Paint(1);
        new SparseArray();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f14294h = r5;
        this.f14295i = new LinearLayout(r5);
        OUIFrameLayout r13 = new OUIFrameLayout(r5, null, 0, 14);
        this.f14296j = r13;
        r13.setRadius(com.lynx.tasm.utils.a.B(99, this));
        r13.setChangeAlphaWhenPress(false);
        r13.setChangeAlphaWhenDisable(false);
        r13.setChangeAlphaWhenSelected(false);
        addView(r13);
        Intrinsics.checkNotNull(r10);
        String r14 = r10.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r14, "-1") == false) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r14, "-2") == true) goto L17;
        TypedArray r15 = r5.obtainStyledAttributes(r10, new int[]{R.attr.layout_height});
        r15.getDimensionPixelSize(0, -2);
        r15.recycle();
        return;
    L17:
        return;
    L5:
        if (com.obric.oui.material.n.k() == false) goto L7;
        r12 = true;
        goto L8
    }
}
