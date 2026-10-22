package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.exception.MmCreateRecordingException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final MmCreateRecordingException a;
    public final b b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        return "MmRecordingCreateFailureDecision(exception=" + this.a + ", feedback=" + this.b + ')';
    }

    public a(MmCreateRecordingException r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        Intrinsics.checkNotNullParameter(r3, "feedback");
        this.a = r2;
        this.b = r3;
    }
}
