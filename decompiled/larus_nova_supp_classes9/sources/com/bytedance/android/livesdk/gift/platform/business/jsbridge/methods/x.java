package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftFailedException;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ y a;

    public x(y r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        ApiServerException r7 = (Throwable) r6;
        JSONObject r0 = new JSONObject();
        r0.put("code", 0);
        if ((r7 instanceof ApiServerException) == false) goto L6;
        ApiServerException r8 = r7;
        r0.put("code", r8.getErrorCode());
        r0.put("message", r8.getPrompt());
    L8:
        this.a.finishWithResult(r0);
        return;
    L6:
        if ((r7 instanceof SendGiftFailedException) == false) goto L8;
        JSONObject r2 = new JSONObject();
        r2.put("code", "0");
        r2.put("message", r7.getMessage());
        r0.put("error_data", r2);
        goto L8
    }
}
