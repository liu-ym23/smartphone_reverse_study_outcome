package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final MmRecordingEndWindowReasonMode a;
    public final Set<EndRecordingReason> b;
    public final boolean c;
    public final boolean d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingEndWindowReasonMode.values().length];
            r0[MmRecordingEndWindowReasonMode.DEFAULT_ALLOW_LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmRecordingEndWindowReasonMode.ALL_EXCEPT_BLOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.d == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingEndWindowPolicy(reasonMode=" + this.a + ", blockedReasons=" + this.b + ", requireAppForeground=" + this.c + ", initializeWithoutRecordingPage=" + this.d + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(MmRecordingEndWindowReasonMode r2, Set<? extends EndRecordingReason> r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "reasonMode");
        Intrinsics.checkNotNullParameter(r3, "blockedReasons");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
