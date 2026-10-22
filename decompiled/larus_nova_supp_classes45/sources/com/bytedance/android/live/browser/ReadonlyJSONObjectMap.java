package com.bytedance.android.live.browser;

import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ReadonlyJSONObjectMap extends AbstractMap<String, Object> {
    public final Lazy a;
    public final JSONObject b;

    public final Set<Map.Entry<String, Object>> getEntries() {
        return (Set) this.a.getValue();
    }

    public final int getSize() {
        return this.b.length();
    }

    public ReadonlyJSONObjectMap(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.b = r2;
        this.a = LazyKt.lazy(new ReadonlyJSONObjectMap$entries$2(this));
    }

    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return super.containsKey((String) r2);
    }

    public final Object get(Object r3) {
        if ((r3 instanceof String) == true) goto L5;
        return null;
    L5:
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r5 = this.b.get(r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        return UtilsKt.a(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return super/*java.util.Map*/.getOrDefault((String) r2, r3);
    }
}
