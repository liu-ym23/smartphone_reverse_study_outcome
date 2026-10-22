package com.bytedance.android.annie.bridge.method;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getDeviceStats")
public final class d0 extends a<e0, GetDeviceStatsResultModel> {
    public Disposable a;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public d0() {
    }

    public final void invoke(Object r10, CallContext r11) {
        e0 r12 = (e0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        this.a = Observable.create(new b0(r12, r11)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(this));
    }
}
