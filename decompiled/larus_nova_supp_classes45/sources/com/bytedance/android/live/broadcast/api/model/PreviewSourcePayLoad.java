package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PreviewSourcePayLoad {
    public static final /* synthetic */ int b = 0;
    public final Map<String, b1> a;

    public static final class a {
    }

    static {
    }

    public PreviewSourcePayLoad() {
        this.a = new LinkedHashMap();
    }

    public final String toString() {
        System.currentTimeMillis();
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r1.next();
        Iterator r3 = ((LinkedHashMap) ((b1) r2.getValue()).b).entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.add(CollectionsKt.arrayListOf(new String[]{(String) r2.getKey(), (String) r4.getKey(), (String) r4.getValue()}));
        goto L7
    L10:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r0);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.live.broadcast.api.model.PreviewSourcePayLoad$putPayLoad$1] */
    public final <T> void a(@PayLoadNameSpace String r2, final String r3, final T r4) {
        Intrinsics.checkNotNullParameter(r2, "nameSpace");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        ?? r0 = new PreviewSourcePayLoad$putPayLoad$1(r4, r3);
        b1 r5 = (b1) ((LinkedHashMap) this.a).get(r2);
        if (r5 == null) goto L6;
        r0.invoke(r5);
        return;
    L6:
        b1 r6 = new b1();
        r0.invoke(r6);
        this.a.put(r2, r6);
    }
}
