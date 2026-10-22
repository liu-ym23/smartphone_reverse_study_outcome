package com.bytedance.android.live.revlink.impl.intercomment;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ InteractCommentWidget a;

    public m(InteractCommentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        q11.b r3 = (q11.b) r2;
        InteractCommentWidget r4 = this.a;
        int r0 = InteractCommentWidget.n;
        r4.yq(false);
    }
}
