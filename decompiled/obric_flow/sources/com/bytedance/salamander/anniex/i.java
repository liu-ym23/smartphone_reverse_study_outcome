package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSMapKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7256a;

    public i() {
        this.f7256a = RTSMapKt.RTSMap();
        new ArrayList();
    }

    public final h a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Map r10 = this.f7256a;
        if (RTSMapKt.has(r10, r5) == false) goto L7;
        Object r11 = r10.get(r5);
        Intrinsics.checkNotNull(r11);
        return (h) r11;
    L7:
        if (RTSMapKt.has(r10, "__hybrid_default") == false) goto L11;
        Object r12 = r10.get("__hybrid_default");
        Intrinsics.checkNotNull(r12);
        return (h) r12;
    L11:
        return new h("__hybrid_default");
    }
}
