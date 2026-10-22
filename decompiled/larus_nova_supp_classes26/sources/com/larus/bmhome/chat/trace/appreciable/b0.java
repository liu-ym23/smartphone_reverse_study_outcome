package com.larus.bmhome.chat.trace.appreciable;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 {
    public static final Lazy a = null;
    public static final Queue<String> b = null;
    public static final ConcurrentHashMap<String, Integer> c = null;
    public static final ConcurrentHashMap<String, Long> d = null;

    public static final class a implements f09.a.b {
        public a() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
        }

        public final void onAllActivityDestroyed() {
            FLogger.a.d("MessageSendFailureTracer", "app destroyed");
            Lazy r0 = b0.a;
            b0.c.clear();
            b0.d.clear();
            ((LinkedList) b0.b).clear();
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Object r4 = ((Pair) r2).getSecond();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            Object r5 = ((Pair) r3).getSecond();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
            return ComparisonsKt.compareValues((Integer) r4, (Integer) r5);
        }
    }

    static {
        a = LazyKt.lazy(new a0());
        LinkedList r0 = new LinkedList();
        b = r0;
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        AppHost.a.a().j(new a());
        if (r0.isEmpty() == false) goto L22;
        List r1 = MapsKt.toList(b().getAll());
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if ((((Pair) r4).getSecond() instanceof Integer) == false) goto L6;
        r2.add(r4);
        goto L6
    L10:
        List r5 = CollectionsKt.sortedWith(r2, new b());
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r6.add((String) ((Pair) r7.next()).getFirst());
        goto L12
    L14:
        ((LinkedList) b).addAll(r6);
        return;
    }

    public static Keva b() {
        return (Keva) a.getValue();
    }

    public static boolean a(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (b().getInt(r4, -1) == (-1)) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void c(String r3) {
        FLogger.a.i("MessageSendFailureTracer", "onMessageResend，localMessageId=" + r3);
        b().erase(r3);
    }
}
