package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.AssistantChatDialog;
import com.obric.assistant.interaction.impl.window.AssistantWindowContext;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.memorydata.sdk.entity.search.SearchError;
import java.lang.reflect.Field;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class DialogLancet {
    private static final String TAG = "DialogLancet";
    public static volatile Throwable sLastShowStack;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.window.helpers.DialogLancet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class DialogDismissRunnable implements Runnable {
        private final Dialog mDialog;

        @Override // java.lang.Runnable
        public void run() {
            com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable__run$___twin___() {
            DialogLancet.beforeDialogDismiss(this.mDialog);
            Dialog.class.getMethod("dismiss", new Class[0]).invoke(this.mDialog, new Object[0]);     // Catch: Throwable -> L5 Exception -> L7
        L11:
            DialogLancet.afterDialogDismiss(this.mDialog);
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L5
            Throwable r0 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L5
            if (r0 == null) goto L11;
            com.bytedance.crash.d.d(r0, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            DialogLancet.afterDialogDismiss(this.mDialog);
            throw th;
        }

        private DialogDismissRunnable(Dialog r1) {
            this.mDialog = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable_com_larus_apm_impl_protector_RunnableLancet_run(DialogDismissRunnable r1) {
            r1.com_obric_assistant_interaction_impl_window_helpers_DialogLancet$DialogDismissRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ DialogDismissRunnable(Dialog r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public DialogLancet() {
    }

    public void dismiss() {
        Object r0 = This.get();
        Dialog r1 = (Dialog) r0;
        Handler r2 = resolveDialogHandler(r1);
        if (r2 != null) goto L5;
    L8:
        beforeDialogDismiss(r0);
        Origin.callVoid();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        afterDialogDismiss(r0);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r3 = sLastShowStack;     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        afterDialogDismiss(r0);
        throw th;
    L5:
        if (Looper.myLooper() == r2.getLooper()) goto L8;
        r2.post(createDismissRunnable(r1));
    }

    public void show() {
        Object r0 = This.get();
        if (shouldBlockDialogShow(r0) == false) goto L10;
        handleBlockedDialogShow(r0);
        return;
    L10:
        sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        beforeDialogShow(r0);
        Origin.callVoid();
        afterDialogShow(r0);
    }

    public static void afterDialogDismiss(Object r1) {
        if ((r1 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r2 = (Dialog) r1;
        LandscapeRestrictionGuard.onDialogDismissed(r2);
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r2);
    }

    public static void afterDialogShow(Object r1) {
        if ((r1 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r2 = (Dialog) r1;
        LandscapeRestrictionGuard.onDialogShown(r2);
        LandscapeChildDialogBoundsAdapter.onDialogShown(r2);
        trackDialogIfNeeded(r2);
    }

    public static void beforeDialogDismiss(Object r1) {
        if ((r1 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r2 = (Dialog) r1;
        LandscapeRestrictionGuard.onDialogDismissed(r2);
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r2);
        untrackDialog(r2);
    }

    public static void beforeDialogShow(Object r1) {
        tryBindDialogToWindowHostIfNeeded(r1);
        if ((r1 instanceof Dialog) == true) goto L5;
        return;
    L5:
        Dialog r2 = (Dialog) r1;
        LandscapeChildDialogBoundsAdapter.beginPreAddViewBoundsSession(r2);
        if (isPlainFrameworkDialog(r2) == false) goto L9;
        handleDialogPreAddViewOnStart(r2, "dialog:beforeShow");
        return;
    }

    public static Runnable createDismissRunnable(Dialog r2) {
        return new DialogDismissRunnable(r2, null);
    }

    public static void handleBlockedDialogShow(Object r4) {
        if ((r4 instanceof Dialog) == true) goto L6;
        FLogger.a.w(TAG, "handleBlockedDialogShow ignored, target is not Dialog");
        return;
    L6:
        Dialog r5 = (Dialog) r4;
        FLogger.a.i(TAG, "handleBlockedDialogShow dialogClass=" + r5.getClass().getName() + ", dialogIdentity=" + System.identityHashCode(r5));
        PopupOrDialogVisibilityTracker.onDialogShowBlocked(r5);
    }

    public static boolean isDialogFromWindowContext(Dialog r2) {
        Context r3 = r2.getContext();
    L4:
        if ((r3 instanceof ContextWrapper) == false) goto L13;
        if ((r3 instanceof ChatWindowActivity) == true) goto L7;
        if ((r3 instanceof AssistantWindowContext) == true) goto L10;
        r3 = ((ContextWrapper) r3).getBaseContext();
        goto L4
    L10:
        return true;
    L7:
        return true;
    L13:
        if ((r3 instanceof ChatWindowActivity) == false) goto L15;
        return true;
    L15:
        if ((r3 instanceof AssistantWindowContext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public static boolean isPlainFrameworkDialog(Dialog r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Class<?> r3 = r2.getClass();
        if (isClassOrSuperclassNamed(r3, "androidx.activity.ComponentDialog") == false) goto L8;
        return false;
    L8:
        if (isClassOrSuperclassNamed(r3, "com.google.android.material.bottomsheet.BottomSheetDialog") == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isWindowChildDialog(Dialog r6) {
        Window r0 = r6.getWindow();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        return r1;
    L5:
        if (r0.getAttributes() == null) goto L13;
        IBinder r2 = r0.getAttributes().token;
        IBinder r3 = WindowHost.INSTANCE.getWindowToken();
        if (r2 == null) goto L11;
        if (r2 != r3) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L13;
        FLogger.a.i(TAG, "isWindowChildDialog matched, dialog = " + r6 + ", dialogToken = " + r2 + ", windowToken = " + r3);
        goto L13
    }

    public static Handler resolveDialogHandler(Dialog r3) {
        Field r1 = Dialog.class.getDeclaredField("mHandler");     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r4 = r1.get(r3);     // Catch: Throwable -> L8
        if ((r4 instanceof Handler) == false) goto L11;
        return (Handler) r4;
    L11:
        return null;
    L12:
        return null;
    }

    public static OverlaySource resolveDialogSource(Dialog r3) {
        if (isWindowChildDialog(r3) == false) goto L7;
        return OverlaySource.WINDOW;
    L7:
        if (WindowUtils.INSTANCE.isChatActivityDialog(r3) == false) goto L10;
        FLogger.a.i(TAG, "resolveDialogSource activity dialog = " + r3);
        return OverlaySource.ACTIVITY;
    L10:
        return null;
    }

    public static boolean shouldBlockDialogShow(Object r1) {
        if ((r1 instanceof Dialog) == true) goto L5;
    L7:
        return false;
    L5:
        if (LandscapeRestrictionGuard.shouldBlockDialogShow((Dialog) r1) == false) goto L7;
        return true;
    }

    public static void trackDialogIfNeeded(Dialog r5) {
        if ((r5 instanceof AssistantChatDialog) == false) goto L5;
        return;
    L5:
        OverlaySource r0 = resolveDialogSource(r5);
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0 != OverlaySource.ACTIVITY) goto L11;
        FragmentActivity r1 = WindowUtils.INSTANCE.resolveChatActivityDialog(r5);
    L12:
        PopupOrDialogVisibilityTracker.onDialogShow(r5, r0, r1);
        FLogger.a.i(TAG, "trackDialogIfNeeded track dialog = " + r5 + ", source = " + r0 + ", activity = " + r1);
        return;
    L11:
        r1 = null;
        goto L12
    }

    public static void tryBindDialogToWindowHostIfNeeded(Object r4) {
        if ((r4 instanceof Dialog) == true) goto L6;
        return;
    L6:
        if ((r4 instanceof AssistantChatDialog) == false) goto L8;
        return;
    L8:
        Dialog r5 = (Dialog) r4;
        WindowHost r0 = WindowHost.INSTANCE;
        if (r0.isShowing() == true) goto L14;
        if (r0.isStashed() == true) goto L14;
        return;
    L14:
        if (isDialogFromWindowContext(r5) == true) goto L16;
        return;
    L16:
        Window r6 = r5.getWindow();
        if (r6 != null) goto L36;
        return;
    L36:
        if (r6 != r0.provideWindow()) goto L23;
        return;
    L23:
        WindowManager.LayoutParams r1 = r6.getAttributes();
        if (r1 != null) goto L26;
        return;
    L26:
        IBinder r2 = WindowHost.INSTANCE.getWindowToken();
        if (r2 != null) goto L30;
        return;
    L30:
        if (r1.token == r2) goto L32;
    L34:
        r1.token = r2;
        r1.type = SearchError.ERR_UNKNOWN;
        r6.setAttributes(r1);
        return;
    L32:
        if (r1.type != 1000) goto L34;
    }

    public static void untrackDialog(Dialog r3) {
        PopupOrDialogVisibilityTracker.onDialogDismiss(r3);
        FLogger.a.i(TAG, "untrackDialog dialog = " + r3);
    }

    public static void handleDialogPreAddViewOnStart(Object r1, String r2) {
        if ((r1 instanceof Dialog) == true) goto L5;
        return;
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogPreAddView((Dialog) r1, r2);
    }

    public static boolean isClassOrSuperclassNamed(Class<?> r1, String r2) {
    L2:
        if (r1 == null) goto L8;
        if (r2.equals(r1.getName()) == true) goto L5;
        r1 = r1.getSuperclass();
        goto L2
    L5:
        return true;
    L8:
        return false;
    }
}
