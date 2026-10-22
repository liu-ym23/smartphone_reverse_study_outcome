package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import gd0.x;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s {
    public static final x a(pc0.e r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$toRtcManagerData");
        vc0.a r1 = r9.a;
        Object r2 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.a;
    L7:
        if ((r3 instanceof ei6.a) == true) goto L9;
        r3 = null;
    L9:
        ei6.a r4 = (ei6.a) r3;
        boolean r5 = r9.b;
        Map<String, Object> r6 = r9.c.a;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r7 = ILiveWrappedLivePusher.a.b();
        if (r7 == null) goto L15;
        vc0.a r8 = r9.d;
        if (r8 == null) goto L14;
        r2 = r8.a;
    L14:
        d0 r10 = r7.buildLiveCore(r2);
    L17:
        return new x(r4, r5, r6, r10, r9.e, null, 32);
    L15:
        r10 = null;
        goto L17
    L5:
        r3 = null;
        goto L7
    }
}
