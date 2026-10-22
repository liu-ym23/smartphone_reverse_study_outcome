package com.obric.assistant.interaction.impl.window.landscape.restriction;

import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.AssistantChatDialog;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import java.lang.reflect.Field;
import jea.a;
import jea.b;
import jea.c;
import jea.d;
import jea.e;
import jea.f;
import jea.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020,H\u0007J\u001a\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0005H\u0007J\u0012\u00101\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u000102H\u0007J\u0012\u00103\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u000102H\u0007J\u0012\u00104\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J\u0012\u00105\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J\u0012\u00106\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J\u0012\u00107\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J$\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u0005H\u0007J$\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,H\u0007J$\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u0005H\u0007J$\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,H\u0007J6\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010<\u001a\u00020\tH\u0007J6\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010<\u001a\u00020\tH\u0007J:\u0010=\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010<\u001a\u00020\tH\u0002J\u0014\u0010>\u001a\u0004\u0018\u00010\u001a2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010?\u001a\u0004\u0018\u00010@2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030B2\u0006\u0010C\u001a\u00020\u0005H\u0002J\u0012\u0010D\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\r0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\r0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R(\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\r0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R*\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R&\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018¨\u0006H"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionGuard;", "", "<init>", "()V", "TAG", "", "TOAST_DEDUP_INTERVAL_MS", "", "NO_CONTAINER_VIEW_ID", "", "lastToastUptimeMs", "landscapeRestrictionActiveResolver", "Lkotlin/Function0;", "", "getLandscapeRestrictionActiveResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setLandscapeRestrictionActiveResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "windowContextResolver", "Lkotlin/Function1;", "Landroid/content/Context;", "getWindowContextResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setWindowContextResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "windowRootFragmentManagerResolver", "Landroidx/fragment/app/FragmentManager;", "getWindowRootFragmentManagerResolver$impl_mainlandRelease", "setWindowRootFragmentManagerResolver$impl_mainlandRelease", "currentChatFragmentResolver", "Landroidx/fragment/app/Fragment;", "getCurrentChatFragmentResolver$impl_mainlandRelease", "setCurrentChatFragmentResolver$impl_mainlandRelease", "fragmentManagerResolver", "getFragmentManagerResolver$impl_mainlandRelease", "setFragmentManagerResolver$impl_mainlandRelease", "portraitToastReporter", "", "getPortraitToastReporter$impl_mainlandRelease", "setPortraitToastReporter$impl_mainlandRelease", "markDialogFragmentIfAllowed", "fragment", "tag", "operation", "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "markDialogAllowed", "dialog", "Landroid/app/Dialog;", "ruleId", "bindDialogForAllowedDialogFragment", "Landroidx/fragment/app/DialogFragment;", "clearAllowedDialogFragment", "clearAllowedDialog", "onDialogShown", "onDialogDismissed", "shouldBlockDialogShow", "shouldBlockDialogFragmentShow", "fragmentManager", "shouldBlockFragmentTransaction", "transaction", "containerViewId", "shouldBlockFragmentManagerOperation", "resolveFragmentManager", "findField", "Ljava/lang/reflect/Field;", "clsStart", "Ljava/lang/Class;", "name", "isWindowContext", "context", "showPortraitOnlyToast", WindowEvent.Params.REASON, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeRestrictionGuard {
    public static final LandscapeRestrictionGuard INSTANCE = null;
    private static final int NO_CONTAINER_VIEW_ID = 0;
    private static final String TAG = "LandscapeRestrictionGuard";
    private static final long TOAST_DEDUP_INTERVAL_MS = 800;
    private static Function1<? super Fragment, Boolean> currentChatFragmentResolver;
    private static Function1<Object, ? extends FragmentManager> fragmentManagerResolver;
    private static Function0<Boolean> landscapeRestrictionActiveResolver;
    private static volatile long lastToastUptimeMs;
    private static Function1<? super String, Unit> portraitToastReporter;
    private static Function1<? super Context, Boolean> windowContextResolver;
    private static Function1<? super FragmentManager, Boolean> windowRootFragmentManagerResolver;

    private LandscapeRestrictionGuard() {
    }

    public static /* synthetic */ void a() {
        showPortraitOnlyToast$lambda$11();
    }

    public static /* synthetic */ boolean b(Context r0) {
        return windowContextResolver$lambda$1(r0);
    }

    public static /* synthetic */ boolean c(Fragment r0) {
        return currentChatFragmentResolver$lambda$3(r0);
    }

    public static /* synthetic */ boolean d() {
        return landscapeRestrictionActiveResolver$lambda$0();
    }

    public static /* synthetic */ FragmentManager e(Object r0) {
        return fragmentManagerResolver$lambda$4(r0);
    }

    public static /* synthetic */ boolean f(FragmentManager r0) {
        return windowRootFragmentManagerResolver$lambda$2(r0);
    }

    public static /* synthetic */ Unit g(String r0) {
        return portraitToastReporter$lambda$5(r0);
    }

    static {
        INSTANCE = new LandscapeRestrictionGuard();
        landscapeRestrictionActiveResolver = new a();
        windowContextResolver = new b();
        windowRootFragmentManagerResolver = new c();
        currentChatFragmentResolver = new d();
        fragmentManagerResolver = new e();
        portraitToastReporter = new f();
    }

    private static final boolean landscapeRestrictionActiveResolver$lambda$0() {
        return WindowHost.INSTANCE.isLandscapeRestrictionActive();
    }

    private static final void showPortraitOnlyToast$lambda$11() {
        s.a.g(AppHost.a.getApplication(), 2131912394, false);
    }

    public final Function1<Fragment, Boolean> getCurrentChatFragmentResolver$impl_mainlandRelease() {
        return currentChatFragmentResolver;
    }

    public final Function1<Object, FragmentManager> getFragmentManagerResolver$impl_mainlandRelease() {
        return fragmentManagerResolver;
    }

    public final Function0<Boolean> getLandscapeRestrictionActiveResolver$impl_mainlandRelease() {
        return landscapeRestrictionActiveResolver;
    }

    public final Function1<String, Unit> getPortraitToastReporter$impl_mainlandRelease() {
        return portraitToastReporter;
    }

    public final Function1<Context, Boolean> getWindowContextResolver$impl_mainlandRelease() {
        return windowContextResolver;
    }

    public final Function1<FragmentManager, Boolean> getWindowRootFragmentManagerResolver$impl_mainlandRelease() {
        return windowRootFragmentManagerResolver;
    }

    @JvmStatic
    public static final void bindDialogForAllowedDialogFragment(DialogFragment r0) {
        LandscapeRestrictionManager.bindDialogForAllowedDialogFragment(r0);
    }

    @JvmStatic
    public static final void clearAllowedDialog(Dialog r0) {
        LandscapeRestrictionManager.clearAllowedDialog(r0);
    }

    @JvmStatic
    public static final void clearAllowedDialogFragment(DialogFragment r0) {
        LandscapeRestrictionManager.clearAllowedDialogFragment(r0);
    }

    private static final boolean currentChatFragmentResolver$lambda$3(Fragment r1) {
        return WindowHost.INSTANCE.isCurrentChatFragment(r1);
    }

    private static final FragmentManager fragmentManagerResolver$lambda$4(Object r1) {
        return INSTANCE.resolveFragmentManager(r1);
    }

    private final boolean isWindowContext(Context r6) {
        if (r6 != null) goto L17;
        return false;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Boolean.valueOf(ChatWindowServiceDelegate.b.d(r6)));     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        FLogger.a.w(TAG, "isWindowContext failed, context=" + r6, r2);
    L12:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L16;
        r1 = r7;
    L16:
        return ((Boolean) r1).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void onDialogDismissed(Dialog r0) {
        LandscapeRestrictionManager.onDialogDismissed(r0);
    }

    @JvmStatic
    public static final void onDialogShown(Dialog r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L8;
        return;
    L8:
        if (((Boolean) windowContextResolver.invoke(r2.getContext())).booleanValue() == true) goto L10;
        return;
    L10:
        LandscapeRestrictionManager.onDialogShown(r2);
    }

    private static final Unit portraitToastReporter$lambda$5(String r1) {
        Intrinsics.checkNotNullParameter(r1, WindowEvent.Params.REASON);
        INSTANCE.showPortraitOnlyToast(r1);
        return Unit.INSTANCE;
    }

    private final FragmentManager resolveFragmentManager(Object r7) {
        Object r0 = null;
        if (r7 != null) goto L26;
        return null;
    L26:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        Field r2 = findField(r7.getClass(), "mManager");     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        Object r3 = r2.get(r7);     // Catch: Throwable -> L15
    L10:
        if ((r3 instanceof FragmentManager) == false) goto L12;
        FragmentManager r4 = (FragmentManager) r3;     // Catch: Throwable -> L15
    L13:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        FLogger.a.w(TAG, "resolveFragmentManager failed, transaction=" + r7, r6);
    L21:
        if (Result.isFailure-impl(r5) == true) goto L25;
        r0 = r5;
    L25:
        return (FragmentManager) r0;
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    @JvmStatic
    public static final boolean shouldBlockDialogShow(Dialog r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof AssistantChatDialog) == false) goto L9;
        return false;
    L9:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L12;
        return false;
    L12:
        if (((Boolean) windowContextResolver.invoke(r3.getContext())).booleanValue() == true) goto L15;
        return false;
    L15:
        if (LandscapeRestrictionManager.isDialogAllowed(r3, LandscapeRestrictionOperation.DIALOG_SHOW) == false) goto L18;
        return false;
    L18:
        if (LandscapeRestrictionManager.isDialogAllowedByVisibleScope(r3) == false) goto L21;
        return false;
    L21:
        if (LandscapeRestrictionManager.hasVisibleAllowedDialog() == false) goto L24;
        return false;
    L24:
        if (LandscapeRestrictionManager.isDialogAllowedByTaskbarScope(r3) == false) goto L27;
        return false;
    L27:
        if (LandscapeTaskbarExpandedAllowHelper.isTaskbarExpanded() == false) goto L29;
        return false;
    L29:
        FLogger.a.i(TAG, "block dialog show in landscape restriction, dialog=".concat(r3.getClass().getName()));
        portraitToastReporter.invoke("dialog");
        return true;
    }

    private final synchronized void showPortraitOnlyToast(String r7) {
        monitor-enter(this);
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        if ((r0 - lastToastUptimeMs) >= 800) goto L8;
        monitor-exit(this);
        return;
    L8:
        lastToastUptimeMs = r0;     // Catch: Throwable -> L11
        t0.e(new g());     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static final boolean windowContextResolver$lambda$1(Context r1) {
        return INSTANCE.isWindowContext(r1);
    }

    private static final boolean windowRootFragmentManagerResolver$lambda$2(FragmentManager r1) {
        return WindowHost.INSTANCE.isWindowRootFragmentManager(r1);
    }

    public final void setCurrentChatFragmentResolver$impl_mainlandRelease(Function1<? super Fragment, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        currentChatFragmentResolver = r2;
    }

    public final void setFragmentManagerResolver$impl_mainlandRelease(Function1<Object, ? extends FragmentManager> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        fragmentManagerResolver = r2;
    }

    public final void setLandscapeRestrictionActiveResolver$impl_mainlandRelease(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        landscapeRestrictionActiveResolver = r2;
    }

    public final void setPortraitToastReporter$impl_mainlandRelease(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        portraitToastReporter = r2;
    }

    public final void setWindowContextResolver$impl_mainlandRelease(Function1<? super Context, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        windowContextResolver = r2;
    }

    public final void setWindowRootFragmentManagerResolver$impl_mainlandRelease(Function1<? super FragmentManager, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        windowRootFragmentManagerResolver = r2;
    }

    private final Field findField(Class<?> r3, String r4) {
    L2:
        if (r3 == null) goto L6;
        Field r0 = r3.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r0;
    L5:
        r3 = r3.getSuperclass();
        goto L2
    L6:
        return null;
    }

    @JvmStatic
    public static final void markDialogAllowed(Dialog r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "ruleId");
        LandscapeRestrictionManager.markDialogAllowed(r1, r2);
    }

    @JvmStatic
    public static final void markDialogFragmentIfAllowed(Fragment r1, String r2, LandscapeRestrictionOperation r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        LandscapeRestrictionManager.markDialogFragmentIfAllowed(r1, r2, r3);
    }

    @JvmStatic
    public static final boolean shouldBlockDialogFragmentShow(FragmentManager r8, Fragment r9, LandscapeRestrictionOperation r10) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L7;
        return false;
    L7:
        return shouldBlockFragmentManagerOperation$default(INSTANCE, r8, r9, r10, null, 0, 24, null);
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r1, Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        return shouldBlockFragmentTransaction(r1, r2, LandscapeRestrictionOperation.Companion.fromLegacyName(r3));
    }

    @JvmStatic
    public static final boolean shouldBlockDialogFragmentShow(FragmentManager r1, Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        return shouldBlockDialogFragmentShow(r1, r2, LandscapeRestrictionOperation.Companion.fromLegacyName(r3));
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r2, Fragment r3, LandscapeRestrictionOperation r4) {
        Intrinsics.checkNotNullParameter(r4, "operation");
        return shouldBlockFragmentTransaction(r2, r3, r4, null, 0);
    }

    private final boolean shouldBlockFragmentManagerOperation(FragmentManager r3, Fragment r4, LandscapeRestrictionOperation r5, String r6, int r7) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (((Boolean) windowRootFragmentManagerResolver.invoke(r3)).booleanValue() == true) goto L9;
        return false;
    L9:
        if (((Boolean) currentChatFragmentResolver.invoke(r4)).booleanValue() == false) goto L12;
        return false;
    L12:
        if (LandscapeRestrictionManager.isDialogFragmentAllowed(r4, r5) == false) goto L15;
        return false;
    L15:
        if ((r4 instanceof DialogFragment) == false) goto L33;
        if (LandscapeRestrictionManager.isDialogFragmentAllowedByVisibleScope(r4, r5) == false) goto L20;
        return false;
    L20:
        if (LandscapeRestrictionManager.markDialogFragmentAllowedByVisibleScope(r4, r5) == false) goto L23;
        return false;
    L23:
        if (LandscapeRestrictionManager.isDialogFragmentAllowedByTaskbarScope(r4, r5) == false) goto L26;
        return false;
    L26:
        if (r5.isDialogFragmentShowOperation() == false) goto L33;
        if (LandscapeTaskbarExpandedAllowHelper.isTaskbarExpanded() == false) goto L33;
        if (LandscapeRestrictionManager.markDialogFragmentAllowedByTaskbarScope(r4, r5) == false) goto L33;
        return false;
    L33:
        if (LandscapeRestrictionManager.isFragmentAllowed(r4, r5) == false) goto L36;
        return false;
    L36:
        if (LandscapeRestrictionManager.markFragmentIfAllowed(r4, r6, r7, r5) == false) goto L38;
        return false;
    L38:
        FLogger.a.i(TAG, "block fragment in landscape restriction, operation=" + r5.getTraceName$impl_mainlandRelease() + ", fragment=" + r4.getClass().getName());
        portraitToastReporter.invoke("fragment");
        return true;
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r8, Fragment r9, LandscapeRestrictionOperation r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        if (r9 != null) goto L6;
        return false;
    L6:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L9;
        return false;
    L9:
        return INSTANCE.shouldBlockFragmentManagerOperation((FragmentManager) fragmentManagerResolver.invoke(r8), r9, r10, r11, r12);
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r1, Fragment r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        return shouldBlockFragmentTransaction(r1, r2, LandscapeRestrictionOperation.Companion.fromLegacyName(r3), r4, r5);
    }

    public static /* synthetic */ boolean shouldBlockFragmentManagerOperation$default(LandscapeRestrictionGuard r6, FragmentManager r7, Fragment r8, LandscapeRestrictionOperation r9, String r10, int r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        int r5 = 0;
    L10:
        return r6.shouldBlockFragmentManagerOperation(r7, r8, r9, r4, r5);
    L8:
        r5 = r11;
        goto L10
    }
}
