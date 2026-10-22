package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.crash.util.NpthLog;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
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

    public static void setDomainName(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        NpthLog.i("setDomainName:" + r10);
        if (r10.startsWith(PREFIX) == true) goto L8;
        r10 = ReportConsts.HTTPS + r10;
    L8:
        domainName = r10;
        NpthLog.i("setDomainName:" + domainName);
    }

    public static void setDomainName(String r10, JSONArray r11) {
        if (TextUtils.isEmpty(r10) == true) goto L24;
        if (r11 == null) goto L24;
        if (r11.length() == 0) goto L24;
        if (r10.equals(domainName) == false) goto L12;
        NpthLog.i("setDomainName: same domain");
        return;
    L12:
        boolean r12 = false;
        int r13 = 0;
    L14:
        if (r13 >= r11.length()) goto L19;
        if (r10.equals(r11.optString(r13)) == true) goto L17;
        r13 = r13 + 1;
        goto L14
    L17:
        r12 = true;
    L19:
        if (r12 == true) goto L22;
        NpthLog.i("setDomainName: check valid fail");
        return;
    L22:
        NpthLog.i("setDomainName begin:" + r10);
        domainName = r10;
        return;
    L24:
        NpthLog.i("setDomainName: invalid param");
    }
}
