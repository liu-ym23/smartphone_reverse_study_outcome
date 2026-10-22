package com.ss.android.lark.chat.base.model.dispatch;

import com.bytedance.lark.pb.media.v1.PreprocessResourceResponse;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n<T> implements SdkSender.IParser {
    public static final n<T> a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final Object parse(byte[] r2) {
        ProtoAdapter r0 = PreprocessResourceResponse.ADAPTER;
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((PreprocessResourceResponse) r0.decode(r2)).key;
    }
}
