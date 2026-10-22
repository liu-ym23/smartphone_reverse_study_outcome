package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.link.model.i2;
import com.bytedance.android.livesdk.link.model.l2;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkReserveBattleManager {
    public final CompositeDisposable a;
    public final PkReserveBattleDataContext b;
    public final PkReserveBattleManager$showReserveDialogObserver$1 c;
    public final PkReserveBattleManager$showReserveBeInviteDialogObserver$1 d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final yz0.f f;
    public final ld.a g;
    public final lr2.a h;
    public final com.bytedance.android.live.revlink.impl.global.c i;
    public final Function2<l2, PkReserveBattleDataContext, Unit> j;
    public final Function2<i2, PkReserveBattleDataContext, Unit> k;

    public PkReserveBattleManager(com.bytedance.android.livesdk.revenue.service.room.c r2, yz0.f r3, ld.a r4, lr2.a r5, com.bytedance.android.live.revlink.impl.global.c r6, Function2<? super l2, ? super PkReserveBattleDataContext, Unit> r7, Function2<? super i2, ? super PkReserveBattleDataContext, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "showReserveDialog");
        Intrinsics.checkNotNullParameter(r8, "showReserveBeInviteDialog");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        CompositeDisposable r9 = new CompositeDisposable();
        this.a = r9;
        Observer r10 = new PkReserveBattleManager$showReserveDialogObserver$1(this);
        this.c = r10;
        Observer r12 = new PkReserveBattleManager$showReserveBeInviteDialogObserver$1(this);
        this.d = r12;
        Pair r13 = com.bytedance.live.datacontext.d.a(new PkReserveBattleManager$pair$1(this));
        PkReserveBattleDataContext r14 = (PkReserveBattleDataContext) r13.getFirst();
        this.b = r14;
        com.bytedance.live.datacontext.b.a((DataContext) r13.getFirst(), "IPkBattleReserveService");
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r13.getSecond(), r9);
        if (r14 == null) goto L7;
        MutableLiveData<l2> r15 = r14.getShowReserveSettleDialog();
        if (r15 == null) goto L7;
        r15.observeForever(r10);
    L7:
        if (r14 == null) goto L12;
        MutableLiveData<i2> r16 = r14.getShowReserveInviteDialog();
        if (r16 == null) goto L13;
        r16.observeForever(r12);
        return;
    L13:
        return;
    }
}
