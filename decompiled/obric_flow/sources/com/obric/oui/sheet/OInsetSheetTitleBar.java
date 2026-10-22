package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0001TB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010&\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u0010;\u001a\u0002032\u0006\u00104\u001a\u0002038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R.\u0010A\u001a\u0004\u0018\u00010\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u0010R.\u0010E\u001a\u0004\u0018\u00010\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010\u0010R.\u0010I\u001a\u0004\u0018\u00010\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010=\u001a\u0004\bG\u0010?\"\u0004\bH\u0010\u0010R*\u0010Q\u001a\u00020J2\u0006\u00104\u001a\u00020J8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bR\u0010\u0013¨\u0006U"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resId", "", "setCenterText", "(I)V", "", Constant.TITLE, "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "b", "getMRightContainer", "setMRightContainer", "mRightContainer", "c", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "d", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "Lcom/obric/oui/button/OButton;", "k", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "", "value", "l", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "m", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "subTitleText", "n", "getTitleText", "setTitleText", "titleText", "o", "getDesText", "setDesText", "desText", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;)V", "mTitlePosition", "getMTitleView", "mTitleView", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInsetSheetTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f14410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f14411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f14412c;
    public FrameLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f14413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f14414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTextView f14415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OButton f14416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f14418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f14419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f14420o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TitlePosition f14421p;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "", "", "value", "I", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitlePosition[] f14422a = null;
        private final int value;

        static {
            TitlePosition r5 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r5;
            TitlePosition r10 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r10;
            TitlePosition r11 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r11;
            f14422a = new TitlePosition[]{r5, r10, r11};
        }

        public TitlePosition(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static TitlePosition valueOf(String r5) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r5);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) f14422a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @JvmOverloads
    public OInsetSheetTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final String getDesText() {
        return this.f14420o;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r5 = this.f14412c;
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
        OButton r5 = this.f14416k;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r5 = this.f14410a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r5 = this.f14411b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TitlePosition getMTitlePosition() {
        return this.f14421p;
    }

    public final TextView getMTitleView() {
        TitlePosition r5 = this.f14421p;
        int r10 = f.f14432a[r5.ordinal()];
        if (r10 != 1) goto L5;
        TextView r11 = this.g;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L22:
        return r11;
    L5:
        if (r10 != 2) goto L7;
        r11 = this.e;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r10 != 3) goto L13;
        r11 = this.f;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f14417l;
    }

    public final String getSubTitleText() {
        return this.f14418m;
    }

    public final String getTitleText() {
        return this.f14419n;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    public final void setCenterText(int r5) {
        setTitleText(getResources().getString(r5));
    }

    public final void setDesText(String r5) {
        this.f14420o = r5;
        FrameLayout r10 = null;
        OTextView r11 = null;
        if (r5 != null) goto L5;
    L15:
        FrameLayout r12 = this.f14414i;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L19:
        r10.setVisibility(8);
        return;
    L18:
        r10 = r12;
        goto L19
    L5:
        if (r5.length() == 0) goto L15;
        FrameLayout r13 = this.f14414i;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r13 = null;
    L10:
        r13.setVisibility(0);
        OTextView r14 = this.f14415j;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L14:
        r11.setText(r5);
        return;
    L13:
        r11 = r14;
        goto L14
    }

    public final void setMCenterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14412c = r5;
    }

    public final void setMFixedCenterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.d = r5;
    }

    public final void setMLeftActionBack(OButton r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14416k = r5;
    }

    public final void setMLeftContainer(LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14410a = r5;
    }

    public final void setMRightContainer(LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14411b = r5;
    }

    public final void setMTitlePosition(TitlePosition r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        this.f14421p = r10;
        int r11 = f.f14432a[r10.ordinal()];
        TextView r12 = null;
        if (r11 != 1) goto L5;
        TextView r13 = this.g;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L34:
        r13.setVisibility(0);
        TextView r14 = this.e;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L37:
        r14.setVisibility(8);
        TextView r15 = this.f;
        if (r15 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r12.setVisibility(8);
    L42:
        getMTitleView().setText(this.f14419n);
        return;
    L40:
        r12 = r15;
        goto L41
    L5:
        if (r11 != 2) goto L7;
        TextView r16 = this.g;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L23:
        r16.setVisibility(8);
        TextView r17 = this.e;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r17 = null;
    L26:
        r17.setVisibility(0);
        TextView r18 = this.f;
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
        TextView r19 = this.g;
        if (r19 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r19 = null;
    L12:
        r19.setVisibility(8);
        TextView r20 = this.e;
        if (r20 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r20 = null;
    L15:
        r20.setVisibility(8);
        TextView r21 = this.f;
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

    public final void setShowLeftBack(boolean r5) {
        this.f14417l = r5;
        OButton r10 = getMLeftActionBack();
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        if (this.f14421p != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r11 = 8;
        goto L6
    }

    public final void setSubTitleText(String r5) {
        this.f14418m = r5;
        TextView r10 = null;
        if (r5 != null) goto L9;
        TextView r11 = this.f14413h;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r10.setVisibility(8);
        return;
    L7:
        r10 = r11;
        goto L8
    L9:
        TextView r12 = this.f14413h;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r12 = null;
    L12:
        r12.setVisibility(0);
        TextView r13 = this.f14413h;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r10.setText(r5);
        return;
    L15:
        r10 = r13;
        goto L16
    }

    public final void setTitleText(String r5) {
        this.f14419n = r5;
        if (r5 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r5);
    }

    @JvmOverloads
    public OInsetSheetTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OInsetSheetTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
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
    public OInsetSheetTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14417l = true;
        TitlePosition r12 = TitlePosition.FIXED_CENTER;
        this.f14421p = r12;
        View.inflate(r5, R$layout.o_sheet_title_bar_container, this);
        this.e = (TextView) findViewById(R$id.center_title);
        this.f = (TextView) findViewById(R$id.left_title);
        setMLeftContainer((LinearLayout) findViewById(R$id.ll_left_action_container));
        setMRightContainer((LinearLayout) findViewById(R$id.ll_right_action_container));
        setMCenterContainer((FrameLayout) findViewById(R$id.fl_center_action_container));
        setMFixedCenterContainer((FrameLayout) findViewById(R$id.fl_fixed_center_action_container));
        this.g = (TextView) findViewById(R$id.fixed_center_title);
        setMLeftActionBack((OButton) findViewById(R$id.left_action_back));
        this.f14413h = (TextView) findViewById(R$id.fixed_center_sub_title);
        this.f14414i = (FrameLayout) findViewById(R$id.sheet_title_bar_des);
        OTextView r13 = (OTextView) findViewById(R$id.sheet_title_bar_des_text);
        this.f14415j = r13;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r13 = null;
    L5:
        r13.setEnableAutoAlignLeft(true);
        if (r10 == null) goto L13;
        TypedArray r14 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCTitleBar, 0, 0);
        int r15 = r14.getInt(R$styleable.OCTitleBar_oui_title_pos, r12.getValue());     // Catch: Throwable -> L10
        setMTitlePosition(TitlePosition.values()[r15]);     // Catch: Throwable -> L10
        setTitleText(r14.getString(R$styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L10
        setDesText(r14.getString(R$styleable.OCTitleBar_oui_title_des_text));     // Catch: Throwable -> L10
        setShowLeftBack(r14.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L10
        setSubTitleText(r14.getString(R$styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L10
        r14.recycle();
        return;
    L10:
        th = move-exception;
        r14.recycle();
        throw th;
    }
}
