package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public t(String r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        ExtraResponse r12 = (ExtraResponse) r11;
        String r13 = this.a;
        long r0 = this.b;
        long r7 = System.currentTimeMillis() - r0;
        dl0.m r1 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r13, "token");
        JSONObject r9 = new JSONObject();
        BaseMonitor.add(r9, "token", r13);
        dl0.m.a.getClass();
        dl0.m.z("audience_notify_join_rtc", 0, "", r7, r9);
    }
}
