package pc4;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static volatile boolean a;
    public static volatile boolean b;
    public static final Lock c = null;

    public static boolean b() {
        Lock r1 = c;     // Catch: Error -> L6 Throwable -> L12
        ((ReentrantLock) r1).lock();     // Catch: Error -> L6 Throwable -> L12
        if (b == true) goto L9;
        a("ttcrypto");     // Catch: Error -> L6 Throwable -> L12
        b = true;     // Catch: Error -> L6 Throwable -> L12
    L9:
        if (a == true) goto L11;
        a("ttboringssl");     // Catch: Error -> L6 Throwable -> L12
        a = true;     // Catch: Error -> L6 Throwable -> L12
    L11:
        ((ReentrantLock) r1).unlock();
        if (a == true) goto L19;
    L21:
        return false;
    L19:
        if (b == false) goto L21;
        return true;
    L12:
        th = move-exception;
        ((ReentrantLock) c).unlock();
        throw th;
    L6:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L12
        r1 = c;
        goto L11
    }

    static {
        c = new ReentrantLock();
    }

    @JvmStatic
    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r3));
        com.bytedance.librarian.a.c(r3);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r3));
    }
}
