package y58;

import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final String a;
    public final Integer b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final AsrResultState g;
    public final AsrEventEnum h;
    public final c i;

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
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Integer r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.e.hashCode()) * 31;
        long r11 = this.f;
        int r12 = (((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + this.g.hashCode()) * 31;
        AsrEventEnum r13 = this.h;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (r12 + r14) * 31;
        c r16 = this.i;
        if (r16 == null) goto L23;
        r2 = r16.hashCode();
    L23:
        return r15 + r2;
    L17:
        r14 = r13.hashCode();
        goto L18
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
        return "AsrResultData(taskId=" + this.a + ", errCode=" + this.b + ", errorMessage=" + this.c + ", asrResult=" + this.d + ", vid=" + this.e + ", duration=" + this.f + ", asrResultState=" + this.g + ", reason=" + this.h + ", extra=" + this.i + ')';
    }

    public static b a(b r11, String r12) {
        String r1 = r11.a;
        Integer r2 = r11.b;
        String r3 = r11.c;
        String r5 = r11.e;
        long r6 = r11.f;
        AsrResultState r8 = r11.g;
        AsrEventEnum r9 = r11.h;
        c r10 = r11.i;
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r5, "vid");
        Intrinsics.checkNotNullParameter(r8, "asrResultState");
        return new b(r1, r2, r3, r12, r5, r6, r8, r9, r10);
    }

    public b(String r2, Integer r3, String r4, String r5, String r6, long r7, AsrResultState r9, AsrEventEnum r10, c r11) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r6, "vid");
        Intrinsics.checkNotNullParameter(r9, "asrResultState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }

    public /* synthetic */ b(String r15, Integer r16, String r17, String r19, String r110, long r20, AsrResultState r22, AsrEventEnum r23, c r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r25 & 2) == 0) goto L9;
        Integer r5 = 0;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r25 & 32) == 0) goto L25;
        long r9 = 0;
    L27:
        if ((r25 & 256) == 0) goto L29;
        c r13 = null;
    L30:
        this(r4, r5, r6, r7, r8, r9, r22, r23, r13);
        return;
    L29:
        r13 = r24;
        goto L30
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r110;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }
}
