package com.obric.memorydata.memory.ui.feedback;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/FeedbackInputHeightCalculator;", "", "<init>", "()V", "calculate", "Lcom/obric/memorydata/memory/ui/feedback/FeedbackInputHeightResult;", "geometry", "Lcom/obric/memorydata/memory/ui/feedback/FeedbackInputHeightGeometry;", "calculateEditorHeight", "", "outerHeightPx", "chromeHeightPx", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10928a = null;

    static {
        f10928a = new a();
    }

    private a() {
    }

    public final int a(int r1, int r2) {
        return RangesKt.coerceAtLeast(r1 - r2, 1);
    }

    public final c a(b r4) {
        Intrinsics.checkNotNullParameter(r4, "geometry");
        int r3 = ((((r4.d() - r4.e()) - r4.f()) - r4.g()) - r4.h()) - r4.i();
        boolean r0 = true;
        int r1 = RangesKt.coerceAtLeast(r3, 1);
        int r2 = Math.min(RangesKt.coerceAtLeast(r4.c(), 1), r1);
        int r5 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r4.a(), r4.b()), r2), 1);
        if (r3 <= 0) goto L7;
        r0 = false;
    L7:
        return new c(r5, r0);
    }
}
