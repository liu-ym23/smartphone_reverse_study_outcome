package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.model.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public final String a;
    public int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final long h;
    public final int i;
    public final long j;
    public final int k;
    public String l;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "primaryKey: " + this.a + ", type: " + this.b + ", effectId: " + this.c + ", panel: " + this.d + ", resource_id: " + this.e + ", uri: " + this.f + ", biz_space: " + this.g + ", last_access_time: " + this.h + ", use_count: " + this.i + ", file_size: " + this.j + ", source: " + this.k + ", model_name: " + this.l;
    }

    public k() {
        this.a = "";
        this.b = -1;
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = -1;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = -1;
        this.l = "";
    }

    public final int getType() {
        return this.b;
    }

    public k(Effect r4) {
        this();
        String r0 = b.a(r4);
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        this.a = r0;
        this.b = 0;
        this.c = r4.getEffect_id();
        this.d = r4.getPanel();
        this.e = r4.getResource_id();
        this.f = r4.getUnzipPath();
        int r5 = b0.a.a;
        this.h = System.currentTimeMillis();
        this.k = 0;
    }

    public k(ModelInfo r3, String r4) {
        this();
        this.a = com.ss.ugc.effectplatform.util.k.a(r3);
        this.b = 1;
        this.f = r4;
        int r5 = b0.a.a;
        this.h = System.currentTimeMillis();
        this.k = 0;
        this.l = r3.getName();
    }
}
