package com.bytedance.sdk.account.a;

import com.bytedance.apm6.util.constant.ReportConsts;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    public static class a {
        public static String a() {
            return com.ss.android.account.d.a().a();
        }

        private static String a(String r2) {
            com.bytedance.sdk.account.utils.c r0 = com.ss.android.account.d.c();
            if (r0 != null) goto L5;
        L9:
            StringBuilder r1 = new StringBuilder();
            String r3 = ReportConsts.HTTPS;
        L8:
            return r1.append(r3).append(a()).append(r2).toString();
        L5:
            if (r0.a() == false) goto L9;
            r1 = new StringBuilder();
            r3 = "http://";
            goto L8
        }

        public static String b() {
            return a("/passport/user/logout/");
        }

        public static String c() {
            return a("/passport/account/info/v2/");
        }
    }
}
