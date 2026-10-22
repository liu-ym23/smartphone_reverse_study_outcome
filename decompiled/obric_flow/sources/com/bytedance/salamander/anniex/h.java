package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSMapKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7255c;
    public boolean d;
    public boolean e;

    public h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        this.f7253a = "__hybrid_default";
        RTSMapKt.RTSMap();
        if (Intrinsics.areEqual(r5, "") == true) goto L6;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f7253a = r5;
        return;
    }
}
