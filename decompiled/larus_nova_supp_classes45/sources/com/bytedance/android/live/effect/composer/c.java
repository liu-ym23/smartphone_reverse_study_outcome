package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdk.widget.u2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements ObservableOnSubscribe {
    public final /* synthetic */ com.bytedance.android.live.effect.api.k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IFetchEffectListener c;

    public static final class a implements IFetchEffectListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ ObservableEmitter b;

        public final void onStart(Effect r2) {
            IFetchEffectListener r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.onStart(r2);
            return;
        }

        public final void onSuccess(Object r4) {
            Effect r5 = (Effect) r4;
            if (r5 != null) goto L7;
            Exception r0 = new Exception("effect is null");
            this.b.onError(r0);
            IFetchEffectListener r1 = this.a.c;
            if (r1 == null) goto L9;
            r1.onFail(r5, new ExceptionResult(r0));
            return;
        L9:
            return;
        L7:
            this.b.onNext(r5);
            this.b.onComplete();
        }

        public a(c r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFail(Effect r3, ExceptionResult r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            this.b.onError(r4.getException());
            IFetchEffectListener r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.onFail(r3, r4);
            return;
        }
    }

    public c(com.bytedance.android.live.effect.api.k r1, String r2, u2.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<Effect> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        this.a.d(this.b, new a(this, r4));
    }
}
