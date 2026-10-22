package com.bytedance.ai.model.widgets;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k0 implements ix7.f {
    public final /* synthetic */ WebEngineAssem a;

    public k0(WebEngineAssem r1) {
        this.a = r1;
    }

    public final void onTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        if (this.a.q == false) goto L42;
        int r10 = r12.getAction();
        boolean r11 = false;
        if (r10 != 0) goto L7;
        this.a.t = (int) r12.getY();
        this.a.w = r12.getPointerId(0);
        return;
    L7:
        if (r10 != 1) goto L9;
    L38:
        WebEngineAssem r13 = this.a;
        r13.x = false;
        r13.w = -1;
        return;
    L9:
        if (r10 != 2) goto L11;
    L35:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("WebViewAssem", "exception in onTouchEvent. " + e.getStackTrace());
        return;
    L14:
        if (r12.findPointerIndex(this.a.w) != (-1)) goto L17;
        com.bytedance.ai.utils.g.a.e("WebViewAssem", "invalid pointerId = " + this.a.w + " in onTouchEvent");     // Catch: IllegalArgumentException -> L35
        return;
    L17:
        int r14 = (int) r12.getY(this.a.w);     // Catch: IllegalArgumentException -> L35
        WebEngineAssem r15 = this.a;     // Catch: IllegalArgumentException -> L35
        int r16 = r14 - r15.t;     // Catch: IllegalArgumentException -> L35
        if (r15.x == true) goto L22;
        int r17 = Math.abs(r16);     // Catch: IllegalArgumentException -> L35
        WebEngineAssem r18 = this.a;     // Catch: IllegalArgumentException -> L35
        if (r17 <= r18.v) goto L22;
        r18.x = true;     // Catch: IllegalArgumentException -> L35
    L22:
        WebEngineAssem r19 = this.a;     // Catch: IllegalArgumentException -> L35
        if (r19.x == false) goto L43;
        if (r16 == 0) goto L44;
        if (r16 >= 0) goto L27;
        r11 = true;
    L27:
        r19.u = r11;     // Catch: IllegalArgumentException -> L35
        com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;     // Catch: IllegalArgumentException -> L35
        r20.d("WebViewAssem", "----pullUp detected: " + this.a.u + ", offset: " + r16);     // Catch: IllegalArgumentException -> L35
        WebEngineAssem r110 = this.a;     // Catch: IllegalArgumentException -> L35
        if (r110.r == false) goto L31;
        r110.r = !r110.u;     // Catch: IllegalArgumentException -> L35
        r20.d("WebViewAssem", "####isReachTop: " + this.a.r);     // Catch: IllegalArgumentException -> L35
        return;
    L31:
        if (r110.s == false) goto L33;
        r110.s = r110.u;     // Catch: IllegalArgumentException -> L35
        r20.d("WebViewAssem", "####isReachBottom: " + this.a.s);     // Catch: IllegalArgumentException -> L35
        return;
    L33:
        r20.d("WebViewAssem", "isReachTop: " + this.a.r + ", isReachBottom: " + this.a.s);     // Catch: IllegalArgumentException -> L35
        return;
    L44:
        return;
    L43:
        return;
    L11:
        if (r10 == 3) goto L38;
        return;
    }

    public final Boolean a(int r10, boolean r11) {
        WebEngineAssem r0 = this.a;
        if (r0.q == true) goto L7;
        return null;
    L7:
        if (r10 > 0) goto L9;
    L12:
        if (r10 < 0) goto L14;
    L17:
        com.bytedance.ai.utils.g.a.d("WebViewAssem", "canScrollVertically: " + r10 + ", enable: " + r11 + ", result: true");
        return Boolean.TRUE;
    L14:
        if (r0.s == false) goto L17;
        com.bytedance.ai.utils.g.a.d("WebViewAssem", "canScrollVertically: " + r10 + ", enable: " + r11 + ", result: false");
        return Boolean.FALSE;
    L9:
        if (r0.r == false) goto L12;
        com.bytedance.ai.utils.g.a.d("WebViewAssem", "canScrollVertically: " + r10 + ", enable: " + r11 + ", result: false");
        return Boolean.FALSE;
    }
}
