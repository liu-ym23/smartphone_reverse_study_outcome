package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w0<T> implements Consumer {
    public final /* synthetic */ MarkHighlightController a;

    public w0(MarkHighlightController r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ALogger.d("HighlightBacktrackUtil", String.valueOf((Throwable) r2));
        this.a.j(false);
        int r3 = e72.c.a;
        e72.c.a(this.a.t);
    }
}
