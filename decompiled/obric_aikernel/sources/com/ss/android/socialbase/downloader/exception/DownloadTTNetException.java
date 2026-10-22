package com.ss.android.socialbase.downloader.exception;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadTTNetException extends BaseException {
    private String remoteIp;

    public DownloadTTNetException(int r10, String r11) {
        super(r10, r11);
    }

    public DownloadTTNetException(int r10, Throwable r11) {
        super(r10, r11);
    }

    public String getRemoteIp() {
        return this.remoteIp;
    }

    public String getRequestLog() {
        return getExtraInfo();
    }

    public void parseRemoteIp() {
        String r10 = this.remoteIp;
        if (r10 == null) goto L7;
        if ("0:".equals(r10) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(getRequestLog()) == true) goto L18;
        String r11 = new JSONObject(getRequestLog()).getJSONObject("socket").optString("remote");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r11) == true) goto L19;
        this.remoteIp = g.Z(r11);     // Catch: Throwable -> L12
        return;
    L19:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public DownloadTTNetException setRemoteIp(String r10) {
        this.remoteIp = r10;
        return this;
    }

    public DownloadTTNetException setRequestLog(String r10) {
        setExtraInfo(r10);
        return this;
    }
}
