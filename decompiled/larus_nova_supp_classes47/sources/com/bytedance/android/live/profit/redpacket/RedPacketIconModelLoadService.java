package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.android.livesdk.message.model.qa;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RedPacketIconModelLoadService implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final w0 b;
    public final y0 c;
    public final bv0.b d;
    public final c01.a e;
    public final yz0.k f;
    public final RedPacketHybridService g;
    public final r0 h;
    public final ny0.a i;
    public final LuckyBoxClientService j;
    public final yz0.l k;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RedPacketIconModelLoadService a;

        public a(RedPacketIconModelLoadService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            RedPacketIconModelLoadService r0 = this.a;
            com.bytedance.android.live.profit.redpacket.model.e r1 = new com.bytedance.android.live.profit.redpacket.model.e();
            r1.c(((qa) r3).getRawPayload());
            Unit r4 = Unit.INSTANCE;
            r0.c(r1);
        }
    }

    public final void onStart() {
        if (this.b.p().a == false) goto L10;
        this.e.D9(b1.class, new AnonymousClass1(this));
        if (this.b.p().c == false) goto L12;
        com.bytedance.android.livesdk.revenue.service.message.d r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.message.d.class);
        if (r0 == null) goto L9;
        r0.i1("WebcastLuckyBoxMessage");
    L9:
        RxUtilKt.c(new RedPacketIMDataSource(this.k, this.a).d.take(1).subscribe(new a(this)), this.a);
        com.bytedance.android.livesdk.revenue.service.room.b.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class), this.f.getRoom().getRoomId(), com.bytedance.android.live.profit.redpacket.model.b.class, new RedPacketIconModelLoadService$runWithBackendData$1(this), null, null, new RedPacketIconModelLoadService$runWithBackendData$2(this), this.a, 24);
        return;
    L12:
        return;
    L10:
        this.e.D9(RedPacketIconModel.class, new AnonymousClass3(this));
    }

    public final void onStop() {
        this.a.dispose();
    }

    public static final void a(RedPacketIconModelLoadService r2) {
        r2.getClass();
        int r0 = h.a;
        RxUtilKt.c(h.b(r2.f.getRoom().getId()).subscribe(new m0(r2)), r2.a);
    }

    public final void c(com.bytedance.android.live.profit.redpacket.model.e r4) {
        lz0.a r0 = (lz0.a) this.i.x(Reflection.getOrCreateKotlinClass(lz0.a.class), CenterServiceType.CENTER_SERVICE);
        lz0.b r1 = new lz0.b();
        r1.c();
        if (r4 == null) goto L5;
        uh7.c.d.getClass();
        byte[] r5 = uh7.c.f(r4);
    L6:
        r1.d(r5);
        Unit r6 = Unit.INSTANCE;
        RxUtilKt.c(r0.load(r1).subscribe(), this.a);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public RedPacketIconModelLoadService(w0 r2, y0 r3, bv0.b r4, c01.a r5, yz0.k r6, RedPacketHybridService r7, r0 r8, ny0.a r9, LuckyBoxClientService r10, yz0.l r12) {
        Intrinsics.checkNotNullParameter(r2, "redPacketScope");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "redPacketDressService");
        Intrinsics.checkNotNullParameter(r5, "stiService");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        Intrinsics.checkNotNullParameter(r7, "redPackerHybridService");
        Intrinsics.checkNotNullParameter(r8, "redPacketRepository");
        Intrinsics.checkNotNullParameter(r9, "rpcService");
        Intrinsics.checkNotNullParameter(r10, "clientService");
        Intrinsics.checkNotNullParameter(r12, "messageService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r12;
        this.a = new CompositeDisposable();
    }
}
