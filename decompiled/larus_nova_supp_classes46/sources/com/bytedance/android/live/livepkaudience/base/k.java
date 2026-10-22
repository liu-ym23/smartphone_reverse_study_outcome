package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public k(p r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r11) {
        com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
        this.a.h = false;
        long r0 = this.b;
        long r7 = System.currentTimeMillis() - r0;
        String r13 = this.c;
        dl0.m r1 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r13, "reqFrom");
        JSONObject r9 = new JSONObject();
        BaseMonitor.add(r9, "request_source", r13);
        dl0.m.a.getClass();
        dl0.m.z("audience_finish", 0, "", r7, r9);
        Iterator<g> r14 = this.a.e.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r14.next().u0();
        goto L4
    L6:
        this.a.i.put("cmd_finish_video_talk_room_result", Boolean.TRUE);
    }
}
