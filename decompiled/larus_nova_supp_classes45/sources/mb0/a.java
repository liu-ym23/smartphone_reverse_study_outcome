package mb0;

import com.bytedance.android.live.core.log.ALogger;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<T> {
    public final HashMap<Long, LinkedList<g<T>>> a;

    /* JADX INFO: renamed from: mb0.a$a, reason: collision with other inner class name */
    public static final class C0247a {
    }

    static {
    }

    public abstract long c(T r1);

    public abstract void d(String r1, T r2);

    public a() {
        this.a = new HashMap();
    }

    public final LinkedList<g<T>> b(long r4) {
        LinkedList<g<T>> r0 = this.a.get(Long.valueOf(r4));
        if (r0 != null) goto L6;
        LinkedList<g<T>> r1 = new LinkedList();
        String r2 = "new queue:" + r4;
        Intrinsics.checkNotNullParameter(r2, "content");
        ALogger.i("AbsChainMonitorQueue", r2);
        this.a.put(Long.valueOf(r4), r1);
        return r1;
    L6:
        return r0;
    }

    public final void a(String r6, T r7) {
        Intrinsics.checkNotNullParameter(r6, "path");
        long r0 = c(r7);
        LinkedList<g<T>> r2 = b(r0);
        r2.add(new g(r6, r7));
        String r8 = "finish node,path：" + r6 + ", param:" + r7;
        Intrinsics.checkNotNullParameter(r8, "content");
        ALogger.w("AbsChainMonitorQueue", r8);
        g<T> r9 = r2.pollFirst();
    L3:
        if (r9 == null) goto L5;
        d(r9.a, r9.b);
        r9 = r2.pollFirst();
        goto L3
    L5:
        this.a.remove(Long.valueOf(r0));
    }
}
