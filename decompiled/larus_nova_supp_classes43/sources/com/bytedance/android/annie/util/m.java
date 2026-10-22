package com.bytedance.android.annie.util;

import android.app.Activity;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean c() {
        if (p.a.getResources().getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean a(Activity r10) {
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == true) goto L23;
        if (r10 != null) goto L11;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == true) goto L23;
        if (r10 != null) goto L17;
    L19:
        boolean r13 = false;
    L20:
        if (r13 == true) goto L23;
        return false;
    L17:
        if (r10.getRequestedOrientation() != 6) goto L19;
        r13 = true;
        goto L20
    L11:
        if (r10.getRequestedOrientation() != 8) goto L13;
        r12 = true;
    L23:
        return true;
    L5:
        if (r10.getRequestedOrientation() != 0) goto L7;
        r11 = true;
        goto L8
    }

    public static boolean b(int r10) {
        if (com.bytedance.android.annie.ng.g.b().b.c == true) goto L5;
        if (r10 != 0) goto L11;
        return true;
    L11:
        if (r10 != 6) goto L13;
        return true;
    L13:
        if (r10 == 8) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (p.a.getResources().getConfiguration().orientation == 2) goto L16;
        return false;
    L16:
        return true;
    }
}
