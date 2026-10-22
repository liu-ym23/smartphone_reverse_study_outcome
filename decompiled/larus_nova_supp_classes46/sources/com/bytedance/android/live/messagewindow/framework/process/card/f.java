package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ PkPs a;

    public f(PkPs r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r0 = this.a.a;
        if (r0 == null) goto L19;
        com.bytedance.android.live.messagewindow.framework.process.a r1 = (com.bytedance.android.live.messagewindow.framework.process.a) r0.d();
        if (r1 == null) goto L19;
        y61.b r2 = r1.b;
        if (r2 == null) goto L19;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r3 = r2.monitor();
        if (r3 == null) goto L19;
        CardAlogParamsBuilder r4 = new CardAlogParamsBuilder();
        r4.c("PkPs runnable run error");
        int r5 = 0;
        Pair[] r6 = {TuplesKt.to("task", String.valueOf(this.a.g)), TuplesKt.to("skipProcessNext", Boolean.valueOf(this.a.h)), TuplesKt.to("error_msg", r9)};
    L11:
        if (r5 >= 3) goto L18;
        Pair r10 = r6[r5];
        if (r10 == null) goto L17;
        Object r7 = r10.getSecond();
        if (r7 == null) goto L17;
        r4.a((String) r10.getFirst(), r7);
    L17:
        r5 = r5 + 1;
        goto L11
    L18:
        Unit r11 = Unit.INSTANCE;
        r3.d(r4.b());
    L19:
        this.a.e();
    }
}
