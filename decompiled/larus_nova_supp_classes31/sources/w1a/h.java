package w1a;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h extends d {
    public final String a;

    public h() {
        this(0);
    }

    public /* synthetic */ h(int r1) {
        this(String.valueOf(UUID.randomUUID()));
    }

    public h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "subscriptionId");
        this.a = r2;
    }
}
