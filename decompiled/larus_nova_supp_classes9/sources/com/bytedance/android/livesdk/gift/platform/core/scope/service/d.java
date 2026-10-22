package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.util.LruCache;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.scope.o {
    public final HashMap<String, a> a;
    public final AssetsService b;

    public static final class a extends LruCache<Long, Pair<? extends Integer, ? extends String>> {
        public int a;

        public a(int r1) {
            super(r1);
        }

        @Override // android.util.LruCache
        public final void trimToSize(int r6) {
            int r0 = size();
            int r1 = r0 - this.a;
            Set<Map.Entry<Long, Pair<? extends Integer, ? extends String>>> r2 = snapshot().entrySet();
            Map.Entry r4 = null;
            if ((!r2.isEmpty()) == true) goto L6;
            r2 = null;
        L6:
            if (r2 == null) goto L8;
            r4 = (Map.Entry) CollectionsKt.last(r2);
        L8:
            if (r4 == null) goto L14;
            Pair r3 = (Pair) r4.getValue();
            if (r3 == null) goto L14;
            Integer r5 = (Integer) r3.getFirst();
            if (r5 == null) goto L14;
            int r7 = r5.intValue();
        L15:
            if (r1 >= r7) goto L18;
            r1 = r7 + 1;
        L18:
            if (r4 == null) goto L20;
            Long r8 = (Long) r4.getKey();
        L20:
            if (r0 <= r6) goto L24;
            if (r1 > r6) goto L24;
            super.trimToSize(r1);
            return;
        L24:
            super.trimToSize(r6);
            return;
        L14:
            r7 = 0;
            goto L15
        }

        @Override // android.util.LruCache
        public final int sizeOf(Long r1, Pair<? extends Integer, ? extends String> r2) {
            r1.longValue();
            Pair<? extends Integer, ? extends String> r3 = r2;
            Intrinsics.checkNotNullParameter(r3, "value");
            return ((Number) r3.getFirst()).intValue();
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r1, Long r2, Pair<? extends Integer, ? extends String> r3, Pair<? extends Integer, ? extends String> r4) {
            Long r5 = r2;
            Pair<? extends Integer, ? extends String> r6 = r3;
            if (r6 == null) goto L9;
            if (r1 == false) goto L8;
            Single.create(new c(this, r6, r5)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L8:
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void onStop() {
        this.a.clear();
    }

    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.c().isEmpty() == false) goto L5;
        return;
    L5:
        Single.create(new f(this)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
    }

    public d(AssetsService r2) {
        Intrinsics.checkNotNullParameter(r2, "assetsService");
        this.b = r2;
        this.a = new HashMap();
    }

    public static final void a(d r5) {
        HashMap<String, a> r0 = r5.a;
        monitor-enter(r0);
        HashMap r1 = new HashMap();     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, a>> r2 = r5.a.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, a> r3 = r2.next();     // Catch: Throwable -> L15
        String r4 = r3.getKey();     // Catch: Throwable -> L15
        Map<Long, Pair<? extends Integer, ? extends String>> r6 = r3.getValue().snapshot();     // Catch: Throwable -> L15
        if (r6 == null) goto L11;
        r1.put(r4, (LinkedHashMap) r6);     // Catch: Throwable -> L15
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.util.LinkedHashMap<kotlin.Long!, kotlin.Pair<kotlin.Int, kotlin.String>!>");     // Catch: Throwable -> L15
    L12:
        KProperty[] r7 = ay1.b.a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r1, "<set-?>");     // Catch: Throwable -> L15
        ay1.b.t0.setValue(null, ay1.b.a[86], r1);     // Catch: Throwable -> L15
        r5.c("writeToDisk");     // Catch: Throwable -> L15
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void c(String r3) {
        Iterator<Map.Entry<String, a>> r4 = this.a.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, a> r0 = r4.next();
        String r1 = r0.getKey();
        Objects.toString(r0.getValue().snapshot());
        r0.getValue().size();
        goto L4
    }
}
