package com.bytedance.android.live.revlink.impl.multianchor.ui;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public j(p r1, String r2) {
        this.a = r1;
        this.b = r2;
        this.c = "connection_manage_setting";
    }

    public final void accept(Object r4) {
        IFollowPair r5 = (IFollowPair) r4;
        this.a.c = false;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r6 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r6 == null) goto L5;
        r6.A(this.b, this.c, true);
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r7 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r7 == null) goto L9;
        String r1 = this.b;
        this.a.getClass();
        r7.x(r1, true, this.c);
        return;
    }
}
