package com.bytedance.ies.argus.bean;

import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.strategy.provider.client.e;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum f5120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f5121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f5122c;
    public final ConcurrentHashMap d;
    public final ArrayList e;
    public final ArrayList f;
    public final ym.d g;

    public a(ArgusGlobalAspect r5, e r10) {
        Intrinsics.checkNotNullParameter(r5, "callingAspect");
        Intrinsics.checkNotNullParameter(r10, "callerParams");
        this.f5120a = r5;
        this.f5121b = r10;
        this.f5122c = LazyKt.lazy(new AspectContext$aspectConfigInfo$2(this));
        if (r10.f.getValue() != null) goto L7;
        new b();
        this.d = new ConcurrentHashMap();
        this.e = new ArrayList();
        this.f = new ArrayList();
        a(AspectContext$Companion$TraceType.f5111c, AspectContext$Companion$TraceStage.f5107a, null);
        ArgusReportPlatform r11 = ArgusReportPlatform.f5009a;
        Intrinsics.checkNotNullParameter(r11, "reportPlatform");
        ym.d r12 = new ym.d();
        r12.f23297a = r11;
        this.g = r12;
        return;
    L7:
        throw new ClassCastException();
    }

    public final void a(AspectContext$Companion$TraceType r10, AspectContext$Companion$TraceStage r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "stage");
        Intrinsics.checkNotNullParameter(r11, "stageType");
        String r5 = r10.f5112a;
        int r13 = r10.ordinal();
        if (r13 != 2) goto L5;
    L7:
        ConcurrentHashMap r14 = this.d;
        if (r14.get(r5) != null) goto L14;
        long[] r15 = new long[2];
        int r16 = 0;
    L10:
        if (r16 >= 2) goto L12;
        r15[r16] = -1;
        r16 = r16 + 1;
        goto L10
    L12:
        r14.put(r5, r15);
    L14:
        if (r11 != AspectContext$Companion$TraceStage.f5107a) goto L19;
        long[] r17 = (long[]) r14.get(r5);
        if (r17 == null) goto L24;
        r17[0] = System.currentTimeMillis();
        return;
    L24:
        return;
    L19:
        long[] r18 = (long[]) r14.get(r5);
        if (r18 == null) goto L25;
        r18[1] = System.currentTimeMillis();
        return;
    L25:
        return;
    L5:
        if (r13 == 3) goto L7;
        r5 = androidx.constraintlayout.motion.widget.a.m(r5, '_', r12);
        goto L7
    }

    public final b b() {
        com.bytedance.ies.argus.repository.c r5 = (com.bytedance.ies.argus.repository.c) this.f5122c.getValue();
        b r10 = new b();
        b.g(r10, ArgusCommonVerifyReason.f5020h, null, 6);
        return r10;
    }
}
