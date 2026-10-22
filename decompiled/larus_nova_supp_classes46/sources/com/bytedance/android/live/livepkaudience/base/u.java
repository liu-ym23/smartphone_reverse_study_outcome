package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;

    public u(long r1, String r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r11) {
        ApiServerException r12 = (Throwable) r11;
        Intrinsics.checkNotNullParameter(r12, "throwable");
        long r0 = this.a;
        long r7 = System.currentTimeMillis() - r0;
        String r1 = this.b;
        dl0.m r2 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r1, "token");
        JSONObject r9 = new JSONObject();
        BaseMonitor.add(r9, "token", r1);
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r12 instanceof ApiServerException) == false) goto L10;
        dl0.m r3 = dl0.m.a;
        ApiServerException r13 = r12;
        int r5 = r13.getErrorCode();
        String r14 = r13.getErrorMsg();
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        r3.getClass();
        dl0.m.z("audience_notify_join_rtc", r5, r14, r7, r9);
        return;
    L10:
        dl0.m r4 = dl0.m.a;
        String r6 = r12.toString();
        r4.getClass();
        dl0.m.z("audience_notify_join_rtc", 1, r6, r7, r9);
    }
}
