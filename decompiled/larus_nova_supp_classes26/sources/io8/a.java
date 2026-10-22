package io8;

import com.larus.platform.api.Image;
import com.larus.platform.kmp.chat.TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final TemplateInfo.TemplateImage a(Image r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new TemplateInfo.TemplateImage(r7.a, r7.c, r7.d);
    }
}
