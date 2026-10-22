package com.bytedance.android.ec.core.anchorv3;

import android.text.TextUtils;
import com.bytedance.android.ec.base.service.ECServiceManager;
import jd3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1) {
        if (TextUtils.equals(r1, "search_result_card") == false) goto L5;
        boolean r10 = ECServiceManager.a;
        return ((s83.g) ECServiceManager.c(s83.g.class)).S("ecommerce");
    L5:
        return null;
    }

    public static void b(String r1) {
        jd3.q r0 = new jd3.q();
        r0.a = r1;
        r0.post(null, null);
    }

    public static void c(int r1, String r10, String r11, Throwable r12) {
        int r0 = a63.a.a;
        int r13 = com.bytedance.android.ec.core.opt.ab.c.a;
        w r14 = new w();
        r14.setResult(r1);
        r14.b = r11;
        if (r12 == null) goto L5;
        String r15 = r12.getMessage();
    L6:
        r14.c = r15;
        r14.d = r10;
        r14.post(null, null);
        return;
    L5:
        r15 = null;
        goto L6
    }
}
