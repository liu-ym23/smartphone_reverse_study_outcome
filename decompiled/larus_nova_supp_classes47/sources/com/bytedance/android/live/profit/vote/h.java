package com.bytedance.android.live.profit.vote;

import com.bytedance.android.live.profit.vote.model.VoteConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements o, yz0.m {
    public final CompositeDisposable a;
    public final cy0.f b;
    public final yz0.g c;

    public static final class a extends DataContext {
        private final j inst;

        public final void shareAsCurrent() {
            j r0 = this.inst;
            int r1 = com.bytedance.live.datacontext.d.a;
            Intrinsics.checkNotNullParameter(this, "self");
            com.bytedance.live.datacontext.b.a(this, r0);
        }

        public final j getInst() {
            return this.inst;
        }

        public a(j r2) {
            Intrinsics.checkNotNullParameter(r2, "inst");
            this.inst = r2;
        }
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        IRoomBase r0 = this.c.mo444getRoom();
        int r1 = VoteConfig.a;
        LiveVoteConfig r2 = l.a();
        boolean r3 = false;
        if (r2 == null) goto L7;
        Integer r4 = r2.X8();
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L9:
        if (r5 < 1) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L14;
    L20:
        if (r3 == false) goto L35;
        final m r7 = new m(this.b);
        Intrinsics.checkNotNullParameter(r7, "scope");
        Object r8 = e33.k.a;
        if (r7.e != r8) goto L25;
        String r9 = "revenueInstance";
    L31:
        if (r9 != null) goto L34;
        Pair r10 = com.bytedance.live.datacontext.d.a(new VoteLoaderService$loadVote$1(r7));
        a r12 = (a) r10.component1();
        Disposable r13 = (Disposable) r10.component2();
        this.a.add(r13);
        r12.shareAsCurrent();
        com.bytedance.android.scope.l.a(r7);
        return;
    L34:
        throw new UninitializedPropertyAccessException(r9);
    L25:
        if (r7.f != r8) goto L28;
        r9 = "revenueInstanceExt";
        goto L31
    L28:
        if (r7.g != r8) goto L30;
        r9 = "roomInstance";
        goto L31
    L30:
        r9 = null;
        goto L31
    L35:
        return;
    L14:
        if (IRoomKt_androidKt.isMediaRoom(r0) == true) goto L20;
        if (IRoomKt_androidKt.isStarRoom(r0) == true) goto L20;
        if (IRoomKt_androidKt.isKoiRoom(r0) == true) goto L20;
        r3 = true;
        goto L20
    L11:
        r6 = false;
    L7:
        r5 = 0;
        goto L9
    }

    public final void onStop() {
        this.a.clear();
    }

    public h(cy0.f r2, yz0.g r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
