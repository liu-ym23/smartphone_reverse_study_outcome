package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m0<T, R> implements Function {
    public final /* synthetic */ XplayMainService a;

    public m0(XplayMainService r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        IXplayMainService.State r3 = (IXplayMainService.State) r2;
        Intrinsics.checkNotNullParameter(r3, "curState");
        if (r3 != IXplayMainService.State.Starting) goto L6;
        return this.a.d.flatMap(i0.a).doOnNext(new j0(this));
    L6:
        if (r3 != IXplayMainService.State.StartingFailed) goto L9;
        return Observable.just(Unit.INSTANCE).doOnSubscribe(new k0(this));
    L9:
        if (r3.isAtLeast(IXplayMainService.State.Started) == false) goto L12;
        return Observable.just(Unit.INSTANCE).doOnSubscribe(new l0(this));
    L12:
        return Observable.empty();
    }
}
