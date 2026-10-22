package com.bytedance.android.live.messagewindow.framework.handler;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ BottomRightCommonCardHandler a;

    public c(BottomRightCommonCardHandler r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(this.a.b);
        r1.c("recreateCard error, " + r6);
        Unit r7 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }
}
