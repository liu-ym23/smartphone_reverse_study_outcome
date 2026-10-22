package com.bytedance.android.live.misc;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.IBrowserService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livehybridimpl {
    public LiveService$$livehybridimpl() {
    }

    public static void registerP0Service() {
    }

    public static void registerP2Service() {
    }

    public static void registerP1Service() {
        BrowserServiceImpl r0 = new BrowserServiceImpl();
        jc1.k.l(IBrowserService.class, r0);
        jc1.k.l(IBaseBrowserService.class, r0);
    }

    public static void registerService() {
        BrowserServiceImpl r0 = new BrowserServiceImpl();
        jc1.k.l(IBrowserService.class, r0);
        jc1.k.l(IBaseBrowserService.class, r0);
    }
}
