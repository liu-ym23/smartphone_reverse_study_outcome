package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;

    public j(String r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        IHostLiveOpenPlatform r3 = TTLiveSDK.hostService().hostOpenPlatform();
        if (r3 == null) goto L6;
        r3.preloadMiniGame(this.a);
        return;
    }
}
