package com.facebook.common.logging;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import td.d;

/* JADX INFO: loaded from: classes2.dex */
public class FLogDefaultLoggingDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FLogDefaultLoggingDelegate f7658a = null;

    static {
        f7658a = new FLogDefaultLoggingDelegate();
    }

    public FLogDefaultLoggingDelegate() {
    }

    public final boolean a(int r5) {
        if (5 > r5) goto L6;
        return true;
    L6:
        return false;
    }

    public static String a(String r5) {
        return d.b("unknown:", r5);
    }

    public static void a(int r5, String r10, String r11, Throwable r12) {
        String r13 = a(r10);
        StringBuilder r14 = new StringBuilder();
        r14.append(r11);
        r14.append('\n');
        if (r12 != null) goto L5;
        String r15 = "";
    L6:
        r14.append(r15);
        Log.println(r5, r13, r14.toString());
        return;
    L5:
        StringWriter r16 = new StringWriter();
        r12.printStackTrace(new PrintWriter(r16));
        r15 = r16.toString();
        goto L6
    }
}
