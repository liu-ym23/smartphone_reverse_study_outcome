package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.MGetThreadsResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class m1 implements SdkSender.IParser {
    public final /* synthetic */ List a;

    public /* synthetic */ m1(List r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        List r0 = this.a;
        MGetThreadsResponse r4 = (MGetThreadsResponse) MGetThreadsResponse.ADAPTER.decode(r3);
        Entity r1 = r4.entity;
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (CollectionUtils.isNotEmpty(r1.threads) == false) goto L7;
        return com.ss.android.lark.parser.internal.b0.a((Thread) r4.entity.threads.get(r0));
    }
}
