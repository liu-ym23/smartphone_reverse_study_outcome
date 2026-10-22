package com.bytedance.android.live.impl.logfilter;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public final List<List<Pair<Long, Float>>> a;

    public final synchronized List<Float> a() {
        monitor-enter(this);
        List<List<Pair<Long, Float>>> r0 = this.a;     // Catch: Throwable -> L14
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Throwable -> L14
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L14
    L4:
        if (r2.hasNext() == false) goto L12;
        List r3 = (List) r2.next();     // Catch: Throwable -> L14
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Throwable -> L14
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L14
    L8:
        if (r5.hasNext() == false) goto L10;
        r4.add(Float.valueOf(((Number) ((Pair) r5.next()).getSecond()).floatValue()));     // Catch: Throwable -> L14
        goto L8
    L10:
        r1.add(Float.valueOf((float) CollectionsKt.averageOfFloat(r4)));     // Catch: Throwable -> L14
        goto L4
    L12:
        monitor-exit(this);
        return r1;
    L14:
        th = move-exception;
        throw th;
    }

    public h() {
        ArrayList r0 = new ArrayList(7);
        int r2 = 0;
    L3:
        if (r2 >= 7) goto L5;
        r0.add(new ArrayList());
        r2 = r2 + 1;
        goto L3
    L5:
        this.a = r0;
    }

    public final synchronized void b(boolean r14, Float... r15) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r15, "variableValues");     // Catch: Throwable -> L39
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L39
        int r2 = 0;
        if (r14 == false) goto L11;
        int r16 = r15.length;     // Catch: Throwable -> L39
        int r1 = 0;
    L6:
        if (r2 >= r16) goto L37;
        int r3 = r1 + 1;     // Catch: Throwable -> L39
        if (r15[r2] != null) goto L10;
        ((List) ListProtector.get(this.a, r1)).clear();     // Catch: Throwable -> L39
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L39
    L10:
        r2 = r2 + 1;     // Catch: Throwable -> L39
        r1 = r3;
    L37:
        monitor-exit(this);
        return;
    L11:
        int r17 = r15.length;     // Catch: Throwable -> L39
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r5 >= r17) goto L37;
        Float r7 = r15[r5];     // Catch: Throwable -> L39
        int r8 = r6 + 1;     // Catch: Throwable -> L39
        if (r7 == null) goto L16;
        float r9 = r7.floatValue();     // Catch: Throwable -> L39
        ((List) ListProtector.get(this.a, r6)).add(TuplesKt.to(Long.valueOf(r0), Float.valueOf(r9)));     // Catch: Throwable -> L39
    L16:
        Iterable r11 = (Iterable) ListProtector.get(this.a, r6);     // Catch: Throwable -> L39
        if ((r11 instanceof Collection) == true) goto L19;
    L21:
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L39
        int r13 = 0;
    L23:
        if (r12.hasNext() == false) goto L32;
        if (((Number) ((Pair) r12.next()).getFirst()).longValue() > (r0 - ((long) 60000))) goto L27;
        boolean r18 = true;
    L28:
        if (r18 == false) goto L23;
        r13 = r13 + 1;     // Catch: Throwable -> L39
        if (r13 >= 0) goto L23;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L39
        goto L23
    L27:
        r18 = false;
    L32:
        int r19 = 0;
    L33:
        if (r19 >= r13) goto L36;
        ListProtector.remove((List) ListProtector.get(this.a, r6), 0);     // Catch: Throwable -> L39
        r19 = r19 + 1;
        goto L33
    L36:
        r5 = r5 + 1;
        r6 = r8;
        goto L12
    L19:
        if (((Collection) r11).isEmpty() == false) goto L21;
        r13 = 0;
    L39:
        th = move-exception;
        throw th;
    }
}
