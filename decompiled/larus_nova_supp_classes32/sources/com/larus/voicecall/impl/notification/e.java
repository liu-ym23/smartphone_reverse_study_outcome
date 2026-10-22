package com.larus.voicecall.impl.notification;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final MutableSharedFlow<Integer> a = null;

    static {
        a = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static PendingIntent a(String r4) {
        AppHost.Companion r1 = AppHost.a;
        Application r2 = r1.getApplication();
        if (z2.a.Z2() == false) goto L5;
        Class r3 = RealtimeCallRTCMicAndPlaybackService.class;
    L6:
        Intent r0 = new Intent(r2, r3);
        r0.setAction(r4);
        Application r5 = r1.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L9;
        int r6 = 201326592;
    L11:
        return PendingIntent.getService(r5, 101, r0, r6);
    L9:
        r6 = 134217728;
        goto L11
    L5:
        r3 = RTCService.class;
        goto L6
    }
}
