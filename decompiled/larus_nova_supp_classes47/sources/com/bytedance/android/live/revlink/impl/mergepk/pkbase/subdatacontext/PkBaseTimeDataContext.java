package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001,B\u001f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004R$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR'\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0010j\b\u0012\u0004\u0012\u00020\f`\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseTimeDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "", "startPkTimeDown", "startPenalty", "clearIt", "onShowPK", "onShowPenal", "onFinish", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "_timeLeft", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "timeLeft", "Landroidx/lifecycle/LiveData;", "getTimeLeft", "()Landroidx/lifecycle/LiveData;", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "timeCountDown", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lkotlin/Function0;", "", "scene", "Lkotlin/jvm/functions/Function0;", "Lb21/d;", "getPkBaseMonitor", "()Lb21/d;", "pkBaseMonitor", "<init>", "(Lcom/bytedance/android/live/revlink/impl/global/c;Lkotlin/jvm/functions/Function0;)V", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkBaseTimeDataContext extends DataContext {
    public static final b Companion = null;
    public static final String TAG = "PkBaseTimeDataContext";
    private final MutableLiveData<Long> _timeLeft;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final Function0<Integer> scene;
    private Disposable timeCountDown;
    private final LiveData<Long> timeLeft;

    public static final class a implements Action {
        public final /* synthetic */ PkBaseTimeDataContext a;

        public a(PkBaseTimeDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            Disposable r0 = PkBaseTimeDataContext.access$getTimeCountDown$p(this.a);
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            jy0.b.a(PkBaseTimeDataContext.TAG, "onCleared");
            PkBaseTimeDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ int a;

        public c(int r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            long r0 = ((Number) r5).longValue();
            return Long.valueOf(((long) this.a) - r0);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PkBaseTimeDataContext a;

        public d(PkBaseTimeDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            long r0 = ((Number) r5).longValue();
            PkBaseTimeDataContext.access$get_timeLeft$p(this.a).setValue(Long.valueOf(r0));
            if (r0 > 0) goto L8;
            Disposable r6 = PkBaseTimeDataContext.access$getTimeCountDown$p(this.a);
            if (r6 == null) goto L9;
            r6.dispose();
            return;
        L9:
            return;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ long a;

        public e(long r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            long r0 = ((Number) r5).longValue();
            return Long.valueOf(this.a - r0);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkBaseTimeDataContext a;

        public f(PkBaseTimeDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            long r0 = ((Number) r5).longValue();
            if (r0 < 0) goto L5;
            PkBaseTimeDataContext.access$get_timeLeft$p(this.a).setValue(Long.valueOf(r0));
        L5:
            if (r0 != 0) goto L10;
            Disposable r6 = PkBaseTimeDataContext.access$getTimeCountDown$p(this.a);
            if (r6 == null) goto L11;
            r6.dispose();
            return;
        L11:
            return;
        }
    }

    static {
        Companion = new b();
    }

    private final b21.d getPkBaseMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkBaseMonitor();
    }

    public final void onFinish() {
        this._timeLeft.setValue(0L);
        Disposable r0 = this.timeCountDown;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void clearIt() {
        onCleared();
    }

    public final LiveData<Long> getTimeLeft() {
        return this.timeLeft;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkBaseTimeDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Disposable access$getTimeCountDown$p(PkBaseTimeDataContext r0) {
        return r0.timeCountDown;
    }

    public static final /* synthetic */ MutableLiveData access$get_timeLeft$p(PkBaseTimeDataContext r0) {
        return r0._timeLeft;
    }

    private final void startPenalty(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r19) {
        long r2 = r19.a();
        if (r2 > 0) goto L7;
        b21.d r7 = getPkBaseMonitor();
        if (r7 == null) goto L7;
        int r6 = ((Number) this.scene.invoke()).intValue();
        Intrinsics.checkNotNullParameter(r19, "pkInfo");
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("penalty_time_millis", Long.valueOf(r2));
        b21.d.a(r19, r9);
        b21.d.e(r7, "penal_time_error", r9, null, Integer.valueOf(r6), 12);
    L7:
        long r1 = RangesKt.coerceAtLeast(r2, 0);
        long r8 = WebcastRedirectException.UNKNOWN;
        int r10 = (int) (r1 / r8);
        int r12 = (int) (r1 % r8);
        Disposable r3 = this.timeCountDown;
        if (r3 == null) goto L10;
        r3.dispose();
    L10:
        if (r10 <= 0) goto L12;
        this._timeLeft.setValue(Long.valueOf(r10));
    L12:
        jy0.b.d(TAG, "penal start count down " + r1);
        l r4 = l.a;
        int r5 = p.a;
        Scheduler r13 = Schedulers.computation();
        TimeUnit r15 = TimeUnit.MILLISECONDS;
        Disposable r14 = Observable.interval(0, r8, r15, r13).take(r10 + 1).delay(r12, r15, Schedulers.computation(), false).map(new c(r10)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
        com.bytedance.revenue.platform.api.core.rx.f.a(r14, this.cd);
        this.timeCountDown = r14;
    }

    private final void startPkTimeDown(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r22) {
        IBaseBattleSetting r2 = r22.a;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.getDuration() > 0) goto L8;
        return;
    L8:
        if (r2.getStartTimeMs() <= 0) goto L23;
        long r3 = r2.getStartTimeMs() - com.bytedance.live.kmp.util.e.b();
        long r7 = r2.getDuration();
        long r12 = WebcastRedirectException.UNKNOWN;
        long r4 = r3 + (r7 * r12);
        long r8 = r4 / r12;
        int r5 = ((int) r4) % WebcastRedirectException.UNKNOWN;
        jy0.b.d(TAG, "pk start count down " + r4);
        if (r4 > 0) goto L16;
        this._timeLeft.setValue(0L);
        b21.d r6 = getPkBaseMonitor();
        if (r6 == null) goto L21;
        int r9 = ((Number) this.scene.invoke()).intValue();
        Intrinsics.checkNotNullParameter(r22, "pkInfo");
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("pk_time_millis", Long.valueOf(r4));
        b21.d.a(r22, r10);
        b21.d.e(r6, "pk_time_error", r10, null, Integer.valueOf(r9), 12);
        return;
    L21:
        return;
    L16:
        this._timeLeft.setValue(Long.valueOf(r8));
        Disposable r1 = this.timeCountDown;
        if (r1 == null) goto L19;
        r1.dispose();
    L19:
        l r13 = l.a;
        int r14 = p.a;
        Scheduler r15 = Schedulers.computation();
        TimeUnit r18 = TimeUnit.MILLISECONDS;
        Disposable r16 = Observable.interval(0, r12, r18, r15).take(1 + r8).delay(r5, r18, Schedulers.computation(), false).map(new e(r8)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this));
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, this.cd);
        this.timeCountDown = r16;
        return;
    }

    public final void onShowPK(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pkInfo");
        Disposable r0 = this.timeCountDown;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        startPkTimeDown(r2);
    }

    public final void onShowPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pkInfo");
        Disposable r0 = this.timeCountDown;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        startPenalty(r2);
    }

    public PkBaseTimeDataContext(com.bytedance.android.live.revlink.impl.global.c r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.linkFakeGlobalService = r2;
        this.scene = r3;
        MutableLiveData<Long> r4 = new MutableLiveData();
        this._timeLeft = r4;
        this.timeLeft = r4;
        CompositeDisposable r5 = new CompositeDisposable();
        this.cd = r5;
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r5);
    }

    public static final /* synthetic */ void access$setTimeCountDown$p(PkBaseTimeDataContext r0, Disposable r1) {
        r0.timeCountDown = r1;
    }
}
