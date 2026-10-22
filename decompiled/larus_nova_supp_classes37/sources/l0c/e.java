package l0c;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class e implements c {
    public final zyb.c a;
    public final int b;
    public final ConcurrentHashMap<String, Long> c;
    public final ConcurrentHashMap<String, Long> d;
    public final ConcurrentHashMap<String, Long> e;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Long) ((Map.Entry) r2).getValue(), (Long) ((Map.Entry) r1).getValue());
        }
    }

    static {
    }

    @Override // l0c.c
    public final void d() {
        zyb.a.b r0 = this.a.a();
        HashMap<String, Long> r1 = new HashMap();     // Catch: Exception -> L8
        j(r1);     // Catch: Exception -> L8
        k(r1);     // Catch: Exception -> L8
        Iterator<T> r2 = r1.entrySet().iterator();     // Catch: Exception -> L8
    L5:
        if (r2.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Exception -> L8
        r0.a((String) r3.getKey(), (Number) r3.getValue());     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        Log.e("PassportUserFlowMonitorImpl", "endRustInfraFlow exception:" + e);
    }

    @Override // l0c.c
    public final void e() {
        Intrinsics.checkNotNullParameter("rust_infra_user_notify_total", AppbrandHostConstants.Schema_Meta.NAME);
        this.c.put("rust_infra_user_notify_total", Long.valueOf(SystemClock.elapsedRealtime()));
    }

    @Override // l0c.c
    public final void f() {
        ConcurrentHashMap<String, Long> r0 = this.c;
        monitor-enter(r0);
        this.c.clear();     // Catch: Throwable -> L21
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        ConcurrentHashMap<String, Long> r2 = this.d;
        monitor-enter(r2);
        this.d.clear();     // Catch: Throwable -> L18
        monitor-exit(r2);
        ConcurrentHashMap<String, Long> r3 = this.e;
        monitor-enter(r3);
        this.e.clear();     // Catch: Throwable -> L15
        monitor-exit(r3);
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // l0c.c
    public final void h() {
        Intrinsics.checkNotNullParameter("rust_infra_user_notify_total", AppbrandHostConstants.Schema_Meta.NAME);
        Long r1 = this.c.get("rust_infra_user_notify_total");
        if (r1 == null) goto L16;
        long r3 = SystemClock.elapsedRealtime() - r1.longValue();
        Log.i("PassportUserFlowMonitorImpl", "endCountStep name:rust_infra_user_notify_total duration:" + r3);
        ConcurrentHashMap<String, Long> r2 = this.d;
        monitor-enter(r2);
        ConcurrentHashMap<String, Long> r4 = this.d;     // Catch: Throwable -> L13
        Long r5 = r4.get("rust_infra_user_notify_total");     // Catch: Throwable -> L13
        if (r5 == null) goto L9;
        long r6 = r5.longValue();     // Catch: Throwable -> L13
    L10:
        r4.put("rust_infra_user_notify_total", Long.valueOf(r6 + r3));     // Catch: Throwable -> L13
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r2);
        return;
    L9:
        r6 = 0;
    L13:
        th = move-exception;
        throw th;
    }

    @Inject
    public e(zyb.c r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorService");
        this.a = r2;
        this.b = 10;
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
    }

    @Override // l0c.c
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter("rust_online_scenario", AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.a().d(r3);
    }

    @Override // l0c.c
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        this.a.a().b(r2);
    }

    @Override // l0c.c
    public final void g(long r6) {
        Intrinsics.checkNotNullParameter("rust_infra_user_notify_total", AppbrandHostConstants.Schema_Meta.NAME);
        ConcurrentHashMap<String, Long> r1 = this.d;
        monitor-enter(r1);
        ConcurrentHashMap<String, Long> r2 = this.d;     // Catch: Throwable -> L11
        Long r3 = r2.get("rust_infra_user_notify_total");     // Catch: Throwable -> L11
        if (r3 == null) goto L7;
        long r4 = r3.longValue();     // Catch: Throwable -> L11
    L8:
        r2.put("rust_infra_user_notify_total", Long.valueOf(r4 + r6));     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);
        return;
    L7:
        r4 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // l0c.c
    public final void i(String r3) {
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
        this.a.a().c(r3, MapsKt.emptyMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(HashMap<String, Long> r5) {
        ConcurrentHashMap<String, Long> r0 = this.d;
        monitor-enter(r0);
        Iterator<T> r1 = this.d.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Throwable -> L11
        r5.put(r2.getKey(), r2.getValue());     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(HashMap<String, Long> r9) {
        ConcurrentHashMap<String, Long> r0 = this.d;
        monitor-enter(r0);
        Iterator r1 = CollectionsKt.sortedWith(this.e.entrySet(), new b()).iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Throwable -> L13
        if (((Number) r2.getValue()).longValue() < this.b) goto L6;
        r9.put(r2.getKey(), r2.getValue());     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // l0c.c
    public final void c(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_Meta.NAME);
        ConcurrentHashMap<String, Long> r0 = this.e;
        monitor-enter(r0);
        ConcurrentHashMap<String, Long> r1 = this.e;     // Catch: Throwable -> L11
        Long r2 = r1.get(r5);     // Catch: Throwable -> L11
        if (r2 == null) goto L7;
        long r3 = r2.longValue();     // Catch: Throwable -> L11
    L8:
        r1.put(r5, Long.valueOf(r3 + r6));     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L7:
        r3 = 0;
    L11:
        th = move-exception;
        throw th;
    }
}
