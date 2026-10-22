package com.bytedance.ai.uiu;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final String a = null;
    public static final Regex b = null;
    public static final Regex c = null;

    static {
        a = g.class.getName();
        b = new Regex("(?=;[cligbnpt]:\\d{3})");
        c = new Regex("^\\d{3}(&&\\d{3})*$");
    }

    public static u5.c a(String r10, String r11) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        String r1 = a;
        r0.d(r1, "parseUIOperations data: " + r10);
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith$default(r10, "\"", false, 2, null) == false) goto L16;
        r10 = r10.substring(1);
    L16:
        if (StringsKt.endsWith$default(r10, ";", false, 2, null) == false) goto L18;
        r10 = StringsKt.dropLast(r10, 1);
    L18:
        List r13 = Regex.split$default(b, r10, 0, 2, null);
        if (r13.isEmpty() == false) goto L22;
        r0.d(r1, "parseUIOperations No data to split for uiOperations");
        return null;
    L22:
        if (r11 != null) goto L25;
        r11 = (String) ListProtector.get(r13, 0);
    L25:
        return new u5.c(r11, SequencesKt.toList(SequencesKt.flattenSequenceOfIterable(SequencesKt.mapNotNull(SequencesKt.drop(CollectionsKt.asSequence(r13), 1), new f()))));
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L10
    }
}
