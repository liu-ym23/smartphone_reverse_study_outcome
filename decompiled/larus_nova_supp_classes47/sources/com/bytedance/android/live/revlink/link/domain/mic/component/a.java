package com.bytedance.android.live.revlink.link.domain.mic.component;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ FollowComponent a;

    public a(FollowComponent r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        NextLiveData<Boolean> r0 = this.a.b;
        if (((Integer) r2).intValue() <= 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setValue(Boolean.valueOf(r3));
        return;
    L5:
        r3 = false;
        goto L6
    }
}
