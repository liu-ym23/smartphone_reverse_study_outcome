package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSMapKt;
import com.bytedance.salamander.adapter.Lock;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static final Lock d = null;
    public static q e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f7275c;

    static {
        new Lock();
        new Lock();
        d = new Lock();
    }

    public q() {
        this.f7273a = RTSMapKt.RTSMap();
        new ArrayList();
        this.f7274b = new ArrayList();
        this.f7275c = new o();
    }

    public final o a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        return this.f7275c;
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        RTSMapKt.delete(this.f7273a, r5);
    }
}
