package ir8;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final CopyOnWriteArraySet<a> a = null;
    public static final CopyOnWriteArrayList<a> b = null;

    public interface a {
        void a();
    }

    static {
        a = new CopyOnWriteArraySet();
        b = new CopyOnWriteArrayList();
    }

    public static boolean a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        if (CollectionsKt.lastOrNull(b) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (a.contains(r2) == true) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<a> r0 = b;
        if (CollectionsKt.lastOrNull(r0) != r2) goto L8;
        return;
    L8:
        r0.remove(r2);
        r0.add(r2);
    }

    public static void c(a r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        a.remove(r1);
        b.remove(r1);
    }
}
