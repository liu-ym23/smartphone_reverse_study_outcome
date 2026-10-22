package com.bytedance.rpc.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LruMap<K, V> extends LinkedHashMap<K, V> {
    private int mMaxSize;

    public LruMap(int r1) {
        this(r1, r1);
    }

    public LruMap(int r3, int r4) {
        super(r3, 0.75f, true);
        this.mMaxSize = r4;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }
}
