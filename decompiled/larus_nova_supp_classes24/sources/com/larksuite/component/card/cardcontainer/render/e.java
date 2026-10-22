package com.larksuite.component.card.cardcontainer.render;

import com.bytedance.lark.pb.openplatform.v1.TransSer2CliUniversalCardEntityResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e<T> implements SdkSender.IParser {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object parse(byte[] r2) {
        return ((TransSer2CliUniversalCardEntityResponse) TransSer2CliUniversalCardEntityResponse.ADAPTER.decode(r2)).universal_card_entity;
    }
}
