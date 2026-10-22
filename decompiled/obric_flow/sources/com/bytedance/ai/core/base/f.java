package com.bytedance.ai.core.base;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends d implements m2.a {
    public final String f;

    public f() {
        super(h0.a(t2.b.f22089a));
        ConcurrentHashMap r5 = o2.a.f20402a;
        this.f = UUID.randomUUID().toString();
    }
}
