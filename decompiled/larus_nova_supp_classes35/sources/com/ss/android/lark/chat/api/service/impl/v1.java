package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsResponse;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v1<T, R> implements Function {
    public final /* synthetic */ Function1<TranslateMessageUrlPreviewsResponse, Map<String, Map<String, PreviewHangPoint>>> a;

    public v1(e2 r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (Map) this.a.invoke(r3.c);
    }
}
