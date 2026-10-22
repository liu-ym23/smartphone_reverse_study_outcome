package com.bytedance.android.live.rts.client_utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final Object a(JsonElement r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$asPrimitiveType");
        if ((r4 instanceof JsonObject) == false) goto L9;
        JsonObject r6 = (JsonObject) r4;
        Set r0 = r6.keySet();
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L44;
        Object r3 = r1.next();
        r2.put(r3, a(r6.get((String) r3), r5));
        goto L6
    L44:
        return r2;
    L9:
        if ((r4 instanceof JsonArray) == false) goto L15;
        Iterable r7 = (Iterable) r4;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L12:
        if (r9.hasNext() == false) goto L45;
        r8.add(a((JsonElement) r9.next(), r5));
        goto L12
    L45:
        return r8;
    L15:
        if ((r4 instanceof JsonPrimitive) == false) goto L35;
        JsonPrimitive r10 = (JsonPrimitive) r4;
        if (r10.isBoolean() == false) goto L20;
        return Boolean.valueOf(r10.getAsBoolean());
    L20:
        if (r10.isNumber() == false) goto L43;
        BigDecimal r12 = r10.getAsBigDecimal();
        if (r12.stripTrailingZeros().scale() != 0) goto L42;
        long r13 = r12.longValue();
        if (r13 < Integer.MAX_VALUE) goto L26;
    L29:
        boolean r14 = true;
    L30:
        if (r14 == false) goto L41;
        return String.valueOf(r13);
    L41:
        return Integer.valueOf((int) r13);
    L26:
        if (r13 <= Integer.MIN_VALUE) goto L29;
        r14 = false;
        goto L30
    L42:
        return Double.valueOf(r12.doubleValue());
    L43:
        return r10.getAsString();
    L35:
        return null;
    }
}
