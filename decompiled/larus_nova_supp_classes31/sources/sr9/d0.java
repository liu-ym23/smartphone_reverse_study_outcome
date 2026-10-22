package sr9;

import com.larus.platform.api.IVideoController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d0 implements ps8.a {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    public final IVideoController a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "subTag");
        return null;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
    }

    public final IVideoController c(String r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r3, "subTag");
        return null;
    }
}
