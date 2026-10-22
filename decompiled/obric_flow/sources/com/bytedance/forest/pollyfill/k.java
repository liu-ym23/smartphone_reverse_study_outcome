package com.bytedance.forest.pollyfill;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f4523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f4524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4525c;

    public k(String r5, Map r10) {
        this.f4525c = r5;
        this.f4524b = new ConcurrentHashMap(r10);
    }

    public final String toString() {
        String r5 = this.f4523a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        StringBuilder r10 = new StringBuilder(this.f4525c);
        Map r11 = MapsKt.toSortedMap(this.f4524b);
        if (r11 != null) goto L9;
        r11 = MapsKt.emptyMap();
    L9:
        Iterator r12 = r11.entrySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Map.Entry r13 = (Map.Entry) r12.next();
        r10.append((String) r13.getKey());
        r10.append((String) r13.getValue());
        goto L11
    L13:
        String r14 = r10.toString();
        this.f4523a = r14;
        return r14;
    }
}
