package com.ss.android.lark.officesdk.minutes.ui.style.contract;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public final boolean a;
    public final boolean b;
    public final MmRecordingSource c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        MmRecordingSource r4 = this.c;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmTopBarCapabilityContext(hasHostBridge=" + this.a + ", hasHostNavRect=" + this.b + ", source=" + this.c + ')';
    }

    public i(boolean r1, boolean r2, MmRecordingSource r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
