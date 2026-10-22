package com.obric.oui.dialog.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.i;
import com.obric.oui.color.e;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\"*\u0001 \b&\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u0002:\u0006\u008f\u0001\u0090\u0001\u0091\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000bH\u0004J-\u0010Z\u001a\u00020X2\u0006\u0010[\u001a\u00020\u00182\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010^J\u0010\u0010_\u001a\u00020X2\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u00020XH\u0016J\b\u0010c\u001a\u00020XH\u0004J\b\u0010d\u001a\u00020XH\u0016J\u0012\u0010e\u001a\u00020X2\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\n\u0010h\u001a\u0004\u0018\u00010gH\u0002J\u0006\u0010i\u001a\u00020XJ\b\u0010j\u001a\u00020\u000bH\u0014J\b\u0010k\u001a\u00020\u000bH&J\u0010\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u0006H\u0014J\b\u0010n\u001a\u00020\u000bH\u0014J\u0010\u0010o\u001a\u00020p2\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010q\u001a\u00020XH\u0002J\b\u0010r\u001a\u00020\u0006H\u0016J\b\u0010s\u001a\u00020\u0006H\u0004J\b\u0010t\u001a\u00020XH\u0014J\b\u0010u\u001a\u00020XH\u0014J\b\u0010v\u001a\u00020XH\u0014J\b\u0010w\u001a\u00020XH\u0014J\b\u0010x\u001a\u00020XH\u0002J\b\u0010y\u001a\u00020XH\u0014J\b\u0010z\u001a\u00020XH\u0004J\u000e\u0010{\u001a\u00020X2\u0006\u0010|\u001a\u00020\u0006J\u0010\u0010}\u001a\u00020X2\u0006\u0010~\u001a\u00020\u0006H\u0016J\u000e\u0010\u007f\u001a\u00020X2\u0006\u0010b\u001a\u00020\u0006J\u001e\u0010\u0080\u0001\u001a\u00020X2\u0006\u0010|\u001a\u00020\u00062\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010\u0082\u0001\u001a\u00020X2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0003\u0010\u0084\u0001J\u0012\u0010\u0085\u0001\u001a\u00020X2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0086\u0001\u001a\u00020X2\t\u0010\u0081\u0001\u001a\u0004\u0018\u000101J\u0012\u0010\u0087\u0001\u001a\u00020X2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010\u0088\u0001\u001a\u00020X2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0003\u0010\u008a\u0001J\t\u0010\u008b\u0001\u001a\u00020XH\u0002J\u0015\u0010\u008c\u0001\u001a\u00020X2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010gH\u0016J\t\u0010\u008d\u0001\u001a\u00020XH\u0002J\t\u0010\u008e\u0001\u001a\u00020XH\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010%\"\u0004\b,\u0010'R\u001a\u0010-\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u0012\u0010:\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010;R\u001a\u0010<\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00104\"\u0004\b=\u00106R\u0012\u0010>\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u001a\u0010@\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0012\u0010D\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u0012\u0010E\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010N\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u001a\u0010O\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00104\"\u0004\bQ\u00106R\u0010\u0010R\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020\u0006X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00104\"\u0004\bU\u00106R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bV\u00104¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "context", "Landroid/content/Context;", "widthMatch", "", "matchParentHeight", "(Landroid/content/Context;ZZ)V", "autoDismissOnButtonClick", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "closeIcon", "Landroid/widget/ImageView;", "closeIconContainer", "Landroid/view/View;", "closeIconEnabled", "closeIconStyle", "Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "completeShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getCompleteShowListener", "()Landroid/content/DialogInterface$OnShowListener;", "setCompleteShowListener", "(Landroid/content/DialogInterface$OnShowListener;)V", "configurationCallback", "com/obric/oui/dialog/base/AbstractDialogModal$configurationCallback$1", "Lcom/obric/oui/dialog/base/AbstractDialogModal$configurationCallback$1;", "configurationCallbackRegistered", "contentRootView", "getContentRootView", "()Landroid/view/View;", "setContentRootView", "(Landroid/view/View;)V", "dialogAnimator", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "dialogRootView", "getDialogRootView", "setDialogRootView", "dimView", "getDimView", "setDimView", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "enableMaterial", "getEnableMaterial", "()Z", "setEnableMaterial", "(Z)V", "hideFirstFrame", "getHideFirstFrame", "setHideFirstFrame", "includeCutoutInLandscape", "Ljava/lang/Boolean;", "isShowingModal", "setShowingModal", "lastAppliedModalYPx", "Ljava/lang/Integer;", "mCancelable", "getMCancelable", "setMCancelable", "getMatchParentHeight", "modalYAnimCurrentPx", "modalYAnimTargetPx", "modalYAnimator", "Landroid/animation/ValueAnimator;", "myWindowCallback", "Landroid/view/Window$Callback;", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "originalWindowCallback", "pendingApplyModalPosition", "rootFixedHeightPx", "showAnimRunning", "getShowAnimRunning", "setShowAnimRunning", "showListener", "useNewDialogAnim", "getUseNewDialogAnim", "setUseNewDialogAnim", "getWidthMatch", "animateModalYTo", "", "targetYPx", "applyCloseIconStyle", "style", "customIconColor", "customIconBgColor", "(Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "applyInsets", "insets", "Lcom/obric/oui/view/WindowInsetsCompat;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "completeOnShow", "dismiss", "ensureAttachedToParent", "parent", "Landroid/view/ViewGroup;", "findDecorViewParent", "forceHideFirstFrame", "getBaseLayoutRes", "getLayout", "getLayoutMarginBottom", "excludeThreeButtonsNaviBar", "getLayoutMarginHorizontal", "getTargetDimAmount", "", "interceptBackPressed", "isAutoDismiss", "isDarkTheme", "onDetachedFromWindow", "originDismiss", "performEnterAnimation", "performExitAnimation", "registerConfigurationCallbackIfNeeded", "requestModalApplyInsets", "restoreWindowCallback", "setAutoDismiss", "enabled", "setCancelable", "cancelable", "setCanceledOnTouchOutside", "setCloseIconEnabled", "listener", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)V", "setOnCancelListener", "setOnDismissListener", "setOnShowListener", "setRootFixedHeight", "heightPx", "(Ljava/lang/Integer;)V", "setupDimViewClick", "show", "unregisterConfigurationCallbackIfNeeded", "updateRootLayout", "BackPressedWindowCallback", "CloseIconStyle", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractDialogModal extends FrameLayout implements com.obric.oui.dialog.v2.alert.style.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13808a = null;
    private Window.Callback A;
    private Window.Callback B;
    private com.obric.oui.animation.easy.b<View> C;
    private boolean D;
    private ValueAnimator E;
    private Integer F;
    private Integer G;
    private Integer H;
    private d I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f13809b;
    protected View c;
    protected View d;
    private final boolean e;
    private final boolean f;
    private View g;
    private ImageView h;
    private boolean i;
    private CloseIconStyle j;
    private View.OnClickListener k;
    private boolean l;
    private boolean m;
    private DialogInterface.OnDismissListener n;
    private DialogInterface.OnCancelListener o;
    private DialogInterface.OnShowListener p;
    private DialogInterface.OnShowListener q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Integer x;
    private Boolean y;
    private boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        private static final /* synthetic */ CloseIconStyle[] $values() {
            return new CloseIconStyle[]{LIGHT, DARK, CUSTOM};
        }

        static {
            LIGHT = new CloseIconStyle("LIGHT", 0);
            DARK = new CloseIconStyle("DARK", 1);
            CUSTOM = new CloseIconStyle("CUSTOM", 2);
            $VALUES = $values();
        }

        private CloseIconStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static CloseIconStyle valueOf(String r2) {
            return (CloseIconStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(CloseIconStyle.class, r2), CloseIconStyle.class, "com.obric.memorydata.plugin");
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CloseIconStyle[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13810a = null;

        static {
            int[] r0 = new int[CloseIconStyle.values().length];
            r0[CloseIconStyle.DARK.ordinal()] = 1;
            r0[CloseIconStyle.LIGHT.ordinal()] = 2;
            r0[CloseIconStyle.CUSTOM.ordinal()] = 3;
            f13810a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/dialog/base/AbstractDialogModal$animateModalYTo$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f13811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13812b;

        c(AbstractDialogModal r1, int r2) {
            this.f13811a = r1;
            this.f13812b = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            AbstractDialogModal.c(this.f13811a, null);
            AbstractDialogModal.a(this.f13811a, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            AbstractDialogModal.a(this.f13811a, Integer.valueOf(this.f13812b));
            AbstractDialogModal.b(this.f13811a, Integer.valueOf(this.f13812b));
            AbstractDialogModal.c(this.f13811a, null);
            AbstractDialogModal.a(this.f13811a, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/dialog/base/AbstractDialogModal$configurationCallback$1", "Landroid/content/ComponentCallbacks;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f13813a;

        d(AbstractDialogModal r1) {
            this.f13813a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r2) {
            Intrinsics.checkNotNullParameter(r2, "newConfig");
            if (this.f13813a.a() == false) goto L6;
            AbstractDialogModal.a(this.f13813a);
            this.f13813a.requestApplyInsets();
            return;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    static {
        f13808a = new a(null);
    }

    public AbstractDialogModal(Context r10, boolean r11, boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13);
        this.e = r11;
        this.f = r12;
        this.j = CloseIconStyle.DARK;
        this.l = true;
        this.m = true;
        this.v = true;
        this.I = new d(this);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setVisibility(8);
        View r4 = new View(r13);
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r4.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        r4.setAlpha(0.0f);
        r4.setVisibility(8);
        setDimView(r4);
        addView(getDimView());
        View r3 = ZeusTransformUtils.inflate(LayoutInflater.from(r13), getBaseLayoutRes(), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "from(context).inflate(ge…LayoutRes(), this, false)");
        setDialogRootView(r3);
        addView(getDialogRootView());
        if (ZeusTransformUtils.instanceOf(getDialogRootView().getBackground(), ColorDrawable.class) == false) goto L7;
        Drawable r5 = getDialogRootView().getBackground();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        int r6 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r5, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor();
    L5:
        this.t = r6;
    L14:
        getDialogRootView().setAlpha(0.0f);
        this.h = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_close, OaidModel.KEY_ID, "btn_close")), ImageView.class, "com.obric.memorydata.plugin");
        this.g = findViewById(ZeusTransformUtils.mapRes(R.id.close_container, OaidModel.KEY_ID, "close_container"));
        if (r12 == false) goto L17;
        View r14 = getDialogRootView();
        ViewGroup.LayoutParams r7 = getDialogRootView().getLayoutParams();
        r7.height = -1;
        r14.setLayoutParams(r7);
    L17:
        a(this, this.i, null, 2, null);
        ViewStub r15 = (ViewStub) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.contentView, OaidModel.KEY_ID, "contentView")), ViewStub.class, "com.obric.memorydata.plugin");
        r15.setLayoutResource(getLayout());
        View r16 = r15.inflate();
        Intrinsics.checkNotNullExpressionValue(r16, "viewStub.inflate()");
        setContentRootView(r16);
        if (l.a(r13) == true) goto L20;
    L22:
        boolean r17 = false;
    L23:
        this.s = r17;
        if (r17 == false) goto L35;
        getDialogRootView().setBackgroundColor(0);
        com.obric.oui.material.c[] r18 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!i.a(getDialogRootView()))), com.obric.oui.material.c[].class, "com.obric.memorydata.plugin");
        l.a(getDialogRootView(), r18, false, 0, null, 14, null);
        if (OMaterialHelper.b(r13) != 1) goto L28;
    L29:
        e r19 = r18[0].e();
        if (r19 == null) goto L35;
        if (ZeusTransformUtils.instanceOf(getDialogRootView(), DialogRootView.class) == false) goto L35;
        ((DialogRootView) ZeusTransformUtils.preCheckCast(getDialogRootView(), DialogRootView.class, "com.obric.memorydata.plugin")).setStroke(r19.b(), h.b(r13, r19.a()));
        goto L35
    L28:
        if (r18.length == 1) goto L29;
    L35:
        com.obric.oui.view.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), new $$Lambda$AbstractDialogModal$2KxXQL3kMrFsTyLz3gox4Os8UkQ(this));
        return;
    L20:
        if (OMaterialHelper.d() == false) goto L22;
        r17 = true;
        goto L23
    L7:
        if (ZeusTransformUtils.instanceOf(getDialogRootView().getBackground(), GradientDrawable.class) == false) goto L14;
        if (Build.VERSION.SDK_INT < 24) goto L14;
        Drawable r8 = getDialogRootView().getBackground();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ColorStateList r9 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r8, GradientDrawable.class, "com.obric.memorydata.plugin")).getColor();
        if (r9 != null) goto L13;
        r6 = 0;
        goto L5
    L13:
        r6 = r9.getDefaultColor();
        goto L5
    }

    private static final com.obric.oui.view.e a(AbstractDialogModal r0, View r1, com.obric.oui.view.e r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "insets");
        r0.a(r2);
        return r2;
    }

    private static final void a(View r1, AbstractDialogModal r2, ValueAnimator r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r1, "$modal");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r1.isAttachedToWindow() == false) goto L5;
        Object r5 = r4.getAnimatedValue();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        r2.G = Integer.valueOf(r6);
        r1.setTranslationY(r6);
        return;
    L5:
        r3.cancel();
    }

    public static final /* synthetic */ void a(AbstractDialogModal r0) {
        r0.f();
    }

    public static final /* synthetic */ void a(AbstractDialogModal r0, ValueAnimator r1) {
        r0.E = r1;
    }

    private static final void a(AbstractDialogModal r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.dismiss();
        View.OnClickListener r3 = r1.k;
        if (r3 == null) goto L7;
        r3.onClick(r2);
        return;
    }

    public static /* synthetic */ void a(AbstractDialogModal r1, CloseIconStyle r2, Integer r3, Integer r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.a(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    public static final /* synthetic */ void a(AbstractDialogModal r0, Integer r1) {
        r0.H = r1;
    }

    public static /* synthetic */ void a(AbstractDialogModal r2, boolean r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r7 = null;
    L7:
        r2.a(r3, r7);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    private final void a(com.obric.oui.view.e r9) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        boolean r1 = com.obric.oui.window.a.f(r0);
        int r10 = r9.a(com.obric.oui.view.e.m.a()).e;
        com.obric.oui.window.a r3 = com.obric.oui.window.a.f14878a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        boolean r5 = r3.g(r4);
        com.obric.oui.window.a r6 = com.obric.oui.window.a.f14878a;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        boolean r2 = r6.c(r7);
        boolean r8 = true;
        if (r2 == true) goto L7;
        if (r5 == true) goto L7;
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        int r12 = 0;
    L11:
        if (r1 == true) goto L15;
        if (r11 == true) goto L15;
        r8 = false;
    L15:
        int r13 = a(r8);
        if (r8 == true) goto L19;
        r13 = Math.max(r13, r12);
    L19:
        int r14 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin_to_ime, "dimen", "oui_dialog_layout_margin_to_ime"));
        com.obric.oui.c.a.b.a("AbstractDialogModal", Intrinsics.stringPlus("onApplyWindowInsets, update, imeBottom: ", Integer.valueOf(r10)));
        ViewGroup.LayoutParams r15 = getDialogRootView().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r15, ViewGroup.MarginLayoutParams.class) == false) goto L22;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L23:
        if (r16 != null) goto L26;
        return;
    L26:
        if (this.e == false) goto L29;
        r16.bottomMargin = 0;
        getDialogRootView().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        getDialogRootView().setTranslationY(0.0f);
        getDialogRootView().setPadding(getDialogRootView().getPaddingLeft(), getDialogRootView().getPaddingTop(), getDialogRootView().getPaddingRight(), r10);
        return;
    L29:
        if (r16.bottomMargin == r13) goto L31;
        r16.bottomMargin = r13;
        getDialogRootView().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L31:
        if (r10 <= 0) goto L37;
        int r17 = ((r10 + r12) + r14) - r16.bottomMargin;
        com.obric.oui.animation.easy.b<View> r18 = this.C;
        if (r18 == null) goto L36;
        r18.c();
    L36:
        a(-r17);
        return;
    L37:
        a(0);
        return;
    L22:
        r16 = null;
        goto L23
    L10:
        r12 = com.obric.oui.window.a.f14878a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L7:
        r11 = true;
        goto L8
    }

    private static final void b(AbstractDialogModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        o.b(r1.getDimView());
    }

    public static final /* synthetic */ void b(AbstractDialogModal r0, Integer r1) {
        r0.G = r1;
    }

    private static final void c(AbstractDialogModal r8) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        Size r0 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        ViewGroup.LayoutParams r2 = r8.getDialogRootView().getLayoutParams();
        Integer r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, FrameLayout.LayoutParams.class) == false) goto L5;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        int r5 = -2;
        if (r3 != null) goto L9;
        r3 = new FrameLayout.LayoutParams(-2, -2);
    L9:
        boolean r7 = false;
        if (r8.f == false) goto L17;
        if (r8.e == false) goto L14;
        int r1 = -1;
    L15:
        r3.width = r1;
        r3.height = -1;
        r3.gravity = 17;
        r3.bottomMargin = 0;
    L46:
        r8.getDialogRootView().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        r1 = r3.width;
        goto L15
    L17:
        if (r8.e == false) goto L25;
        r3.width = -1;
        Integer r6 = r8.x;
        if (r6 == null) goto L22;
        r5 = r6.intValue();
    L22:
        r3.height = r5;
        r3.gravity = 80;
        r3.bottomMargin = 0;
        if (ZeusTransformUtils.instanceOf(r8.getDialogRootView(), DialogRootView.class) == false) goto L46;
        float r9 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3, "dimen", "oui_r_l3"));
        ((DialogRootView) ZeusTransformUtils.preCheckCast(r8.getDialogRootView(), DialogRootView.class, "com.obric.memorydata.plugin")).setRadius(r9, r9, 0.0f, 0.0f);
        goto L46
    L25:
        int r10 = Math.min(r0.getWidth(), r0.getHeight()) - (r8.getLayoutMarginHorizontal() * 2);
        r3.width = r10;
        Integer r11 = r8.x;
        if (r11 != null) goto L28;
        int r12 = -2;
    L29:
        r3.height = r12;
        r3.gravity = 81;
        r8.getDialogRootView().measure(View.MeasureSpec.makeMeasureSpec(r10, Integer.MIN_VALUE), 0);
        if (r0.getWidth() >= r0.getHeight()) goto L46;
        int r13 = r0.getHeight();
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        int r15 = RangesKt.coerceAtLeast((r13 - h.a(r14, 232)) - r3.bottomMargin, 0);
        Integer r16 = r8.x;
        if (r16 != null) goto L34;
        Integer r17 = null;
    L35:
        if (r17 != null) goto L44;
        Integer r18 = Integer.valueOf(r15);
        if (r8.getDialogRootView().getMeasuredHeight() <= ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue()) goto L39;
        r7 = true;
    L39:
        if (r7 == false) goto L41;
        r4 = r18;
    L41:
        if (r4 == null) goto L45;
        r5 = r4.intValue();
    L45:
        r3.height = r5;
        goto L46
    L44:
        r5 = r17.intValue();
        goto L45
    L34:
        r17 = Integer.valueOf(RangesKt.coerceAtMost(r16.intValue(), r15));
        goto L35
    L28:
        r12 = r11.intValue();
        goto L29
    L5:
        r3 = null;
        goto L6
    }

    public static final /* synthetic */ void c(AbstractDialogModal r0, Integer r1) {
        r0.F = r1;
    }

    private final void f() {
        getDialogRootView().post(new $$Lambda$AbstractDialogModal$kcHXnOOj0CB_LErW5lu26PNvqEw(this));
    }

    private final void g() {
        if (this.z == true) goto L5;
        return;
    L5:
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).unregisterComponentCallbacks((ComponentCallbacks) ZeusTransformUtils.preCheckCast(this.I, ComponentCallbacks.class, "com.obric.memorydata.plugin"));
        this.z = false;
    }

    public static /* synthetic */ com.obric.oui.view.e lambda$2KxXQL3kMrFsTyLz3gox4Os8UkQ(AbstractDialogModal r0, View r1, com.obric.oui.view.e r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$9QvvOMqQueaFqsATRhQtFuhr90U(AbstractDialogModal r0) {
        b(r0);
    }

    /* JADX INFO: renamed from: lambda$N4N4cZYENc2jrDW6ggh-uF9sRR8, reason: not valid java name */
    public static /* synthetic */ void m1286lambda$N4N4cZYENc2jrDW6gghuF9sRR8(View r0, AbstractDialogModal r1, ValueAnimator r2, ValueAnimator r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$U-XJ1jdhTCvHG_cMxZcSqsZQur8, reason: not valid java name */
    public static /* synthetic */ void m1287lambda$UXJ1jdhTCvHG_cMxZcSqsZQur8(AbstractDialogModal r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$kcHXnOOj0CB_LErW5lu26PNvqEw(AbstractDialogModal r0) {
        c(r0);
    }

    public int a(boolean r3) {
        Context r2 = ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin");
        if (r3 == false) goto L5;
        Resources r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        int r5 = R.dimen.oui_dialog_layout_margin;
        String r1 = "oui_dialog_layout_margin";
    L7:
        return r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(r5, "dimen", r1));
    L5:
        r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        r5 = R.dimen.oui_dialog_layout_margin_with_three_button_mode;
        r1 = "oui_dialog_layout_margin_with_three_button_mode";
        goto L7
    }

    public final void a(int r6) {
        final View r0 = getDialogRootView();
        if (this.w == true) goto L6;
        this.D = true;
        return;
    L6:
        Integer r1 = this.G;
        if (r1 != null) goto L11;
        r1 = this.H;
        if (r1 != null) goto L11;
        int r2 = (int) r0.getTranslationY();
    L12:
        if (r2 != r6) goto L19;
        ValueAnimator r3 = this.E;
        if (r3 == null) goto L17;
        r3.cancel();
    L17:
        this.E = null;
        this.F = null;
        this.G = Integer.valueOf(r6);
        this.H = Integer.valueOf(r6);
        r0.setTranslationY(r6);
        return;
    L19:
        ValueAnimator r4 = this.E;
        if (r4 != null) goto L23;
    L21:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L32;
        Integer r7 = this.F;
        if (r7 == null) goto L32;
        if (r7.intValue() != r6) goto L32;
        return;
    L32:
        ValueAnimator r8 = this.E;
        if (r8 == null) goto L36;
        r8.cancel();
    L36:
        this.F = Integer.valueOf(r6);
        final ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r2, r6});
        r9.setDuration(200);
        r9.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(1.5f), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r9.addUpdateListener(new $$Lambda$AbstractDialogModal$N4N4cZYENc2jrDW6gghuF9sRR8(r0, this, r9));
        r9.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new c(this, r6), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        this.E = r9;
        if (r9 == null) goto L41;
        r9.start();
        return;
    L41:
        return;
    L23:
        if (r4.isRunning() != true) goto L21;
        r5 = true;
    L11:
        r2 = r1.intValue();
        goto L12
    }

    public final void a(CloseIconStyle r4, Integer r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r4, "style");
        this.j = r4;
        if (this.i == true) goto L5;
        return;
    L5:
        int r7 = b.f13810a[r4.ordinal()];
        if (r7 != 1) goto L8;
        int r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, TypedValues.Custom.S_COLOR, "ConstTextInverse");
        int r9 = R.color.ConstBGContainer7;
        String r10 = "ConstBGContainer7";
    L18:
        r6 = Integer.valueOf(ZeusTransformUtils.mapRes(r9, TypedValues.Custom.S_COLOR, r10));
    L19:
        ImageView r11 = this.h;
        if (r11 == null) goto L23;
        r11.setImageTintList(ContextCompat.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8));
    L23:
        GradientDrawable r12 = null;
        if (r6 != null) goto L29;
        View r3 = this.g;
        if (r3 == null) goto L41;
        r3.setBackground(null);
        return;
    L41:
        return;
    L29:
        View r13 = this.g;
        if (r13 != null) goto L32;
        Drawable r14 = null;
    L34:
        if (ZeusTransformUtils.instanceOf(r14, GradientDrawable.class) == false) goto L36;
        r12 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r14, GradientDrawable.class, "com.obric.memorydata.plugin");
    L36:
        if (r12 == null) goto L42;
        r12.setColor(ContextCompat.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6.intValue()));
        return;
    L42:
        return;
    L32:
        r14 = r13.getBackground();
        goto L34
    L8:
        if (r7 != 2) goto L10;
        r8 = ZeusTransformUtils.mapRes(R.color.TextReverse, TypedValues.Custom.S_COLOR, "TextReverse");
        r9 = R.color.ConstTextInverse5;
        r10 = "ConstTextInverse5";
        goto L18
    L10:
        if (r7 != 3) goto L15;
        if (r5 != null) goto L13;
        r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, TypedValues.Custom.S_COLOR, "ConstTextInverse");
        goto L19
    L13:
        r8 = r5.intValue();
        goto L19
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public void a(boolean r7, View.OnClickListener r8) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.i = r7;
        this.k = r9;
        ImageView r10 = this.h;
        if (r10 == null) goto L21;
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        o.a(r11, h.a(r0, 44));
        if (r7 == false) goto L15;
        View r12 = this.g;
        if (r12 == null) goto L11;
        o.a(r12);
    L11:
        a(this, this.j, null, null, 6, null);
        View r13 = this.g;
        if (r13 == null) goto L22;
        r13.setOnClickListener(new $$Lambda$AbstractDialogModal$UXJ1jdhTCvHG_cMxZcSqsZQur8(this));
        return;
    L22:
        return;
    L15:
        View r6 = this.g;
        if (r6 == null) goto L23;
        o.b(r6);
        return;
    L23:
        return;
    }

    public final boolean a() {
        return this.w;
    }

    public void b() {
        getDimView().animate().alpha(0.0f).setDuration(180).withEndAction(new $$Lambda$AbstractDialogModal$9QvvOMqQueaFqsATRhQtFuhr90U(this)).start();
        com.obric.oui.animation.easy.b<View> r0 = DialogAnimStyle.f13797a.a(getDialogRootView(), null, false, getUseNewDialogAnim());
        com.obric.oui.animation.easy.b.a(r0, null, (Function1) ZeusTransformUtils.preCheckCast(new AbstractDialogModal$performExitAnimation$2$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new AbstractDialogModal$performExitAnimation$2$2(this), Function1.class, "com.obric.memorydata.plugin"), 1, null);
        r0.b();
    }

    public void c() {
        if (this.w == true) goto L5;
        return;
    L5:
        this.w = false;
        this.u = false;
        e();
        g();
        DialogInterface.OnDismissListener r0 = this.n;
        if (r0 == null) goto L9;
        r0.onDismiss((DialogInterface) ZeusTransformUtils.preCheckCast(this, DialogInterface.class, "com.obric.memorydata.plugin"));
    L9:
        ViewParent r1 = getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L12;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
    L13:
        if (r2 == null) goto L16;
        r2.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L16:
        setVisibility(8);
        getDimView().setAlpha(0.0f);
        getDialogRootView().setAlpha(1.0f);
        getDialogRootView().setTranslationX(0.0f);
        getDialogRootView().setTranslationY(0.0f);
        return;
    L12:
        r2 = null;
        goto L13
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        if (this.m == true) goto L5;
        return;
    L5:
        DialogInterface.OnCancelListener r0 = this.o;
        if (r0 == null) goto L9;
        r0.onCancel((DialogInterface) ZeusTransformUtils.preCheckCast(this, DialogInterface.class, "com.obric.memorydata.plugin"));
    L9:
        dismiss();
    }

    public final void d() {
        this.u = false;
        this.C = null;
        DialogInterface.OnShowListener r0 = this.q;
        if (r0 == null) goto L7;
        r0.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this, DialogInterface.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        if (this.w == true) goto L5;
        return;
    L5:
        e();
        b();
    }

    public final void e() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f14878a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        Window.Callback r3 = this.A;
        if (r3 != null) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin").getCallback() != this.B) goto L11;
        ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin").setCallback(r3);
    L11:
        this.B = null;
        this.A = null;
    }

    public int getBaseLayoutRes() {
        if (this.f == false) goto L5;
        int r2 = R.layout.o_base_dialog_with_match_parent_height;
        String r1 = "o_base_dialog_with_match_parent_height";
    L7:
        return ZeusTransformUtils.mapRes(r2, "layout", r1);
    L5:
        r2 = R.layout.o_base_dialog;
        r1 = "o_base_dialog";
        goto L7
    }

    public final int getBgColor() {
        return this.t;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.q;
    }

    public final View getContentRootView() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentRootView");
        return null;
    }

    public final View getDialogRootView() {
        View r0 = this.f13809b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dialogRootView");
        return null;
    }

    public final View getDimView() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    public final boolean getEnableMaterial() {
        return this.s;
    }

    public final boolean getHideFirstFrame() {
        return this.r;
    }

    public abstract int getLayout();

    public int getLayoutMarginHorizontal() {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin, "dimen", "oui_dialog_layout_margin"));
    }

    public final boolean getMCancelable() {
        return this.m;
    }

    public final boolean getMatchParentHeight() {
        return this.f;
    }

    public final boolean getShowAnimRunning() {
        return this.u;
    }

    public boolean getUseNewDialogAnim() {
        return this.v;
    }

    public final boolean getWidthMatch() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        g();
    }

    public final void setAutoDismiss(boolean r1) {
        this.l = r1;
    }

    public final void setBgColor(int r1) {
        this.t = r1;
    }

    public void setCancelable(boolean r1) {
        this.m = r1;
    }

    public final void setCanceledOnTouchOutside(boolean r1) {
        setCancelable(r1);
    }

    public final void setCompleteShowListener(DialogInterface.OnShowListener r3) {
        this.q = (DialogInterface.OnShowListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnShowListener.class, "com.obric.memorydata.plugin");
    }

    public final void setContentRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setDialogRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13809b = r2;
    }

    public final void setDimView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setEnableMaterial(boolean r1) {
        this.s = r1;
    }

    public final void setHideFirstFrame(boolean r1) {
        this.r = r1;
    }

    public final void setIncludeCutoutInLandscape(Boolean r1) {
        this.y = r1;
    }

    public final void setMCancelable(boolean r1) {
        this.m = r1;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r3) {
        this.o = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r3) {
        this.n = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
    }

    public final void setOnShowListener(DialogInterface.OnShowListener r3) {
        this.p = (DialogInterface.OnShowListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnShowListener.class, "com.obric.memorydata.plugin");
    }

    public final void setRootFixedHeight(Integer r4) {
        if (r4 != null) goto L6;
    L4:
        r4 = null;
    L10:
        this.x = r4;
        return;
    L6:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L8:
        r1 = false;
        goto L9
    }

    public final void setShowAnimRunning(boolean r1) {
        this.u = r1;
    }

    public final void setShowingModal(boolean r1) {
        this.w = r1;
    }

    public void setUseNewDialogAnim(boolean r1) {
        this.v = r1;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.b
    public boolean t() {
        return this.l;
    }
}
