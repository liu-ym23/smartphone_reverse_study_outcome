package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class InternCache extends LinkedHashMap<String, String> {
    private static final int DEFAULT_SIZE = 64;
    private static final int MAX_SIZE = 660;
    private static final InternCache sInstance = null;

    static {
        sInstance = new InternCache();
    }

    private InternCache() {
        super(64, 0.6666f, false);
    }

    public static InternCache getInstance() {
        return sInstance;
    }

    public String intern(String r4) {
        monitor-enter(this);
        String r0 = (String) ZeusTransformUtils.preCheckCast(get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r0 != null) goto L14;
        r0 = r4.intern();
        monitor-enter(this);
        put(r0, r0);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, String> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        if (size() <= MAX_SIZE) goto L5;
        return true;
    L5:
        return false;
    }
}
