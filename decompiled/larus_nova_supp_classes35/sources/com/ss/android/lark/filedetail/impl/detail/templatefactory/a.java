package com.ss.android.lark.filedetail.impl.detail.templatefactory;

import com.bytedance.lark.pb.im.v1.ShareAsMessageResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r2) {
        return (ShareAsMessageResponse) ShareAsMessageResponse.ADAPTER.decode(r2);
    }
}
