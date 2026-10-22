package com.obric.oui.segmentedtab;

import android.R;
import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o9.q;
import u8.f;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005opqrsB'\b\u0007\u0012\u0006\u0010i\u001a\u00020h\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010j\u0012\b\b\u0002\u0010l\u001a\u00020\u0004¢\u0006\u0004\bm\u0010nJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R$\u0010)\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R$\u0010*\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00107\u001a\b\u0012\u0004\u0012\u0002000/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R$\u0010<\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.R$\u0010I\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010.R$\u0010P\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010,R\"\u0010S\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R$\u0010U\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010,\"\u0004\bW\u0010.R$\u0010X\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010\u0015\"\u0004\bZ\u0010\u0017R\"\u0010\\\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010R\u001a\u0004\b\\\u0010 \"\u0004\b]\u0010\"R$\u0010^\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010,\"\u0004\b`\u0010.R$\u0010d\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010\u0015R$\u0010e\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010\u0015\"\u0004\bg\u0010\u0017¨\u0006t"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "Landroid/widget/FrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "", "index", "", "setFragments", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "", "enabled", "setEnabled", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$e;", "listener", "setOnTabSelectListener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$d;", "setOnTabSelectAnimListener", "", "indicatorHeight", "getIndicatorHeight", "()F", "setIndicatorHeight", "(F)V", "dividerWidth", "getDividerWidth", "setDividerWidth", "tabPadding", "getTabPadding", "setTabPadding", "tabSpaceEqual", "isTabSpaceEqual", "()Z", "setTabSpaceEqual", "(Z)V", "tabWidth", "getTabWidth", "setTabWidth", "textSize", "getTextsize", "setTextsize", "textsize", "textBold", "getTextBold", "()I", "setTextBold", "(I)V", "", "Landroid/view/View;", "T", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "", "w", "J", "getIndicatorAnimDuration", "()J", "setIndicatorAnimDuration", "(J)V", "indicatorAnimDuration", "currentTab", "getCurrentTab", "setCurrentTab", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "<set-?>", "k", "I", "getTabCount", "tabCount", "x", "Z", "isIndicatorAnimEnable", "setIndicatorAnimEnable", "dividerColor", "getDividerColor", "setDividerColor", "dividerPadding", "getDividerPadding", "setDividerPadding", "y", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "textSelectColor", "getTextSelectColor", "setTextSelectColor", BaseSwitches.V, "F", "getIndicatorSpacing", "indicatorSpacing", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "e", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OTabSegmentedLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private float A;
    private float B;
    private float C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f7316J;
    private FragmentManager K;
    private ArrayList<Fragment> L;
    private final ValueAnimator M;
    private final PathInterpolator N;
    private final float[] O;
    private final Paint P;
    private final Paint Q;
    private final RectF R;
    private final RectF S;
    private List<View> T;
    private boolean U;
    private d V;
    private final b W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final b f7317a0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7318c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinearLayout f7319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Rect f7324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Rect f7325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Paint f7326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint f7327o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f7328p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7329q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f7330r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f7331s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f7332t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f7333u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f7334v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f7335w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f7336x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f7337y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f7338z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f7340b;

        public b(OTabSegmentedLayout r10) {
        }

        public final float a() {
            return this.f7339a;
        }

        public final float b() {
            return this.f7340b;
        }

        public final void c(float r10) {
            this.f7339a = r10;
        }

        public final void d(float r10) {
            this.f7340b = r10;
        }

        public String toString() {
            return "(left = " + this.f7339a + ", right = " + this.f7340b + ')';
        }
    }

    public final class c implements TypeEvaluator<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabSegmentedLayout f7341a;

        public c(OTabSegmentedLayout r10) {
            this.f7341a = r10;
        }

        public b a(float r10, b r11, b r12) {
            Intrinsics.checkNotNullParameter(r11, "startValue");
            Intrinsics.checkNotNullParameter(r12, "endValue");
            float r13 = r11.a() + ((r12.a() - r11.a()) * r10);
            float r14 = r11.b() + (r10 * (r12.b() - r11.b()));
            b r15 = new b(this.f7341a);
            r15.c(r13);
            r15.d(r14);
            return r15;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ b evaluate(float r10, b r11, b r12) {
            return a(r10, r11, r12);
        }
    }

    public interface d {
        void a();

        void b();

        void c();
    }

    public interface e {
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OTabSegmentedLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OTabSegmentedLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OTabSegmentedLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7321i = -1;
        this.f7324l = new Rect();
        this.f7325m = new Rect();
        this.f7326n = new Paint();
        this.f7327o = new Paint(1);
        this.f7335w = 350;
        this.f7336x = true;
        this.N = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.O = new float[8];
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        Unit r14 = Unit.INSTANCE;
        this.P = r13;
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.STROKE);
        this.Q = r15;
        this.R = new RectF();
        this.S = new RectF();
        this.T = new ArrayList();
        this.U = true;
        new Paint(1);
        new SparseArray();
        b r16 = new b(this);
        this.W = r16;
        b r17 = new b(this);
        this.f7317a0 = r17;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f7318c = r10;
        LinearLayout r18 = new LinearLayout(r10);
        this.f7319g = r18;
        addView(r18);
        f(r10, r11);
        Intrinsics.checkNotNull(r11);
        String r19 = r11.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (r19 == null) goto L16;
        int r20 = r19.hashCode();
        if (r20 == 1444) goto L14;
        if (r20 != 1445) goto L16;
        if (r19.equals("-2") == false) goto L16;
    L17:
        ValueAnimator r21 = ValueAnimator.ofObject(new c(this), new Object[]{r17, r16});
        Intrinsics.checkNotNullExpressionValue(r21, "ValueAnimator.ofObject(P…tor(), mLastP, mCurrentP)");
        this.M = r21;
        r21.addUpdateListener(this);
        r21.addListener(this);
        return;
    L14:
        if (r19.equals("-1") == true) goto L17;
    L16:
        TypedArray r22 = r10.obtainStyledAttributes(r11, new int[]{R.attr.layout_height});
        Intrinsics.checkNotNullExpressionValue(r22, "context.obtainStyledAttributes(attrs, systemAttrs)");
        r22.getDimensionPixelSize(0, -2);
        r22.recycle();
        goto L17
    }

    public /* synthetic */ OTabSegmentedLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(TextPaint r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = TypedValues.TransitionType.TYPE_DURATION;
    L5:
        r10.setTypeface(Typeface.create(null, r12, false));
        return;
    L4:
        r12 = 400;
        goto L5
    }

    private final void b() {
        int r10 = this.f7321i;
        if (r10 == (-1)) goto L5;
        View r11 = this.f7319g.getChildAt(r10);
    L6:
        if (r11 == null) goto L9;
        Rect r12 = this.f7325m;
        r12.left = r11.getLeft();
        Rect r13 = this.f7325m;
        r13.right = r11.getRight();
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private final void c() {
        View r10 = this.f7319g.getChildAt(this.f7320h);
        Intrinsics.checkNotNullExpressionValue(r10, "currentTabView");
        float r11 = r10.getLeft();
        float r12 = r10.getRight();
        Rect r13 = this.f7324l;
        r13.left = (int) r11;
        r13.right = (int) r12;
        if (this.f7336x == true) goto L11;
        int r14 = this.f7320h;
        if (r14 != 0) goto L8;
        float[] r15 = this.O;
        float r16 = this.f7333u;
        r15[0] = r16;
        r15[1] = r16;
        r15[2] = 0.0f;
        r15[3] = 0.0f;
        r15[4] = 0.0f;
        r15[5] = 0.0f;
        r15[6] = r16;
        r15[7] = r16;
        return;
    L8:
        if (r14 != (this.f7323k - 1)) goto L10;
        float[] r17 = this.O;
        r17[0] = 0.0f;
        r17[1] = 0.0f;
        float r18 = this.f7333u;
        r17[2] = r18;
        r17[3] = r18;
        r17[4] = r18;
        r17[5] = r18;
        r17[6] = 0.0f;
        r17[7] = 0.0f;
        return;
    L10:
        float[] r19 = this.O;
        r19[0] = 0.0f;
        r19[1] = 0.0f;
        r19[2] = 0.0f;
        r19[3] = 0.0f;
        r19[4] = 0.0f;
        r19[5] = 0.0f;
        r19[6] = 0.0f;
        r19[7] = 0.0f;
        return;
    L11:
        float[] r20 = this.O;
        float r110 = this.f7333u;
        r20[0] = r110;
        r20[1] = r110;
        r20[2] = r110;
        r20[3] = r110;
        r20[4] = r110;
        r20[5] = r110;
        r20[6] = r110;
        r20[7] = r110;
    }

    private final void d() {
        View r10 = this.f7319g.getChildAt(this.f7320h);
        b r11 = this.W;
        Intrinsics.checkNotNullExpressionValue(r10, "currentTabView");
        r11.c(r10.getLeft());
        this.W.d(r10.getRight());
        View r12 = this.f7319g.getChildAt(this.f7322j);
        b r13 = this.f7317a0;
        Intrinsics.checkNotNullExpressionValue(r12, "lastTabView");
        r13.c(r12.getLeft());
        this.f7317a0.d(r12.getRight());
        if (this.f7317a0.a() == this.W.a()) goto L5;
    L7:
        this.M.setObjectValues(new Object[]{this.f7317a0, this.W});
        if (this.f7337y == false) goto L10;
        this.M.setInterpolator(this.N);
    L10:
        this.M.setDuration(350);
        this.M.start();
        return;
    L5:
        if (this.f7317a0.b() != this.W.b()) goto L7;
        invalidate();
    }

    private final int e(float r10) {
        Resources r11 = this.f7318c.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "mContext.resources");
        return (int) ((r10 * r11.getDisplayMetrics().density) + 0.5f);
    }

    private final void f(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.f7331s = r12.getColor(l.OTabLayout_indicator_color, getResources().getColor(u8.c.oui_fill_seg_selected));
        this.f7332t = r12.getDimension(l.OTabLayout_indicator_height, -1.0f);
        this.f7333u = r12.getDimension(l.OTabLayout_indicator_corner_radius, -1.0f);
        float r13 = r12.getDimension(l.OTabLayout_indicator_spacing, e(4.0f));
        this.f7334v = r13;
        int r14 = (int) (r13 / 2);
        this.f7319g.setPadding(r14, 0, r14, 0);
        this.f7336x = r12.getBoolean(l.OTabLayout_indicator_anim_enable, false);
        this.f7337y = r12.getBoolean(l.OTabLayout_indicator_bounce_enable, true);
        this.f7338z = r12.getColor(l.OTabLayout_divider_color, this.f7331s);
        this.A = r12.getDimension(l.OTabLayout_divider_width, e(1.0f));
        this.B = r12.getDimension(l.OTabLayout_divider_padding, 0.0f);
        this.C = r12.getDimension(l.OTabLayout_tab_textSize, g(13.0f));
        this.D = r12.getColor(l.OTabLayout_tab_textSelectColor, Color.parseColor("#ffffff"));
        this.E = r12.getColor(l.OTabLayout_tab_textUnselectColor, this.f7331s);
        this.F = r12.getInt(l.OTabLayout_tab_textBold, 0);
        this.G = r12.getBoolean(l.OTabLayout_tab_textAllCaps, false);
        this.f7329q = r12.getBoolean(l.OTabLayout_tab_space_equal, true);
        float r15 = r12.getDimension(l.OTabLayout_tab_width, e(-1.0f));
        this.f7330r = r15;
        int r16 = l.OTabLayout_tab_padding;
        if (this.f7329q == false) goto L5;
    L8:
        int r17 = e(0.0f);
    L9:
        this.f7328p = r12.getDimension(r16, r17);
        int r18 = r12.getColor(l.OTabLayout_bar_color, 0);
        this.H = r18;
        this.I = r12.getColor(l.OTabLayout_bar_stroke_color, r18);
        this.f7316J = r12.getDimension(l.OTabLayout_bar_stroke_width, e(0.0f));
        r12.getBoolean(l.OTabLayout_vibrate_on_tab_selected, true);
        r12.recycle();
        return;
    L5:
        if (r15 > 0) goto L8;
        r17 = e(10.0f);
        goto L9
    }

    private final int g(float r10) {
        Resources r11 = this.f7318c.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "mContext.resources");
        return (int) ((r10 * r11.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void h(int r10) {
        int r11 = this.f7323k;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L23;
        View r13 = this.f7319g.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r14 = true;
    L8:
        View r15 = r13.findViewById(f.tv_tab_title);
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.widget.TextView");
        TextView r16 = (TextView) r15;
        ImageView r17 = (ImageView) r13.findViewById(f.tv_tab_icon);
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        if (r14 == false) goto L11;
        int r18 = this.D;
    L12:
        r17.setImageTintList(ColorStateList.valueOf(r18));
        if (this.F != 1) goto L15;
        TextPaint r19 = r16.getPaint();
        Intrinsics.checkNotNullExpressionValue(r19, "tabTitle.paint");
        a(r19, r14);
        r16.invalidate();
    L15:
        da.c r20 = da.c.f8520a;
        if ((r13 instanceof OSegmentTabView) == true) goto L19;
        r13 = null;
    L19:
        OSegmentTabView r21 = (OSegmentTabView) r13;
        if (r21 == null) goto L22;
        r21.k(r14);
    L22:
        r12 = r12 + 1;
        goto L3
    L11:
        r18 = this.E;
        goto L12
    L7:
        r14 = false;
        goto L8
    }

    private final void i() {
        int r10 = this.f7323k;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L26;
        View r12 = this.f7319g.getChildAt(r11);
        float r13 = this.f7328p;
        r12.setPadding((int) r13, 0, (int) r13, 0);
        View r14 = r12.findViewById(f.tv_tab_title);
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.TextView");
        TextView r15 = (TextView) r14;
        int r16 = this.f7320h;
        if (r11 != r16) goto L7;
        boolean r17 = true;
    L8:
        if (r11 != r16) goto L10;
        int r18 = this.D;
    L11:
        r15.setTextColor(r18);
        r15.setTextSize(0, this.C);
        ImageView r19 = (ImageView) r12.findViewById(f.tv_tab_icon);
        Intrinsics.checkNotNullExpressionValue(r19, "it");
        if (r11 != this.f7320h) goto L14;
        int r20 = this.D;
    L15:
        r19.setImageTintList(ColorStateList.valueOf(r20));
        if (this.G == false) goto L18;
        String r21 = r15.getText().toString();
        Locale r22 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r22, "Locale.ROOT");
        String r23 = r21.toUpperCase(r22);
        Intrinsics.checkNotNullExpressionValue(r23, "this as java.lang.String).toUpperCase(locale)");
        r15.setText(r23);
    L18:
        int r24 = this.F;
        if (r24 != 2) goto L21;
        TextPaint r25 = r15.getPaint();
        Intrinsics.checkNotNullExpressionValue(r25, "tvTabTitle.paint");
        a(r25, true);
    L25:
        r11 = r11 + 1;
        goto L3
    L21:
        if (r24 != 0) goto L23;
        TextPaint r26 = r15.getPaint();
        Intrinsics.checkNotNullExpressionValue(r26, "tvTabTitle.paint");
        a(r26, false);
        goto L25
    L23:
        if (r24 != 1) goto L25;
        TextPaint r27 = r15.getPaint();
        Intrinsics.checkNotNullExpressionValue(r27, "tvTabTitle.paint");
        a(r27, r17);
        goto L25
    L14:
        r20 = this.E;
        goto L15
    L10:
        r18 = this.E;
        goto L11
    L7:
        r17 = false;
        goto L8
    }

    private final void setFragments(int r10) {
        ArrayList<Fragment> r11 = this.L;
        if (r11 == null) goto L16;
        int r12 = 0;
        int r13 = r11.size();
    L5:
        if (r12 >= r13) goto L11;
        FragmentManager r14 = this.K;
        Intrinsics.checkNotNull(r14);
        FragmentTransaction r15 = r14.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r15, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r16 = this.L;
        Intrinsics.checkNotNull(r16);
        Fragment r17 = r16.get(r12);
        Intrinsics.checkNotNullExpressionValue(r17, "mFragments!![i]");
        Fragment r18 = r17;
        if (r12 != r10) goto L9;
        r15.show(r18);
    L10:
        r15.commit();
        r12 = r12 + 1;
        goto L5
    L9:
        r15.hide(r18);
        goto L10
    L11:
        this.f7320h = r10;
        return;
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r10 = this.L;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get(this.f7320h);
    }

    public final int getCurrentTab() {
        return this.f7320h;
    }

    public final int getDividerColor() {
        return this.f7338z;
    }

    public final float getDividerPadding() {
        return this.B;
    }

    public final float getDividerWidth() {
        return this.A;
    }

    public final long getIndicatorAnimDuration() {
        return this.f7335w;
    }

    public final int getIndicatorColor() {
        return this.f7331s;
    }

    public final float getIndicatorCornerRadius() {
        return this.f7333u;
    }

    public final float getIndicatorHeight() {
        return this.f7332t;
    }

    public final float getIndicatorSpacing() {
        return this.f7334v;
    }

    public final int getTabCount() {
        return this.f7323k;
    }

    public final List<View> getTabList() {
        return this.T;
    }

    public final float getTabPadding() {
        return this.f7328p;
    }

    public final float getTabWidth() {
        return this.f7330r;
    }

    public final int getTextBold() {
        return this.F;
    }

    public final int getTextSelectColor() {
        return this.D;
    }

    public final int getTextUnselectColor() {
        return this.E;
    }

    public final float getTextsize() {
        return this.C;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        d r11 = this.V;
        if (r11 == null) goto L6;
        r11.c();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        d r11 = this.V;
        if (r11 == null) goto L6;
        r11.b();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        d r11 = this.V;
        if (r11 == null) goto L6;
        r11.a();
        return;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        Object r11 = r10.getAnimatedValue();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
        b r12 = (b) r11;
        Rect r13 = this.f7324l;
        r13.left = (int) r12.a();
        Rect r14 = this.f7324l;
        r14.right = (int) r12.b();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        super.onDraw(r17);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f7323k <= 0) goto L35;
        int r10 = getHeight();
        int r11 = getPaddingLeft();
        float r12 = 0;
        if (this.f7332t >= r12) goto L10;
        this.f7332t = r10 - (this.f7334v * 2);
    L10:
        float r13 = this.f7333u;
        if (r13 >= r12) goto L13;
    L14:
        this.f7333u = this.f7332t;
    L15:
        this.P.setColor(this.H);
        this.R.set(0.0f, getPaddingTop(), getWidth(), r10 - getPaddingBottom());
        float r14 = 2;
        float r15 = this.f7333u + (this.f7334v / r14);
        q.i(r17, this.R, r15, this.P);
        if (this.f7316J <= r12) goto L19;
        this.Q.setColor(this.I);
        this.Q.setStrokeWidth(this.f7316J);
        this.S.set(this.f7316J / r14, getPaddingTop() + (this.f7316J / r14), getWidth() - (this.f7316J / r14), (r10 - getPaddingBottom()) - (this.f7316J / r14));
        q.i(r17, this.S, r15, this.Q);
    L19:
        if (this.f7336x == true) goto L26;
        float r16 = this.A;
        if (r16 <= r12) goto L26;
        this.f7327o.setStrokeWidth(r16);
        this.f7327o.setColor(this.f7338z);
        int r18 = this.f7323k - 1;
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L26;
        View r20 = this.f7319g.getChildAt(r19);
        Intrinsics.checkNotNullExpressionValue(r20, "tab");
        r17.drawLine(r20.getRight() + r11, this.B, r20.getRight() + r11, r10 - this.B, this.f7327o);
        r19 = r19 + 1;
    L26:
        if (this.f7336x == true) goto L28;
    L30:
        c();
    L31:
        b();
        float r21 = (this.f7334v / r14) + this.f7316J;
        Paint r22 = this.f7326n;
        r22.setColor(this.f7331s);
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        float r24 = TypedValue.applyDimension(1, 10, r23.getDisplayMetrics());
        Resources r25 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r25, "Resources.getSystem()");
        float r26 = TypedValue.applyDimension(1, r12, r25.getDisplayMetrics());
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        r22.setShadowLayer(r24, r26, TypedValue.applyDimension(1, 4, r27.getDisplayMetrics()), ContextCompat.getColor(getContext(), u8.c.TabSegmentedShadowColor));
        Rect r28 = this.f7324l;
        float r29 = (r11 + r21) + r28.left;
        float r30 = this.f7334v;
        float r31 = this.f7316J;
        q.h(r17, r29, r30 + r31, (r11 + r28.right) - r21, (r30 + this.f7332t) - r31, this.f7333u, this.f7326n);
        return;
    L28:
        if (this.U == false) goto L31;
        this.U = false;
        goto L30
    L13:
        if (r13 <= (this.f7332t / 2)) goto L15;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        if ((r10 instanceof Bundle) == false) goto L9;
        Bundle r11 = (Bundle) r10;
        this.f7320h = r11.getInt("mCurrentTab");
        r10 = r11.getParcelable("instanceState");
        if (this.f7320h == 0) goto L9;
        if (this.f7319g.getChildCount() <= 0) goto L9;
        h(this.f7320h);
    L9:
        super.onRestoreInstanceState(r10);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle r10 = new Bundle();
        r10.putParcelable("instanceState", super.onSaveInstanceState());
        r10.putInt("mCurrentTab", this.f7320h);
        return r10;
    }

    public final void setCurrentTab(int r10) {
        int r11 = this.f7320h;
        if (r10 != r11) goto L5;
        return;
    L5:
        this.U = true;
        this.f7322j = r11;
        this.f7320h = r10;
        Log.d("OTabSegmentedLayout", "setCurrentTab, currentTab: " + r10 + ", lastTab: " + this.f7322j);
        h(r10);
        setFragments(r10);
        if (this.f7336x == false) goto L8;
        d();
        return;
    L8:
        invalidate();
    }

    public final void setDividerColor(int r10) {
        this.f7338z = r10;
        invalidate();
    }

    public final void setDividerPadding(float r10) {
        this.B = e(r10);
        invalidate();
    }

    public final void setDividerWidth(float r10) {
        this.A = e(r10);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator<View> r11 = this.T.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setEnabled(r10);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r10) {
        this.f7335w = r10;
    }

    public final void setIndicatorAnimEnable(boolean r10) {
        this.f7336x = r10;
    }

    public final void setIndicatorBounceEnable(boolean r10) {
        this.f7337y = r10;
    }

    public final void setIndicatorColor(int r10) {
        this.f7331s = r10;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r10) {
        this.f7333u = e(r10);
        invalidate();
    }

    public final void setIndicatorHeight(float r10) {
        this.f7332t = e(r10);
        invalidate();
    }

    public final void setOnTabSelectAnimListener(d r10) {
        this.V = r10;
    }

    public final void setOnTabSelectListener(e r10) {
    }

    public final void setTabList(List<View> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.T = r10;
    }

    public final void setTabPadding(float r10) {
        this.f7328p = e(r10);
        i();
    }

    public final void setTabSpaceEqual(boolean r10) {
        this.f7329q = r10;
        i();
    }

    public final void setTabWidth(float r10) {
        this.f7330r = e(r10);
        i();
    }

    public final void setTextAllCaps(boolean r10) {
        this.G = r10;
        i();
    }

    public final void setTextBold(int r10) {
        this.F = r10;
        i();
    }

    public final void setTextSelectColor(int r10) {
        this.D = r10;
        i();
    }

    public final void setTextUnselectColor(int r10) {
        this.E = r10;
        i();
    }

    public final void setTextsize(float r10) {
        this.C = g(r10);
        i();
    }
}
