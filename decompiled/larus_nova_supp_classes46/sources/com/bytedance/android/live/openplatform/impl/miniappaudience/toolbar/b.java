package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import com.bytedance.android.livehostapi.TTLiveSDK;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;

    public b(String r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        TTLiveSDK.hostService().hostOpenPlatform().preloadMiniApp(this.a);
    }
}
