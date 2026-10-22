package com.bytedance.android.annie.bridge.method;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ d0 a;

    public c0(d0 r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        GetDeviceStatsResultModel r11 = (GetDeviceStatsResultModel) r10;
        r11.b(GetDeviceStatsResultModel.Code.Success);
        this.a.finishWithResult(r11);
    }
}
