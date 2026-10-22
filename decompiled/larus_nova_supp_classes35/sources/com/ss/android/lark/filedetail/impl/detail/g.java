package com.ss.android.lark.filedetail.impl.detail;

import com.bytedance.lark.pb.media.v1.DecryptFileResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g<T> implements SdkSender.IParser {
    public static final g<T> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object parse(byte[] r2) {
        return Boolean.valueOf(!((DecryptFileResponse) DecryptFileResponse.ADAPTER.decode(r2)).is_not_encrypted.booleanValue());
    }
}
