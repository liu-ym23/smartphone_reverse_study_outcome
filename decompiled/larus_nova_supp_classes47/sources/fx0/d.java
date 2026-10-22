package fx0;

import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ b.C0240b b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ CallContext d;
    public final /* synthetic */ ExchangeType e;
    public final /* synthetic */ py.k f;

    public d(b r1, b.C0240b r2, Ref.ObjectRef r3, CallContext r4, ExchangeType r5, py.k r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r12) {
        Long r13 = (Long) r12;
        Long r0 = this.b.a();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        long r7 = r1 - r13.longValue();
        com.bytedance.android.live.incentive.exchange.c r14 = qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        Intrinsics.checkNotNull(r14);
        com.bytedance.android.live.incentive.exchange.c r15 = r14;
        if (r15.d(r7) == false) goto L9;
        c r9 = new c(this, r7);
        r15.g(new com.bytedance.android.live.incentive.exchange.l(this.d.getContext(), this.e, r7, r9, this.f));
        return;
    L9:
        this.a.finishWithResult(new b.c(2, null));
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
