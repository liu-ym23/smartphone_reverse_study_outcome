package com.larus.apm.impl;

import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.jvm.internal.Intrinsics;
import q48.r;
import v48.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a implements e {
    public final /* synthetic */ NpthImpl a;

    public a(NpthImpl r1) {
        this.a = r1;
    }

    public final void onGetId(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "did");
        Intrinsics.checkNotNullParameter(r3, "iid");
        Intrinsics.checkNotNullParameter(r4, "ssid");
        FLogger r5 = FLogger.a;
        int r6 = NpthImpl.c;
        r5.i("NpthImpl", "addGetAppLogIdListener onGetId");
        NpthImpl r7 = this.a;
        r7.getClass();
        r5.i("NpthImpl", "trySaveDeviceIdToKeva start delay 2s");
        t0.b(new r(r7), 2000);
    }
}
