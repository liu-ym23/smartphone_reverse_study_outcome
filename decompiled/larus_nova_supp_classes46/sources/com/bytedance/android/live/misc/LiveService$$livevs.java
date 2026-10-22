package com.bytedance.android.live.misc;

import com.bytedance.android.live.base.service.IVSReportService;
import com.bytedance.android.livesdk.chatroom.vs.report.VSReportServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livevs {
    public LiveService$$livevs() {
    }

    public static void registerP0Service() {
    }

    public static void registerP2Service() {
    }

    public static void registerP1Service() {
        jc1.k.l(IVSReportService.class, new VSReportServiceImpl());
    }

    public static void registerService() {
        jc1.k.l(IVSReportService.class, new VSReportServiceImpl());
    }
}
