package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.h;
import com.obric.oui.material.i;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010+\u001a\u0004\u0018\u00010\u0014J\n\u0010,\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010-\u001a\u00020\fH\u0002J\b\u0010.\u001a\u00020(H\u0014J\b\u0010/\u001a\u00020(H\u0014J\b\u00100\u001a\u00020(H\u0002J\u0012\u00101\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u0019H\u0002J\u0014\u00105\u001a\u00020(2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001707J\b\u00108\u001a\u00020(H\u0002J\u001e\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\fJ\u0016\u0010=\u001a\u00020(2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\tJ\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u00020(2\u0006\u0010 \u001a\u00020\fH\u0016J\u000e\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "enableSetBackDropTarget", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IIZ)V", "BOTTOM_ACTION_PADDING_BOTTOM", "getBOTTOM_ACTION_PADDING_BOTTOM", "()I", "BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE", "getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE", "actionGroup", "Landroid/view/ViewGroup;", "backdropTarget", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "backgroundBlurRadius", "", "centerContainer", "Landroid/widget/LinearLayout;", "defaultPaddingBottom", "enableBackDropTarget", "floatingWindowHelper", "Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "isBackdropView", "leftContainer", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "materialSrcType", "rightContainer", "rootView", "applyContentMaterial", "", "apply", "applyMaskMaterial", "getActionGroup", "getDefaultTargetView", "isDarkTheme", "onAttachedToWindow", "onFinishInflate", "resetContainers", "setBackdropTarget", "view", "setBackgroundBlurRadius", "radius", "setButtons", "buttons", "", "setDefaultBackdropTargetForChild", "setMixed", "button", "group", "isButtonLeft", "setSingleGroup", "gravity", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateLayoutForInsetBottom", "insetBottom", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarFloating extends FrameLayout implements com.obric.oui.material.b, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13279b;
    private final int c;
    private ViewGroup d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private ViewGroup h;
    private float i;
    private int j;
    private boolean k;
    private int l;
    private WeakReference<View> m;
    private final boolean n;
    private final com.obric.oui.window.b.a o;
    private final c p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/actionbar/v2/OBottomActionBarFloating$setBackgroundBlurRadius$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r4, Outline r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "outline");
            int r3 = r4.getPaddingBottom() - r4.getPaddingTop();
            r5.setRect(new Rect(0, (r4.getHeight() / 2) - r3, r4.getWidth(), r4.getHeight()));
        }
    }

    static {
        f13278a = new a(null);
    }

    public OBottomActionBarFloating(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, false, 30, null);
    }

    public OBottomActionBarFloating(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, false, 28, null);
    }

    public OBottomActionBarFloating(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r13, 0, false, 24, null);
    }

    public OBottomActionBarFloating(Context r28, AttributeSet r29, int r30, int r31, boolean r32) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r28, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r29, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r3, r30, r31);
        this.f13279b = 24;
        this.c = 40;
        this.k = true;
        this.l = 2;
        this.n = r32;
        com.obric.oui.window.b.a r6 = new com.obric.oui.window.b.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        this.o = r6;
        c r7 = new c(null, null, OMaterialHelper.a(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_colors, "array", "oui_bottom_actionbar_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_blend_modes, "array", "oui_bottom_actionbar_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.p = r7;
        this.i = BlurToken.Blur_Progress_Thin;
        boolean r8 = false;
        setClipChildren(false);
        setClipToPadding(false);
        this.j = getPaddingBottom();
        FrameLayout.inflate(r1, ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_v2_floating, "layout", "o_widget_bottom_action_bar_v2_floating"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_action_bar_root, OaidModel.KEY_ID, "bottom_action_bar_root"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.bottom_action_bar_root)");
        this.d = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_left_container, OaidModel.KEY_ID, "action_bar_left_container"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.action_bar_left_container)");
        this.e = (LinearLayout) ZeusTransformUtils.preCheckCast(r10, LinearLayout.class, "com.obric.memorydata.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_center_container, OaidModel.KEY_ID, "action_bar_center_container"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.action_bar_center_container)");
        this.f = (LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_right_container, OaidModel.KEY_ID, "action_bar_right_container"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.action_bar_right_container)");
        this.g = (LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin");
        int[] r13 = R.styleable.OBottomActionBar;
        Intrinsics.checkNotNullExpressionValue(r13, "OBottomActionBar");
        TypedArray r2 = r1.obtainStyledAttributes(r3, r13, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r2, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.l = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetMaterialSrcType, "styleable", "OBottomActionBar_oui_widgetMaterialSrcType"), 2);
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurColors, "styleable", "OBottomActionBar_oui_widgetBlurColors")) == false) goto L10;
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurBlendModes, "styleable", "OBottomActionBar_oui_widgetBlurBlendModes")) == false) goto L10;
        r7.a(OMaterialHelper.a(ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin"), r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurColors, "styleable", "OBottomActionBar_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_colors, "array", "oui_bottom_actionbar_blur_colors")), r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurBlendModes, "styleable", "OBottomActionBar_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_blend_modes, "array", "oui_bottom_actionbar_blur_blend_modes"))));
        if (r7.c() != null) goto L10;
        com.obric.oui.c.a.b.e("OBottomActionBarFloating", "init get widget blur colors or modes error");
    L10:
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurRadius, "styleable", "OBottomActionBar_oui_widgetBlurRadius")) == false) goto L13;
        this.i = r2.getFloat(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurRadius, "styleable", "OBottomActionBar_oui_widgetBlurRadius"), BlurToken.Blur_Progress_Thin);
    L13:
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_bottomActionBarType, "styleable", "OBottomActionBar_oui_bottomActionBarType")) == false) goto L18;
        boolean r4 = true;
        if (r2.getInt(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_bottomActionBarType, "styleable", "OBottomActionBar_oui_bottomActionBarType"), 0) != 1) goto L17;
        r8 = true;
    L17:
        r6.a(r8);
    L19:
        r6.a(r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetFitInsetBottom, "styleable", "OBottomActionBar_oui_widgetFitInsetBottom"), r4), (Function1) ZeusTransformUtils.preCheckCast(new OBottomActionBarFloating$1$1(this), Function1.class, "com.obric.memorydata.plugin"));
        r2.recycle();
        setBackgroundBlurRadius(this.i);
        b();
        r6.a(81);
        return;
    L18:
        r4 = true;
        goto L19
    }

    public /* synthetic */ OBottomActionBarFloating(Context r4, AttributeSet r5, int r6, int r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        int r0 = 0;
        if ((r9 & 4) == 0) goto L8;
        int r1 = 0;
    L10:
        if ((r9 & 8) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r9 & 16) == 0) goto L16;
        r8 = true;
    L16:
        this(r11, r13, r1, r0, r8);
        return;
    L8:
        r1 = r6;
        goto L10
    }

    private final void a() {
        this.e.removeAllViews();
        this.f.removeAllViews();
        this.g.removeAllViews();
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.h = null;
    }

    private final void b() {
        if (this.n == true) goto L5;
        return;
    L5:
        View r0 = getDefaultTargetView();
        i.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.e, this.f, this.g}, ViewGroup[].class, "com.obric.memorydata.plugin"), r0);
        if (ZeusTransformUtils.instanceOf(this.h, h.class) == false) goto L9;
        ViewGroup r4 = this.h;
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin")).setBackdropTarget(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    private final View getDefaultTargetView() {
        WeakReference<View> r0 = this.m;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        Object r3 = r0.get();
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
    L7:
        this = this;
        if (OMaterialHelper.c() <= 1) goto L6;
        r3 = this.d;
        goto L6
    }

    private final void setBackgroundBlurRadius(float r4) {
        setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new b(), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        int r0 = this.l;
        if (r0 != (-1)) goto L6;
        r0 = 2;
    L6:
        com.obric.oui.blur.a r1 = this.p.g();
        if (r1 == null) goto L11;
        r1.a(r4);
        this.o.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.p, r0);
        return;
    }

    public final void a(int r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (com.obric.oui.window.a.f(r0) == true) goto L7;
        if (r7 <= 0) goto L7;
        int r1 = this.c;
    L8:
        setPaddingRelative(getPaddingLeft(), getPaddingTop(), getPaddingRight(), Math.max(r7, com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r1)));
        return;
    L7:
        r1 = this.f13279b;
        goto L8
    }

    @Override // com.obric.oui.material.b
    public void a(boolean r4) {
        if (this.l == (-1)) goto L6;
        i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.l);
        return;
    L6:
        i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.k);
    }

    @Override // com.obric.oui.material.h
    public void b(int r5) {
        this.l = r5;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r5);
        i.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.e, this.f, this.g}, ViewGroup[].class, "com.obric.memorydata.plugin"), this.l);
        if (ZeusTransformUtils.instanceOf(this.h, h.class) == false) goto L6;
        ViewGroup r4 = this.h;
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin")).b(r5);
        return;
    }

    public final ViewGroup getActionGroup() {
        return this.h;
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM() {
        return this.f13279b;
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o.a();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.l == (-1)) goto L6;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.l);
        i.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.e, this.f, this.g}, ViewGroup[].class, "com.obric.memorydata.plugin"), this.l);
        return;
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r4) {
        if (this.n == true) goto L5;
        return;
    L5:
        this.m = new WeakReference(r4);
        i.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.e, this.f, this.g}, ViewGroup[].class, "com.obric.memorydata.plugin"), r4);
        if (ZeusTransformUtils.instanceOf(this.h, h.class) == false) goto L9;
        ViewGroup r3 = this.h;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin")).setBackdropTarget(r4);
        return;
    }

    public final void setButtons(List<? extends View> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "buttons");
        a();
        if (r8.isEmpty() == false) goto L6;
        return;
    L6:
        if (r8.size() != 1) goto L10;
        this.f.addView((View) ZeusTransformUtils.preCheckCast(r8.get(0), View.class, "com.obric.memorydata.plugin"));
        LinearLayout r0 = this.f;
    L8:
        r0.setVisibility(0);
    L12:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r9.hasNext() == false) goto L23;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r9.next(), View.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, h.class) == false) goto L14;
        if (this.n == false) goto L21;
        ((h) ZeusTransformUtils.preCheckCast(r1, h.class, "com.obric.memorydata.plugin")).setBackdropTarget(getDefaultTargetView());
    L21:
        if (this.l == (-1)) goto L14;
        ((h) ZeusTransformUtils.preCheckCast(r1, h.class, "com.obric.memorydata.plugin")).b(this.l);
        goto L14
    L23:
        return;
    L10:
        if (r8.size() < 2) goto L12;
        this.e.addView((View) ZeusTransformUtils.preCheckCast(r8.get(0), View.class, "com.obric.memorydata.plugin"));
        this.e.setVisibility(0);
        this.g.addView((View) ZeusTransformUtils.preCheckCast(r8.get(1), View.class, "com.obric.memorydata.plugin"));
        r0 = this.g;
        goto L8
    }
}
