package o69;

import com.bytedance.keva.Keva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public static final Lazy a = null;
    public static final CopyOnWriteArrayList<String> b = null;
    public static final Lazy c = null;
    public static final Object d = null;

    static {
        a = LazyKt.lazy(new c());
        CopyOnWriteArrayList<String> r2 = new CopyOnWriteArrayList();
        b = r2;
        c = LazyKt.lazy(new d());
        d = new Object();
        c();     // Catch: Exception -> L5
        g49.d.d("DoraGTimeSyncRepo", "Initialized with " + r2.size() + " sessions, max limit: " + b());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Failed to load session list: " + e.getMessage());
    }

    public static int b() {
        return ((Number) c.getValue()).intValue();
    }

    public static void c() {
        String r3 = ((Keva) a.getValue()).getString("dora_g_time_sync_session_list", "");
        Intrinsics.checkNotNull(r3);
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L23;
        List r1 = StringsKt.split$default(r3, new String[]{","}, false, 0, 6, null);
        ArrayList r4 = new ArrayList();
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        Object r5 = r2.next();
        if (((String) r5).length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        r4.add(r5);
        goto L9
    L13:
        r6 = false;
        goto L14
    L16:
        CopyOnWriteArrayList<String> r7 = b;
        r7.clear();
        r7.addAll(r4);
        return;
    L23:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void d() {
        String r0 = CollectionsKt.joinToString$default(b, ",", null, null, 0, null, null, 62, null);
        ((Keva) a.getValue()).storeString("dora_g_time_sync_session_list", r0);
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Object r1 = d;     // Catch: Exception -> L16
        monitor-enter(r1);     // Catch: Exception -> L16
        CopyOnWriteArrayList<String> r2 = b;     // Catch: Throwable -> L13
        if (r2.contains(r4) == true) goto L10;
        g49.d.d("DoraGTimeSyncRepo", "Session " + r4 + " not found for deletion");     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Exception -> L16
        return;
    L10:
        r2.remove(r4);     // Catch: Throwable -> L13
        ((Keva) a.getValue()).erase("dora_g_time_sync_session_" + r4);     // Catch: Throwable -> L13
        d();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Exception -> L16
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Error deleting time deviation: " + e.getMessage());
    }

    public static boolean e(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Object r2 = d;     // Catch: Exception -> L17
        monitor-enter(r2);     // Catch: Exception -> L17
        CopyOnWriteArrayList<String> r3 = b;     // Catch: Throwable -> L14
        if (r3.contains(r5) == true) goto L10;
        g49.d.d("DoraGTimeSyncRepo", "Session " + r5 + " not found for update");     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Exception -> L17
        return false;
    L10:
        ((Keva) a.getValue()).storeLong("dora_g_time_sync_session_" + r5, r6);     // Catch: Throwable -> L14
        r3.remove(r5);     // Catch: Throwable -> L14
        r3.add(r5);     // Catch: Throwable -> L14
        d();     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Exception -> L17
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Error updating time deviation: " + e.getMessage());
        return false;
    }
}
