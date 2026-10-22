package jy9;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final String a;
    public final z b;
    public final Function1<Message, Map<String, String>> c;
    public final c d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        z r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BeautifyConfig(curBotId=" + this.a + ", imageEditConfig=" + this.b + ", replyTrackMapResolver=" + this.c + ", beautifyEnv=" + this.d + ')';
    }

    public b(String r2, z r3, q r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "replyTrackMapResolver");
        Intrinsics.checkNotNullParameter(r5, "beautifyEnv");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
