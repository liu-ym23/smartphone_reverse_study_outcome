package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.u;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements ObservableOnSubscribe {
    public final /* synthetic */ e a;
    public final /* synthetic */ Effect b;

    public static final class a implements IFetchEffectListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ ObservableEmitter b;

        public final void onStart(Effect r1) {
        }

        public final void onSuccess(Object r4) {
            Effect r5 = (Effect) r4;
            if (r5 != null) goto L7;
            Exception r0 = new Exception("effect is null");
            this.b.onError(r0);
            IFetchEffectListener r1 = this.a.a.c;
            if (r1 == null) goto L9;
            r1.onFail(r5, new ExceptionResult(r0));
            return;
        L9:
            return;
        L7:
            ObservableEmitter r6 = this.b;
            Effect r2 = this.a.b;
            r6.onNext(TuplesKt.to(r2, com.bytedance.android.live.effect.sticker.d.b(r2)));
            this.b.onComplete();
        }

        public a(d r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFail(Effect r3, ExceptionResult r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            this.b.onError(r4.getException());
            IFetchEffectListener r0 = this.a.a.c;
            if (r0 == null) goto L6;
            r0.onFail(r3, r4);
            return;
        }
    }

    public d(e r1, Effect r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Pair<Effect, Sticker>> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        if (this.a.b.e(this.b) == false) goto L5;
        Effect r0 = this.b;
        r4.onNext(TuplesKt.to(r0, com.bytedance.android.live.effect.sticker.d.b(r0)));
        r4.onComplete();
        return;
    L5:
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r1 = u.a;
        u.a(this.a.a.getType()).getEffectManager().fetchEffect(this.b, new a(this, r4));
    }
}
