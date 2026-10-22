package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.latch.prefetch.internal.ProcessManager;
import com.bytedance.android.latch.prefetch.internal.y;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LatchPrefetchProcessorHolder {
    public static final Map<String, com.bytedance.android.latch.prefetch.internal.g> a = null;

    public static final class a<T> implements Predicate {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r10) {
            com.bytedance.android.annie.lynx.service.latch.b r11 = (com.bytedance.android.annie.lynx.service.latch.b) r10;
            Intrinsics.checkNotNullParameter(r11, "<name for destructuring parameter 0>");
            return !StringsKt.isBlank(r11.b);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r10) {
            List r11 = (List) r10;
            Map<String, com.bytedance.android.latch.prefetch.internal.g> r0 = LatchPrefetchProcessorHolder.a;
            if (r11.isEmpty() == true) goto L23;
            int r1 = x8.a.a;
            StringBuilder r12 = new StringBuilder("init processor: ");
            List r13 = r11;
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator<T> r15 = r13.iterator();
        L7:
            if (r15.hasNext() == false) goto L9;
            r14.add(((com.bytedance.android.annie.lynx.service.latch.b) r15.next()).a);
            goto L7
        L9:
            r12.append(r14);
            x8.a.d("LatchPrefetchProcessorHolder", r12.toString(), false);
            JSONObject r16 = new JSONObject();
            AtomicInteger r17 = new AtomicInteger();
            Map<String, com.bytedance.android.latch.prefetch.internal.g> r18 = LatchPrefetchProcessorHolder.a;
            LinkedHashMap r19 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16));
            Iterator<T> r20 = r13.iterator();
        L11:
            if (r20.hasNext() == false) goto L17;
            com.bytedance.android.annie.lynx.service.latch.b r21 = (com.bytedance.android.annie.lynx.service.latch.b) r20.next();
            String r22 = r21.a;
            if (r22 != null) goto L15;
            String r23 = "";
        L16:
            Pair r24 = new Pair(r22, LatchPrefetchProcessorHolder.b(r16, r17, r11, r23, CollectionsKt.listOf(r21.b)));
            r19.put(r24.getFirst(), r24.getSecond());
            goto L11
        L15:
            r23 = r22;
            goto L16
        L17:
            r18.putAll(MapsKt.plus(r19, new Pair(null, LatchPrefetchProcessorHolder.b(r16, r17, r11, null, CollectionsKt.emptyList()))));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r10) {
            x8.a.c("LatchPrefetchProcessorHolder", (Throwable) r10, false);
        }
    }

    public static final class d implements Executor {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r10) {
            Schedulers.io().scheduleDirect(r10);
        }
    }

    public static final class e implements com.bytedance.android.latch.prefetch.internal.f {
        public final /* synthetic */ List<String> a;

        public final List<String> a() {
            return this.a;
        }

        public e(List<String> r1) {
            this.a = r1;
        }
    }

    public static final class f implements com.bytedance.android.latch.prefetch.internal.i {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ List<com.bytedance.android.annie.lynx.service.latch.b> d;

        public final void a(boolean r11, long r12) {
            String r0 = this.a;
            if (r0 == null) goto L11;
            if (r11 == false) goto L6;
            this.b.put(r0, r12);
        L8:
            if (this.c.incrementAndGet() != this.d.size()) goto L12;
            Map<String, com.bytedance.android.latch.prefetch.internal.g> r13 = LatchPrefetchProcessorHolder.a;
            JSONObject r10 = this.b;
            ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0().b(null, "latch_load_config", null, null, r10, null, null, 1, null);
            return;
        L12:
            return;
        L6:
            this.b.put(r0, -1);
            goto L8
        }

        public f(String r1, JSONObject r10, AtomicInteger r11, List<com.bytedance.android.annie.lynx.service.latch.b> r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    static {
        a = new LinkedHashMap();
    }

    public static void a(final List r10) {
        int r0 = x8.a.a;
        x8.a.d("LatchPrefetchProcessorHolder", "init channels: " + r10, false);
        k r1 = new k(new LatchPrefetchProcessorHolder$initActual$1(r10));
        Observable.fromIterable(((com.bytedance.android.annie.service.prefetch.p) Annie.getService$default(com.bytedance.android.annie.service.prefetch.p.class, null, 2, null)).o()).flatMap(new m(r1)).subscribeOn(Schedulers.io()).map(new n(r1)).onErrorReturn(o.a).filter(p.a).subscribeOn(Schedulers.io()).filter(a.a).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(b.a, c.a);
    }

    public static final com.bytedance.android.latch.prefetch.internal.g b(JSONObject r10, AtomicInteger r11, List<com.bytedance.android.annie.lynx.service.latch.b> r12, String r13, List<String> r14) {
        com.bytedance.android.latch.prefetch.internal.g r0 = com.bytedance.android.latch.prefetch.internal.g.b;
        Intrinsics.checkNotNullParameter("live", "business");
        Intrinsics.checkNotNullParameter("live", "business");
        Intrinsics.checkNotNullParameter("live", "business");
        com.bytedance.android.anniex.assemble.a.h();
        d r15 = d.a;
        Intrinsics.checkNotNullParameter(r15, "workerExecutor");
        e r16 = new e(r14);
        Intrinsics.checkNotNullParameter(r16, "configProvider");
        f r17 = new f(r13, r10, r11, r12);
        Intrinsics.checkNotNullParameter(r17, "monitor");
        com.bytedance.android.latch.prefetch.internal.b r18 = new com.bytedance.android.latch.prefetch.internal.b(r15, r16, r17);
        y r19 = new y(new ProcessManager(r15), r18);
        Intrinsics.checkNotNullParameter("live", "business");
        Intrinsics.checkNotNullParameter(r19, "handler");
        Intrinsics.checkNotNullParameter(r18, "configManager");
        com.bytedance.android.latch.prefetch.internal.g r20 = new com.bytedance.android.latch.prefetch.internal.g("live", r19, r18);
        if (Intrinsics.areEqual("live", "default_business") == false) goto L5;
        com.bytedance.android.latch.prefetch.internal.g.b = r20;
    L5:
        return r20;
    }
}
