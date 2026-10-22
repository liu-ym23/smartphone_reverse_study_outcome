package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final AtomicReference<C0038b> a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b$b, reason: collision with other inner class name */
    public static final class C0038b {
        public final MmRecordingCommonParam a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0038b) == true) goto L8;
            return false;
        L8:
            C0038b r9 = (C0038b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "StartContext(commonParam=" + this.a + ", startTimeMs=" + this.b + ')';
        }

        public C0038b(MmRecordingCommonParam r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "commonParam");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public b() {
        this.a = new AtomicReference(null);
    }
}
