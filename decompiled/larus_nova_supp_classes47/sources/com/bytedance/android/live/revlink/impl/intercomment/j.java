package com.bytedance.android.live.revlink.impl.intercomment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ InteractCommentDataContext.e a;

    public j(InteractCommentDataContext.e r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        InteractCommentDataContext.access$sendAction(this.a.a, new f());
    }
}
