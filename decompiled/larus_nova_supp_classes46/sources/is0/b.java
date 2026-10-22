package is0;

import com.bytedance.android.live.player.api.PlayerFeatureEffectScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b<T> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static d b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "feature");
            return new d(r3, 1, Boolean.TRUE);
        }

        public static d a(String r1, @PlayerFeatureEffectScope int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "feature");
            return new d(r1, r2, Integer.valueOf(r3));
        }

        public static d c(String r1, @PlayerFeatureEffectScope int r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "feature");
            Intrinsics.checkNotNullParameter(r3, "value");
            return new d(r1, r2, r3);
        }
    }

    static {
    }

    public b() {
    }

    public abstract int a();

    public abstract String b();

    public abstract T c();
}
