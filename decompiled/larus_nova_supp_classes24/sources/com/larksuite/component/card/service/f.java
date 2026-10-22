package com.larksuite.component.card.service;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.openplatform.v1.GetUniversalCardEntityByBizParamResponse;
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

    public final Object parse(byte[] r2) {
        if (r2 != null) goto L6;
        Log.i("UniversalRequestClient", "fetch card entity return null");
        return new UniversalCardEntity.Builder().build();
    L6:
        return ((GetUniversalCardEntityByBizParamResponse) GetUniversalCardEntityByBizParamResponse.ADAPTER.decode(r2)).universal_card_entity;
    }
}
