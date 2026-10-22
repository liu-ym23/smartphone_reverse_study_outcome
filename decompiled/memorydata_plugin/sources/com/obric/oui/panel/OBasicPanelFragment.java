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
import androidx.appcompat.app.AppCompatDialogFragment;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.m;
import com.obric.oui.panel.anim.AnimController;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001$\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010~\u001a\u00020\u007fH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u007fH\u0002J\t\u0010\u0081\u0001\u001a\u00020\u007fH\u0016J\"\u0010\u0082\u0001\u001a\u00020\u007f2\u000e\b\u0001\u0010\u0083\u0001\u001a\u0007\u0012\u0002\b\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0004H\u0002J\u001e\u0010\u0086\u0001\u001a\u00020\u007f2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u0004H\u0002J\t\u0010\u008a\u0001\u001a\u00020\u007fH\u0002J\t\u0010\u008b\u0001\u001a\u00020\u007fH\u0002J\u0007\u0010\u008c\u0001\u001a\u00020*J\u0013\u0010\u008d\u0001\u001a\u00020\u007f2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\u0016\u0010\u0090\u0001\u001a\u00030\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0013\u0010\u0094\u0001\u001a\u00020\u007f2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\u001f\u0010\u0095\u0001\u001a\u00020\u007f2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010&\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001e\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR(\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001a\u0010H\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0006\"\u0004\bv\u0010\bR\u001a\u0010w\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010J\"\u0004\by\u0010LR\u001a\u0010z\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0006\"\u0004\b|\u0010\bR\u000e\u0010}\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "()V", "adaptNavBarColor", "", "getAdaptNavBarColor", "()Z", "setAdaptNavBarColor", "(Z)V", "adaptRLSlide", "getAdaptRLSlide", "setAdaptRLSlide", "animConfig", "Lcom/obric/oui/panel/anim/AnimConfig;", "getAnimConfig", "()Lcom/obric/oui/panel/anim/AnimConfig;", "setAnimConfig", "(Lcom/obric/oui/panel/anim/AnimConfig;)V", "animController", "Lcom/obric/oui/panel/anim/AnimController;", "getAnimController$OUI_standardRelease", "()Lcom/obric/oui/panel/anim/AnimController;", "autoSwitchDayNight", "getAutoSwitchDayNight", "setAutoSwitchDayNight", "backgroundDimEnable", "getBackgroundDimEnable", "setBackgroundDimEnable", "bottomSheetCallbacks", "", "Lcom/obric/oui/panel/BottomSheetBehavior$BottomSheetCallback;", "getBottomSheetCallbacks", "()Ljava/util/List;", "setBottomSheetCallbacks", "(Ljava/util/List;)V", "bottomSheetDismissCallback", "com/obric/oui/panel/OBasicPanelFragment$bottomSheetDismissCallback$1", "Lcom/obric/oui/panel/OBasicPanelFragment$bottomSheetDismissCallback$1;", "clipTopCorner", "getClipTopCorner", "setClipTopCorner", "collapsedHeight", "", "getCollapsedHeight", "()Ljava/lang/Integer;", "setCollapsedHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "disableAutoAdaptHeight", "getDisableAutoAdaptHeight", "setDisableAutoAdaptHeight", "dispatchTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getDispatchTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "expandedHeight", "getExpandedHeight", "setExpandedHeight", "fitsSystemWindows", "getFitsSystemWindows", "setFitsSystemWindows", "fixedPanelHeight", "getFixedPanelHeight", "setFixedPanelHeight", "floatHeader", "getFloatHeader", "setFloatHeader", "isExpandable", "setExpandable", "maxPanelHeight", "getMaxPanelHeight", "()I", "setMaxPanelHeight", "(I)V", "navBarColor", "getNavBarColor", "setNavBarColor", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "onDialogBackPressCallback", "Lkotlin/Function0;", "getOnDialogBackPressCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDialogBackPressCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "outsideClickListener", "Landroid/view/View$OnClickListener;", "getOutsideClickListener", "()Landroid/view/View$OnClickListener;", "setOutsideClickListener", "(Landroid/view/View$OnClickListener;)V", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "panelHeader", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "getPanelHeader", "()Lcom/obric/oui/panel/header/BasicPanelHeader;", "setPanelHeader", "(Lcom/obric/oui/panel/header/BasicPanelHeader;)V", "removeMinHeight", "getRemoveMinHeight", "setRemoveMinHeight", "styleId", "getStyleId", "setStyleId", "useToneBg", "getUseToneBg", "setUseToneBg", "waitingForDismissAllowingStateLoss", "dismiss", "", "dismissAfterAnimation", "dismissAllowingStateLoss", "dismissWithAnimation", "behavior", "Lcom/obric/oui/panel/BottomSheetBehavior;", "allowingStateLoss", "dispatchAnimProgress", EventBody.KEY_VALUE, "", "out", "exeEnterAnim", "exeExitAnim", "getBgColor", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "onViewCreated", "view", "Landroid/view/View;", "tryDismissWithAnimation", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasicPanelFragment extends AppCompatDialogFragment {
    private boolean adaptNavBarColor;
    private boolean adaptRLSlide;
    private com.obric.oui.panel.anim.a animConfig;
    private final AnimController animController;
    private boolean autoSwitchDayNight;
    private boolean backgroundDimEnable;
    private List<? extends BottomSheetBehavior.a> bottomSheetCallbacks;
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
    private Integer navBarColor;
    private DialogInterface.OnCancelListener onCancelListener;
    private Function0<Boolean> onDialogBackPressCallback;
    private DialogInterface.OnDismissListener onDismissListener;
    private View.OnClickListener outsideClickListener;
    private OBasicPanel.PadCompatConfig padCompatConfig;
    private com.obric.oui.panel.header.c panelHeader;
    private boolean removeMinHeight;
    private int styleId;
    private boolean useToneBg;
    private boolean waitingForDismissAllowingStateLoss;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/oui/panel/OBasicPanelFragment$bottomSheetDismissCallback$1", "Lcom/obric/oui/panel/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends BottomSheetBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f14266a;

        a(OBasicPanelFragment r1) {
            this.f14266a = r1;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.a
        public void a(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.a
        public void a(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 5) goto L6;
            OBasicPanelFragment.access$dismissAfterAnimation(this.f14266a);
            return;
        }
    }

    public OBasicPanelFragment() {
        this.maxPanelHeight = -1;
        this.backgroundDimEnable = true;
        this.clipTopCorner = true;
        this.fitsSystemWindows = true;
        this.styleId = ZeusTransformUtils.mapRes(R.style.OBasicPanel, "style", "OBasicPanel");
        this.animController = new AnimController();
        this.bottomSheetDismissCallback = new a(this);
    }

    public static final /* synthetic */ void access$dismissAfterAnimation(OBasicPanelFragment r0) {
        r0.dismissAfterAnimation();
    }

    public static final /* synthetic */ void access$dispatchAnimProgress(OBasicPanelFragment r0, float r1, boolean r2) {
        r0.dispatchAnimProgress(r1, r2);
    }

    private final void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    private final void dismissWithAnimation(BottomSheetBehavior<?> r4, boolean r5) {
        this.waitingForDismissAllowingStateLoss = r5;
        if (r4.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(getDialog(), BottomSheetDialog.class) == false) goto L15;
        BottomSheetDialog r6 = (BottomSheetDialog) ZeusTransformUtils.preCheckCast(getDialog(), BottomSheetDialog.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L11;
        r6.removeDefaultCallback();
    L11:
        BottomSheetDialog r7 = (BottomSheetDialog) ZeusTransformUtils.preCheckCast(getDialog(), BottomSheetDialog.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r7.clearBottomSheetCallback();
    L15:
        r4.addBottomSheetCallback((BottomSheetBehavior.a) ZeusTransformUtils.preCheckCast(this.bottomSheetDismissCallback, BottomSheetBehavior.a.class, "com.obric.memorydata.plugin"));
        r4.setState(5);
    }

    private final void dispatchAnimProgress(float r4, boolean r5) {
        List<? extends BottomSheetBehavior.a> r3 = this.bottomSheetCallbacks;
        if (r3 == null) goto L12;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L19;
        BottomSheetBehavior.a r0 = (BottomSheetBehavior.a) ZeusTransformUtils.preCheckCast(r6.next(), BottomSheetBehavior.a.class, "com.obric.memorydata.plugin");
        if (r5 == true) goto L10;
        r0.a(r4);
        goto L7
    L10:
        r0.b(r4);
        goto L7
    L19:
        return;
    }

    static /* synthetic */ void dispatchAnimProgress$default(OBasicPanelFragment r0, float r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        r0.dispatchAnimProgress(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchAnimProgress");
    }

    private final void exeEnterAnim() {
        Dialog r0 = getDialog();
        View r1 = null;
        if (r0 == null) goto L9;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L9;
        r1 = r2.getDecorView();
    L9:
        if (r1 == null) goto L18;
        com.obric.oui.panel.anim.a r3 = this.animConfig;
        if (r3 == null) goto L19;
        ObjectAnimator r4 = r3.a(r1);
        if (r4 == null) goto L20;
        getAnimController$OUI_standardRelease().a(r4, (Function1) ZeusTransformUtils.preCheckCast(new OBasicPanelFragment$exeEnterAnim$1$1(this), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L20:
        return;
    L19:
        return;
    }

    private final void exeExitAnim() {
        Dialog r0 = getDialog();
        View r1 = null;
        if (r0 == null) goto L9;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L9;
        r1 = r2.getDecorView();
    L9:
        if (r1 == null) goto L18;
        com.obric.oui.panel.anim.a r3 = this.animConfig;
        if (r3 == null) goto L19;
        ObjectAnimator r4 = r3.b(r1);
        if (r4 == null) goto L20;
        getAnimController$OUI_standardRelease().b(r4, (Function1) ZeusTransformUtils.preCheckCast(new OBasicPanelFragment$exeExitAnim$1$1(this), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L20:
        return;
    L19:
        return;
    }

    /* JADX INFO: renamed from: lambda$-8t2uODDuoJ8tgRcZnJfUC2aa0M, reason: not valid java name */
    public static /* synthetic */ void m1329lambda$8t2uODDuoJ8tgRcZnJfUC2aa0M(OBasicPanelFragment r0, DialogInterface r1) {
        m1330onViewCreated$lambda2(r0, r1);
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-2, reason: not valid java name */
    private static final void m1330onViewCreated$lambda2(OBasicPanelFragment r2, DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.exeEnterAnim();
    }

    private final boolean tryDismissWithAnimation(boolean r5) {
        Dialog r0 = getDialog();
        if (ZeusTransformUtils.instanceOf(r0, BottomSheetDialog.class) == false) goto L10;
        BottomSheetBehavior<FrameLayout> r1 = ((BottomSheetDialog) ZeusTransformUtils.preCheckCast(r0, BottomSheetDialog.class, "com.obric.memorydata.plugin")).getBehavior();
        Intrinsics.checkNotNullExpressionValue(r1, "dialog.behavior");
        if (r1.isHideable() == true) goto L7;
        return false;
    L7:
        if (((BottomSheetDialog) ZeusTransformUtils.preCheckCast(r0, BottomSheetDialog.class, "com.obric.memorydata.plugin")).getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r1, r5);
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
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        m.a(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Throwable r3 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        Unit r4 = Unit.INSTANCE;
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

    public final com.obric.oui.panel.anim.a getAnimConfig() {
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
        Dialog r2 = getDialog();
        if (ZeusTransformUtils.instanceOf(r2, OBasePanelDialog.class) == false) goto L5;
        OBasePanelDialog r3 = (OBasePanelDialog) ZeusTransformUtils.preCheckCast(r2, OBasePanelDialog.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getBgColor();
    L5:
        r3 = null;
        goto L6
    }

    public final List<BottomSheetBehavior.a> getBottomSheetCallbacks() {
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

    public final com.obric.oui.panel.header.c getPanelHeader() {
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
    public void onCancel(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dialog");
        exeExitAnim();
        super.onCancel(r4);
        DialogInterface.OnCancelListener r2 = this.onCancelListener;
        if (r2 == null) goto L7;
        r2.onCancel(r4);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext()");
        OBasePanelDialog r5 = new OBasePanelDialog(r0, this.styleId);
        r5.setMaxPanelHeight(getMaxPanelHeight());
        r5.setUseToneBg(getUseToneBg());
        r5.setExpandable(isExpandable());
        r5.setFloatHeader(getFloatHeader());
        r5.setBackgroundDimEnable(getBackgroundDimEnable());
        r5.setAdaptNavBarColor(getAdaptNavBarColor());
        r5.setPanelHeader(getPanelHeader());
        r5.setNavBarColor(getNavBarColor());
        r5.setOnDialogBackPressCallback(getOnDialogBackPressCallback());
        r5.setClipTopCorner(getClipTopCorner());
        r5.setAutoSwitchDayNight(getAutoSwitchDayNight());
        r5.setDispatchTouchEvent(getDispatchTouchEvent());
        r5.setRemoveMinHeight(getRemoveMinHeight());
        r5.setPadCompatConfig(getPadCompatConfig());
        r5.setFixedHeight(getFixedPanelHeight());
        r5.setOutsideClickListener(getOutsideClickListener());
        r5.setCollapsedHeight(getCollapsedHeight());
        r5.setExpandedHeight(getExpandedHeight());
        r5.setFitsSystemWindows(getFitsSystemWindows());
        r5.setAdaptRLSlide(getAdaptRLSlide());
        r5.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
        if (getBottomSheetCallbacks() == null) goto L12;
        List<BottomSheetBehavior.a> r3 = getBottomSheetCallbacks();
        if (r3 == null) goto L12;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        r5.addBottomSheetCallback((BottomSheetBehavior.a) ZeusTransformUtils.preCheckCast(r6.next(), BottomSheetBehavior.a.class, "com.obric.memorydata.plugin"));
    L12:
        return (Dialog) ZeusTransformUtils.preCheckCast(r5, Dialog.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super.onDismiss(r4);
        DialogInterface.OnDismissListener r2 = this.onDismissListener;
        if (r2 == null) goto L7;
        r2.onDismiss(r4);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L7;
        r4.setOnShowListener(new $$Lambda$OBasicPanelFragment$8t2uODDuoJ8tgRcZnJfUC2aa0M(this));
        return;
    }

    public final void setAdaptNavBarColor(boolean r1) {
        this.adaptNavBarColor = r1;
    }

    public final void setAdaptRLSlide(boolean r1) {
        this.adaptRLSlide = r1;
    }

    public final void setAnimConfig(com.obric.oui.panel.anim.a r3) {
        this.animConfig = (com.obric.oui.panel.anim.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.panel.anim.a.class, "com.obric.memorydata.plugin");
    }

    public final void setAutoSwitchDayNight(boolean r1) {
        this.autoSwitchDayNight = r1;
    }

    public final void setBackgroundDimEnable(boolean r1) {
        this.backgroundDimEnable = r1;
    }

    public final void setBottomSheetCallbacks(List<? extends BottomSheetBehavior.a> r3) {
        this.bottomSheetCallbacks = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setClipTopCorner(boolean r1) {
        this.clipTopCorner = r1;
    }

    public final void setCollapsedHeight(Integer r1) {
        this.collapsedHeight = r1;
    }

    public final void setDisableAutoAdaptHeight(boolean r1) {
        this.disableAutoAdaptHeight = r1;
    }

    public final void setDispatchTouchEvent(Function1<? super MotionEvent, Boolean> r3) {
        this.dispatchTouchEvent = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void setExpandable(boolean r1) {
        this.isExpandable = r1;
    }

    public final void setExpandedHeight(Integer r1) {
        this.expandedHeight = r1;
    }

    public final void setFitsSystemWindows(boolean r1) {
        this.fitsSystemWindows = r1;
    }

    public final void setFixedPanelHeight(boolean r1) {
        this.fixedPanelHeight = r1;
    }

    public final void setFloatHeader(boolean r1) {
        this.floatHeader = r1;
    }

    public final void setMaxPanelHeight(int r1) {
        this.maxPanelHeight = r1;
    }

    public final void setNavBarColor(Integer r1) {
        this.navBarColor = r1;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r3) {
        this.onCancelListener = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
    }

    public final void setOnDialogBackPressCallback(Function0<Boolean> r3) {
        this.onDialogBackPressCallback = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r3) {
        this.onDismissListener = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
    }

    public final void setOutsideClickListener(View.OnClickListener r3) {
        this.outsideClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
    }

    public final void setPadCompatConfig(OBasicPanel.PadCompatConfig r1) {
        this.padCompatConfig = r1;
    }

    public final void setPanelHeader(com.obric.oui.panel.header.c r1) {
        this.panelHeader = r1;
    }

    public final void setRemoveMinHeight(boolean r1) {
        this.removeMinHeight = r1;
    }

    public final void setStyleId(int r1) {
        this.styleId = r1;
    }

    public final void setUseToneBg(boolean r1) {
        this.useToneBg = r1;
    }
}
