package com.bytedance.android.annie.resource;

import android.app.Application;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.GeckoConfig;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ForestLoader {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static volatile Forest c;

    static {
        a = LazyKt.lazy(ForestLoader$memoryConfig$2.INSTANCE);
        b = LazyKt.lazy(ForestLoader$preloadMemSize$2.INSTANCE);
    }

    public static Forest a() {
        if (c != null) goto L27;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        String r10 = m.a(null);     // Catch: Throwable -> L21
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L21
        o8.a r11 = com.bytedance.android.annie.ng.e.a;     // Catch: Throwable -> L21
        long r12 = r11.a;     // Catch: Throwable -> L21
        String r13 = m.c();     // Catch: Throwable -> L21
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L21
        String r1 = r11.d;     // Catch: Throwable -> L21
        if (r1 != null) goto L8;
        String r14 = "";
    L9:
        GeckoConfig r15 = new GeckoConfig(r10, r13, r12, r14, m.b(), "cn", false);     // Catch: Throwable -> L21
        String r16 = f.a();     // Catch: Throwable -> L21
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L21
        long r17 = r11.a;     // Catch: Throwable -> L21
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L21
        String r18 = r11.d;     // Catch: Throwable -> L21
        if (r18 != null) goto L12;
        String r19 = "";
    L13:
        GeckoConfig r20 = new GeckoConfig(r16, "offlineX", r17, r19, m.b(), "cn");     // Catch: Throwable -> L21
        Application r21 = com.bytedance.android.annie.ng.g.a();     // Catch: Throwable -> L21
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L21
        r22.put(m.a(null), r15);     // Catch: Throwable -> L21
        r22.put(f.a(), r20);     // Catch: Throwable -> L21
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L21
        com.bytedance.forest.model.i r24 = new com.bytedance.forest.model.i("gecko.zijieapi.com", r15, r22);     // Catch: Throwable -> L21
        Lazy r25 = a;     // Catch: Throwable -> L21
        if (((y9.m) r25.getValue()).b() <= 0) goto L16;
        r24.c = ((y9.m) r25.getValue()).b() * 1048576;     // Catch: Throwable -> L21
    L16:
        Lazy r26 = b;     // Catch: Throwable -> L21
        if (((Integer) r26.getValue()).intValue() <= 0) goto L19;
        r24.d = ((Integer) r26.getValue()).intValue() * 1048576;     // Catch: Throwable -> L21
    L19:
        r24.e = true;     // Catch: Throwable -> L21
        c = new Forest(r21, r24);     // Catch: Throwable -> L21
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L27;
        x8.a.c("ForestLoader", r28, false);
        goto L27
    L12:
        r19 = r18;
        goto L13
    L8:
        r14 = r1;
    L21:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        return c;
    }
}
