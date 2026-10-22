package zo0;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final /* synthetic */ int d = 0;
    public final List<e> a;
    public final Bundle b;
    public final String c;

    public static final class a {
    }

    public interface b<T extends f> {
        void a(T r1);

        void onFailure();
    }

    static {
    }

    public final void b() {
        l("finish", null);
    }

    public final synchronized void n() {
        monitor-enter(this);
        ((ArrayList) this.a).clear();     // Catch: Throwable -> L6
        this.b.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void o() {
        l("start", null);
    }

    public final long f() {
        return k("finish");
    }

    public final long h() {
        return k("start");
    }

    public f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.c = r2;
        this.a = new ArrayList();
        this.b = new Bundle();
    }

    public static /* synthetic */ long e(f r2) {
        return r2.d("finish", "start");
    }

    public final synchronized boolean c(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Throwable -> L6
        boolean r4 = this.b.getBoolean(r3, false);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized long g(String r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Throwable -> L6
        long r0 = this.b.getLong(r4, 0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String i(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("click_source", "key");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r3, "defaultValue");     // Catch: Throwable -> L7
        String r4 = this.b.getString("click_source", r3);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized int j(String r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "event");     // Catch: Throwable -> L13
        Iterator r0 = ((ArrayList) this.a).iterator();     // Catch: Throwable -> L13
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((e) r0.next()).a, r4) == true) goto L11;
        r1 = r1 + 1;
    L11:
        monitor-exit(this);
        return r1;
    L10:
        r1 = -1;
    L13:
        th = move-exception;
        throw th;
    }

    public final long k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "event");     // Catch: Throwable -> L14
        int r4 = j(r3);     // Catch: Throwable -> L14
        if (r4 == (-1)) goto L8;
        e r5 = (e) ListProtector.get(this.a, r4);     // Catch: Throwable -> L14
    L9:
        monitor-exit(this);
        if (r5 != null) goto L19;
        return 0;
    L19:
        return r5.b;
    L8:
        r5 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public static void a(f r4, b r5) {
        monitor-enter(r4);
        Intrinsics.checkNotNullParameter("start", "beginEvent");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter("finish", "endEvent");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r5, "callback");     // Catch: Throwable -> L16
        int r0 = r4.j("start");     // Catch: Throwable -> L16
        int r1 = r4.j("finish");     // Catch: Throwable -> L16
        if (r0 >= 0) goto L7;
    L13:
        r5.onFailure();     // Catch: Throwable -> L16
        monitor-exit(r4);
        return;
    L7:
        if (r1 >= ((ArrayList) r4.a).size()) goto L13;
        if (r0 >= r1) goto L13;
        List r2 = CollectionsKt.slice(r4.a, new IntRange(r0, r1));     // Catch: Throwable -> L16
        f r3 = new f(r4.c);     // Catch: Throwable -> L16
        ArrayList r6 = (ArrayList) r3.a;     // Catch: Throwable -> L16
        r6.addAll(r2);     // Catch: Throwable -> L16
        r3.b.putAll(r4.b);     // Catch: Throwable -> L16
        r5.a(r3);     // Catch: Throwable -> L16
        monitor-exit(r4);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized long d(String r3, String r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "endEvent");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r4, "beginEvent");     // Catch: Throwable -> L7
        long r0 = k(r3) - k(r4);
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void l(String r5, Long r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "event");     // Catch: Throwable -> L34
        if ((!Intrinsics.areEqual(r5, "start")) == false) goto L22;
        e r0 = (e) CollectionsKt.firstOrNull(this.a);     // Catch: Throwable -> L34
        Object r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.a;     // Catch: Throwable -> L34
    L10:
        if (Intrinsics.areEqual(r2, "start") == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        Iterator r3 = ((ArrayList) this.a).iterator();     // Catch: Throwable -> L34
    L15:
        if (r3.hasNext() == false) goto L19;
        Object r4 = r3.next();     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(((e) r4).a, r5) == false) goto L15;
        r1 = r4;
    L19:
        if (r1 == null) goto L22;
        monitor-exit(this);
        return;
    L8:
        r2 = null;
    L22:
        if (r6 == null) goto L24;
        long r7 = r6.longValue();     // Catch: Throwable -> L34
    L26:
        if (Intrinsics.areEqual(r5, "start") == false) goto L29;
        n();     // Catch: Throwable -> L34
    L29:
        if (v.a() == true) goto L31;
    L31:
        ((ArrayList) this.a).add(new e(r5, r7));     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L24:
        r7 = SystemClock.uptimeMillis();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final synchronized void m(String r2, boolean r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L6
        this.b.putBoolean(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
