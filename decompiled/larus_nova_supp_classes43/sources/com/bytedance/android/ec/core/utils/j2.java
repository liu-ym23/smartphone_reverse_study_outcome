package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.ViewConfiguration;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j2 {
    public static SparseArray<ViewConfiguration> a;
    public static Field b;
    public static Field c;
    public static Field d;
    public static boolean e;
    public static boolean f;
    public static final j2 g = null;

    public j2() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (a == null) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (f == true) goto L15;
        f = true;     // Catch: Throwable -> L17
        Field r1 = ViewConfiguration.class.getDeclaredField("sConfigurations");     // Catch: Exception -> L13 Throwable -> L17
        r1.setAccessible(true);     // Catch: Exception -> L13 Throwable -> L17
        Object r10 = r1.get(null);     // Catch: Exception -> L13 Throwable -> L17
        if (r10 == null) goto L12;
        a = (SparseArray) r10;     // Catch: Exception -> L13 Throwable -> L17
        Field r11 = SparseArray.class.getDeclaredField("mKeys");     // Catch: Exception -> L13 Throwable -> L17
        r11.setAccessible(true);     // Catch: Exception -> L13 Throwable -> L17
        b = r11;     // Catch: Exception -> L13 Throwable -> L17
        Field r12 = SparseArray.class.getDeclaredField("mValues");     // Catch: Exception -> L13 Throwable -> L17
        r12.setAccessible(true);     // Catch: Exception -> L13 Throwable -> L17
        c = r12;     // Catch: Exception -> L13 Throwable -> L17
        SparseArray.class.getDeclaredField("mSize").setAccessible(true);     // Catch: Exception -> L13 Throwable -> L17
        Field r13 = SparseArray.class.getDeclaredField("DELETED");     // Catch: Exception -> L13 Throwable -> L17
        r13.setAccessible(true);     // Catch: Exception -> L13 Throwable -> L17
        d = r13;     // Catch: Exception -> L13 Throwable -> L17
        goto L15
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.util.SparseArray<android.view.ViewConfiguration>");     // Catch: Exception -> L13 Throwable -> L17
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L17
        goto L15
    }

    static {
        g = new j2();
    }

    public final String c() {
        a();
        StringBuilder r0 = new StringBuilder();
        SparseArray<ViewConfiguration> r1 = a;
        Object r10 = null;
        if (r1 == null) goto L7;
        Field r11 = b;
        if (r11 == null) goto L7;
        Object r12 = r11.get(r1);
    L9:
        if ((r12 instanceof int[]) == false) goto L12;
        r10 = r12;
    L12:
        int[] r13 = (int[]) r10;
        if (r13 == null) goto L24;
        int r14 = r13.length;
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L24;
        int r16 = r13[r15];
        if (r0.length() <= 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
        r0.append(",");
    L22:
        r0.append(r16);
        r15 = r15 + 1;
        goto L15
    L19:
        r17 = false;
    L24:
        return r0.toString();
    L7:
        r12 = null;
        goto L9
    }

    public static void d(String r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_MSG);
        dm.a.a("VIEW_CONF_FIX").i(r1);
    }

    public final String b(Context r10) {
        StringBuilder r1 = new StringBuilder("[viewconf_info size:");     // Catch: Throwable -> L17
        a();     // Catch: Throwable -> L17
        SparseArray<ViewConfiguration> r0 = a;     // Catch: Throwable -> L17
        if (r0 == null) goto L6;
        int r11 = r0.size();     // Catch: Throwable -> L17
    L7:
        r1.append(r11);     // Catch: Throwable -> L17
        r1.append(" keys:");     // Catch: Throwable -> L17
        r1.append(c());     // Catch: Throwable -> L17
        r1.append(" enableFix:");     // Catch: Throwable -> L17
        ECSettingKeys.j.getClass();     // Catch: Throwable -> L17
        r1.append(ECSettingKeys.b0());     // Catch: Throwable -> L17
        r1.append(" density:");     // Catch: Throwable -> L17
        if (r10 == null) goto L14;
        Resources r12 = r10.getResources();     // Catch: Throwable -> L17
        if (r12 == null) goto L14;
        DisplayMetrics r13 = WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics());     // Catch: Throwable -> L17
        if (r13 == null) goto L14;
        Float r14 = Float.valueOf(r13.density);     // Catch: Throwable -> L17
    L15:
        r1.append(r14);     // Catch: Throwable -> L17
        r1.append(']');     // Catch: Throwable -> L17
        return r1.toString();
    L14:
        r14 = null;
        goto L15
    L6:
        r11 = -1;
    L17:
        th = move-exception;
        String r15 = th.getMessage();
        if (r15 != null) goto L24;
        return IHostStyleUIDepend.TOAST_TYPE_ERROR;
    L24:
        return r15;
    }
}
