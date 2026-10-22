package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        int r0 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.a;
        Intrinsics.checkNotNullParameter("recommend", "scene");
        String r1 = BuildConfig.FLAVOR;
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "defaultPrompt");
        if (r4 == null) goto L8;
        String r5 = ga2.e.a(r4);
        if (r5 == null) goto L8;
        r1 = r5;
    L8:
        ALogger.e("FrequentChatApi", "recommend Api Error: ".concat(r1));
    }
}
