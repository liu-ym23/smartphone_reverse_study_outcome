package gx1;

import com.bytedance.android.live.user.IMiddlewareUserService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final boolean a;
    public final long b;
    public final String c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L10;
        a r7 = (a) r6;
        if (this.b == r7.b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.c;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "FeedbackSession(roomId=" + this.b + ", roomOwnerId=" + this.c + ")";
    }

    public a() {
        this(0, "0");
    }

    public a(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "roomOwnerId");
        this.b = r2;
        this.c = r4;
        this.a = Intrinsics.areEqual(k.n(IMiddlewareUserService.class).user().n(), r4);
    }
}
