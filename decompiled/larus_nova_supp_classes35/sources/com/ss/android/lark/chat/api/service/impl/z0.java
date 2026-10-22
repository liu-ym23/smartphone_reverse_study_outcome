package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.url.v1.MGetUrlPreviewResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z0<T> implements SdkSender.IParser {
    public static final z0<T> a = null;

    static {
        a = new z0();
    }

    public z0() {
    }

    public final Object parse(byte[] r2) {
        return (MGetUrlPreviewResponse) MGetUrlPreviewResponse.ADAPTER.decode(r2);
    }
}
