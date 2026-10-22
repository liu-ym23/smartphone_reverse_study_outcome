package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ i a;

    public k(i r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        ALogger.i("CarnivalBinarySeiHandler", "carnival state change. started=" + r4);
        if (r4.booleanValue() == true) goto L6;
        this.a.b();
        return;
    }
}
