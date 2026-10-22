package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ y a;

    public z(y r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IRoomLinkMicSyncData r3 = (IRoomLinkMicSyncData) r2;
        if (this.a.G == true) goto L5;
        return;
    L5:
        if (vm2.e.i() == false) goto L9;
        y r4 = this.a;
        r4.G = false;
        r4.H();
        return;
    }
}
