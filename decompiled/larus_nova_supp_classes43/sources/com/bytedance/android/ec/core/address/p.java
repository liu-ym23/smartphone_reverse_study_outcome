package com.bytedance.android.ec.core.address;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p<T> implements Consumer {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        AddressSDK.g("init error", r11, 4);
        int r0 = s.a;
        if (r11 == null) goto L5;
        String r1 = r11.getMessage();
    L6:
        s.a(IServerListener.WHAT_NSD_ERROR, "SDK_INIT_ERROR", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB, r1)));
        ECExceptionMonitor.e(r11);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
