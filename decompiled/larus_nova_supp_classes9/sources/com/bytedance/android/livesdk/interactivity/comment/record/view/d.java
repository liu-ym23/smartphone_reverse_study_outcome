package com.bytedance.android.livesdk.interactivity.comment.record.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LiveHighlightRecordTetris a;

    public d(LiveHighlightRecordTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.W();
    }
}
