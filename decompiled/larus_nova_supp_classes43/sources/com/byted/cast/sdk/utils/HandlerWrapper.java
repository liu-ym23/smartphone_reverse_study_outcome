package com.byted.cast.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class HandlerWrapper {
    private final Handler mHandler;

    public Looper getLooper() {
        return this.mHandler.getLooper();
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public HandlerWrapper(Handler r1) {
        this.mHandler = r1;
    }

    public boolean post(Runnable r10) {
        return this.mHandler.post(r10);
    }

    public void removeCallbacks(Runnable r10) {
        this.mHandler.removeCallbacks(r10);
    }

    public void removeMessages(int r10) {
        this.mHandler.removeMessages(r10);
    }

    public boolean postDelayed(Runnable r10, long r11) {
        return this.mHandler.postDelayed(r10, r11);
    }

    public void sendMessageDelayed(Message r10, long r11) {
        this.mHandler.sendMessageDelayed(r10, r11);
    }
}
