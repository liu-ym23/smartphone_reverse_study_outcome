package com.bytedance.android.live;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.view.LiveFrameLayout;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveDrawOverlayConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ILiveCheckDraw {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ILiveCheckDraw$drawCheckConfig$2.INSTANCE);
    }

    public static boolean a(View r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L48
        if (r5 != null) goto L6;
        return true;
    L6:
        Lazy r2 = a;     // Catch: Throwable -> L48
        if (((LiveDrawOverlayConfig) r2.getValue()).getEnable() == true) goto L10;
        return true;
    L10:
        if (((LiveDrawOverlayConfig) r2.getValue()).getEnableEmptyCheck() == false) goto L33;
        if (Build.VERSION.SDK_INT >= 23) goto L15;
    L29:
        boolean r3 = false;
    L30:
        if (r3 == false) goto L33;
        return false;
    L15:
        if ((r5 instanceof ViewGroup) == false) goto L29;
        ViewGroup r4 = (ViewGroup) r5;     // Catch: Throwable -> L48
        if (r4.getChildCount() != 0) goto L29;
        if (r4.getBackground() != null) goto L29;
        if (r4.getForeground() != null) goto L29;
        if (r4.isFocused() == true) goto L29;
        Class<?> r6 = r4.getClass();     // Catch: Throwable -> L48
        if (r6 != FrameLayout.class) goto L27;
    L28:
        r3 = true;
        goto L30
    L27:
        if (r6 != LiveFrameLayout.class) goto L29;
    L33:
        if (((LiveDrawOverlayConfig) r2.getValue()).getEnableSizeCheck() == true) goto L35;
    L46:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L48
    L50:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L53;
        ALogger.e("ILiveCheckDraw", "enableDrawView error:".concat(String.valueOf(r8.getMessage())));
    L53:
        return true;
    L35:
        if (r5.getAnimation() == null) goto L38;
    L42:
        boolean r9 = false;
    L44:
        if (r9 == false) goto L46;
        return false;
    L38:
        if (r5.getWidth() != 0) goto L40;
    L43:
        r9 = true;
        goto L44
    L40:
        if (r5.getHeight() != 0) goto L42;
    L48:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    }
}
