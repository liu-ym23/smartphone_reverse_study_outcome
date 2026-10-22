package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.widget.u2;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ LiveComposerManagerB a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.k b;
    public final /* synthetic */ IFetchEffectListener c;

    public e(LiveComposerManagerB r1, com.bytedance.android.live.effect.api.k r2, u2.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r2) {
        Effect r3 = (Effect) r2;
        Intrinsics.checkNotNullParameter(r3, NewBroadcastMonitor.STAGE.EFFECT);
        return Observable.create(new d(this, r3));
    }
}
