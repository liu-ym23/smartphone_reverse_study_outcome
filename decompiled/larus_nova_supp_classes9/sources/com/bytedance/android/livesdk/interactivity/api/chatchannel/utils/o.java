package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public static final long a(BaseMessage r2) {
        if (r2 == null) goto L6;
        CommonMessageData r3 = r2.baseMessage;
        if (r3 == null) goto L6;
        return r3.channelId;
    L6:
        return 0;
    }

    public static final long b(tlc.d r2) {
        if ((r2 instanceof BaseMessage) == true) goto L5;
        r2 = null;
    L5:
        BaseMessage r3 = (BaseMessage) r2;
        if (r3 == null) goto L10;
        CommonMessageData r4 = r3.baseMessage;
        if (r4 == null) goto L10;
        return r4.channelId;
    L10:
        return 0;
    }
}
