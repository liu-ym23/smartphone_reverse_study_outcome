package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<String, a> f = null;
    public final SkuApiMonitor a;
    public final b b;
    public final d c;
    public final e d;
    public final c e;

    /* JADX INFO: renamed from: com.bytedance.android.ec.common.impl.sku.monitor.a$a, reason: collision with other inner class name */
    public static final class C0119a {
        public static a a(String r1) {
            return (a) ((LinkedHashMap) a.f).get(r1);
        }
    }

    static {
        f = new LinkedHashMap();
    }

    public a(SkuParams r10) {
        Intrinsics.checkNotNullParameter(r10, "skuParams");
        this.a = new SkuApiMonitor();
        this.b = new b(r10);
        this.c = new d(r10);
        this.d = new e(r10);
        this.e = new c(r10);
    }
}
