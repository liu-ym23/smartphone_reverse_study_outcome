package g68;

import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.sami.v2.x;
import com.larus.audio.report.h;
import g78.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final ConcurrentHashMap<String, h68.e> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static List d() {
        Collection<h68.e> r0 = a.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((h68.e) r3).d() == AsrState.ASR_STOP) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        r5.add(((h68.e) r6.next()).getTaskId());
        goto L13
    L15:
        return r5;
    }

    public static int e() {
        return a.size();
    }

    public static y58.a c(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        h68.e r3 = a.get(r2);
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.getConfig();
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public static boolean f(String r2) {
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        h68.e r3 = a.get(r2);
        if (r3 != null) goto L14;
        return false;
    L14:
        return r3.b();
    L5:
        if (r2.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static long g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return 0;
    L9:
        h68.e r4 = a.get(r3);
        if (r4 != null) goto L12;
        return 0;
    L12:
        return r4.e();
    L5:
        r0 = false;
        goto L7
    }

    public static void h(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        h68.e r2 = a.get(r1);
        if (r2 == null) goto L12;
        r2.release();
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void i(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        h68.e r2 = a.get(r1);
        if (r2 == null) goto L12;
        r2.start();
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void j(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        h68.e r2 = a.get(r1);
        if (r2 == null) goto L12;
        r2.stop();
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(String r1, a0 r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        h68.e r3 = a.get(r1);
        if (r3 == null) goto L14;
        r3.f(r2);
        return;
    L14:
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void b(String r3, w58.a r4, h r5) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L16;
        ConcurrentHashMap<String, h68.e> r1 = a;
        if (r1.containsKey(r3) == false) goto L13;
        return;
    L13:
        int r2 = c68.b.a;
        c68.b.a("AsrManager", "addAsrTask taskId: " + r3 + ", task size: " + r1.size());
        x r6 = new x(r3);
        r6.k(r4);
        r6.z = r5;
        r1.put(r3, r6);
        return;
    L16:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public static int k(String r2, byte[] r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "buffer");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return -1;
    L9:
        h68.e r5 = a.get(r2);
        if (r5 != null) goto L12;
        return -1;
    L12:
        return r5.a(r3, r4);
    L5:
        r0 = false;
        goto L7
    }
}
