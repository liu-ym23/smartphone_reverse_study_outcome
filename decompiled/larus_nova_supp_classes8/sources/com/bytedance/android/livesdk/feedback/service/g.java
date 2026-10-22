package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        ALogger.e("RoomLightFeedbackConfig", "获取问卷失败" + r6.getMessage(), r6);
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r1.a = "RoomLightFeedbackConfig";
        r1.c("获取问卷数据失败");
        r1.b(new Pair[]{TuplesKt.to("error", r6.getMessage())});
        r1.d();
        if (v.a() == true) goto L5;
        return;
    L5:
        throw r6;
    }
}
