package aw0;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.core.f;
import com.bytedance.android.live.recharge.utils.k;
import com.bytedance.android.live.recharge.utils.n;
import com.bytedance.android.live.revenue.common.reactive.j;
import com.bytedance.android.scope.o;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import vw0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o, aw0.b {
    public final com.bytedance.android.live.recharge.balance.d a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            com.bytedance.android.live.recharge.balance.c r5 = (com.bytedance.android.live.recharge.balance.c) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            this.a.getClass();
            aw0.a r0 = new aw0.a();
            r0.a(r5.a);
            return r0;
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            com.bytedance.android.live.recharge.balance.c r5 = (com.bytedance.android.live.recharge.balance.c) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            this.a.getClass();
            aw0.a r0 = new aw0.a();
            r0.a(r5.a);
            return r0;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // aw0.b
    public final g getRechargeCommonParams() {
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
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L24;
        g r5 = (g) r4;
        String r6 = "";
        r5.n8("");
        r5.U6("");
        int r7 = k.a;
        String r8 = f.b(RechargeServices.b()).getBioType();
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r5.Z7(r8);
        String r9 = f.b(RechargeServices.b()).Y0();
        if (r9 == null) goto L21;
        r6 = r9;
    L21:
        r5.F6(r6);
        r5.N4(k.b());
        r5.T6(k.a());
        r5.setLiveType(n.a());
        return r5;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.aio.RechargeCommonParams");
    }

    @Override // aw0.b
    public final Observable<aw0.a> observeBalanceInfo() {
        return j.a(this.a.U(), true).map(new a(this));
    }

    public c(com.bytedance.android.live.recharge.balance.d r2) {
        Intrinsics.checkNotNullParameter(r2, "walletBalanceService");
        this.a = r2;
    }

    @Override // aw0.b
    public final Single<aw0.a> updateBalanceInfo(d r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        return this.a.C1(new com.bytedance.android.live.recharge.balance.f(r4.a(), null)).map(new b(this)).singleOrError();
    }
}
