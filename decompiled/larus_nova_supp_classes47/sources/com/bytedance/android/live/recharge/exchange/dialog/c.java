package com.bytedance.android.live.recharge.exchange.dialog;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.livesdk.utils.r3;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ CashExchangeDialogNew a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ String f;
    public final /* synthetic */ ExchangeType g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ int i;
    public final /* synthetic */ Map j;
    public final /* synthetic */ zv0.e k;

    public c(CashExchangeDialogNew r1, Ref.ObjectRef r2, Ref.ObjectRef r3, String r4, long r5, String r7, ExchangeType r8, boolean r9, int r10, Map r12, zv0.e r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r13;
    }

    public final void accept(Object r13) {
        Throwable r14 = (Throwable) r13;
        this.b.element = s1.C(2131915515, new Object[]{r3.c()});
        Ref.ObjectRef r15 = this.c;
        CashExchangeDialogNew r1 = this.a;
        String r2 = this.d;
        String r4 = s1.B(2131915485);
        String r5 = String.valueOf(this.e);
        String r6 = this.a.j;
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        String r7 = s1.B(2131915481);
        r1.getClass();
        r15.element = s1.C(2131915487, new Object[]{r2, r4, r5, r6, r7});
        CashExchangeDialogNew r3 = this.a;
        r3.t = "trial_exchange_income_error";
        r3.J0(this.f, this.g, (String) this.b.element, (String) this.c.element, this.e, this.h, this.i, this.j, this.k);
    }
}
