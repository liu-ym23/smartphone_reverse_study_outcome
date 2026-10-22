package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.link.model.d5;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkPrecisionMatchManager {
    public final CompositeDisposable a;
    public final PkPrecisionMatchDataContext b;
    public final PkPrecisionMatchManager$showDialogObserver$1 c;
    public final PkPrecisionMatchManager$updateLynxMatchUserStatusObserver$1 d;
    public final ld.a e;
    public final com.bytedance.android.livesdk.revenue.service.room.c f;
    public final com.bytedance.android.live.revlink.impl.global.c g;
    public final yz0.f h;
    public final x11.a i;
    public final Function1<PkPrecisionMatchDataContext, Unit> j;
    public final Function1<PkPrecisionMatchDataContext, Unit> k;

    /* JADX WARN: Multi-variable type inference failed */
    public PkPrecisionMatchManager(ld.a r2, com.bytedance.android.livesdk.revenue.service.room.c r3, com.bytedance.android.live.revlink.impl.global.c r4, yz0.f r5, x11.a r6, Function1<? super PkPrecisionMatchDataContext, Unit> r7, Function1<? super PkPrecisionMatchDataContext, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "showDialog");
        Intrinsics.checkNotNullParameter(r8, "updateMatchUser");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        CompositeDisposable r9 = new CompositeDisposable();
        this.a = r9;
        Observer r10 = new PkPrecisionMatchManager$showDialogObserver$1(this);
        this.c = r10;
        Observer r12 = new PkPrecisionMatchManager$updateLynxMatchUserStatusObserver$1(this);
        this.d = r12;
        Pair r13 = com.bytedance.live.datacontext.d.a(new PkPrecisionMatchManager$pair$1(this));
        PkPrecisionMatchDataContext r14 = (PkPrecisionMatchDataContext) r13.getFirst();
        this.b = r14;
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r13.getFirst(), "IPKPrecisionMatchService", r4);
        r9.add((Disposable) r13.getSecond());
        if (r14 == null) goto L7;
        MutableLiveData<d5> r15 = r14.getShowDialogData();
        if (r15 == null) goto L7;
        r15.observeForever(r10);
    L7:
        if (r14 == null) goto L12;
        MutableLiveData<d5> r16 = r14.getUpdateLynxMatchUserStatus();
        if (r16 == null) goto L13;
        r16.observeForever(r12);
        return;
    L13:
        return;
    }
}
