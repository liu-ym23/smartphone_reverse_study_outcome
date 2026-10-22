package com.mammon.audiosdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SAMICoreNativeWakeupUploadTaskCallback {
    private static SAMICoreWakeupUploadTaskCallback userCallback;

    public SAMICoreNativeWakeupUploadTaskCallback() {
    }

    public static void onWakeupUploadTask(byte[] r1) {
        SAMICoreWakeupUploadTaskCallback r0 = userCallback;
        if (r0 == null) goto L6;
        r0.onWakeupUploadTask(r1);
        return;
    }

    public static void setWakeupUploadTaskCallback(SAMICoreWakeupUploadTaskCallback r0) {
        userCallback = r0;
    }
}
