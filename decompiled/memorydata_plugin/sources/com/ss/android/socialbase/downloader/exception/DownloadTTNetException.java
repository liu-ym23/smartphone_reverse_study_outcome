package com.ss.android.socialbase.downloader.exception;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadTTNetException extends BaseException {
    private String remoteIp;

    public DownloadTTNetException(int r1, String r2) {
        super(r1, r2);
    }

    public DownloadTTNetException(int r1, Throwable r2) {
        super(r1, r2);
    }

    public String getRemoteIp() {
        return this.remoteIp;
    }

    public String getRequestLog() {
        return getExtraInfo();
    }

    public void parseRemoteIp() {
        String r0 = this.remoteIp;
        if (r0 == null) goto L7;
        if ("0:".equals(r0) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(getRequestLog()) == true) goto L18;
        String r1 = new JSONObject(getRequestLog()).getJSONObject("socket").optString("remote");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r1) == true) goto L19;
        this.remoteIp = g.g(r1);     // Catch: Throwable -> L12
        return;
    L19:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public DownloadTTNetException setRemoteIp(String r1) {
        this.remoteIp = r1;
        return this;
    }

    public DownloadTTNetException setRequestLog(String r1) {
        setExtraInfo(r1);
        return this;
    }
}
