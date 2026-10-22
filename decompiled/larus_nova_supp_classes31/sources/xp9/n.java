package xp9;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n {
    public static Object a;
    public static final List<Function1<Object, Unit>> b = null;

    static {
        b = new CopyOnWriteArrayList();
    }

    public static void a(Function1 r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((CopyOnWriteArrayList) b).add(r1);
        Object r0 = a;
        if (r0 == null) goto L6;
        r1.invoke(r0);
        return;
    }

    public static void b(Function1 r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((CopyOnWriteArrayList) b).remove(r1);
    }
}
