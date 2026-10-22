package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o {
    public final yz0.g a;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Single a() {
        Intrinsics.checkNotNullParameter("enter_room", "requestSource");
        cy0.e.a.getClass();
        j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(jy0.a.class));
        Intrinsics.checkNotNull(r1);
        jy0.a r2 = (jy0.a) ((f80.a) r1);
        r2.k("VoteApiClient", "getCurrentVote enter_room");
        b r3 = b.c;
        long r4 = IRoomKtKt.getId(this.a.mo444getRoom());
        r3.getClass();
        Observable r5 = b.a(r4, "enter_room").flatMap(d.a).doOnComplete(new e(r2));
        int r6 = p.a;
        return r5.observeOn(AndroidSchedulers.mainThread()).singleOrError();
    }

    public c(yz0.g r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.a = r2;
    }
}
