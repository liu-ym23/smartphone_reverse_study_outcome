package com.bytedance.ai.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements f09.a.b {
    public l() {
    }

    public final void onAllActivityDestroyed() {
    }

    public final void onAppForeground() {
    }

    public final void onAppBackground() {
        AppsInstalledStatusUtils.a("com.ss.android.ugc.aweme", new j());
        AppsInstalledStatusUtils.a("com.luna.music", new k());
    }
}
