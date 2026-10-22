package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ d a;

    public h(d r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((Long) r3, "it");
        ALogger.i("DiggHandler", "interval map, current diggCount: " + this.a.b);
        d r4 = this.a;
        int r0 = r4.b;
        r4.b = 0;
        return Integer.valueOf(r0);
    }
}
