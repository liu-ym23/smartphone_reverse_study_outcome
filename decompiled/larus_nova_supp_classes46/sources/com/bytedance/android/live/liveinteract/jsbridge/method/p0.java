package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ s0 a;

    public p0(s0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        s0.k(this.a);
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openDoubleChat.success");
    }
}
