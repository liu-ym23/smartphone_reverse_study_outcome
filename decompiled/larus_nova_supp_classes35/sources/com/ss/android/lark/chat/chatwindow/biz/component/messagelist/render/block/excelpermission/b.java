package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
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
        return (SendHttpResponse) SendHttpResponse.ADAPTER.decode(r2);
    }
}
