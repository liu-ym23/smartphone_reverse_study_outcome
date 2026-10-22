package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 T2\u00020\u0001:\u0001UB'\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u0002¢\u0006\u0004\bR\u0010SJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0001J\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010$\u001a\u00020#J\u0010\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010(\u001a\u0004\u0018\u00010%J\u0006\u0010*\u001a\u00020)J\u0010\u0010+\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010,\u001a\u0004\u0018\u00010%J\u0006\u0010-\u001a\u00020)J\u0006\u0010/\u001a\u00020.J\u0010\u00100\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u00100\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0002J\b\u00103\u001a\u0004\u0018\u00010\u0017J\b\u00104\u001a\u0004\u0018\u00010\u001eJ\b\u00106\u001a\u0004\u0018\u000105J\b\u00108\u001a\u0004\u0018\u000107J\b\u00109\u001a\u0004\u0018\u00010)J\u0010\u0010:\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%J\u0010\u0010;\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0002J\u0006\u0010>\u001a\u00020#J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\bJ\u000e\u0010A\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\bJ\u0010\u0010B\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010D\u001a\u00020CJ\b\u0010E\u001a\u0004\u0018\u00010\u0017J\u0010\u0010H\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010FJ\u0010\u0010J\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010IJ\u0010\u0010L\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\bH\u0016¨\u0006V"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem;", "Landroid/widget/FrameLayout;", "", TypedValues.Custom.S_COLOR, "", "setBgColor", "setContentColor", "Landroid/content/res/ColorStateList;", "", "checked", "setContentChecked", "show", "setShowCardBg", "getShowCardBg", WsConstants.KEY_CONNECTION_TYPE, "setCardType", "getCardType", "position", "setCardPosition", "getCardPosition", "getCardContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "getContentContainer", "Landroid/view/View;", "view", "setCustomStartView", "resId", "defaultCustomStart", "setDefaultCustomStartView", "getCustomStartView", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "getStartCheckBox", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "Landroid/widget/ImageView;", "getIconView", "", "text", "setTitle", "getTitle", "Lcom/obric/oui/text/OTextView;", "getTitleView", "setSubTitle", "getSubTitle", "getSubTitleView", "Landroid/widget/LinearLayout;", "getTitleContainer", "setCustomEndView", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "getEndCheckBox", "Lcom/obric/oui/oswitch/OSwitch;", "getEndSwitch", "Lcom/obric/oui/checkbox/OCheckMark;", "getEndMark", "getEndDetail", "setEndDetailText", "setTailIcon", "defaultTailIcon", "setDefaultTailIcon", "getTailIconView", "enable", "setEnableSwipeDivider", "setEnableSwipe", "setSwipeView", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "getSwipeLayout", "getSwipeView", "Landroid/view/View$OnClickListener;", "listener", "setOnContentClickListener", "Landroid/view/View$OnLongClickListener;", "setOnContentLongClickListener", "enabled", "setEnabled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "V", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OCardListItem extends FrameLayout {
    private static final int H = 0;
    private static final int I = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int f6857J = 0;
    private static final int K = 0;
    private static final int L = 0;
    private static final int M = 0;
    private static final int N = 0;
    private static final int O = 0;
    private static final int P = 0;
    private static final int Q = 0;
    private static final int R = 0;
    private static final int S = 0;
    private static final int T = 0;
    private static final int U = 0;
    public static final c V = null;
    private int A;
    private OSwipeLayout B;
    private FrameLayout C;
    private int D;
    private boolean E;
    private int F;
    private int G;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u9.a f6858c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FrameLayout f6861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FrameLayout f6862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final OUILinearLayout f6863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final GradientDrawable f6864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorStateList f6865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final FrameLayout f6866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final FrameLayout f6867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ImageView f6868p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LinearLayout f6869q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final OTextView f6870r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f6871s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final OTextView f6872t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f6873u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final FrameLayout f6874v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ImageView f6875w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final View f6876x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View.OnLayoutChangeListener f6877y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6878z;

    static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCardListItem f6879a;

        a(OCardListItem r10) {
            this.f6879a = r10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            if (OCardListItem.f(this.f6879a).getVisibility() != 0) goto L5;
            boolean r19 = true;
        L6:
            if (r19 == false) goto L9;
            OCardListItem.p(this.f6879a);
            return;
        L9:
            return;
        L5:
            r19 = false;
            goto L6
        }
    }

    public static final class b implements OSwipeLayout.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCardListItem f6880a;

        b(OCardListItem r10) {
            this.f6880a = r10;
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.i
        public void a(OSwipeLayout r10) {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.i
        public void b(OSwipeLayout r10, int r11, int r12) {
            OCardListItem.o(this.f6880a, r11);
            if (OCardListItem.f(this.f6880a).getVisibility() != 0) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L13;
            View r14 = OCardListItem.f(this.f6880a);
            if (OCardListItem.g(this.f6880a) == false) goto L10;
            float r15 = r11;
        L11:
            r14.setTranslationX(r15);
            return;
        L10:
            r15 = 0.0f;
            goto L11
        L13:
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.i
        public void c(OSwipeLayout r10) {
            this.f6880a.setContentChecked(false);
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.i
        public void d(OSwipeLayout r10) {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.i
        public void e(OSwipeLayout r10) {
            this.f6880a.setContentChecked(true);
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.i
        public void f(OSwipeLayout r10, float r11, float r12) {
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r10) {
            this();
        }

        public final int a() {
            return OCardListItem.i();
        }

        public final int b() {
            return OCardListItem.j();
        }

        public final int c() {
            return OCardListItem.k();
        }

        public final int d() {
            return OCardListItem.l();
        }
    }

    public static final class d extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCardListItem f6881a;

        d(OCardListItem r10) {
            this.f6881a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, "outline");
            int r12 = r10.getWidth();
            int r13 = r10.getHeight();
            if (OCardListItem.b(this.f6881a) != 0) goto L5;
            int r14 = 8;
        L6:
            Resources r15 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
            r11.setRoundRect(0, 0, r12, r13, MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics())));
            return;
        L5:
            r14 = 10;
            goto L6
        }
    }

    static final class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OCardListItem f6882c;

        e(OCardListItem r10) {
            this.f6882c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r10 = OCardListItem.d(this.f6882c);
            int r11 = OCardListItem.c(this.f6882c);
            ViewGroup.LayoutParams r12 = null;
            if (OCardListItem.d(this.f6882c) != (-1)) goto L5;
        L6:
            ViewGroup.LayoutParams r13 = OCardListItem.a(this.f6882c).getLayoutParams();
            if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
            r13 = null;
        L9:
            ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
            boolean r15 = false;
            if (r14 == null) goto L12;
            int r16 = r14.leftMargin;
        L13:
            int r17 = OCardListItem.a(this.f6882c).getPaddingLeft();
            ViewGroup.LayoutParams r18 = OCardListItem.a(this.f6882c).getLayoutParams();
            if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L16;
            r18 = null;
        L16:
            ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
            if (r19 == null) goto L19;
            int r20 = r19.rightMargin;
        L20:
            int r21 = OCardListItem.a(this.f6882c).getPaddingRight();
            r10 = r16 + r17;
            if (OCardListItem.e(this.f6882c).getVisibility() != 0) goto L23;
            boolean r22 = true;
        L24:
            if (r22 == false) goto L27;
            r10 = r10 + OCardListItem.e(this.f6882c).getWidth();
        L27:
            if (OCardListItem.h(this.f6882c).getVisibility() != 0) goto L29;
            boolean r23 = true;
        L30:
            if (r23 == false) goto L33;
            r10 = r10 + OCardListItem.h(this.f6882c).getWidth();
        L33:
            if (OCardListItem.e(this.f6882c).getVisibility() != 8) goto L35;
            boolean r24 = true;
        L36:
            if (r24 == true) goto L38;
        L42:
            Resources r25 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r25, "Resources.getSystem()");
            r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r25.getDisplayMetrics())) + (r20 + r21);
        L43:
            ViewGroup.LayoutParams r26 = OCardListItem.f(this.f6882c).getLayoutParams();
            if ((r26 instanceof ViewGroup.MarginLayoutParams) == false) goto L47;
            r12 = r26;
        L47:
            ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r12;
            if (r27 == null) goto L50;
            r27.setMargins(r10, r27.topMargin, r11, r27.bottomMargin);
        L50:
            OCardListItem.f(this.f6882c).setLayoutParams(r27);
            return;
        L38:
            if (OCardListItem.h(this.f6882c).getVisibility() != 8) goto L40;
            r15 = true;
        L40:
            if (r15 == false) goto L42;
            r10 = r10 + OCardListItem.n(this.f6882c).getPaddingLeft();
            goto L42
        L35:
            r24 = false;
            goto L36
        L29:
            r23 = false;
            goto L30
        L23:
            r22 = false;
            goto L24
        L19:
            r20 = 0;
            goto L20
        L12:
            r16 = 0;
            goto L13
        L5:
            if (OCardListItem.c(this.f6882c) != (-1)) goto L43;
            goto L6
        }
    }

    static {
        V = new c(null);
        I = 1;
        f6857J = 2;
        L = 1;
        M = 2;
        N = 3;
        Q = 1;
        R = 2;
        S = 3;
        U = 1;
    }

    @JvmOverloads
    public OCardListItem(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OCardListItem(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OCardListItem(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6859g = true;
        this.f6860h = getResources().getColor(u8.c.oui_fill_list_item_card);
        this.f6864l = new GradientDrawable();
        ColorStateList r13 = getResources().getColorStateList(u8.c.o_card_list_item_content_bg_color);
        Intrinsics.checkNotNullExpressionValue(r13, "resources.getColorStateL…st_item_content_bg_color)");
        this.f6865m = r13;
        this.f6871s = getResources().getColor(u8.c.oui_basic_text_1);
        this.f6873u = getResources().getColor(u8.c.oui_basic_text_3);
        this.f6878z = -1;
        this.A = -1;
        this.E = true;
        this.F = -1;
        this.G = H;
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r14 = LayoutInflater.from(r10).inflate(h.o_card_list_item_layout, this, true);
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r15 = (FrameLayout) r14;
        View r16 = findViewById(f.card_list_item_root);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.card_list_item_root)");
        this.f6861i = (FrameLayout) r16;
        View r17 = findViewById(f.card_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.card_container)");
        FrameLayout r18 = (FrameLayout) r17;
        this.f6862j = r18;
        View r19 = findViewById(f.content_container);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.content_container)");
        OUILinearLayout r20 = (OUILinearLayout) r19;
        this.f6863k = r20;
        r20.setChangeAlphaWhenPress(false);
        r20.setChangeAlphaWhenDisable(true);
        View r21 = findViewById(f.custom_start_container);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.custom_start_container)");
        this.f6866n = (FrameLayout) r21;
        View r22 = findViewById(f.icon_container);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.icon_container)");
        this.f6867o = (FrameLayout) r22;
        View r23 = findViewById(f.icon);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.icon)");
        this.f6868p = (ImageView) r23;
        View r24 = findViewById(f.title_container);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.title_container)");
        this.f6869q = (LinearLayout) r24;
        View r25 = findViewById(f.title);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.title)");
        this.f6870r = (OTextView) r25;
        View r26 = findViewById(f.sub_title);
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.sub_title)");
        this.f6872t = (OTextView) r26;
        View r27 = findViewById(f.custom_end_container);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.custom_end_container)");
        this.f6874v = (FrameLayout) r27;
        View r28 = findViewById(f.tail_icon);
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.tail_icon)");
        this.f6875w = (ImageView) r28;
        View r29 = findViewById(f.card_divider);
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.card_divider)");
        this.f6876x = r29;
        this.f6877y = new a(this);
        View r30 = findViewById(f.swipe_layout);
        Intrinsics.checkNotNullExpressionValue(r30, "findViewById(R.id.swipe_layout)");
        OSwipeLayout r31 = (OSwipeLayout) r30;
        this.B = r31;
        r31.setChangeAlphaWhenDisable(false);
        this.B.setSwipeEnabled(false);
        this.B.n(new b(this));
        View r32 = findViewById(f.swip_container);
        Intrinsics.checkNotNullExpressionValue(r32, "findViewById(R.id.swip_container)");
        this.C = (FrameLayout) r32;
        if (r11 == null) goto L8;
        q(r11);
    L8:
        t();
        s();
        setCardType(this.G);
        x(this.f6871s, this.f6873u);
        this.f6858c = new u9.a(r18, this.f6859g, this.f6860h, this.F);
    }

    public /* synthetic */ OCardListItem(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void F() {
        this.f6876x.post(new e(this));
        requestLayout();
    }

    public static final /* synthetic */ FrameLayout a(OCardListItem r10) {
        return r10.f6862j;
    }

    public static final /* synthetic */ int b(OCardListItem r10) {
        return r10.G;
    }

    public static final /* synthetic */ int c(OCardListItem r10) {
        return r10.A;
    }

    public static final /* synthetic */ int d(OCardListItem r10) {
        return r10.f6878z;
    }

    public static final /* synthetic */ FrameLayout e(OCardListItem r10) {
        return r10.f6866n;
    }

    public static final /* synthetic */ View f(OCardListItem r10) {
        return r10.f6876x;
    }

    public static final /* synthetic */ boolean g(OCardListItem r10) {
        return r10.E;
    }

    public static final /* synthetic */ FrameLayout h(OCardListItem r10) {
        return r10.f6867o;
    }

    public static final /* synthetic */ int i() {
        return N;
    }

    public static final /* synthetic */ int j() {
        return M;
    }

    public static final /* synthetic */ int k() {
        return K;
    }

    public static final /* synthetic */ int l() {
        return L;
    }

    public static final /* synthetic */ int[] m() {
        return FrameLayout.PRESSED_STATE_SET;
    }

    public static final /* synthetic */ LinearLayout n(OCardListItem r10) {
        return r10.f6869q;
    }

    public static final /* synthetic */ void o(OCardListItem r10, int r11) {
        r10.D = r11;
    }

    public static final /* synthetic */ void p(OCardListItem r10) {
        r10.F();
    }

    private final void q(AttributeSet r10) {
        TypedArray r11 = getContext().obtainStyledAttributes(r10, l.OCardListItemContainer);
        Intrinsics.checkNotNullExpressionValue(r11, "context.obtainStyledAttr…e.OCardListItemContainer)");
        int r12 = l.OCardListItemContainer_ocardlistitem_showCardBg;     // Catch: Throwable -> L72
        if (r11.hasValue(r12) == false) goto L6;
        this.f6859g = r11.getBoolean(r12, true);     // Catch: Throwable -> L72
    L6:
        this.f6860h = r11.getColor(l.OCardListItemContainer_ocardlistitem_bgColor, getResources().getColor(u8.c.oui_fill_list_item_card));     // Catch: Throwable -> L72
        int r13 = l.OCardListItemContainer_ocardlistitem_contentColorList;     // Catch: Throwable -> L72
        if (r11.hasValue(r13) == false) goto L13;
        ColorStateList r14 = r11.getColorStateList(r13);     // Catch: Throwable -> L72
        if (r14 != null) goto L12;
        r14 = getResources().getColorStateList(u8.c.o_card_list_item_content_bg_color);     // Catch: Throwable -> L72
        Intrinsics.checkNotNullExpressionValue(r14, "resources.getColorStateL…st_item_content_bg_color)");     // Catch: Throwable -> L72
    L12:
        this.f6865m = r14;     // Catch: Throwable -> L72
    L13:
        int r15 = l.OCardListItemContainer_ocardlistitem_cardType;     // Catch: Throwable -> L72
        if (r11.hasValue(r15) == false) goto L16;
        this.G = r11.getInt(r15, 0);     // Catch: Throwable -> L72
    L16:
        int r16 = l.OCardListItemContainer_ocardlistitem_cardPosition;     // Catch: Throwable -> L72
        if (r11.hasValue(r16) == false) goto L19;
        this.F = r11.getInt(r16, 0);     // Catch: Throwable -> L72
    L19:
        int r17 = l.OCardListItemContainer_ocardlistitem_customStart;     // Catch: Throwable -> L72
        if (r11.hasValue(r17) == false) goto L22;
        setCustomStartView(r11.getResourceId(r17, 0));     // Catch: Throwable -> L72
    L22:
        int r18 = l.OCardListItemContainer_ocardlistitem_defaultCustomStart;     // Catch: Throwable -> L72
        if (r11.hasValue(r18) == false) goto L25;
        setDefaultCustomStartView(r11.getInt(r18, 0));     // Catch: Throwable -> L72
    L25:
        int r19 = l.OCardListItemContainer_ocardlistitem_icon;     // Catch: Throwable -> L72
        if (r11.hasValue(r19) == false) goto L28;
        setIcon(r11.getResourceId(r19, 0));     // Catch: Throwable -> L72
    L28:
        int r20 = l.OCardListItemContainer_ocardlistitem_title;     // Catch: Throwable -> L72
        if (r11.hasValue(r20) == false) goto L31;
        setTitle(r11.getString(r20));     // Catch: Throwable -> L72
    L31:
        this.f6871s = r11.getColor(l.OCardListItemContainer_ocardlistitem_titleColor, getResources().getColor(u8.c.oui_basic_text_1));     // Catch: Throwable -> L72
        int r21 = l.OCardListItemContainer_ocardlistitem_subTitle;     // Catch: Throwable -> L72
        if (r11.hasValue(r21) == false) goto L34;
        setSubTitle(r11.getString(r21));     // Catch: Throwable -> L72
    L34:
        this.f6873u = r11.getColor(l.OCardListItemContainer_ocardlistitem_subTitleColor, getResources().getColor(u8.c.oui_basic_text_3));     // Catch: Throwable -> L72
        int r22 = l.OCardListItemContainer_ocardlistitem_customEnd;     // Catch: Throwable -> L72
        if (r11.hasValue(r22) == false) goto L37;
        setCustomEndView(r11.getResourceId(r22, 0));     // Catch: Throwable -> L72
    L37:
        int r23 = l.OCardListItemContainer_ocardlistitem_defaultCustomEnd;     // Catch: Throwable -> L72
        if (r11.hasValue(r23) == false) goto L40;
        setDefaultCustomEndView(r11.getInt(r23, 0));     // Catch: Throwable -> L72
    L40:
        int r24 = l.OCardListItemContainer_ocardlistitem_endDetailText;     // Catch: Throwable -> L72
        if (r11.hasValue(r24) == false) goto L43;
        setEndDetailText(r11.getString(r24));     // Catch: Throwable -> L72
    L43:
        int r25 = l.OCardListItemContainer_ocardlistitem_tailIcon;     // Catch: Throwable -> L72
        if (r11.hasValue(r25) == false) goto L46;
        setTailIcon(r11.getResourceId(r25, 0));     // Catch: Throwable -> L72
    L46:
        int r26 = l.OCardListItemContainer_ocardlistitem_defaultTailIcon;     // Catch: Throwable -> L72
        if (r11.hasValue(r26) == false) goto L49;
        setDefaultTailIcon(r11.getInt(r26, 0));     // Catch: Throwable -> L72
    L49:
        int r27 = l.OCardListItemContainer_ocardlistitem_showCustomStart;     // Catch: Throwable -> L72
        if (r11.hasValue(r27) == false) goto L52;
        z(r11.getBoolean(r27, false));     // Catch: Throwable -> L72
    L52:
        int r28 = l.OCardListItemContainer_ocardlistitem_showIcon;     // Catch: Throwable -> L72
        if (r11.hasValue(r28) == false) goto L55;
        B(r11.getBoolean(r28, false));     // Catch: Throwable -> L72
    L55:
        int r29 = l.OCardListItemContainer_ocardlistitem_showTitle;     // Catch: Throwable -> L72
        if (r11.hasValue(r29) == false) goto L58;
        E(r11.getBoolean(r29, false));     // Catch: Throwable -> L72
    L58:
        int r30 = l.OCardListItemContainer_ocardlistitem_showSubTitle;     // Catch: Throwable -> L72
        if (r11.hasValue(r30) == false) goto L61;
        C(r11.getBoolean(r30, false));     // Catch: Throwable -> L72
    L61:
        int r31 = l.OCardListItemContainer_ocardlistitem_showCustomEnd;     // Catch: Throwable -> L72
        if (r11.hasValue(r31) == false) goto L64;
        y(r11.getBoolean(r31, false));     // Catch: Throwable -> L72
    L64:
        int r32 = l.OCardListItemContainer_ocardlistitem_showTailIcon;     // Catch: Throwable -> L72
        if (r11.hasValue(r32) == false) goto L67;
        D(r11.getBoolean(r32, false));     // Catch: Throwable -> L72
    L67:
        int r33 = l.OCardListItemContainer_ocardlistitem_showDivider;     // Catch: Throwable -> L72
        if (r11.hasValue(r33) == false) goto L70;
        A(r11.getBoolean(r33, false));     // Catch: Throwable -> L72
    L70:
        r11.recycle();
        return;
    L72:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    private final void r(View r10, boolean r11) {
        if ((r10 instanceof ViewGroup) == false) goto L7;
        int r12 = 0;
        ViewGroup r13 = (ViewGroup) r10;
        int r14 = r13.getChildCount();
    L5:
        if (r12 >= r14) goto L9;
        View r15 = r13.getChildAt(r12);
        Intrinsics.checkNotNullExpressionValue(r15, "child");
        r15.setEnabled(r11);
        r(r15, r11);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    private final void s() {
        ViewGroup.LayoutParams r10 = this.f6861i.getLayoutParams();
        ViewGroup.LayoutParams r11 = null;
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r10 = null;
    L5:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10;
        int r13 = 0;
        if (r12 != null) goto L8;
    L16:
        this.f6861i.setLayoutParams(r12);
        ViewGroup.LayoutParams r14 = this.f6862j.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r11 = r14;
    L20:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r11;
        if (r15 != null) goto L23;
    L31:
        this.f6862j.setLayoutParams(r15);
        return;
    L23:
        if (this.f6859g == false) goto L25;
        int r16 = 0;
    L26:
        int r17 = r15.topMargin;
        if (this.f6859g == true) goto L30;
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r18.getDisplayMetrics()));
    L30:
        r15.setMargins(r16, r17, r13, r15.bottomMargin);
        goto L31
    L25:
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        r16 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r19.getDisplayMetrics()));
        goto L26
    L8:
        if (this.f6859g == false) goto L10;
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        int r21 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r20.getDisplayMetrics()));
    L11:
        int r22 = r12.topMargin;
        if (this.f6859g == false) goto L14;
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        int r24 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r23.getDisplayMetrics()));
    L15:
        r12.setMargins(r21, r22, r24, r12.bottomMargin);
        goto L16
    L14:
        r24 = 0;
        goto L15
    L10:
        r21 = 0;
        goto L11
    }

    private final void t() {
        boolean r10 = true;
        if (this.f6859g == false) goto L5;
        int r11 = 12;
    L6:
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        this.f6864l.setColor(this.f6865m);
        this.f6864l.setCornerRadius(r13);
        this.f6863k.setBackground(this.f6864l);
        if (this.f6876x.getVisibility() == 0) goto L10;
        r10 = false;
    L10:
        if (r10 == false) goto L13;
        F();
        return;
    L13:
        return;
    L5:
        r11 = 20;
        goto L6
    }

    private final void u() {
        if (this.f6874v.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L25;
        View r11 = getCustomEndView();
        if ((r11 instanceof OTextView) == false) goto L26;
        OTextView r12 = (OTextView) r11;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r13 = null;
    L12:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        if (r14 == null) goto L23;
        int r15 = r14.leftMargin;
        int r16 = r14.topMargin;
        if (this.f6875w.getVisibility() != 0) goto L17;
        boolean r17 = true;
    L19:
        if (r17 == false) goto L21;
        float r18 = 0;
    L22:
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        r14.setMargins(r15, r16, MathKt.roundToInt(TypedValue.applyDimension(1, r18, r19.getDisplayMetrics())), r14.bottomMargin);
        goto L23
    L21:
        r18 = 6;
        goto L22
    L17:
        r17 = false;
    L23:
        r12.setLayoutParams(r14);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r10 = false;
        goto L6
    }

    private final void v() {
        this.f6868p.setClipToOutline(true);
        this.f6868p.setOutlineProvider(new d(this));
        this.f6868p.invalidateOutline();
    }

    private final void w() {
        boolean r10 = true;
        if (this.f6866n.getVisibility() != 8) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        if ((getCustomStartView() instanceof OCheckBoxLayout) == true) goto L10;
    L15:
        LinearLayout r12 = this.f6869q;
        r12.setPadding(0, r12.getPaddingTop(), this.f6869q.getPaddingRight(), this.f6869q.getPaddingBottom());
    L17:
        if (this.f6876x.getVisibility() == 0) goto L20;
        r10 = false;
    L20:
        if (r10 == false) goto L22;
        F();
    L22:
        requestLayout();
        return;
    L10:
        if (this.f6867o.getVisibility() != 8) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        LinearLayout r14 = this.f6869q;
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        r14.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 12, r15.getDisplayMetrics())), this.f6869q.getPaddingTop(), this.f6869q.getPaddingRight(), this.f6869q.getPaddingBottom());
        goto L17
    L12:
        r13 = false;
        goto L13
    L5:
        r11 = false;
        goto L6
    }

    public final void A(boolean r10) {
        View r11 = this.f6876x;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        if (r10 == false) goto L14;
        View r13 = this.f6876x;
        if (this.E == false) goto L11;
        float r14 = this.D;
    L12:
        r13.setTranslationX(r14);
        F();
        return;
    L11:
        r14 = 0.0f;
        goto L12
    L14:
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void B(boolean r10) {
        FrameLayout r11 = this.f6867o;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        w();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void C(boolean r10) {
        CharSequence r11 = getSubTitle();
        int r12 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        OTextView r14 = this.f6872t;
        if (r13 == true) goto L15;
        if (r10 == true) goto L14;
        r12 = 8;
    L14:
        r14.setVisibility(r12);
        return;
    L15:
        r14.setVisibility(8);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    public final void D(boolean r10) {
        ImageView r11 = this.f6875w;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        u();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void E(boolean r10) {
        CharSequence r11 = getTitle();
        int r12 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        OTextView r14 = this.f6870r;
        if (r13 == true) goto L15;
        if (r10 == true) goto L14;
        r12 = 8;
    L14:
        r14.setVisibility(r12);
        return;
    L15:
        r14.setVisibility(8);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    public final FrameLayout getCardContainer() {
        return this.f6862j;
    }

    public final int getCardPosition() {
        return this.F;
    }

    public final int getCardType() {
        return this.G;
    }

    public final OUILinearLayout getContentContainer() {
        return this.f6863k;
    }

    public final View getCustomEndView() {
        if (this.f6874v.getChildCount() == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        return null;
    L8:
        return this.f6874v.getChildAt(0);
    L5:
        r10 = false;
        goto L6
    }

    public final View getCustomStartView() {
        if (this.f6866n.getChildCount() == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        return null;
    L8:
        return this.f6866n.getChildAt(0);
    L5:
        r10 = false;
        goto L6
    }

    public final OCheckBoxLayout getEndCheckBox() {
        if ((getCustomEndView() instanceof OCheckBoxLayout) == false) goto L6;
        View r10 = getCustomEndView();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
        return (OCheckBoxLayout) r10;
    L6:
        return null;
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L6;
        View r10 = getCustomEndView();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        return (OTextView) r10;
    L6:
        return null;
    }

    public final OCheckMark getEndMark() {
        if ((getCustomEndView() instanceof OCheckMark) == false) goto L6;
        View r10 = getCustomEndView();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
        return (OCheckMark) r10;
    L6:
        return null;
    }

    public final OSwitch getEndSwitch() {
        if ((getCustomEndView() instanceof OSwitch) == false) goto L6;
        View r10 = getCustomEndView();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
        return (OSwitch) r10;
    L6:
        return null;
    }

    public final ImageView getIconView() {
        return this.f6868p;
    }

    public final boolean getShowCardBg() {
        return this.f6859g;
    }

    public final OCheckBoxLayout getStartCheckBox() {
        if ((getCustomStartView() instanceof OCheckBoxLayout) == false) goto L6;
        View r10 = getCustomStartView();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
        return (OCheckBoxLayout) r10;
    L6:
        return null;
    }

    public final CharSequence getSubTitle() {
        return this.f6872t.getText();
    }

    public final OTextView getSubTitleView() {
        return this.f6872t;
    }

    public final OSwipeLayout getSwipeLayout() {
        return this.B;
    }

    public final View getSwipeView() {
        if (this.C.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.C.getChildAt(0);
    }

    public final ImageView getTailIconView() {
        return this.f6875w;
    }

    public final CharSequence getTitle() {
        return this.f6870r.getText();
    }

    public final LinearLayout getTitleContainer() {
        return this.f6869q;
    }

    public final OTextView getTitleView() {
        return this.f6870r;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6866n.addOnLayoutChangeListener(this.f6877y);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6866n.removeOnLayoutChangeListener(this.f6877y);
    }

    public final void setBgColor(int r10) {
        this.f6858c.b(r10);
    }

    public final void setCardPosition(int r10) {
        this.F = r10;
        this.f6858c.c(r10);
    }

    public final void setCardType(int r10) {
        this.G = r10;
        boolean r11 = false;
        if (r10 != H) goto L7;
        OUILinearLayout r12 = this.f6863k;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r12.setPaddingRelative(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 4, r13.getDisplayMetrics())), 0);
        OUILinearLayout r14 = this.f6863k;
        float r15 = 48;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r14.setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r15, r16.getDisplayMetrics())));
        this.f6869q.setVisibility(0);
        FrameLayout r17 = this.f6866n;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) r18;
        r19.width = -2;
        r19.weight = 0.0f;
        Unit r20 = Unit.INSTANCE;
        r17.setLayoutParams(r19);
        FrameLayout r21 = this.f6867o;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        r22.width = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r23.getDisplayMetrics()));
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        r22.height = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r24.getDisplayMetrics()));
        r21.setLayoutParams(r22);
        FrameLayout r25 = this.f6867o;
        int r26 = 10;
    L5:
        float r27 = r26;
        Resources r28 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r28, "Resources.getSystem()");
        int r29 = MathKt.roundToInt(TypedValue.applyDimension(1, r27, r28.getDisplayMetrics()));
        Resources r30 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r30, "Resources.getSystem()");
        int r31 = MathKt.roundToInt(TypedValue.applyDimension(1, r27, r30.getDisplayMetrics()));
        Resources r32 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r32, "Resources.getSystem()");
        int r33 = MathKt.roundToInt(TypedValue.applyDimension(1, r27, r32.getDisplayMetrics()));
        Resources r34 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r34, "Resources.getSystem()");
        r25.setPadding(r29, r31, r33, MathKt.roundToInt(TypedValue.applyDimension(1, r27, r34.getDisplayMetrics())));
    L12:
        v();
        if (this.f6876x.getVisibility() != 0) goto L15;
        r11 = true;
    L15:
        if (r11 == false) goto L18;
        F();
        return;
    L18:
        return;
    L7:
        if (r10 != I) goto L10;
        OUILinearLayout r35 = this.f6863k;
        Resources r36 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r36, "Resources.getSystem()");
        r35.setPaddingRelative(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 4, r36.getDisplayMetrics())), 0);
        OUILinearLayout r37 = this.f6863k;
        float r38 = 60;
        Resources r39 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r39, "Resources.getSystem()");
        r37.setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r38, r39.getDisplayMetrics())));
        this.f6869q.setVisibility(0);
        FrameLayout r40 = this.f6866n;
        ViewGroup.LayoutParams r41 = r40.getLayoutParams();
        Objects.requireNonNull(r41, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r42 = (LinearLayout.LayoutParams) r41;
        r42.width = -2;
        r42.weight = 0.0f;
        Unit r43 = Unit.INSTANCE;
        r40.setLayoutParams(r42);
        FrameLayout r44 = this.f6867o;
        ViewGroup.LayoutParams r45 = r44.getLayoutParams();
        Resources r46 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r46, "Resources.getSystem()");
        r45.width = MathKt.roundToInt(TypedValue.applyDimension(1, r38, r46.getDisplayMetrics()));
        Resources r47 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r47, "Resources.getSystem()");
        r45.height = MathKt.roundToInt(TypedValue.applyDimension(1, r38, r47.getDisplayMetrics()));
        r44.setLayoutParams(r45);
        r25 = this.f6867o;
        r26 = 12;
        goto L5
    L10:
        if (r10 != f6857J) goto L12;
        this.f6863k.setPaddingRelative(0, 0, 0, 0);
        this.f6863k.setMinimumHeight(0);
        this.f6869q.setVisibility(8);
        FrameLayout r48 = this.f6866n;
        ViewGroup.LayoutParams r49 = r48.getLayoutParams();
        Objects.requireNonNull(r49, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r50 = (LinearLayout.LayoutParams) r49;
        r50.width = -1;
        r50.weight = 1.0f;
        Unit r51 = Unit.INSTANCE;
        r48.setLayoutParams(r50);
        z(true);
        goto L12
    }

    public final void setContentChecked(boolean r10) {
        if (r10 == true) goto L4;
        this.f6864l.setColor(this.f6865m);
        return;
    L4:
        if (this.f6865m.isStateful() == false) goto L6;
        GradientDrawable r11 = this.f6864l;
        int r12 = this.f6865m.getColorForState(m(), getResources().getColor(u8.c.oui_state_overlay_pressed));
    L7:
        r11.setColor(r12);
        return;
    L6:
        r11 = this.f6864l;
        r12 = getResources().getColor(u8.c.oui_state_overlay_pressed);
        goto L7
    }

    public final void setContentColor(int r10) {
        ColorStateList r11 = ColorStateList.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "ColorStateList.valueOf(color)");
        this.f6865m = r11;
        this.f6864l.setColor(r10);
    }

    public final void setContentColor(ColorStateList r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.Custom.S_COLOR);
        this.f6865m = r10;
        this.f6864l.setColor(r10);
    }

    public final void setCustomEndView(int r10) {
        this.f6874v.removeAllViews();
        if (r10 == 0) goto L9;
        FrameLayout.inflate(getContext(), r10, this.f6874v);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void setCustomEndView(View r10) {
        this.f6874v.removeAllViews();
        if (r10 == null) goto L6;
        this.f6874v.addView(r10);
        return;
    }

    public final void setCustomStartView(int r10) {
        this.f6866n.removeAllViews();
        if (r10 == 0) goto L6;
        FrameLayout.inflate(getContext(), r10, this.f6866n);     // Catch: Exception -> L12
    L6:
        if (this.f6876x.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L15;
        F();
        return;
    L15:
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void setCustomStartView(View r10) {
        this.f6866n.removeAllViews();
        if (r10 == null) goto L6;
        this.f6866n.addView(r10);
    L6:
        if (this.f6876x.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        F();
        return;
    L12:
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void setDefaultCustomEndView(int r10) {
        this.f6874v.removeAllViews();
        if (r10 != P) goto L7;
        int r11 = h.o_card_list_item_custom_end_checkbox;
    L5:
        setCustomEndView(r11);
        return;
    L7:
        if (r10 != Q) goto L10;
        r11 = h.o_card_list_item_custom_end_switch;
        goto L5
    L10:
        if (r10 != R) goto L13;
        r11 = h.o_card_list_item_custom_end_mark;
        goto L5
    L13:
        if (r10 != S) goto L16;
        r11 = h.o_card_list_item_custom_end_detail;
        goto L5
    }

    public final void setDefaultCustomStartView(int r10) {
        this.f6866n.removeAllViews();
        if (r10 != O) goto L6;
        setCustomStartView(h.o_card_list_item_custom_start_checkbox);
    L6:
        if (this.f6876x.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        F();
        return;
    L12:
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void setDefaultTailIcon(int r10) {
        if (r10 != T) goto L7;
        Resources r11 = getResources();
        int r12 = u8.e.o_card_list_item_tail_icon_arrow;
    L5:
        setTailIcon(r11.getDrawable(r12));
        return;
    L7:
        if (r10 != U) goto L10;
        r11 = getResources();
        r12 = u8.e.o_card_list_item_tail_icon_chevron;
        goto L5
    }

    public final void setEnableSwipe(boolean r10) {
        this.B.setSwipeEnabled(r10);
        FrameLayout r11 = this.C;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r10) {
        this.E = r10;
        if (this.f6876x.getVisibility() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L13;
        View r12 = this.f6876x;
        if (this.E == false) goto L10;
        float r13 = this.D;
    L11:
        r12.setTranslationX(r13);
        return;
    L10:
        r13 = 0.0f;
        goto L11
    L13:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.f6863k.setEnabled(r10);
        this.f6866n.setEnabled(r10);
        this.f6867o.setEnabled(r10);
        this.f6868p.setEnabled(r10);
        this.f6869q.setEnabled(r10);
        this.f6870r.setEnabled(r10);
        this.f6872t.setEnabled(r10);
        this.f6874v.setEnabled(r10);
        this.f6875w.setEnabled(r10);
        this.B.setEnabled(r10);
        r(this.f6866n, r10);
        r(this.f6874v, r10);
        r(this.C, r10);
    }

    public final void setEndDetailText(CharSequence r10) {
        setDefaultCustomEndView(S);
        if ((getCustomEndView() instanceof OTextView) == false) goto L6;
        View r11 = getCustomEndView();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        ((OTextView) r11).setText(r10);
        return;
    }

    public final void setIcon(int r10) {
        if (r10 == 0) goto L4;
        this.f6868p.setImageResource(r10);
    L6:
        if (this.f6876x.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        F();
        return;
    L12:
        return;
    L8:
        r11 = false;
        goto L9
    L4:
        this.f6868p.setImageDrawable(null);
        goto L6
    }

    public final void setIcon(Drawable r10) {
        if (r10 == null) goto L5;
        this.f6868p.setImageDrawable(r10);
    L5:
        if (this.f6876x.getVisibility() != 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L11;
        F();
        return;
    L11:
        return;
    L7:
        r11 = false;
        goto L8
    }

    public final void setOnContentClickListener(View.OnClickListener r10) {
        this.f6863k.setOnClickListener(r10);
    }

    public final void setOnContentLongClickListener(View.OnLongClickListener r10) {
        this.f6863k.setOnLongClickListener(r10);
    }

    public final void setShowCardBg(boolean r10) {
        this.f6859g = r10;
        t();
        s();
        this.f6858c.d(this.f6859g);
    }

    public final void setSubTitle(CharSequence r10) {
        this.f6872t.setText(r10);
    }

    public final void setSwipeView(int r10) {
        this.C.removeAllViews();
        if (r10 == 0) goto L9;
        FrameLayout.inflate(getContext(), r10, this.C);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void setSwipeView(View r10) {
        this.C.removeAllViews();
        if (r10 == null) goto L6;
        this.C.addView(r10);
        return;
    }

    public final void setTailIcon(int r10) {
        ImageView r11 = this.f6875w;
        if (r10 == 0) goto L5;
        r11.setImageResource(r10);
        return;
    L5:
        r11.setImageDrawable(null);
    }

    public final void setTailIcon(Drawable r10) {
        if (r10 == null) goto L5;
        this.f6875w.setImageDrawable(r10);
        return;
    }

    public final void setTitle(CharSequence r10) {
        this.f6870r.setText(r10);
    }

    public final void x(int r10, int r11) {
        this.f6871s = r10;
        this.f6873u = r11;
        this.f6870r.setTextColor(r10);
        this.f6872t.setTextColor(this.f6873u);
    }

    public final void y(boolean r10) {
        FrameLayout r11 = this.f6874v;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        u();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void z(boolean r10) {
        FrameLayout r11 = this.f6866n;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        w();
        return;
    L5:
        r12 = 8;
        goto L6
    }
}
