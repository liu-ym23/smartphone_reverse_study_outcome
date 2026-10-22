package com.ss.bduploader.net;

/* JADX INFO: loaded from: classes6.dex */
public class DNSServerIP {
    private static final String TAG = "DNSServerIP";
    private static final int UPDATE_PEROID = 300000;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;

    public DNSServerIP() {
    }

    static /* synthetic */ String access$002(String r0) {
        mServerIP = r0;
        return r0;
    }

    static /* synthetic */ long access$102(long r0) {
        mServerIPTime = r0;
        return r0;
    }

    public static String getDNSServerIP() {
        updateDNSServerIP();
        return mServerIP;
    }

    public static void updateDNSServerIP() {
        if ((System.currentTimeMillis() - mServerIPTime) >= 300000) goto L5;
        return;
    L5:
        BDUploadThreadPool.addExecuteTask(new AnonymousClass1());
    }
}
