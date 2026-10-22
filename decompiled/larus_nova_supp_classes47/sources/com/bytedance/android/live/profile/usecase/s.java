package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.profile.p000enum.TrackArea;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public final Map<TrackArea, List<String>> a;
    public final Map<String, String> b;

    public static final class a {
    }

    static {
    }

    public s() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final void a(Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r13, "map");
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        r13.put(((TrackArea) r1.getKey()).getParamName(), CollectionsKt.joinToString$default((Iterable) r1.getValue(), "|", null, null, 0, null, null, 62, null));
        goto L4
    L6:
        Set r2 = ((LinkedHashMap) this.a).keySet();
        Iterator r3 = CollectionsKt.minus(ArraysKt.toList(TrackArea.values()), r2).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r13.put(((TrackArea) r3.next()).getParamName(), "");
        goto L8
    }
}
