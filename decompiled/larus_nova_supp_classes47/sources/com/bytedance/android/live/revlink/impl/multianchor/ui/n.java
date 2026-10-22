package com.bytedance.android.live.revlink.impl.multianchor.ui;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public n(p r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        IFollowPair r5 = (IFollowPair) r4;
        this.a.c = false;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r6 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r6 == null) goto L6;
        r6.A(this.b, this.c, false);
        return;
    }
}
