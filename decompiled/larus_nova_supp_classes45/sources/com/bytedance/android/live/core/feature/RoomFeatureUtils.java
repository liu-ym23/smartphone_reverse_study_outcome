package com.bytedance.android.live.core.feature;

import com.bytedance.android.livesdkapi.depend.model.live.StrategyRoomFeatureConfig;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RoomFeatureUtils {
    public static final Lazy a = null;
    public static final a<String, DynamicDataRespItem> b = null;
    public static final a<Long, Map<String, Object>> c = null;
    public static Disposable d;

    static {
        Lazy r0 = LazyKt.lazy(RoomFeatureUtils$roomFeatureConfig$2.INSTANCE);
        a = r0;
        b = new a(((StrategyRoomFeatureConfig) r0.getValue()).getCacheSize());
        c = new a(((StrategyRoomFeatureConfig) r0.getValue()).getCacheSize());
    }

    public static Map a(long r5) {
        Iterator r0 = CollectionsKt.toList(((ConcurrentHashMap) b.a).values()).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        Long r2 = ((DynamicDataRespItem) r1).getRoomId();
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L4;
    L15:
        DynamicDataRespItem r4 = (DynamicDataRespItem) r1;
        if (r4 == null) goto L26;
        LinkedHashMap r6 = new LinkedHashMap();
        Map<String, Object> r7 = r4.getTone();
        if (r7 == null) goto L20;
        r6.putAll(r7);
    L20:
        Map<String, Object> r8 = r4.getCae();
        if (r8 == null) goto L23;
        r6.putAll(r8);
    L23:
        a<Long, Map<String, Object>> r9 = c;
        Long r11 = Long.valueOf(r5);
        Map r12 = (Map) ((ConcurrentHashMap) r9.a).get(r11);
        if (r12 == null) goto L33;
        r6.putAll(r12);
        return r6;
    L33:
        return r6;
    L26:
        a<Long, Map<String, Object>> r13 = c;
        Long r14 = Long.valueOf(r5);
        return (Map) ((ConcurrentHashMap) r13.a).get(r14);
    L9:
        if (r2.longValue() != r5) goto L11;
        r3 = true;
        goto L12
    L14:
        r1 = null;
        goto L15
    }

    public static void b(long r3, String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "featureKey");
        Intrinsics.checkNotNullParameter(r6, "featureValue");
        a<Long, Map<String, Object>> r0 = c;
        Long r1 = Long.valueOf(r3);
        Map r2 = (Map) ((ConcurrentHashMap) r0.a).get(r1);
        if (r2 != null) goto L5;
        Long r4 = Long.valueOf(r3);
        ConcurrentHashMap r7 = new ConcurrentHashMap();
        r7.put(r5, r6);
        Unit r8 = Unit.INSTANCE;
        r0.a(r4, r7);
        return;
    L5:
        r2.put(r5, r6);
    }
}
