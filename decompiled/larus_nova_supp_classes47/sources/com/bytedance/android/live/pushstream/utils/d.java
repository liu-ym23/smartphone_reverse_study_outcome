package com.bytedance.android.live.pushstream.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public d() {
    }

    static {
    }

    public static void a(int r14, int r15) {
        List r3 = CollectionsKt.take(ArraysKt.drop(new Throwable().getStackTrace(), 2), 5);     // Catch: Exception -> L8
        if (r3.isEmpty() == true) goto L13;
        ALogger.i("LiveStream4TAG", "switchVideoCapture: useSelfCapture = false, liveSource = " + r14 + ", liveCoreSource = " + r15 + ", " + CollectionsKt.joinToString$default(r3, "\n", null, null, 0, null, StreamReportUtils$logSwitchVideoCaptureStack$1.INSTANCE, 30, null));     // Catch: Exception -> L8
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c("ttlive_switch_video_capture", null, null, 14);     // Catch: Exception -> L8
        r0.c(String.valueOf(false));     // Catch: Exception -> L8
        r0.i("live_source", Integer.valueOf(r14));     // Catch: Exception -> L8
        r0.i("live_core_source", Integer.valueOf(r15));     // Catch: Exception -> L8
        r0.i("stack_trace", CollectionsKt.joinToString$default(r3, "\n", null, null, 0, null, null, 62, null));     // Catch: Exception -> L8
        r0.i("use_self_capture", Boolean.FALSE);     // Catch: Exception -> L8
        r0.a().report();     // Catch: Exception -> L8
        return;
    L13:
        return;
    L8:
        e = move-exception;
        SafetyGuard.a("LiveStream4TAG", e, null);
    }
}
