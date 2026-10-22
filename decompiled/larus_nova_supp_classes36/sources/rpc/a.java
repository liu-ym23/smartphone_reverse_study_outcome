package rpc;

import com.lark.kmp.pb.basic.v1.Packet;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final long a;
    public final boolean b;
    public final byte[] c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final Packet.StreamStatus g;

    public final String toString() {
        return "AsyncCallbackData(taskId=" + this.a + ", isError=" + this.b + ", data=" + Arrays.toString(this.c) + ", userId=" + this.d + ", needVerifyUser=" + this.e + ", outerHandled=" + this.f + ", steamStatus=" + this.g + ')';
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r1 + r3) * 31;
        byte[] r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = Arrays.hashCode(r5);
    L10:
        int r7 = (((r4 + r6) * 31) + this.d.hashCode()) * 31;
        if (this.e == true) goto L15;
        r2 = 1237;
    L15:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L40:
        return false;
    L8:
        if (a.class != r8.getClass()) goto L40;
        a r9 = (a) r8;
        if (this.a == r9.a) goto L14;
        return false;
    L14:
        if (this.b == r9.b) goto L16;
        return false;
    L16:
        byte[] r2 = this.c;
        if (r2 == null) goto L25;
        byte[] r3 = r9.c;
        if (r3 != null) goto L22;
        return false;
    L22:
        if (Arrays.equals(r2, r3) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L31;
        return false;
    L31:
        if (this.e == r9.e) goto L34;
        return false;
    L34:
        if (this.f == r9.f) goto L37;
        return false;
    L37:
        if (this.g == r9.g) goto L39;
        return false;
    L39:
        return true;
    L25:
        if (r9.c == null) goto L28;
        return false;
    }

    public a(long r1, boolean r3, byte[] r4, String r5, boolean r6, Packet.StreamStatus r7, int r8) {
        if ((r8 & 64) == 0) goto L5;
        r7 = Packet.StreamStatus.FINAL_WITH_PAYLOAD;
    L5:
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r7, "steamStatus");
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = false;
        this.g = r7;
    }
}
