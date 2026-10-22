package com.obric.oui.lisitem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIFrameLayout;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.c;
import u8.d;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010m\u001a\u00020l\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010n¢\u0006\u0004\bp\u0010qJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\"\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R.\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010*\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u00103\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001d\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\"\u00107\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010S\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010+\u001a\u0004\bQ\u0010-\"\u0004\bR\u0010/R*\u0010[\u001a\u00020T2\u0006\u0010\u001b\u001a\u00020T8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010_\u001a\u00020@8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\\\u0010B\u001a\u0004\b]\u0010D\"\u0004\b^\u0010FR.\u0010c\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010$\u001a\u0004\ba\u0010&\"\u0004\bb\u0010(R*\u0010g\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010+\u001a\u0004\be\u0010-\"\u0004\bf\u0010/R\"\u0010k\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bh\u0010\u0014\u001a\u0004\bi\u0010\u0016\"\u0004\bj\u0010\u0018¨\u0006r"}, d2 = {"Lcom/obric/oui/lisitem/OListItemGeneral;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "enabled", "", "setAlpha", "Landroid/view/View;", "view", "setLeadingView", "setTrailingView", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "", "getContentDefaultOneChildWidth", "selected", "setSelected", "setEnabled", "Landroid/widget/FrameLayout;", "l", "Landroid/widget/FrameLayout;", "getMLeadingElement", "()Landroid/widget/FrameLayout;", "setMLeadingElement", "(Landroid/widget/FrameLayout;)V", "mLeadingElement", "", EventBody.KEY_VALUE, "t", "Ljava/lang/CharSequence;", "getSubTitleString", "()Ljava/lang/CharSequence;", "setSubTitleString", "(Ljava/lang/CharSequence;)V", "subTitleString", "u", "Landroid/graphics/drawable/Drawable;", "getContentImage", "()Landroid/graphics/drawable/Drawable;", "setContentImage", "(Landroid/graphics/drawable/Drawable;)V", "contentImage", "showBackground", "Z", "getShowBackground", "()Z", "setShowBackground", "(Z)V", "s", "getTitleString", "setTitleString", "titleString", "m", "getMTrailingElement", "setMTrailingElement", "mTrailingElement", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "getMIvContent", "()Landroid/widget/ImageView;", "setMIvContent", "(Landroid/widget/ImageView;)V", "mIvContent", "Landroid/widget/TextView;", "q", "Landroid/widget/TextView;", "getMTvSubtitle", "()Landroid/widget/TextView;", "setMTvSubtitle", "(Landroid/widget/TextView;)V", "mTvSubtitle", "Landroidx/constraintlayout/widget/ConstraintLayout;", "r", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMClContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMClContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mClContent", "w", "getShowPreDefineBackground", "setShowPreDefineBackground", "showPreDefineBackground", "", "y", "F", "getMContentElementWidth", "()F", "setMContentElementWidth", "(F)V", "mContentElementWidth", "p", "getMTvTitle", "setMTvTitle", "mTvTitle", BaseSwitches.V, "getTrailingImage", "setTrailingImage", "trailingImage", "x", "getShowDivider", "setShowDivider", "showDivider", "n", "getMContentElement", "setMContentElement", "mContentElement", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OListItemGeneral extends OUIFrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f6886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f6887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f6888n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f6889o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f6890p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f6891q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ConstraintLayout f6892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f6893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f6894t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Drawable f6895u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f6896v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f6897w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f6898x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f6899y;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6900c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OListItemGeneral f6901g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f6902h;

        public a(View r10, OListItemGeneral r11, boolean r12) {
            this.f6900c = r10;
            this.f6901g = r11;
            this.f6902h = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f6902h == false) goto L5;
            OListItemGeneral r10 = this.f6901g;
            int r11 = r10.getMClContent().getLeft();
            Resources r12 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
            r10.updateBottomDivider(r11, 0, MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, r12.getDisplayMetrics())), this.f6901g.getResources().getColor(c.oui_line_2));
            return;
        L5:
            OListItemGeneral r13 = this.f6901g;
            r13.updateBottomDivider(r13.getMClContent().getLeft(), 0, 0, c.oui_line_2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OListItemGeneral(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OListItemGeneral(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, 0, null, 12, null);
        e(r10, r11);
    }

    public /* synthetic */ OListItemGeneral(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @SuppressLint({"CustomViewStyleable"})
    private final void e(Context r10, AttributeSet r11) {
        d();
        ViewParent r12 = (ViewGroup) findViewById(f.ll_root);
        da.c r13 = da.c.f8520a;
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L7:
        o9.a r14 = (o9.a) r12;
        if (r14 == null) goto L10;
        r14.setChangeAlphaWhenPress(false);
    L10:
        View r15 = findViewById(f.fl_leading_element);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.fl_leading_element)");
        this.f6886l = (FrameLayout) r15;
        View r16 = findViewById(f.fl_trailing_element);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.fl_trailing_element)");
        this.f6887m = (FrameLayout) r16;
        View r17 = findViewById(f.fl_content_element);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.fl_content_element)");
        this.f6888n = (FrameLayout) r17;
        View r18 = findViewById(f.iv_content_img);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.iv_content_img)");
        this.f6889o = (ImageView) r18;
        View r19 = findViewById(f.cl_content_container);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.cl_content_container)");
        this.f6892r = (ConstraintLayout) r19;
        View r20 = findViewById(f.tv_content_title);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.tv_content_title)");
        this.f6890p = (TextView) r20;
        View r21 = findViewById(f.tv_content_subtitle);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.tv_content_subtitle)");
        this.f6891q = (TextView) r21;
        TypedArray r22 = r10.obtainStyledAttributes(r11, l.OListItemGeneral);
        setTitleString(r22.getString(l.OListItemGeneral_oui_list_item_title));
        setSubTitleString(r22.getString(l.OListItemGeneral_oui_list_item_subtitle));
        setTrailingImage(r22.getDrawable(l.OListItemGeneral_oui_list_item_trailing_image));
        setContentImage(r22.getDrawable(l.OListItemGeneral_oui_list_item_content_image));
        setShowPreDefineBackground(r22.getBoolean(l.OListItemGeneral_oui_list_item_show_background, true));
        setShowDivider(r22.getBoolean(l.OListItemGeneral_oui_list_item_show_divider, false));
        setMContentElementWidth(r22.getDimension(l.OListItemGeneral_oui_list_item_content_width, 0.0f));
        r22.recycle();
        setRadius((int) getResources().getDimension(d.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r12 instanceof o9.a) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void g(OListItemGeneral r10, ViewGroup r11, View r12, ViewGroup.LayoutParams r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L6;
        r13 = null;
    L6:
        r10.f(r11, r12, r13);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChildToParent");
    }

    public final boolean c(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        View r13 = r10.getChildAt(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "child");
        if (r13.getVisibility() == 0) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void d() {
        LayoutInflater.from(getContext()).inflate(h.o_listitem_general, this);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r10);
    }

    public final void f(ViewGroup r10, View r11, ViewGroup.LayoutParams r12) {
        if (r11 == null) goto L12;
        if (r10 == null) goto L5;
        k.h(r10);
    L5:
        if (r10 == null) goto L7;
        r10.removeAllViews();
    L7:
        if (r12 != null) goto L10;
        if (r10 == null) goto L15;
        r10.addView(r11);
        return;
    L15:
        return;
    L10:
        if (r10 == null) goto L17;
        r10.addView(r11, r12);
        return;
    L17:
        return;
    L12:
        if (r10 == null) goto L19;
        k.f(r10);
        return;
    }

    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(d.oui_listitem_content_width_middle));
    }

    public final Drawable getContentImage() {
        return this.f6895u;
    }

    public final ConstraintLayout getMClContent() {
        ConstraintLayout r10 = this.f6892r;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mClContent");
    L5:
        return r10;
    }

    public final FrameLayout getMContentElement() {
        FrameLayout r10 = this.f6888n;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
    L5:
        return r10;
    }

    public final float getMContentElementWidth() {
        return this.f6899y;
    }

    public final ImageView getMIvContent() {
        ImageView r10 = this.f6889o;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
    L5:
        return r10;
    }

    public final FrameLayout getMLeadingElement() {
        FrameLayout r10 = this.f6886l;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
    L5:
        return r10;
    }

    public final FrameLayout getMTrailingElement() {
        FrameLayout r10 = this.f6887m;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTrailingElement");
    L5:
        return r10;
    }

    public final TextView getMTvSubtitle() {
        TextView r10 = this.f6891q;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
    L5:
        return r10;
    }

    public final TextView getMTvTitle() {
        TextView r10 = this.f6890p;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
    L5:
        return r10;
    }

    public final boolean getShowBackground() {
        return this.f6897w;
    }

    public final boolean getShowDivider() {
        return this.f6898x;
    }

    public final boolean getShowPreDefineBackground() {
        return this.f6897w;
    }

    public final CharSequence getSubTitleString() {
        return this.f6894t;
    }

    public final CharSequence getTitleString() {
        return this.f6893s;
    }

    public final Drawable getTrailingImage() {
        return this.f6896v;
    }

    public final void h(View r10, ViewGroup.LayoutParams r11) {
        if (r10 == null) goto L11;
        if (r11 != null) goto L6;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
        r12.gravity = 8388629;
        ViewGroup.LayoutParams r13 = r12;
    L6:
        ViewGroup r14 = this.f6887m;
        if (r14 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTrailingElement");
    L9:
        f(r14, r10, r13);
        return;
    }

    public final void i() {
        FrameLayout r10 = this.f6888n;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
    L6:
        if (c(r10) == false) goto L11;
        FrameLayout r11 = this.f6888n;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
    L10:
        int r12 = getContentDefaultOneChildWidth();
    L15:
        com.obric.oui.indicator.a.d(r11, r12);
        if (this.f6899y == 0.0f) goto L22;
        FrameLayout r13 = this.f6888n;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
    L20:
        com.obric.oui.indicator.a.d(r13, (int) this.f6899y);
        return;
    L22:
        return;
    L11:
        r11 = this.f6888n;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
    L14:
        r12 = MathKt.roundToInt(getResources().getDimension(d.oui_listitem_content_width_empty));
        goto L15
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        setShowDivider(this.f6898x);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
    }

    public final void setAlpha(boolean r10) {
        if (r10 == true) goto L4;
        float r11 = 0.3f;
    L5:
        setAlpha(r11);
        return;
    L4:
        r11 = 1.0f;
        goto L5
    }

    public final void setContentImage(Drawable r10) {
        this.f6895u = r10;
        if (r10 == null) goto L14;
        ImageView r11 = this.f6889o;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
    L7:
        r11.setImageDrawable(this.f6895u);
        ImageView r12 = this.f6889o;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
    L10:
        r12.setVisibility(0);
        FrameLayout r13 = this.f6888n;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
    L13:
        r13.setVisibility(0);
    L18:
        i();
        return;
    L14:
        ImageView r14 = this.f6889o;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
    L17:
        r14.setVisibility(8);
        goto L18
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L13;
        FrameLayout r11 = this.f6886l;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
    L7:
        float r12 = 1.0f;
        r11.setAlpha(1.0f);
        ConstraintLayout r13 = this.f6892r;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mClContent");
    L10:
        r13.setAlpha(1.0f);
        FrameLayout r14 = this.f6888n;
        if (r14 == null) goto L21;
    L22:
        r14.setAlpha(r12);
        return;
    L21:
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
        goto L22
    L13:
        FrameLayout r15 = this.f6886l;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
    L16:
        r12 = 0.3f;
        r15.setAlpha(0.3f);
        ConstraintLayout r16 = this.f6892r;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mClContent");
    L19:
        r16.setAlpha(0.3f);
        r14 = this.f6888n;
        if (r14 != null) goto L22;
        goto L21
    }

    public final void setLeadingView(View r10) {
        if (r10 == null) goto L8;
        FrameLayout r11 = this.f6886l;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
    L6:
        g(this, r11, r10, null, 4, null);
        return;
    }

    public final void setMClContent(ConstraintLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6892r = r10;
    }

    public final void setMContentElement(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6888n = r10;
    }

    public final void setMContentElementWidth(float r10) {
        this.f6899y = r10;
        if (r10 == 0.0f) goto L9;
        FrameLayout r11 = this.f6888n;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
    L7:
        com.obric.oui.indicator.a.d(r11, (int) r10);
        return;
    }

    public final void setMIvContent(ImageView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6889o = r10;
    }

    public final void setMLeadingElement(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6886l = r10;
    }

    public final void setMTrailingElement(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6887m = r10;
    }

    public final void setMTvSubtitle(TextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6891q = r10;
    }

    public final void setMTvTitle(TextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6890p = r10;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        getAlphaHelper().onSelectedChanged(this, r10);
    }

    public final void setShowBackground(boolean r10) {
        setShowPreDefineBackground(r10);
    }

    public final void setShowDivider(boolean r10) {
        this.f6898x = r10;
        Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(this, new a(this, this, r10)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setShowPreDefineBackground(boolean r10) {
        this.f6897w = r10;
        if (getBackground() != null) goto L9;
        ColorDrawable r11 = null;
        if (r10 == false) goto L7;
        r11 = new ColorDrawable(getResources().getColor(c.oui_fill_list_item_card, null));
    L7:
        setBackground(r11);
        return;
    }

    public final void setSubTitleString(CharSequence r10) {
        this.f6894t = r10;
        if (TextUtils.isEmpty(r10) == false) goto L8;
        TextView r11 = this.f6891q;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
    L7:
        k.f(r11);
        return;
    L8:
        TextView r12 = this.f6891q;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
    L11:
        k.h(r12);
        TextView r13 = this.f6891q;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
    L14:
        r13.setText(this.f6894t);
    }

    public final void setTitleString(CharSequence r10) {
        this.f6893s = r10;
        TextView r11 = this.f6890p;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
    L5:
        r11.setText(r10);
    }

    public final void setTrailingImage(Drawable r10) {
        this.f6896v = r10;
        setTrailingImageView(r10);
    }

    public final void setTrailingImageView(Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ImageView r11 = new ImageView(getContext());
        r11.setImageDrawable(r10);
        Unit r12 = Unit.INSTANCE;
        setTrailingView(r11);
    }

    public final void setTrailingView(View r10) {
        if (r10 == null) goto L8;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 8388629;
        ViewGroup r12 = this.f6887m;
        if (r12 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTrailingElement");
    L6:
        f(r12, r10, r11);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, o9.b
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }
}
