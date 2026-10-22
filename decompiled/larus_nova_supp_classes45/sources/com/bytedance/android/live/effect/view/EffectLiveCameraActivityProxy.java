package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.gesture.EffectGestureDetectorV2;
import com.bytedance.android.live.effect.t;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/view/EffectLiveCameraActivityProxy;", "Lcom/bytedance/android/live/effect/view/LiveEffectActivityProxy;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectLiveCameraActivityProxy extends LiveEffectActivityProxy {
    public Disposable a;
    public t b;

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onCreate() {
        super.onCreate();
        this.a = xs2.b.a().b(com.bytedance.android.live.effect.gesture.a.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        LiveEffectContextFactoryDelegate$Type r1 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        new EffectGestureDetectorV2(null, r1);
        this.b = new t(r1);
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.isDisposed();
    L5:
        Disposable r1 = this.a;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }
}
