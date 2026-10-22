package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.media.v1.GetPreviewVideoSourceResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y1<T, R> implements Function {
    public static final y1<T, R> a = null;

    static {
        a = new y1();
    }

    public y1() {
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return ((GetPreviewVideoSourceResponse) r3.c).video_src;
    }
}
