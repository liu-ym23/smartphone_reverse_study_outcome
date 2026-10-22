package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DataLoaderCDNLog {
    public long contentLength;
    public String fileKey;
    public String host;
    public long reqEndT;
    public long reqStartT;
    public String serverIp;
    public String url;
    public String xCache;
    public String xMCache;

    public DataLoaderCDNLog(JSONObject r6) throws Exception {
        if (r6 == null) goto L9;
        this.url = r6.optString("url");     // Catch: Exception -> L6
        this.host = new URL(this.url).getHost();     // Catch: Exception -> L6
        this.serverIp = r6.optString("server_ip");     // Catch: Exception -> L6
        this.xCache = r6.optString("x_cache");     // Catch: Exception -> L6
        this.xMCache = r6.optString("x_m_cache");     // Catch: Exception -> L6
        this.fileKey = r6.optString("f_key");     // Catch: Exception -> L6
        this.contentLength = r6.optLong("contentLength", -1);     // Catch: Exception -> L6
        this.reqStartT = r6.optLong("req_start_t", -1);     // Catch: Exception -> L6
        this.reqEndT = r6.optLong("req_end_t", -1);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new Exception("log null");
    }

    public static JSONObject process(JSONObject r3) {
        if (r3 != null) goto L12;
        return null;
    L12:
        String r1 = r3.optString("url");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r1) == true) goto L10;
        String r2 = new URL(r1).getHost();     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r3.put("host", r2);     // Catch: Exception -> L11
    L10:
        return r3;
    L11:
        return null;
    }
}
