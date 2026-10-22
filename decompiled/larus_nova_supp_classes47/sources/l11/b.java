package l11;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import ey.f;
import ey.l;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import k11.n;
import k11.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final o a(l r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toLynx");
        n.a r0 = n.o;
        f r1 = r5.a;
        int r2 = r1.d;
        long r3 = r1.a;
        r0.getClass();
        n r4 = n.a.a(r2, r3);
        f r6 = r5.b;
        n r7 = n.a.a(r6.d, r6.a);
        o.p.getClass();
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r7, "to");
        Class r8 = o.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r9 = vh7.b.a;
        Object r10 = r9.get(r8);
        if (r10 != null) goto L12;
        r10 = r8.getConstructor(new Class[0]);
        if (r10 == null) goto L11;
        Object r12 = r9.putIfAbsent(r8, r10);
        if (r12 == null) goto L12;
        r10 = r12;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r13 = ((SerializableObjectJsonAdapterBase) ((Constructor) r10).newInstance(new Object[0])).createInstance();
        if (r13 == null) goto L17;
        o r14 = (o) r13;
        r14.M6(r4);
        r14.q2(r7);
        return r14;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.StateTransition");
    }
}
