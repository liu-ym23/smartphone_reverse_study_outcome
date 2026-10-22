package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LinkingInvitePreloadUtils a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public d(LinkingInvitePreloadUtils r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Throwable r5 = (Throwable) r7;
        v r0 = this.a.d();
        if (r0 == null) goto L5;
        r0.o("preload", this.b, t.a(this.c), r5);
    L5:
        this.a.b("preloadFailed");
    }
}
