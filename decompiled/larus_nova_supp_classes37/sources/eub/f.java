package eub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final String a;
    public final MmRecordingSource b;
    public final List<d> c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Map<String, String> h;
    public final String i;

    public f() {
        this(null, null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.h.hashCode()) * 31;
        String r11 = this.i;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMinutesFileUploadTaskParam(taskId=" + this.a + ", source=" + this.b + ", files=" + this.c + ", recordUuid=" + this.d + ", realtimeRecordingStartMs=" + this.e + ", realtimeRecordingStopMs=" + this.f + ", startTimeZoneOffset=" + this.g + ", extra=" + this.h + ", doubaoBizInfo=" + this.i + ')';
    }

    public final String b() {
        return this.i;
    }

    public final Map<String, String> c() {
        return this.h;
    }

    public final List<d> d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final MmRecordingSource f() {
        return this.b;
    }

    public final String g() {
        return this.a;
    }

    public static f a(f r10, String r11, List r12, Map r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r11 = r10.a;
    L5:
        String r1 = r11;
        if ((r14 & 2) == 0) goto L8;
        MmRecordingSource r2 = r10.b;
    L10:
        if ((r14 & 4) == 0) goto L12;
        r12 = r10.c;
    L12:
        List r3 = r12;
        if ((r14 & 8) == 0) goto L15;
        String r4 = r10.d;
    L17:
        if ((r14 & 16) == 0) goto L19;
        String r5 = r10.e;
    L21:
        if ((r14 & 32) == 0) goto L23;
        String r6 = r10.f;
    L25:
        if ((r14 & 64) == 0) goto L27;
        String r7 = r10.g;
    L29:
        if ((r14 & 128) == 0) goto L31;
        r13 = r10.h;
    L31:
        Map r8 = r13;
        if ((r14 & 256) == 0) goto L34;
        String r9 = r10.i;
    L35:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "files");
        Intrinsics.checkNotNullParameter(r4, "recordUuid");
        Intrinsics.checkNotNullParameter(r8, "extra");
        return new f(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    L34:
        r9 = null;
        goto L35
    L27:
        r7 = null;
        goto L29
    L23:
        r6 = null;
        goto L25
    L19:
        r5 = null;
        goto L21
    L15:
        r4 = null;
        goto L17
    L8:
        r2 = null;
        goto L10
    }

    public f(String r2, MmRecordingSource r3, List<d> r4, String r5, String r6, String r7, String r8, Map<String, String> r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "files");
        Intrinsics.checkNotNullParameter(r5, "recordUuid");
        Intrinsics.checkNotNullParameter(r9, "extra");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ f(String r11, MmRecordingSource r12, List r13, String r14, String r15, String r16, String r17, Map r18, String r19, int r20) {
        String r2 = "";
        if ((r20 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r20 & 2) == 0) goto L9;
        MmRecordingSource r3 = MmRecordingSource.FEISHU;
    L11:
        if ((r20 & 4) == 0) goto L13;
        List r4 = CollectionsKt.emptyList();
    L15:
        if ((r20 & 8) != 0) goto L18;
        r2 = r14;
    L18:
        String r6 = null;
        if ((r20 & 16) == 0) goto L21;
        String r5 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Map r9 = MapsKt.emptyMap();
    L35:
        if ((r20 & 256) != 0) goto L38;
        r6 = r19;
    L38:
        this(r1, r3, r4, r2, r5, r7, r8, r9, r6);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r15;
        goto L23
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
