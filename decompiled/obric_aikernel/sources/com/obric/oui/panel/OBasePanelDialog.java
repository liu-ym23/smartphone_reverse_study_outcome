package com.obric.oui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001e\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u0012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u0004¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\b\u0010!\u001a\u0004\u0018\u00010 J\b\u0010\"\u001a\u0004\u0018\u00010 J&\u0010(\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001cR\"\u0010-\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\"\u00106\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010.\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\"\u00109\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010.\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\"\u0010<\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010.\u001a\u0004\b=\u00100\"\u0004\b>\u00102R\"\u0010?\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010.\u001a\u0004\b?\u00100\"\u0004\b@\u00102R\"\u0010A\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010.\u001a\u0004\bB\u00100\"\u0004\bC\u00102R\"\u0010D\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010.\u001a\u0004\bE\u00100\"\u0004\bF\u00102R\"\u0010G\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010.\u001a\u0004\bH\u00100\"\u0004\bI\u00102R$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010Q\u001a\u0004\b\r\u0010R\"\u0004\b\u0016\u0010SR\"\u0010T\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010.\u001a\u0004\bU\u00100\"\u0004\bV\u00102R$\u0010X\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010^\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010.\u001a\u0004\b_\u00100\"\u0004\b`\u00102R$\u0010a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010Q\u001a\u0004\bb\u0010R\"\u0004\bc\u0010SR*\u0010e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010k\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010Q\u001a\u0004\bl\u0010R\"\u0004\bm\u0010SR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0018\u0010u\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010w\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c\u0018\u00010y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R'\u0010\u007f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010xR$\u0010\u0017\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0017\u0010.\u001a\u0005\b\u0086\u0001\u00100\"\u0005\b\u0087\u0001\u00102¨\u0006\u008d\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasePanelDialog;", "Lcom/obric/oui/panel/BottomSheetDialog;", "", "ensureHeaderAndContainer", "", "layoutResId", "Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "wrapWithHeader", "initView", "getPeekHeight", "getExpandedHeight", "compatibleWithPad", "setContentView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", "getBgColor", "expandedHeight", "setExpandedHeight", "removeMinHeight", "hideHeader", "onBackPressed", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getPanelContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getContentContainer", "getHeaderContainer", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "setRadius", TypedValues.Custom.S_COLOR, "setBgColor", "fit", "setFitsSystemWindow", "floatHeader", "Z", "getFloatHeader", "()Z", "setFloatHeader", "(Z)V", "clipTopCorner", "getClipTopCorner", "setClipTopCorner", "fitsSystemWindows", "getFitsSystemWindows", "setFitsSystemWindows", "backgroundDimEnable", "getBackgroundDimEnable", "setBackgroundDimEnable", "useToneBg", "getUseToneBg", "setUseToneBg", "isExpandable", "setExpandable", "adaptNavBarColor", "getAdaptNavBarColor", "setAdaptNavBarColor", "autoSwitchDayNight", "getAutoSwitchDayNight", "setAutoSwitchDayNight", "fixedHeight", "getFixedHeight", "setFixedHeight", "Landroid/view/View$OnClickListener;", "outsideClickListener", "Landroid/view/View$OnClickListener;", "getOutsideClickListener", "()Landroid/view/View$OnClickListener;", "setOutsideClickListener", "(Landroid/view/View$OnClickListener;)V", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "adaptRLSlide", "getAdaptRLSlide", "setAdaptRLSlide", "Lcom/obric/oui/panel/header/b;", "panelHeader", "Lcom/obric/oui/panel/header/b;", "getPanelHeader", "()Lcom/obric/oui/panel/header/b;", "setPanelHeader", "(Lcom/obric/oui/panel/header/b;)V", "disableAutoAdaptHeight", "getDisableAutoAdaptHeight", "setDisableAutoAdaptHeight", "collapsedHeight", "getCollapsedHeight", "setCollapsedHeight", "Lkotlin/Function0;", "onDialogBackPressCallback", "Lkotlin/jvm/functions/Function0;", "getOnDialogBackPressCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDialogBackPressCallback", "(Lkotlin/jvm/functions/Function0;)V", "navBarColor", "getNavBarColor", "setNavBarColor", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "panelContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "headerContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getDispatchTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "maxPanelHeight", "I", "getMaxPanelHeight", "()I", "setMaxPanelHeight", "(I)V", "contentContainer", "getRemoveMinHeight", "setRemoveMinHeight", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OBasePanelDialog extends BottomSheetDialog {
    private boolean adaptNavBarColor;
    private boolean adaptRLSlide;
    private boolean autoSwitchDayNight;
    private boolean backgroundDimEnable;
    private boolean clipTopCorner;
    private Integer collapsedHeight;
    private RadiusLayout contentContainer;
    private boolean disableAutoAdaptHeight;
    private Function1<? super MotionEvent, Boolean> dispatchTouchEvent;
    private Integer expandedHeight;
    private boolean fitsSystemWindows;
    private boolean fixedHeight;
    private boolean floatHeader;
    private RadiusLayout headerContainer;
    private boolean isExpandable;
    private int maxPanelHeight;

    @ColorInt
    private Integer navBarColor;
    private Function0<Boolean> onDialogBackPressCallback;
    private View.OnClickListener outsideClickListener;
    private OBasicPanel.PadCompatConfig padCompatConfig;
    private ConstraintLayout panelContainer;
    private com.obric.oui.panel.header.b panelHeader;
    private boolean removeMinHeight;
    private boolean useToneBg;

    public OBasePanelDialog(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.maxPanelHeight = -1;
        this.backgroundDimEnable = true;
        this.fitsSystemWindows = true;
        this.clipTopCorner = true;
    }

    public /* synthetic */ OBasePanelDialog(Context r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = k.OBasicPanel;
    L5:
        this(r10, r11);
    }

    private final void compatibleWithPad() {
    }

    private final void ensureHeaderAndContainer() {
        if (this.panelContainer != null) goto L5;
    L8:
        RadiusLayout r10 = null;
        ConstraintLayout r11 = (ConstraintLayout) View.inflate(getContext(), h.o_basic_panel, null);
        this.panelContainer = r11;
        if (r11 == null) goto L11;
        RadiusLayout r12 = (RadiusLayout) r11.findViewById(f.header_container);
    L12:
        this.headerContainer = r12;
        ConstraintLayout r13 = this.panelContainer;
        if (r13 == null) goto L15;
        r10 = (RadiusLayout) r13.findViewById(f.content_container);
    L15:
        this.contentContainer = r10;
        return;
    L11:
        r12 = null;
        goto L12
    L5:
        if (this.headerContainer == null) goto L8;
        if (this.contentContainer == null) goto L8;
    }

    private final int getExpandedHeight() {
        Integer r10 = this.expandedHeight;
        if (r10 == null) goto L6;
        Intrinsics.checkNotNull(r10);
        return r10.intValue();
    L6:
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        return (int) (((double) com.obric.oui.common.util.f.d(r11)) * 0.9d);
    }

    private final int getPeekHeight() {
        Integer r10 = this.collapsedHeight;
        if (r10 == null) goto L6;
        Intrinsics.checkNotNull(r10);
        return r10.intValue();
    L6:
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        Resources r12 = r11.getResources();
        if (r12 == null) goto L9;
        Integer r13 = Integer.valueOf(r12.getIdentifier("config_showNavigationBar", "bool", "android"));
    L10:
        boolean r14 = false;
        if (r13 != null) goto L13;
    L20:
        Context r15 = getContext();
        Intrinsics.checkNotNullExpressionValue(r15, "context");
        double r16 = com.obric.oui.common.util.f.d(r15);
        if (r14 == false) goto L25;
        return (int) (r16 * 0.65d);
    L25:
        return (int) (r16 * 0.6d);
    L13:
        if (r13.intValue() <= 0) goto L20;
        Context r17 = getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        Resources r18 = r17.getResources();
        if (r18 == null) goto L17;
        boolean r19 = r18.getBoolean(r13.intValue());
    L18:
        if (r19 == false) goto L20;
        r14 = true;
        goto L20
    L17:
        r19 = false;
        goto L18
    L9:
        r13 = null;
        goto L10
    }

    private final void initView() {
        if (this.panelHeader != null) goto L5;
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        this.panelHeader = new com.obric.oui.panel.header.a(r10, null, null, 6, null);
    L5:
        compatibleWithPad();
        if (this.clipTopCorner == false) goto L8;
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        float r12 = TypedValue.applyDimension(1, 20, r11.getDisplayMetrics());
    L9:
        RadiusLayout r13 = this.headerContainer;
        if (r13 == null) goto L13;
        r13.d(r12, r12, 0.0f, 0.0f);
    L13:
        if (this.floatHeader == false) goto L17;
        RadiusLayout r14 = this.contentContainer;
        if (r14 == null) goto L17;
        r14.d(r12, r12, 0.0f, 0.0f);
    L17:
        com.obric.oui.panel.header.b r15 = this.panelHeader;
        if (r15 == null) goto L22;
        View r16 = r15.e();
        if (r16 == null) goto L22;
        ViewParent r17 = r16.getParent();
    L24:
        if ((r17 instanceof ViewGroup) == false) goto L41;
        com.obric.oui.panel.header.b r18 = this.panelHeader;
        if (r18 == null) goto L30;
        View r19 = r18.e();
        if (r19 == null) goto L30;
        ViewParent r20 = r19.getParent();
    L32:
        if ((r20 instanceof ViewGroup) == true) goto L34;
        r20 = null;
    L34:
        ViewGroup r21 = (ViewGroup) r20;
        if (r21 == null) goto L41;
        com.obric.oui.panel.header.b r22 = this.panelHeader;
        if (r22 == null) goto L39;
        View r23 = r22.e();
    L40:
        r21.removeView(r23);
        goto L41
    L39:
        r23 = null;
    L30:
        r20 = null;
    L41:
        RadiusLayout r24 = this.headerContainer;
        if (r24 == null) goto L49;
        com.obric.oui.panel.header.b r25 = this.panelHeader;
        if (r25 == null) goto L46;
        View r26 = r25.e();
    L47:
        com.obric.oui.common.util.k.j(r24, r26);
        goto L49
    L46:
        r26 = null;
    L49:
        if (this.floatHeader == false) goto L59;
        if (this.contentContainer == null) goto L59;
        ConstraintSet r27 = new ConstraintSet();
        r27.clone(this.panelContainer);
        RadiusLayout r28 = this.contentContainer;
        Intrinsics.checkNotNull(r28);
        r27.clear(r28.getId(), 3);
        RadiusLayout r29 = this.contentContainer;
        Intrinsics.checkNotNull(r29);
        r27.connect(r29.getId(), 3, 0, 3);
        r27.applyTo(this.panelContainer);
        RadiusLayout r30 = this.headerContainer;
        if (r30 == null) goto L55;
        r30.setBackground(null);
    L55:
        RadiusLayout r31 = this.headerContainer;
        if (r31 == null) goto L59;
        r31.bringToFront();
    L59:
        if (this.backgroundDimEnable == true) goto L64;
        Window r32 = getWindow();
        if (r32 == null) goto L64;
        r32.setDimAmount(0.0f);
    L64:
        if (this.adaptNavBarColor == false) goto L86;
        Integer r33 = this.navBarColor;
        if (r33 == null) goto L72;
        int r34 = r33.intValue();
        Window r35 = getWindow();
        if (r35 == null) goto L85;
        r35.setNavigationBarColor(r34);
        return;
    L85:
        return;
    L72:
        if (this.autoSwitchDayNight == false) goto L78;
        if (this.useToneBg == false) goto L76;
        int r36 = u8.c.BGPanelTone;
    L81:
        Window r37 = getWindow();
        if (r37 == null) goto L87;
        r37.setNavigationBarColor(ContextCompat.getColor(getContext(), r36));
        return;
    L87:
        return;
    L76:
        r36 = u8.c.BGPanelTint;
        goto L81
    L78:
        if (this.useToneBg == false) goto L80;
        r36 = u8.c.ConstBGPanelReverse;
        goto L81
    L80:
        r36 = u8.c.ConstTextInverse;
        goto L81
    L86:
        return;
    L22:
        r17 = null;
        goto L24
    L8:
        r12 = 0.0f;
        goto L9
    }

    private final View wrapWithHeader(int r10, View r11, ViewGroup.LayoutParams r12) {
        ensureHeaderAndContainer();
        if (r10 == 0) goto L6;
        if (r11 != null) goto L6;
        r11 = getLayoutInflater().inflate(r10, this.contentContainer, false);
    L6:
        RadiusLayout r13 = this.contentContainer;
        if (r13 == null) goto L9;
        r13.removeAllViews();
    L9:
        RadiusLayout r14 = this.contentContainer;
        if (r12 != null) goto L13;
        if (r14 == null) goto L15;
        r14.addView(r11);
    L15:
        initView();
        ConstraintLayout r15 = this.panelContainer;
        Intrinsics.checkNotNull(r15);
        return r15;
    L13:
        if (r14 == null) goto L15;
        r14.addView(r11, r12);
        goto L15
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        Function1<? super MotionEvent, Boolean> r11 = this.dispatchTouchEvent;
        if (r11 == null) goto L9;
        if (r11.invoke(r10).booleanValue() == false) goto L9;
        return true;
    L9:
        return super.dispatchTouchEvent(r10);
    }

    public final boolean getAdaptNavBarColor() {
        return this.adaptNavBarColor;
    }

    public final boolean getAdaptRLSlide() {
        return this.adaptRLSlide;
    }

    public final boolean getAutoSwitchDayNight() {
        return this.autoSwitchDayNight;
    }

    public final boolean getBackgroundDimEnable() {
        return this.backgroundDimEnable;
    }

    public final int getBgColor() {
        if (this.autoSwitchDayNight == false) goto L9;
        if (this.useToneBg == false) goto L7;
        int r10 = u8.c.BGPanelTone;
    L13:
        return ContextCompat.getColor(getContext(), r10);
    L7:
        r10 = u8.c.BGPanelTint;
        goto L13
    L9:
        if (this.useToneBg == false) goto L11;
        r10 = u8.c.ConstBGPanelReverse;
        goto L13
    L11:
        r10 = u8.c.ConstTextInverse;
        goto L13
    }

    public final boolean getClipTopCorner() {
        return this.clipTopCorner;
    }

    public final Integer getCollapsedHeight() {
        return this.collapsedHeight;
    }

    public final RadiusLayout getContentContainer() {
        return this.contentContainer;
    }

    public final boolean getDisableAutoAdaptHeight() {
        return this.disableAutoAdaptHeight;
    }

    public final Function1<MotionEvent, Boolean> getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    /* JADX INFO: renamed from: getExpandedHeight, reason: collision with other method in class */
    public final Integer m27getExpandedHeight() {
        return this.expandedHeight;
    }

    public final boolean getFitsSystemWindows() {
        return this.fitsSystemWindows;
    }

    public final boolean getFixedHeight() {
        return this.fixedHeight;
    }

    public final boolean getFloatHeader() {
        return this.floatHeader;
    }

    public final RadiusLayout getHeaderContainer() {
        return this.headerContainer;
    }

    public final int getMaxPanelHeight() {
        return this.maxPanelHeight;
    }

    public final Integer getNavBarColor() {
        return this.navBarColor;
    }

    public final Function0<Boolean> getOnDialogBackPressCallback() {
        return this.onDialogBackPressCallback;
    }

    public final View.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public final OBasicPanel.PadCompatConfig getPadCompatConfig() {
        return this.padCompatConfig;
    }

    public final ConstraintLayout getPanelContainer() {
        return this.panelContainer;
    }

    public final com.obric.oui.panel.header.b getPanelHeader() {
        return this.panelHeader;
    }

    public final boolean getRemoveMinHeight() {
        return this.removeMinHeight;
    }

    public final boolean getUseToneBg() {
        return this.useToneBg;
    }

    public final void hideHeader() {
        RadiusLayout r10 = this.headerContainer;
        if (r10 == null) goto L6;
        com.obric.oui.common.util.k.f(r10);
        return;
    }

    public final boolean isExpandable() {
        return this.isExpandable;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onBackPressed() {
        Function0<Boolean> r10 = this.onDialogBackPressCallback;
        if (r10 != null) goto L5;
    L7:
        super.onBackPressed();
        return;
    L5:
        if (r10.invoke().booleanValue() != true) goto L7;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        BottomSheetBehavior<FrameLayout> r11 = getBehavior();
        Intrinsics.checkNotNullExpressionValue(r11, "behavior");
        boolean r12 = true;
        r11.setHideable(true);
        getBehavior().fitsSystemWindow = this.fitsSystemWindows;
        getBehavior().setAutoSlideToPeekHeight(!this.disableAutoAdaptHeight);
        if (this.isExpandable == false) goto L5;
        setIs69Expandable(true);
        BottomSheetBehavior<FrameLayout> r13 = getBehavior();
        Intrinsics.checkNotNullExpressionValue(r13, "behavior");
        r13.setPeekHeight(getPeekHeight());
        return;
    L5:
        BottomSheetBehavior<FrameLayout> r14 = getBehavior();
        com.obric.oui.panel.header.b r15 = this.panelHeader;
        if (r15 != null) goto L8;
    L10:
        r12 = false;
    L11:
        r14.setDraggable(r12);
        if (this.maxPanelHeight <= 0) goto L18;
        getBehavior().setMaxExpandedHeight(this.maxPanelHeight);
        if (this.fixedHeight == false) goto L19;
        setExpandedHeight(this.maxPanelHeight);
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (r15.c() != true) goto L10;
        goto L10
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (this.removeMinHeight == false) goto L6;
        removeMinHeight();
    L6:
        if (this.clipTopCorner == false) goto L8;
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        float r11 = TypedValue.applyDimension(1, 20, r10.getDisplayMetrics());
    L9:
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        r12.setCornerRadii(new float[]{r11, r11, r11, r11, 0.0f, 0.0f, 0.0f, 0.0f});
        r12.setColor(getBgColor());
        FrameLayout r13 = getBottomSheet();
        if (r13 == null) goto L13;
        r13.setBackground(r12);
    L13:
        if (this.isExpandable == false) goto L15;
        setExpandedHeight(getExpandedHeight());
    L15:
        setFitsSystemWindow(this.fitsSystemWindows);
        getBehavior().setIs69Mode(this.isExpandable);
        if (this.outsideClickListener == null) goto L20;
        View r14 = findViewById(f.touch_outside);
        if (r14 == null) goto L20;
        r14.setOnClickListener(this.outsideClickListener);
    L20:
        adaptPortraitRLSlide(this.adaptRLSlide);
        return;
    L8:
        r11 = 0.0f;
        goto L9
    }

    public final void removeMinHeight() {
        FrameLayout r10 = (FrameLayout) findViewById(f.design_bottom_sheet);
        if (r10 == null) goto L6;
        r10.setMinimumHeight(0);
        return;
    }

    public final void setAdaptNavBarColor(boolean r10) {
        this.adaptNavBarColor = r10;
    }

    public final void setAdaptRLSlide(boolean r10) {
        this.adaptRLSlide = r10;
    }

    public final void setAutoSwitchDayNight(boolean r10) {
        this.autoSwitchDayNight = r10;
    }

    public final void setBackgroundDimEnable(boolean r10) {
        this.backgroundDimEnable = r10;
    }

    public final void setBgColor(int r10) {
        FrameLayout r11 = getBottomSheet();
        if (r11 == null) goto L5;
        Drawable r12 = r11.getBackground();
    L7:
        if ((r12 instanceof GradientDrawable) == false) goto L9;
        ((GradientDrawable) r12).setColor(r10);
        Drawable r13 = r12;
    L10:
        FrameLayout r14 = getBottomSheet();
        if (r14 == null) goto L14;
        r14.setBackground(r13);
    L14:
        if (this.adaptNavBarColor == true) goto L16;
        return;
    L16:
        if (this.navBarColor != null) goto L22;
        Window r15 = getWindow();
        if (r15 == null) goto L23;
        r15.setNavigationBarColor(r10);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        GradientDrawable r16 = new GradientDrawable();
        r16.setColor(r10);
        r13 = r16;
        goto L10
    L5:
        r12 = null;
        goto L7
    }

    public final void setClipTopCorner(boolean r10) {
        this.clipTopCorner = r10;
    }

    public final void setCollapsedHeight(Integer r10) {
        this.collapsedHeight = r10;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r10) {
        super.setContentView(wrapWithHeader(r10, null, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.setContentView(wrapWithHeader(0, r10, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.setContentView(wrapWithHeader(0, r10, r11));
    }

    public final void setDisableAutoAdaptHeight(boolean r10) {
        this.disableAutoAdaptHeight = r10;
    }

    public final void setDispatchTouchEvent(Function1<? super MotionEvent, Boolean> r10) {
        this.dispatchTouchEvent = r10;
    }

    public final void setExpandable(boolean r10) {
        this.isExpandable = r10;
    }

    public final void setExpandedHeight(int r10) {
        FrameLayout r11 = (FrameLayout) findViewById(f.design_bottom_sheet);
        if (r11 == null) goto L6;
        r11.getLayoutParams().height = r10;
        return;
    }

    public final void setExpandedHeight(Integer r10) {
        this.expandedHeight = r10;
    }

    public final void setFitsSystemWindow(boolean r10) {
        FrameLayout r11 = (FrameLayout) findViewById(f.container);
        if (r11 == null) goto L6;
        r11.setFitsSystemWindows(r10);
        return;
    }

    public final void setFitsSystemWindows(boolean r10) {
        this.fitsSystemWindows = r10;
    }

    public final void setFixedHeight(boolean r10) {
        this.fixedHeight = r10;
    }

    public final void setFloatHeader(boolean r10) {
        this.floatHeader = r10;
    }

    public final void setMaxPanelHeight(int r10) {
        this.maxPanelHeight = r10;
    }

    public final void setNavBarColor(Integer r10) {
        this.navBarColor = r10;
    }

    public final void setOnDialogBackPressCallback(Function0<Boolean> r10) {
        this.onDialogBackPressCallback = r10;
    }

    public final void setOutsideClickListener(View.OnClickListener r10) {
        this.outsideClickListener = r10;
    }

    public final void setPadCompatConfig(OBasicPanel.PadCompatConfig r10) {
    }

    public final void setPanelHeader(com.obric.oui.panel.header.b r10) {
        this.panelHeader = r10;
    }

    public final void setRadius(float r12, float r13, float r14, float r15) {
        RadiusLayout r10 = this.headerContainer;
        if (r10 == null) goto L6;
        r10.d(r12, r13, r14, r15);
    L6:
        if (this.floatHeader == false) goto L10;
        RadiusLayout r11 = this.contentContainer;
        if (r11 == null) goto L10;
        r11.d(r12, r13, r14, r15);
    L10:
        FrameLayout r16 = getBottomSheet();
        if (r16 == null) goto L13;
        Drawable r17 = r16.getBackground();
    L15:
        if ((r17 instanceof GradientDrawable) == false) goto L17;
        ((GradientDrawable) r17).setCornerRadii(new float[]{r12, r12, r13, r13, r14, r14, r15, r15});
        return;
    L17:
        if (r17 != null) goto L23;
        FrameLayout r18 = getBottomSheet();
        if (r18 == null) goto L24;
        GradientDrawable r19 = new GradientDrawable();
        r19.setCornerRadii(new float[]{r12, r12, r13, r13, r14, r14, r15, r15});
        Unit r110 = Unit.INSTANCE;
        r18.setBackground(r19);
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r17 = null;
        goto L15
    }

    public final void setRemoveMinHeight(boolean r10) {
        this.removeMinHeight = r10;
    }

    public final void setUseToneBg(boolean r10) {
        this.useToneBg = r10;
    }
}
