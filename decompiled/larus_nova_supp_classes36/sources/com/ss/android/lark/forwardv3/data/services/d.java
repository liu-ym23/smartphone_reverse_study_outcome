package com.ss.android.lark.forwardv3.data.services;

import com.bytedance.lark.pb.im.v1.BatchTransmitResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements SdkSender.IParser {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object parse(byte[] r2) {
        return (BatchTransmitResponse) BatchTransmitResponse.ADAPTER.decode(r2);
    }
}
