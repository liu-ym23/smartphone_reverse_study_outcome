package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final Regex a = null;
    public static final Map<String, String> b = null;

    static {
        a = new Regex("^[a-zA-Z0-9]{1,16}$");
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("image/jpeg", "jpeg"), TuplesKt.to("image/jpg", "jpg"), TuplesKt.to("image/png", "png"), TuplesKt.to("image/webp", "webp"), TuplesKt.to("image/heic", "heic"), TuplesKt.to("image/heif", "heif"), TuplesKt.to("image/gif", "gif")});
    }

    public static String a(String r3, String r4) {
        if (r3 == null) goto L11;
        String r5 = StringsKt.substringAfterLast(r3, '.', "");
        if (r5 == null) goto L11;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L11;
        if (a.matches(r6) == false) goto L11;
    L12:
        if (r6 != null) goto L20;
        if (r4 == null) goto L21;
        String r7 = StringsKt.trim(r4).toString();
        if (r7 == null) goto L22;
        String r8 = r7.toLowerCase(Locale.ROOT);
        if (r8 != null) goto L24;
        return null;
    L24:
        return b.get(r8);
    L22:
        return null;
    L21:
        return null;
    L20:
        return r6;
    L11:
        r6 = null;
        goto L12
    }
}
