package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final ConcurrentHashMap<String, b> a;

    public static final class a {
    }

    public static final class b {
        public final MmRecordingCommonParam a;
        public final String b;
        public final DoubaoStatisticInfo c;
        public final long d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            DoubaoStatisticInfo r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            long r4 = this.d;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "EndWindowContext(commonParam=" + this.a + ", source=" + this.b + ", doubaoStatisticInfo=" + this.c + ", startTimeMs=" + this.d + ')';
        }

        public b(MmRecordingCommonParam r2, String r3, DoubaoStatisticInfo r4, long r5) {
            Intrinsics.checkNotNullParameter(r2, "commonParam");
            Intrinsics.checkNotNullParameter(r3, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public c() {
        this.a = new ConcurrentHashMap();
    }
}
