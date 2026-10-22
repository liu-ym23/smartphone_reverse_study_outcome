package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    private final Application getContext() {
        com.bytedance.ies.bullet.core.h r0 = com.bytedance.ies.bullet.core.h.h;
        return com.bytedance.ies.bullet.core.h.h.b;
    }

    public final DisplayMetrics b() {
        Application r0 = getContext();
        if (r0 == null) goto L9;
        Context r1 = r0.getApplicationContext();
        if (r1 == null) goto L9;
        Resources r10 = r1.getResources();
        if (r10 == null) goto L9;
        DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());
    L10:
        if (r11 != null) goto L13;
        Resources r12 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics());
    L13:
        return r11;
    L9:
        r11 = null;
        goto L10
    }

    public final int d() {
        return b().heightPixels;
    }

    public final Resources getResources() {
        Application r0 = getContext();
        if (r0 == null) goto L5;
        Resources r1 = r0.getResources();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return Resources.getSystem();
    L5:
        r1 = null;
        goto L6
    }

    public static DisplayMetrics c(Context r10) {
        DisplayMetrics r0 = new DisplayMetrics();
        if (r10 != null) goto L6;
        return r0;
    L6:
        if ((r10 instanceof Activity) == false) goto L8;
        WindowManager r11 = ((Activity) r10).getWindowManager();
    L9:
        if (r11 != null) goto L11;
        return r0;
    L11:
        r11.getDefaultDisplay().getRealMetrics(r0);
        return r0;
    L8:
        Object r12 = r10.getSystemService("window");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.WindowManager");
        r11 = (WindowManager) r12;
        goto L9
    }

    public final int a(float r10) {
        return (int) ((r10 * b().density) + 0.5f);
    }

    public final float e(int r10) {
        return r10 / b().density;
    }
}
