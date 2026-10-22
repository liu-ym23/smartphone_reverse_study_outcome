package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class KeyboardUtils {
    private static volatile int KEYBOARD_HEIGHT;

    public static class a implements Runnable {
        public int a;
        public final WeakReference<Context> b;
        public final WeakReference<View> c;
        public final boolean d;
        public final Handler e;

        public final void a() {
            Context r0 = this.b.get();
            View r1 = this.c.get();
            if (r0 == null) goto L29;
            if (r1 == null) goto L30;
            int r2 = this.a - 1;
            this.a = r2;
            if (r2 >= 0) goto L9;
            return;
        L9:
            if (this.d == true) goto L13;
            Boolean r3 = ExternalKeyboardUtils.a;
            if (ExternalKeyboardUtils.b(false) == false) goto L13;
            return;
        L13:
            InputMethodManager r4 = (InputMethodManager) r0.getSystemService("input_method");
            if (r1.isFocusable() == true) goto L16;
        L25:
            Log.d("ShowKeyboardRunnable", "focusable = " + r1.isFocusable() + ", focusableInTouchMode = " + r1.isFocusableInTouchMode());
            return;
        L16:
            if (r1.isFocusableInTouchMode() == false) goto L25;
            if (r1.requestFocus() == true) goto L22;
            Log.d("ShowKeyboardRunnable", "Cannot focus on view");
            this.e.postDelayed(this, 100);
            return;
        L22:
            if (r4.showSoftInput(r1, 0) == true) goto L28;
            Log.d("ShowKeyboardRunnable", "Unable to show keyboard");
            this.e.postDelayed(this, 100);
            return;
        L28:
            return;
        L30:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r2, View r3, boolean r4) {
            this.a = 5;
            this.b = new WeakReference(r2);
            this.c = new WeakReference(r3);
            this.d = r4;
            this.e = new Handler(Looper.getMainLooper());
        }
    }

    public KeyboardUtils() {
    }

    public static View INVOKEVIRTUAL_com_larksuite_framework_utils_KeyboardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static int getKeyboardHeight(Context r1) {
        if (KEYBOARD_HEIGHT != 0) goto L5;
        if (r1 == null) goto L8;
        int r2 = UIUtils.dp2px(r1, 236.0f);
    L10:
        if (r2 < KEYBOARD_HEIGHT) goto L13;
        return r2;
    L13:
        return KEYBOARD_HEIGHT;
    L8:
        r2 = 708;
        goto L10
    L5:
        return KEYBOARD_HEIGHT;
    }

    public static int getSoftButtonsBarHeight(Activity r2) {
        DisplayMetrics r0 = new DisplayMetrics();
        r2.getWindowManager().getDefaultDisplay().getMetrics(r0);
        int r1 = r0.heightPixels;
        r2.getWindowManager().getDefaultDisplay().getRealMetrics(r0);
        int r3 = r0.heightPixels;
        if (r3 > r1) goto L5;
        return 0;
    L5:
        return r3 - r1;
    }

    public static void hideKeyboard(Context r2) {
        if (UIUtils.getActivityFromContext(r2) != null) goto L5;
        return;
    L5:
        Activity r0 = UIUtils.getActivityFromContext(r2);
        if (r0 == null) goto L15;
        InputMethodManager r3 = (InputMethodManager) r2.getSystemService("input_method");
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.isActive() == true) goto L12;
        return;
    L12:
        if (r0.getCurrentFocus() == null) goto L18;
        r3.hideSoftInputFromWindow(r0.getCurrentFocus().getWindowToken(), 0);
        return;
    L18:
        return;
    }

    public static boolean isSoftShowing(Activity r3) {
        int r0 = INVOKEVIRTUAL_com_larksuite_framework_utils_KeyboardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3.getWindow()).getHeight();
        Rect r1 = new Rect();
        INVOKEVIRTUAL_com_larksuite_framework_utils_KeyboardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3.getWindow()).getWindowVisibleDisplayFrame(r1);
        if (((r0 - r1.bottom) - getSoftButtonsBarHeight(r3)) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setKeyboardHeight(int r1) {
        if (KEYBOARD_HEIGHT == r1) goto L6;
        KEYBOARD_HEIGHT = r1;
        return;
    }

    public static void showKeyboard(Context r2) {
        if (UIUtils.getActivityFromContext(r2) != null) goto L5;
        return;
    L5:
        Activity r3 = UIUtils.getActivityFromContext(r2);
        if (r3 == null) goto L13;
        InputMethodManager r0 = (InputMethodManager) r3.getSystemService("input_method");
        View r1 = r3.getCurrentFocus();
        if (r1 != null) goto L10;
        r1 = new View(r3);
    L10:
        if (r0 == null) goto L14;
        r0.showSoftInputFromInputMethod(r1.getWindowToken(), 0);
        r0.toggleSoftInput(0, 2);
        return;
    L14:
        return;
    }

    public static void showKeyboardIgnoreExternalKeyboardCheck(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        a r0 = new a(r3.getContext(), r3, true);
        r0.e.post(r0);
    }

    public static void showKeyboard(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        a r0 = new a(r3.getContext(), r3, false);
        r0.e.post(r0);
    }

    public static void hideKeyboard(Context r1, View r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L11;
        InputMethodManager r3 = (InputMethodManager) r1.getSystemService("input_method");
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.isActive() == false) goto L13;
        r3.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    L13:
        return;
    L11:
        return;
    }

    public static void hideKeyboardUseCompat(Context r2, View r3) {
        if (r2 == null) goto L17;
        if (r3 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 30) goto L10;
        WindowInsetsController r4 = r3.getWindowInsetsController();
        if (r4 == null) goto L16;
        r4.hide(WindowInsets.Type.ime());
        return;
    L16:
        return;
    L10:
        Activity r5 = UIUtils.getActivityFromContext(r2);
        if (r5 == null) goto L19;
        WindowInsetsControllerCompat r6 = WindowCompat.getInsetsController(r5.getWindow(), r3);
        if (r6 == null) goto L20;
        r6.hide(WindowInsetsCompat.Type.ime());
        return;
    L20:
        return;
    L19:
        return;
    }
}
