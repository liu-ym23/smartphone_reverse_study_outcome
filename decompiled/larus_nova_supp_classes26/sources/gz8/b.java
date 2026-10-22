package gz8;

import com.larus.bmhome.actionbar.model.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int b = 0;
    public final k a;

    public static final class a {
        public static b a(p0 r2) {
            Intrinsics.checkNotNullParameter(r2, "activeSwitchConf");
            if (Intrinsics.areEqual(r2.k, Boolean.TRUE) == false) goto L5;
            k r0 = new l(r2.j);
        L7:
            return new b(r0);
        L5:
            r0 = new j(r2.d());
            goto L7
        }
    }

    static {
    }

    public b(k r1) {
        this.a = r1;
    }
}
