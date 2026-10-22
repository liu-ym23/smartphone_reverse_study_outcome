package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ y a;

    public w(y r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ALogger.i("LiveStream", "VideoAntiShakeChangedEvent:" + ((pv0.i) r3).a);
        this.a.getClass();
    }
}
