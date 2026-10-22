package rcb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.ResultReceiver;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.edit.keyboard.utils.KeyboardResultReceiver;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final List<d> a = null;

    static {
        a = new ArrayList();
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

    public static void b(EditText r8) {
        Method r3 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
        r3.setAccessible(true);     // Catch: Exception -> L5
        r3.invoke(r8, new Object[]{Boolean.FALSE});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.d("KeyBoardUtils", "disableShowSoftInput fail, error: " + e.toString());
        Method r0 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L9
        r0.setAccessible(true);     // Catch: Exception -> L9
        r0.invoke(r8, new Object[]{Boolean.FALSE});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.d("KeyBoardUtils", "disableShowSoftInput fail, error: " + e.toString());
    }

    public static void c(Context r2) {
        if ((r2 instanceof Activity) == true) goto L6;
        Log.e("KeyBoardUtils", "hideKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        Activity r3 = (Activity) r2;
        if (r3.getWindow() != null) goto L10;
        Log.e("KeyBoardUtils", "hideKeyboard window null", new IllegalArgumentException());
        return;
    L10:
        d(a(r3.getWindow()));
    }

    public static void d(View r4) {
        if (r4 != null) goto L6;
        Log.e("KeyBoardUtils", "hideKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator r1 = ((ArrayList) a).iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        d r2 = (d) r1.next();
        if (r2.interceptKeyboardEvent() == false) goto L8;
        Log.i("KeyBoardUtils", "intercept hideKeyboard event: " + r2);
        return;
    L13:
        Log.i("KeyBoardUtils", "hideKeyboard ");
        InputMethodManager r3 = (InputMethodManager) r4.getContext().getSystemService("input_method");
        if (r3 == null) goto L27;
    L19:
        e = move-exception;
        Log.i("KeyBoardUtils", "hideKeyboard err = " + e.getMessage());
        return;
    L16:
        if (r3.isActive() == false) goto L28;
        Log.i("KeyBoardUtils", "hideKeyboard  view.getWindowToken() =" + r4.getWindowToken());     // Catch: Exception -> L19
        Log.i("KeyBoardUtils", "hideKeyboard hideSoftInputFromWindow result =" + r3.hideSoftInputFromWindow(r4.getWindowToken(), 0));     // Catch: Exception -> L19
        return;
    L28:
        return;
    }

    public static boolean e(Activity r0) {
        if (r0 != null) goto L4;
        return false;
    L4:
        return f(a(r0.getWindow()).getRootView());
    }

    public static boolean f(View r9) {
        if (r9 == null) goto L21;
        WindowManager r1 = (WindowManager) r9.getContext().getSystemService("window");
        DisplayMetrics r3 = new DisplayMetrics();
        if (r1 == null) goto L22;
        r1.getDefaultDisplay().getMetrics(r3);
        int r2 = r3.heightPixels;
        Rect r4 = new Rect();
        r9.getWindowVisibleDisplayFrame(r4);
        int r5 = r2 - r4.bottom;
        WindowManager r10 = (WindowManager) r9.getContext().getSystemService("window");
        DisplayMetrics r6 = new DisplayMetrics();
        if (r10 == null) goto L14;
        Display r11 = r10.getDefaultDisplay();
        r11.getMetrics(r6);
        int r7 = r6.heightPixels;
        r11.getClass().getDeclaredMethod("getRealMetrics", new Class[]{r6.getClass()}).invoke(r11, new Object[]{r6});     // Catch: Exception -> L11
        int r12 = r6.heightPixels;     // Catch: Exception -> L11
    L12:
        if (r12 <= r7) goto L14;
        int r13 = r12 - r7;
    L16:
        if ((r5 - r13) <= 0) goto L23;
        return true;
    L23:
        return false;
    L11:
        r12 = r7;
    L14:
        r13 = 0;
        goto L16
    L22:
        return false;
    L21:
        return false;
    }

    public static void g(Context r2) {
        if ((r2 instanceof Activity) == true) goto L6;
        Log.e("KeyBoardUtils", "showKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        h(((Activity) r2).getCurrentFocus(), null);
    }

    public static void h(View r5, ResultReceiver r6) {
        if (r5 != null) goto L6;
        Log.e("KeyBoardUtils", "showKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator r1 = ((ArrayList) a).iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        d r2 = (d) r1.next();
        if (r2.interceptKeyboardEvent() == false) goto L8;
        Log.i("KeyBoardUtils", "intercept showKeyboard event: " + r2);
        return;
    L13:
        Log.i("KeyBoardUtils", "showKeyboard ");
        InputMethodManager r3 = (InputMethodManager) r5.getContext().getSystemService("input_method");     // Catch: Exception -> L24
        if (r3 != null) goto L17;
        return;
    L17:
        if (r5.requestFocus() == true) goto L20;
        r5.setFocusableInTouchMode(true);     // Catch: Exception -> L24
        r5.setFocusable(true);     // Catch: Exception -> L24
        r5.requestFocus();     // Catch: Exception -> L24
    L20:
        if (r6 == null) goto L22;
        Log.i("KeyBoardUtils", "showKeyboard  resultReceiver is not null");     // Catch: Exception -> L24
        Log.i("KeyBoardUtils", "showKeyboard  showSoftInput result = " + r3.showSoftInput(r5, 1, new KeyboardResultReceiver(r6)));     // Catch: Exception -> L24
        return;
    L22:
        Log.i("KeyBoardUtils", "showKeyboard  showSoftInput result = " + r3.showSoftInput(r5, 1, null));     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        Log.e("KeyBoardUtils", "Android System InputMethodManager is error", e);
    }
}
