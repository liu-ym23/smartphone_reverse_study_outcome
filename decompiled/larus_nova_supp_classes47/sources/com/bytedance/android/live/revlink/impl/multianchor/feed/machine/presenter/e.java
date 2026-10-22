package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Unit r4 = (Unit) r3;
        a r5 = this.a;
        mx0.a r0 = r5.q.c;
        if (r5.b == false) goto L7;
        if (r0 == null) goto L8;
        r5.d(r0);
        return;
    L8:
        return;
    }
}
