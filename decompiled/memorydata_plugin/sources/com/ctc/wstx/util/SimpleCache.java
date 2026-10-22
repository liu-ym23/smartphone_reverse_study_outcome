package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class SimpleCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final LimitMap<K, V> f3687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f3688b;

    static final class LimitMap<K, V> extends LinkedHashMap<K, V> {
        final int mMaxSize;

        public LimitMap(int r3) {
            super(r3, 0.8f, true);
            this.mMaxSize = r3;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            if (size() < this.mMaxSize) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public SimpleCache(int r2) {
        this.f3687a = new LimitMap(r2);
        this.f3688b = r2;
    }

    public V a(K r1) {
        return this.f3687a.get(r1);
    }

    public void a(K r1, V r2) {
        this.f3687a.put(r1, r2);
    }
}
