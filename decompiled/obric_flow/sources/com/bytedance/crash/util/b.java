package com.bytedance.crash.util;

import android.content.Context;
import com.bytedance.crash.n;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f4173a = null;

    static {
        f4173a = new HashMap();
    }

    public static void a(boolean r10, int r11) {
        HashMap r5 = f4173a;
        a r12 = (a) r5.get("single_logcat");
        if (r12 != null) goto L6;
        Context r13 = n.f4057a;
        String r14 = g.f4181a;
        r12 = new a(new File(new File(g.h(r13), x8.a.f22985h), "single_logcat"));
        r5.put("single_logcat", r12);
    L6:
        if (2 == r12.f4171b) goto L9;
        r12.f4172c = 0;
        r12.d = 0;
        r12.e = 1;
        r12.f4171b = 2;
    L9:
        if (r12.e != 1) goto L23;
        if (r10 == false) goto L15;
        int r15 = r12.f4172c + 1;
        r12.f4172c = r15;
        if (r11 > r15) goto L21;
        r12.d = 0;
    L21:
        cl.a.u(r12.f4171b + "\n" + r12.f4172c + "\n" + r12.d + "\n" + r12.e, r12.f4170a, false);     // Catch: IOException -> L20
        return;
    L24:
        return;
    L15:
        int r16 = r12.d + 1;
        r12.d = r16;
        if (r11 > r16) goto L21;
        r12.f4172c = 0;
        r12.e = 0;
        goto L21
    }
}
