package j42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final long a;
    public final String b;
    public final String c;
    public final String d;

    public b(long r2, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "commenterNickName");
        Intrinsics.checkNotNullParameter(r5, "commenterUserId");
        Intrinsics.checkNotNullParameter(r6, "commentContent");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
