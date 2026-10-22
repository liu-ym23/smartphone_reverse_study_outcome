package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class URLDispatch {
    public static final String KEY_EPOCH = "epoch";
    public static final String KEY_ETAG = "etag";
    public static final String KEY_FINAL_URL = "final_url";
    public static final String KEY_TTNET_ORIGIN_HOST = "ttnet_origin_host";
    private static final String TAG = null;
    private static final int TIME_OUT_MILLISECONDS = 300;
    private String mEpoch;
    private String mEtag;
    private String mFinalUrl;
    private MessageLoop mMessageLoop;
    private String mOriginalUrl;
    private String mTTNetOriginHost;

    static {
        TAG = "URLDispatch";
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

    public URLDispatch(String r1) {
        this.mOriginalUrl = r1;
        this.mMessageLoop = new MessageLoop();
    }

    public void resume(Runnable r4) {
        this.mMessageLoop.execute(r4);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception URLDispatch resume ", new Object[]{e});
    }

    public void waitResult(int r2) throws IOException {
        MessageLoop r0 = this.mMessageLoop;
        if (r2 > 0) goto L6;
        r2 = TIME_OUT_MILLISECONDS;
    L6:
        r0.loop(r2);
    }

    public void setResult(String r1, String r2, String r3, String r4) {
        this.mFinalUrl = r1;
        this.mEtag = r2;
        this.mEpoch = r3;
        this.mTTNetOriginHost = r4;
    }
}
