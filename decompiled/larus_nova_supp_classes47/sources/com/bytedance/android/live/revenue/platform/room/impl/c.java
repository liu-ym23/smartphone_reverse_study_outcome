package com.bytedance.android.live.revenue.platform.room.impl;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements ObservableOnSubscribe {
    public final /* synthetic */ d a;
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.message.c b;

    public static final class a implements ttc.c {
        public final /* synthetic */ c a;
        public final /* synthetic */ vlc.l b;

        public a(c r1, vlc.l r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void cancel() {
            c r0 = this.a;
            r0.b.K0(r0.a.b, this.b);
        }
    }

    public static final class b implements vlc.l {
        public final /* synthetic */ c a;
        public final /* synthetic */ ObservableEmitter b;

        public b(c r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onMessage(tlc.d r3) {
            ObservableEmitter r0 = this.b;
            if (r3 == null) goto L11;
            yh6.c r4 = com.bytedance.android.live.base.model.m.a((vh7.c) r3, this.a.a.a);
            if (r4 == null) goto L9;
            r0.onNext(r4);
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.room.impl.c$c, reason: collision with other inner class name */
    public static final class C0102c implements vlc.l {
        public final /* synthetic */ ObservableEmitter a;

        public C0102c(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            ObservableEmitter r0 = this.a;
            if (r2 == null) goto L7;
            r0.onNext((yh6.c) r2);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public c(d r1, com.bytedance.android.livesdk.revenue.message.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        if (vh7.e.class.isAssignableFrom(this.a.a) == false) goto L5;
        vlc.l r0 = new b(this, r3);
    L6:
        r3.setCancellable(new a(this, r0));
        this.b.L0(this.a.b, r0);
        return;
    L5:
        r0 = new C0102c(r3);
        goto L6
    }
}
