package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0 implements CompletableOnSubscribe {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ dv0.f b;

    public static final class a implements com.bytedance.android.livesdk.revenue.service.broadcast.a.a {
        public final /* synthetic */ CompletableEmitter a;

        public final void onSuccess() {
            jy0.b.d("ScoreboardInvitationHandler", "loadGame succeeded");
            this.a.onComplete();
        }

        public a(CompletableEmitter r1) {
            this.a = r1;
        }

        public final void onFailure(Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "throwable");
            jy0.b.c("ScoreboardInvitationHandler", "loadGame failed: " + r5, null, 4);
            this.a.tryOnError(r5);
        }
    }

    public s0(r0 r1, dv0.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(CompletableEmitter r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        r0 r0 = this.a;
        r0.d.v4(r0.b.getContext(), this.b.getMiniAppId(), new a(r5));
    }
}
