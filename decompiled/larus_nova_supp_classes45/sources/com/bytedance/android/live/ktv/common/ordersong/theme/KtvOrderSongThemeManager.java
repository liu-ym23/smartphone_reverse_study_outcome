package com.bytedance.android.live.ktv.common.ordersong.theme;

import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KtvOrderSongThemeManager {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public static final int I = 0;
    public static final int J = 0;
    public static final Lazy K = null;
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public static final int r = 0;
    public static final int s = 0;
    public static final int t = 0;
    public static final int u = 0;
    public static final int v = 0;
    public static final int w = 0;
    public static final int x = 0;
    public static final int y = 0;
    public static final int z = 0;

    static {
        a = 11;
        b = 12;
        c = 13;
        d = 14;
        e = 15;
        f = 201;
        g = 202;
        h = 203;
        i = 204;
        j = 205;
        k = 206;
        l = 207;
        m = 208;
        n = 301;
        o = 302;
        p = 303;
        q = 304;
        r = 251;
        s = 252;
        t = 253;
        u = 254;
        v = 255;
        w = 256;
        x = 257;
        y = 258;
        z = 259;
        A = 401;
        B = 402;
        C = 403;
        D = 404;
        E = 501;
        F = 502;
        G = 503;
        H = 504;
        I = 505;
        J = 506;
        K = LazyKt.lazy(KtvOrderSongThemeManager$LIGHT$2.INSTANCE);
    }

    public static int a(int r1) {
        Object r2 = ((HashMap) K.getValue()).get(Integer.valueOf(r1));
        if ((r2 instanceof Integer) == true) goto L5;
        r2 = null;
    L5:
        Integer r3 = (Integer) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.intValue();
    }

    public static void b(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setThemeBackGroundColor");
        r1.setBackgroundColor(a(r2));
    }

    public static void c(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setThemeBackGroundRes");
        r1.setBackgroundResource(a(r2));
    }

    public static void d(TextView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setThemeTextColor");
        r1.setTextColor(a(r2));
    }
}
