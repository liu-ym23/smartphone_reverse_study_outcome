package ct1;

import android.content.Context;
import android.os.CountDownTimer;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements e {
    public f a;
    public long b;
    public CountDownTimerC0377b c;
    public int d;
    public final LiveNetworkBroadcastReceiver e;
    public boolean f;
    public final d g;
    public final c h;
    public final Context i;
    public final long j;
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.c k;

    public static final class a {
    }

    /* JADX INFO: renamed from: ct1.b$b, reason: collision with other inner class name */
    public static final class CountDownTimerC0377b extends CountDownTimer {
        public final /* synthetic */ b a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            b r0 = this.a;
            r0.d = 3;
            f r1 = r0.a;
            if (r1 == null) goto L6;
            r1.onFinish();
            return;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r4) {
            b r0 = this.a;
            long r5 = r4 / 1000;
            r0.b = r5;
            f r1 = r0.a;
            if (r1 == null) goto L6;
            r1.onTick(r5);
            return;
        }

        public CountDownTimerC0377b(b r3, long r4) {
            this.a = r3;
            super(r4, 1000);
        }
    }

    static {
    }

    public final Context getContext() {
        return this.i;
    }

    @Override // ct1.e
    public final long getRemainTime() {
        return this.b;
    }

    @Override // ct1.e
    public final int getState() {
        return this.d;
    }

    @Override // ct1.e
    public final long getTaskKey() {
        return this.j;
    }

    public final void a(long r4) {
        if (NetworkUtils.f(this.i) == true) goto L5;
        return;
    L5:
        if (this.f == false) goto L8;
        return;
    L8:
        if (r4 > 0) goto L10;
        return;
    L10:
        CountDownTimerC0377b r0 = new CountDownTimerC0377b(this, r4 * 1000);
        this.c = r0;
        r0.start();
        this.d = 1;
    }

    public final void b(bt1.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    public b(Context r3, com.bytedance.android.livesdk.coupon.expandcoupon.model.c r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        this.i = r3;
        this.j = 1;
        this.k = r4;
        this.b = r4.a();
        this.e = new LiveNetworkBroadcastReceiver();
        this.g = new d(this);
        this.h = new c(this);
    }
}
