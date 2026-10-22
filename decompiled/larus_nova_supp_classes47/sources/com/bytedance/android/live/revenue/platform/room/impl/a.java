package com.bytedance.android.live.revenue.platform.room.impl;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.room.impl.b a;
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.message.b b;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.room.impl.a$a, reason: collision with other inner class name */
    public static final class C0101a implements ttc.c {
        public final /* synthetic */ a a;
        public final /* synthetic */ vlc.l b;

        public C0101a(a r1, vlc.l r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void cancel() {
            a r0 = this.a;
            r0.b.removeMessageListener(r0.a.b, this.b);
        }
    }

    public static final class b implements vlc.l {
        public final /* synthetic */ a a;
        public final /* synthetic */ ObservableEmitter b;

        public b(a r1, ObservableEmitter r2) {
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

    public static final class c implements vlc.l {
        public final /* synthetic */ ObservableEmitter a;

        public c(ObservableEmitter r1) {
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

    public a(com.bytedance.android.live.revenue.platform.room.impl.b r1, com.bytedance.android.livesdk.revenue.message.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        if (vh7.e.class.isAssignableFrom(this.a.a) == false) goto L5;
        vlc.l r0 = new b(this, r4);
    L6:
        r4.setCancellable(new C0101a(this, r0));
        com.bytedance.android.live.revenue.platform.room.impl.b r5 = this.a;
        if (r5.c == false) goto L9;
        this.b.i(r5.b, r0, r5.d);
        return;
    L9:
        this.b.addMessageListener(r5.b, r0);
        return;
    L5:
        r0 = new c(r4);
        goto L6
    }
}
