package com.obric.assistant.common.utils;

import android.os.Bundle;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final String a(Object r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        if ((r10 instanceof Bundle) == false) goto L8;
        return b((Bundle) r10);
    L8:
        if ((r10 instanceof Object[]) == false) goto L11;
        return ArraysKt.joinToString$default((Object[]) r10, null, "[", "]", 0, null, new d(), 25, null);
    L11:
        if ((r10 instanceof int[]) == false) goto L14;
        return ArraysKt.joinToString$default((int[]) r10, null, "[", "]", 0, null, null, 57, null);
    L14:
        if ((r10 instanceof long[]) == false) goto L17;
        return ArraysKt.joinToString$default((long[]) r10, null, "[", "]", 0, null, null, 57, null);
    L17:
        if ((r10 instanceof float[]) == false) goto L20;
        return ArraysKt.joinToString$default((float[]) r10, null, "[", "]", 0, null, null, 57, null);
    L20:
        if ((r10 instanceof double[]) == false) goto L23;
        return ArraysKt.joinToString$default((double[]) r10, null, "[", "]", 0, null, null, 57, null);
    L23:
        if ((r10 instanceof boolean[]) == false) goto L26;
        return ArraysKt.joinToString$default((boolean[]) r10, null, "[", "]", 0, null, null, 57, null);
    L26:
        if ((r10 instanceof byte[]) == false) goto L29;
        return ArraysKt.joinToString$default((byte[]) r10, null, "[", "]", 0, null, null, 57, null);
    L29:
        if ((r10 instanceof short[]) == false) goto L32;
        return ArraysKt.joinToString$default((short[]) r10, null, "[", "]", 0, null, null, 57, null);
    L32:
        if ((r10 instanceof char[]) == false) goto L35;
        return ArraysKt.joinToString$default((char[]) r10, null, "[", "]", 0, null, null, 57, null);
    L35:
        return r10.toString();
    }

    public static final String b(final Bundle r10) {
        if (r10 == null) goto L9;
        Set<String> r0 = r10.keySet();
        if (r0 == null) goto L9;
        List r1 = CollectionsKt.sorted(r0);
        if (r1 == null) goto L9;
        String r11 = CollectionsKt.joinToString$default(r1, null, "{", "}", 0, null, new c(r10), 25, null);
        if (r11 == null) goto L9;
        return r11;
    L9:
        return "null";
    }
}
