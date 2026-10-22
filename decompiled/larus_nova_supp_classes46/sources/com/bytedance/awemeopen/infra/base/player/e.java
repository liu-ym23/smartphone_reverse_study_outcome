package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public long a;
    public m b;
    public final Map<String, m> c;
    public final PolarisFileWrapper d;

    public static final class a {
    }

    static {
    }

    public e() {
        this.c = new LinkedHashMap();
        this.d = new PolarisFileWrapper(y54.a.a().getCacheDir(), "video_thumb");
    }
}
