package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.videochat.Image;
import com.ss.android.lark.pb.videochat.LarkSpeakerInfo;
import com.ss.android.lark.pb.videochat.SpeakerInfo;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final /* synthetic */ int h = 0;
    public final MmRecordingSpeakerCandidateType a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final d f;
    public final MmMarkedSpeakerType g;

    public static final class a {
        public static e a(LarkSpeakerInfo r9) {
            MmRecordingSpeakerCandidateType r1 = MmRecordingSpeakerCandidateType.NORMAL;
            if (r9 == null) goto L6;
            String r2 = r9.mid;
            if (r2 == null) goto L6;
        L7:
            if (r9 == null) goto L10;
            String r3 = r9.mname;
            if (r3 == null) goto L10;
        L11:
            if (r9 == null) goto L14;
            String r4 = r9.mdepartment;
            if (r4 == null) goto L14;
        L16:
            if (r9 == null) goto L20;
            Image r10 = r9.mavatar;
            if (r10 == null) goto L20;
            d r6 = new d(r10.mkey, r10.mfs_unit);
        L22:
            return new e(r1, r2, r3, r4, null, r6, MmMarkedSpeakerType.LARK_USER, 16);
        L20:
            r6 = null;
        L14:
            r4 = "";
        L10:
            r3 = "";
        L6:
            r2 = "";
            goto L7
        }

        public static e b(SpeakerInfo r10) {
            MmRecordingSpeakerCandidateType r1 = MmRecordingSpeakerCandidateType.NORMAL;
            if (r10 == null) goto L6;
            String r2 = r10.mid;
            if (r2 == null) goto L6;
        L7:
            if (r10 == null) goto L10;
            String r3 = r10.mname;
            if (r3 == null) goto L10;
        L12:
            if (r10 == null) goto L17;
            String r11 = r10.mavatar;
            if (r11 == null) goto L17;
            String r5 = r11;
        L19:
            return new e(r1, r2, r3, null, r5, null, MmMarkedSpeakerType.TEMPORARY, 40);
        L17:
            r5 = "";
        L10:
            r3 = "";
        L6:
            r2 = "";
            goto L7
        }
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
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        d r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.g.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        int r0 = b.a[this.g.ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L19;
        if (r0 != 3) goto L13;
        if (this.a != MmRecordingSpeakerCandidateType.ADD_NEW) goto L18;
        return "MmSpeakerCandidate(type=" + this.a + ", name='" + this.c + "', speakerType=" + this.g + ')';
    L18:
        return "MmSpeakerCandidate(type=" + this.a + ", id='" + this.b + "', name='" + this.c + "', avatarUrl='" + this.e + "', speakerType=" + this.g + ')';
    L13:
        throw new NoWhenBranchMatchedException();
    L19:
        return "MmSpeakerCandidate(type=" + this.a + ", id='" + this.b + "', name='" + this.c + "', avatarUrl='" + this.e + "', speakerType=" + this.g + ')';
    L16:
        return "MmSpeakerCandidate(type=" + this.a + ", id='" + this.b + "', name='" + this.c + "', department='" + this.d + "', image=" + this.f + ", speakerType=" + this.g + ')';
    }

    public final MmRecordingSpeakerCandidateType getType() {
        return this.a;
    }

    public e(MmRecordingSpeakerCandidateType r3, String r4, String r5, String r6, String r7, d r8, MmMarkedSpeakerType r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r4 = "";
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = "";
    L9:
        if ((r10 & 8) == 0) goto L12;
        r6 = "";
    L12:
        if ((r10 & 16) == 0) goto L15;
        r7 = "";
    L15:
        if ((r10 & 32) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & 64) == 0) goto L20;
        r9 = MmMarkedSpeakerType.CLUSTER_ID;
    L20:
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r6, "department");
        Intrinsics.checkNotNullParameter(r7, "avatarUrl");
        Intrinsics.checkNotNullParameter(r9, "speakerType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
