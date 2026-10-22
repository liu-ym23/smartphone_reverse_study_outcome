package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class URLDispatch {
    public static final String KEY_EPOCH = "epoch";
    public static final String KEY_ETAG = "etag";
    public static final String KEY_FINAL_URL = "final_url";
    public static final String KEY_TTNET_ORIGIN_HOST = "ttnet_origin_host";
    private static final String TAG = "URLDispatch";
    private static final int TIME_OUT_MILLISECONDS = 300;
    private String mEpoch;
    private String mEtag;
    private String mFinalUrl;
    private MessageLoop mMessageLoop;
    private String mOriginalUrl;
    private String mTTNetOriginHost;

    static {
    }

    public URLDispatch(String r10) {
        this.mOriginalUrl = r10;
        this.mMessageLoop = new MessageLoop();
    }

    public void done() {
        this.mMessageLoop.quit();
    }

    public String getEpoch() {
        return this.mEpoch;
    }

    public String getEtag() {
        return this.mEtag;
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getTTNetOriginHost() {
        return this.mTTNetOriginHost;
    }

    public void resume(Runnable r10) {
        this.mMessageLoop.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception URLDispatch resume ", new Object[]{e});
    }

    public void setResult(String r10, String r11, String r12, String r13) {
        this.mFinalUrl = r10;
        this.mEtag = r11;
        this.mEpoch = r12;
        this.mTTNetOriginHost = r13;
    }

    public void waitResult(int r10) {
        MessageLoop r11 = this.mMessageLoop;
        if (r10 > 0) goto L6;
        r10 = 300;
    L6:
        r11.loop(r10);
    }
}
