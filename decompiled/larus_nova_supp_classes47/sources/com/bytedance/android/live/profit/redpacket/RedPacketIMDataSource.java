package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.message.model.qa;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RedPacketIMDataSource implements Disposable {
    public final PublishSubject<n0> a;
    public final PublishSubject b;
    public final PublishSubject<qa> c;
    public final PublishSubject d;
    public final PublishSubject<String> e;
    public final PublishSubject f;
    public final PublishSubject<Unit> g;
    public final PublishSubject h;
    public final PropertyOwner<Pair<String, List<String>>> i;
    public final PropertyOwner<Pair<String, List<String>>> j;
    public final PropertyOwner<l1> k;
    public final PropertyOwner<l1> l;
    public final Function1<yh6.c, Unit> m;
    public final CompositeDisposable n;

    public static final class a implements Action {
        public final /* synthetic */ RedPacketIMDataSource a;

        public a(RedPacketIMDataSource r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.a.onComplete();
            this.a.e.onComplete();
            this.a.g.onComplete();
            this.a.i.onComplete();
            this.a.k.onComplete();
            this.a.c.onComplete();
        }
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final void dispose() {
        this.n.dispose();
    }

    public final boolean isDisposed() {
        return this.n.isDisposed();
    }

    public RedPacketIMDataSource(yz0.l r6, CompositeDisposable r7) {
        Intrinsics.checkNotNullParameter(r6, "messageService");
        Intrinsics.checkNotNullParameter(r7, "cd");
        this.n = r7;
        PublishSubject<n0> r0 = PublishSubject.create();
        this.a = r0;
        this.b = r0;
        PublishSubject<qa> r1 = PublishSubject.create();
        this.c = r1;
        this.d = r1;
        PublishSubject<String> r2 = PublishSubject.create();
        this.e = r2;
        this.f = r2;
        PublishSubject<Unit> r3 = PublishSubject.create();
        this.g = r3;
        this.h = r3;
        PropertyOwner<Pair<String, List<String>>> r4 = new PropertyOwner(new Pair("", CollectionsKt.emptyList()));
        this.i = r4;
        this.j = r4;
        PropertyOwner<l1> r5 = new PropertyOwner(new l1(null, null, null));
        this.k = r5;
        this.l = r5;
        Function1<yh6.c, Unit> r8 = new RedPacketIMDataSource$messageListener$1(this);
        this.m = r8;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r6, com.bytedance.android.live.revenue.common.message.b.r, false, 6).subscribe(new b(r8)), r7);
        RxUtilKt.c(yz0.h.a.a(r6, com.bytedance.android.live.revenue.common.message.b.s, false, 6).subscribe(new b(r8)), r7);
        RxUtilKt.c(yz0.h.a.a(r6, com.bytedance.android.live.revenue.common.message.b.t, false, 6).subscribe(new b(r8)), r7);
        RxUtilKt.c(yz0.h.a.a(r6, com.bytedance.android.live.revenue.common.message.b.u, false, 6).subscribe(new b(r8)), r7);
        RxUtilKt.c(Disposables.fromAction(new a(this)), r7);
    }
}
