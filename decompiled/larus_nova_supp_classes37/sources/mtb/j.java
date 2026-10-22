package mtb;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j extends c {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final List<String> f;

    public j(String r2, String r3, String r4, boolean r5, boolean r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r2, "displayName");
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        Intrinsics.checkNotNullParameter(r4, "avatarKey");
        Intrinsics.checkNotNullParameter(r7, "profileFieldTexts");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
