package com.larus.common.location.impl;

import android.os.Handler;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p implements a3 {
    public final /* synthetic */ LocationClient a;
    public final /* synthetic */ a3 b;
    public final /* synthetic */ LocateScene c;

    public p(LocationClient r1, a3 r2, LocateScene r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(final LocationResult r9, final Integer r10, final GeoLocationInfo r11) {
        Intrinsics.checkNotNullParameter(r9, "code");
        Handler r0 = this.a.j;
        final a3 r2 = this.b;
        final LocateScene r6 = this.c;
        r0.post(new o(r2, r9, r10, r11, r6));
    }
}
