package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n {
    public final Map<Object, Object> a;

    public interface a<V> {
    }

    public n() {
        this.a = new LinkedHashMap();
    }

    public final <V> V a(a<V> r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        V r3 = (V) ((LinkedHashMap) this.a).get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3;
    }

    public final void b(a r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        this.a.put(r2, r3);
    }
}
