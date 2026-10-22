package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "handleDetainmentDialog")
public final class o0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public static final WeakHashMap<Context, Pair<String, String>> a = null;

    public static final class a {
    }

    public final void onTerminate() {
    }

    static {
        a = new WeakHashMap();
    }

    public o0() {
    }

    public final void invoke(Object r7, CallContext r8) {
        JSONObject r9 = (JSONObject) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        String r0 = r9.optString("room_id");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        finishWithFailure();
        ALogger.e("DetainmentMethod", "id should`nt be null ");
    L12:
        int r4 = r9.optInt("action");
        String r10 = r9.optString("scene");
        if (r10 != null) goto L15;
    L16:
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        finishWithFailure();
        ALogger.e("DetainmentMethod", "scene should`nt be null");
    L19:
        if (r4 != 0) goto L21;
        Pair<String, String> r2 = new Pair(r0, r10);
        a.put(r8.getContext(), r2);
    L23:
        finishWithSuccess();
        return;
    L21:
        if (r4 != 1) goto L23;
        a.remove(r8.getContext());
        goto L23
    L15:
        if (r10.length() != 0) goto L17;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L10
    }
}
