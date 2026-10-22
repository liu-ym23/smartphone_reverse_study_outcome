package fy;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final int a;
    public final long b;
    public final long c;
    public final int d;
    public final String e;
    public final String f;
    public final long g;
    public final Room h;
    public final int i;
    public final String j;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L26;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31;
        String r5 = this.e;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.f;
        if (r9 == null) goto L9;
        int r11 = r9.hashCode();
    L10:
        long r12 = this.g;
        int r13 = (((r8 + r11) * 31) + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        Room r14 = this.h;
        if (r14 == null) goto L13;
        int r15 = r14.hashCode();
    L14:
        int r16 = (((r13 + r15) * 31) + this.i) * 31;
        String r17 = this.j;
        if (r17 == null) goto L18;
        r6 = r17.hashCode();
    L18:
        return r16 + r6;
    L13:
        r15 = 0;
        goto L14
    L9:
        r11 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public final String toString() {
        return "ApplyParams(scene=" + this.a + ", roomId=" + this.b + ", toRoomId=" + this.c + ", applyType=" + this.d + ", secToUserId=" + this.e + ", toUserId=" + this.f + ", channelId=" + this.g + ", targetRoom=" + this.h + ", applyIndex=" + this.i + ", clientAttachedInfo=" + this.j + ")";
    }

    public b(int r2, long r3, long r5, int r7, String r8, String r9, long r11, Room r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r8, "secToUserId");
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        Intrinsics.checkNotNullParameter(r12, "targetRoom");
        Intrinsics.checkNotNullParameter(r14, "clientAttachedInfo");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
    }
}
