package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;
import w20.q7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ PkAnchorLauncher a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ a.b e;

    public f(PkAnchorLauncher r1, String r2, int r3, long r4, com.bytedance.android.live.revlink.impl.jsb.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        b21.e r0 = this.a.z();
        if (r0 == null) goto L5;
        String r1 = this.b;
        int r2 = this.c;
        int r4 = ((Number) this.a.u.invoke()).intValue();
        long r5 = t.a(this.d);
        int r10 = b21.e.b;
        r0.h(r1, r2, null, r4, r5);
    L5:
        this.a.h.setValue(c21.c.C0008c.a);
        q7 r12 = new q7();
        r12.a = 1;
        a.b r3 = this.e;
        if (r3 == null) goto L9;
        r3.a(r12);
        return;
    }
}
