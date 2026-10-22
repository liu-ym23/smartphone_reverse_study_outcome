package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y extends DynamicFactor<Integer> {
    public static final Long d = null;
    public Disposable b;
    public b c;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ y a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (r2.what != 1009) goto L6;
            this.a.update(0);
            return;
        }

        public b(y r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ y a;

        public c(y r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((com.bytedance.android.livesdk.event.z) r4).b == false) goto L11;
            this.a.update(1);
            b r5 = this.a.c;
            if (r5 == null) goto L7;
            r5.removeMessages(1009);
        L7:
            b r6 = this.a.c;
            if (r6 == null) goto L12;
            r6.sendEmptyMessageDelayed(1009, y.d.longValue());
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_user_comment";
    }

    static {
        d = (Long) r52.v.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.c = new b(this, Looper.getMainLooper());
        this.b = xs2.b.a().b(com.bytedance.android.livesdk.event.z.class).subscribe(new c(this));
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        b r1 = this.c;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
    L8:
        this.c = null;
    }

    public y() {
    }
}
