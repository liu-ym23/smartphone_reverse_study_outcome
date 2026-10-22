package com.bytedance.android.live.revlink.link.infra.rtcbiz;

import fr2.i0;
import fr2.p;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ RTCAdvanceManagerService.b a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ String c;

    public c(RTCAdvanceManagerService.b r1, JSONObject r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        JSONObject r8 = new JSONObject();
        r8.put("pk_rts_key", this.b);
        long r0 = this.a.a.g.M(this.c, r8.toString());
        RTCAdvanceManagerService r9 = this.a.a;
        if (r0 <= r9.d) goto L5;
        r9.d = r0;
    L5:
        v41.a r10 = v41.a.m;
        r10.getClass();
        if (((Boolean) v41.a.b.getValue(r10, v41.a.a[0])).booleanValue() == false) goto L12;
        vc0.a r12 = this.a.a.g.getLiveCore();
        if (r12 == null) goto L12;
        p r13 = i0.a(r12);
        if (r13 == null) goto L12;
        r13.Q3(this.b);
    L12:
        jy0.b.c("RTCAdvanceManagerService", "sendUserMessageOutsideRoom " + this.b, null, 4);
    }
}
