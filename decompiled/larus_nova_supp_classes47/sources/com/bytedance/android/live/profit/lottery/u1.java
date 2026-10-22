package com.bytedance.android.live.profit.lottery;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u1<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ l01.d b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Lottery d;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g e;
    public final /* synthetic */ LotteryState.a f;

    public u1(LotteryRepository r1, l01.d r2, boolean r3, Lottery r4, com.bytedance.android.live.revenue.common.g r5, LotteryState.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r7) {
        e1 r4 = (e1) r7;
        String r8 = this.b.b().getIdString();
        List<String> r0 = r4.b;
        boolean r2 = true;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((String) r1.next(), r8) == false) goto L9;
        boolean r9 = true;
    L15:
        if (((ParticipateStatus) this.a.g.a) == ParticipateStatus.PARTICIPATEINSUCCESS) goto L19;
        if (r9 == true) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L21;
        boolean r3 = this.c;
        JsonObject r5 = new JsonObject();
        r5.add("rawRes", GsonProtectorUtils.toJsonTree(new Gson(), r4));
        Unit r6 = Unit.INSTANCE;
        p0 r10 = new p0(r2, r9, r3, r5);
        this.a.d(this.d, r10);
        this.e.b(r10.toString());
        return;
    L21:
        this.e.a("user_maybe_participate");
        this.a.i(this.f, this.d, 0, r4, this.e);
        return;
    L13:
        r9 = false;
        goto L15
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }
}
