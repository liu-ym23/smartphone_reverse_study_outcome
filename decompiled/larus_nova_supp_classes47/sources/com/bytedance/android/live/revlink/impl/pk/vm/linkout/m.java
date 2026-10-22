package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ PkAutoMatchManager a;

    public m(PkAutoMatchManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Long r6 = (Long) r5;
        if (r6 == null) goto L20;
        long r0 = r6.longValue();
        PkAutoMatchDataContext r7 = this.a.d;
        if (r7 != null) goto L7;
        return;
    L7:
        if (r0 != r7.getExpectTime()) goto L22;
        PkAutoMatchDataContext r8 = this.a.d;
        if (r8 != null) goto L11;
        return;
    L11:
        if (r8.isSpeedUp() == false) goto L13;
        return;
    L13:
        if (this.a.b == true) goto L25;
        d51.c r9 = d51.c.A0;
        r9.getClass();
        if (((Boolean) d51.c.h.getValue(r9, d51.c.a[6])).booleanValue() == true) goto L26;
        this.a.k.a();
        PkAutoMatchManager r10 = this.a;
        if (r10.a == false) goto L27;
        r10.b = true;
        r10.a = false;
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L22:
        return;
    }
}
