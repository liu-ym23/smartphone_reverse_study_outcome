package com.bytedance.android.annie.param;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class JsGsonMap extends GsonMap {
    public final JsonObject c;
    public final Lazy d;

    @Override // com.bytedance.android.annie.param.GsonMap
    public final Set<Map.Entry<String, Object>> b() {
        return (Set) this.d.getValue();
    }

    @Override // com.bytedance.android.annie.param.GsonMap
    public final Collection<Object> c() {
        Set r0 = this.c.entrySet();
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r10 = r0.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r1.add(UtilsKt.a((JsonElement) ((Map.Entry) r10.next()).getValue()));
        goto L4
    L6:
        return r1;
    }

    public JsGsonMap(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        super(r10);
        this.c = r10;
        this.d = LazyKt.lazy(new JsGsonMap$entries$2(this));
    }

    @Override // com.bytedance.android.annie.param.GsonMap
    public final Object a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        JsonElement r11 = this.c.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return UtilsKt.a(r11);
    }
}
