package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final MmMarkedSpeakerType g;

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
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "MmMarkedSpeakerData(id=" + this.a + ", name=" + this.b + ", department=" + this.c + ", avatarUrl=" + this.d + ", imageKey=" + this.e + ", imageFsUnit=" + this.f + ", speakerType=" + this.g + ')';
    }

    public f() {
        this("", "", "", "", "", "", MmMarkedSpeakerType.CLUSTER_ID);
    }

    public f(String r2, String r3, String r4, String r5, String r6, String r7, MmMarkedSpeakerType r8) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r4, "department");
        Intrinsics.checkNotNullParameter(r5, "avatarUrl");
        Intrinsics.checkNotNullParameter(r6, "imageKey");
        Intrinsics.checkNotNullParameter(r7, "imageFsUnit");
        Intrinsics.checkNotNullParameter(r8, "speakerType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
