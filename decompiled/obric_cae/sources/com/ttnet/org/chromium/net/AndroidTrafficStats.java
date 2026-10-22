package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android::traffic_stats")
public class AndroidTrafficStats {
    private AndroidTrafficStats() {
    }

    @CalledByNative
    private static long getCurrentUidRxBytes() {
        long r8 = TrafficStats.getUidRxBytes(Process.myUid());
        if (r8 != (-1)) goto L7;
        return 0;
    L7:
        return r8;
    }

    @CalledByNative
    private static long getCurrentUidTxBytes() {
        long r8 = TrafficStats.getUidTxBytes(Process.myUid());
        if (r8 != (-1)) goto L7;
        return 0;
    L7:
        return r8;
    }

    @CalledByNative
    private static long getTotalRxBytes() {
        long r8 = TrafficStats.getTotalRxBytes();
        if (r8 != (-1)) goto L7;
        return 0;
    L7:
        return r8;
    }

    @CalledByNative
    private static long getTotalTxBytes() {
        long r8 = TrafficStats.getTotalTxBytes();
        if (r8 != (-1)) goto L7;
        return 0;
    L7:
        return r8;
    }
}
