package ix0;

import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o, a {
    public final AtomicInteger a;
    public final ConcurrentHashMap<String, WeakReference<Object>> b;

    public final void onStart() {
    }

    public final void onStop() {
        this.b.clear();
    }

    public c() {
        this.a = new AtomicInteger(1);
        this.b = new ConcurrentHashMap();
    }

    @Override // ix0.a
    public final <T> T e1(b<T> r4) {
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.KEY_TOKEN);
        String r5 = r4.a;
        WeakReference<Object> r0 = this.b.get(r5);
        if (r0 == null) goto L10;
        T r1 = (T) r0.get();
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new IllegalStateException("object ID '" + r5 + "' is recycled");
    L10:
        throw new IllegalArgumentException("object ID '" + r5 + "' is invalid");
    }

    @Override // ix0.a
    public final <T> b<T> f1(T r4) {
        Intrinsics.checkNotNullParameter(r4, "obj");
        String r0 = r4.getClass().getSimpleName() + '@' + this.a.getAndIncrement();
        this.b.put(r0, new WeakReference(r4));
        return new b(r0);
    }
}
