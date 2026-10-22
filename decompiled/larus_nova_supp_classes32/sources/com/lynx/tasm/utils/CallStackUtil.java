package com.lynx.tasm.utils;

import android.util.Log;
import com.obric.aivoice.core.data.NameKeys;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CallStackUtil {
    public CallStackUtil() {
    }

    public static String a(Throwable r2) {
        String r3 = Log.getStackTraceString(r2);
        if (r3.length() > 900) goto L5;
        return r3;
    L5:
        return r3.substring(0, 900);
    }

    public static String getMessageOfCauseChain(Throwable r4) {
        if (r4 != null) goto L13;
        return NameKeys.UnloadStrategy_No_Strategy;
    L13:
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L11
        r0.append(r4);     // Catch: Throwable -> L11
        Throwable r1 = r4.getCause();     // Catch: Throwable -> L11
        int r2 = 5;
    L6:
        if (r1 == null) goto L9;
        if (r2 <= 0) goto L9;
        r2 = r2 - 1;     // Catch: Throwable -> L11
        r0.append(": ");     // Catch: Throwable -> L11
        r0.append(r1);     // Catch: Throwable -> L11
        r1 = r1.getCause();     // Catch: Throwable -> L11
    L9:
        return r0.toString();
    L12:
        return r4.toString();
    }

    public static String getStackTraceStringWithLineTrimmed(Throwable r3) {
        if (r3 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        StringWriter r0 = new StringWriter();     // Catch: Throwable -> L7
        PrintWriter r1 = new PrintWriter(r0);     // Catch: Throwable -> L7
        b(r3, Collections.newSetFromMap(new IdentityHashMap()), r1);     // Catch: Throwable -> L7
        r1.flush();     // Catch: Throwable -> L7
        return r0.toString();
    L8:
        return a(r3);
    }

    public static void b(Throwable r5, Set<Throwable> r6, PrintWriter r7) {
        if (r5 == null) goto L19;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.contains(r5) == false) goto L8;
        return;
    L8:
        if (r6.isEmpty() == true) goto L10;
        r7.print("Caused by: ");
    L10:
        r7.println(r5);
        r6.add(r5);
        StackTraceElement[] r0 = r5.getStackTrace();
        int r2 = 9;
        if (r0.length >= 9) goto L13;
        r2 = r0.length;
    L13:
        int r1 = 0;
    L14:
        if (r1 >= r2) goto L16;
        r7.println("\tat " + r0[r1]);
        r1 = r1 + 1;
        goto L14
    L16:
        b(r5.getCause(), r6, r7);
        return;
    }
}
