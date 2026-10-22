package com.bytedance.android.annie.param;

import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ReadonlyJSONObjectMap extends AbstractMap<String, Object> {
    public final JSONObject a;
    public final Lazy b;

    public final Set<Map.Entry<String, Object>> getEntries() {
        return (Set) this.b.getValue();
    }

    public final int getSize() {
        return this.a.length();
    }

    public ReadonlyJSONObjectMap(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.a = r10;
        this.b = LazyKt.lazy(new ReadonlyJSONObjectMap$entries$2(this));
    }

    public final /* bridge */ boolean containsKey(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return false;
    L7:
        return super.containsKey((String) r10);
    }

    public final Object get(Object r10) {
        if ((r10 instanceof String) == true) goto L5;
        return null;
    L5:
        String r11 = (String) r10;
        Intrinsics.checkNotNullParameter(r11, "key");
        Object r12 = this.a.get(r11);
        if (r12 != null) goto L8;
        return null;
    L8:
        return UtilsKt.b(r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return super/*java.util.Map*/.getOrDefault((String) r10, r11);
    }
}
