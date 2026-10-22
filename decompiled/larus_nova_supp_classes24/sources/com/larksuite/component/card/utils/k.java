package com.larksuite.component.card.utils;

import android.app.ActivityManager;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {
    public static AtomicBoolean a;

    public static final boolean a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        AtomicBoolean r1 = a;     // Catch: Throwable -> L16
        if (r1 == null) goto L6;
        Boolean r3 = Boolean.valueOf(r1.get());     // Catch: Throwable -> L16
    L7:
        if (r3 != null) goto L9;
        Object r4 = r2.getSystemService("activity");     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L16
        if (((ActivityManager) r4).getDeviceConfigurationInfo().reqGlEsVersion < 196608) goto L13;
        boolean r5 = true;
    L14:
        a = new AtomicBoolean(r5);     // Catch: Throwable -> L16
        return r5;
    L13:
        r5 = false;
        goto L14
    L9:
        return r3.booleanValue();
    L6:
        r3 = null;
    L16:
        return true;
    }

    public static final boolean b(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r3 = false;
        goto L8
    }
}
