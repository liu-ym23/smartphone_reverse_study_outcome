package com.bytedance.geckox.utils;

import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f4787a = null;

    static {
        f4787a = new ConcurrentHashMap();
    }

    public static boolean a(String r5, String r10) {
        ConcurrentHashMap r11 = f4787a;
        if (r11.isEmpty() == true) goto L11;
        List r12 = (List) r11.get(r5);
        if (r12 == null) goto L11;
        if (r12.isEmpty() == true) goto L11;
        boolean r13 = r12.contains(r10);
    L12:
        if (r13 == false) goto L15;
        return true;
    L15:
        String r14 = (String) df.c.d.get(r5);
        if (r14 == null) goto L19;
        StringBuilder r15 = sk.a.a(r5);
        String r16 = File.separator;
        return new File(r14, androidx.constraintlayout.motion.widget.a.u(r15, r16, r10, r16, ".consumed")).exists();
    L19:
        return false;
    L11:
        r13 = false;
        goto L12
    }

    public static void b(String r5, String r10) {
        String r11 = (String) df.c.d.get(r5);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() == 0) goto L18;
        StringBuilder r12 = sk.a.a(r5);
        String r13 = File.separator;
        File r14 = new File(r11, androidx.constraintlayout.motion.widget.a.u(r12, r13, r10, r13, ".consumed"));
        if (r14.exists() == true) goto L19;
        r14.createNewFile();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        GeckoLogger.a("set channel consumed failed", e);
        return;
    L19:
        return;
    }
}
