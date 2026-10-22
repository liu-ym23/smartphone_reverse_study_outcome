package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.crash.util.NpthLog;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class AllDefaultUrls {
    private static String PREFIX = "http";
    private static String domainName = "https://mon.zijieapi.com";

    static {
    }

    public AllDefaultUrls() {
    }

    public static String getDomainName() {
        return domainName;
    }

    public static void setDomainName(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        NpthLog.i("setDomainName:" + r3);
        if (r3.startsWith(PREFIX) == true) goto L8;
        r3 = ReportConsts.HTTPS + r3;
    L8:
        domainName = r3;
        NpthLog.i("setDomainName:" + domainName);
    }

    public static void setDomainName(String r3, JSONArray r4) {
        if (TextUtils.isEmpty(r3) == true) goto L24;
        if (r4 == null) goto L24;
        if (r4.length() == 0) goto L24;
        if (r3.equals(domainName) == false) goto L12;
        NpthLog.i("setDomainName: same domain");
        return;
    L12:
        boolean r0 = false;
        int r1 = 0;
    L14:
        if (r1 >= r4.length()) goto L19;
        if (r3.equals(r4.optString(r1)) == true) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        r0 = true;
    L19:
        if (r0 == true) goto L22;
        NpthLog.i("setDomainName: check valid fail");
        return;
    L22:
        NpthLog.i("setDomainName begin:" + r3);
        domainName = r3;
        return;
    L24:
        NpthLog.i("setDomainName: invalid param");
    }
}
