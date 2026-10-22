package pib;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends d {
    public final String c;
    public final String d;

    public final String toString() {
        return "ForwardFavShareOption{ messageId=" + this.a + ", favId=" + this.d + " ,messageFileKeys_size = " + this.c + '}';
    }

    public a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "messageFileKey");
        Intrinsics.checkNotNullParameter(r4, "favId");
        this.c = r3;
        this.d = r4;
        this.b = 8;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
