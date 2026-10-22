package com.obric.oui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.h;
import com.obric.oui.material.i;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0014J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010!\u001a\u00020\u0018J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\tH\u0007J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000eH\u0007J\b\u0010,\u001a\u00020\u0018H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\tH\u0016J\u0010\u00100\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\tJ\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/blur/OBlurMaskView;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Lcom/obric/oui/material/MaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultPaddingBottom", "defaultPaddingTop", "fitInsetBottom", "", "fitInsetTop", "isBackdropView", "isInflated", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "materialMask", "Landroid/view/ViewGroup;", "materialSrcType", "applyContentMaterial", "", "apply", "applyMaskMaterial", "getDefaultTargetView", "Landroid/view/View;", "initAttrs", "onFinishInflate", "setBackdropTarget", "view", "setDefaultMaskBackground", "setMaskBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setMaskBlurRadius", "radius", "", "setMaskHeight", "height", "showMask", "show", "updateBackdropConfigOfChildren", "updateBackdropEnableOfChildren", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateLayoutForInsetBottom", "insetBottom", "updateLayoutForInsetTop", "insetTop", "updateMaterialOwnerChildBackdropSrcType", "child", "updateMaterialOwnerChildBackdropTarget", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBlurMaskView extends FrameLayout implements com.obric.oui.material.b, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewGroup f13341b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private final com.obric.oui.material.c j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/blur/OBlurMaskView$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13340a = new a(null);
    }

    public OBlurMaskView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBlurMaskView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBlurMaskView(Context r21, AttributeSet r22, int r23) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r22, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r3, r23);
        this.f = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 24);
        this.g = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 24);
        this.h = true;
        this.i = 2;
        this.j = new com.obric.oui.material.c(null, null, OMaterialHelper.a(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors, "array", "oui_titlebar_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes, "array", "oui_titlebar_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        ZeusTransformUtils.inflate(LayoutInflater.from(r1), ZeusTransformUtils.mapRes(R.layout.o_blur_mask_view, "layout", "o_blur_mask_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.material_mask, OaidModel.KEY_ID, "material_mask"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.material_mask)");
        this.f13341b = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        this.c = true;
        if (r3 == null) goto L6;
        a(r3);
        return;
    }

    public /* synthetic */ OBlurMaskView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private static final WindowInsets a(OBlurMaskView r1, View r2, WindowInsets r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, "insets");
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f14878a;
        com.obric.oui.view.b r5 = com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), r3, true);
        if (r1.d == false) goto L5;
        int r0 = r5.c;
    L6:
        r1.a(r0);
        if (r1.e == false) goto L9;
        int r6 = r5.e;
    L10:
        r1.c(r6);
        return r3;
    L9:
        r6 = r1.g;
        goto L10
    L5:
        r0 = r1.f;
        goto L6
    }

    private final void a() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        View r4 = getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, h.class) == false) goto L8;
        b((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin"));
        a((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin"));
    L15:
        r2 = r3;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L15;
        int r5 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        int r7 = r6 + 1;
        View r8 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r6);
        if (ZeusTransformUtils.instanceOf(r8, h.class) == false) goto L14;
        b((h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.memorydata.plugin"));
        a((h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.memorydata.plugin"));
    L14:
        r6 = r7;
        goto L10
    }

    private final void a(AttributeSet r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int[] r2 = R.styleable.OBlurMaskView;
        Intrinsics.checkNotNullExpressionValue(r2, "OBlurMaskView");
        TypedArray r12 = r0.obtainStyledAttributes(r11, r2, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r12, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetMaterialSrcType, "styleable", "OBlurMaskView_oui_widgetMaterialSrcType")) == false) goto L6;
        this.i = r12.getInt(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetMaterialSrcType, "styleable", "OBlurMaskView_oui_widgetMaterialSrcType"), 2);
    L6:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurType, "styleable", "OBlurMaskView_oui_widgetBlurType")) == false) goto L12;
        int r1 = r12.getInt(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurType, "styleable", "OBlurMaskView_oui_widgetBlurType"), 0);
        com.obric.oui.blur.a r5 = this.j.g();
        if (r5 == null) goto L12;
        r5.a(r1);
    L12:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurColors, "styleable", "OBlurMaskView_oui_widgetBlurColors")) == false) goto L19;
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurBlendModes, "styleable", "OBlurMaskView_oui_widgetBlurBlendModes")) == false) goto L19;
        int r3 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurColors, "styleable", "OBlurMaskView_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors, "array", "oui_titlebar_blur_colors"));
        int r6 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurBlendModes, "styleable", "OBlurMaskView_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes, "array", "oui_titlebar_blur_blend_modes"));
        this.j.a(OMaterialHelper.a(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin"), r3, r6));
        if (this.j.c() != null) goto L19;
        com.obric.oui.c.a.b.e("OBlurMaskView", "init get widget blur colors or modes error");
    L19:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_blurRadius, "styleable", "OBlurMaskView_oBlurMask_blurRadius")) == false) goto L26;
        float r4 = r12.getFloat(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_blurRadius, "styleable", "OBlurMaskView_oBlurMask_blurRadius"), BlurToken.Blur_Progress_Thin);
        com.obric.oui.blur.a r7 = this.j.g();
        if (r7 == null) goto L24;
        r7.a(r4);
    L24:
        setMaskBlurRadius(r4);
    L26:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_maskHeight, "styleable", "OBlurMaskView_oBlurMask_maskHeight")) == false) goto L30;
        int r8 = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_maskHeight, "styleable", "OBlurMaskView_oBlurMask_maskHeight"), 0);
        if (r8 <= 0) goto L30;
        setMaskHeight(r8);
    L30:
        boolean r9 = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_statusBarImmersion, "styleable", "OBlurMaskView_oBlurMask_statusBarImmersion"), false);
        this.d = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetFitInsetTop, "styleable", "OBlurMaskView_oui_widgetFitInsetTop"), r9);
        boolean r13 = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetFitInsetBottom, "styleable", "OBlurMaskView_oui_widgetFitInsetBottom"), false);
        this.e = r13;
        if (this.d == true) goto L33;
        if (r13 == true) goto L33;
    L42:
        r12.recycle();
        return;
    L33:
        com.obric.oui.window.a r14 = com.obric.oui.window.a.f14878a;
        com.obric.oui.view.b r15 = com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), null, true);
        if (this.d == false) goto L36;
        int r16 = r15.c;
    L37:
        a(r16);
        if (this.e == false) goto L40;
        int r17 = r15.e;
    L41:
        c(r17);
        setOnApplyWindowInsetsListener(new $$Lambda$OBlurMaskView$5l8cYtqrzTqo4h0BtEnSC6TQeYA(this));
        goto L42
    L40:
        r17 = this.g;
        goto L41
    L36:
        r16 = this.f;
        goto L37
    }

    private final void a(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.material.b.class) == false) goto L5;
        ((com.obric.oui.material.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.material.b.class, "com.obric.memorydata.plugin")).a(false);
    L5:
        r4.setBackdropTarget(getDefaultTargetView());
    }

    private final void b(h r3) {
        ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin")).b(this.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5 */
    private final View getDefaultTargetView() {
        Object r3 = this;
        if (OMaterialHelper.c() <= 1) goto L6;
        r3 = this.f13341b;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ WindowInsets lambda$5l8cYtqrzTqo4h0BtEnSC6TQeYA(OBlurMaskView r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    public final void a(int r4) {
        View r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r3.setPadding(r3.getPaddingLeft(), r4, r3.getPaddingRight(), r3.getPaddingBottom());
    }

    @Override // com.obric.oui.material.b
    public void a(boolean r4) {
        if (this.i == (-1)) goto L6;
        i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.i);
        return;
    L6:
        i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.h);
    }

    @Override // com.obric.oui.material.h
    public void b(int r3) {
        this.i = r3;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
        a();
    }

    public final void c(int r4) {
        View r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r4);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r3) {
        if (r3 != null) goto L6;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setMaskBackground(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        setBackground(r2);
    }

    public final void setMaskBlurRadius(float r3) {
        com.obric.oui.blur.a r0 = this.j.g();
        if (r0 == null) goto L6;
        r0.a(r3);
    L6:
        OMaterialHelper.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.j);
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "")
    public final void setMaskHeight(int r1) {
    }
}
