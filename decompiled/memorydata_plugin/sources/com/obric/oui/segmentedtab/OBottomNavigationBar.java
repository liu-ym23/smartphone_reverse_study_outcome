package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.b;
import com.obric.oui.material.c;
import com.obric.oui.material.h;
import com.obric.oui.material.i;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\fJ\b\u0010 \u001a\u00020\u0019H\u0014J\b\u0010!\u001a\u00020\u0019H\u0014J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0007J\u0016\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)J\u0012\u0010*\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\t2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0010J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\tH\u0016J\u0010\u00105\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomNavBar", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "floatingWindowHelper", "Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "isBackdropView", "", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "maskView", "Landroid/view/View;", "materialSrcType", "rootView", "Landroid/view/ViewGroup;", "applyContentMaterial", "", "apply", "applyMaskMaterial", "enable", "getDefaultTargetView", "getMaskView", "getNavigationBar", "onAttachedToWindow", "onFinishInflate", "setBackdropTarget", "view", "setDefaultBackdropTargetForChild", "setDefaultMaskBackground", "setDrawable", "index", "drawable", "Landroid/graphics/drawable/Drawable;", "setMaskBackground", "setMaskBlurRadius", "radius", "", "setTitle", "title", "", "showMask", "show", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateLayoutForInsetBottom", "insetBottom", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavigationBar extends OUIFrameLayout implements b, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewGroup f14425b;
    private final OBottomNavActionBar c;
    private final View d;
    private boolean e;
    private int f;
    private final com.obric.oui.window.b.a g;
    private final c h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavigationBar$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14424a = new a(null);
    }

    public OBottomNavigationBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBottomNavigationBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBottomNavigationBar(Context r25, AttributeSet r26, int r27) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r26, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r27, null, 8, null);
        this.e = true;
        this.f = -1;
        com.obric.oui.window.b.a r2 = new com.obric.oui.window.b.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        this.g = r2;
        c r3 = new c(null, null, OMaterialHelper.a(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.array.oui_bottom_navbar_blend_colors, "array", "oui_bottom_navbar_blend_colors")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.h = r3;
        boolean r4 = false;
        setClipToPadding(false);
        setClipChildren(false);
        setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenSelected(false);
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.layout_custom_bottom_navigation, "layout", "layout_custom_bottom_navigation"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_nav_bar_container, OaidModel.KEY_ID, "bottom_nav_bar_container"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.bottom_nav_bar_container)");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
        this.f14425b = r6;
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setChangeAlphaWhenPress(false);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setChangeAlphaWhenDisable(false);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setChangeAlphaWhenSelected(false);
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_nav_bar, OaidModel.KEY_ID, "bottom_nav_bar"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.bottom_nav_bar)");
        OBottomNavActionBar r8 = (OBottomNavActionBar) ZeusTransformUtils.preCheckCast(r7, OBottomNavActionBar.class, "com.obric.memorydata.plugin");
        this.c = r8;
        r8.a(r9, r10);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r8, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setChangeAlphaWhenPress(false);
        r8.setChangeAlphaWhenDisable(false);
        r8.setChangeAlphaWhenSelected(false);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.mask_view, OaidModel.KEY_ID, "mask_view"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.mask_view)");
        this.d = r11;
        int[] r12 = R.styleable.OTabLayout;
        Intrinsics.checkNotNullExpressionValue(r12, "OTabLayout");
        TypedArray r13 = r9.obtainStyledAttributes(r10, r12, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.f = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetMaterialSrcType, "styleable", "OTabLayout_oui_widgetMaterialSrcType"), -1);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurColors, "styleable", "OTabLayout_oui_widgetBlurColors")) == true) goto L5;
    L9:
        float r1 = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurRadius, "styleable", "OTabLayout_oui_widgetBlurRadius"), 0.0f);
        com.obric.oui.blur.a r14 = r3.g();
        if (r14 == null) goto L14;
        r14.a(r1);
    L14:
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_enableDefaultMaskBackground, "styleable", "OTabLayout_enableDefaultMaskBackground"), false) == false) goto L16;
        a();
    L18:
        if (r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_bottomActionBarType, "styleable", "OTabLayout_oui_bottomActionBarType"), 0) != 1) goto L20;
        r4 = true;
    L20:
        r2.a(r4);
        r2.a(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetFitInsetBottom, "styleable", "OTabLayout_oui_widgetFitInsetBottom"), true), (Function1) ZeusTransformUtils.preCheckCast(new OBottomNavigationBar$2$1(this), Function1.class, "com.obric.memorydata.plugin"));
        setMaskBlurRadius(r1);
        r13.recycle();
        b();
        r2.a(81);
        return;
    L16:
        setMaskBackground(r13.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_maskBackground, "styleable", "OTabLayout_maskBackground")));
        goto L18
    L5:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurBlendModes, "styleable", "OTabLayout_oui_widgetBlurBlendModes")) == false) goto L9;
        r3.a(OMaterialHelper.a(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin"), r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurColors, "styleable", "OTabLayout_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_bottom_navbar_blur_colors, "array", "oui_bottom_navbar_blur_colors")), r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurBlendModes, "styleable", "OTabLayout_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_bottom_navbar_blur_blend_modes, "array", "oui_bottom_navbar_blur_blend_modes"))));
        if (r3.c() != null) goto L9;
        com.obric.oui.c.a.b.e("OBottomNavigationBar", "init get widget blur colors or modes error");
        goto L9
    }

    public /* synthetic */ OBottomNavigationBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void b() {
        View r0 = getDefaultTargetView();
        this.c.setBackdropTarget(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5 */
    private final View getDefaultTargetView() {
        Object r3 = this;
        if (OMaterialHelper.c() <= 1) goto L6;
        r3 = this.f14425b;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
    }

    @Deprecated(message = "no use")
    public final void a() {
    }

    public final void a(int r7) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        int r2 = getPaddingRight();
        ViewGroup.LayoutParams r3 = ((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        int r5 = r4.bottomMargin;
    L9:
        setPaddingRelative(r0, r1, r2, RangesKt.coerceAtLeast(0, r7 - r5));
        return;
    L8:
        r5 = 0;
        goto L9
    }

    @Override // com.obric.oui.material.b
    public void a(boolean r3) {
        i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3, this.e);
    }

    @Override // com.obric.oui.material.h
    public void b(int r1) {
        this.f = r1;
        OMaterialHelper.b(this, r1);
        this.c.b(r1);
    }

    public final void b(boolean r1) {
        View r0 = this.d;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public final View getMaskView() {
        return this.d;
    }

    public final OBottomNavActionBar getNavigationBar() {
        return this.c;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g.a();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.f;
        if (r0 == (-1)) goto L6;
        OMaterialHelper.b(this, r0);
        this.c.b(r0);
        return;
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r3) {
        if (r3 != null) goto L6;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        b();
        return;
    L6:
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
        this.c.setBackdropTarget(r3);
    }

    @Deprecated(message = "no use")
    public final void setMaskBackground(Drawable r1) {
    }

    public final void setMaskBlurRadius(float r5) {
        int r0 = this.f;
        if (r0 != (-1)) goto L6;
        r0 = 2;
    L6:
        com.obric.oui.blur.a r1 = this.h.g();
        if (r1 == null) goto L10;
        r1.a(r5);
    L10:
        this.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.h, r0);
        if (r5 != 0.0f) goto L13;
        boolean r6 = true;
    L14:
        b(!r6);
        return;
    L13:
        r6 = false;
        goto L14
    }
}
