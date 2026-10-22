package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w {
    public final String a;
    public final int b;

    public w() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "MmRecordingVolumeData(recordingId=" + this.a + ", recordingVolume=" + this.b + ')';
    }

    public /* synthetic */ w(int r2) {
        this("", 0);
    }

    public w(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        this.a = r2;
        this.b = r3;
    }
}
