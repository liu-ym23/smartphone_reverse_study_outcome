package qz0;

import com.bytedance.android.scope.o;
import com.bytedance.live.kmp.util.e;
import com.bytedance.revenue.platform.api.core.rx.q;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Single;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements g01.b, o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // g01.b
    public final Single<g01.a> getServerTimestamp() {
        Class r0 = g01.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L17;
        g01.a r5 = (g01.a) r4;
        r5.B7(e.a());
        i97.a r6 = i97.a.a;
        r5.D4(System.currentTimeMillis());
        int r7 = q.a;
        return Single.just(r5);
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.time.api.GetServerTimestampResponse");
    }
}
