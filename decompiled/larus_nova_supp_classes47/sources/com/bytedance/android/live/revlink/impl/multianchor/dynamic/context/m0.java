package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0<T, R> implements Function {
    public static final m0 a = null;

    static {
        a = new m0();
    }

    public m0() {
    }

    public final Object apply(Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r5, "map");
        List r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((com.bytedance.android.livesdk.link.model.p) r7.next())));
        goto L4
    L6:
        int r8 = com.bytedance.revenue.platform.api.core.b.a;
        Object r9 = JSONObject.wrap(r0);
        if (r9 == null) goto L11;
        return (JSONArray) r9;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONArray /* = org.json.JSONArray */");
    }
}
