package com.ss.android.lark.integrator.security.compliance.screen_audit;

import com.ss.android.lark.log.Log;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r4) {
        Integer r5 = (Integer) r4;
        b r0 = this.a;
        Intrinsics.checkNotNull(r5);
        int r6 = r5.intValue();
        if (r6 == r0.c) goto L11;
        r0.c = r6;
        if (r6 != 1) goto L8;
        Log.i("OfficeSDKScreenAudit", "screen recording entered VISIBLE");
        r0.a.a();
        return;
    L8:
        Log.i("OfficeSDKScreenAudit", "screen recording state changed: " + r6);
        return;
    }
}
