package f01;

import com.bytedance.android.live.revenue.common.r;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import e01.d;
import e01.g;
import e01.i;
import e01.j;
import e01.k;
import io.reactivex.Single;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o, i {
    public final d01.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public b(d01.a r2) {
        Intrinsics.checkNotNullParameter(r2, "seiService");
        this.a = r2;
    }

    @Override // e01.i
    public final Single<d> clearSeiField(e01.c r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        String r5 = r4.getKey();
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        this.a.E3().b(r5);
        Class r6 = d.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r2 = vh7.b.a;
        Object r3 = r2.get(r6);
        if (r3 != null) goto L22;
        r3 = r6.getConstructor(new Class[0]);
        if (r3 == null) goto L21;
        Object r7 = r2.putIfAbsent(r6, r3);
        if (r7 == null) goto L22;
        r3 = r7;
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L22:
        Object r8 = ((SerializableObjectJsonAdapterBase) ((Constructor) r3).newInstance(new Object[0])).createInstance();
        if (r8 == null) goto L27;
        return Single.just((d) r8);
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.stream.api.aio.AioClearSeiFieldResponse");
    L11:
        return Single.error(new IllegalArgumentException("key is not specified"));
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // e01.i
    public final Single<k> setSeiField(j r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        String r0 = r7.getKey();
        int r2 = 1;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        JsonOrBytesJvm r4 = r7.getValue();
        if (r4 != null) goto L15;
    L17:
        Object r5 = JSONObject.NULL;
    L18:
        g r8 = r7.getAttributes();
        if (r8 == null) goto L23;
        Integer r6 = r8.getRepeatCount();
        if (r6 == null) goto L23;
        r2 = r6.intValue();
    L23:
        if (r8 == null) goto L25;
        Boolean r9 = r8.l5();
    L26:
        d01.b.a r10 = new d01.b.a(r2, Intrinsics.areEqual(r9, Boolean.TRUE));
        this.a.E3().a(r0, r5, r10);
        Class r12 = k.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r13 = r1.get(r12);
        if (r13 != null) goto L36;
        r13 = r12.getConstructor(new Class[0]);
        if (r13 == null) goto L35;
        Object r14 = r1.putIfAbsent(r12, r13);
        if (r14 == null) goto L36;
        r13 = r14;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r15 = ((SerializableObjectJsonAdapterBase) ((Constructor) r13).newInstance(new Object[0])).createInstance();
        if (r15 == null) goto L41;
        return Single.just((k) r15);
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.stream.api.aio.AioSetSeiFieldResponse");
    L25:
        r9 = null;
        goto L26
    L15:
        if (r4.a() != true) goto L17;
        r5 = r.a(r4.b());
        goto L18
    L11:
        return Single.error(new IllegalArgumentException("key is not specified"));
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
