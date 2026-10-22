package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.base.model.data.activityemoji.b a;

    public u(com.bytedance.android.live.base.model.data.activityemoji.b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("input activity emoji failed due to " + ((Throwable) r3).getMessage() + ", emoji id: " + this.a.getIdStr());
    }
}
