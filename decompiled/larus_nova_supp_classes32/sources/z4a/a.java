package z4a;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static boolean a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("basedevtool", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> basedevtool");
        com.bytedance.librarian.a.c("basedevtool");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> basedevtool");
    }
}
