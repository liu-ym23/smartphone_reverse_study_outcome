package com.bytedance.sdk.xbridge.cn.registry.core;

import cj.l;
import com.bytedance.sdk.xbridge.cn.utils.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7476b;

    public a(int r5) {
        this.f7475a = r5;
        this.f7476b = new ConcurrentHashMap();
    }

    public final IDLXBridgeMethod a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "bizId");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        ConcurrentHashMap r11 = (ConcurrentHashMap) this.f7476b.get(r5);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.containsKey(r10) == true) goto L7;
        return null;
    L7:
        return (IDLXBridgeMethod) r11.get(r10);
    }

    public final void b(String r10, IDLXBridgeMethod r11) {
        Intrinsics.checkNotNullParameter(r10, "bizId");
        Intrinsics.checkNotNullParameter(r11, "method");
        String r5 = r11.getName();
        ConcurrentHashMap r12 = this.f7476b;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12.get(r10);
        if (r13 == null) goto L8;
        if (r13.containsKey(r5) != true) goto L8;
        return;
    L8:
        if (r11.getCompatibility().f7469a == true) goto L16;
        Class<?> r14 = r11.getClass();
        ConcurrentHashMap r15 = l.f1209a;
        Intrinsics.checkNotNullParameter(r14, "clazz");
        if (l.f1209a.contains(r14) == true) goto L16;
        ExecutorService r16 = b.f7499a;
        a6.a r17 = new a6.a(r14, 2);
        Intrinsics.checkNotNullParameter(r17, "runnable");
        if (b.f7499a != null) goto L15;
        b.f7499a = Executors.newSingleThreadExecutor();
    L15:
        ExecutorService r18 = b.f7499a;
        Intrinsics.checkNotNull(r18);
        r18.submit(r17);
    L16:
        if (r13 != null) goto L18;
        r12.put(r10, new ConcurrentHashMap(this.f7475a));
    L18:
        ConcurrentHashMap r19 = (ConcurrentHashMap) r12.get(r10);
        if (r19 == null) goto L22;
        r19.put(r5, r11);
        return;
    }
}
