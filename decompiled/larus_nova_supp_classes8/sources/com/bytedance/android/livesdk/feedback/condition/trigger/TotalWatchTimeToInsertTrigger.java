package com.bytedance.android.livesdk.feedback.condition.trigger;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.feedback.room.RoomFeedbackContext;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class TotalWatchTimeToInsertTrigger extends fx1.c<ex1.a> {
    public final TriggerId d;
    public long e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final CompositeDisposable h;
    public final long i;
    public final boolean j;
    public final Long k;
    public final Long l;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ TotalWatchTimeToInsertTrigger a;

        public a(TotalWatchTimeToInsertTrigger r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            long r0 = this.a.i;
            if (r6 != null) goto L6;
            return;
        L6:
            if (r0 != r6.longValue()) goto L9;
            TotalWatchTimeToInsertTrigger r7 = this.a;
            r7.d("进入后台，停止看播计时任务", new Pair[]{TuplesKt.to("roomId", Long.valueOf(r7.i))});
            this.a.b.clear();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TotalWatchTimeToInsertTrigger a;

        public b(TotalWatchTimeToInsertTrigger r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            TotalWatchTimeToInsertTrigger r0 = this.a;
            TotalWatchTimeToInsertTrigger.g(r0, "TotalWatchTimeToInsertTrigger onRoomBackgroundEvent error.", r6, new Pair[]{TuplesKt.to("roomId", Long.valueOf(r0.i))});
            ALogger.e(this.a.a, "TotalWatchTimeToInsertTrigger onRoomBackgroundEvent error.", r6);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TotalWatchTimeToInsertTrigger a;

        public c(TotalWatchTimeToInsertTrigger r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            long r0 = this.a.i;
            if (r6 != null) goto L6;
            return;
        L6:
            if (r0 != r6.longValue()) goto L9;
            TotalWatchTimeToInsertTrigger r7 = this.a;
            r7.d("进入前台，开始看播计时任务", new Pair[]{TuplesKt.to("roomId", Long.valueOf(r7.i))});
            this.a.a();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ TotalWatchTimeToInsertTrigger a;

        public d(TotalWatchTimeToInsertTrigger r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            TotalWatchTimeToInsertTrigger r0 = this.a;
            TotalWatchTimeToInsertTrigger.g(r0, "TotalWatchTimeToInsertTrigger onRoomForegroundEvent error.", r6, new Pair[]{TuplesKt.to("roomId", Long.valueOf(r0.i))});
            ALogger.e(this.a.a, "TotalWatchTimeToInsertTrigger onRoomForegroundEvent error.", r6);
        }
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        Long r0 = this.k;
        Boolean r1 = null;
        if (r0 != null) goto L8;
        Long r2 = this.l;
        if (r2 == null) goto L7;
        r2.longValue();
        r0 = 0L;
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 == null) goto L47;
        final long r6 = r0.longValue();
        Long r3 = this.l;
        if (r3 == null) goto L12;
        long r4 = r3.longValue();
    L14:
        if (r4 <= 0) goto L19;
        Long r5 = this.l;
        if (r5 == null) goto L19;
        long r7 = r5.longValue();
    L20:
        final long r8 = r7;
        if (r6 < r8) goto L23;
        return;
    L23:
        if (r6 >= 0) goto L26;
        return;
    L26:
        if (r8 > this.e) goto L29;
        h(false);
        return;
    L29:
        d("TotalWatchTimeToInsertTrigger：start task.", new Pair[]{TuplesKt.to("insert time", Long.valueOf(r6)), TuplesKt.to("remove time", Long.valueOf(r8)), TuplesKt.to("curWatchTime", Long.valueOf(this.e))});
        ALogger.d(this.a, "TotalWatchTimeToInsertTrigger：start task.insert time:" + r6 + ",remove time:" + r8 + ",cur room watch time:" + this.e);
        boolean r9 = this.j;
        Function0<Unit> r10 = new TotalWatchTimeToInsertTrigger$startObserve$1(this, r6, r8);
        Intrinsics.checkNotNullParameter(r10, "block");
        ILivePlayerClient r11 = LivePlatformPlayerManager.f();
        if (r11 == null) goto L34;
        IRoomEventHub r12 = r11.getEventHub();
        if (r12 == null) goto L34;
        MutableLiveData r13 = r12.getFirstFrame();
    L35:
        if (r13 == null) goto L38;
        r1 = (Boolean) r13.getValue();
    L38:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L45;
        if (r9 == true) goto L45;
        d("首帧未播放，监听首帧", new Pair[0]);
        fx1.b r14 = new fx1.b(this, r10);
        if (r13 == null) goto L44;
        r13.observeForever(r14);
    L44:
        this.b.add(Disposables.fromAction(new fx1.a(r13, r14)));
        return;
    L45:
        d("首帧已播放，开始计时", new Pair[0]);
        r10.invoke();
        return;
    L34:
        r13 = null;
    L19:
        r7 = Long.MAX_VALUE;
        goto L20
    L12:
        r4 = -1;
        goto L14
    }

    @Override // fx1.c, fx1.e
    public final void reset() {
        super.reset();
        this.h.clear();
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }

    public final void h(boolean r3) {
        if (r3 == false) goto L8;
        if (this.f.getAndSet(true) == true) goto L11;
        d("on action：看播时长条件达成，插入问卷", new Pair[0]);
        e(new ex1.a(1));
        ALogger.d(this.a, "TotalWatchTimeToInsertTrigger：insert");
        return;
    L11:
        return;
    L8:
        if (this.g.getAndSet(true) == true) goto L13;
        d("on action：看播时长条件达成，移除问卷", new Pair[0]);
        e(new ex1.a(2));
        ALogger.d(this.a, "TotalWatchTimeToInsertTrigger：remove");
        return;
    }

    public TotalWatchTimeToInsertTrigger(long r1, boolean r3, Long r4, Long r5) {
        this.i = r1;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.d = TriggerId.TOTAL_WATCH_TIME_SECTION;
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        CompositeDisposable r2 = new CompositeDisposable();
        this.h = r2;
        RoomFeedbackContext.Companion.getClass();
        RoomFeedbackContext r6 = RoomFeedbackContext.a.a();
        if (r6 == null) goto L6;
        r2.add(r6.getOnRoomBackgroundEvent().onEvent().subscribe(new a(this), new b(this)));
        r2.add(r6.getOnRoomForegroundEvent().onEvent().subscribe(new c(this), new d(this)));
        return;
    }

    public static final void g(TotalWatchTimeToInsertTrigger r2, String r3, Throwable r4, Pair... r5) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        Intrinsics.checkNotNullParameter(r5, "args");
        int r6 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r7 = new FeedbackMonitor.Monitor();
        String r8 = r2.d.name();
        Intrinsics.checkNotNullParameter(r8, "page");
        r7.a = r8;
        r7.c(r3);
        int r9 = r5.length;
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L8;
        Pair r0 = r5[r10];
        Object r1 = r0.getSecond();
        if (r1 == null) goto L7;
        r7.a((String) r0.getFirst(), r1);
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        r7.d();
    }
}
