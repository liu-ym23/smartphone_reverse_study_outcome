package vu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final ju1.c<Object> a;
    public final DynamicFactor<Object> b;
    public final iu1.a<Object> c;

    public c(ju1.c<Object> r2, DynamicFactor<Object> r3, iu1.a<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "factor");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "wrapper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
