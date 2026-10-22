package fy;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public final int a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final LinkerKickOutContent.KickOutSource f;
    public final long g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g) == false) goto L20;
        g r7 = (g) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        String r11 = this.e;
        if (r11 == null) goto L13;
        int r12 = r11.hashCode();
    L14:
        int r13 = (r9 + r12) * 31;
        LinkerKickOutContent.KickOutSource r14 = this.f;
        if (r14 == null) goto L17;
        r4 = r14.hashCode();
    L17:
        long r15 = this.g;
        return ((r13 + r4) * 31) + ((int) (r15 ^ (r15 >>> 32)));
    L13:
        r12 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final String toString() {
        return "KickOutParams(scene=" + this.a + ", channelId=" + this.b + ", toUserId=" + this.c + ", secToUserId=" + this.d + ", reqSrc=" + this.e + ", kickOutSource=" + this.f + ", toRoomId=" + this.g + ")";
    }

    public /* synthetic */ g(long r11, String r13, String r14, String r15, LinkerKickOutContent.KickOutSource r16, int r17) {
        if ((r17 & 32) == 0) goto L5;
        LinkerKickOutContent.KickOutSource r7 = LinkerKickOutContent.KickOutSource.General;
    L6:
        this(17, r11, r13, r14, r15, r7, 0);
        return;
    L5:
        r7 = r16;
        goto L6
    }

    public g(int r2, long r3, String r5, String r6, String r7, LinkerKickOutContent.KickOutSource r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        Intrinsics.checkNotNullParameter(r8, "kickOutSource");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
