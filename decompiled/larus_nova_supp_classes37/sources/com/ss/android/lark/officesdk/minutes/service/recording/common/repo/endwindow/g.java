package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {
    public final c a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        c r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "EndRecording(entity=" + this.a + ')';
    }

    public g(c r1) {
        this.a = r1;
    }
}
