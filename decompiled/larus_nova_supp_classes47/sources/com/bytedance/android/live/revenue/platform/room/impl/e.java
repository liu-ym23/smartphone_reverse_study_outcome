package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ f a;
    public final /* synthetic */ wlc.c b;

    public static final class a implements ttc.c {
        public final /* synthetic */ e a;
        public final /* synthetic */ wlc.b b;

        public a(e r1, wlc.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void cancel() {
            e r0 = this.a;
            r0.b.removeMessageListener(r0.a.b, this.b);
        }
    }

    public static final class b implements wlc.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ ObservableEmitter b;

        public b(e r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void Rk(IStreamMessage r3) {
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

    public static final class c implements wlc.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ ObservableEmitter b;

        public c(e r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void Rk(IStreamMessage r2) {
            if (this.a.a.a.isInstance(r2) == false) goto L9;
            ObservableEmitter r0 = this.b;
            if (r2 == null) goto L8;
            r0.onNext((yh6.c) r2);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public e(f r1, wlc.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        if (vh7.e.class.isAssignableFrom(this.a.a) == false) goto L5;
        wlc.b r0 = new b(this, r3);
    L6:
        r3.setCancellable(new a(this, r0));
        this.b.addMessageListener(MessageType.GROUP_COMPONENT_CONTAINER_MESSAGE.getIntTypeExt(), r0);
        return;
    L5:
        r0 = new c(this, r3);
        goto L6
    }
}
