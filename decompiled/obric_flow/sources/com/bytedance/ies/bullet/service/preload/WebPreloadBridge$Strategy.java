package com.bytedance.ies.bullet.service.preload;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/bullet/service/preload/WebPreloadBridge$Strategy", "", "Lcom/bytedance/ies/bullet/service/preload/WebPreloadBridge$Strategy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum WebPreloadBridge$Strategy extends Enum<WebPreloadBridge$Strategy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebPreloadBridge$Strategy f6104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WebPreloadBridge$Strategy f6105b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WebPreloadBridge$Strategy f6106c = null;
    public static final WebPreloadBridge$Strategy d = null;
    public static final /* synthetic */ WebPreloadBridge$Strategy[] e = null;

    static {
        WebPreloadBridge$Strategy r5 = new WebPreloadBridge$Strategy("OnlyPreCreate", 0);
        f6104a = r5;
        WebPreloadBridge$Strategy r10 = new WebPreloadBridge$Strategy("PreConnect", 1);
        f6105b = r10;
        WebPreloadBridge$Strategy r11 = new WebPreloadBridge$Strategy("LoadUriOnIdle", 2);
        f6106c = r11;
        WebPreloadBridge$Strategy r12 = new WebPreloadBridge$Strategy("LoadUriRightNow", 3);
        d = r12;
        e = new WebPreloadBridge$Strategy[]{r5, r10, r11, r12};
    }

    public WebPreloadBridge$Strategy(String r5, int r10) {
        super(r5, r10);
    }

    public static WebPreloadBridge$Strategy valueOf(String r5) {
        return (WebPreloadBridge$Strategy) Enum.valueOf(WebPreloadBridge$Strategy.class, r5);
    }

    public static WebPreloadBridge$Strategy[] values() {
        return (WebPreloadBridge$Strategy[]) e.clone();
    }
}
