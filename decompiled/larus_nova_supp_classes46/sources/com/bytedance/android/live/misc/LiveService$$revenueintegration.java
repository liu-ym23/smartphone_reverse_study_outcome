package com.bytedance.android.live.misc;

import com.bytedance.android.live.revenue.ILiveRevenueService;
import com.bytedance.android.live.revenue.IRevenueService;
import com.bytedance.android.live.revenue.RevenueServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$revenueintegration {
    private static final com.bytedance.android.live.revenue.e serviceInitializer = null;

    public LiveService$$revenueintegration() {
    }

    static {
        serviceInitializer = new com.bytedance.android.live.revenue.e();
    }

    public static void registerP0Service() {
        RevenueServiceImpl r0 = new RevenueServiceImpl();
        jc1.k.l(IRevenueService.class, r0);
        jc1.k.l(ILiveRevenueService.class, r0);
        serviceInitializer.d();
    }

    public static void registerP1Service() {
        serviceInitializer.b();
    }

    public static void registerP2Service() {
        serviceInitializer.c();
    }

    public static void registerService() {
        RevenueServiceImpl r0 = new RevenueServiceImpl();
        jc1.k.l(IRevenueService.class, r0);
        jc1.k.l(ILiveRevenueService.class, r0);
        serviceInitializer.a();
    }
}
