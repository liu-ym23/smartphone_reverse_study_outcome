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
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import o9.k;
import o9.p;
import o9.q;
import u8.f;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005nopqrB'\b\u0007\u0012\u0006\u0010h\u001a\u00020g\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010i\u0012\b\b\u0002\u0010k\u001a\u00020\u0004¢\u0006\u0004\bl\u0010mJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010R$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010$\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001aR\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00100\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0014R(\u00109\u001a\b\u0012\u0004\u0012\u000202018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016R$\u0010>\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010B\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR$\u0010E\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010\u0016R$\u0010H\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u001a\"\u0004\bJ\u0010\u001cR$\u0010L\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010?\"\u0004\bM\u0010AR$\u0010N\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\u001a\"\u0004\bP\u0010\u001cR$\u0010Q\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0014\"\u0004\bS\u0010\u0016R\"\u0010U\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010B\u001a\u0004\bU\u0010?\"\u0004\bV\u0010AR$\u0010W\u001a\u00020\u00172\u0006\u0010W\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010\u001a\"\u0004\bY\u0010\u001cR$\u0010Z\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\u0014\"\u0004\b\\\u0010\u0016R$\u0010]\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u001a\"\u0004\b_\u0010\u001cR$\u0010c\u001a\u00020\u00172\u0006\u0010`\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u001a\"\u0004\bb\u0010\u001cR$\u0010d\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\be\u0010\u001a\"\u0004\bf\u0010\u001c¨\u0006s"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "", "index", "", "setFragments", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "", "enabled", "setEnabled", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$e;", "listener", "setOnTabSelectListener", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$d;", "setOnTabSelectAnimListener", "textUnselectColor", "getTextUnselectColor", "()I", "setTextUnselectColor", "(I)V", "", "indicatorCornerRadius", "getIndicatorCornerRadius", "()F", "setIndicatorCornerRadius", "(F)V", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "<set-?>", "C", "F", "getIndicatorSpacing", "indicatorSpacing", "", "D", "J", "getIndicatorAnimDuration", "()J", "setIndicatorAnimDuration", "(J)V", "indicatorAnimDuration", "r", "I", "getTabCount", "tabCount", "", "Landroid/view/View;", "m0", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "currentTab", "getCurrentTab", "setCurrentTab", "tabSpaceEqual", "isTabSpaceEqual", "()Z", "setTabSpaceEqual", "(Z)V", "Z", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "tabWidth", "getTabWidth", "setTabWidth", "textBold", "getTextBold", "setTextBold", "E", "isIndicatorAnimEnable", "setIndicatorAnimEnable", "tabPadding", "getTabPadding", "setTabPadding", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "textSize", "getTextsize", "setTextsize", "textsize", "dividerPadding", "getDividerPadding", "setDividerPadding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "e", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomNavActionBar extends OUIFrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private float A;
    private float B;
    private float C;
    private long D;
    private boolean E;
    private boolean F;
    private int G;
    private float H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f7243J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private int O;
    private int P;
    private float Q;
    private FragmentManager R;
    private ArrayList<Fragment> S;
    private final ValueAnimator T;
    private final PathInterpolator U;
    private final float[] V;
    private List<p> W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private List<p> f7244a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Paint f7245b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final Paint f7246c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final RectF f7247d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final RectF f7248e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private n8.d f7249f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private n8.d f7250g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f7251h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private float f7252i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f7253j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private float f7254k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Context f7255l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f7256l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LinearLayout f7257m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private List<View> f7258m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OUIFrameLayout f7259n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f7260n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7261o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private d f7262o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7263p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final b f7264p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f7265q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final b f7266q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f7267r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f7268s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f7269t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Paint f7270u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Paint f7271v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f7272w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f7273x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f7274y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f7275z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f7277b;

        public b(OBottomNavActionBar r10) {
        }

        public final float a() {
            return this.f7276a;
        }

        public final float b() {
            return this.f7277b;
        }

        public final void c(float r10) {
            this.f7276a = r10;
        }

        public final void d(float r10) {
            this.f7277b = r10;
        }

        public String toString() {
            return "(left = " + this.f7276a + ", right = " + this.f7277b + ')';
        }
    }

    public final class c implements TypeEvaluator<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomNavActionBar f7278a;

        public c(OBottomNavActionBar r10) {
            this.f7278a = r10;
        }

        public b a(float r10, b r11, b r12) {
            Intrinsics.checkNotNullParameter(r11, "startValue");
            Intrinsics.checkNotNullParameter(r12, "endValue");
            float r13 = r11.a() + ((r12.a() - r11.a()) * r10);
            float r14 = r11.b() + (r10 * (r12.b() - r11.b()));
            b r15 = new b(this.f7278a);
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
    public OBottomNavActionBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OBottomNavActionBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OBottomNavActionBar(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14, null, 8, null);
        this.f7263p = -1;
        this.f7268s = new Rect();
        this.f7269t = new Rect();
        this.f7270u = new Paint();
        this.f7271v = new Paint(1);
        this.D = 350;
        this.E = true;
        this.U = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.V = new float[8];
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.FILL);
        Unit r10 = Unit.INSTANCE;
        this.f7245b0 = r15;
        Paint r16 = new Paint(1);
        r16.setStyle(Paint.Style.STROKE);
        this.f7246c0 = r16;
        this.f7247d0 = new RectF();
        this.f7248e0 = new RectF();
        this.f7251h0 = 0.988f;
        this.f7252i0 = 0.01f;
        this.f7253j0 = 1.0f;
        this.f7256l0 = 0.85f;
        this.f7258m0 = new ArrayList();
        this.f7260n0 = true;
        new Paint(1);
        new SparseArray();
        b r17 = new b(this);
        this.f7264p0 = r17;
        b r11 = new b(this);
        this.f7266q0 = r11;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f7255l = r12;
        this.f7257m = new LinearLayout(r12);
        OUIFrameLayout r18 = new OUIFrameLayout(r12, null, 0, null, 14, null);
        this.f7259n = r18;
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        r18.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, r19.getDisplayMetrics())));
        addView(this.f7259n);
        Intrinsics.checkNotNull(r13);
        String r20 = r13.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (r20 == null) goto L16;
        int r21 = r20.hashCode();
        if (r21 == 1444) goto L14;
        if (r21 != 1445) goto L16;
        if (r20.equals("-2") == false) goto L16;
    L17:
        ValueAnimator r110 = ValueAnimator.ofObject(new c(this), new Object[]{r11, r17});
        Intrinsics.checkNotNullExpressionValue(r110, "ValueAnimator.ofObject(P…tor(), mLastP, mCurrentP)");
        this.T = r110;
        r110.addUpdateListener(this);
        r110.addListener(this);
        return;
    L14:
        if (r20.equals("-1") == true) goto L17;
    L16:
        TypedArray r111 = r12.obtainStyledAttributes(r13, new int[]{R.attr.layout_height});
        Intrinsics.checkNotNullExpressionValue(r111, "context.obtainStyledAttributes(attrs, systemAttrs)");
        r111.getDimensionPixelSize(0, -2);
        r111.recycle();
        goto L17
    }

    public /* synthetic */ OBottomNavActionBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ float c(OBottomNavActionBar r10) {
        return r10.f7253j0;
    }

    public static final /* synthetic */ List d(OBottomNavActionBar r10, float r11, float r12, float r13, List r14, List r15) {
        return r10.o(r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ float e(OBottomNavActionBar r10) {
        return r10.f7251h0;
    }

    public static final /* synthetic */ List f(OBottomNavActionBar r10) {
        return r10.W;
    }

    public static final /* synthetic */ List g(OBottomNavActionBar r10) {
        return r10.f7244a0;
    }

    private final void h(TextPaint r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = TypedValues.TransitionType.TYPE_DURATION;
    L5:
        r10.setTypeface(Typeface.create(null, r12, false));
        return;
    L4:
        r12 = 400;
        goto L5
    }

    private final void i() {
        int r10 = this.f7263p;
        if (r10 == (-1)) goto L5;
        View r11 = this.f7257m.getChildAt(r10);
    L6:
        if (r11 == null) goto L9;
        Rect r12 = this.f7269t;
        r12.left = r11.getLeft();
        Rect r13 = this.f7269t;
        r13.right = r11.getRight();
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private final void j() {
        View r10 = this.f7257m.getChildAt(this.f7261o);
        Intrinsics.checkNotNullExpressionValue(r10, "currentTabView");
        float r11 = r10.getLeft();
        float r12 = r10.getRight();
        Rect r13 = this.f7268s;
        r13.left = (int) r11;
        r13.right = (int) r12;
        this.f7254k0 = this.A;
        if (this.E == true) goto L11;
        int r14 = this.f7261o;
        if (r14 != 0) goto L8;
        float[] r15 = this.V;
        float r16 = this.B;
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
        if (r14 != (this.f7267r - 1)) goto L10;
        float[] r17 = this.V;
        r17[0] = 0.0f;
        r17[1] = 0.0f;
        float r18 = this.B;
        r17[2] = r18;
        r17[3] = r18;
        r17[4] = r18;
        r17[5] = r18;
        r17[6] = 0.0f;
        r17[7] = 0.0f;
        return;
    L10:
        float[] r19 = this.V;
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
        float[] r20 = this.V;
        float r110 = this.B;
        r20[0] = r110;
        r20[1] = r110;
        r20[2] = r110;
        r20[3] = r110;
        r20[4] = r110;
        r20[5] = r110;
        r20[6] = r110;
        r20[7] = r110;
    }

    private final void k() {
        View r10 = this.f7257m.getChildAt(this.f7261o);
        b r11 = this.f7264p0;
        Intrinsics.checkNotNullExpressionValue(r10, "currentTabView");
        r11.c(r10.getLeft());
        this.f7264p0.d(r10.getRight());
        View r12 = this.f7257m.getChildAt(this.f7265q);
        b r13 = this.f7266q0;
        Intrinsics.checkNotNullExpressionValue(r12, "lastTabView");
        r13.c(r12.getLeft());
        this.f7266q0.d(r12.getRight());
        if (this.f7266q0.a() == this.f7264p0.a()) goto L5;
    L7:
        this.T.setObjectValues(new Object[]{this.f7266q0, this.f7264p0});
        if (this.F == false) goto L10;
        this.T.setInterpolator(this.U);
    L10:
        this.T.setDuration(350);
        this.T.start();
        return;
    L5:
        if (this.f7266q0.b() != this.f7264p0.b()) goto L7;
        invalidate();
    }

    private final void l(float r10) {
        float r11 = this.A;
        float r12 = this.f7256l0 * r11;
        if (r10 > 0.7f) goto L5;
        this.f7254k0 = r11 - ((r11 - r12) * (r10 / 0.7f));
    L6:
        this.f7254k0 = RangesKt.coerceAtLeast(this.f7254k0, n(2.0f));
        return;
    L5:
        this.f7254k0 = r12 + ((r11 - r12) * ((r10 - 0.7f) / 0.3f));
        goto L6
    }

    private final void m(boolean r24) {
        n8.d r10 = this.f7249f0;
        if (r10 == null) goto L5;
        n8.d.c(r10, false, 1, null);
    L5:
        n8.d r11 = this.f7250g0;
        if (r11 == null) goto L8;
        n8.d.c(r11, false, 1, null);
    L8:
        com.obric.common.oea.foundation.animation.builder.a.C0123a r12 = com.obric.common.oea.foundation.animation.builder.b.b(this, 0.0f, 1, null);
        AnimationProperty$FloatProperty r13 = AnimationProperty$FloatProperty.SCALE_X;
        Float r14 = Float.valueOf(getScaleX());
        if (r24 == false) goto L11;
        float r15 = this.f7251h0;
        Token$Bounce r16 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r17 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r18 = o8.b.b(r16, r17, 0, 4, null);
        r18.j(this.f7252i0);
        Unit r19 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.a.C0123a r110 = com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r12, r13, r14, r15, r18, null, 16, null);
        AnimationProperty$FloatProperty r111 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r112 = Float.valueOf(getScaleY());
        float r20 = this.f7251h0;
        com.obric.common.oea.foundation.animation.spec.spring.b r21 = o8.b.b(r16, r17, 0, 4, null);
        r21.j(this.f7252i0);
        this.f7249f0 = com.obric.common.oea.foundation.animation.builder.a.b(com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r110, r111, r112, r20, r21, null, 16, null).e(new OBottomNavActionBar$doPressAnim$$inlined$let$lambda$1(this)).b(), null, null, 3, null);
        return;
    L11:
        float r113 = this.f7253j0;
        Token$Bounce r22 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r23 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r114 = o8.b.b(r22, r23, 0, 4, null);
        r114.j(this.f7252i0);
        Unit r115 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.a.C0123a r116 = com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r12, r13, r14, r113, r114, null, 16, null);
        AnimationProperty$FloatProperty r117 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r118 = Float.valueOf(getScaleY());
        float r25 = this.f7253j0;
        com.obric.common.oea.foundation.animation.spec.spring.b r26 = o8.b.b(r22, r23, 0, 4, null);
        r26.j(this.f7252i0);
        this.f7250g0 = com.obric.common.oea.foundation.animation.builder.a.b(com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r116, r117, r118, r25, r26, null, 16, null).e(new OBottomNavActionBar$doPressAnim$$inlined$let$lambda$2(this)).b(), null, null, 3, null);
    }

    private final int n(float r10) {
        Resources r11 = this.f7255l.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "mContext.resources");
        return (int) ((r10 * r11.getDisplayMetrics().density) + 0.5f);
    }

    private final List<p> o(float r17, float r18, float r19, List<p> r20, List<p> r21) {
        float r10 = RangesKt.coerceIn((r17 - r18) / (r19 - r18), 0.0f, 1.0f);
        if (r20 == null) goto L17;
        if (r21 != null) goto L6;
        return r20;
    L6:
        if (r20.size() != r21.size()) goto L19;
        Iterator<T> r11 = r20.iterator();
        Iterator<T> r12 = r21.iterator();
        ArrayList r13 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r20, 10), CollectionsKt.collectionSizeOrDefault(r21, 10)));
    L9:
        if (r11.hasNext() == false) goto L14;
        if (r12.hasNext() == false) goto L14;
        Object r14 = r11.next();
        p r15 = (p) r12.next();
        p r16 = (p) r14;
        com.obric.oui.button.a r22 = com.obric.oui.button.a.f6287a;
        r13.add(new p(r22.a(r10, r16.a(), r15.a()), r22.b(r16.f(), r15.f(), r10), r22.b(r16.c(), r15.c(), r10), r22.b(r16.d(), r15.d(), r10), r22.b(r16.g(), r15.g(), r10), null, 0.0f, 96, null));
    L14:
        return r13;
    L19:
        return r20;
    L17:
        return r20;
    }

    private final void p(Context r10, TypedArray r11) {
        int r12 = r11.getResourceId(l.OTabLayout_shadow_normal, 0);
        int r13 = r11.getResourceId(l.OTabLayout_shadow_pressed, 0);
        if (r12 == 0) goto L5;
        List<p> r14 = k.v(r10, r12);
        List<p> r15 = CollectionsKt.listOf(new p[]{r14.get(0), r14.get(1)});
        this.W = r15;
        Intrinsics.checkNotNull(r15);
        p r16 = (p) CollectionsKt.getOrNull(r15, 0);
        List<p> r17 = this.W;
        Intrinsics.checkNotNull(r17);
        setShadow(r16, (p) CollectionsKt.getOrNull(r17, 1));
    L5:
        if (r13 == 0) goto L8;
        List<p> r18 = k.v(r10, r13);
        this.f7244a0 = CollectionsKt.listOf(new p[]{r18.get(0), r18.get(1)});
        return;
    }

    private final int r(float r10) {
        Resources r11 = this.f7255l.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "mContext.resources");
        return (int) ((r10 * r11.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void s(int r10) {
        int r11 = this.f7267r;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L23;
        View r13 = this.f7257m.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r14 = true;
    L8:
        View r15 = r13.findViewById(f.tv_tab_title);
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.widget.TextView");
        TextView r16 = (TextView) r15;
        ImageView r17 = (ImageView) r13.findViewById(f.tv_tab_icon);
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        if (r14 == false) goto L11;
        int r18 = this.K;
    L12:
        r17.setImageTintList(ColorStateList.valueOf(r18));
        if (this.M != 1) goto L15;
        TextPaint r19 = r16.getPaint();
        Intrinsics.checkNotNullExpressionValue(r19, "tabTitle.paint");
        h(r19, r14);
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
        r18 = this.L;
        goto L12
    L7:
        r14 = false;
        goto L8
    }

    private final void setFragments(int r10) {
        ArrayList<Fragment> r11 = this.S;
        if (r11 == null) goto L16;
        int r12 = 0;
        int r13 = r11.size();
    L5:
        if (r12 >= r13) goto L11;
        FragmentManager r14 = this.R;
        Intrinsics.checkNotNull(r14);
        FragmentTransaction r15 = r14.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r15, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r16 = this.S;
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
        this.f7261o = r10;
        return;
    }

    private final void t() {
        int r10 = this.f7267r;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L26;
        View r12 = this.f7257m.getChildAt(r11);
        float r13 = this.f7272w;
        r12.setPadding((int) r13, 0, (int) r13, 0);
        View r14 = r12.findViewById(f.tv_tab_title);
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.TextView");
        TextView r15 = (TextView) r14;
        int r16 = this.f7261o;
        if (r11 != r16) goto L7;
        boolean r17 = true;
    L8:
        if (r11 != r16) goto L10;
        int r18 = this.K;
    L11:
        r15.setTextColor(r18);
        r15.setTextSize(0, this.f7243J);
        ImageView r19 = (ImageView) r12.findViewById(f.tv_tab_icon);
        Intrinsics.checkNotNullExpressionValue(r19, "it");
        if (r11 != this.f7261o) goto L14;
        int r20 = this.K;
    L15:
        r19.setImageTintList(ColorStateList.valueOf(r20));
        if (this.N == false) goto L18;
        String r21 = r15.getText().toString();
        Locale r22 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r22, "Locale.ROOT");
        String r23 = r21.toUpperCase(r22);
        Intrinsics.checkNotNullExpressionValue(r23, "this as java.lang.String).toUpperCase(locale)");
        r15.setText(r23);
    L18:
        int r24 = this.M;
        if (r24 != 2) goto L21;
        TextPaint r25 = r15.getPaint();
        Intrinsics.checkNotNullExpressionValue(r25, "tvTabTitle.paint");
        h(r25, true);
    L25:
        r11 = r11 + 1;
        goto L3
    L21:
        if (r24 != 0) goto L23;
        TextPaint r26 = r15.getPaint();
        Intrinsics.checkNotNullExpressionValue(r26, "tvTabTitle.paint");
        h(r26, false);
        goto L25
    L23:
        if (r24 != 1) goto L25;
        TextPaint r27 = r15.getPaint();
        Intrinsics.checkNotNullExpressionValue(r27, "tvTabTitle.paint");
        h(r27, r17);
        goto L25
    L14:
        r20 = this.L;
        goto L15
    L10:
        r18 = this.L;
        goto L11
    L7:
        r17 = false;
        goto L8
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        int r11 = r10.getAction();
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
    L8:
        m(false);
    L11:
        return super.dispatchTouchEvent(r10);
    L6:
        if (r11 == 3) goto L8;
    L9:
        m(true);
        goto L11
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r10 = this.S;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get(this.f7261o);
    }

    public final int getCurrentTab() {
        return this.f7261o;
    }

    public final int getDividerColor() {
        return this.G;
    }

    public final float getDividerPadding() {
        return this.I;
    }

    public final float getDividerWidth() {
        return this.H;
    }

    public final long getIndicatorAnimDuration() {
        return this.D;
    }

    public final int getIndicatorColor() {
        return this.f7275z;
    }

    public final float getIndicatorCornerRadius() {
        return this.B;
    }

    public final float getIndicatorHeight() {
        return this.A;
    }

    public final float getIndicatorSpacing() {
        return this.C;
    }

    public final int getTabCount() {
        return this.f7267r;
    }

    public final List<View> getTabList() {
        return this.f7258m0;
    }

    public final float getTabPadding() {
        return this.f7272w;
    }

    public final float getTabWidth() {
        return this.f7274y;
    }

    public final int getTextBold() {
        return this.M;
    }

    public final int getTextSelectColor() {
        return this.K;
    }

    public final int getTextUnselectColor() {
        return this.L;
    }

    public final float getTextsize() {
        return this.f7243J;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        d r11 = this.f7262o0;
        if (r11 == null) goto L6;
        r11.c();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        d r11 = this.f7262o0;
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
        d r11 = this.f7262o0;
        if (r11 == null) goto L6;
        r11.a();
        return;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        Object r11 = r10.getAnimatedValue();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OBottomNavActionBar.IndicatorPoint");
        b r12 = (b) r11;
        Rect r13 = this.f7268s;
        r13.left = (int) r12.a();
        Rect r14 = this.f7268s;
        r14.right = (int) r12.b();
        l(r10.getAnimatedFraction());
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        super.onDraw(r17);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f7267r <= 0) goto L35;
        int r10 = getHeight();
        int r11 = getPaddingLeft();
        float r12 = 0;
        if (this.A >= r12) goto L10;
        this.A = r10 - (this.C * 2);
    L10:
        float r13 = this.B;
        if (r13 >= r12) goto L13;
    L14:
        this.B = this.A;
    L15:
        this.f7245b0.setColor(this.O);
        this.f7247d0.set(0.0f, getPaddingTop(), getWidth(), r10 - getPaddingBottom());
        float r14 = 2;
        float r15 = this.B + (this.C / r14);
        q.i(r17, this.f7247d0, r15, this.f7245b0);
        if (this.Q <= r12) goto L19;
        this.f7246c0.setColor(this.P);
        this.f7246c0.setStrokeWidth(this.Q);
        this.f7248e0.set(this.Q / r14, getPaddingTop() + (this.Q / r14), getWidth() - (this.Q / r14), (r10 - getPaddingBottom()) - (this.Q / r14));
        q.i(r17, this.f7248e0, r15, this.f7246c0);
    L19:
        if (this.E == true) goto L26;
        float r16 = this.H;
        if (r16 <= r12) goto L26;
        this.f7271v.setStrokeWidth(r16);
        this.f7271v.setColor(this.G);
        int r18 = this.f7267r - 1;
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L26;
        View r20 = this.f7257m.getChildAt(r19);
        Intrinsics.checkNotNullExpressionValue(r20, "tab");
        r17.drawLine(r20.getRight() + r11, this.I, r20.getRight() + r11, r10 - this.I, this.f7271v);
        r19 = r19 + 1;
    L26:
        if (this.E == true) goto L28;
    L30:
        j();
    L31:
        i();
        float r21 = (this.C / r14) + this.Q;
        Paint r22 = this.f7270u;
        r22.setColor(this.f7275z);
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        float r24 = TypedValue.applyDimension(1, 10, r23.getDisplayMetrics());
        Resources r25 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r25, "Resources.getSystem()");
        float r26 = TypedValue.applyDimension(1, r12, r25.getDisplayMetrics());
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        r22.setShadowLayer(r24, r26, TypedValue.applyDimension(1, 4, r27.getDisplayMetrics()), ContextCompat.getColor(getContext(), u8.c.TabSegmentedShadowColor));
        float r28 = this.C;
        float r29 = this.Q;
        float r30 = ((r28 + r29) + ((r28 + this.A) - r29)) / r14;
        float r31 = this.f7254k0 / r14;
        Rect r32 = this.f7268s;
        q.h(r17, (r11 + r21) + r32.left, r30 - r31, (r11 + r32.right) - r21, r30 + r31, this.B, this.f7270u);
        return;
    L28:
        if (this.f7260n0 == false) goto L31;
        this.f7260n0 = false;
        goto L30
    L13:
        if (r13 <= (this.A / 2)) goto L15;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        if ((r10 instanceof Bundle) == false) goto L9;
        Bundle r11 = (Bundle) r10;
        this.f7261o = r11.getInt("mCurrentTab");
        r10 = r11.getParcelable("instanceState");
        if (this.f7261o == 0) goto L9;
        if (this.f7257m.getChildCount() <= 0) goto L9;
        s(this.f7261o);
    L9:
        super.onRestoreInstanceState(r10);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle r10 = new Bundle();
        r10.putParcelable("instanceState", super.onSaveInstanceState());
        r10.putInt("mCurrentTab", this.f7261o);
        return r10;
    }

    public final void q(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.f7275z = r12.getColor(l.OTabLayout_indicator_color, getResources().getColor(u8.c.oui_fill_element_2));
        this.A = r12.getDimension(l.OTabLayout_indicator_height, -1.0f);
        this.B = r12.getDimension(l.OTabLayout_indicator_corner_radius, -1.0f);
        float r13 = r12.getDimension(l.OTabLayout_indicator_spacing, n(4.0f));
        this.C = r13;
        int r14 = (int) (r13 / 2);
        this.f7257m.setPadding(r14, 0, r14, 0);
        this.f7259n.addView(this.f7257m);
        this.E = r12.getBoolean(l.OTabLayout_indicator_anim_enable, false);
        this.F = r12.getBoolean(l.OTabLayout_indicator_bounce_enable, true);
        this.G = r12.getColor(l.OTabLayout_divider_color, this.f7275z);
        this.H = r12.getDimension(l.OTabLayout_divider_width, n(1.0f));
        this.I = r12.getDimension(l.OTabLayout_divider_padding, 0.0f);
        this.f7243J = r12.getDimension(l.OTabLayout_tab_textSize, r(12.0f));
        this.K = r12.getColor(l.OTabLayout_tab_textSelectColor, this.f7255l.getColor(u8.c.oui_text_1));
        this.L = r12.getColor(l.OTabLayout_tab_textUnselectColor, this.f7255l.getColor(u8.c.oui_text_3b));
        this.M = r12.getInt(l.OTabLayout_tab_textBold, 0);
        this.N = r12.getBoolean(l.OTabLayout_tab_textAllCaps, false);
        this.f7273x = r12.getBoolean(l.OTabLayout_tab_space_equal, true);
        float r15 = r12.getDimension(l.OTabLayout_tab_width, n(-1.0f));
        this.f7274y = r15;
        int r16 = l.OTabLayout_tab_padding;
        if (this.f7273x == false) goto L5;
    L8:
        int r17 = n(0.0f);
    L9:
        this.f7272w = r12.getDimension(r16, r17);
        int r18 = r12.getColor(l.OTabLayout_bar_color, 0);
        this.O = r18;
        this.P = r12.getColor(l.OTabLayout_bar_stroke_color, r18);
        this.Q = r12.getDimension(l.OTabLayout_bar_stroke_width, n(0.0f));
        r12.getBoolean(l.OTabLayout_vibrate_on_tab_selected, true);
        p(r10, r12);
        r12.recycle();
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        setShadowCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, r19.getDisplayMetrics())));
        return;
    L5:
        if (r15 > 0) goto L8;
        r17 = n(10.0f);
        goto L9
    }

    public final void setCurrentTab(int r10) {
        int r11 = this.f7261o;
        if (r10 != r11) goto L5;
        return;
    L5:
        this.f7260n0 = true;
        this.f7265q = r11;
        this.f7261o = r10;
        Log.d("OTabSegmentedLayout", "setCurrentTab, currentTab: " + r10 + ", lastTab: " + this.f7265q);
        s(r10);
        setFragments(r10);
        if (this.E == false) goto L8;
        k();
        return;
    L8:
        invalidate();
    }

    public final void setDividerColor(int r10) {
        this.G = r10;
        invalidate();
    }

    public final void setDividerPadding(float r10) {
        this.I = n(r10);
        invalidate();
    }

    public final void setDividerWidth(float r10) {
        this.H = n(r10);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator<View> r11 = this.f7258m0.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setEnabled(r10);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r10) {
        this.D = r10;
    }

    public final void setIndicatorAnimEnable(boolean r10) {
        this.E = r10;
    }

    public final void setIndicatorBounceEnable(boolean r10) {
        this.F = r10;
    }

    public final void setIndicatorColor(int r10) {
        this.f7275z = r10;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r10) {
        this.B = n(r10);
        invalidate();
    }

    public final void setIndicatorHeight(float r10) {
        float r11 = n(r10);
        this.A = r11;
        this.f7254k0 = r11;
        invalidate();
    }

    public final void setOnTabSelectAnimListener(d r10) {
        this.f7262o0 = r10;
    }

    public final void setOnTabSelectListener(e r10) {
    }

    public final void setTabList(List<View> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7258m0 = r10;
    }

    public final void setTabPadding(float r10) {
        this.f7272w = n(r10);
        t();
    }

    public final void setTabSpaceEqual(boolean r10) {
        this.f7273x = r10;
        t();
    }

    public final void setTabWidth(float r10) {
        this.f7274y = n(r10);
        t();
    }

    public final void setTextAllCaps(boolean r10) {
        this.N = r10;
        t();
    }

    public final void setTextBold(int r10) {
        this.M = r10;
        t();
    }

    public final void setTextSelectColor(int r10) {
        this.K = r10;
        t();
    }

    public final void setTextUnselectColor(int r10) {
        this.L = r10;
        t();
    }

    public final void setTextsize(float r10) {
        this.f7243J = r(r10);
        t();
    }
}
