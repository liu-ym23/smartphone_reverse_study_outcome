package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.text.OTextView;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002ghB'\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010d\u001a\u00020\u0002¢\u0006\u0004\be\u0010fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bR.\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010!\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u00101\u001a\u00020*2\u0006\u0010\n\u001a\u00020*8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R.\u00109\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\f\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R\"\u0010@\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010H\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010P\u001a\u00020I8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010T\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bQ\u0010;\u001a\u0004\bR\u0010=\"\u0004\bS\u0010?R\"\u0010X\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bU\u0010$\u001a\u0004\bV\u0010&\"\u0004\bW\u0010(R\u0013\u0010[\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bY\u0010ZR.\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010\f\u001a\u0004\b]\u0010\u000e\"\u0004\b^\u0010\u0010¨\u0006i"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "Landroid/widget/FrameLayout;", "", "resId", "", "setCenterText", "", "title", "Landroid/widget/TextView;", "getTitleView", EventBody.KEY_VALUE, "t", "Ljava/lang/String;", "getDesText", "()Ljava/lang/String;", "setDesText", "(Ljava/lang/String;)V", "desText", "", BaseSwitches.V, "F", "getTouchStartX", "()F", "setTouchStartX", "(F)V", "touchStartX", "", "q", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "Landroid/widget/LinearLayout;", "g", "Landroid/widget/LinearLayout;", "getMRightContainer", "()Landroid/widget/LinearLayout;", "setMRightContainer", "(Landroid/widget/LinearLayout;)V", "mRightContainer", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "u", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;)V", "mTitlePosition", "w", "getTouchStartY", "setTouchStartY", "touchStartY", "s", "getTitleText", "setTitleText", "titleText", "i", "Landroid/widget/FrameLayout;", "getMFixedCenterContainer", "()Landroid/widget/FrameLayout;", "setMFixedCenterContainer", "(Landroid/widget/FrameLayout;)V", "mFixedCenterContainer", "Landroid/view/VelocityTracker;", "x", "Landroid/view/VelocityTracker;", "getVelocityTracker", "()Landroid/view/VelocityTracker;", "setVelocityTracker", "(Landroid/view/VelocityTracker;)V", "velocityTracker", "Lcom/obric/oui/button/OIconButtonFloating;", "p", "Lcom/obric/oui/button/OIconButtonFloating;", "getMLeftActionBack", "()Lcom/obric/oui/button/OIconButtonFloating;", "setMLeftActionBack", "(Lcom/obric/oui/button/OIconButtonFloating;)V", "mLeftActionBack", "h", "getMCenterContainer", "setMCenterContainer", "mCenterContainer", "c", "getMLeftContainer", "setMLeftContainer", "mLeftContainer", "getMTitleView", "()Landroid/widget/TextView;", "mTitleView", "r", "getSubTitleText", "setSubTitleText", "subTitleText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OSheetTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f7412c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f7413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f7414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f7415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f7416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f7417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f7418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f7419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private FrameLayout f7420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OTextView f7421o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OIconButtonFloating f7422p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7423q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f7424r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f7425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f7426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TitlePosition f7427u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f7428v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f7429w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private VelocityTracker f7430x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "", "", EventBody.KEY_VALUE, "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
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

    static {
        new a(null);
    }

    @JvmOverloads
    public OSheetTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSheetTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSheetTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7423q = true;
        this.f7427u = TitlePosition.FIXED_CENTER;
        a(r10);
        if (r11 == null) goto L6;
        b(r11);
        return;
    }

    public /* synthetic */ OSheetTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(Context r10) {
        FrameLayout.inflate(r10, h.o_sheet_title_bar_container_v2, this);
        View r11 = findViewById(f.center_title);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.center_title)");
        this.f7416j = (TextView) r11;
        View r12 = findViewById(f.left_title);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.left_title)");
        this.f7417k = (TextView) r12;
        View r13 = findViewById(f.ll_left_action_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.ll_left_action_container)");
        this.f7412c = (LinearLayout) r13;
        View r14 = findViewById(f.ll_right_action_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.ll_right_action_container)");
        this.f7413g = (LinearLayout) r14;
        View r15 = findViewById(f.fl_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.fl_center_action_container)");
        this.f7414h = (FrameLayout) r15;
        View r16 = findViewById(f.fl_fixed_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.fl_fix…_center_action_container)");
        this.f7415i = (FrameLayout) r16;
        View r17 = findViewById(f.fixed_center_title);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.fixed_center_title)");
        this.f7418l = (TextView) r17;
        View r18 = findViewById(f.left_action_back);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.left_action_back)");
        this.f7422p = (OIconButtonFloating) r18;
        View r19 = findViewById(f.fixed_center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.fixed_center_sub_title)");
        this.f7419m = (TextView) r19;
        View r20 = findViewById(f.sheet_title_bar_des);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.sheet_title_bar_des)");
        this.f7420n = (FrameLayout) r20;
        View r21 = findViewById(f.sheet_title_bar_des_text);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r22 = (OTextView) r21;
        this.f7421o = r22;
        if (r22 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L5:
        r22.setEnableAutoAlignLeft(true);
    }

    private final void b(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        TypedArray r12 = r11.getTheme().obtainStyledAttributes(r10, l.OCTitleBar, 0, 0);
        int r13 = r12.getInt(l.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r13]);     // Catch: Throwable -> L6
        setTitleText(r12.getString(l.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setDesText(r12.getString(l.OCTitleBar_oui_title_des_text));     // Catch: Throwable -> L6
        setShowLeftBack(r12.getBoolean(l.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r12.getString(l.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public final String getDesText() {
        return this.f7426t;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r10 = this.f7414h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
    L5:
        return r10;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r10 = this.f7415i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L5:
        return r10;
    }

    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r10 = this.f7422p;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L5:
        return r10;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r10 = this.f7412c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L5:
        return r10;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r10 = this.f7413g;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        return r10;
    }

    public final TitlePosition getMTitlePosition() {
        return this.f7427u;
    }

    public final TextView getMTitleView() {
        TitlePosition r10 = this.f7427u;
        int r11 = b.f7432a[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f7418l;
        if (r12 != null) goto L20;
        String r13 = "mFixedCenterTitleView";
    L11:
        Intrinsics.throwUninitializedPropertyAccessException(r13);
    L20:
        return r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = this.f7416j;
        if (r12 != null) goto L20;
        r13 = "mCenterTitleView";
        goto L11
    L7:
        if (r11 != 3) goto L13;
        r12 = this.f7417k;
        if (r12 != null) goto L20;
        r13 = "mLeftTitleView";
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f7423q;
    }

    public final String getSubTitleText() {
        return this.f7424r;
    }

    public final String getTitleText() {
        return this.f7425s;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final float getTouchStartX() {
        return this.f7428v;
    }

    public final float getTouchStartY() {
        return this.f7429w;
    }

    public final VelocityTracker getVelocityTracker() {
        return this.f7430x;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
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

    public final void setDesText(String r10) {
        this.f7426t = r10;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L15;
        FrameLayout r12 = this.f7420n;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L14:
        r12.setVisibility(8);
        return;
    L15:
        FrameLayout r13 = this.f7420n;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L18:
        r13.setVisibility(0);
        OTextView r14 = this.f7421o;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L21:
        r14.setText(r10);
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L10
    }

    public final void setMCenterContainer(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7414h = r10;
    }

    public final void setMFixedCenterContainer(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7415i = r10;
    }

    public final void setMLeftActionBack(OIconButtonFloating r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7422p = r10;
    }

    public final void setMLeftContainer(LinearLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7412c = r10;
    }

    public final void setMRightContainer(LinearLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7413g = r10;
    }

    public final void setMTitlePosition(TitlePosition r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this.f7427u = r10;
        int r11 = b.f7433b[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f7418l;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L31:
        r12.setVisibility(0);
        TextView r13 = this.f7416j;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L34:
        r13.setVisibility(8);
        TextView r14 = this.f7417k;
        if (r14 != null) goto L37;
    L36:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L37:
        r14.setVisibility(8);
    L38:
        getMTitleView().setText(this.f7425s);
        return;
    L5:
        if (r11 != 2) goto L7;
        TextView r15 = this.f7418l;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L22:
        r15.setVisibility(8);
        TextView r16 = this.f7416j;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L25:
        r16.setVisibility(0);
        r14 = this.f7417k;
        if (r14 != null) goto L37;
    L7:
        if (r11 != 3) goto L38;
        TextView r17 = this.f7418l;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L12:
        r17.setVisibility(8);
        TextView r18 = this.f7416j;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L15:
        r18.setVisibility(8);
        TextView r19 = this.f7417k;
        if (r19 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L18:
        r19.setVisibility(0);
        setShowLeftBack(false);
        goto L38
    }

    public final void setShowLeftBack(boolean r10) {
        this.f7423q = r10;
        OIconButtonFloating r11 = this.f7422p;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L6:
        if (r10 == false) goto L8;
        int r12 = 0;
    L9:
        r11.setVisibility(r12);
        if (this.f7427u != TitlePosition.LEFT_IN_ACTION) goto L16;
        OIconButtonFloating r13 = this.f7422p;
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
        this.f7424r = r10;
        if (r10 != null) goto L8;
        TextView r11 = this.f7419m;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L7:
        r11.setVisibility(8);
        return;
    L8:
        TextView r12 = this.f7419m;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L11:
        r12.setVisibility(0);
        TextView r13 = this.f7419m;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L14:
        r13.setText(r10);
    }

    public final void setTitleText(String r10) {
        this.f7425s = r10;
        if (r10 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r10);
    }

    public final void setTouchStartX(float r10) {
        this.f7428v = r10;
    }

    public final void setTouchStartY(float r10) {
        this.f7429w = r10;
    }

    public final void setVelocityTracker(VelocityTracker r10) {
        this.f7430x = r10;
    }
}
