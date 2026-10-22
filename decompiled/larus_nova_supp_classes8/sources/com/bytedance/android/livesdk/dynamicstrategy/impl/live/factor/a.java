package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends DynamicFactor<Integer> {
    public static final Long d = null;
    public Disposable b;
    public b c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.a$a, reason: collision with other inner class name */
    public static final class C0306a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (r2.what != 1010) goto L6;
            this.a.update(0);
            return;
        }

        public b(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            o42.a r5 = (o42.a) r4;
            this.a.update(1);
            b r6 = this.a.c;
            if (r6 == null) goto L5;
            r6.removeMessages(1010);
        L5:
            b r7 = this.a.c;
            if (r7 == null) goto L9;
            r7.sendEmptyMessageDelayed(1010, a.d.longValue());
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "ai_reply_show";
    }

    static {
        d = (Long) r52.b.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.c = new b(this, Looper.getMainLooper());
        this.b = xs2.b.a().b(o42.a.class).subscribe(new c(this));
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

    public a() {
    }
}
