package com.obric.assistant.interaction.impl.toast;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeWindowToastBoundsAdapter;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.toast.f;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import we8.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004GHIJB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0006H\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010(\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\"H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00172\u0006\u0010-\u001a\u00020\u0006H\u0002J\u001a\u0010.\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00172\u0006\u00100\u001a\u00020\u0019H\u0002J\u001a\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00104\u001a\u00020\"H\u0002J\u001a\u00105\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u00106\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020\u0006H\u0002J\u0012\u00108\u001a\u00020\n2\b\b\u0001\u00109\u001a\u00020\nH\u0002J\f\u0010:\u001a\u00020\u0006*\u00020\u0002H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0002H\u0002J \u0010>\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0002H\u0002J\u0010\u0010A\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J$\u0010B\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010E\u001a\u00020\n*\u00020\u001c2\u0006\u0010F\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;", "Lcom/larus/common_ui/toast/abs/AbsToastHolder;", "Landroid/view/View;", "<init>", "()V", "supportLottie", "", "getSupportLottie", "()Z", "displayDuration", "", "getDisplayDuration", "()I", "setDisplayDuration", "(I)V", "toastView", "mainHandler", "Landroid/os/Handler;", "windowManager", "Landroid/view/WindowManager;", "removeRunnable", "Ljava/lang/Runnable;", "currentToastSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "currentParamsSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "newInstance", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "duration", "isForceDarkMode", "setDuration", "", "show", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "showInternal", "dismiss", "createLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "buildToastSignature", "isDarkMode", "tryAdoptPendingToast", "toastSignature", "paramsSignature", "schedulePendingRemove", "view", "wm", "flushPendingToast", "scheduleAutoRemove", "buildOuiToastLayout", "shouldShowIconDrawableRes", "normalizeIconDrawableRes", "drawableRes", "isAttachedForToast", "resolveToastActivity", "setupOuiToastBackground", "content", "wrapWithOToastShadowFrame", "bottomInset", "getToastCornerRadius", "getOToastShadowSpaceTop", "removeViewIfNeeded", "retryOnFailure", "isAppDarkMode", "dp", "value", "Companion", "ToastSignature", "WindowParamsSignature", "PendingToast", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowToastHolder extends u19.a<View> {
    public static final Companion Companion = null;
    private static final int OUI_TOAST_BOTTOM_MARGIN_DP = 144;
    private static final int OUI_TOAST_DEFAULT_CORNER_RADIUS_DP = 24;
    public static final long REMOVE_RETRY_DELAY_MS = 16;
    private static final int TOAST_LONG_DURATION_MS = 3500;
    private static final int TOAST_SHORT_DURATION_MS = 2000;
    private static final int TOAST_SHORT_DURATION_THRESHOLD_MS = 1500;
    private static final Set<Integer> WARNING_ICON_DRAWABLE_RES = null;
    private static Function1<? super WindowManager.LayoutParams, Unit> layoutParamsAdapter;
    private static PendingToast pendingToast;
    private static Function1<? super Context, ? extends WindowManager> windowManagerProvider;
    private WindowParamsSignature currentParamsSignature;
    private ToastSignature currentToastSignature;
    private int displayDuration;
    private final Handler mainHandler;
    private Runnable removeRunnable;
    private final boolean supportLottie;
    private View toastView;
    private WindowManager windowManager;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$Companion;", "", "<init>", "()V", "TOAST_SHORT_DURATION_THRESHOLD_MS", "", "TOAST_SHORT_DURATION_MS", "TOAST_LONG_DURATION_MS", "OUI_TOAST_BOTTOM_MARGIN_DP", "OUI_TOAST_DEFAULT_CORNER_RADIUS_DP", "REMOVE_RETRY_DELAY_MS", "", "pendingToast", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$PendingToast;", "WARNING_ICON_DRAWABLE_RES", "", "layoutParamsAdapter", "Lkotlin/Function1;", "Landroid/view/WindowManager$LayoutParams;", "", "getLayoutParamsAdapter$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setLayoutParamsAdapter$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "windowManagerProvider", "Landroid/content/Context;", "Landroid/view/WindowManager;", "getWindowManagerProvider$impl_mainlandRelease", "setWindowManagerProvider$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Function1<WindowManager.LayoutParams, Unit> getLayoutParamsAdapter$impl_mainlandRelease() {
            return WindowToastHolder.access$getLayoutParamsAdapter$cp();
        }

        public final Function1<Context, WindowManager> getWindowManagerProvider$impl_mainlandRelease() {
            return WindowToastHolder.access$getWindowManagerProvider$cp();
        }

        public final void setLayoutParamsAdapter$impl_mainlandRelease(Function1<? super WindowManager.LayoutParams, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            WindowToastHolder.access$setLayoutParamsAdapter$cp(r2);
        }

        public final void setWindowManagerProvider$impl_mainlandRelease(Function1<? super Context, ? extends WindowManager> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            WindowToastHolder.access$setWindowManagerProvider$cp(r2);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$PendingToast;", "", "view", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "toastSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "paramsSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "owner", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;", "<init>", "(Landroid/view/View;Landroid/view/WindowManager;Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;)V", "getView", "()Landroid/view/View;", "getWindowManager", "()Landroid/view/WindowManager;", "getToastSignature", "()Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "getParamsSignature", "()Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "getOwner", "()Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;", "removeRunnable", "Ljava/lang/Runnable;", "getRemoveRunnable", "()Ljava/lang/Runnable;", "setRemoveRunnable", "(Ljava/lang/Runnable;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PendingToast {
        private final WindowToastHolder owner;
        private final WindowParamsSignature paramsSignature;
        public Runnable removeRunnable;
        private final ToastSignature toastSignature;
        private final View view;
        private final WindowManager windowManager;

        public final Runnable getRemoveRunnable() {
            Runnable r0 = this.removeRunnable;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("removeRunnable");
            return null;
        }

        public final WindowToastHolder getOwner() {
            return this.owner;
        }

        public final WindowParamsSignature getParamsSignature() {
            return this.paramsSignature;
        }

        public final ToastSignature getToastSignature() {
            return this.toastSignature;
        }

        public final View getView() {
            return this.view;
        }

        public final WindowManager getWindowManager() {
            return this.windowManager;
        }

        public final void setRemoveRunnable(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.removeRunnable = r2;
        }

        public PendingToast(View r2, WindowManager r3, ToastSignature r4, WindowParamsSignature r5, WindowToastHolder r6) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r6, "owner");
            this.view = r2;
            this.windowManager = r3;
            this.toastSignature = r4;
            this.paramsSignature = r5;
            this.owner = r6;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "", "text", "", "iconDrawableRes", "", "yOffsetPx", "isDarkMode", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Z)V", "getText", "()Ljava/lang/String;", "getIconDrawableRes", "()I", "getYOffsetPx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Z)Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ToastSignature {
        private final int iconDrawableRes;
        private final boolean isDarkMode;
        private final String text;
        private final Integer yOffsetPx;

        public static /* synthetic */ ToastSignature copy$default(ToastSignature r0, String r1, int r2, Integer r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.text;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.iconDrawableRes;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.yOffsetPx;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.isDarkMode;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.text;
        }

        public final int component2() {
            return this.iconDrawableRes;
        }

        public final Integer component3() {
            return this.yOffsetPx;
        }

        public final boolean component4() {
            return this.isDarkMode;
        }

        public final ToastSignature copy(String r2, int r3, Integer r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "text");
            return new ToastSignature(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ToastSignature) == true) goto L8;
            return false;
        L8:
            ToastSignature r6 = (ToastSignature) r5;
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (this.iconDrawableRes == r6.iconDrawableRes) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.yOffsetPx, r6.yOffsetPx) == true) goto L18;
            return false;
        L18:
            if (this.isDarkMode == r6.isDarkMode) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.text.hashCode() * 31) + this.iconDrawableRes) * 31;
            Integer r1 = this.yOffsetPx;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            if (this.isDarkMode == false) goto L9;
            int r4 = 1231;
        L11:
            return r3 + r4;
        L9:
            r4 = 1237;
            goto L11
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ToastSignature(text=" + this.text + ", iconDrawableRes=" + this.iconDrawableRes + ", yOffsetPx=" + this.yOffsetPx + ", isDarkMode=" + this.isDarkMode + ')';
        }

        public final int getIconDrawableRes() {
            return this.iconDrawableRes;
        }

        public final String getText() {
            return this.text;
        }

        public final Integer getYOffsetPx() {
            return this.yOffsetPx;
        }

        public final boolean isDarkMode() {
            return this.isDarkMode;
        }

        public ToastSignature(String r2, int r3, Integer r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.text = r2;
            this.iconDrawableRes = r3;
            this.yOffsetPx = r4;
            this.isDarkMode = r5;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 (2\u00020\u0001:\u0001(BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006)"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "", "type", "", "width", "height", "format", "flags", "gravity", "x", "y", "windowAnimations", "<init>", "(IIIIIIIII)V", "getType", "()I", "getWidth", "getHeight", "getFormat", "getFlags", "getGravity", "getX", "getY", "getWindowAnimations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WindowParamsSignature {
        public static final Companion Companion = null;
        private final int flags;
        private final int format;
        private final int gravity;
        private final int height;
        private final int type;
        private final int width;
        private final int windowAnimations;
        private final int x;
        private final int y;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature$Companion;", "", "<init>", "()V", "from", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "params", "Landroid/view/WindowManager$LayoutParams;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final WindowParamsSignature from(WindowManager.LayoutParams r12) {
                Intrinsics.checkNotNullParameter(r12, "params");
                return new WindowParamsSignature(r12.type, r12.width, r12.height, r12.format, r12.flags, r12.gravity, r12.x, r12.y, r12.windowAnimations);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ WindowParamsSignature copy$default(WindowParamsSignature r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            int r2 = r10.type;
        L7:
            if ((r20 & 2) == 0) goto L9;
            int r3 = r10.width;
        L11:
            if ((r20 & 4) == 0) goto L13;
            int r4 = r10.height;
        L15:
            if ((r20 & 8) == 0) goto L17;
            int r5 = r10.format;
        L19:
            if ((r20 & 16) == 0) goto L21;
            int r6 = r10.flags;
        L23:
            if ((r20 & 32) == 0) goto L25;
            int r7 = r10.gravity;
        L27:
            if ((r20 & 64) == 0) goto L29;
            int r8 = r10.x;
        L31:
            if ((r20 & 128) == 0) goto L33;
            int r9 = r10.y;
        L35:
            if ((r20 & 256) == 0) goto L37;
            int r1 = r10.windowAnimations;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final int component1() {
            return this.type;
        }

        public final int component2() {
            return this.width;
        }

        public final int component3() {
            return this.height;
        }

        public final int component4() {
            return this.format;
        }

        public final int component5() {
            return this.flags;
        }

        public final int component6() {
            return this.gravity;
        }

        public final int component7() {
            return this.x;
        }

        public final int component8() {
            return this.y;
        }

        public final int component9() {
            return this.windowAnimations;
        }

        public final WindowParamsSignature copy(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
            return new WindowParamsSignature(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof WindowParamsSignature) == true) goto L8;
            return false;
        L8:
            WindowParamsSignature r6 = (WindowParamsSignature) r5;
            if (this.type == r6.type) goto L12;
            return false;
        L12:
            if (this.width == r6.width) goto L15;
            return false;
        L15:
            if (this.height == r6.height) goto L18;
            return false;
        L18:
            if (this.format == r6.format) goto L21;
            return false;
        L21:
            if (this.flags == r6.flags) goto L24;
            return false;
        L24:
            if (this.gravity == r6.gravity) goto L27;
            return false;
        L27:
            if (this.x == r6.x) goto L30;
            return false;
        L30:
            if (this.y == r6.y) goto L33;
            return false;
        L33:
            if (this.windowAnimations == r6.windowAnimations) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((this.type * 31) + this.width) * 31) + this.height) * 31) + this.format) * 31) + this.flags) * 31) + this.gravity) * 31) + this.x) * 31) + this.y) * 31) + this.windowAnimations;
        }

        public String toString() {
            return "WindowParamsSignature(type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", format=" + this.format + ", flags=" + this.flags + ", gravity=" + this.gravity + ", x=" + this.x + ", y=" + this.y + ", windowAnimations=" + this.windowAnimations + ')';
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getFormat() {
            return this.format;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getType() {
            return this.type;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getWindowAnimations() {
            return this.windowAnimations;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }

        public WindowParamsSignature(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.type = r1;
            this.width = r2;
            this.height = r3;
            this.format = r4;
            this.flags = r5;
            this.gravity = r6;
            this.x = r7;
            this.y = r8;
            this.windowAnimations = r9;
        }
    }

    public static /* synthetic */ void a(WindowToastHolder r0, View r1, WindowManager r2) {
        scheduleAutoRemove$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(WindowManager.LayoutParams r0) {
        return layoutParamsAdapter$lambda$17(r0);
    }

    public static /* synthetic */ WindowManager c(Context r0) {
        return windowManagerProvider$lambda$18(r0);
    }

    public static /* synthetic */ void d(WindowToastHolder r0, View r1, WindowManager r2) {
        removeViewIfNeeded$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ void e(PendingToast r0, WindowToastHolder r1, View r2, WindowManager r3) {
        schedulePendingRemove$lambda$5(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
        WARNING_ICON_DRAWABLE_RES = SetsKt.setOf(new Integer[]{2131243497, 2131243498, 2131243499});
        layoutParamsAdapter = new b();
        windowManagerProvider = new c();
    }

    private final void flushPendingToast() {
        PendingToast r0 = pendingToast;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.getOwner().mainHandler.removeCallbacks(r0.getRemoveRunnable());
        pendingToast = null;
        removeViewIfNeeded$default(r0.getOwner(), r0.getView(), r0.getWindowManager(), false, 4, null);
    }

    public void dismiss() {
        Runnable r0 = this.removeRunnable;
        if (r0 == null) goto L5;
        this.mainHandler.removeCallbacks(r0);
    L5:
        View r1 = (View) getInstance();
        if (r1 != null) goto L8;
        r1 = this.toastView;
    L8:
        if (r1 == null) goto L10;
        schedulePendingRemove(r1, this.windowManager);
    L10:
        setInstance(null);
        this.toastView = null;
        this.windowManager = null;
        this.removeRunnable = null;
        this.currentToastSignature = null;
        this.currentParamsSignature = null;
        super.dismiss();
    }

    public WindowToastHolder() {
        this.displayDuration = TOAST_SHORT_DURATION_MS;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private final boolean shouldShowIconDrawableRes() {
        if (getIconDrawableRes() != 0) goto L5;
    L7:
        return false;
    L5:
        if (WARNING_ICON_DRAWABLE_RES.contains(Integer.valueOf(getIconDrawableRes())) == true) goto L7;
        return true;
    }

    public static final /* synthetic */ Function1 access$getLayoutParamsAdapter$cp() {
        return layoutParamsAdapter;
    }

    public static final /* synthetic */ Function1 access$getWindowManagerProvider$cp() {
        return windowManagerProvider;
    }

    public int getDisplayDuration() {
        return this.displayDuration;
    }

    public boolean getSupportLottie() {
        return this.supportLottie;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final /* synthetic */ void access$setLayoutParamsAdapter$cp(Function1 r0) {
        layoutParamsAdapter = r0;
    }

    public static final /* synthetic */ void access$setWindowManagerProvider$cp(Function1 r0) {
        windowManagerProvider = r0;
    }

    private final ToastSignature buildToastSignature(boolean r5) {
        if (getIconDrawable() == null) goto L5;
        return null;
    L5:
        if (getLottieConfig() == null) goto L8;
        return null;
    L8:
        return new ToastSignature(getText().toString(), normalizeIconDrawableRes(getIconDrawableRes()), getToastYOffsetPx(), r5);
    }

    private final WindowManager.LayoutParams createLayoutParams(Context r3) {
        WindowManager.LayoutParams r4 = new WindowManager.LayoutParams();
        r4.height = -2;
        r4.width = -1;
        r4.format = -3;
        r4.flags = 184;
        r4.type = WindowHost.INSTANCE.getWindowType(IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        r4.gravity = 87;
        r4.y = 0;
        r4.windowAnimations = 2131953294;
        WindowUtils.INSTANCE.setTrustedOverlayReflectively(r4);
        return r4;
    }

    private final int getOToastShadowSpaceTop(Activity r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        Iterator<T> r6 = l.g(r5, 2131953309).iterator();     // Catch: Throwable -> L19
        if (r6.hasNext() == true) goto L6;
        Integer r7 = null;
    L13:
        Integer r8 = r7;     // Catch: Throwable -> L19
        if (r8 == null) goto L16;
        int r9 = r8.intValue();     // Catch: Throwable -> L19
    L17:
        Object r10 = Result.constructor-impl(Integer.valueOf(r9));     // Catch: Throwable -> L19
    L21:
        Throwable r2 = Result.exceptionOrNull-impl(r10);
        if (r2 == null) goto L26;
        FLogger.a.d("ToastLogger", "WindowToastHolder get OToast shadow top skipped: " + r2.getMessage());
        r10 = 0;
    L26:
        return ((Number) r10).intValue();
    L16:
        r9 = 0;
        goto L17
    L6:
        q r3 = (q) r6.next();     // Catch: Throwable -> L19
        Integer r4 = Integer.valueOf(MathKt.roundToInt(r3.b - r3.d));     // Catch: Throwable -> L19
    L8:
        if (r6.hasNext() == false) goto L12;
        q r11 = (q) r6.next();     // Catch: Throwable -> L19
        Integer r12 = Integer.valueOf(MathKt.roundToInt(r11.b - r11.d));     // Catch: Throwable -> L19
        if (r4.compareTo(r12) >= 0) goto L8;
        r4 = r12;
        goto L8
    L12:
        r7 = r4;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    private final int getToastCornerRadius(View r3) {
        return WindowOuiToastCompat.getCornerRadius(r3, dp(r3.getContext(), OUI_TOAST_DEFAULT_CORNER_RADIUS_DP));
    }

    private final boolean isAppDarkMode(Context r5) {
        Lazy r0 = j.a;
        int r1 = j.c;
        if (r1 == (-1)) goto L10;
        if (r1 != 1) goto L6;
        return false;
    L6:
        if (r1 != 2) goto L15;
    L8:
        return true;
    L15:
        return false;
    L10:
        if ((r5.getResources().getConfiguration().uiMode & 48) == 32) goto L8;
        return false;
    }

    private final boolean isAttachedForToast(View r2) {
        if (r2.getParent() == null) goto L5;
    L8:
        return true;
    L5:
        if (r2.isAttachedToWindow() == true) goto L8;
        return false;
    }

    private static final Unit layoutParamsAdapter$lambda$17(WindowManager.LayoutParams r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        LandscapeWindowToastBoundsAdapter.INSTANCE.applyIfNeeded$impl_mainlandRelease(r1);
        return Unit.INSTANCE;
    }

    private final int normalizeIconDrawableRes(int r3) {
        if (WARNING_ICON_DRAWABLE_RES.contains(Integer.valueOf(r3)) == false) goto L6;
        return 0;
    L6:
        return r3;
    }

    private final Activity resolveToastActivity(Context r5) {
        if ((r5 instanceof Activity) == false) goto L5;
        Activity r6 = (Activity) r5;
    L6:
        boolean r0 = true;
        if (r6 != null) goto L9;
    L18:
        r6 = AppHost.a.a().getCurrentActivity();
        if (r6 != null) goto L21;
        return null;
    L21:
        if (r6.isFinishing() == false) goto L23;
    L25:
        r0 = false;
    L26:
        if (r0 == true) goto L28;
        return null;
    L28:
        return r6;
    L23:
        if (r6.isDestroyed() == true) goto L25;
    L9:
        if (r6.isFinishing() == false) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L17;
        r6 = null;
    L17:
        if (r6 != null) goto L28;
    L11:
        if (r6.isDestroyed() == true) goto L13;
        r3 = true;
        goto L14
    L5:
        r6 = null;
        goto L6
    }

    private final void setupOuiToastBackground(View r1) {
        WindowOuiToastCompat.setupBackground(r1);
    }

    private static final WindowManager windowManagerProvider$lambda$18(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Object r2 = r1.getApplicationContext().getSystemService("window");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) r2;
    }

    public void setDisplayDuration(int r1) {
        this.displayDuration = r1;
    }

    public void setDuration(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L9;
        int r4 = TOAST_SHORT_DURATION_MS;
    L10:
        setDisplayDuration(r4);
        return;
    L9:
        r4 = TOAST_LONG_DURATION_MS;
        goto L10
    L5:
        if (r3 >= 1501) goto L7;
        r0 = true;
        goto L7
    }

    private final View buildOuiToastLayout(Context r12, boolean r13) {
        Activity r8 = resolveToastActivity(r12);
        if (r8 != null) goto L6;
        FLogger.a.e("ToastLogger", "WindowToastHolder build OToast failed: activity is null");
        return new FrameLayout(r12);
    L6:
        String r2 = getText().toString();
        int r10 = 0;
        if (r13 == false) goto L9;
        int r6 = 2;
    L10:
        f r9 = new f(r8, r2, 80, true, null, r6, 16);
        r9.g.f = getDisplayDuration();
        if (getIconDrawable() == null) goto L18;
        Drawable r14 = getIconDrawable();
        ImageView r0 = (ImageView) r9.l.findViewById(2131376297);
        if (r14 == null) goto L15;
        r0.setImageDrawable(r14);
        pla.j.f(r0);
    L16:
        r9.a();
    L21:
        View r15 = r9.l;
        setupOuiToastBackground(r15);
        int r16 = dp(r12, OUI_TOAST_BOTTOM_MARGIN_DP);
        Integer r1 = getToastYOffsetPx();
        if (r1 == null) goto L25;
        r10 = r1.intValue();
    L25:
        return wrapWithOToastShadowFrame(r8, r15, r16 + r10);
    L15:
        pla.j.e(r0);
        goto L16
    L18:
        if (shouldShowIconDrawableRes() == false) goto L20;
        r9.b(Integer.valueOf(getIconDrawableRes()));
        goto L21
    L20:
        r9.b(null);
        goto L21
    L9:
        r6 = 0;
        goto L10
    }

    private final int dp(Context r1, int r2) {
        return (int) ((r2 * INVOKEVIRTUAL_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r1.getResources()).density) + 0.5f);
    }

    private final void scheduleAutoRemove(final View r4, final WindowManager r5) {
        Runnable r0 = this.removeRunnable;
        if (r0 == null) goto L6;
        this.mainHandler.removeCallbacks(r0);
    L6:
        if (getShouldAutoDisappear() == false) goto L9;
        long r1 = getDisplayDuration();
        Runnable r2 = new d(this, r4, r5);
        this.removeRunnable = r2;
        this.mainHandler.postDelayed(r2, r1);
        return;
    }

    private final void schedulePendingRemove(final View r8, final WindowManager r9) {
        flushPendingToast();
        final PendingToast r6 = new PendingToast(r8, r9, this.currentToastSignature, this.currentParamsSignature, this);
        Runnable r0 = new a(r6, this, r8, r9);
        r6.setRemoveRunnable(r0);
        pendingToast = r6;
        this.mainHandler.post(r0);
    }

    private final void showInternal(Context r11, boolean r12) {
        FLogger r1 = FLogger.a;
        r1.d("ToastLogger", "WindowToastHolder showInternal start");
        if (r12 == false) goto L5;
    L8:
        boolean r13 = true;
    L9:
        WindowManager.LayoutParams r5 = createLayoutParams(r11);
        layoutParamsAdapter.invoke(r5);
        ToastSignature r6 = buildToastSignature(r13);
        WindowParamsSignature r7 = WindowParamsSignature.Companion.from(r5);
        if (tryAdoptPendingToast(r6, r7) == false) goto L12;
        return;
    L12:
        View r14 = (View) ensureInstance(r11, null, getDisplayDuration(), r13);
        r14.setVisibility(0);
        flushPendingToast();     // Catch: Exception -> L15
        WindowManager r15 = (WindowManager) windowManagerProvider.invoke(r11);     // Catch: Exception -> L15
        this.windowManager = r15;     // Catch: Exception -> L15
        r1.d("ToastLogger", "WindowToastHolder adding view to WM: " + r14);     // Catch: Exception -> L15
        INVOKEINTERFACE_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(r15, r14, r5);     // Catch: Exception -> L15
        set_isShown(true);     // Catch: Exception -> L15
        this.currentToastSignature = r6;     // Catch: Exception -> L15
        this.currentParamsSignature = r7;     // Catch: Exception -> L15
        r1.d("ToastLogger", "WindowToastHolder addView success");     // Catch: Exception -> L15
        scheduleAutoRemove(r14, r15);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.a.e("ToastLogger", "WindowToastHolder addView failed", e);
        e.printStackTrace();
        setInstance(null);
        this.toastView = null;
        this.windowManager = null;
        this.removeRunnable = null;
        this.currentToastSignature = null;
        this.currentParamsSignature = null;
        set_isShown(false);
        clear();
        return;
    L5:
        if (isAppDarkMode(r11) == true) goto L8;
        r13 = false;
        goto L9
    }

    private final boolean tryAdoptPendingToast(ToastSignature r4, WindowParamsSignature r5) {
        PendingToast r0 = pendingToast;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
    L15:
        return false;
    L7:
        if (Intrinsics.areEqual(r0.getToastSignature(), r4) == false) goto L15;
        if (Intrinsics.areEqual(r0.getParamsSignature(), r5) == false) goto L15;
        if (isAttachedForToast(r0.getView()) == false) goto L15;
        r0.getOwner().mainHandler.removeCallbacks(r0.getRemoveRunnable());
        pendingToast = null;
        setInstance(r0.getView());
        this.toastView = r0.getView();
        this.windowManager = r0.getWindowManager();
        this.currentToastSignature = r4;
        this.currentParamsSignature = r5;
        set_isShown(true);
        scheduleAutoRemove(r0.getView(), r0.getWindowManager());
        FLogger.a.d("ToastLogger", "WindowToastHolder adopt pending same toast");
        return true;
    }

    public void show(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Context r0 = r2.getContext();
        if (r0 == null) goto L6;
        super.show(r2, r3);
        showInternal(r0, r3);
        return;
    }

    public void show(Activity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super.show(r2, r3);
        showInternal(r2, r3);
    }

    public void show(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.show(r2, r3);
        showInternal(r2, r3);
    }

    public static void INVOKEINTERFACE_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r0, View r1, ViewGroup.LayoutParams r2) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r1, r2);
        r0.addView(r1, r2);
    }

    private final void removeViewIfNeeded(final View r5, final WindowManager r6, boolean r7) {
        if (r5.getParent() == null) goto L5;
    L8:
        if (r6 != null) goto L13;
        Object r8 = r5.getContext().getApplicationContext().getSystemService("window");
        if ((r8 instanceof WindowManager) == false) goto L12;
        r6 = (WindowManager) r8;
        goto L13
    L12:
        r6 = null;
    L13:
        if (r6 != null) goto L24;
        FLogger.a.d("ToastLogger", "WindowToastHolder skip remove, windowManager is null");
        return;
    L24:
        r6.removeView(r5);     // Catch: Exception -> L18
        FLogger.a.d("ToastLogger", "WindowToastHolder view removed");     // Catch: Exception -> L18
    L22:
        set_isShown(false);
        return;
    L18:
        e = move-exception;
        FLogger.a.e("ToastLogger", "WindowToastHolder removeView failed", e);
        if (r7 == false) goto L22;
        this.mainHandler.postDelayed(new e(this, r5, r6), 16);
        goto L22
    L5:
        if (r5.isAttachedToWindow() == true) goto L8;
        FLogger.a.d("ToastLogger", "WindowToastHolder skip remove, view not attached");
    }

    private static final void removeViewIfNeeded$lambda$16(WindowToastHolder r1, View r2, WindowManager r3) {
        r1.removeViewIfNeeded(r2, r3, false);
    }

    private static final void scheduleAutoRemove$lambda$7(WindowToastHolder r6, View r7, WindowManager r8) {
        removeViewIfNeeded$default(r6, r7, r8, false, 4, null);
        if (r6.getInstance() != r7) goto L5;
    L6:
        r6.setInstance(null);
        r6.toastView = null;
        r6.windowManager = null;
        r6.removeRunnable = null;
        r6.currentToastSignature = null;
        r6.currentParamsSignature = null;
        r6.set_isShown(false);
        r6.clear();
        return;
    L5:
        if (r6.toastView == r7) goto L6;
    }

    private final View wrapWithOToastShadowFrame(Activity r6, View r7, int r8) {
        View r0 = LayoutInflater.from(r6).inflate(2131563811, null);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) r0;
        r1.addView(r7, new FrameLayout.LayoutParams(-2, -2));
        WindowOuiToastCompat.setShadowCornerRadius(r1, getToastCornerRadius(r7));
        FrameLayout r9 = new FrameLayout(r6);
        r9.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        r9.setClipChildren(false);
        r9.setClipToPadding(false);
        r9.addView(r1, new FrameLayout.LayoutParams(-2, -2, 1));
        r9.setPadding(0, getOToastShadowSpaceTop(r6), 0, r8);
        return r9;
    }

    private static final void schedulePendingRemove$lambda$5(PendingToast r6, WindowToastHolder r7, View r8, WindowManager r9) {
        if (pendingToast != r6) goto L6;
        pendingToast = null;
        removeViewIfNeeded$default(r7, r8, r9, false, 4, null);
        return;
    }

    public View newInstance(Context r1, LifecycleOwner r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r4 == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        View r6 = buildOuiToastLayout(r1, r5);
        this.toastView = r6;
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r6;
    L5:
        if (isAppDarkMode(r1) == true) goto L8;
        r5 = false;
        goto L9
    }

    /* JADX INFO: renamed from: newInstance, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3newInstance(Context r1, LifecycleOwner r2, int r3, boolean r4) {
        return newInstance(r1, r2, r3, r4);
    }

    public static /* synthetic */ void removeViewIfNeeded$default(WindowToastHolder r0, View r1, WindowManager r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        r0.removeViewIfNeeded(r1, r2, r3);
    }
}
