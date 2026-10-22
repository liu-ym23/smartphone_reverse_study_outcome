package com.ss.android.lark.chat.preview.actions;

import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vcb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final b a(UrlPreviewAction r7, String r8, UrlPreviewBody r9, d r10, Map r11) {
        Intrinsics.checkNotNullParameter(r8, "actionId");
        Intrinsics.checkNotNullParameter(r10, "context");
        return new b(r7, r8, r9, r10, r11);
    }
}
