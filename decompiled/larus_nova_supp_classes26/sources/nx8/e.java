package nx8;

import com.bytedance.common.utility.NetworkClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final String a;
    public final NetworkClient b;
    public final k c;
    public final a d;

    public e(String r2, NetworkClient r3, k r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "apiHost");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
