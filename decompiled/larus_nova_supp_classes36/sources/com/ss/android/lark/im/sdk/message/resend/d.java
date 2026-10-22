package com.ss.android.lark.im.sdk.message.resend;

import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
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
        return (UploadResourceResponse) UploadResourceResponse.ADAPTER.decode(r2);
    }
}
