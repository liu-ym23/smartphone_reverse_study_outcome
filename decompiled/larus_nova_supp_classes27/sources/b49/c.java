package b49;

import java.net.InetAddress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final int a;
    public final int b;
    public final int c;
    public final InetAddress d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DoraRTCChannelConfig(channelID=" + this.a + ", localPort=" + this.b + ", targetPort=" + this.c + ", host=" + this.d + ')';
    }

    public c(int r2, int r3, InetAddress r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        this.a = r2;
        this.b = 0;
        this.c = r3;
        this.d = r4;
    }
}
