package com.obric.oui.dialog.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.i;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.l;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)*\u00014\b&\u0018\u0000 ¡\u00012\u00020\u00012\u00020\u0002:\u0006 \u0001¡\u0001¢\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020`J\u0010\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020\u0012H\u0004J-\u0010c\u001a\u00020`2\u0006\u0010d\u001a\u00020\u001c2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010gJ\b\u0010h\u001a\u00020`H\u0002J\b\u0010i\u001a\u00020`H\u0002J\b\u0010j\u001a\u00020`H\u0002J\u0010\u0010k\u001a\u00020`2\u0006\u0010l\u001a\u00020\u0006H\u0002J\b\u0010m\u001a\u00020`H\u0002J\b\u0010n\u001a\u00020`H\u0016J\u0018\u0010o\u001a\u00020`2\u0006\u0010p\u001a\u00020\u00192\u0006\u0010l\u001a\u00020\u0006H\u0002J\u0006\u0010q\u001a\u00020`J\n\u0010r\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010s\u001a\u00020\u0012H&J\u0010\u0010t\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u0006H\u0002J\u0010\u0010v\u001a\u00020w2\u0006\u0010\u0003\u001a\u00020\u0004H\u0004J\u0012\u0010x\u001a\u00020`2\b\u0010y\u001a\u0004\u0018\u00010zH\u0002J\b\u0010{\u001a\u00020\u0006H\u0016J\u0006\u0010|\u001a\u00020\u0006J\b\u0010}\u001a\u00020`H\u0014J\u0010\u0010~\u001a\u00020`2\u0006\u0010\u007f\u001a\u00020OH\u0002J\t\u0010\u0080\u0001\u001a\u00020`H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020`2\u0006\u0010\u007f\u001a\u00020OH\u0002J\u0010\u0010\u0082\u0001\u001a\u00020`2\u0007\u0010\u0083\u0001\u001a\u00020\u0006J\u001f\u0010\u0084\u0001\u001a\u00020`2\u0007\u0010\u0083\u0001\u001a\u00020\u00062\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010LH\u0016J\u001a\u0010\u0086\u0001\u001a\u00020`2\u0006\u0010p\u001a\u00020\u00192\u0007\u0010\u0087\u0001\u001a\u00020\u0012H\u0002J\u0018\u0010\u0088\u0001\u001a\u00020\u00002\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0003\u0010\u008a\u0001J\t\u0010\u008b\u0001\u001a\u00020`H\u0002J\u0010\u0010\u008c\u0001\u001a\u00020`2\u0007\u0010\u0083\u0001\u001a\u00020\u0006J\u0010\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u0012J\u0010\u0010\u008f\u0001\u001a\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020\u0012J\u001d\u0010\u0091\u0001\u001a\u00020\u00002\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u00122\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0012J\u001d\u0010\u0094\u0001\u001a\u00020\u00002\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u00122\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0012J\t\u0010\u0097\u0001\u001a\u00020`H\u0002J\t\u0010\u0098\u0001\u001a\u00020`H\u0017J#\u0010\u0099\u0001\u001a\u00020`2\u0006\u0010p\u001a\u00020\u00192\u0007\u0010\u009a\u0001\u001a\u00020\u00122\u0007\u0010\u009b\u0001\u001a\u00020\u0012H\u0002J\u001a\u0010\u009c\u0001\u001a\u00020`2\u0006\u0010p\u001a\u00020\u00192\u0007\u0010\u009d\u0001\u001a\u00020\u0006H\u0014J\u001a\u0010\u009e\u0001\u001a\u00020`2\u0006\u0010p\u001a\u00020\u00192\u0007\u0010\u009d\u0001\u001a\u00020\u0006H\u0002J\r\u0010\u009f\u0001\u001a\u00020\u0012*\u00020zH\u0014R\u0010\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0004\n\u0002\b\u000bR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0019X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u000e\u0010,\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\u000e\u0010A\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u001a\u0010D\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0012\u0010I\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u000eR\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010P\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u001a\u0010Q\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010%\"\u0004\bS\u0010'R\u001a\u0010T\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000e\"\u0004\bV\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u000eR\u000e\u0010X\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\\\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u0012\u0010]\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006£\u0001"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog;", "Landroid/app/Dialog;", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "context", "Landroid/content/Context;", "widthMatch", "", "matchParentHeight", "(Landroid/content/Context;ZZ)V", "TAG", "", "TAG$1", "adaptWindowDim", "getAdaptWindowDim", "()Z", "setAdaptWindowDim", "(Z)V", "animExpectedHeight", "", "autoDismissOnButtonClick", "bgColor", "cancelRestoreToWrapOnCancel", "closeIcon", "Landroid/widget/ImageView;", "closeIconContainer", "Landroid/view/View;", "closeIconEnabled", "closeIconStyle", "Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "completeShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getCompleteShowListener", "()Landroid/content/DialogInterface$OnShowListener;", "setCompleteShowListener", "(Landroid/content/DialogInterface$OnShowListener;)V", "contentRootView", "getContentRootView", "()Landroid/view/View;", "setContentRootView", "(Landroid/view/View;)V", "currentAnimContainer", "enableLayoutHeightChangeAnim", "getEnableLayoutHeightChangeAnim", "setEnableLayoutHeightChangeAnim", "enableMaterial", "fixedWindowHeightPx", "getFixedWindowHeightPx", "()Ljava/lang/Integer;", "setFixedWindowHeightPx", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "handler", "com/obric/oui/dialog/base/AbstractDialog$handler$1", "Lcom/obric/oui/dialog/base/AbstractDialog$handler$1;", "heightAnimProgrammaticChange", "heightAnimRunning", "heightAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "heightLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "heightPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "hideFirstFrame", "getHideFirstFrame", "setHideFirstFrame", "imeVisible", "includeCutoutInLandscape", "Ljava/lang/Boolean;", "insetsBaseYOffsetPx", "getInsetsBaseYOffsetPx", "()I", "setInsetsBaseYOffsetPx", "(I)V", "lastAppliedWindowYPx", "getMatchParentHeight", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "pendingApplyWindowPosition", "pendingHeightChange", "Lcom/obric/oui/dialog/base/AbstractDialog$HeightChange;", "pendingTargetHeightWhileAnimating", "rootView", "getRootView", "setRootView", "showAnimRunning", "getShowAnimRunning", "setShowAnimRunning", "getWidthMatch", "windowGravity", "windowLockedMinHeightPx", "windowOffsetXPx", "windowOffsetYPx", "windowYAnimCurrentPx", "windowYAnimTargetPx", "windowYAnimator", "Landroid/animation/ValueAnimator;", "", "animateWindowYTo", "targetYPx", "applyCloseIconStyle", "style", "customIconColor", "customIconBgColor", "(Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "applyWindowGravityAndXIfNeeded", "applyWindowHeightIfNeeded", "applyWindowPositionIfNeeded", "cancelHeightAnimatorIfNeeded", "restoreToWrapContent", "cleanupRootHeightAnim", "dismiss", "finishHeightAnim", "container", "forceHideFirstFrame", "getHeightChangeAnimContainer", "getLayout", "getLayoutMarginBottom", "excludeThreeButtonsNaviBar", "getTargetWindowDimAmount", "", "hideAndTransparentNavigationBar", "window", "Landroid/view/Window;", "isAutoDismiss", "isDarkTheme", "onStop", "prepareAndStartHeightAnim", "change", "recheckInset", "scheduleHeightAnim", "setAutoDismiss", "enabled", "setCloseIconEnabled", "listener", "setContainerFixedHeight", "height", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/dialog/base/AbstractDialog;", "setOnApplyWindowInsetsListener", "setRootHeightChangeAnimEnabled", "setWindowFixedHeight", "heightPx", "setWindowGravity", "gravity", "setWindowOffset", "xPx", "yPx", "setWindowOffsetDp", "xDp", "yDp", "setupRootHeightChangeAnimIfNeeded", "show", "startHeightAnimator", "fromHeight", "toHeight", "suppressHeightAnimContainerChildren", "suppress", "suppressInternalLayout", "getLayoutMarginHorizontal", "CloseIconStyle", "Companion", "HeightChange", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractDialog extends Dialog implements com.obric.oui.dialog.v2.alert.style.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13799a = null;
    private boolean A;
    private DialogInterface.OnShowListener B;
    private Integer C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private Boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f13800J;
    private boolean K;
    private ValueAnimator L;
    private Integer M;
    private Integer N;
    private Integer O;
    private final View.OnLayoutChangeListener P;
    private final e Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f13801b;
    protected View c;
    private final boolean d;
    private final boolean e;
    private final String f;
    private View g;
    private ImageView h;
    private boolean i;
    private int j;
    private CloseIconStyle k;
    private View.OnClickListener l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private com.obric.common.oea.foundation.animation.d.d r;
    private ViewTreeObserver.OnPreDrawListener s;
    private b t;
    private boolean u;
    private boolean v;
    private Integer w;
    private int x;
    private boolean y;
    private View z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$Companion;", "", "()V", "HORIZONTAL_MAX_HEIGHT", "", "HORIZONTAL_MAX_WIDTH", "HORIZONTAL_TOP_SYSBAR_HEIGHT", "MSG_RECHECK_INSET", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$HeightChange;", "", "container", "Landroid/view/View;", "fromHeight", "", "toHeight", "rootFromHeight", "rootToHeight", "(Landroid/view/View;IIII)V", "getContainer", "()Landroid/view/View;", "getFromHeight", "()I", "getRootFromHeight", "getRootToHeight", "getToHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f13802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13803b;
        private final int c;
        private final int d;
        private final int e;

        public b(View r2, int r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.f13802a = r2;
            this.f13803b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final View a() {
            return this.f13802a;
        }

        public final int b() {
            return this.f13803b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13802a, r6.f13802a) == true) goto L12;
            return false;
        L12:
            if (this.f13803b == r6.f13803b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f13802a.hashCode() * 31) + Integer.hashCode(this.f13803b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "HeightChange(container=" + this.f13802a + ", fromHeight=" + this.f13803b + ", toHeight=" + this.c + ", rootFromHeight=" + this.d + ", rootToHeight=" + this.e + ')';
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13804a = null;

        static {
            int[] r0 = new int[CloseIconStyle.values().length];
            r0[CloseIconStyle.DARK.ordinal()] = 1;
            r0[CloseIconStyle.LIGHT.ordinal()] = 2;
            r0[CloseIconStyle.CUSTOM.ordinal()] = 3;
            f13804a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/dialog/base/AbstractDialog$animateWindowYTo$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f13805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13806b;

        d(AbstractDialog r1, int r2) {
            this.f13805a = r1;
            this.f13806b = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            AbstractDialog.d(this.f13805a, null);
            AbstractDialog.a(this.f13805a, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            AbstractDialog.b(this.f13805a, Integer.valueOf(this.f13806b));
            AbstractDialog.c(this.f13805a, Integer.valueOf(this.f13806b));
            AbstractDialog.d(this.f13805a, null);
            AbstractDialog.a(this.f13805a, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/oui/dialog/base/AbstractDialog$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f13807a;

        e(AbstractDialog r1, Looper r2) {
            this.f13807a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(r2);
            if (r2.what != 101) goto L6;
            AbstractDialog.g(this.f13807a);
            return;
        }
    }

    static {
        f13799a = new a(null);
    }

    public AbstractDialog(Context r12, boolean r13, boolean r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "context");
        super(r15);
        this.d = r13;
        this.e = r14;
        this.f = "AbstractDialog";
        this.k = CloseIconStyle.DARK;
        this.o = true;
        this.x = -1;
        this.y = true;
        this.E = 81;
        Window r2 = getWindow();
        if (r2 == null) goto L6;
        r2.requestFeature(1);
    L6:
        Window r3 = getWindow();
        if (r3 == null) goto L11;
        r3.addFlags(512);
    L11:
        if (r14 == false) goto L13;
        int r4 = R.layout.o_base_dialog_with_match_parent_height;
        String r5 = "o_base_dialog_with_match_parent_height";
    L14:
        setContentView(ZeusTransformUtils.mapRes(r4, "layout", r5));
        View r6 = findViewById(android.R.id.content);
        if (r6 == null) goto L18;
        r6.setOnClickListener(new $$Lambda$AbstractDialog$1wrhkOs4QllInPEnAmVyO9J0FnQ(this));
    L18:
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.root_view, OaidModel.KEY_ID, "root_view"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.root_view)");
        a(r7);
        j().setOnClickListener($$Lambda$AbstractDialog$kGUZyEOgBD_DjZRLozeTIPVyVg.INSTANCE);
        if (ZeusTransformUtils.instanceOf(j().getBackground(), ColorDrawable.class) == false) goto L23;
        Drawable r8 = j().getBackground();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        int r9 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r8, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor();
    L21:
        this.j = r9;
    L31:
        j().setAlpha(0.0f);
        this.h = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_close, OaidModel.KEY_ID, "btn_close")), ImageView.class, "com.obric.memorydata.plugin");
        this.g = findViewById(ZeusTransformUtils.mapRes(R.id.close_container, OaidModel.KEY_ID, "close_container"));
        if (r14 == false) goto L34;
        View r16 = j();
        ViewGroup.LayoutParams r10 = j().getLayoutParams();
        r10.height = -1;
        r16.setLayoutParams(r10);
    L34:
        a(this, this.i, null, 2, null);
        ViewStub r17 = (ViewStub) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.contentView, OaidModel.KEY_ID, "contentView")), ViewStub.class, "com.obric.memorydata.plugin");
        r17.setLayoutResource(a());
        View r18 = r17.inflate();
        Intrinsics.checkNotNullExpressionValue(r18, "viewStub.inflate()");
        b(r18);
        DialogAnimStyle.f13797a.a(j());
        if (l.a(r15) == true) goto L37;
    L39:
        boolean r19 = false;
    L40:
        this.p = r19;
        if (r19 == false) goto L52;
        j().setBackgroundColor(0);
        com.obric.oui.material.c[] r110 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!i.a(j()))), com.obric.oui.material.c[].class, "com.obric.memorydata.plugin");
        l.a(j(), r110, false, null, 6, null);
        if (OMaterialHelper.b(r15) != 1) goto L45;
    L46:
        com.obric.oui.color.e r111 = r110[0].e();
        if (r111 == null) goto L52;
        if (ZeusTransformUtils.instanceOf(j(), DialogRootView.class) == false) goto L52;
        ((DialogRootView) ZeusTransformUtils.preCheckCast(j(), DialogRootView.class, "com.obric.memorydata.plugin")).setStroke(r111.b(), h.b(r15, r111.a()));
        goto L52
    L45:
        if (r110.length == 1) goto L46;
    L52:
        this.P = new $$Lambda$AbstractDialog$lOY5_Q_TMSwNHWkFYNnws_b2VAU(this);
        this.Q = new e(this, Looper.getMainLooper());
        return;
    L37:
        if (OMaterialHelper.d() == false) goto L39;
        r19 = true;
        goto L40
    L23:
        if (ZeusTransformUtils.instanceOf(j().getBackground(), GradientDrawable.class) == true) goto L25;
    L30:
        this.j = 0;
        goto L31
    L25:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        Drawable r11 = j().getBackground();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ColorStateList r20 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r11, GradientDrawable.class, "com.obric.memorydata.plugin")).getColor();
        if (r20 != null) goto L29;
        r9 = 0;
        goto L21
    L29:
        r9 = r20.getDefaultColor();
        goto L21
    L13:
        r4 = R.layout.o_base_dialog;
        r5 = "o_base_dialog";
        goto L14
    }

    public static final /* synthetic */ int a(AbstractDialog r0) {
        return r0.E;
    }

    private static final WindowInsets a(AbstractDialog r12, View r13, WindowInsets r14) {
        Intrinsics.checkNotNullParameter(r12, "this$0");
        Intrinsics.checkNotNullParameter(r13, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r14, "insets");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        int r0 = r14.getInsets(WindowInsets.Type.ime()).bottom;
        int r2 = com.obric.oui.window.a.f14878a.a(r12.j());
        com.obric.oui.c.a.b.c(r12.f, "onApplyWindowInsets-start, lastImeVisible: " + r12.H + ", nowImeVisible: " + r14.isVisible(WindowInsets.Type.ime()) + "，imeHeightFromInsets: " + r0 + ", imeHeightFromHideApi: " + r2);
    L5:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "v.context");
        boolean r3 = com.obric.oui.window.a.f(r1);
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f14878a;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        boolean r6 = r4.g(r5);
        com.obric.oui.window.a r7 = com.obric.oui.window.a.f14878a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        boolean r9 = r7.c(r8);
        boolean r10 = true;
        if (r9 == true) goto L10;
        if (r6 == true) goto L10;
        boolean r11 = false;
    L11:
        if (r11 == false) goto L13;
        int r15 = 0;
    L14:
        if (r3 == true) goto L18;
        if (r11 == true) goto L18;
        r10 = false;
    L18:
        int r16 = r12.c(r10);
        if (r10 == true) goto L22;
        r16 = Math.max(r16, r15);
    L22:
        int r17 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin_to_ime, "dimen", "oui_dialog_layout_margin_to_ime"));
        View r18 = r12.j();
        ViewGroup.LayoutParams r19 = r12.j().getLayoutParams();
        com.obric.oui.c.a.b.a(r12.f, "onApplyWindowInsets, bottomMargin: " + r16 + " systemBarHeight: " + r15);
        if (ZeusTransformUtils.instanceOf(r19, ViewGroup.MarginLayoutParams.class) == false) goto L25;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L26:
        if (r20 == null) goto L29;
        r20.bottomMargin = r16;
    L29:
        r18.setLayoutParams(r19);
        if (Build.VERSION.SDK_INT < 30) goto L49;
        boolean r21 = r14.isVisible(WindowInsets.Type.ime());
        if (r12.H == r21) goto L49;
        r12.H = r21;
        int r22 = Math.max(r14.getInsets(WindowInsets.Type.ime()).bottom, com.obric.oui.window.a.f14878a.a(r12.j()));
        com.obric.oui.c.a.b.a(r12.f, "onApplyWindowInsets, systemBarHeight: " + r15 + ", imeHeight: " + r22);
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r23, "context");
        if (r22 >= h.b(r23)) goto L49;
        if (r22 > 0) goto L38;
        r12.f13800J = 0;
        if (r12.d == false) goto L44;
        Context r110 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r110, "context");
        int r24 = r15 - h.a(r110, 16);
        r12.j().setPadding(0, 0, 0, r24);
        String r111 = r12.f;
        String r25 = Intrinsics.stringPlus("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r24));
    L46:
        com.obric.oui.c.a.b.a(r111, r25);
    L47:
        r12.b(r12.f13800J + r12.G);
        goto L49
    L44:
        r111 = r12.f;
        Integer r26 = Integer.valueOf(r15);
    L45:
        r25 = Intrinsics.stringPlus("onApplyWindowInsets, update, insetsBaseYOffsetPx: ", r26);
        goto L46
    L38:
        if (r12.d == false) goto L40;
        r13.setPadding(0, 0, 0, r22);
        com.obric.oui.c.a.b.a(r12.f, Intrinsics.stringPlus("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r22)));
        r12.f13800J = 0;
        goto L47
    L40:
        r12.f13800J = (r22 - r16) + r17;
        r111 = r12.f;
        r26 = Integer.valueOf(r22);
    L49:
        return r14.consumeSystemWindowInsets();
    L25:
        r20 = null;
        goto L26
    L13:
        r15 = com.obric.oui.window.a.f14878a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L10:
        r11 = true;
        goto L11
    }

    private final void a(View r2, int r3) {
        this.u = true;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.height = r3;
        r2.setLayoutParams(r0);
        this.u = false;
    }

    private final void a(final View r9, int r10, int r11) {
        if (this.q == true) goto L5;
        return;
    L5:
        if (this.e == false) goto L8;
        return;
    L8:
        if (isShowing() == true) goto L11;
        return;
    L11:
        if (r10 != r11) goto L14;
        b(r9, true);
        return;
    L14:
        this.v = true;
        this.w = null;
        this.z = r9;
        com.obric.common.oea.foundation.animation.builder.c.a r1 = new com.obric.common.oea.foundation.animation.builder.c.a();
        float r2 = r10;
        float r3 = r11;
        com.obric.common.oea.foundation.animation.spec.spring.b r12 = com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null);
        r12.a(0.3f);
        Unit r13 = Unit.INSTANCE;
        this.r = com.obric.common.oea.foundation.animation.builder.c.a.a(r1, r2, r3, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r12, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new AbstractDialog$startHeightAnimator$2(this, r9), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new AbstractDialog$startHeightAnimator$3(this, r9), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    private static final void a(Window r1, AbstractDialog r2, ValueAnimator r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r1, "$w");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r1.getDecorView().isAttachedToWindow() == false) goto L5;
        Object r5 = r4.getAnimatedValue();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        r2.N = Integer.valueOf(r6);
        WindowManager.LayoutParams r7 = r1.getAttributes();
        r7.y = r6;
        r1.setAttributes(r7);
        return;
    L5:
        r3.cancel();
    }

    private final void a(b r2) {
        this.t = r2;
        if (this.s != null) goto L5;
        this.s = new $$Lambda$AbstractDialog$nxpIOBcoKFYdBgId74XcWXSTXLQ(this);
    L5:
        ViewTreeObserver.OnPreDrawListener r1 = this.s;
        if (r1 == null) goto L13;
        ViewTreeObserver r3 = r2.a().getViewTreeObserver();
        if (r3.isAlive() == false) goto L12;
        r3.removeOnPreDrawListener(r1);
        r3.addOnPreDrawListener(r1);
        return;
    L12:
        return;
    }

    public static final /* synthetic */ void a(AbstractDialog r0, int r1) {
        r0.x = r1;
    }

    public static final /* synthetic */ void a(AbstractDialog r0, ValueAnimator r1) {
        r0.L = r1;
    }

    private static final void a(AbstractDialog r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.dismiss();
    }

    public static final /* synthetic */ void a(AbstractDialog r0, View r1, int r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(AbstractDialog r0, View r1, int r2, int r3) {
        r0.a(r1, r2, r3);
    }

    private static final void a(AbstractDialog r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.q == true) goto L6;
        return;
    L6:
        if (r0.e == false) goto L9;
        return;
    L9:
        if (r0.u == false) goto L11;
        return;
    L11:
        int r10 = r5 - r3;
        int r11 = r9 - r7;
        if (r10 <= 0) goto L30;
        if (r11 <= 0) goto L31;
        if (r10 == r11) goto L32;
        int r12 = r10 - r11;
        int r13 = r0.j().getHeight();
        if (r13 <= 0) goto L19;
        int r14 = Math.max(1, r13 - r12);
    L21:
        if (r0.v == false) goto L28;
        int r15 = r0.x;
        if (r15 <= 0) goto L26;
        if (r10 != r15) goto L26;
        return;
    L26:
        r0.w = Integer.valueOf(r10);
        return;
    L28:
        Intrinsics.checkNotNullExpressionValue(r1, BaseSwitches.V);
        r0.a(new b(r1, r11, r10, r14, r13));
        return;
    L19:
        r14 = r13;
        goto L21
    L32:
        return;
    L31:
        return;
    }

    public static final /* synthetic */ void a(AbstractDialog r0, View r1, boolean r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void a(AbstractDialog r1, CloseIconStyle r2, Integer r3, Integer r4, int r5, Object r6) {
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

    private static final void a(AbstractDialog r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$change");
        r2.a(r3.a(), r3.b(), r3.c());
    }

    public static final /* synthetic */ void a(AbstractDialog r0, Integer r1) {
        r0.w = r1;
    }

    public static /* synthetic */ void a(AbstractDialog r2, boolean r3, View.OnClickListener r4, int r5, Object r6) {
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

    public static final /* synthetic */ int b(AbstractDialog r0) {
        return r0.F;
    }

    private final void b() {
        final Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        ((Function0) ZeusTransformUtils.preCheckCast(new AbstractDialog$applyWindowPositionIfNeeded$apply$1(r0, this), Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private final void b(View r3, boolean r4) {
        this.v = false;
        this.x = -1;
        this.z = null;
        if (r4 == false) goto L5;
        this.u = true;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        r5.height = -2;
        r3.setLayoutParams(r5);
        this.u = false;
        r3.requestLayout();
    L5:
        c(r3, false);
    }

    private final void b(Window r3) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r3 == null) goto L7;
        r3.setNavigationBarContrastEnforced(false);
    L7:
        if (r3 == null) goto L10;
        r3.clearFlags(134217728);
    L10:
        if (r3 == null) goto L13;
        r3.addFlags(Integer.MIN_VALUE);
    L13:
        if (r3 == null) goto L17;
        r3.setNavigationBarColor(0);
    L17:
        if (Build.VERSION.SDK_INT < 30) goto L25;
        if (r3 == null) goto L21;
        r3.setDecorFitsSystemWindows(false);
    L21:
        if (r3 == null) goto L26;
        r3.setNavigationBarDividerColor(0);
        return;
    L26:
        return;
    }

    private final void b(final b r3) {
        if (r3.b() > 0) goto L5;
        return;
    L5:
        if (r3.c() > 0) goto L7;
        return;
    L7:
        if (r3.b() == r3.c()) goto L13;
        b(false);
        this.v = true;
        this.x = r3.b();
        this.z = r3.a();
        c(r3.a(), true);
        a(r3.a(), r3.b());
        r3.a().requestLayout();
        r3.a().post(new $$Lambda$AbstractDialog$ySXaanDYbBLvTX7EJWWxMgXRpoU(this, r3));
        return;
    }

    private static final void b(AbstractDialog r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.dismiss();
        View.OnClickListener r3 = r1.l;
        if (r3 == null) goto L7;
        r3.onClick(r2);
        return;
    }

    public static final /* synthetic */ void b(AbstractDialog r0, Integer r1) {
        r0.O = r1;
    }

    private final void b(boolean r4) {
        com.obric.common.oea.foundation.animation.d.d r0 = this.r;
        if (r0 == null) goto L7;
        this.y = r4;
        com.obric.common.oea.foundation.animation.d.d.a(r0, false, 1, null);
        this.y = true;
        this.r = null;
        return;
    }

    public static final /* synthetic */ int c(AbstractDialog r0) {
        return r0.G;
    }

    private final int c(boolean r3) {
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

    private final void c() {
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (this.e == false) goto L8;
        return;
    L8:
        Window r0 = getWindow();
        if (r0 != null) goto L11;
        return;
    L11:
        WindowManager.LayoutParams r1 = r0.getAttributes();
        Integer r2 = this.C;
        if (r2 == null) goto L20;
        if (r2.intValue() <= 0) goto L20;
        if (r1.height == r2.intValue()) goto L25;
        r1.height = r2.intValue();
        r0.setAttributes(r1);
        return;
    L25:
        return;
    L20:
        if (this.D <= 0) goto L26;
        int r3 = r1.height;
        int r4 = this.D;
        if (r3 == r4) goto L27;
        r1.height = r4;
        r0.setAttributes(r1);
        return;
    L27:
        return;
    }

    private static final void c(View r0) {
    }

    private final void c(View r1, boolean r2) {
        a(r1, r2);
    }

    public static final /* synthetic */ void c(AbstractDialog r0, Integer r1) {
        r0.N = r1;
    }

    public static final /* synthetic */ int d(AbstractDialog r0) {
        return r0.x;
    }

    private final void d() {
        if (this.e == false) goto L5;
        return;
    L5:
        View r0 = q();
        if (r0 != null) goto L8;
        return;
    L8:
        r0.removeOnLayoutChangeListener(this.P);
        r0.addOnLayoutChangeListener(this.P);
    }

    public static final /* synthetic */ void d(AbstractDialog r0, Integer r1) {
        r0.M = r1;
    }

    public static final /* synthetic */ Integer e(AbstractDialog r0) {
        return r0.w;
    }

    private final void e() {
        View r0 = this.z;
        if (r0 != null) goto L5;
        r0 = q();
    L5:
        b(true);
        if (r0 != null) goto L8;
    L10:
        if (r0 == null) goto L12;
        c(r0, false);
    L12:
        this.t = null;
        this.w = null;
        View r1 = q();
        if (r1 != null) goto L15;
        ViewTreeObserver r3 = null;
    L16:
        ViewTreeObserver.OnPreDrawListener r4 = this.s;
        if (r1 == null) goto L23;
        if (r4 == null) goto L23;
        if (r3 == null) goto L23;
        if (r3.isAlive() == false) goto L23;
        r3.removeOnPreDrawListener(r4);
    L23:
        this.s = null;
        if (r1 == null) goto L28;
        r1.removeOnLayoutChangeListener(this.P);
    L28:
        if (this.C != null) goto L31;
        this.D = 0;
        return;
    L31:
        return;
    L15:
        r3 = r1.getViewTreeObserver();
        goto L16
    L8:
        if (this.v == false) goto L10;
        b(r0, true);
        goto L12
    }

    private final void f() {
        j().setOnApplyWindowInsetsListener(new $$Lambda$AbstractDialog$oCSgknDh3lhaTFHFAxkUQp0fGY0(this));
    }

    public static final /* synthetic */ boolean f(AbstractDialog r0) {
        return r0.y;
    }

    private final void g() {
    L21:
        e = move-exception;
        com.obric.oui.c.a.b.a(this.f, "recheckInset failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L6;
        int r1 = com.obric.oui.window.a.f14878a.a(j());     // Catch: Exception -> L21
    L7:
        if (r1 <= 0) goto L9;
        return;
    L9:
        if (this.d == false) goto L27;
        com.obric.oui.c.c r2 = com.obric.oui.c.c.f13403a;     // Catch: Exception -> L21
        ViewParent r3 = j().getParent();     // Catch: Exception -> L21
        if (r3 != null) goto L14;
    L12:
        r3 = null;
    L15:
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
        if (r4 != null) goto L18;
        return;
    L18:
        if (r4.getHeight() <= j().getHeight()) goto L29;
        j().requestLayout();     // Catch: Exception -> L21
        com.obric.oui.c.a.b.a(this.f, "recheckInset, requestLayout, parentView.height: " + r4.getHeight() + ", rootView.height: " + j().getHeight());     // Catch: Exception -> L21
        return;
    L29:
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L12;
    L27:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public static final /* synthetic */ void g(AbstractDialog r0) {
        r0.g();
    }

    private static final boolean h(AbstractDialog r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        b r0 = r5.t;
        r5.t = null;
        if (r0 != null) goto L5;
        View r2 = null;
    L6:
        if (r2 != null) goto L8;
        r2 = r5.q();
    L8:
        if (r2 != null) goto L10;
        ViewTreeObserver r3 = null;
    L11:
        ViewTreeObserver.OnPreDrawListener r4 = r5.s;
        if (r4 == null) goto L17;
        if (r3 == null) goto L17;
        if (r3.isAlive() == false) goto L17;
        r3.removeOnPreDrawListener(r4);
    L17:
        r5.s = null;
        if (r0 != null) goto L21;
        return true;
    L21:
        if (r5.isShowing() == true) goto L23;
        return true;
    L23:
        r5.b(r0);
        return false;
    L10:
        r3 = r2.getViewTreeObserver();
        goto L11
    L5:
        r2 = r0.a();
        goto L6
    }

    public static /* synthetic */ void lambda$1wrhkOs4QllInPEnAmVyO9J0FnQ(AbstractDialog r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Po5sIKM5Ws9iO0pgDGpohfc1s-w, reason: not valid java name */
    public static /* synthetic */ void m1283lambda$Po5sIKM5Ws9iO0pgDGpohfc1sw(AbstractDialog r0, View r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$f8hjT7_PjTk0GNB580ExewPW-OE, reason: not valid java name */
    public static /* synthetic */ void m1284lambda$f8hjT7_PjTk0GNB580ExewPWOE(Window r0, AbstractDialog r1, ValueAnimator r2, ValueAnimator r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$kGUZyEOgBD-_DjZRLozeTIPVyVg, reason: not valid java name */
    public static /* synthetic */ void m1285lambda$kGUZyEOgBD_DjZRLozeTIPVyVg(View r0) {
        c(r0);
    }

    public static /* synthetic */ void lambda$lOY5_Q_TMSwNHWkFYNnws_b2VAU(AbstractDialog r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ boolean lambda$nxpIOBcoKFYdBgId74XcWXSTXLQ(AbstractDialog r0) {
        return h(r0);
    }

    public static /* synthetic */ WindowInsets lambda$oCSgknDh3lhaTFHFAxkUQp0fGY0(AbstractDialog r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$ySXaanDYbBLvTX7EJWWxMgXRpoU(AbstractDialog r0, b r1) {
        a(r0, r1);
    }

    public final float a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r3 = false;
        goto L6
    }

    public abstract int a();

    public int a(Window r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin, "dimen", "oui_dialog_layout_margin"));
    }

    public final AbstractDialog a(int r3) {
        Integer r4 = Integer.valueOf(r3);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r4 = null;
    L9:
        this.C = r4;
        c();
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final AbstractDialog a(Boolean r1) {
        this.I = r1;
        return this;
    }

    public final void a(DialogInterface.OnShowListener r3) {
        this.B = (DialogInterface.OnShowListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnShowListener.class, "com.obric.memorydata.plugin");
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13801b = r2;
    }

    public void a(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "container");
        if (Build.VERSION.SDK_INT < 29) goto L19;
        ViewGroup r1 = null;
        if (ZeusTransformUtils.instanceOf(r3, RadiusLayout.class) == false) goto L7;
        RadiusLayout r2 = (RadiusLayout) ZeusTransformUtils.preCheckCast(r3, RadiusLayout.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 != null) goto L10;
        Unit r5 = null;
    L11:
        if (r5 == null) goto L13;
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L15;
        r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
    L15:
        if (r1 == null) goto L21;
        r1.suppressLayout(r4);
        return;
    L21:
        return;
    L10:
        r2.setSuppressChildMeasureAndLayout(r4);
        r5 = Unit.INSTANCE;
        goto L11
    L7:
        r2 = null;
        goto L8
    }

    public final void a(CloseIconStyle r4, Integer r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r4, "style");
        if (this.i == false) goto L39;
        int r7 = c.f13804a[r4.ordinal()];
        if (r7 != 1) goto L7;
        int r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, TypedValues.Custom.S_COLOR, "ConstTextInverse");
        int r9 = R.color.ConstBGContainer7;
        String r10 = "ConstBGContainer7";
    L17:
        r6 = Integer.valueOf(ZeusTransformUtils.mapRes(r9, TypedValues.Custom.S_COLOR, r10));
    L18:
        ImageView r11 = this.h;
        if (r11 == null) goto L22;
        r11.setImageTintList(ContextCompat.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8));
    L22:
        GradientDrawable r12 = null;
        if (r6 != null) goto L28;
        View r3 = this.g;
        if (r3 == null) goto L41;
        r3.setBackground(null);
        return;
    L41:
        return;
    L28:
        View r13 = this.g;
        if (r13 != null) goto L31;
        Drawable r14 = null;
    L33:
        if (ZeusTransformUtils.instanceOf(r14, GradientDrawable.class) == false) goto L35;
        r12 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r14, GradientDrawable.class, "com.obric.memorydata.plugin");
    L35:
        if (r12 == null) goto L42;
        r12.setColor(ContextCompat.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6.intValue()));
        return;
    L42:
        return;
    L31:
        r14 = r13.getBackground();
        goto L33
    L7:
        if (r7 != 2) goto L9;
        r8 = ZeusTransformUtils.mapRes(R.color.TextReverse, TypedValues.Custom.S_COLOR, "TextReverse");
        r9 = R.color.ConstTextInverse5;
        r10 = "ConstTextInverse5";
        goto L17
    L9:
        if (r7 != 3) goto L14;
        if (r5 != null) goto L12;
        r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, TypedValues.Custom.S_COLOR, "ConstTextInverse");
        goto L18
    L12:
        r8 = r5.intValue();
        goto L18
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(boolean r1) {
        this.o = r1;
    }

    public void a(boolean r7, View.OnClickListener r8) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.i = r7;
        this.l = r9;
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
        a(this, this.k, null, null, 6, null);
        View r13 = this.g;
        if (r13 == null) goto L22;
        r13.setOnClickListener(new $$Lambda$AbstractDialog$Po5sIKM5Ws9iO0pgDGpohfc1sw(this));
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

    public final void b(int r6) {
        final Window r0 = getWindow();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isShowing() == true) goto L9;
        this.K = true;
        return;
    L9:
        Integer r1 = this.N;
        if (r1 != null) goto L14;
        r1 = this.O;
        if (r1 != null) goto L14;
        int r2 = r0.getAttributes().y;
    L15:
        if (r2 != r6) goto L24;
        ValueAnimator r3 = this.L;
        if (r3 == null) goto L20;
        r3.cancel();
    L20:
        this.L = null;
        this.M = null;
        this.N = Integer.valueOf(r6);
        this.O = Integer.valueOf(r6);
        WindowManager.LayoutParams r5 = r0.getAttributes();
        if (r5.y == r6) goto L46;
        r5.y = r6;
        r0.setAttributes(r5);
        return;
    L46:
        return;
    L24:
        ValueAnimator r4 = this.L;
        if (r4 != null) goto L28;
    L26:
        boolean r7 = false;
    L30:
        if (r7 == false) goto L37;
        Integer r8 = this.M;
        if (r8 == null) goto L37;
        if (r8.intValue() != r6) goto L37;
        return;
    L37:
        ValueAnimator r9 = this.L;
        if (r9 == null) goto L41;
        r9.cancel();
    L41:
        this.M = Integer.valueOf(r6);
        final ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r2, r6});
        r10.setDuration(200);
        r10.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(1.5f), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r10.addUpdateListener(new $$Lambda$AbstractDialog$f8hjT7_PjTk0GNB580ExewPWOE(r0, this, r10));
        r10.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new d(this, r6), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        this.L = r10;
        if (r10 == null) goto L47;
        r10.start();
        return;
    L47:
        return;
    L28:
        if (r4.isRunning() != true) goto L26;
        r7 = true;
    L14:
        r2 = r1.intValue();
        goto L15
    }

    public final void b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        j().setOnApplyWindowInsetsListener(null);
        ValueAnimator r0 = this.L;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.A = false;
        super.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.obric.oui.c.a.b.a(this.f, "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean h() {
        return this.d;
    }

    public final boolean i() {
        return this.e;
    }

    public final View j() {
        View r0 = this.f13801b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final boolean k() {
        return this.m;
    }

    public final boolean l() {
        return this.n;
    }

    public final boolean m() {
        return this.A;
    }

    public final DialogInterface.OnShowListener n() {
        return this.B;
    }

    public final Integer o() {
        return this.C;
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.Q.removeCallbacksAndMessages(null);
        e();
    }

    public final int p() {
        return this.f13800J;
    }

    public View q() {
        return null;
    }

    public final void r() {
        this.m = true;
    }

    public final void s() {
        this.n = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Dialog
    public void show() {
        f();
        super.show();
        d();
        c();
        Window r0 = getWindow();
        if (r0 == null) goto L67;
        if (m() == false) goto L8;
        return;
    L8:
        r0.setBackgroundDrawableResource(android.R.color.transparent);
        Window r2 = getWindow();
        if (r2 == null) goto L13;
        r2.setWindowAnimations(0);
    L13:
        if (l() == false) goto L18;
        Window r3 = getWindow();
        if (r3 == null) goto L19;
        r3.clearFlags(2);
    L19:
        b(r0);
        WindowManager.LayoutParams r4 = r0.getAttributes();
        r4.gravity = this.E;
        r4.x = this.F;
        r4.y = p() + this.G;
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        ViewGroup.MarginLayoutParams r8 = null;
        RadiusLayout r9 = null;
        if (i() == false) goto L22;
        r4.height = -1;
    L36:
        if (h() == false) goto L50;
        View r5 = j();
        ViewGroup.LayoutParams r6 = j().getLayoutParams();
        r6.width = -1;
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L40;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L41:
        if (r7 == null) goto L44;
        r7.bottomMargin = 0;
    L44:
        r5.setLayoutParams(r6);
        View r10 = j();
        if (ZeusTransformUtils.instanceOf(r10, RadiusLayout.class) == false) goto L47;
        r9 = (RadiusLayout) ZeusTransformUtils.preCheckCast(r10, RadiusLayout.class, "com.obric.memorydata.plugin");
    L47:
        if (r9 == null) goto L62;
        float r11 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3, "dimen", "oui_r_l3"));
        r9.setRadius(r11, r11, 0.0f, 0.0f);
    L62:
        if (l() == false) goto L64;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        r4.dimAmount = a(r12);
    L65:
        com.obric.oui.window.a r13 = com.obric.oui.window.a.f14878a;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        Context r15 = (Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getActivity(r14), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, TrackerImpl.PARAMS);
        com.obric.oui.window.a.a(r15, r4, this.I);
        r0.setAttributes(r4);
        goto L67
    L64:
        r4.dimAmount = 0.0f;
        goto L65
    L40:
        r7 = null;
        goto L41
    L50:
        Size r16 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        int r17 = Math.min(r16.getWidth(), r16.getHeight()) - (a(r0) * 2);
        View r18 = j();
        ViewGroup.LayoutParams r19 = j().getLayoutParams();
        r19.width = r17;
        r19.height = -2;
        r18.setLayoutParams(r19);
        j().measure(View.MeasureSpec.makeMeasureSpec(r17, Integer.MIN_VALUE), 0);
        if (r16.getWidth() >= r16.getHeight()) goto L62;
        ViewGroup.LayoutParams r20 = j().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r20, ViewGroup.MarginLayoutParams.class) == false) goto L55;
        r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r20, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L55:
        if (r8 != null) goto L57;
        int r21 = 0;
    L58:
        int r22 = r16.getHeight();
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r23, "context");
        int r24 = RangesKt.coerceAtLeast((r22 - h.a(r23, 232)) - r21, 0);
        if (j().getMeasuredHeight() <= r24) goto L62;
        View r25 = j();
        ViewGroup.LayoutParams r26 = j().getLayoutParams();
        r26.height = r24;
        r25.setLayoutParams(r26);
        goto L62
    L57:
        r21 = r8.bottomMargin;
        goto L58
    L22:
        Integer r27 = o();
        if (r27 != null) goto L33;
        r27 = Integer.valueOf(this.D);
        if (((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L27;
        Object[] r110 = true;
    L28:
        if (r110 == true) goto L31;
        r27 = null;
    L31:
        if (r27 != null) goto L33;
        int r28 = -2;
    L34:
        r4.height = r28;
        goto L36
    L27:
        r110 = false;
    L33:
        r28 = r27.intValue();
        goto L34
    L18:
        r0.addFlags(2);
    L67:
        if (this.K == false) goto L69;
        b();
    L69:
        this.A = true;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.b
    public boolean t() {
        return this.o;
    }
}
