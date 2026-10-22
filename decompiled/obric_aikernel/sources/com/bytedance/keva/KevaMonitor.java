package com.bytedance.keva;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class KevaMonitor {
    public KevaMonitor() {
    }

    protected void loadLibrary(String r10) {
        System.loadLibrary(r10);
    }

    protected void logDebug(String r10) {
        Log.println(4, KevaConstants.TAG, r10);
    }

    protected void onLoadRepo(String r10, int r11) {
        Log.println(4, KevaConstants.TAG, "load repo: " + r10 + ", with mode: " + r11);
    }

    protected void reportThrowable(int r10, String r11, String r12, Object r13, Throwable r14) {
        Log.e(KevaConstants.TAG, "action: [" + r10 + "], repo: [" + r11 + "], key: [" + r12 + "], value: [" + r13 + "], msg: " + r14.getMessage(), r14);
    }

    protected void reportWarning(int r10, String r11, String r12, Object r13, String r14) {
        Log.println(5, KevaConstants.TAG, "action: [" + r10 + "], repo: [" + r11 + "], key: [" + r12 + "], value: [" + r13 + "], msg: " + r14);
    }
}
