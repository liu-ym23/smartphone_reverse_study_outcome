package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmParticipantTypeData;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmSubtitleSpeakerTypeData;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final String a;
    public final String b;
    public final MmParticipantTypeData c;
    public final MmSubtitleSpeakerTypeData d;
    public final String e;
    public final d f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "MmDisplaySpeakerData(userId=" + this.a + ", deviceId=" + this.b + ", participantType=" + this.c + ", speakerType=" + this.d + ", name=" + this.e + ", avatar=" + this.f + ')';
    }

    public e() {
        this("", "", MmParticipantTypeData.UNKNOWN, MmSubtitleSpeakerTypeData.UNKNOWN, "", new d(null, null, null, null, 15));
    }

    public e(String r2, String r3, MmParticipantTypeData r4, MmSubtitleSpeakerTypeData r5, String r6, d r7) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        Intrinsics.checkNotNullParameter(r4, "participantType");
        Intrinsics.checkNotNullParameter(r5, "speakerType");
        Intrinsics.checkNotNullParameter(r6, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r7, "avatar");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
