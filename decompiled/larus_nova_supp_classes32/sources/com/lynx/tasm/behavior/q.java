package com.lynx.tasm.behavior;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q extends Dialog {
    public static final String a = null;

    static {
        a = q.class.getSimpleName();
    }

    public final int e() {
        DisplayMetrics r0 = new DisplayMetrics();
        Display r1 = getWindow().getWindowManager().getDefaultDisplay();
        Point r2 = new Point();
        Point r3 = new Point();
        r1.getCurrentSizeRange(r2, r3);
        r1.getMetrics(r0);
        int r4 = r0.heightPixels;
        int r5 = r1.getRotation();
        if (r5 != 0) goto L5;
    L8:
        int r6 = r3.y;
        if (r6 >= r4) goto L11;
        r4 = r6;
    L11:
        int r7 = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r7 <= 0) goto L14;
        int r8 = getContext().getResources().getDimensionPixelSize(r7);
    L16:
        return r4 + r8;
    L14:
        r8 = 0;
        goto L16
    L5:
        if (r5 == 2) goto L8;
        return r4;
    }

    public final void f() {
        String r0 = a;
        if (isShowing() == true) goto L15;
    L10:
        e = move-exception;
        LLog.w(r0, e.toString());
        return;
    L8:
        e = move-exception;
        LLog.w(r0, e.toString());
        return;
    L5:
        if (getActivity(getContext()).isFinishing() == true) goto L16;
        c(this);     // Catch: RuntimeException -> L8 WindowManager.BadTokenException -> L10
    L18:
        return;
    L16:
        return;
    }

    public final View d() {
        return a(getWindow());
    }

    public q(Context r1) {
        super(r1);
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void b(q r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void c(q r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    private static Activity getActivity(Context r1) {
        if ((r1 instanceof Activity) == false) goto L7;
        return (Activity) r1;
    L7:
        if ((r1 instanceof ContextWrapper) == false) goto L11;
        return getActivity(((ContextWrapper) r1).getBaseContext());
    L11:
        throw new IllegalArgumentException();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        getWindow().setGravity(3);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(2, -1);
        getWindow().setSoftInputMode(16);
        getWindow().addFlags(32);
        getWindow().addFlags(8);
        getWindow().addFlags(131072);
        getWindow().clearFlags(2);
        getWindow().clearFlags(1024);
        getWindow().clearFlags(67108864);
        getWindow().clearFlags(256);
        getWindow().clearFlags(134217728);
        d().setSystemUiVisibility(0);
        d().setOutlineProvider(null);
        d().setElevation(0.0f);
        d().setTranslationZ(0.0f);
    }
}
