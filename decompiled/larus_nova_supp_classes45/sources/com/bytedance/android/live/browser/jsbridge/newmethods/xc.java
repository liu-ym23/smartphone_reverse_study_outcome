package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showLeaveRoomDialog")
public final class xc extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final CompositeDisposable a;

    public final void onTerminate() {
        this.a.clear();
    }

    public xc() {
        this.a = new CompositeDisposable();
    }

    public final void invoke(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter((JSONObject) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        JSONObject r6 = new JSONObject();
        com.bytedance.android.livesdk.widget.z0 r0 = com.bytedance.android.livesdk.widget.z0.a();
        Context r7 = r5.getContext();
        r0.getClass();
        com.bytedance.android.livesdk.widget.x0.b r1 = new com.bytedance.android.livesdk.widget.x0.b(r7, 4);
        r1.a.d = "确认前往其他直播间吗？";
        r1.i(1, 2131915442, new uc(r6));
        r1.i(0, 2131917187, new vc(r6));
        r1.a.i = new wc(this, r6);
        r1.n();
    }
}
