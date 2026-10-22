package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public static final String a(Throwable r2) {
        if (r2 != null) goto L5;
        return CardLockInfo.sUNKNOWN;
    L5:
        if ((r2 instanceof ApiServerException) == false) goto L8;
        StringBuilder r0 = new StringBuilder("api error, code is ");
        ApiServerException r3 = (ApiServerException) r2;
        r0.append(r3.getErrorCode());
        r0.append(", prompts is ");
        r0.append(r3.getPrompt());
        return r0.toString();
    L8:
        return "message is " + r2.getMessage();
    }
}
