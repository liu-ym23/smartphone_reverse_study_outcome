package com.bytedance.android.bcm.impl.chain;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<String, com.bytedance.android.bcm.api.c<?>> a = null;

    /* JADX INFO: renamed from: com.bytedance.android.bcm.impl.chain.a$a, reason: collision with other inner class name */
    public static final class C0104a extends com.bytedance.android.bcm.api.a<kc.a> {
        @Override // com.bytedance.android.bcm.api.c
        public final String id() {
            return "exist";
        }

        public C0104a() {
        }
    }

    public static final class b extends com.bytedance.android.bcm.api.a<kc.a> {
        @Override // com.bytedance.android.bcm.api.c
        public final String id() {
            return "raw";
        }

        public b() {
        }
    }

    public static final class c extends com.bytedance.android.bcm.api.a<kc.a> {
        @Override // com.bytedance.android.bcm.api.c
        public final String id() {
            return "reverse";
        }

        public c() {
        }
    }

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        a = r0;
        b r1 = new b();
        C0104a r10 = new C0104a();
        c r11 = new c();
        r0.put("raw", r1);
        r0.put("exist", r10);
        r0.put("reverse", r11);
    }
}
