package com.bytedance.android.live.core.utils.screen;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import j40.s3;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import r80.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class FoldScreenUtils {
    public static IMiddleWareHostContext a;
    public static final l b = null;
    public static Boolean c;
    public static boolean d;
    public static Boolean e;
    public static final Map<String, b> f = null;

    static {
        a = k.f(IMiddleWareHostContext.class);
        b = new l();
        c = null;
        d = false;
        e = null;
        f = new AnonymousClass1();
    }

    public static String d() {
        return Build.MANUFACTURER.toUpperCase().trim();
    }

    public static boolean f() {
        Boolean r0 = e;
        if (r0 == Boolean.TRUE) goto L5;
    L10:
        if (r0 != null) goto L13;
        e = s3.a.getValue();
    L13:
        if (d == false) goto L17;
        ALogger.i("FoldScreenUtils", "New API:Is fold screen " + c);
        return c.booleanValue();
    L17:
        if (a != null) goto L19;
        a = k.f(IMiddleWareHostContext.class);
    L19:
        IMiddleWareHostContext r1 = a;
        if (r1 == null) goto L23;
        c = Boolean.valueOf(r1.isFoldDevice());
        d = true;
        ALogger.i("FoldScreenUtils", "New API:Is fold screen " + c);
        return c.booleanValue();
    L23:
        String r2 = Build.MANUFACTURER.toUpperCase().trim();
        Map<String, b> r3 = f;
        b r4 = (b) ((HashMap) r3).get(r2);
        if (r4 != null) goto L26;
        r4 = (b) ((HashMap) r3).get("default_manufacture");
    L26:
        if (r4 != null) goto L30;
        return false;
    L30:
        return r4.isFoldScreen();
    L5:
        if (d == false) goto L10;
        Boolean r5 = c;
        if (r5 == null) goto L10;
        return r5.booleanValue();
    }

    public static int a() {
        Resources r0 = s1.getResources();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return b(s1.getContext(), r0.getConfiguration());
    }

    public static boolean e() {
        if (f() == true) goto L5;
    L7:
        return false;
    L5:
        if (a() != 0) goto L7;
        return true;
    }

    public static int c(Configuration r1) {
        if (r1 != null) goto L6;
        return a();
    L6:
        return b(s1.getContext(), r1);
    }

    public static int b(Context r2, Configuration r3) {
        if (e == Boolean.TRUE) goto L5;
    L7:
        l r4 = b;
        if (r4 != null) goto L10;
        String r5 = Build.MANUFACTURER.toUpperCase().trim();
        HashMap r0 = (HashMap) f;
        b r6 = (b) r0.get(r5);
        if (r6 != null) goto L14;
        r6 = (b) r0.get("default_manufacture");
    L14:
        if (r6 != null) goto L17;
        return -1;
    L17:
        return r6.a(r3);
    L10:
        return r4.a(r3);
    L5:
        if (f() == true) goto L7;
        return -1;
    }
}
