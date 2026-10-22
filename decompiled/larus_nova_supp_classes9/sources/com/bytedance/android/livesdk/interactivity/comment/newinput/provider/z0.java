package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0<T> implements Consumer {
    public final /* synthetic */ MarkHighlightController a;

    public z0(MarkHighlightController r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        if ((r4 instanceof ApiServerException) == true) goto L5;
        r4 = null;
    L5:
        ApiServerException r5 = (ApiServerException) r4;
        if (r5 == null) goto L8;
        int r6 = r5.getErrorCode();
    L10:
        if (r6 != 4011137) goto L12;
    L13:
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getMarkHighlightStatusCode();
        if (r1 == null) goto L18;
        r1.setValue(Integer.valueOf(r6));
    L18:
        b72.b.a(r6);
        MarkHighlightController r7 = this.a;
        r7.k(r7.d);
        ALogger.e("MarkHighlightController", "get data error");
        return;
    L12:
        if (r6 != 4003220) goto L18;
    L8:
        r6 = 0;
        goto L10
    }
}
