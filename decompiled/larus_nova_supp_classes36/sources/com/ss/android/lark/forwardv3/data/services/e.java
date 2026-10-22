package com.ss.android.lark.forwardv3.data.services;

import com.bytedance.lark.pb.im.v1.TransmitResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e<T> implements SdkSender.IParser {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object parse(byte[] r2) {
        return (TransmitResponse) TransmitResponse.ADAPTER.decode(r2);
    }
}
