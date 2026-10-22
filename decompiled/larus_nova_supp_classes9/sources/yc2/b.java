package yc2;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "ecDirectSplash")
public final class b extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public b() {
    }

    public final Object invoke(Object r5, CallContext r6) throws Exception {
        JSONObject r7 = (JSONObject) r5;
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.k;
        Boolean r1 = Boolean.TRUE;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        Bundle r2 = new Bundle();
        Iterator<String> r3 = r7.keys();
    L4:
        if (r3.hasNext() == false) goto L6;
        String r4 = r3.next();
        r2.putString(r4, r7.optString(r4));
        goto L4
    L6:
        r2.putLong("click_time", System.currentTimeMillis());
        IHostCommerceServiceLive r8 = k.f(IHostCommerceServiceLive.class);
        if (r8 == null) goto L9;
        r8.tryShowLiveFlashFragment(r6.getContext(), r2, null);
    L9:
        return null;
    }
}
