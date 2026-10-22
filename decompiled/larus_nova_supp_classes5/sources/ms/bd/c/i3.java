package ms.bd.c;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.HashSet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i3 {
    public final HashSet a;
    public final c4 b;
    public final h c;

    public i3() {
        c4 r0 = new c4();
        h r1 = new h();
        this.a = new HashSet();
        this.b = r0;
        this.c = r1;
    }

    @JvmStatic
    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }
}
