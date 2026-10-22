package com.bytedance.android.live.misc;

import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.chatroom.reserve.IAppointmentService;
import com.bytedance.android.livesdk.feed.LiveFeedOuterService;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdk.feed.tab.FeedUrlService;
import com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livefeed {
    private static volatile boolean initComplete;

    public LiveService$$livefeed() {
    }

    public static void registerP1Service() {
    }

    public static void registerP0Service() {
        jc1.k.l(ILiveFeedOuterService.class, new LiveFeedOuterService());
    }

    public static void registerP2Service() {
        jc1.k.l(IAppointmentService.class, new AppointmentService());
        jc1.k.l(IHostFeed.class, new FeedUrlService());
    }

    public static void registerService() {
        if (initComplete == false) goto L5;
        return;
    L5:
        monitor-enter(LiveService$$livefeed.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (initComplete == false) goto L11;
        monitor-exit(LiveService$$livefeed.class);     // Catch: Throwable -> L17
        return;
    L11:
        if (LiveInitAssistant.INSTANCE.getInitOptimizeConfig().getPreInitLiveOptV2() == false) goto L13;
        jc1.k.m(ILiveFeedOuterService.class, new i());     // Catch: Throwable -> L17
    L14:
        jc1.k.l(IAppointmentService.class, new AppointmentService());     // Catch: Throwable -> L17
        jc1.k.l(IHostFeed.class, new FeedUrlService());     // Catch: Throwable -> L17
        initComplete = true;     // Catch: Throwable -> L17
        monitor-exit(LiveService$$livefeed.class);     // Catch: Throwable -> L17
        return;
    L13:
        jc1.k.l(ILiveFeedOuterService.class, new LiveFeedOuterService());     // Catch: Throwable -> L17
        goto L14
    }
}
