package com.bytedance.android.anniex.base.service;

import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXServiceCenter {
    public static final AnnieXServiceCenter a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public static final class a<I> {
        public final I a;

        public a(I r1) {
            this.a = r1;
        }
    }

    public AnnieXServiceCenter() {
    }

    static {
        a = new AnnieXServiceCenter();
        b = LazyKt.lazy(AnnieXServiceCenter$bidServicesMap$2.INSTANCE);
        c = LazyKt.lazy(AnnieXServiceCenter$serviceProviderMap$2.INSTANCE);
        d = LazyKt.lazy(AnnieXServiceCenter$createServiceMethodMap$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) b.getValue();
    }

    public static ConcurrentHashMap e() {
        return (ConcurrentHashMap) c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e c(String r10) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) b().get("default_bid");
        if (r0 == null) goto L16;
        a r11 = (a) r0.get(r10);
        if (r11 != null) goto L7;
        a.getClass();
        a r1 = (a) e().get("default_bid");
        if (r1 == null) goto L14;
        AnnieXServiceProvider r12 = (AnnieXServiceProvider) r1.a;
        if (r12 == null) goto L14;
        e r13 = a(r10, r12);
        r0.put(r10, new a(r13));
        return r13;
    L14:
        HybridLogger.i("XInit", "miss AnnieXServiceProvider on default bid", null, 12);
        r0.put(r10, new a(null));
        return null;
    L7:
        return (e) r11.a;
    L16:
        ha.a r14 = (ha.a) AnnieXRuntime.a.getValue();
        if (r14 == null) goto L19;
        AnnieXServiceProvider r15 = r14.createServiceProvider("default_bid");
    L20:
        if (r15 == null) goto L23;
        e().put("default_bid", new a(r15));
        e r16 = a(r10, r15);
        ConcurrentHashMap r17 = b();
        ConcurrentHashMap r18 = new ConcurrentHashMap();
        r18.put(r10, new a(r16));
        r17.put("default_bid", r18);
        return r16;
    L23:
        HybridLogger.i("XInit", "miss AnnieXServiceProvider on default bid", null, 12);
        ConcurrentHashMap r19 = b();
        ConcurrentHashMap r20 = new ConcurrentHashMap();
        r20.put(r10, new a(null));
        r19.put("default_bid", r20);
        return null;
    L19:
        r15 = null;
        goto L20
    }

    public static e a(String r10, AnnieXServiceProvider r11) {
        Lazy r0 = d;
        String r1 = (String) ((ConcurrentHashMap) r0.getValue()).get(r10);
        if (r1 != null) goto L13;
        r1 = "create".concat(r10);
        a.getClass();
        ((ConcurrentHashMap) r0.getValue()).put(r10, r1);
    L13:
        Object r12 = r11.getClass().getMethod(r1, new Class[0]).invoke(r11, new Object[0]);     // Catch: Exception -> L10
        if ((r12 instanceof e) == false) goto L15;
        return (e) r12;
    L15:
        return null;
    L10:
        e = move-exception;
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.i("XInit", "createServiceByProvider failed: methodName=" + r1 + ", message=" + e.getMessage(), null, 12);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e d(String r10, Class r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        String r12 = r11.getSimpleName();
        ConcurrentHashMap r0 = (ConcurrentHashMap) b().get(r10);
        if (r0 == null) goto L31;
        a r13 = (a) r0.get(r12);
        if (r13 == null) goto L15;
        I r14 = r13.a;
        if (r14 != 0) goto L9;
        a.getClass();
        e r15 = c(r12);
        if ((r15 instanceof e) == true) goto L14;
        return null;
    L14:
        return r15;
    L9:
        if ((r14 instanceof e) == true) goto L54;
        return null;
    L54:
        return (e) r14;
    L15:
        a.getClass();
        a r16 = (a) e().get(r10);
        if (r16 == null) goto L26;
        AnnieXServiceProvider r17 = (AnnieXServiceProvider) r16.a;
        if (r17 == null) goto L26;
        e r18 = a(r12, r17);
        r0.put(r12, new a(r18));
        if (r18 != null) goto L25;
        r18 = c(r12);
        if ((r18 instanceof e) == true) goto L25;
        return null;
    L25:
        return r18;
    L26:
        r0.put(r12, new a(null));
        e r19 = c(r12);
        if ((r19 instanceof e) == true) goto L29;
        return null;
    L29:
        return r19;
    L31:
        if (e().containsKey(r10) == false) goto L36;
        a r1 = (a) e().get(r10);
        if (r1 == null) goto L35;
        AnnieXServiceProvider r20 = (AnnieXServiceProvider) r1.a;
    L41:
        if (r20 == null) goto L49;
        e r21 = a(r12, r20);
        ConcurrentHashMap r22 = b();
        ConcurrentHashMap r23 = new ConcurrentHashMap();
        r23.put(r12, new a(r21));
        r22.put(r10, r23);
        if (r21 != null) goto L58;
        e r24 = c(r12);
        if ((r24 instanceof e) == true) goto L48;
        return null;
    L48:
        return r24;
    L58:
        return r21;
    L49:
        ConcurrentHashMap r25 = b();
        ConcurrentHashMap r26 = new ConcurrentHashMap();
        r26.put(r12, new a(null));
        r25.put(r10, r26);
        e r27 = c(r12);
        if ((r27 instanceof e) == true) goto L52;
        return null;
    L52:
        return r27;
    L35:
        r20 = null;
        goto L41
    L36:
        ha.a r28 = (ha.a) AnnieXRuntime.a.getValue();
        if (r28 == null) goto L39;
        r20 = r28.createServiceProvider(r10);
    L40:
        e().put(r10, new a(r20));
        goto L41
    L39:
        r20 = null;
        goto L40
    }
}
