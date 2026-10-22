package com.obric.oui.sheet.v2;

import ai.j0;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    static {
    }

    public static final void a(View r5, float r10, float r11, float r12) {
        float r13 = r12 - r11;     // Catch: Exception -> L5
        r5.setAlpha((r13 * RangesKt.coerceIn(r10, 0.0f, 1.0f)) + r11);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("updateDimViewWithAnim: ", e.getMessage()));
    }

    public static final void b(Window r5, float r10, float r11, float r12) {
        float r13 = r12 - r11;     // Catch: Exception -> L5
        r5.setDimAmount((r13 * RangesKt.coerceIn(r10, 0.0f, 1.0f)) + r11);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("updateWindowDimWithAnim: ", e.getMessage()));
    }

    public static Pair c(float r10, boolean r11) {
        float r5 = 1.0f - Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH.getBounce();
        if (r11 == false) goto L6;
        float r12 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_1.getDuration() / 1000.0f;
        return new Pair(Float.valueOf(r5), Float.valueOf((float) Math.pow(6.283185307179586d / ((double) j0.b(Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3.getDuration() / 1000.0f, r12, ym.a.i(RangesKt.coerceIn(r10, 0.3f, 0.6f), 0.3f, 0.6f), r12)), 2.0d)));
    L6:
        float r13 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration() / 1000.0f;
        return new Pair(Float.valueOf(r5), Float.valueOf((float) Math.pow(6.283185307179586d / ((double) j0.b(Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2.getDuration() / 1000.0f, r13, ym.a.i(RangesKt.coerceIn(r10, 0.3f, 0.6f), 0.3f, 0.6f), r13)), 2.0d)));
    }
}
