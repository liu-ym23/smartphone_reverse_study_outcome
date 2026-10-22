package w68;

import com.larus.im.service.audio.l;
import com.larus.im.service.audio.t;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final w68.a a = null;
    public static final a b = null;

    public static final class a implements t {
        public a() {
        }

        public final l a(l r2) {
            Intrinsics.checkNotNullParameter(r2, "frame");
            return r2;
        }

        public final Pair<l, l> c(l r2, l r3) {
            Intrinsics.checkNotNullParameter(r2, "micFrame");
            Intrinsics.checkNotNullParameter(r3, "refFrame");
            return TuplesKt.to(r2, r3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [w68.a] */
    static {
        a = new w68.a();
        b = new a();
    }
}
