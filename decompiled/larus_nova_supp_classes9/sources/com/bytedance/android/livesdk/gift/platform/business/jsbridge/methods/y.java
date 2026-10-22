package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
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

    public y() {
    }

    public final void invoke(Object r63, CallContext r64) {
        JSONObject r1 = (JSONObject) r63;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r64, "context");
        long r6 = r1.optLong("propID", 0);
        int r2 = r1.optInt("count", 0);
        String r24 = r1.optString("ref_id", BuildConfig.FLAVOR);
        String r13 = r1.optString("gift_source", "jsbpage");
        if (r6 <= 0) goto L7;
        if (r2 <= 0) goto L8;
        this.a = jc1.k.n(IGiftService.class).sendProp(new b0(r6, SendGiftSource.JsbPage, null, null, 0, 0, r13, null, null, null, 0, null, null, false, null, 0, true, r24, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -196676, 8388607), r2).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(this), new x(this));
        return;
    L8:
        return;
    }
}
