package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.bytedance.lark.pb.basic.v1.CardContent;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements okb.e {
    public d() {
    }

    public final void b() {
    }

    public final List<gya.a<Content>> d() {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatApi().d();
    }

    public final gya.a<Content> a(MessageType r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatApi().a(r2);
    }

    public final CardContent c(com.ss.android.lark.chat.entity.message.content.CardContent r2) {
        Intrinsics.checkNotNullParameter(r2, "cardContent");
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatApi().c(r2);
    }
}
