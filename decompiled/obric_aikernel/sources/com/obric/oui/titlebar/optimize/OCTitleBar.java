package com.obric.oui.titlebar.optimize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OBaseTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import u8.c;
import u8.d;
import u8.e;
import u8.k;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001[B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020\n¢\u0006\u0004\bY\u0010ZJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0013\u0010\u000e\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR.\u0010%\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00168B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00168B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001aR\u0013\u00103\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b2\u0010\rR$\u00107\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R$\u0010;\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014R*\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070<8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010@R$\u0010I\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0018\u001a\u0004\bG\u0010\u001a\"\u0004\bH\u0010\u001cR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070<8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010@R*\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010>\u001a\u0004\bM\u0010@\"\u0004\bN\u0010BR.\u0010S\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010 \u001a\u0004\bQ\u0010\"\"\u0004\bR\u0010$¨\u0006\\"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "Landroid/widget/RelativeLayout;", "", "title", "", "setCenterText", "setCenterSubText", "Landroid/view/View;", "view", "setCenterView", "", "resId", "getRightViewCount", "()I", "rightViewCount", "i", "Landroid/view/View;", "getMRightLastView", "()Landroid/view/View;", "setMRightLastView", "(Landroid/view/View;)V", "mRightLastView", "Landroid/widget/TextView;", "m", "Landroid/widget/TextView;", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", EventBody.KEY_VALUE, "p", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subTitleText", "getTitleViewOrCreate", "titleViewOrCreate", "Lcom/obric/oui/button/OButton;", "l", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "getSubtitleViewOrCreate", "subtitleViewOrCreate", "getLeftViewCount", "leftViewCount", "h", "getMLeftLastView", "setMLeftLastView", "mLeftLastView", "g", "getMCenterView", "setMCenterView", "mCenterView", "", "k", "Ljava/util/List;", "getMRightViewList", "()Ljava/util/List;", "setMRightViewList", "(Ljava/util/List;)V", "mRightViewList", "getRightViewListOrCreate", "rightViewListOrCreate", "o", "getMSubTitleView", "setMSubTitleView", "mSubTitleView", "getLeftViewListOrCreate", "leftViewListOrCreate", "j", "getMLeftViewList", "setMLeftViewList", "mLeftViewList", "n", "getTitleText", "setTitleText", "titleText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OCTitleBar extends RelativeLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f7743r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f7744s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f7745t = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7746c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f7747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f7748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f7749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<View> f7750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<View> f7751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OButton f7752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f7753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f7754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f7755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f7756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f7757q;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OCTitleBar f7758c;

        b(OCTitleBar r10) {
            this.f7758c = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            OCTitleBar.c(this.f7758c);
            if (OCTitleBar.b(this.f7758c) == true) goto L5;
            return;
        L5:
            OCTitleBar.a(this.f7758c, "OnGlobalLayoutListener");
        }
    }

    static {
        new a(null);
        f7743r = e.oui_ic_back_24_24;
        f7744s = c.oui_text_1;
        f7745t = c.oui_text_3b;
    }

    @JvmOverloads
    public OCTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OCTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OCTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7757q = new b(this);
        if (r11 == null) goto L6;
        n(r11);
    L6:
        if (o() == false) goto L9;
        d();
        return;
    }

    public /* synthetic */ OCTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ void a(OCTitleBar r10, String r11) {
        r10.h(r11);
    }

    public static final /* synthetic */ boolean b(OCTitleBar r10) {
        return r10.o();
    }

    public static final /* synthetic */ void c(OCTitleBar r10) {
        r10.q();
    }

    private final void d() {
        getViewTreeObserver().addOnGlobalLayoutListener(this.f7757q);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ea.b.c("OCTitleBar", "addGlobalLayoutListener: ", e);
    }

    private final void g() {
        TextView r10 = this.f7753m;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f7755o == null) goto L13;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.removeRule(13);
        r12.addRule(14);
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r12.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 9, r13.getDisplayMetrics()));
        Context r14 = getContext();
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        Resources r15 = r14.getResources();
        Intrinsics.checkNotNullExpressionValue(r15, "context.resources");
        if (r15.getConfiguration().fontScale <= 1.0f) goto L14;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r12.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 6, r16.getDisplayMetrics()));
        TextView r17 = this.f7755o;
        if (r17 == null) goto L15;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        ((RelativeLayout.LayoutParams) r18).topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 31, r19.getDisplayMetrics()));
        return;
    L15:
        return;
    L14:
        return;
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.f7750j != null) goto L5;
        this.f7750j = new ArrayList();
    L5:
        List<View> r10 = this.f7750j;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.f7751k != null) goto L5;
        this.f7751k = new ArrayList();
    L5:
        List<View> r10 = this.f7751k;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r10 = this.f7755o;
        if (r10 == null) goto L6;
        Intrinsics.checkNotNull(r10);
        return r10;
    L6:
        this.f7755o = k();
        ViewGroup.LayoutParams r11 = generateDefaultLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.addRule(14);
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r12.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 30, r13.getDisplayMetrics()));
        addView(this.f7755o, r12);
        TextView r14 = this.f7755o;
        Intrinsics.checkNotNull(r14);
        return r14;
    }

    private final TextView getTitleViewOrCreate() {
        View r10 = this.f7747g;
        if (r10 == null) goto L8;
        TextView r11 = this.f7753m;
        if (r10 != r11) goto L8;
    L6:
        Intrinsics.checkNotNull(r11);
        return r11;
    L8:
        if (this.f7753m != null) goto L11;
        this.f7753m = l();
    L11:
        if (this.f7747g == null) goto L13;
        p();
    L13:
        addView(this.f7753m, j());
        r11 = this.f7753m;
        this.f7747g = r11;
        goto L6
    }

    private final void h(String r10) {
        Rect r11 = new Rect();
        Rect r12 = new Rect();
        List<View> r13 = this.f7750j;
        if (r13 == null) goto L8;
        Iterator<T> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        View r15 = (View) r14.next();
        Rect r16 = new Rect();
        r15.getGlobalVisibleRect(r16);
        r11.union(r16.left, r16.top, r16.right, r16.bottom);
    L8:
        List<View> r17 = this.f7751k;
        if (r17 == null) goto L15;
        Iterator<T> r18 = r17.iterator();
    L12:
        if (r18.hasNext() == false) goto L15;
        View r19 = (View) r18.next();
        Rect r20 = new Rect();
        r19.getGlobalVisibleRect(r20);
        r12.union(r20.left, r20.top, r20.right, r20.bottom);
    L15:
        if (r11.isEmpty() == false) goto L17;
        int r21 = 0;
    L18:
        int r22 = RangesKt.coerceAtLeast(r21, 0);
        if (r12.isEmpty() == false) goto L21;
        int r23 = 0;
    L22:
        int r24 = RangesKt.coerceAtLeast(r23, 0);
        int r25 = Math.max(r22, r24);
        ea.b.a("OCTitleBar", "adjustTitleViewSpace, scene: " + r10 + ", leftSpace: " + r22 + ", rightSpace: " + r24 + ", leftViewRectF: " + r11 + ", rightViewRectF: " + r12 + ", width: " + getWidth() + ", height: " + getHeight());
        if (r25 <= 0) goto L51;
        da.c r26 = da.c.f8520a;
        TextView r27 = this.f7753m;
        ViewGroup.LayoutParams r28 = null;
        if (r27 == null) goto L27;
        ViewGroup.LayoutParams r29 = r27.getLayoutParams();
    L28:
        if (r29 != null) goto L31;
    L29:
        r29 = null;
    L32:
        RelativeLayout.LayoutParams r30 = (RelativeLayout.LayoutParams) r29;
        if (r30 == null) goto L35;
        r30.leftMargin = r25;
        r30.rightMargin = r25;
    L35:
        TextView r31 = this.f7755o;
        if (r31 == null) goto L38;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
    L39:
        if (r32 != null) goto L42;
    L44:
        RelativeLayout.LayoutParams r33 = (RelativeLayout.LayoutParams) r28;
        if (r33 == null) goto L47;
        r33.leftMargin = r25;
        r33.rightMargin = r25;
    L47:
        requestLayout();
        return;
    L42:
        if ((r32 instanceof RelativeLayout.LayoutParams) == false) goto L44;
        r28 = r32;
        goto L44
    L38:
        r32 = null;
        goto L39
    L31:
        if ((r29 instanceof RelativeLayout.LayoutParams) == false) goto L29;
    L27:
        r29 = null;
        goto L28
    L51:
        return;
    L21:
        r23 = getWidth() - r12.left;
        goto L22
    L17:
        r21 = r11.right;
        goto L18
    }

    private final RelativeLayout.LayoutParams i(View r10, boolean r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof RelativeLayout.LayoutParams) == true) goto L10;
        if (r11 == false) goto L7;
        ViewGroup.LayoutParams r13 = j();
    L8:
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        return (RelativeLayout.LayoutParams) r13;
    L7:
        r13 = generateDefaultLayoutParams();
        goto L8
    L10:
        return (RelativeLayout.LayoutParams) r12;
    }

    private final RelativeLayout.LayoutParams j() {
        ViewGroup.LayoutParams r10 = generateDefaultLayoutParams();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) r10;
        r11.addRule(13);
        return r11;
    }

    @SuppressLint({"NewApi"})
    private final TextView k() {
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        OBaseTextView r11 = new OBaseTextView(r10, null, 0, 6, null);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setTextAppearance(k.Label_M);
        Context r12 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        r11.setTextColor(r12.getResources().getColor(f7745t));
        return r11;
    }

    @SuppressLint({"NewApi"})
    private final TextView l() {
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        OBaseTextView r11 = new OBaseTextView(r10, null, 0, 6, null);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setTextAppearance(k.Title_Title_M_Thick);
        Context r12 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        r11.setTextColor(r12.getResources().getColor(f7744s));
        return r11;
    }

    private final int m(List<? extends View> r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (r10.size() <= 0) goto L18;
        int r12 = r10.size();
        int r13 = 0;
    L7:
        if (r11 >= r12) goto L13;
        if (r10.get(r11).getVisibility() == 8) goto L11;
        r13 = r13 + 1;
    L11:
        r11 = r11 + 1;
        goto L7
    L13:
        return r13;
    L18:
        return 0;
    }

    private final void n(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        TypedArray r12 = r11.getTheme().obtainStyledAttributes(r10, l.OCTitleBar, 0, 0);
        int r13 = r12.getInt(l.OCTitleBar_oui_title_pos, com.obric.oui.titlebar.OCTitleBar.TitlePosition.FIXED_CENTER.getValue());
        com.obric.oui.titlebar.OCTitleBar.TitlePosition r14 = com.obric.oui.titlebar.OCTitleBar.TitlePosition.values()[r13];
        String r15 = r12.getString(l.OCTitleBar_oui_title_text);
        if (r15 == null) goto L6;
        setCenterText(r15);
    L6:
        if (r12.getBoolean(l.OCTitleBar_oui_useBackIcon, true) == false) goto L8;
        Context r16 = getContext();
        Intrinsics.checkNotNullExpressionValue(r16, "context");
        OButton r17 = ca.a.b(this, r16);
        r17.setButtonSourceBitmap(f7743r);
        this.f7752l = r17;
        Unit r18 = Unit.INSTANCE;
        e(r17);
    L8:
        String r19 = r12.getString(l.OCTitleBar_oui_sub_title_text);
        if (r19 == null) goto L11;
        setCenterSubText(r19);
    L11:
        this.f7746c = r12.getBoolean(l.OCTitleBar_oui_autoAdjustTitleSpace, true);
        Context r20 = getContext();
        Intrinsics.checkNotNullExpressionValue(r20, "context");
        int r21 = (int) r20.getResources().getDimension(d.oui_p_title_bar_default);
        setPadding(r21, 0, r21, 0);
    }

    private final boolean o() {
        return this.f7746c;
    }

    private final void p() {
        View r10 = this.f7747g;
        if (r10 == null) goto L6;
        removeView(r10);
        this.f7747g = null;
        return;
    }

    private final void q() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f7757q);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ea.b.c("OCTitleBar", "removeGlobalLayoutListener: ", e);
    }

    private final void r(View r10, RelativeLayout.LayoutParams r11) {
        if (Intrinsics.areEqual(this.f7747g, r10) == false) goto L5;
        return;
    L5:
        p();
        this.f7747g = r10;
        addView(r10, r11);
    }

    private final void setCenterSubText(String r10) {
        getSubtitleViewOrCreate().setText(r10);
        g();
    }

    private final void setCenterText(String r10) {
        getTitleViewOrCreate().setText(r10);
    }

    public final void e(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        f(r10, i(r10, false), getLeftViewCount(), 0);
    }

    public final void f(View r10, RelativeLayout.LayoutParams r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "layoutParams");
        r11.alignWithParent = true;
        r11.leftMargin = r13;
        r10.setId(View.generateViewId());
        if (this.f7748h != null) goto L5;
        r12 = 0;
        r11.addRule(9);
    L14:
        r11.addRule(15);
        List<View> r14 = this.f7750j;
        if (r14 == null) goto L18;
        Intrinsics.checkNotNull(r14);
        if (r12 == r14.size()) goto L18;
    L19:
        getLeftViewListOrCreate().add(r12, r10);
        addView(r10, r11);
        return;
    L18:
        this.f7748h = r10;
        goto L19
    L5:
        if (r12 < 0) goto L13;
        List<View> r15 = this.f7750j;
        Intrinsics.checkNotNull(r15);
        if (r12 >= r15.size()) goto L13;
        if (r12 != 0) goto L12;
        r11.addRule(9);
        List<View> r16 = this.f7750j;
        Intrinsics.checkNotNull(r16);
        ViewGroup.LayoutParams r17 = r16.get(r12).getLayoutParams();
        Objects.requireNonNull(r17, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r18 = (RelativeLayout.LayoutParams) r17;
        r18.removeRule(9);
        r18.addRule(1, r10.getId());
        goto L14
    L12:
        List<View> r19 = this.f7750j;
        Intrinsics.checkNotNull(r19);
        View r20 = r19.get(r12 - 1);
        List<View> r21 = this.f7750j;
        Intrinsics.checkNotNull(r21);
        View r22 = r21.get(r12);
        r11.addRule(1, r20.getId());
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        Objects.requireNonNull(r23, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r23).addRule(1, r10.getId());
    L13:
        List<View> r24 = this.f7750j;
        Intrinsics.checkNotNull(r24);
        r12 = r24.size();
        View r25 = this.f7748h;
        Intrinsics.checkNotNull(r25);
        r11.addRule(1, r25.getId());
        goto L14
    }

    public final int getLeftViewCount() {
        return m(this.f7750j);
    }

    public final View getMCenterView() {
        return this.f7747g;
    }

    public final OButton getMLeftActionBack() {
        return this.f7752l;
    }

    public final View getMLeftLastView() {
        return this.f7748h;
    }

    public final List<View> getMLeftViewList() {
        return this.f7750j;
    }

    public final View getMRightLastView() {
        return this.f7749i;
    }

    public final List<View> getMRightViewList() {
        return this.f7751k;
    }

    public final TextView getMSubTitleView() {
        return this.f7755o;
    }

    public final TextView getMTitleView() {
        return this.f7753m;
    }

    public final int getRightViewCount() {
        return m(this.f7751k);
    }

    public final String getSubTitleText() {
        return this.f7756p;
    }

    public final String getTitleText() {
        return this.f7754n;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        Context r12 = getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec((int) r12.getResources().getDimension(d.oui_h_title_bar_window), 1073741824));
    }

    public final void setCenterText(int r10) {
        setCenterText(getContext().getString(r10));
    }

    public final void setCenterView(View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r(r10, i(r10, true));
    }

    public final void setMCenterView(View r10) {
        this.f7747g = r10;
    }

    public final void setMLeftActionBack(OButton r10) {
        this.f7752l = r10;
    }

    public final void setMLeftLastView(View r10) {
        this.f7748h = r10;
    }

    public final void setMLeftViewList(List<View> r10) {
        this.f7750j = r10;
    }

    public final void setMRightLastView(View r10) {
        this.f7749i = r10;
    }

    public final void setMRightViewList(List<View> r10) {
        this.f7751k = r10;
    }

    public final void setMSubTitleView(TextView r10) {
        this.f7755o = r10;
    }

    public final void setMTitleView(TextView r10) {
        this.f7753m = r10;
    }

    public final void setSubTitleText(String r10) {
        this.f7756p = r10;
        setCenterSubText(r10);
    }

    public final void setTitleText(String r10) {
        this.f7754n = r10;
        setCenterText(r10);
    }
}
