package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Deprecated(message = "banner动态化后不使用")
@XBridgeMethod(biz = "webcast", name = "saveGiftExtraDataToNative")
public final class q extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public Disposable a;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public q() {
    }

    public final void invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.optString("biz_type");
        if (r6 != null) goto L6;
    L11:
        boolean r7 = false;
    L12:
        this.a = Single.fromCallable(new n(r5)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, r7), new p(this));
        return;
    L6:
        if (r6.hashCode() != 210881801) goto L11;
        if (r6.equals("market_mission_finish") == false) goto L11;
        r7 = true;
        goto L12
    }
}
