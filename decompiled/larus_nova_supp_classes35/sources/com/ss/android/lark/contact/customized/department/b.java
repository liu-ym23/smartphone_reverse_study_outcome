package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements SdkSender.IParser {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object parse(byte[] r2) {
        return ((GetAnotherNameFormatResponse) GetAnotherNameFormatResponse.ADAPTER.decode(r2)).rule;
    }
}
