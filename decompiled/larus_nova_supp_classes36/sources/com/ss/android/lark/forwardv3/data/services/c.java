package com.ss.android.lark.forwardv3.data.services;

import com.bytedance.lark.pb.im.v1.MergeForwardMessagesResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements SdkSender.IParser {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object parse(byte[] r2) {
        return (MergeForwardMessagesResponse) MergeForwardMessagesResponse.ADAPTER.decode(r2);
    }
}
