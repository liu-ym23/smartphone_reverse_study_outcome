package com.bytedance.ai.core.base;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class g extends d implements u4.a {
    public final String f;

    public g() {
        super(0);
        ConcurrentHashMap<String, String> r0 = x4.a.a;
        this.f = UUID.randomUUID().toString();
    }
}
