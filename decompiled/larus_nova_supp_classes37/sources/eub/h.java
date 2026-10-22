package eub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final String a;
    public final MmRecordingSource b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final long g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r9 = (h) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        long r1 = this.g;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.h.hashCode()) * 31;
        String r3 = this.i;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.j;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.k;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        String r13 = this.l;
        if (r13 == null) goto L19;
        r4 = r13.hashCode();
    L19:
        return r12 + r4;
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRawOpusUploadParam(rawOpusPath=" + this.a + ", source=" + this.b + ", channels=" + this.c + ", sampleRate=" + this.d + ", bitrateBps=" + this.e + ", frameMs=" + this.f + ", durationMs=" + this.g + ", recordUuid=" + this.h + ", realtimeRecordingStartMs=" + this.i + ", realtimeRecordingStopMs=" + this.j + ", startTimeZoneOffset=" + this.k + ", doubaoBizInfo=" + this.l + ')';
    }

    public h(String r3, MmRecordingSource r4, int r5, int r6, int r7, int r8, long r9, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r3, "rawOpusPath");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter("", "recordUuid");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = "";
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
