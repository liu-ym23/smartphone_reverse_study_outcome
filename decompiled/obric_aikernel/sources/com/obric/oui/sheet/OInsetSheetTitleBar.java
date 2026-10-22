package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002STB'\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\u0002¢\u0006\u0004\bQ\u0010RJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0013\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR.\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010'\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R*\u0010;\u001a\u0002042\u0006\u0010\u0018\u001a\u0002048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R.\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u001a\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR.\u0010C\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\u001a\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010\u001eR\"\u0010K\u001a\u00020D8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006U"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar;", "Landroid/widget/FrameLayout;", "", "resId", "", "setCenterText", "", "title", "Landroid/widget/TextView;", "getTitleView", "h", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "getMTitleView", "()Landroid/widget/TextView;", "mTitleView", "i", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", EventBody.KEY_VALUE, "r", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subTitleText", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "u", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;)V", "mTitlePosition", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "g", "getMRightContainer", "setMRightContainer", "mRightContainer", "", "q", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "s", "getTitleText", "setTitleText", "titleText", "t", "getDesText", "setDesText", "desText", "Lcom/obric/oui/button/OButton;", "p", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OInsetSheetTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f7381c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f7382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f7383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f7384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f7385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f7386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f7387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f7388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private FrameLayout f7389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OTextView f7390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OButton f7391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7392q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f7393r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f7394s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f7395t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TitlePosition f7396u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "", "", EventBody.KEY_VALUE, "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
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
    public OInsetSheetTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OInsetSheetTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OInsetSheetTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7392q = true;
        this.f7396u = TitlePosition.FIXED_CENTER;
        a(r10);
        if (r11 == null) goto L6;
        b(r11);
        return;
    }

    public /* synthetic */ OInsetSheetTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(Context r10) {
        FrameLayout.inflate(r10, h.o_sheet_title_bar_container, this);
        View r11 = findViewById(f.center_title);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.center_title)");
        this.f7385j = (TextView) r11;
        View r12 = findViewById(f.left_title);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.left_title)");
        this.f7386k = (TextView) r12;
        View r13 = findViewById(f.ll_left_action_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.ll_left_action_container)");
        this.f7381c = (LinearLayout) r13;
        View r14 = findViewById(f.ll_right_action_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.ll_right_action_container)");
        this.f7382g = (LinearLayout) r14;
        View r15 = findViewById(f.fl_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.fl_center_action_container)");
        this.f7383h = (FrameLayout) r15;
        View r16 = findViewById(f.fl_fixed_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.fl_fix…_center_action_container)");
        this.f7384i = (FrameLayout) r16;
        View r17 = findViewById(f.fixed_center_title);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.fixed_center_title)");
        this.f7387l = (TextView) r17;
        View r18 = findViewById(f.left_action_back);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.left_action_back)");
        this.f7391p = (OButton) r18;
        View r19 = findViewById(f.fixed_center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.fixed_center_sub_title)");
        this.f7388m = (TextView) r19;
        View r20 = findViewById(f.sheet_title_bar_des);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.sheet_title_bar_des)");
        this.f7389n = (FrameLayout) r20;
        View r21 = findViewById(f.sheet_title_bar_des_text);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r22 = (OTextView) r21;
        this.f7390o = r22;
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
        return this.f7395t;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r10 = this.f7383h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
    L5:
        return r10;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r10 = this.f7384i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L5:
        return r10;
    }

    public final OButton getMLeftActionBack() {
        OButton r10 = this.f7391p;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L5:
        return r10;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r10 = this.f7381c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L5:
        return r10;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r10 = this.f7382g;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        return r10;
    }

    public final TitlePosition getMTitlePosition() {
        return this.f7396u;
    }

    public final TextView getMTitleView() {
        TitlePosition r10 = this.f7396u;
        int r11 = b.f7407a[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f7387l;
        if (r12 != null) goto L20;
        String r13 = "mFixedCenterTitleView";
    L11:
        Intrinsics.throwUninitializedPropertyAccessException(r13);
    L20:
        return r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = this.f7385j;
        if (r12 != null) goto L20;
        r13 = "mCenterTitleView";
        goto L11
    L7:
        if (r11 != 3) goto L13;
        r12 = this.f7386k;
        if (r12 != null) goto L20;
        r13 = "mLeftTitleView";
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f7392q;
    }

    public final String getSubTitleText() {
        return this.f7393r;
    }

    public final String getTitleText() {
        return this.f7394s;
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
        this.f7395t = r10;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L15;
        FrameLayout r12 = this.f7389n;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L14:
        r12.setVisibility(8);
        return;
    L15:
        FrameLayout r13 = this.f7389n;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L18:
        r13.setVisibility(0);
        OTextView r14 = this.f7390o;
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
        this.f7383h = r10;
    }

    public final void setMFixedCenterContainer(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7384i = r10;
    }

    public final void setMLeftActionBack(OButton r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7391p = r10;
    }

    public final void setMLeftContainer(LinearLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7381c = r10;
    }

    public final void setMRightContainer(LinearLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7382g = r10;
    }

    public final void setMTitlePosition(TitlePosition r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this.f7396u = r10;
        int r11 = b.f7408b[r10.ordinal()];
        if (r11 != 1) goto L5;
        TextView r12 = this.f7387l;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L31:
        r12.setVisibility(0);
        TextView r13 = this.f7385j;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L34:
        r13.setVisibility(8);
        TextView r14 = this.f7386k;
        if (r14 != null) goto L37;
    L36:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L37:
        r14.setVisibility(8);
    L38:
        getMTitleView().setText(this.f7394s);
        return;
    L5:
        if (r11 != 2) goto L7;
        TextView r15 = this.f7387l;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L22:
        r15.setVisibility(8);
        TextView r16 = this.f7385j;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L25:
        r16.setVisibility(0);
        r14 = this.f7386k;
        if (r14 != null) goto L37;
    L7:
        if (r11 != 3) goto L38;
        TextView r17 = this.f7387l;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L12:
        r17.setVisibility(8);
        TextView r18 = this.f7385j;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L15:
        r18.setVisibility(8);
        TextView r19 = this.f7386k;
        if (r19 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L18:
        r19.setVisibility(0);
        setShowLeftBack(false);
        goto L38
    }

    public final void setShowLeftBack(boolean r10) {
        this.f7392q = r10;
        OButton r11 = this.f7391p;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L6:
        if (r10 == false) goto L8;
        int r12 = 0;
    L9:
        r11.setVisibility(r12);
        if (this.f7396u != TitlePosition.LEFT_IN_ACTION) goto L16;
        OButton r13 = this.f7391p;
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
        this.f7393r = r10;
        if (r10 != null) goto L8;
        TextView r11 = this.f7388m;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L7:
        r11.setVisibility(8);
        return;
    L8:
        TextView r12 = this.f7388m;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L11:
        r12.setVisibility(0);
        TextView r13 = this.f7388m;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L14:
        r13.setText(r10);
    }

    public final void setTitleText(String r10) {
        this.f7394s = r10;
        if (r10 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r10);
    }
}
