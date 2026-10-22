package com.ss.android.lark.message.lynxcard.action;

import com.bytedance.lark.pb.openplatform.v1.UpdateMessageCardLocalDataResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.plugin.MsgCardUpdateLocalDataResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements SdkSender.IParser {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object parse(byte[] r3) {
        if (r3 == null) goto L4;
        UpdateMessageCardLocalDataResponse r4 = (UpdateMessageCardLocalDataResponse) UpdateMessageCardLocalDataResponse.ADAPTER.decode(r3);
        MsgCardUpdateLocalDataResponse r0 = new MsgCardUpdateLocalDataResponse();
        r0.setCardVersion(r4.version);
        r0.setData(r4.json_data);
        return r0;
    L4:
        Log.w("LynxCardActionClient", "updateLocalData data is null");
        return new MsgCardUpdateLocalDataResponse();
    }
}
