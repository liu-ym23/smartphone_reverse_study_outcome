package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.lottie.ILottieService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "lottieAnimation")
public final class c2 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public Disposable a;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public c2() {
    }

    public final void invoke(Object r5, CallContext r6) {
        JSONObject r7 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        long r0 = r7.optLong("assetId", 0);
        boolean r8 = r7.optBoolean("autoFinish", false);
        this.a = jc1.k.n(ILottieService.class).tryStartLottieAnimation(r0, r8).observeOn(AndroidSchedulers.mainThread()).subscribe(new a2(this, r6), new b2(this, r6));
    }
}
