package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.bytedance.lark.pb.im.v1.TransmitDoubaoMessagesResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r2) {
        return (TransmitDoubaoMessagesResponse) TransmitDoubaoMessagesResponse.ADAPTER.decode(r2);
    }
}
