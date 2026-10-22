package com.bytedance.android.anniex.base.service;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3126b = null;

    static {
        f3125a = LazyKt.lazy(AnnieXServiceCenter$bidServicesMap$2.f3122a);
        f3126b = LazyKt.lazy(AnnieXServiceCenter$serviceProviderMap$2.f3124a);
        LazyKt.lazy(AnnieXServiceCenter$createServiceMethodMap$2.f3123a);
    }

    public static void a(Class r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        String r11 = r5.getSimpleName();
        Lazy r12 = f3125a;
        ConcurrentHashMap r13 = (ConcurrentHashMap) ((ConcurrentHashMap) r12.getValue()).get(r10);
        Lazy r14 = f3126b;
        if (r13 == null) goto L11;
        if (((b) r13.get(r11)) == null) goto L8;
        b(r11);
        return;
    L8:
        b r15 = (b) ((ConcurrentHashMap) r14.getValue()).get(r10);
        r13.put(r11, new b());
        b(r11);
        return;
    L11:
        if (((ConcurrentHashMap) r14.getValue()).containsKey(r10) == false) goto L14;
        b r16 = (b) ((ConcurrentHashMap) r14.getValue()).get(r10);
    L16:
        ConcurrentHashMap r17 = (ConcurrentHashMap) r12.getValue();
        ConcurrentHashMap r18 = new ConcurrentHashMap();
        r18.put(r11, new b());
        r17.put(r10, r18);
        b(r11);
        return;
    L14:
        if (com.bytedance.android.anniex.base.depend.a.f3112a.getValue() != null) goto L19;
        ((ConcurrentHashMap) r14.getValue()).put(r10, new b());
        goto L16
    L19:
        throw new ClassCastException();
    }

    public static void b(String r10) {
        Lazy r5 = f3125a;
        ConcurrentHashMap r11 = (ConcurrentHashMap) ((ConcurrentHashMap) r5.getValue()).get("default_bid");
        if (r11 == null) goto L10;
        if (((b) r11.get(r10)) == null) goto L7;
        return;
    L7:
        b r12 = (b) ((ConcurrentHashMap) f3126b.getValue()).get("default_bid");
        com.bytedance.ies.bullet.base.utils.logger.a.d("XInit", "miss AnnieXServiceProvider on default bid", null, 12);
        r11.put(r10, new b());
        return;
    L10:
        if (com.bytedance.android.anniex.base.depend.a.f3112a.getValue() != null) goto L14;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XInit", "miss AnnieXServiceProvider on default bid", null, 12);
        ConcurrentHashMap r13 = (ConcurrentHashMap) r5.getValue();
        ConcurrentHashMap r14 = new ConcurrentHashMap();
        r14.put(r10, new b());
        r13.put("default_bid", r14);
        return;
    L14:
        throw new ClassCastException();
    }
}
