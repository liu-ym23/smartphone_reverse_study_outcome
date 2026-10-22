package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0001ZB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\rR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010(\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010E\u001a\u00020=2\u0006\u0010>\u001a\u00020=8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR.\u0010K\u001a\u0004\u0018\u00010\u000e2\b\u0010>\u001a\u0004\u0018\u00010\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010\u0010R.\u0010O\u001a\u0004\u0018\u00010\u000e2\b\u0010>\u001a\u0004\u0018\u00010\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010G\u001a\u0004\bM\u0010I\"\u0004\bN\u0010\u0010R*\u0010W\u001a\u00020P2\u0006\u0010>\u001a\u00020P8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0011\u0010Y\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bX\u0010\u0013¨\u0006["}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resId", "", "setCenterText", "(I)V", "", Constant.TITLE, "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "minWidth", "setMinCenterTitleWidth", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "b", "getMRightContainer", "setMRightContainer", "mRightContainer", "c", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "d", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "getFixedCenterTitleContainer", "()Landroid/view/ViewGroup;", "setFixedCenterTitleContainer", "(Landroid/view/ViewGroup;)V", "fixedCenterTitleContainer", "Lcom/obric/oui/button/OButton;", "j", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "", "value", "l", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "m", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "subTitleText", "n", "getTitleText", "setTitleText", "titleText", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "o", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;)V", "mTitlePosition", "getMTitleView", "mTitleView", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f14768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f14769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f14770c;
    public FrameLayout d;
    public ViewGroup e;
    public final TextView f;
    public final TextView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f14771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f14772i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OButton f14773j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14774k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14775l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f14776m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f14777n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TitlePosition f14778o;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "", "", "value", "I", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitlePosition[] f14779a = null;
        private final int value;

        static {
            TitlePosition r5 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r5;
            TitlePosition r10 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r10;
            TitlePosition r11 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r11;
            f14779a = new TitlePosition[]{r5, r10, r11};
        }

        public TitlePosition(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static TitlePosition valueOf(String r5) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r5);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) f14779a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @JvmOverloads
    public OCTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static /* synthetic */ void a(OCTitleBar r5) {
        m115setMinCenterTitleWidth$lambda1(r5);
    }

    /* JADX INFO: renamed from: setMinCenterTitleWidth$lambda-1, reason: not valid java name */
    private static final void m115setMinCenterTitleWidth$lambda1(OCTitleBar r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.b();
    }

    public final void b() {
        TitlePosition r5 = this.f14778o;
        TextView r10 = null;
        if (r5 != TitlePosition.LEFT_IN_ACTION) goto L10;
        TextView r11 = this.g;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L8:
        r10.requestLayout();
        return;
    L7:
        r10 = r11;
        goto L8
    L10:
        if (r5 != TitlePosition.FIXED_CENTER) goto L21;
        TextView r12 = this.f14771h;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r12 = null;
    L14:
        r12.requestLayout();
        TextView r13 = this.f14772i;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L18:
        r10.requestLayout();
        getMFixedCenterContainer().requestLayout();
        return;
    L17:
        r10 = r13;
        goto L18
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r5 = this.e;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fixedCenterTitleContainer");
        return null;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r5 = this.f14770c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r5 = this.d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final OButton getMLeftActionBack() {
        OButton r5 = this.f14773j;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r5 = this.f14768a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r5 = this.f14769b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TitlePosition getMTitlePosition() {
        return this.f14778o;
    }

    public final TextView getMTitleView() {
        TitlePosition r5 = this.f14778o;
        int r10 = a.f14839a[r5.ordinal()];
        if (r10 != 1) goto L5;
        TextView r11 = this.f14771h;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L22:
        return r11;
    L5:
        if (r10 != 2) goto L7;
        r11 = this.f;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r10 != 3) goto L13;
        r11 = this.g;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f14775l;
    }

    public final String getSubTitleText() {
        return this.f14776m;
    }

    public final String getTitleText() {
        return this.f14777n;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        TitlePosition r12 = this.f14778o;
        int r5 = 0;
        TextView r13 = null;
        if (r12 != TitlePosition.LEFT_IN_ACTION) goto L35;
        TextView r14 = this.g;
        if (r14 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r14 = null;
    L7:
        int r15 = ((getMeasuredWidth() - getMRightContainer().getMeasuredWidth()) - getMLeftContainer().getPaddingLeft()) - getMLeftContainer().getPaddingRight();
        TextView r16 = this.g;
        if (r16 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r16 = null;
    L10:
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r17 = null;
    L13:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L16;
        int r19 = r18.rightMargin;
    L17:
        int r20 = r15 - r19;
        TextView r21 = this.g;
        if (r21 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r21 = null;
    L20:
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
        r22 = null;
    L23:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        if (r23 == null) goto L26;
        r5 = r23.rightMargin;
    L26:
        int r24 = r20 - r5;
        TextView r25 = this.g;
        if (r25 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r25 = null;
    L29:
        int r26 = r24 - r25.getPaddingLeft();
        TextView r27 = this.g;
        if (r27 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L33:
        r14.setMaxWidth(r26 - r13.getPaddingRight());
        return;
    L32:
        r13 = r27;
        goto L33
    L16:
        r19 = 0;
        goto L17
    L35:
        if (r12 == TitlePosition.FIXED_CENTER) goto L37;
        return;
    L37:
        if (getMLeftContainer().getVisibility() != 0) goto L46;
        int r28 = getMLeftContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r29 = getMLeftContainer().getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r29 = null;
    L41:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
        if (r30 == null) goto L44;
        int r31 = r30.leftMargin;
    L45:
        int r32 = r28 + r31;
    L48:
        if (getMRightContainer().getVisibility() != 0) goto L57;
        int r33 = getMRightContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r34 = getMRightContainer().getLayoutParams();
        if ((r34 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r34 = null;
    L52:
        ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r34;
        if (r35 == null) goto L55;
        int r36 = r35.rightMargin;
    L56:
        int r37 = r33 + r36;
    L58:
        int r38 = Math.max(r32, r37);
        if (getMFixedCenterContainer().getVisibility() != 0) goto L96;
        ViewGroup.LayoutParams r39 = getMFixedCenterContainer().getLayoutParams();
        if ((r39 instanceof ViewGroup.MarginLayoutParams) == true) goto L63;
        r39 = null;
    L63:
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r39;
        if (r40 == null) goto L66;
        int r41 = r40.leftMargin;
    L67:
        ViewGroup.LayoutParams r42 = getMFixedCenterContainer().getLayoutParams();
        if ((r42 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r42 = null;
    L70:
        ViewGroup.MarginLayoutParams r43 = (ViewGroup.MarginLayoutParams) r42;
        if (r43 == null) goto L73;
        r5 = r43.rightMargin;
    L73:
        int r44 = Math.max((getMeasuredWidth() - (r38 * 2)) - (r41 + r5), this.f14774k);
        TextView r45 = this.f14771h;
        if (r45 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r45 = null;
    L76:
        TextView r46 = this.f14771h;
        if (r46 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r46 = null;
    L79:
        int r47 = r46.getPaddingLeft() + r44;
        TextView r48 = this.f14771h;
        if (r48 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r48 = null;
    L82:
        r45.setMaxWidth(r48.getPaddingRight() + r47);
        TextView r49 = this.f14772i;
        if (r49 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r49 = null;
    L85:
        TextView r50 = this.f14772i;
        if (r50 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r50 = null;
    L88:
        int r51 = r50.getPaddingLeft() + r44;
        TextView r52 = this.f14772i;
        if (r52 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L92:
        r49.setMaxWidth(r13.getPaddingRight() + r51);
        return;
    L91:
        r13 = r52;
        goto L92
    L66:
        r41 = 0;
        goto L67
    L96:
        return;
    L55:
        r36 = 0;
        goto L56
    L57:
        r37 = 0;
        goto L58
    L44:
        r31 = 0;
        goto L45
    L46:
        r32 = 0;
        goto L48
    }

    public final void setCenterText(int r5) {
        setTitleText(getResources().getString(r5));
    }

    public final void setFixedCenterTitleContainer(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.e = r5;
    }

    public final void setMCenterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14770c = r5;
    }

    public final void setMFixedCenterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.d = r5;
    }

    public final void setMLeftActionBack(OButton r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14773j = r5;
    }

    public final void setMLeftContainer(LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14768a = r5;
    }

    public final void setMRightContainer(LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14769b = r5;
    }

    public final void setMTitlePosition(TitlePosition r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        this.f14778o = r10;
        int r11 = a.f14839a[r10.ordinal()];
        TextView r12 = null;
        if (r11 != 1) goto L5;
        TextView r13 = this.f14771h;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L34:
        r13.setVisibility(0);
        TextView r14 = this.f;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L37:
        r14.setVisibility(8);
        TextView r15 = this.g;
        if (r15 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r12.setVisibility(8);
    L42:
        getMTitleView().setText(this.f14777n);
        return;
    L40:
        r12 = r15;
        goto L41
    L5:
        if (r11 != 2) goto L7;
        TextView r16 = this.f14771h;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L23:
        r16.setVisibility(8);
        TextView r17 = this.f;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r17 = null;
    L26:
        r17.setVisibility(0);
        TextView r18 = this.g;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L30:
        r12.setVisibility(8);
        goto L42
    L29:
        r12 = r18;
        goto L30
    L7:
        if (r11 != 3) goto L42;
        TextView r19 = this.f14771h;
        if (r19 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r19 = null;
    L12:
        r19.setVisibility(8);
        TextView r20 = this.f;
        if (r20 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r20 = null;
    L15:
        r20.setVisibility(8);
        TextView r21 = this.g;
        if (r21 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r12.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r12 = r21;
        goto L19
    }

    public final void setMinCenterTitleWidth(int r5) {
        this.f14774k = com.lynx.tasm.utils.a.B(r5, this);
        post(new com.obric.oui.lisitem.a(this, 4));
    }

    public final void setShowLeftBack(boolean r5) {
        this.f14775l = r5;
        OButton r10 = getMLeftActionBack();
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        if (this.f14778o != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r11 = 8;
        goto L6
    }

    public final void setSubTitleText(String r5) {
        this.f14776m = r5;
        TextView r10 = null;
        if (r5 != null) goto L9;
        TextView r11 = this.f14772i;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r10.setVisibility(8);
        return;
    L7:
        r10 = r11;
        goto L8
    L9:
        TextView r12 = this.f14772i;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r12 = null;
    L12:
        r12.setVisibility(0);
        TextView r13 = this.f14772i;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r13 = null;
    L15:
        r13.setText(r5);
        if (getResources().getConfiguration().fontScale <= 1.0f) goto L25;
        TextView r14 = this.f14771h;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r14 = null;
    L20:
        r14.setTextSize(1, 16.0f);
        TextView r15 = this.f14772i;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L24:
        r10.setTextSize(1, 12.0f);
        goto L25
    L23:
        r10 = r15;
    L25:
        b();
    }

    public final void setTitleText(String r5) {
        this.f14777n = r5;
        if (r5 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r5);
        b();
    }

    @JvmOverloads
    public OCTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OCTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    public final void setCenterText(String r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.TITLE);
        setTitleText(r5);
    }

    @JvmOverloads
    public OCTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14774k = com.lynx.tasm.utils.a.B(70, this);
        this.f14775l = true;
        TitlePosition r12 = TitlePosition.FIXED_CENTER;
        this.f14778o = r12;
        View.inflate(r5, R$layout.o_title_bar_container, this);
        this.f = (TextView) findViewById(R$id.center_title);
        this.g = (TextView) findViewById(R$id.left_title);
        setMLeftContainer((LinearLayout) findViewById(R$id.ll_left_action_container));
        setMRightContainer((LinearLayout) findViewById(R$id.ll_right_action_container));
        setMCenterContainer((FrameLayout) findViewById(R$id.fl_center_action_container));
        setMFixedCenterContainer((FrameLayout) findViewById(R$id.fl_fixed_center_action_container));
        this.f14771h = (TextView) findViewById(R$id.fixed_center_title);
        setMLeftActionBack((OButton) findViewById(R$id.left_action_back));
        this.f14772i = (TextView) findViewById(R$id.fixed_center_sub_title);
        setFixedCenterTitleContainer((ViewGroup) findViewById(R$id.fixed_center_title_container));
        if (r10 == null) goto L10;
        TypedArray r13 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCTitleBar, 0, 0);
        int r14 = r13.getInt(R$styleable.OCTitleBar_oui_title_pos, r12.getValue());     // Catch: Throwable -> L7
        setMTitlePosition(TitlePosition.values()[r14]);     // Catch: Throwable -> L7
        setTitleText(r13.getString(R$styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L7
        setShowLeftBack(r13.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L7
        setSubTitleText(r13.getString(R$styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L7
        r13.recycle();
        return;
    L7:
        th = move-exception;
        r13.recycle();
        throw th;
    }
}
