package com.ss.android.lark.contact.customized.common;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OfficeContactUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public static int b(char r4) {
        if (r4 != ' ') goto L5;
        return 36;
    L5:
        boolean r0 = false;
        if ('a' <= r4) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L14;
        return 35 - (r4 - 'a');
    L14:
        if ('0' <= r4) goto L16;
    L18:
        if (r0 == true) goto L24;
        return -1;
    L24:
        return 9 - (r4 - '0');
    L16:
        if (r4 >= ':') goto L18;
        r0 = true;
        goto L18
    L8:
        if (r4 >= '{') goto L10;
        r3 = true;
        goto L11
    }

    static {
        a = LazyKt.lazy(OfficeContactUtils$profileProtocol$2.INSTANCE);
        b = LazyKt.lazy(OfficeContactUtils$appBaseInfo$2.INSTANCE);
        c = LazyKt.lazy(OfficeContactUtils$tokenService$2.INSTANCE);
    }

    public static boolean f() {
        return ((com.ss.android.lark.passport.dpop.b) c.getValue()).isDoubaoBUser();
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

    public static String c(String r3) {
        Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
        String r4 = ContactMobileUtils.c(r3);
        boolean r1 = true;
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        char r5 = r4.charAt(0);
    L10:
        if ('A' <= r5) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L18;
        return String.valueOf(r5);
    L18:
        if ('a' <= r5) goto L20;
    L22:
        r1 = false;
    L23:
        if (r1 == true) goto L28;
        return "#";
    L28:
        return String.valueOf(Character.toUpperCase(r5));
    L20:
        if (r5 >= '{') goto L22;
    L12:
        if (r5 >= '[') goto L14;
        r2 = true;
        goto L15
    L8:
        r5 = '#';
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static boolean g(final Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Function0<Unit> r0 = new OfficeContactUtils$requireOfficeSDKInitOrFinish$1(r2);
        if (OfficeSDKManager.isAvailable() == true) goto L5;
        Log.w("Contact_Utils", "office sdk not initialized, finish. ".concat(r2.getClass().getName()));
        r0.invoke();
        return false;
    L5:
        return true;
    }

    public static void e(Fragment r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        f r0 = WindowInsetsUtils.b(r3);
        r0.k(true);
        r0.r(true);
        r0.f(false);
        r0.o(false);
        r0.c(false);
        r0.b(r4);
        FragmentActivity r5 = r3.getActivity();
        if (r5 == null) goto L16;
        WindowInsetsUtils.e(r5);
        WindowCompat.setDecorFitsSystemWindows(r5.getWindow(), false);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        View r2 = a(r5.getWindow());     // Catch: Throwable -> L7
        r5.getWindow().setStatusBarColor(0);     // Catch: Throwable -> L7
        r5.getWindow().setNavigationBarColor(0);     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(OneShotPreDrawListener.add(r2, new c(r2, r2)));     // Catch: Throwable -> L7
    L9:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L12;
        Log.e("Contact_Utils", "hideStatusBar failed", r7);
    L12:
        a(r5.getWindow()).setBackgroundColor(r4);
        return;
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static float d(View r2, int r3, Rect r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r4, "outRect");
        if (r2.getGlobalVisibleRect(r4) == true) goto L7;
        return 0.0f;
    L7:
        if (r3 != 1) goto L9;
        float r5 = r4.height();
        float r6 = RangesKt.coerceAtLeast(r2.getHeight(), 0.01f);
    L11:
        return r5 / r6;
    L9:
        r5 = r4.width();
        r6 = RangesKt.coerceAtLeast(r2.getWidth(), 0.01f);
        goto L11
    }
}
