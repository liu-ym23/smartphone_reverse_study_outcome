package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int g = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final d e;
    public final MmMarkedSpeakerType f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmMarkedSpeakerType.values().length];
            r0[MmMarkedSpeakerType.LARK_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmMarkedSpeakerType.TEMPORARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmMarkedSpeakerType.CLUSTER_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public c() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        d r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        int r0 = b.a[this.f.ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L10;
        return "MmMarkedSpeaker(id='" + this.a + "', name='" + this.b + "', avatarUrl='" + this.d + "', speakerType=" + this.f + ')';
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return "MmMarkedSpeaker(id='" + this.a + "', name='" + this.b + "', avatarUrl='" + this.d + "', speakerType=" + this.f + ')';
    L13:
        return "MmMarkedSpeaker(id='" + this.a + "', name='" + this.b + "', department='" + this.c + "', image=" + this.e + ", speakerType=" + this.f + ')';
    }

    public c(String r2, String r3, String r4, String r5, d r6, MmMarkedSpeakerType r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r4, "department");
        Intrinsics.checkNotNullParameter(r5, "avatarUrl");
        Intrinsics.checkNotNullParameter(r7, "speakerType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ c(String r6, String r7, String r8, String r9, d r10, MmMarkedSpeakerType r11, int r12) {
        String r1 = "";
        if ((r12 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r3 = "";
    L15:
        if ((r12 & 8) != 0) goto L19;
        r1 = r9;
    L19:
        if ((r12 & 16) == 0) goto L21;
        r10 = null;
    L21:
        d r4 = r10;
        if ((r12 & 32) == 0) goto L24;
        r11 = MmMarkedSpeakerType.CLUSTER_ID;
    L24:
        String r13 = r0;
        String r14 = r2;
        String r15 = r3;
        String r16 = r1;
        this(r13, r14, r15, r16, r4, r11);
        return;
    L13:
        r3 = r8;
        goto L15
    L9:
        r2 = r7;
        goto L11
    L5:
        r0 = r6;
        goto L7
    }
}
