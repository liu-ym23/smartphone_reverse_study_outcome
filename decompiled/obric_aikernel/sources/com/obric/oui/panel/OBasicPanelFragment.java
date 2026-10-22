package com.obric.oui.panel;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.util.i;
import com.obric.oui.panel.anim.AnimController;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001U\b\u0016\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\n\u001a\u00020\u00022\f\b\u0001\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u001e\u001a\u00020\u001dR\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010 \u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R$\u0010<\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010&\u001a\u0004\b=\u0010(\"\u0004\b>\u0010*R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010 \u001a\u0004\bF\u0010\"\"\u0004\bG\u0010$R$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010 \u001a\u0004\bP\u0010\"\"\u0004\bQ\u0010$R\"\u0010R\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010 \u001a\u0004\bS\u0010\"\"\u0004\bT\u0010$R\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR$\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR*\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010l\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010 \u001a\u0004\bm\u0010\"\"\u0004\bn\u0010$R\"\u0010o\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010 \u001a\u0004\bp\u0010\"\"\u0004\bq\u0010$R\u001c\u0010s\u001a\u00020r8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\"\u0010w\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010 \u001a\u0004\bx\u0010\"\"\u0004\by\u0010$R\"\u0010z\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010 \u001a\u0004\b{\u0010\"\"\u0004\b|\u0010$R\u0016\u0010}\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010 R#\u0010~\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010`\u001a\u0004\b\u007f\u0010b\"\u0005\b\u0080\u0001\u0010dR&\u0010\u0081\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010 \u001a\u0005\b\u0082\u0001\u0010\"\"\u0005\b\u0083\u0001\u0010$R(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010&\u001a\u0005\b\u0085\u0001\u0010(\"\u0005\b\u0086\u0001\u0010*R3\u0010\u0089\u0001\u001a\f\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010\u0087\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R&\u0010\u008f\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010 \u001a\u0005\b\u0090\u0001\u0010\"\"\u0005\b\u0091\u0001\u0010$R&\u0010\u0092\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010 \u001a\u0005\b\u0093\u0001\u0010\"\"\u0005\b\u0094\u0001\u0010$R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R9\u0010\u009e\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001¨\u0006¦\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "", "exeEnterAnim", "exeExitAnim", "", "allowingStateLoss", "tryDismissWithAnimation", "Lcom/obric/oui/panel/BottomSheetBehavior;", "behavior", "dismissWithAnimation", "dismissAfterAnimation", "", EventBody.KEY_VALUE, "out", "dispatchAnimProgress", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/View;", "view", "onViewCreated", "Landroid/content/DialogInterface;", "dialog", "onCancel", "dismiss", "dismissAllowingStateLoss", "onDismiss", "", "getBgColor", "useToneBg", "Z", "getUseToneBg", "()Z", "setUseToneBg", "(Z)V", "expandedHeight", "Ljava/lang/Integer;", "getExpandedHeight", "()Ljava/lang/Integer;", "setExpandedHeight", "(Ljava/lang/Integer;)V", "Landroid/view/View$OnClickListener;", "outsideClickListener", "Landroid/view/View$OnClickListener;", "getOutsideClickListener", "()Landroid/view/View$OnClickListener;", "setOutsideClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "floatHeader", "getFloatHeader", "setFloatHeader", "collapsedHeight", "getCollapsedHeight", "setCollapsedHeight", "Lw9/a;", "animConfig", "Lw9/a;", "getAnimConfig", "()Lw9/a;", "setAnimConfig", "(Lw9/a;)V", "isExpandable", "setExpandable", "Lcom/obric/oui/panel/header/b;", "panelHeader", "Lcom/obric/oui/panel/header/b;", "getPanelHeader", "()Lcom/obric/oui/panel/header/b;", "setPanelHeader", "(Lcom/obric/oui/panel/header/b;)V", "fixedPanelHeight", "getFixedPanelHeight", "setFixedPanelHeight", "disableAutoAdaptHeight", "getDisableAutoAdaptHeight", "setDisableAutoAdaptHeight", "com/obric/oui/panel/OBasicPanelFragment$a", "bottomSheetDismissCallback", "Lcom/obric/oui/panel/OBasicPanelFragment$a;", "Landroid/content/DialogInterface$OnCancelListener;", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "styleId", "I", "getStyleId", "()I", "setStyleId", "(I)V", "Lkotlin/Function0;", "onDialogBackPressCallback", "Lkotlin/jvm/functions/Function0;", "getOnDialogBackPressCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDialogBackPressCallback", "(Lkotlin/jvm/functions/Function0;)V", "adaptNavBarColor", "getAdaptNavBarColor", "setAdaptNavBarColor", "removeMinHeight", "getRemoveMinHeight", "setRemoveMinHeight", "Lcom/obric/oui/panel/anim/AnimController;", "animController", "Lcom/obric/oui/panel/anim/AnimController;", "getAnimController$OUI_standardRelease", "()Lcom/obric/oui/panel/anim/AnimController;", "backgroundDimEnable", "getBackgroundDimEnable", "setBackgroundDimEnable", "clipTopCorner", "getClipTopCorner", "setClipTopCorner", "waitingForDismissAllowingStateLoss", "maxPanelHeight", "getMaxPanelHeight", "setMaxPanelHeight", "autoSwitchDayNight", "getAutoSwitchDayNight", "setAutoSwitchDayNight", "navBarColor", "getNavBarColor", "setNavBarColor", "", "Lcom/obric/oui/panel/BottomSheetBehavior$d;", "bottomSheetCallbacks", "Ljava/util/List;", "getBottomSheetCallbacks", "()Ljava/util/List;", "setBottomSheetCallbacks", "(Ljava/util/List;)V", "fitsSystemWindows", "getFitsSystemWindows", "setFitsSystemWindows", "adaptRLSlide", "getAdaptRLSlide", "setAdaptRLSlide", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "Lkotlin/jvm/functions/Function1;", "getDispatchTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OBasicPanelFragment extends AppCompatDialogFragment {
    private boolean adaptNavBarColor;
    private boolean adaptRLSlide;
    private w9.a animConfig;
    private final AnimController animController;
    private boolean autoSwitchDayNight;
    private boolean backgroundDimEnable;
    private List<? extends BottomSheetBehavior.d> bottomSheetCallbacks;
    private final a bottomSheetDismissCallback;
    private boolean clipTopCorner;
    private Integer collapsedHeight;
    private boolean disableAutoAdaptHeight;
    private Function1<? super MotionEvent, Boolean> dispatchTouchEvent;
    private Integer expandedHeight;
    private boolean fitsSystemWindows;
    private boolean fixedPanelHeight;
    private boolean floatHeader;
    private boolean isExpandable;
    private int maxPanelHeight;

    @ColorInt
    private Integer navBarColor;
    private DialogInterface.OnCancelListener onCancelListener;
    private Function0<Boolean> onDialogBackPressCallback;
    private DialogInterface.OnDismissListener onDismissListener;
    private View.OnClickListener outsideClickListener;
    private OBasicPanel.PadCompatConfig padCompatConfig;
    private com.obric.oui.panel.header.b panelHeader;
    private boolean removeMinHeight;
    private int styleId;
    private boolean useToneBg;
    private boolean waitingForDismissAllowingStateLoss;

    public static final class a extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f6951a;

        a(OBasicPanelFragment r10) {
            this.f6951a = r10;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void c(View r10, float r11) {
            Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void d(View r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "bottomSheet");
            if (r11 != 5) goto L6;
            OBasicPanelFragment.access$dismissAfterAnimation(this.f6951a);
            return;
        }
    }

    static final class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f6952a;

        b(OBasicPanelFragment r10) {
            this.f6952a = r10;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r10) {
            OBasicPanelFragment.access$exeEnterAnim(this.f6952a);
        }
    }

    public OBasicPanelFragment() {
        this.maxPanelHeight = -1;
        this.backgroundDimEnable = true;
        this.clipTopCorner = true;
        this.fitsSystemWindows = true;
        this.styleId = k.OBasicPanel;
        this.animController = new AnimController();
        this.bottomSheetDismissCallback = new a(this);
    }

    public static final /* synthetic */ void access$dismissAfterAnimation(OBasicPanelFragment r10) {
        r10.dismissAfterAnimation();
    }

    public static final /* synthetic */ void access$dispatchAnimProgress(OBasicPanelFragment r10, float r11, boolean r12) {
        r10.dispatchAnimProgress(r11, r12);
    }

    public static final /* synthetic */ void access$exeEnterAnim(OBasicPanelFragment r10) {
        r10.exeEnterAnim();
    }

    private final void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    private final void dismissWithAnimation(@NonNull BottomSheetBehavior<?> r10, boolean r11) {
        this.waitingForDismissAllowingStateLoss = r11;
        if (r10.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L13;
        BottomSheetDialog r12 = (BottomSheetDialog) getDialog();
        if (r12 == null) goto L10;
        r12.removeDefaultCallback();
    L10:
        BottomSheetDialog r13 = (BottomSheetDialog) getDialog();
        if (r13 == null) goto L13;
        r13.clearBottomSheetCallback();
    L13:
        r10.addBottomSheetCallback(this.bottomSheetDismissCallback);
        r10.setState(5);
    }

    private final void dispatchAnimProgress(float r10, boolean r11) {
        List<? extends BottomSheetBehavior.d> r12 = this.bottomSheetCallbacks;
        if (r12 == null) goto L11;
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L18;
        BottomSheetBehavior.d r14 = (BottomSheetBehavior.d) r13.next();
        if (r11 == true) goto L9;
        r14.a(r10);
        goto L6
    L9:
        r14.b(r10);
        goto L6
    L18:
        return;
    }

    static /* synthetic */ void dispatchAnimProgress$default(OBasicPanelFragment r10, float r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = true;
    L6:
        r10.dispatchAnimProgress(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchAnimProgress");
    }

    private final void exeEnterAnim() {
        Dialog r10 = getDialog();
        if (r10 == null) goto L7;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L7;
        View r12 = r11.getDecorView();
    L8:
        if (r12 == null) goto L15;
        w9.a r13 = this.animConfig;
        if (r13 == null) goto L16;
        ObjectAnimator r14 = r13.a(r12);
        if (r14 == null) goto L17;
        this.animController.a(r14, new OBasicPanelFragment$exeEnterAnim$$inlined$let$lambda$1(this));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r12 = null;
        goto L8
    }

    private final void exeExitAnim() {
        Dialog r10 = getDialog();
        if (r10 == null) goto L7;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L7;
        View r12 = r11.getDecorView();
    L8:
        if (r12 == null) goto L15;
        w9.a r13 = this.animConfig;
        if (r13 == null) goto L16;
        ObjectAnimator r14 = r13.b(r12);
        if (r14 == null) goto L17;
        this.animController.b(r14, new OBasicPanelFragment$exeExitAnim$$inlined$let$lambda$1(this));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r12 = null;
        goto L8
    }

    private final boolean tryDismissWithAnimation(boolean r10) {
        Dialog r11 = getDialog();
        if ((r11 instanceof BottomSheetDialog) == false) goto L10;
        BottomSheetDialog r12 = (BottomSheetDialog) r11;
        BottomSheetBehavior<FrameLayout> r13 = r12.getBehavior();
        Intrinsics.checkNotNullExpressionValue(r13, "dialog.behavior");
        if (r13.isHideable() == true) goto L7;
        return false;
    L7:
        if (r12.getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r13, r10);
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        exeExitAnim();     // Catch: Exception -> L7
        if (tryDismissWithAnimation(true) == true) goto L5;
        super.dismiss();     // Catch: Exception -> L7
    L5:
        Unit r10 = Unit.INSTANCE;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        i.a("Try exception occur " + e.getMessage());
        Unit r11 = Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        exeExitAnim();
        super.dismissAllowingStateLoss();
    }

    public final boolean getAdaptNavBarColor() {
        return this.adaptNavBarColor;
    }

    public final boolean getAdaptRLSlide() {
        return this.adaptRLSlide;
    }

    public final w9.a getAnimConfig() {
        return this.animConfig;
    }

    public final AnimController getAnimController$OUI_standardRelease() {
        return this.animController;
    }

    public final boolean getAutoSwitchDayNight() {
        return this.autoSwitchDayNight;
    }

    public final boolean getBackgroundDimEnable() {
        return this.backgroundDimEnable;
    }

    public final int getBgColor() {
        Dialog r10 = getDialog();
        if ((r10 instanceof OBasePanelDialog) == true) goto L5;
        r10 = null;
    L5:
        OBasePanelDialog r11 = (OBasePanelDialog) r10;
        if (r11 != null) goto L10;
        return 0;
    L10:
        return r11.getBgColor();
    }

    public final List<BottomSheetBehavior.d> getBottomSheetCallbacks() {
        return this.bottomSheetCallbacks;
    }

    public final boolean getClipTopCorner() {
        return this.clipTopCorner;
    }

    public final Integer getCollapsedHeight() {
        return this.collapsedHeight;
    }

    public final boolean getDisableAutoAdaptHeight() {
        return this.disableAutoAdaptHeight;
    }

    public final Function1<MotionEvent, Boolean> getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    public final Integer getExpandedHeight() {
        return this.expandedHeight;
    }

    public final boolean getFitsSystemWindows() {
        return this.fitsSystemWindows;
    }

    public final boolean getFixedPanelHeight() {
        return this.fixedPanelHeight;
    }

    public final boolean getFloatHeader() {
        return this.floatHeader;
    }

    public final int getMaxPanelHeight() {
        return this.maxPanelHeight;
    }

    public final Integer getNavBarColor() {
        return this.navBarColor;
    }

    public final DialogInterface.OnCancelListener getOnCancelListener() {
        return this.onCancelListener;
    }

    public final Function0<Boolean> getOnDialogBackPressCallback() {
        return this.onDialogBackPressCallback;
    }

    public final DialogInterface.OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public final View.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public final OBasicPanel.PadCompatConfig getPadCompatConfig() {
        return this.padCompatConfig;
    }

    public final com.obric.oui.panel.header.b getPanelHeader() {
        return this.panelHeader;
    }

    public final boolean getRemoveMinHeight() {
        return this.removeMinHeight;
    }

    public final int getStyleId() {
        return this.styleId;
    }

    public final boolean getUseToneBg() {
        return this.useToneBg;
    }

    public final boolean isExpandable() {
        return this.isExpandable;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        exeExitAnim();
        super.onCancel(r10);
        DialogInterface.OnCancelListener r11 = this.onCancelListener;
        if (r11 == null) goto L6;
        r11.onCancel(r10);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r10) {
        Context r11 = requireContext();
        Intrinsics.checkNotNullExpressionValue(r11, "requireContext()");
        OBasePanelDialog r12 = new OBasePanelDialog(r11, this.styleId);
        r12.setMaxPanelHeight(this.maxPanelHeight);
        r12.setUseToneBg(this.useToneBg);
        r12.setExpandable(this.isExpandable);
        r12.setFloatHeader(this.floatHeader);
        r12.setBackgroundDimEnable(this.backgroundDimEnable);
        r12.setAdaptNavBarColor(this.adaptNavBarColor);
        r12.setPanelHeader(this.panelHeader);
        r12.setNavBarColor(this.navBarColor);
        r12.setOnDialogBackPressCallback(this.onDialogBackPressCallback);
        r12.setClipTopCorner(this.clipTopCorner);
        r12.setAutoSwitchDayNight(this.autoSwitchDayNight);
        r12.setDispatchTouchEvent(this.dispatchTouchEvent);
        r12.setRemoveMinHeight(this.removeMinHeight);
        r12.setPadCompatConfig(this.padCompatConfig);
        r12.setFixedHeight(this.fixedPanelHeight);
        r12.setOutsideClickListener(this.outsideClickListener);
        r12.setCollapsedHeight(this.collapsedHeight);
        r12.setExpandedHeight(this.expandedHeight);
        r12.setFitsSystemWindows(this.fitsSystemWindows);
        r12.setAdaptRLSlide(this.adaptRLSlide);
        r12.setDisableAutoAdaptHeight(this.disableAutoAdaptHeight);
        List<? extends BottomSheetBehavior.d> r13 = this.bottomSheetCallbacks;
        if (r13 == null) goto L9;
        if (r13 == null) goto L9;
        Iterator<T> r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        r12.addBottomSheetCallback((BottomSheetBehavior.d) r14.next());
    L9:
        return r12;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        super.onDismiss(r10);
        DialogInterface.OnDismissListener r11 = this.onDismissListener;
        if (r11 == null) goto L6;
        r11.onDismiss(r10);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        Dialog r12 = getDialog();
        if (r12 == null) goto L6;
        r12.setOnShowListener(new b(this));
        return;
    }

    public final void setAdaptNavBarColor(boolean r10) {
        this.adaptNavBarColor = r10;
    }

    public final void setAdaptRLSlide(boolean r10) {
        this.adaptRLSlide = r10;
    }

    public final void setAnimConfig(w9.a r10) {
        this.animConfig = r10;
    }

    public final void setAutoSwitchDayNight(boolean r10) {
        this.autoSwitchDayNight = r10;
    }

    public final void setBackgroundDimEnable(boolean r10) {
        this.backgroundDimEnable = r10;
    }

    public final void setBottomSheetCallbacks(List<? extends BottomSheetBehavior.d> r10) {
        this.bottomSheetCallbacks = r10;
    }

    public final void setClipTopCorner(boolean r10) {
        this.clipTopCorner = r10;
    }

    public final void setCollapsedHeight(Integer r10) {
        this.collapsedHeight = r10;
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

    public final void setExpandedHeight(Integer r10) {
        this.expandedHeight = r10;
    }

    public final void setFitsSystemWindows(boolean r10) {
        this.fitsSystemWindows = r10;
    }

    public final void setFixedPanelHeight(boolean r10) {
        this.fixedPanelHeight = r10;
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

    public final void setOnCancelListener(DialogInterface.OnCancelListener r10) {
        this.onCancelListener = r10;
    }

    public final void setOnDialogBackPressCallback(Function0<Boolean> r10) {
        this.onDialogBackPressCallback = r10;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r10) {
        this.onDismissListener = r10;
    }

    public final void setOutsideClickListener(View.OnClickListener r10) {
        this.outsideClickListener = r10;
    }

    public final void setPadCompatConfig(OBasicPanel.PadCompatConfig r10) {
    }

    public final void setPanelHeader(com.obric.oui.panel.header.b r10) {
        this.panelHeader = r10;
    }

    public final void setRemoveMinHeight(boolean r10) {
        this.removeMinHeight = r10;
    }

    public final void setStyleId(int r10) {
        this.styleId = r10;
    }

    public final void setUseToneBg(boolean r10) {
        this.useToneBg = r10;
    }
}
