package com.larus.common.location.impl;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements a3 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Continuation<LocationResult> b;

    public a(Ref.BooleanRef r1, SafeContinuation r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(LocationResult r1, Integer r2, GeoLocationInfo r3) {
        Intrinsics.checkNotNullParameter(r1, "code");
        Ref.BooleanRef r4 = this.a;
        if (r4.element == false) goto L5;
        return;
    L5:
        r4.element = true;
        this.b.resumeWith(Result.constructor-impl(r1));
    }
}
