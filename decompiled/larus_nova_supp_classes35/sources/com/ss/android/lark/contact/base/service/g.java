package com.ss.android.lark.contact.base.service;

import com.ss.android.lark.pb.chatters.PutUserAgreementResponse;
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
        return (PutUserAgreementResponse) PutUserAgreementResponse.ADAPTER.decode(r2);
    }
}
