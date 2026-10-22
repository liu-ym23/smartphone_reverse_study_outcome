package com.ss.android.lark.chat.api.service.impl;

import android.util.LruCache;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h2 {
    public static final LruCache<Integer, PreviewHangPoint> a = null;

    static {
        a = new LruCache(100);
    }

    public static int a(PreviewHangPoint r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "point");
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.getPreviewId());
        UrlCardPreviewEntity r4 = r2.getUrlCardPreviewEntity();
        if (r4 == null) goto L7;
        UrlInlinePreviewEntity r5 = r4.getInlineEntity();
        if (r5 == null) goto L7;
        Integer r6 = Integer.valueOf(r5.getVersion());
    L8:
        r0.append(r6);
        r0.append(r3);
        return r0.toString().hashCode();
    L7:
        r6 = null;
        goto L8
    }
}
