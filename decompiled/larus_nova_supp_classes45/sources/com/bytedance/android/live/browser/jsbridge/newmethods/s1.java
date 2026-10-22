package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s1<T> implements Consumer {
    public final /* synthetic */ r1 a;
    public final /* synthetic */ w20.z7 b;

    public s1(r1 r1, w20.z7 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        String r0 = this.b.a();
        if (r0 == null) goto L11;
        if (r5 == null) goto L6;
        String r6 = String.valueOf(r5.longValue());
    L8:
        if (r0.equals(r6) != true) goto L12;
        this.a.finishWithSuccess();
        return;
    L12:
        return;
    L6:
        r6 = null;
        goto L8
    }
}
