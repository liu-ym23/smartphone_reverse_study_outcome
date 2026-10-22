package com.bytedance.forest.utils;

import android.os.Handler;
import com.bytedance.keva.Keva;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f4654a = null;

    static {
        f4654a = new ConcurrentHashMap();
    }

    public static void a(String r19, d r20, Function1 r21, Function1 r22, Function1 r23) {
        int r5 = 6;
        if (r21 == null) goto L5;
        r21.invoke("cdn_ttnet_build_cached_path_start");
    L5:
        ConcurrentHashMap r10 = f4654a;
        com.bytedance.forest.model.j r11 = (com.bytedance.forest.model.j) r10.get(r19);
        boolean r12 = false;
        com.bytedance.forest.model.i r13 = null;
        if (r11 == null) goto L10;
        monitor-enter(r11);
        monitor-exit(r11);
    L43:
        if (r21 == null) goto L45;
        r21.invoke("cdn_ttnet_build_cached_path_finish");
    L45:
        com.bytedance.forest.model.i r14 = (com.bytedance.forest.model.i) r11.f4377a.f4376a.get();
        if (r14 == null) goto L49;
        r13 = r14;
    L49:
        com.bytedance.forest.model.o r15 = (com.bytedance.forest.model.o) r13;
        if (r21 == null) goto L52;
        r21.invoke("cdn_ttnet_load_cache_start");
    L52:
        boolean r16 = false;
        boolean r17 = false;
    L53:
        if (r15 == null) goto L76;
        String r18 = r15.e();
        d.b(r20, 4, "ResponseCacheManager", td.d.b("get file cache key, ", r18), false, null, null, 56);
        if (StringsKt.isBlank(r18) == true) goto L56;
        if (r15.d() == false) goto L75;
        if (r16 == true) goto L75;
        Pair r110 = (Pair) r22.invoke(r15);
        if (r16 == false) goto L64;
    L67:
        r16 = true;
    L68:
        if (r17 == false) goto L70;
    L73:
        r17 = true;
    L74:
        r15 = r15.f();
        goto L53
    L70:
        if (((Boolean) r110.getSecond()).booleanValue() == true) goto L73;
        r17 = false;
        goto L74
    L64:
        if (((Boolean) r110.getFirst()).booleanValue() == true) goto L67;
        r16 = false;
    L75:
        r15 = r15.f();
        goto L53
    L56:
        d.b(r20, 6, "ResponseCacheManager", "hash cache key is blank", false, null, null, 56);
        r15 = r15.f();
        goto L53
    L76:
        if (r16 == true) goto L83;
        if (r17 == true) goto L82;
        if (r23 == null) goto L80;
        boolean r24 = ((Boolean) r23.invoke(r11)).booleanValue();
    L81:
        if (r24 == true) goto L82;
    L84:
        if (r12 == false) goto L108;
        ((Handler) q.f4657b.getValue()).post(new com.bytedance.android.anniex.scene.core.i(r11, r20, r19, r5));
        return;
    L108:
        return;
    L80:
        r24 = false;
    L82:
        r12 = true;
        goto L84
    L83:
        r12 = r17;
        goto L84
    L10:
        r11 = new com.bytedance.forest.model.j();
        monitor-enter(r11);
        com.bytedance.forest.model.j r25 = (com.bytedance.forest.model.j) r10.putIfAbsent(r19, r11);     // Catch: Throwable -> L18
        if (r25 == null) goto L20;
        monitor-enter(r25);     // Catch: Throwable -> L18
        monitor-exit(r25);     // Catch: Throwable -> L18
        monitor-exit(r11);
        r11 = r25;
        goto L43
    L20:
        Keva r26 = l.f4649a;     // Catch: Throwable -> L18
        if (r26 == null) goto L23;
        String r27 = r26.getStringJustDisk(r19, null);     // Catch: Throwable -> L18
    L24:
        if (r27 == null) goto L42;
        List r28 = StringsKt.K(r27, new String[]{","}, 0, 6);     // Catch: Throwable -> L18
        int r111 = r28.size() - 1;     // Catch: Throwable -> L18
    L26:
        if (r111 < 0) goto L40;
        String r29 = (String) r28.get(r111);     // Catch: Throwable -> L18
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L33
        com.bytedance.forest.model.o r113 = new com.bytedance.forest.model.o(r19, r29);     // Catch: Throwable -> L33
        r113.f4376a.set(null);     // Catch: Throwable -> L33
    L29:
        com.bytedance.forest.model.i r30 = (com.bytedance.forest.model.i) r11.f4377a.f4376a.get();     // Catch: Throwable -> L33
        r113.f4376a.set(r30);     // Catch: Throwable -> L33
        AtomicReference r114 = r11.f4377a.f4376a;     // Catch: Throwable -> L33
    L31:
        if (r114.compareAndSet(r30, r113) == true) goto L32;
        if (r114.get() == r30) goto L31;
    L32:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L39:
        r111 = r111 - 1;
        goto L26
    L33:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L18
        Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
        goto L39
    L40:
        monitor-exit(r11);
        goto L43
    L42:
        monitor-exit(r11);
        goto L43
    L23:
        r27 = null;
    L18:
        th = move-exception;
        throw th;
    }
}
