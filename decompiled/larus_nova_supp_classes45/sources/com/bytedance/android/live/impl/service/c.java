package com.bytedance.android.live.impl.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T, U> implements BiConsumer {
    public final /* synthetic */ Object a;

    public c(Object r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiConsumer
    public final void accept(Object r5, Object r6) {
        String r7 = (String) r5;
        Intrinsics.checkNotNullParameter(r7, "name");
        if (StringsKt.startsWith$default(r7, "player_monitor_features_", false, 2, null) == false) goto L15;
        Object r0 = ((JSONObject) this.a).opt(StringsKt.removePrefix(r7, "player_monitor_features_"));
        if ((!Intrinsics.areEqual(r6, r0)) == false) goto L23;
        if (r0 == null) goto L24;
        Iterator<Map.Entry<z90.a.b, List<String>>> r8 = FeatureManager.k.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L25;
        Map.Entry<z90.a.b, List<String>> r1 = r8.next();
        if (r1.getValue().contains(r7) == false) goto L9;
        z90.a.b r2 = r1.getKey();
        if (r2 == 0) goto L9;
        r2.a(r7, r0);
        goto L9
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }
}
