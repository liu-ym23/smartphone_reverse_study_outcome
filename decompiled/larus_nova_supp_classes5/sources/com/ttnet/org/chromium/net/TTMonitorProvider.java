package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class TTMonitorProvider {
    public TTMonitorProvider() {
    }

    public abstract void handleApiResult(boolean r1, String r2, String r3, String r4, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, boolean r25, long r26, long r28, long r30, String r32, String r33, String r34, int r35, int r36, String r37, String r38);

    public abstract boolean handleApiSample(String r1, String r2);

    public abstract void sendAppMonitorEvent(String r1, String r2);
}
