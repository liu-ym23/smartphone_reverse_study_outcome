package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements l {
    public final CompositeDisposable a;
    public long b;
    public long c;
    public final MultiLinkServerMonitor d;
    public final com.bytedance.android.live.revenuelink.withroom.a e;
    public final IRoomBase f;
    public final i g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ r a;
        public final /* synthetic */ fy.d b;

        public a(r r1, fy.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            i r10 = this.a.g;
            if (r10 == null) goto L5;
            r10.Z2(this.b);
        L5:
            MultiLinkServerMonitor r0 = this.a.d;
            int r1 = this.b.b;
            i97.a r12 = i97.a.a;
            r0.g(r1, "linkmic/finish/", System.currentTimeMillis() - this.a.c, this.b.c);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ r a;
        public final /* synthetic */ fy.d b;

        public b(r r1, fy.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Throwable r3 = (Throwable) r9;
            i r10 = this.a.g;
            if (r10 == null) goto L5;
            r10.i3(this.b, r3);
        L5:
            MultiLinkServerMonitor r0 = this.a.d;
            int r1 = this.b.b;
            i97.a r12 = i97.a.a;
            MultiLinkServerMonitor.e(r0, r1, "linkmic/finish/", r3, System.currentTimeMillis() - this.a.c);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ r a;
        public final /* synthetic */ fy.f b;
        public final /* synthetic */ int c;

        public c(r r1, fy.f r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r10 = (ExtraResponse) r9;
            i r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.m3(this.b, r10);
        L5:
            MultiLinkServerMonitor r1 = this.a.d;
            int r2 = this.c;
            i97.a r3 = i97.a.a;
            long r4 = System.currentTimeMillis() - this.a.b;
            Intrinsics.checkNotNullParameter(r10, "$this$requestTypeExt");
            int r6 = r10.a;
            int r12 = MultiLinkServerMonitor.e;
            r1.f(r2, "linkmic/join_channel/", r4, r6, MultiLinkServerMonitor$monitorApiCallSuccess$2.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ r a;
        public final /* synthetic */ fy.f b;
        public final /* synthetic */ int c;

        public d(r r1, fy.f r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            Throwable r3 = (Throwable) r9;
            i r10 = this.a.g;
            if (r10 == null) goto L5;
            r10.h3(this.b, r3);
        L5:
            MultiLinkServerMonitor r0 = this.a.d;
            int r1 = this.c;
            i97.a r12 = i97.a.a;
            MultiLinkServerMonitor.e(r0, r1, "linkmic/join_channel/", r3, System.currentTimeMillis() - this.a.b);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ r a;
        public final /* synthetic */ fy.h b;

        public e(r r1, fy.h r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ExtraResponse<n0, Extra> r4 = (ExtraResponse) r3;
            i r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.k3(this.b, r4);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ r a;
        public final /* synthetic */ fy.h b;

        public f(r r1, fy.h r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            i r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.m2(this.b, r4);
            return;
        }
    }

    @Override // com.bytedance.android.live.revenuelink.connect.l
    public final void a(fy.h r10) {
        Intrinsics.checkNotNullParameter(r10, "leaveParams");
        i97.a r0 = i97.a.a;
        System.currentTimeMillis();
        IRoomBase r1 = this.f;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(IRoomKtKt.getId(r1));
    L6:
        long r3 = r10.a;
        int r4 = r10.b;
        String r5 = r10.c;
        int r8 = r10.f;
        e11.b r6 = e11.c.a(e11.b.a);
        if (r2 == null) goto L9;
        long r7 = r2.longValue();
    L10:
        Observable<ExtraResponse<n0, Extra>> r9 = ((e11.a) r6).a(r3, r4, r5, r7, r8);
        int r12 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r13 = r9.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r10), new f(this, r10));
        this.a.add(r13);
        return;
    L9:
        r7 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.connect.l
    public final void b(fy.d r10) {
        Intrinsics.checkNotNullParameter(r10, "finishParams");
        i97.a r0 = i97.a.a;
        this.c = System.currentTimeMillis();
        IRoomBase r1 = this.f;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(IRoomKtKt.getId(r1));
    L6:
        e11.b r3 = e11.c.a(e11.b.a);
        e11.a r4 = (e11.a) r3;
        Observable<ExtraResponse<Object, Extra>> r5 = r4.e(r10.a, r10.d, r10.b, r10.c, String.valueOf(r2));
        int r6 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r12 = r5.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r10), new b(this, r10));
        this.a.add(r12);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.connect.l
    public final void c(fy.f r10) {
        Intrinsics.checkNotNullParameter(r10, "joinChannelParams");
        long r2 = r10.a;
        int r4 = r10.c;
        int r0 = r10.b;
        int r6 = r10.d;
        i97.a r1 = i97.a.a;
        this.b = System.currentTimeMillis();
        Observable r3 = ((e11.a) e11.c.a(e11.b.a)).h(r2, r4, r0, r6);
        if (r3 == null) goto L12;
        int r5 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r7 = r3.subscribeOn(Schedulers.io());
        if (r7 == null) goto L13;
        Observable r8 = r7.observeOn(AndroidSchedulers.mainThread());
        if (r8 == null) goto L14;
        Disposable r12 = r8.subscribe(new c(this, r10, r0), new d(this, r10, r0));
        if (r12 == null) goto L15;
        this.a.add(r12);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public r(com.bytedance.android.live.revenuelink.withroom.a r2, IRoomBase r3, ConnectDataContext.d r4) {
        Intrinsics.checkNotNullParameter(r2, "storeService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = new CompositeDisposable();
        this.d = new MultiLinkServerMonitor(r2, r3);
    }
}
