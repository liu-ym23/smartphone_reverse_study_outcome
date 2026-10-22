package com.larus.bmhome.chat.markdown.richtext;

import android.net.Uri;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s {
    public static final Set<Integer> a = null;

    static {
        a = SetsKt.setOf(new Integer[]{1, 2, 3, 5});
    }

    public static String a(String r4, Integer r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "skillName");
        if (StringsKt.isBlank(r4) == false) goto L6;
        return null;
    L6:
        if (r5 == null) goto L12;
        if (r5.intValue() != 4) goto L12;
        String r2 = "path";
    L15:
        if (r2 != null) goto L18;
        return null;
    L18:
        if (Intrinsics.areEqual(r2, "path") == false) goto L20;
        r6 = r7;
    L20:
        if (r6 != null) goto L22;
    L28:
        return null;
    L22:
        if ((!StringsKt.isBlank(r6)) == true) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L28;
        return new Uri.Builder().scheme("skill").authority(r4).appendQueryParameter("type", String.valueOf(r5)).appendQueryParameter(r2, r6).build().toString();
    L12:
        if (CollectionsKt.contains(a, r5) == false) goto L14;
        r2 = "id";
        goto L15
    L14:
        r2 = null;
        goto L15
    }
}
