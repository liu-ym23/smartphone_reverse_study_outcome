package com.lynx.tasm.utils;

import android.util.Log;
import androidx.annotation.RestrictTo;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.lynx.tasm.base.CalledByNative;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CallStackUtil {
    public static String a(Throwable r5) {
        String r10 = Log.getStackTraceString(r5);
        if (r10.length() > 900) goto L5;
        return r10;
    L5:
        return r10.substring(0, LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST);
    }

    public static void b(Throwable r5, Set r10, PrintWriter r11) {
        if (r5 == null) goto L19;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.contains(r5) == false) goto L8;
        return;
    L8:
        if (r10.isEmpty() == true) goto L10;
        r11.print("Caused by: ");
    L10:
        r11.println(r5);
        r10.add(r5);
        StackTraceElement[] r12 = r5.getStackTrace();
        int r13 = 9;
        if (r12.length >= 9) goto L13;
        r13 = r12.length;
    L13:
        int r14 = 0;
    L14:
        if (r14 >= r13) goto L16;
        r11.println("\tat " + r12[r14]);
        r14 = r14 + 1;
        goto L14
    L16:
        b(r5.getCause(), r10, r11);
        return;
    }

    @CalledByNative
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getMessageOfCauseChain(Throwable r5) {
        if (r5 != null) goto L13;
        return "";
    L13:
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L11
        r10.append(r5);     // Catch: Throwable -> L11
        Throwable r11 = r5.getCause();     // Catch: Throwable -> L11
        int r12 = 5;
    L6:
        if (r11 == null) goto L9;
        if (r12 <= 0) goto L9;
        r12 = r12 - 1;     // Catch: Throwable -> L11
        r10.append(": ");     // Catch: Throwable -> L11
        r10.append(r11);     // Catch: Throwable -> L11
        r11 = r11.getCause();     // Catch: Throwable -> L11
    L9:
        return r10.toString();
    L12:
        return r5.toString();
    }

    @CalledByNative
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getStackTraceStringWithLineTrimmed(Throwable r5) {
        if (r5 != null) goto L9;
        return "";
    L9:
        StringWriter r10 = new StringWriter();     // Catch: Throwable -> L7
        PrintWriter r11 = new PrintWriter(r10);     // Catch: Throwable -> L7
        b(r5, Collections.newSetFromMap(new IdentityHashMap()), r11);     // Catch: Throwable -> L7
        r11.flush();     // Catch: Throwable -> L7
        return r10.toString();
    L8:
        return a(r5);
    }
}
