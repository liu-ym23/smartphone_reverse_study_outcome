package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class URLDispatch {
    public static final String KEY_EPOCH = "epoch";
    public static final String KEY_ETAG = "etag";
    public static final String KEY_FINAL_URL = "final_url";
    private static final String TAG = "URLDispatch";
    private static final int TIME_OUT_MILLISECONDS = 300;
    private String mEpoch;
    private String mEtag;
    private String mFinalUrl;
    private MessageLoop mMessageLoop;
    private String mOriginalUrl;

    public URLDispatch(String r8) {
        this.mOriginalUrl = r8;
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

    public void resume(Runnable r8) {
        this.mMessageLoop.execute(r8);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception URLDispatch resume ", new Object[]{e});
    }

    public void setResult(String r8, String r10, String r11) {
        this.mFinalUrl = r8;
        this.mEtag = r10;
        this.mEpoch = r11;
    }

    public void waitResult() {
        this.mMessageLoop.loop(300);
    }
}
