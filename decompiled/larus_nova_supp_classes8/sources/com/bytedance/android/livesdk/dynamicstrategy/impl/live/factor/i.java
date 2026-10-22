package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import r52.n4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends DynamicFactor<Integer> {
    public static final Long d = null;
    public Disposable b;
    public b c;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ i a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (r2.what != 1010) goto L6;
            this.a.update(0);
            return;
        }

        public b(i r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            o42.e r9 = (o42.e) r8;
            this.a.update(1);
            b r10 = this.a.c;
            if (r10 == null) goto L5;
            r10.removeMessages(1010);
        L5:
            UtilityKotlinExtentionsKt.s(0, false, true, new BatchMsgShowAction$onBind$2$1(this), 3);
        }
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "batch_msg_show";
    }

    static {
        d = (Long) n4.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.c = new b(this, Looper.getMainLooper());
        this.b = xs2.b.a().b(o42.e.class).subscribe(new c(this));
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

    public i() {
    }
}
