package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;
import w20.q7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ PkAnchorLauncher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;
    public final /* synthetic */ String f;
    public final /* synthetic */ JSONObject g;
    public final /* synthetic */ a.b h;

    public d(PkAnchorLauncher r1, int r2, long r3, long r5, long r7, String r9, JSONObject r10, com.bytedance.android.live.revlink.impl.jsb.a r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r12;
    }

    public final void accept(Object r15) {
        ExtraResponse r16 = (ExtraResponse) r15;
        d31.f r17 = PkAnchorLauncher.r(this.a);
        if (r17 == null) goto L5;
        r17.e("linkmic/battle/open/", new d31.a(0, 0, 0, 0, null, 0, this.b, null, null, "duration=" + this.c, null, 3007), t.a(this.d));
    L5:
        b21.e r0 = this.a.z();
        if (r0 == null) goto L8;
        long r1 = this.e;
        String r3 = this.f;
        JSONObject r4 = this.g;
        long r5 = t.a(this.d);
        int r7 = ((Number) this.a.u.invoke()).intValue();
        int r18 = b21.e.b;
        r0.g(r1, r3, r4, r5, r7, null);
    L8:
        q7 r19 = new q7();
        r19.a = 1;
        a.b r2 = this.h;
        if (r2 == null) goto L12;
        r2.a(r19);
        return;
    }
}
