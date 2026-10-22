package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTMonitorProvider {
    public TTMonitorProvider() {
    }

    public abstract void handleApiResult(boolean r10, String r11, String r12, String r13, long r14, long r15, long r16, long r17, long r18, long r19, long r110, long r111, long r21, long r23, boolean r25, long r26, long r28, String r30, String r31, String r32, int r33, int r34, String r35);

    public abstract boolean handleApiSample(String r10, String r11);

    public abstract void sendAppMonitorEvent(String r10, String r11);
}
