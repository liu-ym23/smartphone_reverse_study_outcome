package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ f a;

    public j(f r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IFollowPair r3 = (IFollowPair) r2;
        if (r3 == null) goto L6;
        this.a.a(r3.getFollowStatus());
        return;
    }
}
