package com.bytedance.android.ec.core.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n1 {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static boolean g;
    public static boolean h;
    public static final a i = null;

    public static final class a {
        public a() {
        }

        public static int b() {
            if (n1.c != 0) goto L6;
            n1.i.getClass();
            e(ECAppInfoService.e.getApplicationContext());
        L6:
            return n1.c;
        }

        public static int c() {
            if (n1.b != 0) goto L6;
            n1.i.getClass();
            e(ECAppInfoService.e.getApplicationContext());
        L6:
            return n1.b;
        }

        public static int d() {
            if (n1.a != 0) goto L6;
            n1.i.getClass();
            e(ECAppInfoService.e.getApplicationContext());
        L6:
            return n1.a;
        }

        @JvmStatic
        public static void e(Context r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            int r0 = com.bytedance.common.utility.UIUtils.getScreenWidth(r10);
            if (r0 != 0) goto L7;
            return;
        L7:
            n1.a = r0;
            n1.b = k1.j(r10);
            d();
            com.bytedance.common.utility.UIUtils.dip2Px(r10, 32.0f);
            n1.f = d() - ((int) com.bytedance.common.utility.UIUtils.dip2Px(r10, 40.0f));
            int r1 = (d() - ((int) com.bytedance.common.utility.UIUtils.dip2Px(r10, 44.0f))) / 2;
            n1.c = (int) (((double) k1.j(r10)) * 0.73d);
            k1.j(r10);
            n1.d = (int) (((double) k1.j(r10)) * 0.9d);
            k1.j(r10);
            n1.e = (int) (((double) k1.j(r10)) * 0.86d);
        }

        @JvmStatic
        public static int a(Integer r1, int r10) {
            if (r1 != null) goto L4;
            return r10;
        L4:
            if (r1.intValue() > 0) goto L6;
            return r10;
        L6:
            if (c() > 0) goto L9;
            return r10;
        L9:
            return (int) (c() * (r1.intValue() / 100.0f));
        }
    }

    static {
        i = new a();
        h = true;
    }
}
