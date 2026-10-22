package com.bytedance.lynx.service.reporter.performance;

import com.lynx.tasm.eventreport.LynxEventReporter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final Lazy e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lambda f6845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6847c;
    public volatile boolean d;

    static {
        e = LazyKt.lazy(LynxMemoryReportTimer$Companion$reportIntervalSec$2.f6839a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function3 r5) {
        Intrinsics.checkNotNullParameter(r5, "reportBlock");
        this.f6845a = (Lambda) r5;
    }

    public final void a() {
        if (this.d == true) goto L5;
        return;
    L5:
        Ref.LongRef r5 = new Ref.LongRef();
        long r10 = ((Number) e.getValue()).longValue() * (this.f6846b + 1);
        r5.element = r10;
        if (r10 <= 7200) goto L8;
        r5.element = 7200;
    L8:
        LynxEventReporter.delayRunOnReportThread(new a2.b(10, this, r5), r5.element * ((long) 1000));
    }
}
