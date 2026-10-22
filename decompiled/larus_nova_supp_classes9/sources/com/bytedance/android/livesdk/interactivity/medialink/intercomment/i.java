package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MediaInteractCommentDataContext.f a;

    public i(MediaInteractCommentDataContext.f r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        MediaInteractCommentDataContext.access$sendAction(this.a.a, new e());
    }
}
