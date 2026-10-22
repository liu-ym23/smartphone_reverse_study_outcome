package com.obric.oui.segmentedtab;

import android.R;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0004PQRSB'\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010M\u001a\u00020\u0003¢\u0006\u0004\bN\u0010OJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fR$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR$\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R$\u0010+\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R(\u00106\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001cR$\u0010:\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0011\"\u0004\b<\u0010\u0013R$\u0010=\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0011\"\u0004\b?\u0010\u0013R$\u0010D\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u0011R$\u0010H\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010\u001a\"\u0004\bG\u0010\u001c¨\u0006T"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "", "index", "", "setFragments", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "", "enabled", "setEnabled", "Lcom/obric/oui/segmentedtab/OBottomToolBar$d;", "listener", "setOnTabSelectListener", "textBold", "getTextBold", "()I", "setTextBold", "(I)V", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "", "tabWidth", "getTabWidth", "()F", "setTabWidth", "(F)V", "tabPadding", "getTabPadding", "setTabPadding", "textAllCaps", "isTextAllCaps", "()Z", "setTextAllCaps", "(Z)V", "dividerPadding", "getDividerPadding", "setDividerPadding", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "dividerColor", "getDividerColor", "setDividerColor", "", "Landroid/view/View;", "T", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "dividerWidth", "getDividerWidth", "setDividerWidth", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "currentTab", "getCurrentTab", "setCurrentTab", "<set-?>", "p", "I", "getTabCount", "tabCount", "textSize", "getTextsize", "setTextsize", "textsize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomToolBar extends OUIFrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private int A;
    private boolean B;
    private int C;
    private int D;
    private float E;
    private FragmentManager F;
    private ArrayList<Fragment> G;
    private final ValueAnimator H;
    private List<p> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private List<p> f7281J;
    private final Paint K;
    private final Paint L;
    private final RectF M;
    private final RectF N;
    private n8.d O;
    private n8.d P;
    private float Q;
    private float R;
    private float S;
    private List<View> T;
    private final b U;
    private final b V;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Context f7282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LinearLayout f7283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OUIFrameLayout f7284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Paint f7287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f7288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f7289s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f7290t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f7291u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f7292v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f7293w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f7294x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f7295y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f7296z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f7298b;

        public b(OBottomToolBar r10) {
        }

        public final float a() {
            return this.f7297a;
        }

        public final float b() {
            return this.f7298b;
        }

        public final void c(float r10) {
            this.f7297a = r10;
        }

        public final void d(float r10) {
            this.f7298b = r10;
        }

        public String toString() {
            return "(left = " + this.f7297a + ", right = " + this.f7298b + ')';
        }
    }

    public final class c implements TypeEvaluator<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomToolBar f7299a;

        public c(OBottomToolBar r10) {
            this.f7299a = r10;
        }

        public b a(float r10, b r11, b r12) {
            Intrinsics.checkNotNullParameter(r11, "startValue");
            Intrinsics.checkNotNullParameter(r12, "endValue");
            float r13 = r11.a() + ((r12.a() - r11.a()) * r10);
            float r14 = r11.b() + (r10 * (r12.b() - r11.b()));
            b r15 = new b(this.f7299a);
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
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OBottomToolBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OBottomToolBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OBottomToolBar(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14, null, 8, null);
        this.f7287q = new Paint(1);
        new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.FILL);
        Unit r10 = Unit.INSTANCE;
        this.K = r15;
        Paint r16 = new Paint(1);
        r16.setStyle(Paint.Style.STROKE);
        this.L = r16;
        this.M = new RectF();
        this.N = new RectF();
        this.Q = 0.988f;
        this.R = 0.01f;
        this.S = 1.0f;
        this.T = new ArrayList();
        new Paint(1);
        new SparseArray();
        b r17 = new b(this);
        this.U = r17;
        b r11 = new b(this);
        this.V = r11;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f7282l = r12;
        this.f7283m = new LinearLayout(r12);
        OUIFrameLayout r18 = new OUIFrameLayout(r12, null, 0, null, 14, null);
        this.f7284n = r18;
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        r18.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, r19.getDisplayMetrics())));
        addView(this.f7284n);
        m(r12, r13);
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
        this.H = r110;
        r110.addUpdateListener(this);
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

    public /* synthetic */ OBottomToolBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ float c(OBottomToolBar r10) {
        return r10.S;
    }

    public static final /* synthetic */ List d(OBottomToolBar r10, float r11, float r12, float r13, List r14, List r15) {
        return r10.k(r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ float e(OBottomToolBar r10) {
        return r10.Q;
    }

    public static final /* synthetic */ List f(OBottomToolBar r10) {
        return r10.I;
    }

    public static final /* synthetic */ List g(OBottomToolBar r10) {
        return r10.f7281J;
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

    private final void i(boolean r24) {
        n8.d r10 = this.O;
        if (r10 == null) goto L5;
        n8.d.c(r10, false, 1, null);
    L5:
        n8.d r11 = this.P;
        if (r11 == null) goto L8;
        n8.d.c(r11, false, 1, null);
    L8:
        com.obric.common.oea.foundation.animation.builder.a.C0123a r12 = com.obric.common.oea.foundation.animation.builder.b.b(this, 0.0f, 1, null);
        AnimationProperty$FloatProperty r13 = AnimationProperty$FloatProperty.SCALE_X;
        Float r14 = Float.valueOf(getScaleX());
        if (r24 == false) goto L11;
        float r15 = this.Q;
        Token$Bounce r16 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r17 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r18 = o8.b.b(r16, r17, 0, 4, null);
        r18.j(this.R);
        Unit r19 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.a.C0123a r110 = com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r12, r13, r14, r15, r18, null, 16, null);
        AnimationProperty$FloatProperty r111 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r112 = Float.valueOf(getScaleY());
        float r20 = this.Q;
        com.obric.common.oea.foundation.animation.spec.spring.b r21 = o8.b.b(r16, r17, 0, 4, null);
        r21.j(this.R);
        this.O = com.obric.common.oea.foundation.animation.builder.a.b(com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r110, r111, r112, r20, r21, null, 16, null).e(new OBottomToolBar$doPressAnim$$inlined$let$lambda$1(this)).b(), null, null, 3, null);
        return;
    L11:
        float r113 = this.S;
        Token$Bounce r22 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r23 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r114 = o8.b.b(r22, r23, 0, 4, null);
        r114.j(this.R);
        Unit r115 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.a.C0123a r116 = com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r12, r13, r14, r113, r114, null, 16, null);
        AnimationProperty$FloatProperty r117 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r118 = Float.valueOf(getScaleY());
        float r25 = this.S;
        com.obric.common.oea.foundation.animation.spec.spring.b r26 = o8.b.b(r22, r23, 0, 4, null);
        r26.j(this.R);
        this.P = com.obric.common.oea.foundation.animation.builder.a.b(com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r116, r117, r118, r25, r26, null, 16, null).e(new OBottomToolBar$doPressAnim$$inlined$let$lambda$2(this)).b(), null, null, 3, null);
    }

    private final int j(float r10) {
        Resources r11 = this.f7282l.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "mContext.resources");
        return (int) ((r10 * r11.getDisplayMetrics().density) + 0.5f);
    }

    private final List<p> k(float r17, float r18, float r19, List<p> r20, List<p> r21) {
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

    private final void l(Context r10, TypedArray r11) {
        int r12 = r11.getResourceId(l.OTabLayout_shadow_normal, 0);
        int r13 = r11.getResourceId(l.OTabLayout_shadow_pressed, 0);
        if (r12 == 0) goto L5;
        List<p> r14 = k.v(r10, r12);
        List<p> r15 = CollectionsKt.listOf(new p[]{r14.get(0), r14.get(1)});
        this.I = r15;
        Intrinsics.checkNotNull(r15);
        p r16 = (p) CollectionsKt.getOrNull(r15, 0);
        List<p> r17 = this.I;
        Intrinsics.checkNotNull(r17);
        setShadow(r16, (p) CollectionsKt.getOrNull(r17, 1));
    L5:
        if (r13 == 0) goto L8;
        List<p> r18 = k.v(r10, r13);
        this.f7281J = CollectionsKt.listOf(new p[]{r18.get(0), r18.get(1)});
        return;
    }

    private final void m(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.f7284n.addView(this.f7283m);
        this.f7292v = r12.getDimension(l.OTabLayout_divider_width, j(1.0f));
        this.f7293w = r12.getDimension(l.OTabLayout_divider_padding, 0.0f);
        this.f7294x = r12.getDimension(l.OTabLayout_tab_textSize, n(12.0f));
        this.f7295y = r12.getColor(l.OTabLayout_tab_textSelectColor, this.f7282l.getColor(u8.c.oui_text_1));
        this.f7296z = r12.getColor(l.OTabLayout_tab_textUnselectColor, this.f7282l.getColor(u8.c.oui_text_3b));
        this.A = r12.getInt(l.OTabLayout_tab_textBold, 0);
        this.B = r12.getBoolean(l.OTabLayout_tab_textAllCaps, false);
        this.f7289s = r12.getBoolean(l.OTabLayout_tab_space_equal, true);
        float r13 = r12.getDimension(l.OTabLayout_tab_width, j(-1.0f));
        this.f7290t = r13;
        int r14 = l.OTabLayout_tab_padding;
        if (this.f7289s == false) goto L5;
    L8:
        int r15 = j(0.0f);
    L9:
        this.f7288r = r12.getDimension(r14, r15);
        int r16 = r12.getColor(l.OTabLayout_bar_color, -1);
        this.C = r16;
        this.D = r12.getColor(l.OTabLayout_bar_stroke_color, r16);
        this.E = r12.getDimension(l.OTabLayout_bar_stroke_width, j(0.0f));
        r12.getBoolean(l.OTabLayout_vibrate_on_tab_selected, true);
        l(r10, r12);
        r12.recycle();
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        setShadowCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, r17.getDisplayMetrics())));
        return;
    L5:
        if (r13 > 0) goto L8;
        r15 = j(10.0f);
        goto L9
    }

    private final int n(float r10) {
        Resources r11 = this.f7282l.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "mContext.resources");
        return (int) ((r10 * r11.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void o(int r10) {
        int r11 = this.f7286p;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L23;
        View r13 = this.f7283m.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r14 = true;
    L8:
        View r15 = r13.findViewById(f.tv_tab_title_small);
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.widget.TextView");
        TextView r16 = (TextView) r15;
        ImageView r17 = (ImageView) r13.findViewById(f.tv_tab_icon_small);
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        if (r14 == false) goto L11;
        int r18 = this.f7295y;
    L12:
        r17.setImageTintList(ColorStateList.valueOf(r18));
        if (this.A != 1) goto L15;
        TextPaint r19 = r16.getPaint();
        Intrinsics.checkNotNullExpressionValue(r19, "tabTitle.paint");
        h(r19, r14);
        r16.invalidate();
    L15:
        da.c r20 = da.c.f8520a;
        if ((r13 instanceof OSegmentTabMiniView) == true) goto L19;
        r13 = null;
    L19:
        OSegmentTabMiniView r21 = (OSegmentTabMiniView) r13;
        if (r21 == null) goto L22;
        r21.k(r14);
    L22:
        r12 = r12 + 1;
        goto L3
    L11:
        r18 = this.f7296z;
        goto L12
    L7:
        r14 = false;
        goto L8
    }

    private final void p() {
        int r10 = this.f7286p;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L26;
        View r12 = this.f7283m.getChildAt(r11);
        float r13 = this.f7288r;
        r12.setPadding((int) r13, 0, (int) r13, 0);
        View r14 = r12.findViewById(f.tv_tab_title_small);
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.TextView");
        TextView r15 = (TextView) r14;
        int r16 = this.f7285o;
        if (r11 != r16) goto L7;
        boolean r17 = true;
    L8:
        if (r11 != r16) goto L10;
        int r18 = this.f7295y;
    L11:
        r15.setTextColor(r18);
        r15.setTextSize(0, this.f7294x);
        ImageView r19 = (ImageView) r12.findViewById(f.tv_tab_icon_small);
        Intrinsics.checkNotNullExpressionValue(r19, "it");
        if (r11 != this.f7285o) goto L14;
        int r20 = this.f7295y;
    L15:
        r19.setImageTintList(ColorStateList.valueOf(r20));
        if (this.B == false) goto L18;
        String r21 = r15.getText().toString();
        Locale r22 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r22, "Locale.ROOT");
        String r23 = r21.toUpperCase(r22);
        Intrinsics.checkNotNullExpressionValue(r23, "this as java.lang.String).toUpperCase(locale)");
        r15.setText(r23);
    L18:
        int r24 = this.A;
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
        r20 = this.f7296z;
        goto L15
    L10:
        r18 = this.f7296z;
        goto L11
    L7:
        r17 = false;
        goto L8
    }

    private final void setFragments(int r10) {
        ArrayList<Fragment> r11 = this.G;
        if (r11 == null) goto L16;
        int r12 = 0;
        int r13 = r11.size();
    L5:
        if (r12 >= r13) goto L11;
        FragmentManager r14 = this.F;
        Intrinsics.checkNotNull(r14);
        FragmentTransaction r15 = r14.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r15, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r16 = this.G;
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
        this.f7285o = r10;
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        int r11 = r10.getAction();
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
    L8:
        i(false);
    L11:
        return super.dispatchTouchEvent(r10);
    L6:
        if (r11 == 3) goto L8;
    L9:
        i(true);
        goto L11
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r10 = this.G;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get(this.f7285o);
    }

    public final int getCurrentTab() {
        return this.f7285o;
    }

    public final int getDividerColor() {
        return this.f7291u;
    }

    public final float getDividerPadding() {
        return this.f7293w;
    }

    public final float getDividerWidth() {
        return this.f7292v;
    }

    public final int getTabCount() {
        return this.f7286p;
    }

    public final List<View> getTabList() {
        return this.T;
    }

    public final float getTabPadding() {
        return this.f7288r;
    }

    public final float getTabWidth() {
        return this.f7290t;
    }

    public final int getTextBold() {
        return this.A;
    }

    public final int getTextSelectColor() {
        return this.f7295y;
    }

    public final int getTextUnselectColor() {
        return this.f7296z;
    }

    public final float getTextsize() {
        return this.f7294x;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
    }

    @Override // android.view.View
    protected void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f7286p <= 0) goto L18;
        int r10 = getHeight();
        int r11 = getPaddingLeft();
        this.K.setColor(this.C);
        this.M.set(0.0f, getPaddingTop(), getWidth(), r10 - getPaddingBottom());
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        q.i(r13, this.M, MathKt.roundToInt(TypedValue.applyDimension(1, 99, r12.getDisplayMetrics())), this.K);
        int r14 = 0;
        float r15 = 0;
        if (this.E <= r15) goto L10;
        this.L.setColor(this.D);
        this.L.setStrokeWidth(this.E);
        float r16 = 2;
        this.N.set(this.E / r16, getPaddingTop() + (this.E / r16), getWidth() - (this.E / r16), (r10 - getPaddingBottom()) - (this.E / r16));
    L10:
        float r17 = this.f7292v;
        if (r17 <= r15) goto L17;
        this.f7287q.setStrokeWidth(r17);
        this.f7287q.setColor(this.f7291u);
        int r18 = this.f7286p - 1;
    L13:
        if (r14 >= r18) goto L19;
        View r19 = this.f7283m.getChildAt(r14);
        Intrinsics.checkNotNullExpressionValue(r19, "tab");
        r13.drawLine(r19.getRight() + r11, this.f7293w, r19.getRight() + r11, r10 - this.f7293w, this.f7287q);
        r14 = r14 + 1;
        goto L13
    L19:
        return;
    L17:
        return;
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
        this.f7285o = r11.getInt("mCurrentTab");
        r10 = r11.getParcelable("instanceState");
        if (this.f7285o == 0) goto L9;
        if (this.f7283m.getChildCount() <= 0) goto L9;
        o(this.f7285o);
    L9:
        super.onRestoreInstanceState(r10);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle r10 = new Bundle();
        r10.putParcelable("instanceState", super.onSaveInstanceState());
        r10.putInt("mCurrentTab", this.f7285o);
        return r10;
    }

    public final void setCurrentTab(int r10) {
        if (r10 != this.f7285o) goto L5;
        return;
    L5:
        this.f7285o = r10;
        o(r10);
        setFragments(r10);
    }

    public final void setDividerColor(int r10) {
        this.f7291u = r10;
        invalidate();
    }

    public final void setDividerPadding(float r10) {
        this.f7293w = j(r10);
        invalidate();
    }

    public final void setDividerWidth(float r10) {
        this.f7292v = j(r10);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator<View> r11 = this.T.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setEnabled(r10);
        goto L4
    }

    public final void setOnTabSelectListener(d r10) {
    }

    public final void setTabList(List<View> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.T = r10;
    }

    public final void setTabPadding(float r10) {
        this.f7288r = j(r10);
        p();
    }

    public final void setTabSpaceEqual(boolean r10) {
        this.f7289s = r10;
        p();
    }

    public final void setTabWidth(float r10) {
        this.f7290t = j(r10);
        p();
    }

    public final void setTextAllCaps(boolean r10) {
        this.B = r10;
        p();
    }

    public final void setTextBold(int r10) {
        this.A = r10;
        p();
    }

    public final void setTextSelectColor(int r10) {
        this.f7295y = r10;
        p();
    }

    public final void setTextUnselectColor(int r10) {
        this.f7296z = r10;
        p();
    }

    public final void setTextsize(float r10) {
        this.f7294x = n(r10);
        p();
    }
}
