package com.ss.android.lark.contact.base.service;

import com.ss.android.lark.pb.chatters.PullUserAgreementResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T> implements SdkSender.IParser {
    public static final f<T> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object parse(byte[] r2) {
        return (PullUserAgreementResponse) PullUserAgreementResponse.ADAPTER.decode(r2);
    }
}
