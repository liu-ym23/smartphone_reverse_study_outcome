package com.larksuite.component.card.component.res;

import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r2) {
        return (SendHttpResponse) SendHttpResponse.ADAPTER.decode(r2);
    }
}
