package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ q a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public r(q r1, long r2) {
        this.a = r1;
        this.b = "cancel_application";
        this.c = r2;
    }

    public final void accept(Object r11) {
        com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
        this.a.g = false;
        String r13 = this.b;
        long r0 = this.c;
        long r7 = System.currentTimeMillis() - r0;
        dl0.m r1 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r13, "reqFrom");
        JSONObject r9 = new JSONObject();
        BaseMonitor.add(r9, "request_source", r13);
        dl0.m.a.getClass();
        dl0.m.z("audience_leave", 0, "", r7, r9);
        Iterator<h> r14 = this.a.c.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r14.next().Pb(this.b);
        goto L4
    }
}
