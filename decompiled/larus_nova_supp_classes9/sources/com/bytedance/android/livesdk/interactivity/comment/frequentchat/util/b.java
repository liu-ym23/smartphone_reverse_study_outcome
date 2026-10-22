package com.bytedance.android.livesdk.interactivity.comment.frequentchat.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import ga2.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r2, Response r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "response");
        RequestError r0 = ((BaseResponse) r3).error;
        if (r0 == null) goto L5;
        String r1 = r0.prompts;
    L6:
        f2.c(r1, 0);
        StringBuilder r4 = new StringBuilder();
        r4.append(r2);
        r4.append(" status code error, ");
        RequestError r5 = ((BaseResponse) r3).error;
        if (r5 == null) goto L10;
        String r6 = r5.prompts;
        if (r6 == null) goto L10;
    L11:
        r4.append(r6);
        r4.append(", log id: ");
        r4.append(((BaseResponse) r3).logId);
        ALogger.e("FrequentChatApi", r4.toString());
        return;
    L10:
        r6 = BuildConfig.FLAVOR;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public static void a(Throwable r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "defaultPrompt");
        if (r1 == null) goto L8;
        String r4 = e.a(r1);
        if (r4 == null) goto L8;
        r3 = r4;
    L8:
        f2.c(r3, 0);
        ALogger.e("FrequentChatApi", r2 + " Api Error: " + r3);
    }
}
