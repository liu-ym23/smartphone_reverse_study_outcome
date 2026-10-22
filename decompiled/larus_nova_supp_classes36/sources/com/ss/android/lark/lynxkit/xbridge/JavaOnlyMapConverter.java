package com.ss.android.lark.lynxkit.xbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u001a\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007*\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e*\u00020\u0012H\u0002¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/JavaOnlyMapConverter;", "", "<init>", "()V", "toLynxMap", "Lcom/lynx/react/bridge/JavaOnlyMap;", "map", "", "", "toLynxValue", "value", "toLynxArray", "Lcom/lynx/react/bridge/JavaOnlyArray;", LocationHitPoint$ResultType.LIST, "", "toMap", "Lorg/json/JSONObject;", "toList", "Lorg/json/JSONArray;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class JavaOnlyMapConverter {
    public static final JavaOnlyMapConverter INSTANCE = null;

    static {
        INSTANCE = new JavaOnlyMapConverter();
    }

    private JavaOnlyMapConverter() {
    }

    private final List<Object> toList(JSONArray r4) {
        IntRange r0 = RangesKt.until(0, r4.length());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r4.opt(r2.nextInt()));
        goto L4
    L6:
        return r1;
    }

    private final JavaOnlyArray toLynxArray(List<?> r4) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        Object r2 = INSTANCE.toLynxValue(r1);
        if (r2 == null) goto L7;
        r0.add(r2);
        goto L4
    L7:
        r0.pushNull();
        goto L4
    L9:
        return r0;
    }

    private final Map<String, Object> toMap(JSONObject r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.put(r2, r5.opt(r2));
        goto L4
    L6:
        return r0;
    }

    public final JavaOnlyMap toLynxMap(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<Map.Entry<String, ? extends Object>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r1 = r6.next();
        String r2 = r1.getKey();
        Object r3 = r1.getValue();
        Object r4 = INSTANCE.toLynxValue(r3);
        if (r4 == null) goto L7;
        r0.put(r2, r4);
        goto L4
    L7:
        r0.putNull(r2);
        goto L4
    L9:
        return r0;
    }

    public final Object toLynxValue(Object r4) {
        if (r4 != JSONObject.NULL) goto L6;
        return null;
    L6:
        if ((r4 instanceof JSONObject) == false) goto L9;
        return toLynxMap(toMap((JSONObject) r4));
    L9:
        if ((r4 instanceof JSONArray) == false) goto L12;
        return toLynxArray(toList((JSONArray) r4));
    L12:
        if ((r4 instanceof Map) == false) goto L19;
        Set r5 = ((Map) r4).entrySet();
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L26;
        Map.Entry r0 = (Map.Entry) r6.next();
        Object r2 = r0.getKey();
        Object r3 = r0.getValue();
        Pair r7 = TuplesKt.to(String.valueOf(r2), r3);
        r1.put(r7.getFirst(), r7.getSecond());
        goto L15
    L26:
        return toLynxMap(r1);
    L19:
        if ((r4 instanceof List) == true) goto L21;
        return r4;
    L21:
        return toLynxArray((List) r4);
    }
}
