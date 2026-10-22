package eub;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final MmMinutesFileUploadTaskState a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final b g;
    public final MmMinutesFileUploadTaskState h;

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        b r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        MmMinutesFileUploadTaskState r5 = this.h;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMinutesFileUploadTaskStatus(state=" + this.a + ", progress=" + this.b + ", speedKBps=" + this.c + ", objectToken=" + this.d + ", vhId=" + this.e + ", uploadId=" + this.f + ", error=" + this.g + ", lastState=" + this.h + ')';
    }

    public /* synthetic */ g(MmMinutesFileUploadTaskState r10, b r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r10 = MmMinutesFileUploadTaskState.Init;
    L5:
        MmMinutesFileUploadTaskState r1 = r10;
        if ((r12 & 8) == 0) goto L8;
        String r13 = "";
    L10:
        if ((r12 & 16) == 0) goto L12;
        String r5 = "";
    L14:
        if ((r12 & 32) == 0) goto L16;
        String r6 = "";
    L18:
        if ((r12 & 64) == 0) goto L20;
        b r7 = null;
    L21:
        this(r1, 0, 0, r13, r5, r6, r7, null);
        return;
    L20:
        r7 = r11;
        goto L21
    L16:
        r6 = null;
        goto L18
    L12:
        r5 = null;
        goto L14
    L8:
        r13 = null;
        goto L10
    }

    public g(MmMinutesFileUploadTaskState r2, int r3, int r4, String r5, String r6, String r7, b r8, MmMinutesFileUploadTaskState r9) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r5, "objectToken");
        Intrinsics.checkNotNullParameter(r6, "vhId");
        Intrinsics.checkNotNullParameter(r7, "uploadId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public static g a(g r9, MmMinutesFileUploadTaskState r10, int r11, int r12, String r13, String r14, String r15, b r16, MmMinutesFileUploadTaskState r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        MmMinutesFileUploadTaskState r2 = r9.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = r9.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        b r8 = r9.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        MmMinutesFileUploadTaskState r1 = r9.h;
    L34:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r5, "objectToken");
        Intrinsics.checkNotNullParameter(r6, "vhId");
        Intrinsics.checkNotNullParameter(r7, "uploadId");
        return new g(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L34
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
