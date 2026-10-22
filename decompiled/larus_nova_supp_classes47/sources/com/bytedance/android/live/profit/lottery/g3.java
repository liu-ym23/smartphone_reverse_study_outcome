package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g3 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final PropertyOwner<a> b;
    public final PropertyOwner c;
    public final PropertyOwner<sh6.b<y2>> d;
    public final PropertyOwner e;
    public final PropertyOwner<sh6.b<h1>> f;
    public final PropertyOwner g;
    public final LotteryContext h;
    public final LotteryRepository i;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.lottery.g3$a$a, reason: collision with other inner class name */
        public static final class C0033a extends a {
            public static final C0033a a = null;

            static {
                a = new C0033a();
            }

            public C0033a() {
            }
        }

        public static final class b extends a {
            public final t a;
            public final boolean b;
            public final boolean c;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof b) == false) goto L12;
                b r4 = (b) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (this.b == r4.b) goto L10;
                return false;
            L10:
                if (this.c == r4.c) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public final int hashCode() {
                t r0 = this.a;
                if (r0 == null) goto L5;
                int r1 = r0.hashCode();
            L6:
                int r2 = r1 * 31;
                boolean r3 = this.b;
                ?? r4 = 1;
                ?? r5 = r3;
                if (r3 == false) goto L9;
                r5 = 1;
            L9:
                int r6 = (r2 + r5) * 31;
                boolean r7 = this.c;
                if (r7 == true) goto L14;
                r4 = r7;
            L14:
                return r6 + r4;
            L5:
                r1 = 0;
                goto L6
            }

            public final String toString() {
                return "Visible(info=" + this.a + ", isPreDrawState=" + this.b + ", isRefreshState=" + this.c + ")";
            }

            public b(t r2, boolean r3) {
                Intrinsics.checkNotNullParameter(r2, "info");
                this.a = r2;
                this.b = false;
                this.c = r3;
            }
        }

        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            k3 r3 = (k3) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.c;
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r2) {
            LotteryState r3 = (LotteryState) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (l.b(r3) == true) goto L8;
            Intrinsics.checkNotNullParameter(r3, "$this$isRefreshState");
            if ((r3 instanceof LotteryState.d) == true) goto L8;
            return false;
        L8:
            return true;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g3 a;

        public d(g3 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            LotteryState r5 = (LotteryState) r4;
            if ((r5 instanceof LotteryState.b) == false) goto L12;
            ALogger.i("LOTTERY_VIEW_MODE", "lotteryRepository.current LotteryState.Finished");
            p0 r0 = ((LotteryState.b) r5).b;
            if (r0.c == false) goto L7;
        L10:
            ALogger.i("LOTTERY_VIEW_MODE", "lotteryRepository.current LotteryState.Finished post");
            this.a.h.getOnFinish().post(r5);
            return;
        L7:
            if (r0.a == true) goto L10;
            this.a.h.getOnHidePanel().post(Unit.INSTANCE);
            return;
        L12:
            if ((r5 instanceof LotteryState.e) == false) goto L15;
            ALogger.i("LOTTERY_VIEW_MODE", "lotteryRepository.current LotteryState.Rejected post");
            this.a.h.getOnReject().post(r5);
            return;
        L15:
            if ((r5 instanceof LotteryState.d) == false) goto L21;
            ALogger.i("LOTTERY_VIEW_MODE", "lotteryRepository.current LotteryState.Refresh post");
            this.a.h.getOnRefresh().post(r5);
            return;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ g3 a;

        public e(g3 r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            sh6.d r4 = (sh6.b) r3;
            Intrinsics.checkNotNullParameter(r4, "opt");
            if ((r4 instanceof sh6.d) == false) goto L6;
            Lottery r5 = (Lottery) r4.a;
            return r5.b.map(i3.a).startWith(r5.getState()).map(new h3(this));
        L6:
            return Observable.just(a.C0033a.a);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ g3 a;

        public f(g3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            PropertyOwner<a> r0 = this.a.b;
            r0.a((a) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ g3 a;

        public g(g3 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.i("LOTTERY_VIEW_MODE", "currentLottery无值 subscribe " + ((sh6.b) this.a.i.d.a));
            Lottery r4 = (Lottery) sh6.c.b((sh6.b) r3);
            if (r4 == null) goto L6;
            this.a.a(r4);
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ g3 a;

        public h(g3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.d.a(sh6.c.a((y2) r2));
        }
    }

    public final void onStart() {
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.i.d).switchMap(new e(this)).subscribe(new f(this)), this.a);
        ALogger.i("LOTTERY_VIEW_MODE", "lotteryRepository.currentLottery1 = " + ((sh6.b) this.i.d.a));
        if (((Boolean) w2.k.getValue(null, w2.a[9])).booleanValue() == true) goto L5;
    L9:
        ALogger.i("LOTTERY_VIEW_MODE", "lotteryRepository.currentLottery.value == None " + ((sh6.b) this.i.d.a));
        RxUtilKt.c(this.i.d.subscribe(new g(this)), this.a);
    L10:
        RxUtilKt.c(this.i.j.subscribe(new h(this)), this.a);
        return;
    L5:
        if ((!Intrinsics.areEqual((sh6.b) this.i.d.a, sh6.a.a)) == false) goto L9;
        ALogger.i("LOTTERY_VIEW_MODE", "lotteryRepository.currentLottery.value != None " + ((sh6.b) this.i.d.a));
        Lottery r0 = (Lottery) sh6.c.b((sh6.b) this.i.d.a);
        if (r0 == null) goto L10;
        ALogger.i("LOTTERY_VIEW_MODE", "currentLottery有值 subscribe " + ((sh6.b) this.i.d.a));
        a(r0);
        goto L10
    }

    public final void onStop() {
        this.a.dispose();
    }

    public final void a(Lottery r3) {
        ALogger.i("LOTTERY_VIEW_MODE", "observeLotteryStateChange = " + ((sh6.b) this.i.d.a));
        RxUtilKt.c(r3.b.map(b.a).startWith(r3.getState()).filter(c.a).take(1).subscribe(new d(this)), this.a);
    }

    public g3(LotteryContext r2, LotteryRepository r3) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        Intrinsics.checkNotNullParameter(r3, "lotteryRepository");
        this.h = r2;
        this.i = r3;
        this.a = new CompositeDisposable();
        PropertyOwner<a> r4 = new PropertyOwner(a.C0033a.a);
        this.b = r4;
        this.c = r4;
        sh6.a r5 = sh6.a.a;
        PropertyOwner<sh6.b<y2>> r6 = new PropertyOwner(r5);
        this.d = r6;
        this.e = r6;
        PropertyOwner<sh6.b<h1>> r7 = new PropertyOwner(r5);
        this.f = r7;
        this.g = r7;
    }
}
