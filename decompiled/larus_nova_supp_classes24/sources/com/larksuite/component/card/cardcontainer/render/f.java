package com.larksuite.component.card.cardcontainer.render;

import com.bytedance.lark.pb.openplatform.v1.TransSer2CliUniversalCardEntityResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f<T> implements SdkSender.IParser {
    public static final f<T> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object parse(byte[] r3) {
        return ((TransSer2CliUniversalCardEntityResponse) TransSer2CliUniversalCardEntityResponse.ADAPTER.decode(r3)).universal_card_entity;
    L4:
        th = move-exception;
        Log.e("CardRenderByServerEntityImpl", "decode TransSer2CliUniversalCardEntityResponse error", th);
        return null;
    }
}
