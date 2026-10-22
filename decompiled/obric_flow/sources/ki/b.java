package ki;

import dj.d;
import dj.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f18649a = null;

    static {
        f18649a = new ConcurrentHashMap();
    }

    public static void a(Class r5, Class r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r10, "annotation");
        boolean r11 = Intrinsics.areEqual(r10, d.class);
        ConcurrentHashMap r12 = f18649a;
        if (r11 == false) goto L10;
        if (r12.get(r5) != null) goto L8;
        return;
    L8:
        throw new ClassCastException();
    L10:
        if (Intrinsics.areEqual(r10, e.class) == true) goto L12;
        return;
    L12:
        if (r12.get(r5) != null) goto L15;
        return;
    L15:
        throw new ClassCastException();
    }
}
