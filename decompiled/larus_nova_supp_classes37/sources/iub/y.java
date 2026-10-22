package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmParticipantTypeData;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmSubtitleSpeakerTypeData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class y {
    public final String a;
    public final String b;
    public final MmParticipantTypeData c;
    public final MmSubtitleSpeakerTypeData d;
    public final String e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmSubtitleSpeakerData(userId=" + this.a + ", deviceId=" + this.b + ", participantType=" + this.c + ", speakerType=" + this.d + ", name=" + this.e + ", avatarKey=" + this.f + ')';
    }

    public y() {
        this("", "", MmParticipantTypeData.UNKNOWN, MmSubtitleSpeakerTypeData.UNKNOWN, null, null);
    }

    public y(String r2, String r3, MmParticipantTypeData r4, MmSubtitleSpeakerTypeData r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        Intrinsics.checkNotNullParameter(r4, "participantType");
        Intrinsics.checkNotNullParameter(r5, "speakerType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
