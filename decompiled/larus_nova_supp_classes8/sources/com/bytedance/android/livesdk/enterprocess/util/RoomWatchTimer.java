package com.bytedance.android.livesdk.enterprocess.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.platform.IHostAction;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/enterprocess/util/RoomWatchTimer;", "Landroidx/lifecycle/LifecycleObserver;", "", "onTimingStart", "onTimingStop", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RoomWatchTimer implements LifecycleObserver {
    public int a;
    public Disposable b;
    public boolean c;
    public final int d;
    public final int e;
    public final String f;

    public static final class a implements Action {
        public final /* synthetic */ RoomWatchTimer a;

        public a(RoomWatchTimer r1) {
            this.a = r1;
        }

        public final void run() {
            RoomWatchTimer r0 = this.a;
            if (r0.c == true) goto L6;
            r0.getClass();
            IHostAction r1 = k.n(IHostAction.class);
            int r2 = r0.d;
            int r3 = r0.e;
            r1.reportTask(r2, r3, r0.f, r3);
            this.a.c = true;
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RoomWatchTimer a;

        public b(RoomWatchTimer r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Long r11 = (Long) r10;
            RoomWatchTimer r0 = this.a;
            Intrinsics.checkNotNull(r11);
            long r1 = r11.longValue();
            r0.a = (int) r1;
            if (r1 == 0) goto L8;
            long r5 = r0.d;
            if ((r1 % r5) != 0) goto L9;
            k.n(IHostAction.class).reportTask(r0.d, r0.e, r0.f, (int) (r1 / r5));
            return;
        L9:
            return;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onTimingStart() {
        int r0 = this.a;
        this.b = du2.a.e(r0, (this.e * this.d) - r0, 0, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).doOnComplete(new a(this)).subscribe(new b(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onTimingStop() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    public RoomWatchTimer(int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "token");
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
