package t6b;

import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o extends s6b.a {
    public final x0 b;

    public o(x0 r2) {
        Intrinsics.checkNotNullParameter(r2, "messageListParams");
        this.b = r2;
    }

    public final void c(Function1<? super d, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "patch");
        Object r1 = ((LinkedHashMap) this.a).get(c.class);
        if ((r1 instanceof c) == true) goto L5;
        r1 = null;
    L5:
        s6b.b<?, ?> r2 = (c) r1;
        if (r2 == null) goto L15;
    L11:
        if (r2 == null) goto L18;
        Map<Class<s6b.b<?, ?>>, s6b.b<?, ?>> r3 = this.a;
        s6b.b r4 = r2.a();
        r5.invoke(r4);
        r3.put(c.class, r2.b(r4));
        return;
    L18:
        return;
    L15:
        r2 = (s6b.b) c.class.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L9
        this.a.put(c.class, r2);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.e("create base error", e);
    }

    public final void d(Function1<? super h, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "patch");
        Object r1 = ((LinkedHashMap) this.a).get(g.class);
        if ((r1 instanceof g) == true) goto L5;
        r1 = null;
    L5:
        s6b.b<?, ?> r2 = (g) r1;
        if (r2 == null) goto L15;
    L11:
        if (r2 == null) goto L18;
        Map<Class<s6b.b<?, ?>>, s6b.b<?, ?>> r3 = this.a;
        s6b.b r4 = r2.a();
        r5.invoke(r4);
        r3.put(g.class, r2.b(r4));
        return;
    L18:
        return;
    L15:
        r2 = (s6b.b) g.class.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L9
        this.a.put(g.class, r2);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.e("create base error", e);
    }

    public final void e(Function1<? super l, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "patch");
        Object r1 = ((LinkedHashMap) this.a).get(k.class);
        if ((r1 instanceof k) == true) goto L5;
        r1 = null;
    L5:
        s6b.b<?, ?> r2 = (k) r1;
        if (r2 == null) goto L15;
    L11:
        if (r2 == null) goto L18;
        Map<Class<s6b.b<?, ?>>, s6b.b<?, ?>> r3 = this.a;
        s6b.b r4 = r2.a();
        r5.invoke(r4);
        r3.put(k.class, r2.b(r4));
        return;
    L18:
        return;
    L15:
        r2 = (s6b.b) k.class.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L9
        this.a.put(k.class, r2);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.e("create base error", e);
    }
}
