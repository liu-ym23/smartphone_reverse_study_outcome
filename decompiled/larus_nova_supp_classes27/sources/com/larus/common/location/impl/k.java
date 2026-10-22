package com.larus.common.location.impl;

import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.utils.logger.FLogger;
import hq9.a3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ LocateScene b;
    public final /* synthetic */ a3 c;

    public /* synthetic */ k(Ref.BooleanRef r1, LocateScene r2, n r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref.BooleanRef r0 = this.a;
        LocateScene r1 = this.b;
        a3 r2 = this.c;
        int r3 = LocationClient.o;
        r0.element = true;
        FLogger.a.e("LocationClient", "[" + r1.name() + "] singleLocate error with timeOutErrorCallbackScheduler");
        a3.a.a(r2, LocationResult.TIME_OUT, null, null, 6);
    }
}
