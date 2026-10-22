package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.content.Context;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ PinAnswerProcessor a;
    public final /* synthetic */ String b;

    public i(PinAnswerProcessor r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        o32.a.b("send comment failed before " + this.b, r4);
        g42.c r0 = this.a.b;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        ExceptionUtils.handleException(r1, r4);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
