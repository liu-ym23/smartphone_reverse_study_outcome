package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ v a;

    public u(v r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ALogger.e("ShowPayCancelChargePanelEvent", ExceptionsKt.stackTraceToString((Throwable) r2));
        this.a.a = false;
    }
}
