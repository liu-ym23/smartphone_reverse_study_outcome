package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\"\u001a\u0004\u0018\u00010\u0018*\u00020#H\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\b\u0010)\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/WindowUtils;", "", "<init>", "()V", "TAG", "", "PRIVATE_FLAG_NO_MOVE_ANIMATION_FALLBACK", "", "layoutParamsPrivateFlagsField", "Ljava/lang/reflect/Field;", "getLayoutParamsPrivateFlagsField", "()Ljava/lang/reflect/Field;", "layoutParamsPrivateFlagsField$delegate", "Lkotlin/Lazy;", "noMoveAnimationPrivateFlag", "getNoMoveAnimationPrivateFlag", "()I", "noMoveAnimationPrivateFlag$delegate", "backToWindow", "", "isChatActivityDialog", "dialog", "Landroid/app/Dialog;", "resolveChatActivityDialog", "Landroidx/fragment/app/FragmentActivity;", "isDialogBelongsToActivity", "targetActivity", "Landroid/app/Activity;", "isChatActivityPopup", "anchorView", "Landroid/view/View;", "resolveChatActivityPopup", "isMainBotActivity", "activity", "findFragmentActivity", "Landroid/content/Context;", "setTrustedOverlayReflectively", "", "lp", "Landroid/view/WindowManager$LayoutParams;", "disableMoveAnimationReflectively", "getCurrentActivityExceptWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowUtils {
    public static final WindowUtils INSTANCE = null;
    private static final int PRIVATE_FLAG_NO_MOVE_ANIMATION_FALLBACK = 64;
    private static final String TAG = "WindowUtils";
    private static final Lazy layoutParamsPrivateFlagsField$delegate = null;
    private static final Lazy noMoveAnimationPrivateFlag$delegate = null;

    private WindowUtils() {
    }

    public static /* synthetic */ int a() {
        return noMoveAnimationPrivateFlag_delegate$lambda$7();
    }

    public static /* synthetic */ Field b() {
        return layoutParamsPrivateFlagsField_delegate$lambda$3();
    }

    public final boolean backToWindow() {
        return true;
    }

    static {
        INSTANCE = new WindowUtils();
        layoutParamsPrivateFlagsField$delegate = LazyKt.lazy(new p());
        noMoveAnimationPrivateFlag$delegate = LazyKt.lazy(new q());
    }

    private final Field getLayoutParamsPrivateFlagsField() {
        return (Field) layoutParamsPrivateFlagsField$delegate.getValue();
    }

    private final int getNoMoveAnimationPrivateFlag() {
        return ((Number) noMoveAnimationPrivateFlag$delegate.getValue()).intValue();
    }

    private static final Field layoutParamsPrivateFlagsField_delegate$lambda$3() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Field r1 = WindowManager.LayoutParams.class.getDeclaredField("privateFlags");     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(r1);     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L10;
        FLogger.a.w(TAG, "resolve privateFlags field failed", r3);
    L10:
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = null;
    L13:
        return (Field) r2;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private static final int noMoveAnimationPrivateFlag_delegate$lambda$7() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Field r1 = WindowManager.LayoutParams.class.getDeclaredField("PRIVATE_FLAG_NO_MOVE_ANIMATION");     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(Integer.valueOf(r1.getInt(null)));     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L10;
        FLogger.a.w(TAG, "resolve PRIVATE_FLAG_NO_MOVE_ANIMATION failed, use fallback", r3);
    L10:
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = 64;
    L13:
        return ((Number) r2).intValue();
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final FragmentActivity getCurrentActivityExceptWindow() {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L18;
        IAssistantChatWindow r3 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r3 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        return null;
    L13:
        if (r3.isShowing() != true) goto L15;
    L18:
        FragmentActivity r4 = AppHost.a.a().getCurrentActivity();
        if ((r4 instanceof FragmentActivity) == true) goto L21;
        return null;
    L21:
        return r4;
    L5:
        if (r0.isWindowMode() != true) goto L7;
        r2 = true;
        goto L9
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_WindowUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private final FragmentActivity findFragmentActivity(Context r2) {
    L3:
        if ((r2 instanceof ContextWrapper) == false) goto L10;
        if ((r2 instanceof FragmentActivity) == true) goto L7;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L3
    L7:
        return (FragmentActivity) r2;
    L10:
        if ((r2 instanceof FragmentActivity) == true) goto L16;
        return null;
    L16:
        return (FragmentActivity) r2;
    }

    public final void disableMoveAnimationReflectively(WindowManager.LayoutParams r5) {
        Intrinsics.checkNotNullParameter(r5, "lp");
        Field r0 = getLayoutParamsPrivateFlagsField();
        if (r0 != null) goto L16;
        return;
    L16:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        int r2 = r0.getInt(r5);     // Catch: Throwable -> L10
        if ((getNoMoveAnimationPrivateFlag() & r2) != getNoMoveAnimationPrivateFlag()) goto L8;
        return;
    L8:
        r0.setInt(r5, r2 | getNoMoveAnimationPrivateFlag());     // Catch: Throwable -> L10
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        FLogger.a.w(TAG, "disableMoveAnimationReflectively failed", r7);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final boolean isChatActivityDialog(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        if (resolveChatActivityDialog(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isChatActivityPopup(View r1) {
        if (resolveChatActivityPopup(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMainBotActivity(FragmentActivity r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        t1a.b r4 = PopupOrDialogVisibilityTrackerKt.getMainBotVContext(r3);
        if (r4 == null) goto L13;
        laa.d r5 = r4.getAbility(laa.d.class);
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.Da() != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public final FragmentActivity resolveChatActivityDialog(Dialog r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        FragmentActivity r0 = r5.getOwnerActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 != null) goto L10;
        r1 = findFragmentActivity(r5.getContext());
        if (r1 != null) goto L10;
        return null;
    L10:
        WindowUtils r2 = INSTANCE;
        if (r2.isMainBotActivity(r1) == true) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == true) goto L18;
        return null;
    L18:
        return r1;
    L13:
        if (r2.isDialogBelongsToActivity(r5, r1) == false) goto L15;
        r6 = true;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final FragmentActivity resolveChatActivityPopup(View r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        FragmentActivity r1 = getCurrentActivityExceptWindow();
        if (isMainBotActivity(r1) == false) goto L15;
        if (r1 == null) goto L11;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L11;
        View r3 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_WindowUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2);
    L13:
        if (Intrinsics.areEqual(r4, r3) == false) goto L15;
        return r1;
    L11:
        r3 = null;
    L15:
        FragmentActivity r5 = findFragmentActivity(r4.getContext());
        if (r5 != null) goto L19;
        return null;
    L19:
        if (isMainBotActivity(r5) == true) goto L21;
        return null;
    L21:
        Window r6 = r5.getWindow();
        if (r6 == null) goto L24;
        View r7 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_WindowUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r6);
    L26:
        if (Intrinsics.areEqual(r4, r7) == false) goto L28;
        return r5;
    L28:
        Context r8 = r4.getContext();
    L30:
        if ((r8 instanceof ContextWrapper) == false) goto L34;
        if (r8 == r5) goto L32;
        r8 = ((ContextWrapper) r8).getBaseContext();
        goto L30
    L32:
        return r5;
    L34:
        if (r8 == r5) goto L36;
        return null;
    L36:
        return r5;
    L24:
        r7 = null;
        goto L26
    }

    public final void setTrustedOverlayReflectively(WindowManager.LayoutParams r6) {
        Intrinsics.checkNotNullParameter(r6, "lp");
        if (Build.VERSION.SDK_INT >= 31) goto L14;
        FLogger.a.i(TAG, "setTrustedOverlayReflectively failed, sdk version < 31");
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        Method r1 = WindowManager.LayoutParams.class.getDeclaredMethod("setTrustedOverlay", new Class[0]);     // Catch: Throwable -> L6
        r1.setAccessible(true);     // Catch: Throwable -> L6
        Object r7 = Result.constructor-impl(r1.invoke(r6, new Object[0]));     // Catch: Throwable -> L6
    L8:
        Throwable r2 = Result.exceptionOrNull-impl(r7);
        if (r2 == null) goto L11;
        FLogger.a.w(TAG, "setTrustedOverlayReflectively failed", r2);
    L11:
        Result.box-impl(r7);
        return;
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean isDialogBelongsToActivity(Dialog r3, Activity r4) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        Intrinsics.checkNotNullParameter(r4, "targetActivity");
        if (r3.getOwnerActivity() != r4) goto L5;
        return true;
    L5:
        Context r5 = r3.getContext();
    L7:
        if ((r5 instanceof ContextWrapper) == false) goto L11;
        if (r5 == r4) goto L9;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L7
    L9:
        return true;
    L11:
        return false;
    }
}
