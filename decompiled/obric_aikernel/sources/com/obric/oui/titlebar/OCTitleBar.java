package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002YZB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\u0002¢\u0006\u0004\bW\u0010XJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002R.\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u0010>\u001a\u0002072\u0006\u0010\f\u001a\u0002078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010F\u001a\u00020?2\u0006\u0010\f\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010J\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bG\u0010)\u001a\u0004\bH\u0010+\"\u0004\bI\u0010-R\u0013\u0010M\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bK\u0010LR.\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\u000e\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010\u0012¨\u0006["}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar;", "Landroid/widget/FrameLayout;", "", "resId", "", "setCenterText", "", "title", "Landroid/widget/TextView;", "getTitleView", "minWidth", "setMinCenterTitleWidth", EventBody.KEY_VALUE, "r", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subTitleText", "Lcom/obric/oui/button/OButton;", "o", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "i", "Landroid/widget/FrameLayout;", "getMFixedCenterContainer", "()Landroid/widget/FrameLayout;", "setMFixedCenterContainer", "(Landroid/widget/FrameLayout;)V", "mFixedCenterContainer", "h", "getMCenterContainer", "setMCenterContainer", "mCenterContainer", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "getFixedCenterTitleContainer", "()Landroid/view/ViewGroup;", "setFixedCenterTitleContainer", "(Landroid/view/ViewGroup;)V", "fixedCenterTitleContainer", "", "q", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "t", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;)V", "mTitlePosition", "g", "getMRightContainer", "setMRightContainer", "mRightContainer", "getMTitleView", "()Landroid/widget/TextView;", "mTitleView", "s", "getTitleText", "setTitleText", "titleText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OCTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f7648c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f7649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f7650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f7651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f7652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f7653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f7654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f7655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f7656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OButton f7657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f7660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f7661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TitlePosition f7662t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "", "", EventBody.KEY_VALUE, "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        static {
            TitlePosition r10 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r10;
            TitlePosition r11 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r11;
            TitlePosition r12 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r12;
            $VALUES = new TitlePosition[]{r10, r11, r12};
        }

        private TitlePosition(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static TitlePosition valueOf(String r10) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r10);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OCTitleBar f7663c;

        b(OCTitleBar r10) {
            this.f7663c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OCTitleBar.a(this.f7663c);
        }
    }

    static {
        new a(null);
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
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.f7658p = MathKt.roundToInt(TypedValue.applyDimension(1, 70, r13.getDisplayMetrics()));
        this.f7659q = true;
        this.f7662t = TitlePosition.FIXED_CENTER;
        b(r10);
        if (r11 == null) goto L6;
        c(r11);
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

    public static final /* synthetic */ void a(OCTitleBar r10) {
        r10.d();
    }

    private final void b(Context r10) {
        FrameLayout.inflate(r10, h.o_title_bar_container, this);
        View r11 = findViewById(f.center_title);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.center_title)");
        this.f7653k = (TextView) r11;
        View r12 = findViewById(f.left_title);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.left_title)");
        this.f7654l = (TextView) r12;
        View r13 = findViewById(f.ll_left_action_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.ll_left_action_container)");
        this.f7648c = (LinearLayout) r13;
        View r14 = findViewById(f.ll_right_action_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.ll_right_action_container)");
        this.f7649g = (LinearLayout) r14;
        View r15 = findViewById(f.fl_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.fl_center_action_container)");
        this.f7650h = (FrameLayout) r15;
        View r16 = findViewById(f.fl_fixed_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.fl_fix…_center_action_container)");
        this.f7651i = (FrameLayout) r16;
        View r17 = findViewById(f.fixed_center_title);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.fixed_center_title)");
        this.f7655m = (TextView) r17;
        View r18 = findViewById(f.left_action_back);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.left_action_back)");
        this.f7657o = (OButton) r18;
        View r19 = findViewById(f.fixed_center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.fixed_center_sub_title)");
        this.f7656n = (TextView) r19;
        View r20 = findViewById(f.fixed_center_title_container);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.fixed_center_title_container)");
        this.f7652j = (ViewGroup) r20;
    }

    private final void c(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        TypedArray r12 = r11.getTheme().obtainStyledAttributes(r10, l.OCTitleBar, 0, 0);
        int r13 = r12.getInt(l.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r13]);     // Catch: Throwable -> L6
        setTitleText(r12.getString(l.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setShowLeftBack(r12.getBoolean(l.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r12.getString(l.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    private final void d() {
        TitlePosition r10 = this.f7662t;
        if (r10 != TitlePosition.LEFT_IN_ACTION) goto L9;
        TextView r11 = this.f7654l;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L7:
        r11.requestLayout();
        return;
    L9:
        if (r10 != TitlePosition.FIXED_CENTER) goto L22;
        TextView r12 = this.f7655m;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L13:
        r12.requestLayout();
        TextView r13 = this.f7656n;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r13.requestLayout();
        FrameLayout r14 = this.f7651i;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L19:
        r14.requestLayout();
        return;
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r10 = this.f7652j;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fixedCenterTitleContainer");
    L5:
        return r10;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r10 = this.f7650h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
    L5:
        return r10;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r10 = this.f7651i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L5:
        return r10;
    }

    public final OButton getMLeftActionBack() {
        OButton r10 = this.f7657o;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L5:
        return r10;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r10 = this.f7648c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L5:
        return r10;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r10 = this.f7649g;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        return r10;
    }

    public final TitlePosition getMTitlePosition() {
        return this.f7662t;
    }

    public final TextView getMTitleView() {
        TitlePosition r10 = this.f7662t;
        int r11 = com.obric.oui.titlebar.a.f7723a[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f7655m;
        if (r12 != null) goto L20;
        String r13 = "mFixedCenterTitleView";
    L11:
        Intrinsics.throwUninitializedPropertyAccessException(r13);
    L20:
        return r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = this.f7653k;
        if (r12 != null) goto L20;
        r13 = "mCenterTitleView";
        goto L11
    L7:
        if (r11 != 3) goto L13;
        r12 = this.f7654l;
        if (r12 != null) goto L20;
        r13 = "mLeftTitleView";
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f7659q;
    }

    public final String getSubTitleText() {
        return this.f7660r;
    }

    public final String getTitleText() {
        return this.f7661s;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        TitlePosition r12 = this.f7662t;
        ViewGroup.LayoutParams r13 = null;
        int r14 = 0;
        if (r12 != TitlePosition.LEFT_IN_ACTION) goto L44;
        TextView r15 = this.f7654l;
        if (r15 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L7:
        int r16 = getMeasuredWidth();
        LinearLayout r17 = this.f7649g;
        if (r17 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L10:
        int r18 = r16 - r17.getMeasuredWidth();
        LinearLayout r19 = this.f7648c;
        if (r19 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L13:
        int r20 = r18 - r19.getPaddingLeft();
        LinearLayout r21 = this.f7648c;
        if (r21 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L16:
        int r22 = r20 - r21.getPaddingRight();
        TextView r23 = this.f7654l;
        if (r23 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if ((r24 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r24 = null;
    L22:
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
        if (r25 == null) goto L25;
        int r26 = r25.rightMargin;
    L26:
        int r27 = r22 - r26;
        TextView r28 = this.f7654l;
        if (r28 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L29:
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r13 = r29;
    L33:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r13;
        if (r30 == null) goto L36;
        r14 = r30.rightMargin;
    L36:
        int r31 = r27 - r14;
        TextView r32 = this.f7654l;
        if (r32 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L39:
        int r33 = r31 - r32.getPaddingLeft();
        TextView r34 = this.f7654l;
        if (r34 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L42:
        r15.setMaxWidth(r33 - r34.getPaddingRight());
        return;
    L25:
        r26 = 0;
        goto L26
    L44:
        if (r12 != TitlePosition.FIXED_CENTER) goto L131;
        LinearLayout r35 = this.f7648c;
        if (r35 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L49:
        if (r35.getVisibility() != 0) goto L64;
        LinearLayout r36 = this.f7648c;
        if (r36 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L53:
        int r37 = r36.getMeasuredWidth();
        LinearLayout r38 = this.f7648c;
        if (r38 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L56:
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if ((r39 instanceof ViewGroup.MarginLayoutParams) == true) goto L59;
        r39 = null;
    L59:
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r39;
        if (r40 == null) goto L62;
        int r41 = r40.leftMargin;
    L63:
        int r42 = r37 + r41;
    L65:
        LinearLayout r43 = this.f7649g;
        if (r43 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L69:
        if (r43.getVisibility() != 0) goto L84;
        LinearLayout r44 = this.f7649g;
        if (r44 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L73:
        int r45 = r44.getMeasuredWidth();
        LinearLayout r46 = this.f7649g;
        if (r46 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L76:
        ViewGroup.LayoutParams r47 = r46.getLayoutParams();
        if ((r47 instanceof ViewGroup.MarginLayoutParams) == true) goto L79;
        r47 = null;
    L79:
        ViewGroup.MarginLayoutParams r48 = (ViewGroup.MarginLayoutParams) r47;
        if (r48 == null) goto L82;
        int r49 = r48.rightMargin;
    L83:
        int r50 = r45 + r49;
    L85:
        int r51 = Math.max(r42, r50);
        FrameLayout r52 = this.f7651i;
        if (r52 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L89:
        if (r52.getVisibility() != 0) goto L132;
        FrameLayout r53 = this.f7651i;
        if (r53 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L93:
        ViewGroup.LayoutParams r54 = r53.getLayoutParams();
        if ((r54 instanceof ViewGroup.MarginLayoutParams) == true) goto L96;
        r54 = null;
    L96:
        ViewGroup.MarginLayoutParams r55 = (ViewGroup.MarginLayoutParams) r54;
        if (r55 == null) goto L99;
        int r56 = r55.leftMargin;
    L100:
        FrameLayout r57 = this.f7651i;
        if (r57 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L103:
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        if ((r58 instanceof ViewGroup.MarginLayoutParams) == false) goto L107;
        r13 = r58;
    L107:
        ViewGroup.MarginLayoutParams r59 = (ViewGroup.MarginLayoutParams) r13;
        if (r59 == null) goto L110;
        r14 = r59.rightMargin;
    L110:
        int r60 = Math.max((getMeasuredWidth() - (r51 * 2)) - (r56 + r14), this.f7658p);
        TextView r61 = this.f7655m;
        if (r61 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L113:
        TextView r62 = this.f7655m;
        if (r62 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L116:
        int r63 = r62.getPaddingLeft() + r60;
        TextView r64 = this.f7655m;
        if (r64 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L119:
        r61.setMaxWidth(r63 + r64.getPaddingRight());
        TextView r65 = this.f7656n;
        if (r65 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L122:
        TextView r66 = this.f7656n;
        if (r66 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L125:
        int r67 = r60 + r66.getPaddingLeft();
        TextView r68 = this.f7656n;
        if (r68 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L128:
        r65.setMaxWidth(r67 + r68.getPaddingRight());
        return;
    L99:
        r56 = 0;
        goto L100
    L132:
        return;
    L82:
        r49 = 0;
        goto L83
    L84:
        r50 = 0;
        goto L85
    L62:
        r41 = 0;
        goto L63
    L64:
        r42 = 0;
        goto L65
    }

    public final void setCenterText(int r10) {
        String r11 = getResources().getString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "resources.getString(resId)");
        setTitleText(r11);
    }

    public final void setCenterText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        setTitleText(r10);
    }

    public final void setFixedCenterTitleContainer(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7652j = r10;
    }

    public final void setMCenterContainer(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7650h = r10;
    }

    public final void setMFixedCenterContainer(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7651i = r10;
    }

    public final void setMLeftActionBack(OButton r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7657o = r10;
    }

    public final void setMLeftContainer(LinearLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7648c = r10;
    }

    public final void setMRightContainer(LinearLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7649g = r10;
    }

    public final void setMTitlePosition(TitlePosition r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this.f7662t = r10;
        int r11 = com.obric.oui.titlebar.a.f7724b[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f7655m;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L31:
        r12.setVisibility(0);
        TextView r13 = this.f7653k;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L34:
        r13.setVisibility(8);
        TextView r14 = this.f7654l;
        if (r14 != null) goto L37;
    L36:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L37:
        r14.setVisibility(8);
    L38:
        getMTitleView().setText(this.f7661s);
        return;
    L5:
        if (r11 != 2) goto L7;
        TextView r15 = this.f7655m;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L22:
        r15.setVisibility(8);
        TextView r16 = this.f7653k;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L25:
        r16.setVisibility(0);
        r14 = this.f7654l;
        if (r14 != null) goto L37;
    L7:
        if (r11 != 3) goto L38;
        TextView r17 = this.f7655m;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L12:
        r17.setVisibility(8);
        TextView r18 = this.f7653k;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L15:
        r18.setVisibility(8);
        TextView r19 = this.f7654l;
        if (r19 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L18:
        r19.setVisibility(0);
        setShowLeftBack(false);
        goto L38
    }

    public final void setMinCenterTitleWidth(int r10) {
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        this.f7658p = MathKt.roundToInt(TypedValue.applyDimension(1, r10, r11.getDisplayMetrics()));
        post(new b(this));
    }

    public final void setShowLeftBack(boolean r10) {
        this.f7659q = r10;
        OButton r11 = this.f7657o;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L6:
        if (r10 == false) goto L8;
        int r12 = 0;
    L9:
        r11.setVisibility(r12);
        if (this.f7662t != TitlePosition.LEFT_IN_ACTION) goto L16;
        OButton r13 = this.f7657o;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L14:
        r13.setVisibility(8);
        return;
    L16:
        return;
    L8:
        r12 = 8;
        goto L9
    }

    public final void setSubTitleText(String r10) {
        this.f7660r = r10;
        if (r10 != null) goto L8;
        TextView r11 = this.f7656n;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L7:
        r11.setVisibility(8);
        return;
    L8:
        TextView r12 = this.f7656n;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L11:
        r12.setVisibility(0);
        TextView r13 = this.f7656n;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L14:
        r13.setText(r10);
        Resources r14 = getResources();
        Intrinsics.checkNotNullExpressionValue(r14, "resources");
        if (r14.getConfiguration().fontScale <= 1.0f) goto L23;
        TextView r15 = this.f7655m;
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L19:
        r15.setTextSize(1, 16.0f);
        TextView r16 = this.f7656n;
        if (r16 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L22:
        r16.setTextSize(1, 12.0f);
    L23:
        d();
    }

    public final void setTitleText(String r10) {
        this.f7661s = r10;
        if (r10 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r10);
        d();
    }
}
