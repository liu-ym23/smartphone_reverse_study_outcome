package com.bytedance.crypto.cloudsync;

import com.bytedance.crypto.monitor.ErrorEvent;
import com.bytedance.crypto.monitor.NormalEvent;
import com.bytedance.crypto.monitor.proto.CloudSyncData;

/* JADX INFO: loaded from: classes.dex */
public class EventTrace {
    public EventTrace() {
    }

    public static void eventTrace(int r10, int r11, String r12, String r13, long r14, int r15) {
        int r16 = 1;
        if (r10 != 0) goto L10;
        if (r11 == 0) goto L8;
        if (r11 == 1) goto L8;
        NormalEvent.getInstance().eventRecord(0, r11, r12, r13, r14, r15);
        return;
    L8:
        NormalEvent.getInstance().eventReport(0, r11, r12, r13, r14);
        return;
    L10:
        if (r11 != 5) goto L12;
    L20:
        r16 = 2;
    L21:
        ErrorEvent.eventTrace(0, r11, r12, r13, r10, r14, CloudSyncData.newBuilder().setCryptoMode(r16).setDataSize(r15).build());
        return;
    L12:
        if (r11 == 7) goto L20;
        if (r11 == 4) goto L21;
        if (r11 == 6) goto L21;
        r16 = 0;
        goto L21
    }
}
