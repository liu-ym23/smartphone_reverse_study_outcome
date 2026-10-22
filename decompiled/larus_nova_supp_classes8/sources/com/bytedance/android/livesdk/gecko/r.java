package com.bytedance.android.livesdk.gecko;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r<T, R> implements Function {
    public final /* synthetic */ o.a a;

    public r(o.a r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        j.b r5 = (j.b) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        int r0 = h.a;
        String r1 = this.a.d;
        Intrinsics.checkNotNullParameter(r5, "downloadEntry");
        if ((r5 instanceof j.c) == false) goto L6;
        return Observable.just(r5);
    L6:
        if ((r5 instanceof j.d) == false) goto L12;
        j.d r6 = (j.d) r5;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r6.b, r1);
        if (r2.exists() == false) goto L15;
        ALogger.i("AAM.Source.GeckoUtils", "find file: " + r2.getAbsolutePath());
        return Observable.just(new j.d(r6.a, r2.getAbsolutePath()));
    L15:
        return Observable.error(new Throwable("file not found: " + r2.getAbsolutePath()));
    L12:
        return Observable.error(new Throwable("can't handle type: ".concat(r5.getClass().getName())));
    }
}
