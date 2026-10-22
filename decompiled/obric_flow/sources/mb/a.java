package mb;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f20054a = null;

    static {
        f20054a = new ConcurrentHashMap();
    }

    public static b a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        b r10 = (b) f20054a.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new b();
    }
}
