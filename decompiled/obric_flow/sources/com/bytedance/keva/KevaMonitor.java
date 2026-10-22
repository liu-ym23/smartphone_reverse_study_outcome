package com.bytedance.keva;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class KevaMonitor {
    public KevaMonitor() {
    }

    public void loadLibrary(String r5) {
        System.loadLibrary(r5);
    }

    public void logDebug(String r5) {
        Log.d(KevaConstants.TAG, r5);
    }

    public void onLoadRepo(String r5, int r10) {
        Log.d(KevaConstants.TAG, "load repo: " + r5 + ", with mode: " + r10);
    }

    public void reportThrowable(int r5, String r10, String r11, Object r12, Throwable r13) {
        Log.e(KevaConstants.TAG, "action: [" + r5 + "], repo: [" + r10 + "], key: [" + r11 + "], value: [" + r12 + "], has error: " + r13.getMessage(), r13);
    }

    public void reportWarning(int r5, String r10, String r11, Object r12, String r13) {
        Log.w(KevaConstants.TAG, "action: [" + r5 + "], repo: [" + r10 + "], key: [" + r11 + "], value: [" + r12 + "], has waring: " + r13);
    }
}
