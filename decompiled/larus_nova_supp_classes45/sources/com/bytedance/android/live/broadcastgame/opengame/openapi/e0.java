package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ NetworkRequestMethod a;

    public e0(NetworkRequestMethod r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        if ((r5 instanceof JSONException) == false) goto L5;
        this.a.n(OpenApiErrorInfo.NET_REQUEST_RESPONSE_INCOMPATIBLE, null);
        return;
    L5:
        this.a.n(OpenApiErrorInfo.INTERNAL_ERROR, null);
        ALogger.d("NetworkRequestMethod", r5.toString());
    }
}
