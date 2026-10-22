package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public final List<q> a;
    public final ProactiveLabelingFeedbackConfigDto b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ProactiveAgentRemoteSnapshot(records=" + this.a + ", feedbackConfig=" + this.b + ')';
    }

    public n(List<q> r2, ProactiveLabelingFeedbackConfigDto r3) {
        Intrinsics.checkNotNullParameter(r2, "records");
        Intrinsics.checkNotNullParameter(r3, "feedbackConfig");
        this.a = r2;
        this.b = r3;
    }
}
