package com.ss.android.lark.message.universalcard.datachannel;

import com.bytedance.lark.pb.openplatform.v1.UnSubscribeUniversalCardResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e<T> implements SdkSender.IParser {
    public e(UniversalCardSubscriptionManager r1) {
    }

    public final Object parse(byte[] r2) {
        if (r2 == null) goto L6;
        UnSubscribeUniversalCardResponse r3 = (UnSubscribeUniversalCardResponse) UnSubscribeUniversalCardResponse.ADAPTER.decode(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return new UnSubscribeUniversalCardResponse.Builder().build();
    }
}
