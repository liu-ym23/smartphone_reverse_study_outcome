package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ies.xelement.input.n;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OBaseTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b$\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0010\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0010\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u000eR$\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u000eR$\u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u000eR*\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010/\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R.\u0010F\u001a\u0004\u0018\u00010\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010\u0014R$\u0010J\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010:\u001a\u0004\bH\u0010<\"\u0004\bI\u0010>R.\u0010N\u001a\u0004\u0018\u00010\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010B\u001a\u0004\bL\u0010D\"\u0004\bM\u0010\u0014R\u0011\u0010Q\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0014\u0010U\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010<R\u0014\u0010W\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010<R\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n0$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010(R\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010(¨\u0006\\"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "view", "", "setCenterView", "(Landroid/view/View;)V", "resId", "setCenterText", "(I)V", "", Constant.TITLE, "(Ljava/lang/String;)V", "setCenterSubText", "b", "Landroid/view/View;", "getMCenterView", "()Landroid/view/View;", "setMCenterView", "mCenterView", "c", "getMLeftLastView", "setMLeftLastView", "mLeftLastView", "d", "getMRightLastView", "setMRightLastView", "mRightLastView", "", "e", "Ljava/util/List;", "getMLeftViewList", "()Ljava/util/List;", "setMLeftViewList", "(Ljava/util/List;)V", "mLeftViewList", "f", "getMRightViewList", "setMRightViewList", "mRightViewList", "Lcom/obric/oui/button/OButton;", "g", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "value", "i", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "titleText", "j", "getMSubTitleView", "setMSubTitleView", "mSubTitleView", "k", "getSubTitleText", "setSubTitleText", "subTitleText", "getLeftViewCount", "()I", "leftViewCount", "getRightViewCount", "rightViewCount", "getSubtitleViewOrCreate", "subtitleViewOrCreate", "getTitleViewOrCreate", "titleViewOrCreate", "getRightViewListOrCreate", "rightViewListOrCreate", "getLeftViewListOrCreate", "leftViewListOrCreate", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCTitleBar extends RelativeLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f14866m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f14867n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f14868o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f14870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f14871c;
    public View d;
    public List e;
    public List f;
    public OButton g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f14872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f14873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f14874j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f14875k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final n f14876l;

    static {
        f14866m = R$drawable.o_ic_titlebar_back;
        f14867n = R$color.oui_text_1;
        f14868o = R$color.oui_text_3b;
    }

    @JvmOverloads
    public OCTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static int b(List r5) {
        int r10 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.size() <= 0) goto L18;
        int r11 = r5.size();
        int r12 = 0;
    L7:
        if (r10 >= r11) goto L13;
        int r13 = r10 + 1;
        if (((View) r5.get(r10)).getVisibility() == 8) goto L11;
        r12 = r12 + 1;
    L11:
        r10 = r13;
        goto L7
    L13:
        return r12;
    L18:
        return 0;
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.e != null) goto L5;
        this.e = new ArrayList();
    L5:
        List<View> r5 = this.e;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.f != null) goto L5;
        this.f = new ArrayList();
    L5:
        List<View> r5 = this.f;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r5 = this.f14874j;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        return r5;
    L6:
        OBaseTextView r10 = new OBaseTextView(getContext(), null, 6, 0);
        r10.setMaxLines(1);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        r10.setTextAppearance(R$style.Label_M);
        r10.setTextColor(r10.getContext().getResources().getColor(f14868o));
        this.f14874j = r10;
        ViewGroup.LayoutParams r11 = generateDefaultLayoutParams();
        if (r11 == null) goto L11;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.addRule(14);
        r12.topMargin = a.B(30, this);
        addView(this.f14874j, r12);
        TextView r13 = this.f14874j;
        Intrinsics.checkNotNull(r13);
        return r13;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final TextView getTitleViewOrCreate() {
        View r5 = this.f14870b;
        if (r5 == null) goto L8;
        TextView r10 = this.f14872h;
        if (r5 != r10) goto L8;
        Intrinsics.checkNotNull(r10);
        return r10;
    L8:
        if (this.f14872h != null) goto L10;
        OBaseTextView r11 = new OBaseTextView(getContext(), null, 6, 0);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setTextAppearance(R$style.Title_Title_M_Thick);
        r11.setTextColor(r11.getContext().getResources().getColor(f14867n));
        this.f14872h = r11;
    L10:
        View r12 = this.f14870b;
        if (r12 == null) goto L14;
        if (r12 == null) goto L14;
        removeView(r12);
        this.f14870b = null;
    L14:
        View r13 = this.f14872h;
        ViewGroup.LayoutParams r14 = generateDefaultLayoutParams();
        if (r14 == null) goto L19;
        RelativeLayout.LayoutParams r15 = (RelativeLayout.LayoutParams) r14;
        r15.addRule(13);
        addView(r13, r15);
        TextView r16 = this.f14872h;
        this.f14870b = r16;
        Intrinsics.checkNotNull(r16);
        return r16;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final void setCenterSubText(String r5) {
        getSubtitleViewOrCreate().setText(r5);
        TextView r10 = this.f14872h;
        if (r10 != null) goto L6;
        return;
    L6:
        if (getMSubTitleView() == null) goto L21;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L20;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.removeRule(13);
        r12.addRule(14);
        r12.topMargin = a.B(9, this);
        if (getContext().getResources().getConfiguration().fontScale <= 1.0f) goto L22;
        r12.topMargin = a.B(6, this);
        TextView r13 = getMSubTitleView();
        if (r13 == null) goto L25;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L18;
        int r15 = a.B(31, this);
        ((RelativeLayout.LayoutParams) r14).topMargin = r15;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L25:
        return;
    L22:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final RelativeLayout.LayoutParams a(View r5, boolean r10) {
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if ((r11 instanceof RelativeLayout.LayoutParams) == false) goto L6;
        return (RelativeLayout.LayoutParams) r11;
    L6:
        if (r10 == false) goto L12;
        ViewGroup.LayoutParams r12 = generateDefaultLayoutParams();
        if (r12 == null) goto L11;
        RelativeLayout.LayoutParams r13 = (RelativeLayout.LayoutParams) r12;
        r13.addRule(13);
        Object r14 = r13;
    L13:
        if (r14 == null) goto L17;
        return (RelativeLayout.LayoutParams) r14;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L12:
        r14 = generateDefaultLayoutParams();
        goto L13
    }

    public final int getLeftViewCount() {
        return b(this.e);
    }

    public final View getMCenterView() {
        return this.f14870b;
    }

    public final OButton getMLeftActionBack() {
        return this.g;
    }

    public final View getMLeftLastView() {
        return this.f14871c;
    }

    public final List<View> getMLeftViewList() {
        return this.e;
    }

    public final View getMRightLastView() {
        return this.d;
    }

    public final List<View> getMRightViewList() {
        return this.f;
    }

    public final TextView getMSubTitleView() {
        return this.f14874j;
    }

    public final TextView getMTitleView() {
        return this.f14872h;
    }

    public final int getRightViewCount() {
        return b(this.f);
    }

    public final String getSubTitleText() {
        return this.f14875k;
    }

    public final String getTitleText() {
        return this.f14873i;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec((int) getContext().getResources().getDimension(R$dimen.oui_h_title_bar_window), BasicMeasure.EXACTLY));
    }

    public final void setCenterText(int r5) {
        setCenterText(getContext().getString(r5));
    }

    public final void setCenterView(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        RelativeLayout.LayoutParams r10 = a(r5, true);
        if (Intrinsics.areEqual(this.f14870b, r5) == true) goto L12;
        View r11 = this.f14870b;
        if (r11 == null) goto L10;
        removeView(r11);
        this.f14870b = null;
    L10:
        this.f14870b = r5;
        addView(r5, r10);
        return;
    }

    public final void setMCenterView(View r5) {
        this.f14870b = r5;
    }

    public final void setMLeftActionBack(OButton r5) {
        this.g = r5;
    }

    public final void setMLeftLastView(View r5) {
        this.f14871c = r5;
    }

    public final void setMLeftViewList(List<View> r5) {
        this.e = r5;
    }

    public final void setMRightLastView(View r5) {
        this.d = r5;
    }

    public final void setMRightViewList(List<View> r5) {
        this.f = r5;
    }

    public final void setMSubTitleView(TextView r5) {
        this.f14874j = r5;
    }

    public final void setMTitleView(TextView r5) {
        this.f14872h = r5;
    }

    public final void setSubTitleText(String r5) {
        this.f14875k = r5;
        setCenterSubText(r5);
    }

    public final void setTitleText(String r5) {
        this.f14873i = r5;
        setCenterText(r5);
    }

    @JvmOverloads
    public OCTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    private final void setCenterText(String r5) {
        getTitleViewOrCreate().setText(r5);
    }

    public /* synthetic */ OCTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OCTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        n r13 = new n(this, 3);
        this.f14876l = r13;
        if (r11 == null) goto L44;
        TypedArray r14 = getContext().getTheme().obtainStyledAttributes(r11, R$styleable.OCTitleBar, 0, 0);
        com.obric.oui.titlebar.OCTitleBar.TitlePosition r15 = com.obric.oui.titlebar.OCTitleBar.TitlePosition.values()[r14.getInt(R$styleable.OCTitleBar_oui_title_pos, com.obric.oui.titlebar.OCTitleBar.TitlePosition.FIXED_CENTER.getValue())];
        String r16 = r14.getString(R$styleable.OCTitleBar_oui_title_text);
        if (r16 == null) goto L8;
        setCenterText(r16);
    L8:
        if (r14.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true) == false) goto L39;
        Context r17 = getContext();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r17, "context");
        int r5 = R$layout.o_widget_titlebar_trans_icon_button;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r17, "context");
        View r18 = LayoutInflater.from(r17).inflate(r5, this, false);
        if (r18 == null) goto L38;
        OButton r19 = (OButton) r18;
        r19.setButtonSourceBitmap(f14866m);
        setMLeftActionBack(r19);
        Intrinsics.checkNotNullParameter(r19, "view");
        RelativeLayout.LayoutParams r20 = a(r19, false);
        int r21 = getLeftViewCount();
        Intrinsics.checkNotNullParameter(r19, "view");
        Intrinsics.checkNotNullParameter(r20, "layoutParams");
        r20.alignWithParent = true;
        r20.leftMargin = 0;
        r19.setId(View.generateViewId());
        if (this.f14871c != null) goto L14;
        r20.addRule(9);
        r21 = 0;
    L31:
        r20.addRule(15);
        List r22 = this.e;
        if (r22 == null) goto L35;
        Intrinsics.checkNotNull(r22);
        if (r21 == r22.size()) goto L35;
    L36:
        getLeftViewListOrCreate().add(r21, r19);
        addView(r19, r20);
    L35:
        this.f14871c = r19;
        goto L36
    L14:
        if (r21 < 0) goto L30;
        List r23 = this.e;
        Intrinsics.checkNotNull(r23);
        if (r21 >= r23.size()) goto L30;
        if (r21 != 0) goto L25;
        r20.addRule(9);
        List r24 = this.e;
        Intrinsics.checkNotNull(r24);
        ViewGroup.LayoutParams r25 = ((View) r24.get(r21)).getLayoutParams();
        if (r25 == null) goto L24;
        RelativeLayout.LayoutParams r26 = (RelativeLayout.LayoutParams) r25;
        r26.removeRule(9);
        r26.addRule(1, r19.getId());
        goto L31
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L25:
        List r27 = this.e;
        Intrinsics.checkNotNull(r27);
        View r28 = (View) r27.get(r21 - 1);
        List r29 = this.e;
        Intrinsics.checkNotNull(r29);
        View r30 = (View) r29.get(r21);
        r20.addRule(1, r28.getId());
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L29;
        ((RelativeLayout.LayoutParams) r31).addRule(1, r19.getId());
        goto L31
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L30:
        List r32 = this.e;
        Intrinsics.checkNotNull(r32);
        r21 = r32.size();
        View r33 = this.f14871c;
        Intrinsics.checkNotNull(r33);
        r20.addRule(1, r33.getId());
        goto L31
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L39:
        String r110 = r14.getString(R$styleable.OCTitleBar_oui_sub_title_text);
        if (r110 == null) goto L42;
        setCenterSubText(r110);
    L42:
        this.f14869a = r14.getBoolean(R$styleable.OCTitleBar_oui_autoAdjustTitleSpace, true);
        int r34 = (int) getContext().getResources().getDimension(R$dimen.oui_p_title_bar_default);
        setPadding(r34, 0, r34, 0);
    L44:
        if (this.f14869a == false) goto L52;
        getViewTreeObserver().addOnGlobalLayoutListener(r13);     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        ps.a.b(e, "OCTitleBar", "addGlobalLayoutListener: ");
        return;
    }
}
