package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.live.revenue.core.util.AsyncService;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RoomMessageService extends AsyncService implements yz0.l, yz0.i {
    public final BaseRoomMessageService d;
    public final com.bytedance.android.livesdk.revenue.service.message.d e;

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final void onStop() {
        super.onStop();
        BehaviorSubject<sh6.b<com.bytedance.android.livesdk.revenue.message.b>> r0 = this.d.a;
        sh6.a r1 = sh6.a.a;
        r0.onNext(r1);
        this.d.a.onComplete();
        this.d.b.onNext(r1);
        this.d.b.onComplete();
        this.d.c.onNext(r1);
        this.d.c.onComplete();
        this.d.d.onNext(r1);
        this.d.d.onComplete();
        this.d.f.clear();
        this.d.g.clear();
        this.d.h.clear();
    }

    public RoomMessageService(com.bytedance.android.livesdk.revenue.service.message.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManagerService");
        this.e = r2;
        this.d = new BaseRoomMessageService();
    }

    @Override // yz0.l
    public final void J0(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d.J0(r2);
    }

    @Override // yz0.i
    public final void Lk(Function1<? super com.bytedance.android.livesdk.revenue.message.a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.d.Lk(r2);
    }

    @Override // yz0.l
    public final void f0(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d.f0(r2);
    }

    @Override // yz0.l
    public final void h(vlc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.d.h(r2);
    }

    @Override // yz0.l
    public final Observable nh(yh6.f r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        return this.d.nh(r2);
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r5) {
        if ((r5 instanceof RoomMessageService$onStartAsync$1) == false) goto L7;
        RoomMessageService$onStartAsync$1 r0 = (RoomMessageService$onStartAsync$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        RoomMessageService r4 = (RoomMessageService) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L18:
        com.bytedance.android.livesdk.revenue.message.i r7 = r4.e.getMessageManager();
        r4.d.a.onNext(sh6.c.a(r7));
        r4.d.b.onNext(sh6.c.a(r4.e.xj()));
        r4.d.c.onNext(sh6.c.a(r4.e.c2()));
        r4.d.d.onNext(sh6.c.a(r4.e.Ih()));
        r4.d.e.onNext(sh6.c.a(r4.e.Kk()));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        com.bytedance.android.livesdk.revenue.service.message.d r8 = this.e;
        r0.L$0 = this;
        r0.label = 1;
        if (r8.g(r0) != r2) goto L17;
        return r2;
    L17:
        r4 = this;
    L7:
        r0 = new RoomMessageService$onStartAsync$1(this, r5);
        goto L8
    }

    @Override // yz0.i
    public final void pe(Function1<? super com.bytedance.android.livesdk.revenue.message.d, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.d.pe(r2);
    }

    @Override // yz0.i
    public final void ra(Function1<? super com.bytedance.android.livesdk.revenue.message.b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.d.ra(r2);
    }

    @Override // yz0.l
    public final Observable Dm(yh6.f r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        return this.d.Dm(r2, r3);
    }

    @Override // yz0.l, yz0.f
    public void insert(yh6.c r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.d.insert(r2, r3);
    }

    @Override // yz0.h
    public final <T extends yh6.c> Observable<T> S4(yh6.b<T> r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        return this.d.S4(r2, r3, r4);
    }
}
