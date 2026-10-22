package com.ss.android.lark.chat.api.service.impl;

import android.util.ArrayMap;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d1 {
    static {
    }

    @JvmStatic
    public static final UrlCardPreviewEntity a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "previewId");
        Lazy<PreviewCache> r0 = PreviewCache.f;
        Map<String, UrlCardPreviewEntity> r4 = PreviewCache.a.a().c(r2, CollectionsKt.listOf(r3));
        if (r4 != null) goto L7;
        return null;
    L7:
        return (UrlCardPreviewEntity) ((ArrayMap) r4).get(r3);
    }
}
