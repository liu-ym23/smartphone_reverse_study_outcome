package com.obric.oui.segmentedtab;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.m;
import com.obric.oui.common.style.n;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b(\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003UV\u0018B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010,\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010+\"\u0004\b.\u0010\u001eR$\u00100\u001a\u00020/2\u0006\u00100\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u0010\u0013R$\u00109\u001a\u00020/2\u0006\u00109\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u00102\"\u0004\b;\u00104R$\u0010<\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010+\"\u0004\b>\u0010\u001eR$\u0010?\u001a\u00020/2\u0006\u0010?\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u00102\"\u0004\bA\u00104R$\u0010B\u001a\u00020/2\u0006\u0010B\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u00102\"\u0004\bD\u00104R$\u0010H\u001a\u00020/2\u0006\u0010E\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u00102\"\u0004\bG\u00104R$\u0010I\u001a\u00020\b2\u0006\u0010I\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010+\"\u0004\bK\u0010\u001eR$\u0010L\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010+\"\u0004\bN\u0010\u001eR$\u0010O\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010+\"\u0004\bQ\u0010\u001eR$\u0010S\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u00107\"\u0004\bT\u0010\u0013¨\u0006W"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/d;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "", "enabled", "", "setEnabled", "(Z)V", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "Lcom/obric/oui/segmentedtab/e;", "listener", "setOnTabSelectListener", "(Lcom/obric/oui/segmentedtab/e;)V", "index", "setFragments", "(I)V", "", "D", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "<set-?>", "tabCount", "I", "getTabCount", "()I", "currentTab", "getCurrentTab", "setCurrentTab", "", "tabPadding", "getTabPadding", "()F", "setTabPadding", "(F)V", "tabSpaceEqual", "isTabSpaceEqual", "()Z", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextsize", "setTextsize", "textsize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textBold", "getTextBold", "setTextBold", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "com/obric/oui/segmentedtab/c", "com/obric/oui/segmentedtab/d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomToolBar extends OUIFrameLayout implements com.obric.oui.material.d, ValueAnimator.AnimatorUpdateListener {
    public static final /* synthetic */ int E = 0;
    public final float A;
    public final boolean B;
    public int C;
    public List D;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f14319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f14320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OUIFrameLayout f14321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f14323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f14325n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14326o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f14327p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f14328q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f14329r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14330t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14331u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f14332v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List f14333w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public jp.d f14334x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public jp.d f14335y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f14336z;

    @JvmOverloads
    public OBottomToolBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final void setFragments(int r5) {
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.C = r5;
        a.a.F(this.f14321j, r5);
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
        return this.f14322k;
    }

    public final int getDividerColor() {
        return this.f14326o;
    }

    public final float getDividerPadding() {
        return this.f14328q;
    }

    public final float getDividerWidth() {
        return this.f14327p;
    }

    public final int getTabCount() {
        return 0;
    }

    public final List<View> getTabList() {
        return this.D;
    }

    public final float getTabPadding() {
        return this.f14323l;
    }

    public final float getTabWidth() {
        return this.f14325n;
    }

    public final int getTextBold() {
        return this.f14331u;
    }

    public final int getTextSelectColor() {
        return this.s;
    }

    public final int getTextUnselectColor() {
        return this.f14330t;
    }

    public final float getTextsize() {
        return this.f14329r;
    }

    public final void n(boolean r5) {
        jp.d r10 = this.f14334x;
        if (r10 == null) goto L6;
        int r11 = jp.d.d;
        r10.a(false);
    L6:
        jp.d r12 = this.f14335y;
        if (r12 == null) goto L10;
        int r13 = jp.d.d;
        r12.a(false);
    L10:
        float r14 = this.f14336z;
        float r15 = this.A;
        if (r5 == false) goto L13;
        this.f14334x = n.c(this, r15, r14, getCurrentShadows(), this.f14333w);
        return;
    L13:
        this.f14335y = n.c(this, r14, r15, getCurrentShadows(), this.f14332v);
    }

    public final int o(float r5) {
        return (int) ((r5 * this.f14319h.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        com.lynx.tasm.utils.a.B(99, this);
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

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if ((r5 instanceof Bundle) == false) goto L7;
        Bundle r10 = (Bundle) r5;
        this.f14322k = r10.getInt("mCurrentTab");
        r5 = r10.getParcelable("instanceState");
        if (this.f14322k == 0) goto L7;
        this.f14320i.getChildCount();
    L7:
        super.onRestoreInstanceState(r5);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r5 = new Bundle();
        r5.putParcelable("instanceState", super.onSaveInstanceState());
        r5.putInt("mCurrentTab", this.f14322k);
        return r5;
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        OUIFrameLayout r10 = this.f14321j;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        com.obric.oui.material.n.r(r5, r10);
    }

    public final void setCurrentTab(int r5) {
        if (r5 != this.f14322k) goto L5;
        return;
    L5:
        this.f14322k = r5;
        setFragments(r5);
    }

    public final void setDividerColor(int r5) {
        this.f14326o = r5;
        invalidate();
    }

    public final void setDividerPadding(float r5) {
        this.f14328q = o(r5);
        invalidate();
    }

    public final void setDividerWidth(float r5) {
        this.f14327p = o(r5);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        Iterator r10 = this.D.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((View) r10.next()).setEnabled(r5);
        goto L4
    }

    public final void setOnTabSelectListener(e r5) {
    }

    public final void setTabList(List<View> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.D = r5;
    }

    public final void setTabPadding(float r5) {
        this.f14323l = o(r5);
    }

    public final void setTabSpaceEqual(boolean r5) {
        this.f14324m = r5;
    }

    public final void setTabWidth(float r5) {
        this.f14325n = o(r5);
    }

    public final void setTextAllCaps(boolean r5) {
    }

    public final void setTextBold(int r5) {
        this.f14331u = r5;
    }

    public final void setTextSelectColor(int r5) {
        this.s = r5;
    }

    public final void setTextUnselectColor(int r5) {
        this.f14330t = r5;
    }

    public final void setTextsize(float r5) {
        this.f14329r = (int) ((r5 * this.f14319h.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @JvmOverloads
    public OBottomToolBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBottomToolBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OBottomToolBar(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20, 8);
        boolean r5 = true;
        new Paint(1);
        new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        new Paint(1).setStyle(Paint.Style.FILL);
        new Paint(1).setStyle(Paint.Style.STROKE);
        new RectF();
        new RectF();
        this.f14336z = 0.988f;
        this.A = 1.0f;
        this.C = -1;
        this.D = new ArrayList();
        new Paint(1);
        new SparseArray();
        Intrinsics.checkNotNullParameter(this, "this$0");
        c r10 = new c();
        Intrinsics.checkNotNullParameter(this, "this$0");
        c r11 = new c();
        com.lynx.tasm.utils.a.B(99, this);
        setWillNotDraw(false);
        if (a.a.w(this) == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        this.B = r12;
        setClipChildren(false);
        setClipToPadding(false);
        this.f14319h = r18;
        LinearLayout r13 = new LinearLayout(r18);
        this.f14320i = r13;
        OUIFrameLayout r14 = new OUIFrameLayout(r18, null, 0, 14);
        this.f14321j = r14;
        r14.setRadius(com.lynx.tasm.utils.a.B(99, this));
        addView(r14);
        TypedArray r15 = r18.obtainStyledAttributes(r19, R$styleable.OTabLayout);
        r14.addView(r13);
        this.f14327p = r15.getDimension(R$styleable.OTabLayout_divider_width, o(1.0f));
        this.f14328q = r15.getDimension(R$styleable.OTabLayout_divider_padding, 0.0f);
        this.f14329r = r15.getDimension(R$styleable.OTabLayout_tab_textSize, (int) ((12.0f * r18.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
        this.s = r15.getColor(R$styleable.OTabLayout_tab_textSelectColor, r18.getColor(R$color.oui_text_1));
        this.f14330t = r15.getColor(R$styleable.OTabLayout_tab_textUnselectColor, r18.getColor(R$color.oui_text_3b));
        this.f14331u = r15.getInt(R$styleable.OTabLayout_tab_textBold, 0);
        r15.getBoolean(R$styleable.OTabLayout_tab_textAllCaps, false);
        this.f14324m = r15.getBoolean(R$styleable.OTabLayout_tab_space_equal, true);
        float r16 = r15.getDimension(R$styleable.OTabLayout_tab_width, o(-1.0f));
        this.f14325n = r16;
        int r17 = R$styleable.OTabLayout_tab_padding;
        if (this.f14324m == false) goto L11;
    L14:
        int r21 = o(0.0f);
    L15:
        this.f14323l = r15.getDimension(r17, r21);
        r15.getColor(R$styleable.OTabLayout_bar_stroke_color, r15.getColor(R$styleable.OTabLayout_bar_color, -1));
        r15.getDimension(R$styleable.OTabLayout_bar_stroke_width, o(0.0f));
        r15.getBoolean(R$styleable.OTabLayout_vibrate_on_tab_selected, false);
        int r22 = r15.getResourceId(R$styleable.OTabLayout_shadow_normal, 0);
        int r23 = r15.getResourceId(R$styleable.OTabLayout_shadow_pressed, 0);
        if (r22 == 0) goto L18;
        ArrayList r24 = com.obric.oui.common.style.i.o(r22, r18);
        List r25 = CollectionsKt.listOf(new m[]{(m) r24.get(0), (m) r24.get(1)});
        this.f14332v = r25;
        Intrinsics.checkNotNull(r25);
        m r26 = (m) CollectionsKt.getOrNull(r25, 0);
        List r110 = this.f14332v;
        Intrinsics.checkNotNull(r110);
        l(r26, (m) CollectionsKt.getOrNull(r110, 1), false);
    L18:
        if (r23 == 0) goto L21;
        ArrayList r27 = com.obric.oui.common.style.i.o(r23, r18);
        this.f14333w = CollectionsKt.listOf(new m[]{(m) r27.get(0), (m) r27.get(1)});
    L21:
        if (r15.getBoolean(R$styleable.OTabLayout_oui_widgetFitInsetBottom, true) == false) goto L24;
        a.a.B(RangesKt.coerceAtLeast(0, com.lynx.tasm.utils.j.r(this, null).bottom), this);
        setOnApplyWindowInsetsListener(new com.obric.oui.actionbar.v2.b(this, 2));
    L24:
        if (this.B == false) goto L40;
        this.C = r15.getInt(R$styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        String r28 = r15.getString(R$styleable.OTabLayout_oui_widgetMaterial);
        if (r28 != null) goto L28;
        r28 = getResources().getString(R$string.oui_material_bg_floating);
    L28:
        com.obric.oui.material.c[] r29 = MaterialToken.parseSet(r28, !a.a.v(this));
        r15.recycle();
        if (r29 != null) goto L32;
        r5 = false;
    L32:
        this.B = r5;
        if (r5 == false) goto L40;
        if (r29 == null) goto L40;
        int r30 = this.C;
        if (r30 == (-1)) goto L39;
        a.a.y(r14, r29, false, r30, 10);
        goto L40
    L39:
        a.a.y(r14, r29, false, 0, 14);
    L40:
        setShadowCornerRadius(com.lynx.tasm.utils.a.B(99, this));
        Intrinsics.checkNotNull(r19);
        String r31 = r19.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r31, "-1") == false) goto L44;
    L47:
        ValueAnimator.ofObject(new d(this), new Object[]{r11, r10}).addUpdateListener(this);
        return;
    L44:
        if (Intrinsics.areEqual(r31, "-2") == true) goto L47;
        TypedArray r32 = r18.obtainStyledAttributes(r19, new int[]{R.attr.layout_height});
        r32.getDimensionPixelSize(0, -2);
        r32.recycle();
        goto L47
    L11:
        if (r16 > 0.0f) goto L14;
        r21 = o(10.0f);
        goto L15
    L5:
        if (com.obric.oui.material.n.k() == false) goto L7;
        r12 = true;
        goto L8
    }
}
