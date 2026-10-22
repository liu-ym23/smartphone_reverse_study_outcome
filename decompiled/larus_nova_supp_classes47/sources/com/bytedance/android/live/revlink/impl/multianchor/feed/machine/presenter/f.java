package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ a a;

    public f(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Unit r3 = (Unit) r2;
        a r4 = this.a;
        r4.b(r4.n);
    }
}
