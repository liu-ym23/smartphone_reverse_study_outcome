package ok0;

import com.bytedance.bmmt.BuildConfig;
import com.bytedance.live.kmp.util.e;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends lb6.b implements ub6.a {
    public static final /* synthetic */ int f = 0;
    public long b;
    public long c;
    public final Set<ub6.a.a> d;
    public Disposable e;

    /* JADX INFO: renamed from: ok0.a$a, reason: collision with other inner class name */
    public static final class C0249a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;

        public b(a r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            long r0 = this.b - ((Long) r6).longValue();
            int r7 = a.f;
            jy0.b.a("GuestLinkCountDownManager", "onStartTimer onNext: " + r0);
            Set<ub6.a.a> r8 = this.a.d;
            if (r8 == null) goto L8;
            Iterator r9 = ((HashSet) r8).iterator();
        L6:
            if (r9.hasNext() == false) goto L10;
            ((ub6.a.a) r9.next()).e(this.a.b, r0);
            goto L6
        L10:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r0 = a.f;
            jy0.b.b("GuestLinkCountDownManager", "onStartTimer onError", (Throwable) r3);
            Set<ub6.a.a> r4 = this.a.d;
            if (r4 == null) goto L8;
            Iterator r5 = ((HashSet) r4).iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            ((ub6.a.a) r5.next()).n();
        L8:
            this.a.release();
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void run() {
            int r0 = a.f;
            jy0.b.d("GuestLinkCountDownManager", "onStartTimer onComplete");
            Set<ub6.a.a> r1 = this.a.d;
            if (r1 == null) goto L8;
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            ((ub6.a.a) r2.next()).n();
        L8:
            this.a.release();
        }
    }

    static {
    }

    public final void release() {
        jy0.b.d("GuestLinkCountDownManager", BuildConfig.BUILD_TYPE);
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.e = null;
        ((HashSet) this.d).clear();
    }

    public a() {
        this.d = new HashSet();
    }

    public final void detach() {
        super.detach();
        release();
    }

    public final long getCallDuration() {
        return this.b;
    }

    public final long getStartTime() {
        return this.c;
    }

    public final void F(long r8) {
        l r0 = l.a;
        int r1 = p.a;
        this.e = Observable.interval(0, 1000, TimeUnit.MILLISECONDS, Schedulers.io()).take(r8).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r8), new c(this), new d(this));
    }

    public final void o(ub6.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "countDownListener");
        ((HashSet) this.d).add(r2);
    }

    public final void setCallDuration(long r1) {
        this.b = r1;
    }

    public final void setStartTime(long r1) {
        this.c = r1;
    }

    public final void E(long r7, long r9) {
        release();
        long r0 = (e.b() - r9) / ((long) 1000);
        long r2 = r7 - r0;
        jy0.b.d("GuestLinkCountDownManager", "startTimerForAudience, callDuration: " + r7 + ", startTime: " + r9 + ", currentTime: " + e.b() + ", pastTimeInSeconds: " + r0 + ", countDownDuration: " + r2);
        if (r2 > 0) goto L6;
        jy0.b.d("GuestLinkCountDownManager", "startTimerForAudience return, cause: countDownDuration <= 0");
        return;
    L6:
        F(r2);
    }

    public final void y(long r3, long r5) {
        release();
        jy0.b.d("GuestLinkCountDownManager", "startTimerForLinker, callDuration: " + r3 + ", startTime: " + r5 + ", currentTime: " + e.b());
        if (r3 > 0) goto L6;
        jy0.b.d("GuestLinkCountDownManager", "startTimerForLinker return, cause: countDownDuration <= 0");
        return;
    L6:
        F(r3);
    }
}
