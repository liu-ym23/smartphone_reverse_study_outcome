package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.common.style.m;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/d;", "Lcom/obric/oui/material/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "getNavigationBar", "()Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "getMaskView", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setMaskBackground", "(Landroid/graphics/drawable/Drawable;)V", "", "radius", "setMaskBlurRadius", "(F)V", "view", "setBackdropTarget", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavigationBar extends OUIFrameLayout implements com.obric.oui.material.d, com.obric.oui.material.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f14312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OBottomNavActionBar f14313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f14314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f14315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final fn.i f14317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.obric.oui.material.c f14318n;

    @JvmOverloads
    public OBottomNavigationBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final View getDefaultTargetView() {
        Integer r5 = n.f13677a;
        return this;
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.f14316l = r5;
        n.p(r5, this);
        this.f14313i.a(r5);
    }

    @Override // com.obric.oui.material.b
    public final void e() {
        p.m(this, this.f14315k);
    }

    public final View getMaskView() {
        return this.f14314j;
    }

    public final OBottomNavActionBar getNavigationBar() {
        return this.f14313i;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f14317m.c();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r5 = this.f14316l;
        if (r5 == (-1)) goto L6;
        n.p(r5, this);
        this.f14313i.a(r5);
        return;
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        OBottomNavActionBar r10 = this.f14313i;
        if (r5 != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(this, this);
        r10.setBackdropTarget(getDefaultTargetView());
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(r5, this);
        r10.setBackdropTarget(r5);
    }

    @Deprecated(message = "no use")
    public final void setMaskBackground(Drawable r5) {
    }

    public final void setMaskBlurRadius(float r5) {
        int r10 = this.f14316l;
        if (r10 != (-1)) goto L6;
        r10 = 2;
    L6:
        com.obric.oui.material.c r11 = this.f14318n;
        xq.a r12 = r11.g;
        if (r12 == null) goto L10;
        r12.f23207a = r5;
    L10:
        this.f14317m.b(this, r11, r10);
        if (r5 != 0.0f) goto L13;
        int r13 = 4;
    L14:
        this.f14314j.setVisibility(r13);
        return;
    L13:
        r13 = 0;
        goto L14
    }

    @JvmOverloads
    public OBottomNavigationBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBottomNavigationBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @JvmOverloads
    public OBottomNavigationBar(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20, 8);
        this.f14315k = true;
        this.f14316l = -1;
        this.f14317m = new fn.i(this);
        Resources r10 = getResources();
        int r11 = R$array.oui_bottom_navbar_blend_colors;
        Integer r12 = n.f13677a;
        com.obric.oui.color.a r13 = com.obric.oui.color.a.f12397c;
        Intrinsics.checkNotNullParameter(r10, "resources");
        int[] r14 = r10.getIntArray(r11);
        if (r14 != null) goto L5;
    L13:
        com.obric.oui.color.b[] r15 = new com.obric.oui.color.b[0];
    L14:
        ArrayList r16 = new ArrayList(r15.length);
        int r17 = r15.length;
        int r110 = 0;
    L15:
        if (r110 >= r17) goto L17;
        com.obric.oui.color.b r111 = r15[r110];
        r16.add(new com.obric.oui.color.a(r111.f12400a, r111.f12401b));
        r110 = r110 + 1;
        goto L15
    L17:
        Object[] r21 = r16.toArray(new com.obric.oui.color.a[0]);
        if (r21 == null) goto L79;
        com.obric.oui.material.c r22 = new com.obric.oui.material.c(null, null, (com.obric.oui.color.a[]) r21, new xq.a(BlurToken.Blur_Progress_Thin, 2, 6), null, null, 955);
        this.f14318n = r22;
        setClipToPadding(false);
        setClipChildren(false);
        setOutlineProvider(new com.obric.oui.actionbar.v2.a(1));
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenSelected(false);
        LayoutInflater.from(r18).inflate(R$layout.layout_custom_bottom_navigation, this, true);
        ViewGroup r23 = (ViewGroup) findViewById(R$id.bottom_nav_bar_container);
        this.f14312h = r23;
        OUIFrameLayout r24 = (OUIFrameLayout) r23;
        r24.setChangeAlphaWhenPress(false);
        r24.setChangeAlphaWhenDisable(false);
        r24.setChangeAlphaWhenSelected(false);
        OBottomNavActionBar r25 = (OBottomNavActionBar) findViewById(R$id.bottom_nav_bar);
        this.f14313i = r25;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        f r5 = r25.f14302p;
        r5.setCallback(r25);
        TypedArray r26 = r18.obtainStyledAttributes(r19, R$styleable.OTabLayout);
        int r27 = r26.getColor(R$styleable.OTabLayout_indicator_color, r25.getResources().getColor(R$color.oui_fill_element_3));
        if (r5.f == r27) goto L22;
        r5.f = r27;
        r5.f14368a.setColor(r27);
        r5.invalidateSelf();
    L22:
        r5.a(r26.getDimension(R$styleable.OTabLayout_indicator_height, -1.0f));
        float r28 = r26.getDimension(R$styleable.OTabLayout_indicator_corner_radius, -1.0f);
        if (r5.g == r28) goto L26;
        r5.g = r28;
        r5.invalidateSelf();
    L26:
        r25.setIndicatorCornerRadius(r5.g);
        r25.f14303q = r26.getDimensionPixelSize(R$styleable.OTabLayout_indicator_spacing, r25.o(4.0f));
        r5.f14373j = r26.getBoolean(R$styleable.OTabLayout_indicator_anim_enable, false);
        r26.getBoolean(R$styleable.OTabLayout_indicator_bounce_enable, true);
        LinearLayout r29 = r25.f14295i;
        r29.setPadding(r25.getIndicatorSpacing(), 0, r25.getIndicatorSpacing(), 0);
        r25.f14296j.addView(r29);
        r25.f14304r = r26.getColor(R$styleable.OTabLayout_divider_color, r5.f);
        r25.s = r26.getDimension(R$styleable.OTabLayout_divider_width, 0.0f);
        r25.f14305t = r26.getDimension(R$styleable.OTabLayout_divider_padding, 0.0f);
        r25.f14306u = r26.getDimension(R$styleable.OTabLayout_tab_textSize, r25.o(10.0f));
        int r30 = R$styleable.OTabLayout_tab_textSelectColor;
        int r112 = R$color.oui_text_1;
        Context r113 = r25.f14294h;
        r25.f14307v = r26.getColor(r30, r113.getColor(r112));
        r25.f14308w = r26.getColor(R$styleable.OTabLayout_tab_textUnselectColor, r113.getColor(R$color.oui_text_3b));
        r26.getBoolean(R$styleable.OTabLayout_tab_textAllCaps, false);
        r25.f14300n = r26.getBoolean(R$styleable.OTabLayout_tab_space_equal, true);
        float r31 = r26.getDimension(R$styleable.OTabLayout_tab_width, r25.o(-1.0f));
        r25.f14301o = r31;
        int r114 = R$styleable.OTabLayout_tab_padding;
        if (r25.f14300n == false) goto L29;
    L32:
        int r32 = r25.o(0.0f);
    L33:
        r25.f14299m = r26.getDimension(r114, r32);
        r26.getColor(R$styleable.OTabLayout_bar_stroke_color, r26.getColor(R$styleable.OTabLayout_bar_color, 0));
        r26.getDimension(R$styleable.OTabLayout_bar_stroke_width, r25.o(0.0f));
        r26.getBoolean(R$styleable.OTabLayout_vibrate_on_tab_selected, false);
        int r33 = r26.getResourceId(R$styleable.OTabLayout_shadow_normal, 0);
        int r115 = r26.getResourceId(R$styleable.OTabLayout_shadow_pressed, 0);
        if (r33 == 0) goto L36;
        ArrayList r34 = com.obric.oui.common.style.i.o(r33, r18);
        List r35 = CollectionsKt.listOf(new m[]{(m) r34.get(0), (m) r34.get(1)});
        r25.f14309x = r35;
        Intrinsics.checkNotNull(r35);
        m r36 = (m) CollectionsKt.getOrNull(r35, 0);
        List r116 = r25.f14309x;
        Intrinsics.checkNotNull(r116);
        r25.l(r36, (m) CollectionsKt.getOrNull(r116, 1), false);
    L36:
        if (r115 == 0) goto L38;
        ArrayList r37 = com.obric.oui.common.style.i.o(r115, r18);
        r25.f14310y = CollectionsKt.listOf(new m[]{(m) r37.get(0), (m) r37.get(1)});
    L38:
        r25.setShadowCornerRadius(com.lynx.tasm.utils.a.B(99, r25));
        if (r25.D == false) goto L57;
        r25.F = r26.getInt(R$styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        String r117 = r26.getString(R$styleable.OTabLayout_oui_widgetMaterial);
        if (r117 != null) goto L43;
        r117 = r25.getResources().getString(R$string.oui_material_bg_floating);
    L43:
        com.obric.oui.material.c[] r118 = MaterialToken.parseSet(r117, !a.a.v(r25));
        if (r118 == null) goto L46;
        boolean r119 = true;
    L47:
        r25.D = r119;
        r25.E = r119;
        r26.recycle();
        if (r25.E == false) goto L57;
        r25.setEnableShadowWidthRadius(true);
        r25.setRadius(com.lynx.tasm.utils.a.B(99, r25));
        if (r118 == null) goto L57;
        int r38 = r25.F;
        if (r38 != (-1)) goto L56;
        r38 = 2;
    L56:
        a.a.y(r25, r118, false, r38, 10);
        GradientDrawable r39 = new GradientDrawable();
        r39.setShape(0);
        r39.setCornerRadius(com.lynx.tasm.utils.a.E(99, r25));
        r39.setColor(0);
        r25.setBackground(r39);
        r25.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        goto L57
    L46:
        r119 = false;
    L57:
        r25.setChangeAlphaWhenPress(false);
        r25.setChangeAlphaWhenDisable(false);
        r25.setChangeAlphaWhenSelected(false);
        this.f14314j = findViewById(R$id.mask_view);
        TypedArray r40 = r18.obtainStyledAttributes(r19, R$styleable.OTabLayout, 0, 0);
        this.f14316l = r40.getInt(R$styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        if (r40.hasValue(R$styleable.OTabLayout_oui_widgetBlurColors) == true) goto L60;
    L64:
        float r41 = r40.getFloat(R$styleable.OTabLayout_oui_widgetBlurRadius, 0.0f);
        xq.a r42 = r22.g;
        if (r42 == null) goto L69;
        r42.f23207a = r41;
    L69:
        if (r40.getBoolean(R$styleable.OTabLayout_enableDefaultMaskBackground, false) == true) goto L72;
        setMaskBackground(r40.getDrawable(R$styleable.OTabLayout_maskBackground));
    L72:
        int r43 = r40.getInt(R$styleable.OTabLayout_oui_bottomActionBarType, 0);
        fn.i r44 = this.f14317m;
        if (r43 != 1) goto L75;
        boolean r120 = true;
    L76:
        r44.f16958a = r120;
        this.f14317m.d(r40.getBoolean(R$styleable.OTabLayout_oui_widgetFitInsetBottom, true), new OBottomNavigationBar$2$1(this));
        setMaskBlurRadius(r41);
        r40.recycle();
        r25.setBackdropTarget(getDefaultTargetView());
        this.f14317m.f16959b = 81;
        return;
    L75:
        r120 = false;
        goto L76
    L60:
        if (r40.hasValue(R$styleable.OTabLayout_oui_widgetBlurBlendModes) == false) goto L64;
        com.obric.oui.color.a[] r45 = n.c(r40.getResources(), r40.getResourceId(R$styleable.OTabLayout_oui_widgetBlurColors, R$array.oui_bottom_navbar_blur_colors), r40.getResourceId(R$styleable.OTabLayout_oui_widgetBlurBlendModes, R$array.oui_bottom_navbar_blur_blend_modes));
        r22.f13611c = r45;
        if (r45 != null) goto L64;
        ps.a.c("OBottomNavigationBar", "init get widget blur colors or modes error");
        goto L64
    L29:
        if (r31 > 0.0f) goto L32;
        r32 = r25.o(10.0f);
        goto L33
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L5:
        if (r14.length == 0) goto L13;
        if ((r14.length % 2) != 0) goto L13;
        r15 = new com.obric.oui.color.b[r14.length / 2];
        int r121 = 0;
        int r122 = 0;
    L11:
        if (r121 >= (r14.length - 1)) goto L14;
        r15[r122] = new com.obric.oui.color.b(r14[r121], BlendMode.mapToLegacyObricBlend(r14[r121 + 1]));
        r121 = r121 + 2;
        r122 = r122 + 1;
        goto L11
    }
}
