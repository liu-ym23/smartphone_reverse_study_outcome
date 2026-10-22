package com.bytedance.android.live.revlink.impl.pk.scope.service;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.scope.m;
import cy0.f;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final void a() {
        m r0 = m.e;
        r0.getClass();
        f r1 = r0.a(m.d, f.class);
        if (r1 == null) goto L5;
        a r2 = (a) r0.d(r1, a.class);
    L6:
        if (r2 == null) goto L13;
        r2.a = r2.g.Ig();
        r2.b = r2.g.getPkUtils().g();
        e r3 = r2.a;
        if (r3 == null) goto L14;
        LiveData<List<cf2.a>> r4 = r3.getBaseScoreState();
        if (r4 == null) goto L15;
        r4.observeForever(r2.e);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
