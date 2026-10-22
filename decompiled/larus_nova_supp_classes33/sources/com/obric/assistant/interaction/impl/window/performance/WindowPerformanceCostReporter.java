package com.obric.assistant.interaction.impl.window.performance;

import com.obric.assistant.reporter.IObricReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/performance/WindowPerformanceCostReporter;", "", "<init>", "()V", "SCENE_WINDOW", "", "report", "", "stage", "costMs", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowPerformanceCostReporter {
    public static final WindowPerformanceCostReporter INSTANCE = null;
    private static final String SCENE_WINDOW = "window";

    static {
        INSTANCE = new WindowPerformanceCostReporter();
    }

    private WindowPerformanceCostReporter() {
    }

    public final void report(String r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "stage");
        IObricReporter.a.getClass();
        IObricReporter r1 = IObricReporter.a.a();
        if (r1 == null) goto L6;
        IObricReporter.b.a(r1, SCENE_WINDOW, r9, r10, false, 24);
        return;
    }
}
