package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final MmAudioSaveType a;
    public final boolean b;
    public final boolean c;
    public final g d;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return ((r3 + r2) * 31) + this.d.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingAudioSaveEntity(audioSaveType=" + this.a + ", showAudioSaveEntry=" + this.b + ", needShowAudioSaveBoarding=" + this.c + ", autoSaveDecision=" + this.d + ')';
    }

    public /* synthetic */ f(int r9) {
        this(MmAudioSaveType.SAVE, false, false, new g(null, false, 0, null, null, 63));
    }

    public f(MmAudioSaveType r2, boolean r3, boolean r4, g r5) {
        Intrinsics.checkNotNullParameter(r2, "audioSaveType");
        Intrinsics.checkNotNullParameter(r5, "autoSaveDecision");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static f a(f r1, MmAudioSaveType r2, boolean r3, boolean r4, g r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = r1.d;
    L14:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "audioSaveType");
        Intrinsics.checkNotNullParameter(r5, "autoSaveDecision");
        return new f(r2, r3, r4, r5);
    }
}
