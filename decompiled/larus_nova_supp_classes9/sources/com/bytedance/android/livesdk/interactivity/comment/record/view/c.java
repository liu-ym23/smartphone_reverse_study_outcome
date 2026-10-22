package com.bytedance.android.livesdk.interactivity.comment.record.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveHighlightRecordTetris a;

    public c(LiveHighlightRecordTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        LiveHighlightRecordTetris r4 = this.a;
        LiveHighlightRecordTetris.StopType r0 = LiveHighlightRecordTetris.StopType.OverTime;
        r4.Z();
    }
}
