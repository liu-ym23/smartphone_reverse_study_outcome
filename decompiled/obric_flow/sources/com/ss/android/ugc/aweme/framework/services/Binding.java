package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class Binding<T> {
    public Binding(Class r5, ServiceProvider r10) {
        ConcurrentHashMap r11 = DynamicBindServiceManager.f16214a;
        Set r12 = (Set) r11.get(r5);
        if (r12 != null) goto L6;
        Set r13 = Collections.synchronizedSet(new LinkedHashSet());
        r13.add(r10);
        r11.put(r5, r13);
        return;
    L6:
        r12.add(r10);
    }
}
