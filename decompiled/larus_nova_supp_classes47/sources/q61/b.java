package q61;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {

    public static final class a {
        public final Map<String, String> a;
        public final Map<String, String> b;
        public final cz.c c;

        public a(cz.c r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.c = r2;
            LinkedHashMap r3 = new LinkedHashMap();
            this.a = r3;
            this.b = r3;
        }

        public final void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            this.a.put(r2, r3);
        }
    }

    Map<String, String> getLogParams();

    cz.c getScene();
}
