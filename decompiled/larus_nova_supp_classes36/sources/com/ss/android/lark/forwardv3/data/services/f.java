package com.ss.android.lark.forwardv3.data.services;

import com.ss.android.lark.pb.messages.BatchShareMessageResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements SdkSender.IParser {
    public static final f<T> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object parse(byte[] r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (BatchShareMessageResponse) BatchShareMessageResponse.ADAPTER.decode(r2);
    }
}
