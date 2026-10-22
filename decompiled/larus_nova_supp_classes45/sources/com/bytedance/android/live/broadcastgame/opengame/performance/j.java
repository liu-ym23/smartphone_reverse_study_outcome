package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ OpenPlatformPerfRuntime a;

    public j(OpenPlatformPerfRuntime r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r4 = AnchorGameContext.a.a();
        if (r4 == null) goto L9;
        m<Boolean> r5 = r4.getOpenGamePerfUploadState();
        if (r5 == null) goto L9;
        if (((Boolean) r5.getValue()).booleanValue() == true) goto L9;
        return;
    L9:
        this.a.c(2);
    }
}
