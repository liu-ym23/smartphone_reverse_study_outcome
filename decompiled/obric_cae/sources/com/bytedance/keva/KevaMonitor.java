package com.bytedance.keva;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class KevaMonitor {
    public KevaMonitor() {
    }

    public void loadLibrary(String r8) {
        System.loadLibrary(r8);
    }

    public void logDebug(String r8) {
        Log.println(4, KevaConstants.TAG, r8);
    }

    public void onLoadRepo(String r8, int r10) {
        Log.println(4, KevaConstants.TAG, "load repo: " + r8 + ", with mode: " + r10);
    }

    public void reportThrowable(int r8, String r10, String r11, Object r12, Throwable r13) {
        Log.e(KevaConstants.TAG, "action: [" + r8 + "], repo: [" + r10 + "], key: [" + r11 + "], value: [" + r12 + "], msg: " + r13.getMessage(), r13);
    }

    public void reportWarning(int r8, String r10, String r11, Object r12, String r13) {
        Log.println(5, KevaConstants.TAG, "action: [" + r8 + "], repo: [" + r10 + "], key: [" + r11 + "], value: [" + r12 + "], msg: " + r13);
    }
}
