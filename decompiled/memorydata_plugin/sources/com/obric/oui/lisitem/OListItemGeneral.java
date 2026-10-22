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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.loc.o;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.c;
import com.obric.oui.common.util.h;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020WH\u0016J\u000e\u0010X\u001a\u0002052\u0006\u0010O\u001a\u00020PJ\b\u0010Y\u001a\u00020NH\u0016J\u001a\u0010Z\u001a\u00020N2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0003J0\u0010[\u001a\u00020N2\u0006\u0010\\\u001a\u0002052\u0006\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020W2\u0006\u0010_\u001a\u00020W2\u0006\u0010`\u001a\u00020WH\u0014J\u0018\u0010a\u001a\u00020N2\u0006\u0010b\u001a\u00020W2\u0006\u0010c\u001a\u00020WH\u0014J(\u0010d\u001a\u00020N2\u0006\u0010e\u001a\u00020W2\u0006\u0010f\u001a\u00020W2\u0006\u0010g\u001a\u00020W2\u0006\u0010h\u001a\u00020WH\u0014J\u000e\u0010i\u001a\u00020N2\u0006\u0010j\u001a\u000205J&\u0010k\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010mJ\u0010\u0010n\u001a\u00020N2\u0006\u0010j\u001a\u000205H\u0016J\u0010\u0010o\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010RJ\u0010\u0010q\u001a\u00020N2\u0006\u0010r\u001a\u000205H\u0016J\u0010\u0010s\u001a\u00020N2\b\u0010t\u001a\u0004\u0018\u00010\bJ\u0010\u0010u\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010RJ\u001a\u0010u\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010R2\b\u0010l\u001a\u0004\u0018\u00010mJ\b\u0010v\u001a\u000205H\u0016J\u0006\u0010w\u001a\u00020NR(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010)\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R&\u00106\u001a\u0002052\u0006\u0010\u0007\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0002052\u0006\u0010\u0007\u001a\u000205@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R$\u0010>\u001a\u0002052\u0006\u0010\u0007\u001a\u000205@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R(\u0010B\u001a\u0004\u0018\u00010A2\b\u0010\u0007\u001a\u0004\u0018\u00010A@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010G\u001a\u0004\u0018\u00010A2\b\u0010\u0007\u001a\u0004\u0018\u00010A@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR(\u0010J\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010\r¨\u0006x"}, d2 = {"Lcom/obric/oui/lisitem/OListItemGeneral;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", EventBody.KEY_VALUE, "Landroid/graphics/drawable/Drawable;", "contentImage", "getContentImage", "()Landroid/graphics/drawable/Drawable;", "setContentImage", "(Landroid/graphics/drawable/Drawable;)V", "mClContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMClContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMClContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mContentElement", "Landroid/widget/FrameLayout;", "getMContentElement", "()Landroid/widget/FrameLayout;", "setMContentElement", "(Landroid/widget/FrameLayout;)V", "", "mContentElementWidth", "getMContentElementWidth", "()F", "setMContentElementWidth", "(F)V", "mIvContent", "Landroid/widget/ImageView;", "getMIvContent", "()Landroid/widget/ImageView;", "setMIvContent", "(Landroid/widget/ImageView;)V", "mLeadingElement", "getMLeadingElement", "setMLeadingElement", "mTrailingElement", "getMTrailingElement", "setMTrailingElement", "mTvSubtitle", "Landroid/widget/TextView;", "getMTvSubtitle", "()Landroid/widget/TextView;", "setMTvSubtitle", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "", "showBackground", "getShowBackground", "()Z", "setShowBackground", "(Z)V", "showDivider", "getShowDivider", "setShowDivider", "showPreDefineBackground", "getShowPreDefineBackground", "setShowPreDefineBackground", "", "subTitleString", "getSubTitleString", "()Ljava/lang/CharSequence;", "setSubTitleString", "(Ljava/lang/CharSequence;)V", "titleString", "getTitleString", "setTitleString", "trailingImage", "getTrailingImage", "setTrailingImage", "addChildToParent", "", "parent", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getContentDefaultOneChildWidth", "", "hasChildVisible", "inflateContent", CommonConsts.APM_INNER_EVENT_COST_INIT, "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", o.g, "oldw", "oldh", "setAlpha", "enabled", "setChildToParent", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setEnabled", "setLeadingView", "view", "setSelected", BuildConfig.FLAVOR, "setTrailingImageView", "drawable", "setTrailingView", "shouldUpdateDividerColorOnPress", "updateState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemGeneral extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f13979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f13980b;
    private Drawable c;
    private Drawable d;
    public FrameLayout e;
    public FrameLayout f;
    public FrameLayout g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public ConstraintLayout k;
    private boolean l;
    private boolean m;
    private boolean n;
    private float o;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 6, 0})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f13981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f13982b;
        final /* synthetic */ OListItemGeneral c;

        public a(View r1, boolean r2, OListItemGeneral r3) {
            this.f13981a = r1;
            this.f13982b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f13982b == false) goto L5;
            OListItemGeneral r0 = this.c;
            r0.updateBottomDivider(r0.getMClContent().getLeft(), 0, h.a((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"), 0.6d), ZeusTransformUtils.getResources(this.c, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_line_2, TypedValues.Custom.S_COLOR, "oui_line_2")));
            return;
        L5:
            OListItemGeneral r10 = this.c;
            r10.updateBottomDivider(r10.getMClContent().getLeft(), 0, 0, ZeusTransformUtils.mapRes(R.color.oui_line_2, TypedValues.Custom.S_COLOR, "oui_line_2"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OListItemGeneral(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OListItemGeneral(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, 0, null, 12, null);
        a(r12, r13);
    }

    public /* synthetic */ OListItemGeneral(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final void a(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        a();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.ll_root, OaidModel.KEY_ID, "ll_root")), ViewGroup.class, "com.obric.memorydata.plugin");
        c r3 = c.f13403a;
        if (r0 != null) goto L6;
    L4:
        r0 = null;
    L7:
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.setChangeAlphaWhenPress(false);
    L11:
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_leading_element, OaidModel.KEY_ID, "fl_leading_element"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.fl_leading_element)");
        setMLeadingElement((FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_trailing_element, OaidModel.KEY_ID, "fl_trailing_element"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.fl_trailing_element)");
        setMTrailingElement((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_content_element, OaidModel.KEY_ID, "fl_content_element"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.fl_content_element)");
        setMContentElement((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_content_img, OaidModel.KEY_ID, "iv_content_img"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.iv_content_img)");
        setMIvContent((ImageView) ZeusTransformUtils.preCheckCast(r10, ImageView.class, "com.obric.memorydata.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.cl_content_container, OaidModel.KEY_ID, "cl_content_container"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.cl_content_container)");
        setMClContent((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_content_title, OaidModel.KEY_ID, "tv_content_title"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.tv_content_title)");
        setMTvTitle((TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.memorydata.plugin"));
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_content_subtitle, OaidModel.KEY_ID, "tv_content_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.tv_content_subtitle)");
        setMTvSubtitle((TextView) ZeusTransformUtils.preCheckCast(r13, TextView.class, "com.obric.memorydata.plugin"));
        TypedArray r14 = r8.obtainStyledAttributes(r9, R.styleable.OListItemGeneral);
        setTitleString((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_title, "styleable", "OListItemGeneral_oui_list_item_title")), CharSequence.class, "com.obric.memorydata.plugin"));
        setSubTitleString((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_subtitle, "styleable", "OListItemGeneral_oui_list_item_subtitle")), CharSequence.class, "com.obric.memorydata.plugin"));
        setTrailingImage(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_image, "styleable", "OListItemGeneral_oui_list_item_trailing_image")));
        setContentImage(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_content_image, "styleable", "OListItemGeneral_oui_list_item_content_image")));
        setShowPreDefineBackground(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_show_background, "styleable", "OListItemGeneral_oui_list_item_show_background"), true));
        setShowDivider(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_show_divider, "styleable", "OListItemGeneral_oui_list_item_show_divider"), false));
        setMContentElementWidth(r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_content_width, "styleable", "OListItemGeneral_oui_list_item_content_width"), 0.0f));
        r14.recycle();
        setRadius((int) ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3_rect, "dimen", "oui_r_l3_rect")));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.common.style.a.class) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void a(OListItemGeneral r0, ViewGroup r1, View r2, ViewGroup.LayoutParams r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.a(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChildToParent");
    }

    public void a() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_general, "layout", "o_listitem_general"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public final void a(View r4, ViewGroup.LayoutParams r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 != null) goto L6;
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 8388629;
        r5 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        a((ViewGroup) ZeusTransformUtils.preCheckCast(getMTrailingElement(), ViewGroup.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public final void a(ViewGroup r2, View r3, ViewGroup.LayoutParams r4) {
        if (r3 == null) goto L17;
        if (r2 == null) goto L7;
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
    L7:
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        if (r4 != null) goto L14;
        if (r2 == null) goto L23;
        r2.addView(r3);
        return;
    L23:
        return;
    L14:
        if (r2 == null) goto L24;
        r2.addView(r3, r4);
        return;
    L24:
        return;
    L17:
        if (r2 == null) goto L25;
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final boolean a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r3 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        int r2 = r1 + 1;
        if (r4.getChildAt(r1).getVisibility() == 0) goto L6;
        r1 = r2;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final void b() {
        if (a((ViewGroup) ZeusTransformUtils.preCheckCast(getMContentElement(), ViewGroup.class, "com.obric.memorydata.plugin")) == false) goto L5;
        View r0 = (View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.memorydata.plugin");
        int r1 = getContentDefaultOneChildWidth();
    L6:
        com.obric.oui.indicator.a.a(r0, r1);
        if (this.o != 0.0f) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        com.obric.oui.indicator.a.a((View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.memorydata.plugin"), (int) this.o);
        return;
    L13:
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = (View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.memorydata.plugin");
        r1 = MathKt.roundToInt(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_empty, "dimen", "oui_listitem_content_width_empty")));
        goto L6
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_middle, "dimen", "oui_listitem_content_width_middle")));
    }

    public final Drawable getContentImage() {
        return this.c;
    }

    public final ConstraintLayout getMClContent() {
        ConstraintLayout r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mClContent");
        return null;
    }

    public final FrameLayout getMContentElement() {
        FrameLayout r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
        return null;
    }

    public final float getMContentElementWidth() {
        return this.o;
    }

    public final ImageView getMIvContent() {
        ImageView r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
        return null;
    }

    public final FrameLayout getMLeadingElement() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
        return null;
    }

    public final FrameLayout getMTrailingElement() {
        FrameLayout r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTrailingElement");
        return null;
    }

    public final TextView getMTvSubtitle() {
        TextView r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
        return null;
    }

    public final TextView getMTvTitle() {
        TextView r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        return null;
    }

    public final boolean getShowBackground() {
        return this.m;
    }

    public final boolean getShowDivider() {
        return this.n;
    }

    public final boolean getShowPreDefineBackground() {
        return this.m;
    }

    public final CharSequence getSubTitleString() {
        return this.f13980b;
    }

    public final CharSequence getTitleString() {
        return this.f13979a;
    }

    public final Drawable getTrailingImage() {
        return this.d;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        setShowDivider(this.n);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    public final void setAlpha(boolean r1) {
        if (r1 == true) goto L4;
        float r2 = 0.3f;
    L5:
        setAlpha(r2);
        return;
    L4:
        r2 = 1.0f;
        goto L5
    }

    public final void setContentImage(Drawable r2) {
        this.c = r2;
        if (r2 == null) goto L5;
        getMIvContent().setImageDrawable(this.c);
        getMIvContent().setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        b();
        return;
    L5:
        getMIvContent().setVisibility(8);
        goto L6
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (r2 == false) goto L5;
        FrameLayout r3 = getMLeadingElement();
        float r0 = 1.0f;
    L6:
        r3.setAlpha(r0);
        getMClContent().setAlpha(r0);
        getMContentElement().setAlpha(r0);
        return;
    L5:
        r3 = getMLeadingElement();
        r0 = 0.3f;
        goto L6
    }

    public final void setLeadingView(View r8) {
        if (r8 == null) goto L5;
        a(this, (ViewGroup) ZeusTransformUtils.preCheckCast(getMLeadingElement(), ViewGroup.class, "com.obric.memorydata.plugin"), r8, null, 4, null);
        return;
    }

    public final void setMClContent(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setMContentElement(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setMContentElementWidth(float r3) {
        this.o = r3;
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        com.obric.oui.indicator.a.a((View) ZeusTransformUtils.preCheckCast(getMContentElement(), View.class, "com.obric.memorydata.plugin"), (int) r3);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setMIvContent(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setMLeadingElement(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setMTrailingElement(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setMTvSubtitle(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setMTvTitle(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        getAlphaHelper().onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void setShowBackground(boolean r1) {
        this.l = r1;
        setShowPreDefineBackground(r1);
    }

    public final void setShowDivider(boolean r4) {
        this.n = r4;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(r0, (Runnable) ZeusTransformUtils.preCheckCast(new a(r0, r4, this), Runnable.class, "com.obric.memorydata.plugin")), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setShowPreDefineBackground(boolean r7) {
        this.m = r7;
        if (getBackground() == null) goto L5;
        return;
    L5:
        if (r7 == false) goto L7;
        Object r8 = ZeusTransformUtils.preCheckCast(new ColorDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_fill_list_item_card"), null)), Drawable.class, "com.obric.memorydata.plugin");
    L8:
        setBackground((Drawable) r8);
        return;
    L7:
        r8 = ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.memorydata.plugin");
        goto L8
    }

    public final void setSubTitleString(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f13980b = r4;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(getMTvSubtitle(), View.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(getMTvSubtitle(), View.class, "com.obric.memorydata.plugin"));
        getMTvSubtitle().setText(this.f13980b);
    }

    public final void setTitleString(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f13979a = r4;
        getMTvTitle().setText(r4);
    }

    public final void setTrailingImage(Drawable r1) {
        this.d = r1;
        setTrailingImageView(r1);
    }

    public final void setTrailingImageView(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setImageDrawable(r5);
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
    }

    public final void setTrailingView(View r5) {
        if (r5 == null) goto L5;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 8388629;
        a((ViewGroup) ZeusTransformUtils.preCheckCast(getMTrailingElement(), ViewGroup.class, "com.obric.memorydata.plugin"), r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }
}
