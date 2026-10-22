package com.larus.bmhome.music.player;

import android.text.TextUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 {
    public static final boolean a(String r8, String r9, Boolean r10) {
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == true) goto L5;
        String r1 = null;
        if (r8 == null) goto L13;
        List r11 = StringsKt.split$default(r8, new String[]{"?"}, false, 0, 6, null);
        if (r11 == null) goto L13;
        String r12 = (String) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L13;
        String r13 = StringsKt.removePrefix(r12, "\"");
    L14:
        if (r9 == null) goto L21;
        List r14 = StringsKt.split$default(r9, new String[]{"?"}, false, 0, 6, null);
        if (r14 == null) goto L21;
        String r15 = (String) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L21;
        r1 = StringsKt.removePrefix(r15, "\"");
    L21:
        return TextUtils.equals(r13, r1);
    L13:
        r13 = null;
        goto L14
    L5:
        return Intrinsics.areEqual(r8, r9);
    }
}
