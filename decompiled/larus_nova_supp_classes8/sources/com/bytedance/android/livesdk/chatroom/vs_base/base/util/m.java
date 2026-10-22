package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m {
    public static Boolean a;

    public static boolean a() {
        Boolean r0 = a;
        if (r0 != null) goto L5;
        boolean r1 = false;
        Method r2 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L15
        r2.setAccessible(true);     // Catch: Throwable -> L15
        Object r3 = r2.invoke(null, new Object[]{"ro.vivo.os.version"});     // Catch: Throwable -> L15
        if ((r3 instanceof String) == true) goto L10;
    L17:
        a = Boolean.valueOf(r1);
        return r1;
    L10:
        if (TextUtils.isEmpty((CharSequence) r3) == true) goto L17;
        if ((!Intrinsics.areEqual("unknown", r3)) == false) goto L17;
        r1 = true;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L5:
        return r0.booleanValue();
    }

    static {
    }
}
