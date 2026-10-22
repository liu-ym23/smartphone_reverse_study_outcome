package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ym.m;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b \n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\fR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010+\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u0002048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR.\u0010P\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR.\u0010T\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010K\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR.\u0010Z\u001a\u0004\u0018\u00010\u00122\b\u0010I\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010\u0015R.\u0010^\u001a\u0004\u0018\u00010\u00122\b\u0010I\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010\u0015R*\u0010d\u001a\u00020\b2\u0006\u0010I\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010\fR*\u0010h\u001a\u00020\b2\u0006\u0010I\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010`\u001a\u0004\bf\u0010b\"\u0004\bg\u0010\fR*\u0010p\u001a\u00020i2\u0006\u0010I\u001a\u00020i8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR*\u0010q\u001a\u00020\b2\u0006\u0010I\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010`\u001a\u0004\br\u0010b\"\u0004\bs\u0010\f¨\u0006t"}, d2 = {"Lcom/obric/oui/lisitem/OListItemGeneral;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "enabled", "", "setAlpha", "(Z)V", "Landroid/view/View;", "view", "setLeadingView", "(Landroid/view/View;)V", "setTrailingView", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "getContentDefaultOneChildWidth", "()I", "selected", "setSelected", "setEnabled", "Landroid/widget/FrameLayout;", "h", "Landroid/widget/FrameLayout;", "getMLeadingElement", "()Landroid/widget/FrameLayout;", "setMLeadingElement", "(Landroid/widget/FrameLayout;)V", "mLeadingElement", "i", "getMTrailingElement", "setMTrailingElement", "mTrailingElement", "j", "getMContentElement", "setMContentElement", "mContentElement", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "getMIvContent", "()Landroid/widget/ImageView;", "setMIvContent", "(Landroid/widget/ImageView;)V", "mIvContent", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "m", "getMTvSubtitle", "setMTvSubtitle", "mTvSubtitle", "Landroidx/constraintlayout/widget/ConstraintLayout;", "n", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMClContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMClContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mClContent", "", "value", "o", "Ljava/lang/CharSequence;", "getTitleString", "()Ljava/lang/CharSequence;", "setTitleString", "(Ljava/lang/CharSequence;)V", "titleString", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "getSubTitleString", "setSubTitleString", "subTitleString", "q", "Landroid/graphics/drawable/Drawable;", "getContentImage", "()Landroid/graphics/drawable/Drawable;", "setContentImage", "contentImage", "r", "getTrailingImage", "setTrailingImage", "trailingImage", "s", "Z", "getShowPreDefineBackground", "()Z", "setShowPreDefineBackground", "showPreDefineBackground", "t", "getShowDivider", "setShowDivider", "showDivider", "", "u", "F", "getMContentElementWidth", "()F", "setMContentElementWidth", "(F)V", "mContentElementWidth", "showBackground", "getShowBackground", "setShowBackground", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemGeneral extends OUIFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f13572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f13573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f13574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f13575k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f13576l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f13577m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConstraintLayout f13578n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f13579o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f13580p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f13581q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f13582r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13583t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f13584u;

    @JvmOverloads
    public OListItemGeneral(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public static void o(FrameLayout r5, View r10, ViewGroup.LayoutParams r11) {
        if (r10 == null) goto L16;
        if (r5 == null) goto L6;
        com.lynx.tasm.utils.d.t(r5);
    L6:
        if (r5 == null) goto L9;
        r5.removeAllViews();
    L9:
        if (r11 != null) goto L13;
        if (r5 == null) goto L22;
        r5.addView(r10);
        return;
    L22:
        return;
    L13:
        if (r5 == null) goto L23;
        r5.addView(r10, r11);
        return;
    L23:
        return;
    L16:
        if (r5 == null) goto L24;
        com.lynx.tasm.utils.d.s(r5);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r5);
    }

    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(R$dimen.oui_listitem_content_width_middle));
    }

    public final Drawable getContentImage() {
        return this.f13581q;
    }

    public final ConstraintLayout getMClContent() {
        ConstraintLayout r5 = this.f13578n;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mClContent");
        return null;
    }

    public final FrameLayout getMContentElement() {
        FrameLayout r5 = this.f13574j;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
        return null;
    }

    public final float getMContentElementWidth() {
        return this.f13584u;
    }

    public final ImageView getMIvContent() {
        ImageView r5 = this.f13575k;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
        return null;
    }

    public final FrameLayout getMLeadingElement() {
        FrameLayout r5 = this.f13572h;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
        return null;
    }

    public final FrameLayout getMTrailingElement() {
        FrameLayout r5 = this.f13573i;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTrailingElement");
        return null;
    }

    public final TextView getMTvSubtitle() {
        TextView r5 = this.f13577m;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
        return null;
    }

    public final TextView getMTvTitle() {
        TextView r5 = this.f13576l;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        return null;
    }

    public final boolean getShowBackground() {
        return this.s;
    }

    public final boolean getShowDivider() {
        return this.f13583t;
    }

    public final boolean getShowPreDefineBackground() {
        return this.s;
    }

    public final CharSequence getSubTitleString() {
        return this.f13580p;
    }

    public final CharSequence getTitleString() {
        return this.f13579o;
    }

    public final Drawable getTrailingImage() {
        return this.f13582r;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public final boolean k() {
        return true;
    }

    public void n() {
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_general, this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        setShowDivider(this.f13583t);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
    }

    public final void p() {
        FrameLayout r5 = getMContentElement();
        Intrinsics.checkNotNullParameter(r5, "parent");
        int r10 = r5.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        int r12 = r11 + 1;
        if (r5.getChildAt(r11).getVisibility() == 0) goto L6;
        r11 = r12;
        goto L3
    L6:
        FrameLayout r13 = getMContentElement();
        m.s(getContentDefaultOneChildWidth(), r13);
    L10:
        if (this.f13584u == 0.0f) goto L16;
        FrameLayout r14 = getMContentElement();
        m.s((int) this.f13584u, r14);
        return;
    L16:
        return;
    L8:
        FrameLayout r15 = getMContentElement();
        m.s(MathKt.roundToInt(getResources().getDimension(R$dimen.oui_listitem_content_width_empty)), r15);
        goto L10
    }

    public final void setAlpha(boolean r5) {
        if (r5 == true) goto L4;
        float r10 = 0.3f;
    L5:
        setAlpha(r10);
        return;
    L4:
        r10 = 1.0f;
        goto L5
    }

    public final void setContentImage(Drawable r5) {
        this.f13581q = r5;
        if (r5 == null) goto L5;
        getMIvContent().setImageDrawable(this.f13581q);
        getMIvContent().setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        p();
        return;
    L5:
        getMIvContent().setVisibility(8);
        goto L6
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        if (r5 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    public final void setLeadingView(View r5) {
        if (r5 == null) goto L5;
        o(getMLeadingElement(), r5, null);
        return;
    }

    public final void setMClContent(ConstraintLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13578n = r5;
    }

    public final void setMContentElement(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13574j = r5;
    }

    public final void setMContentElementWidth(float r5) {
        this.f13584u = r5;
        if (r5 == 0.0f) goto L7;
        int r10 = (int) r5;
        m.s(r10, getMContentElement());
        return;
    }

    public final void setMIvContent(ImageView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13575k = r5;
    }

    public final void setMLeadingElement(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13572h = r5;
    }

    public final void setMTrailingElement(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13573i = r5;
    }

    public final void setMTvSubtitle(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13577m = r5;
    }

    public final void setMTvTitle(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13576l = r5;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        getAlphaHelper().h(this, r5);
    }

    public final void setShowBackground(boolean r5) {
        setShowPreDefineBackground(r5);
    }

    public final void setShowDivider(boolean r5) {
        this.f13583t = r5;
        OneShotPreDrawListener.add(this, new com.bytedance.iesgurd.settings.b(this, r5, this));
    }

    public final void setShowPreDefineBackground(boolean r5) {
        this.s = r5;
        if (getBackground() != null) goto L9;
        ColorDrawable r10 = null;
        if (r5 == false) goto L7;
        r10 = new ColorDrawable(getResources().getColor(R$color.oui_fill_list_item_card, null));
    L7:
        setBackground(r10);
        return;
    }

    public final void setSubTitleString(CharSequence r5) {
        this.f13580p = r5;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        com.lynx.tasm.utils.d.s(getMTvSubtitle());
        return;
    L5:
        com.lynx.tasm.utils.d.t(getMTvSubtitle());
        getMTvSubtitle().setText(this.f13580p);
    }

    public final void setTitleString(CharSequence r5) {
        this.f13579o = r5;
        getMTvTitle().setText(r5);
    }

    public final void setTrailingImage(Drawable r5) {
        this.f13582r = r5;
        setTrailingImageView(r5);
    }

    public final void setTrailingImageView(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ImageView r10 = new ImageView(getContext());
        r10.setImageDrawable(r5);
        setTrailingView(r10);
    }

    public final void setTrailingView(View r5) {
        if (r5 == null) goto L5;
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 8388629;
        o(getMTrailingElement(), r5, r10);
        return;
    }

    @JvmOverloads
    public OListItemGeneral(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, 0, 12);
        n();
        ViewParent r11 = (ViewGroup) findViewById(R$id.ll_root);
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        com.obric.oui.common.style.a r12 = (com.obric.oui.common.style.a) r11;
        if (r12 == null) goto L11;
        r12.setChangeAlphaWhenPress(false);
    L11:
        setMLeadingElement((FrameLayout) findViewById(R$id.fl_leading_element));
        setMTrailingElement((FrameLayout) findViewById(R$id.fl_trailing_element));
        setMContentElement((FrameLayout) findViewById(R$id.fl_content_element));
        setMIvContent((ImageView) findViewById(R$id.iv_content_img));
        setMClContent((ConstraintLayout) findViewById(R$id.cl_content_container));
        setMTvTitle((TextView) findViewById(R$id.tv_content_title));
        setMTvSubtitle((TextView) findViewById(R$id.tv_content_subtitle));
        TypedArray r13 = r5.obtainStyledAttributes(r10, R$styleable.OListItemGeneral);
        setTitleString(r13.getString(R$styleable.OListItemGeneral_oui_list_item_title));
        setSubTitleString(r13.getString(R$styleable.OListItemGeneral_oui_list_item_subtitle));
        setTrailingImage(r13.getDrawable(R$styleable.OListItemGeneral_oui_list_item_trailing_image));
        setContentImage(r13.getDrawable(R$styleable.OListItemGeneral_oui_list_item_content_image));
        setShowPreDefineBackground(r13.getBoolean(R$styleable.OListItemGeneral_oui_list_item_show_background, true));
        setShowDivider(r13.getBoolean(R$styleable.OListItemGeneral_oui_list_item_show_divider, false));
        setMContentElementWidth(r13.getDimension(R$styleable.OListItemGeneral_oui_list_item_content_width, 0.0f));
        r13.recycle();
        setRadius((int) getResources().getDimension(R$dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r11 instanceof com.obric.oui.common.style.a) == false) goto L4;
        goto L4
    }
}
