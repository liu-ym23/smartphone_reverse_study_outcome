package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final ConcurrentHashMap<String, b> a;

    public static final class a {
    }

    public static final class b {
        public final MmRecordingCommonParam a;
        public final String b;
        public final String c;
        public final AtomicInteger d;
        public final AtomicInteger e;
        public final AtomicLong f;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "UploadContext(commonParam=" + this.a + ", recordingId=" + this.b + ", uploadType=" + this.c + ", totalCount=" + this.d + ", successCount=" + this.e + ", durationMs=" + this.f + ')';
        }

        public b(MmRecordingCommonParam r6, String r7, String r8) {
            AtomicInteger r0 = new AtomicInteger(0);
            AtomicInteger r2 = new AtomicInteger(0);
            AtomicLong r1 = new AtomicLong(0);
            Intrinsics.checkNotNullParameter(r6, "commonParam");
            Intrinsics.checkNotNullParameter(r7, "recordingId");
            Intrinsics.checkNotNullParameter(r8, "uploadType");
            Intrinsics.checkNotNullParameter(r0, "totalCount");
            Intrinsics.checkNotNullParameter(r2, "successCount");
            Intrinsics.checkNotNullParameter(r1, "durationMs");
            this.a = r6;
            this.b = r7;
            this.c = r8;
            this.d = r0;
            this.e = r2;
            this.f = r1;
        }
    }

    static {
    }

    public d() {
        this.a = new ConcurrentHashMap();
    }

    public static void a(d r3, String r4, MmRecordingCommonParam r5) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "recordingId");
        Intrinsics.checkNotNullParameter(r5, "commonParam");
        Intrinsics.checkNotNullParameter("audio_segment", "uploadType");
        b r0 = new b(r5, r4, "audio_segment");
        b r6 = r3.a.put(r4, r0);
        StringBuilder r1 = new StringBuilder("[trackUploadStart] init context, recordingId=");
        r1.append(r4);
        r1.append(", traceId=");
        r1.append(r5.getRecordingTraceId());
        r1.append(", source=");
        r1.append(r5.getSource());
        r1.append(", uploadType=");
        r1.append("audio_segment");
        r1.append(", hasPrevious=");
        if (r6 == null) goto L5;
        boolean r7 = true;
    L6:
        r1.append(r7);
        lvb.a.e("MmRecordingUploadMetrics", r1.toString());
        return;
    L5:
        r7 = false;
        goto L6
    }
}
