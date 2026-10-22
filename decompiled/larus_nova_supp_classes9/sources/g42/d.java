package g42;

import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface d {

    public static final class a {
        public static void a(h r1, Map r2) {
            Intrinsics.checkNotNullParameter(r1, "event");
            Intrinsics.checkNotNullParameter(r2, "map");
        }

        public static void b(d r1, HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            r1.c(r2, r3);
        }

        public static void c(d r1, HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            r1.c(r2, r3);
        }

        public static void d(d r1, HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            r1.c(r2, r3);
        }

        public static void e(d r1, HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            r1.c(r2, r3);
        }

        public static void f(d r1, HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            r1.c(r2, r3);
        }

        public static void g(d r1, HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            r1.c(r2, r3);
        }
    }

    void a(HighlightItem r1, Map<String, String> r2);

    void b(HighlightItem r1, Map<String, String> r2);

    void c(HighlightItem r1, Map<String, String> r2);

    void d(h<?> r1, Map<String, String> r2);

    void e(HighlightItem r1, Map<String, String> r2);

    void f(HighlightItem r1, Map<String, String> r2);

    void g(HighlightItem r1, Map<String, String> r2);

    void h(HighlightItem r1, Map<String, String> r2);
}
