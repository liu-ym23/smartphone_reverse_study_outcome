package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int c = 0;
    public final String a;
    public final MmRecordingEntity b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        return "MmRecordingRouteRequest(dataKey=" + this.a + ", entity=" + this.b + ')';
    }

    public b(String r2, MmRecordingEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "dataKey");
        Intrinsics.checkNotNullParameter(r3, "entity");
        this.a = r2;
        this.b = r3;
    }
}
