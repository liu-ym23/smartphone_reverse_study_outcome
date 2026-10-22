package vw0;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.utils.k;
import com.bytedance.android.live.recharge.utils.n;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final g a(com.bytedance.android.live.recharge.model.d r4) {
        Intrinsics.checkNotNullParameter(r4, "entranceParams");
        Class r0 = g.class.getAnnotation(JsonAdapter.class).value();
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
        Object r5 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r5 == null) goto L24;
        g r6 = (g) r5;
        r6.n8(r4.h);
        r6.U6(r4.b);
        int r7 = k.a;
        String r8 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).getBioType();
        String r9 = "";
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r6.Z7(r8);
        String r10 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).Y0();
        if (r10 == null) goto L21;
        r9 = r10;
    L21:
        r6.F6(r9);
        r6.N4(k.b());
        r6.T6(k.a());
        r6.setLiveType(n.a());
        return r6;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.aio.RechargeCommonParams");
    }
}
