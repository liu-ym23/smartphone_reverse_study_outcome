package com.bytedance.android.livesdk.interactivity.service.richcontent.config;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ck6.a {
    public static final a a = null;

    public a() {
    }

    public final void a() {
    }

    static {
        a = new a();
    }

    public final void info(String r2) {
        if (r2 != null) goto L4;
        r2 = BuildConfig.FLAVOR;
    L4:
        ALogger.i("LiveRichContentTracer", r2);
    }

    public final void error(String r2, Throwable r3) {
        ALogger.e("LiveRichContentTracer", r2, r3);
    }
}
