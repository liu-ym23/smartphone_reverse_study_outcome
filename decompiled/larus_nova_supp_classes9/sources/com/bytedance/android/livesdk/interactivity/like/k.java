package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ d a;

    public k(d r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        StringBuilder r0 = new StringBuilder("digg failed: ");
        if (r5 == null) goto L5;
        String r6 = r5.getMessage();
    L6:
        r0.append(r6);
        r0.append(", room id: ");
        r0.append(this.a.d);
        r0.append(", target uid ");
        r0.append(this.a.e);
        r0.append("; current diggCount: ");
        r0.append(this.a.b);
        ALogger.e("DiggHandler", r0.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }
}
