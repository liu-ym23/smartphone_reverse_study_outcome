package g2;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8939a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f8940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f8941c;

    static {
    }

    public a() {
    }

    public static synchronized File a(Context r10) {
        monitor-enter(a.class);
        File r11 = f8940b;     // Catch: Throwable -> L20
        if (r11 == null) goto L25;
        monitor-exit(a.class);
        return r11;
    L25:
        File r12 = new File(b(r10), c.c(r10).replace(".", "_").replace(":", "-") + "_frontier.bin");     // Catch: Exception -> L15 Throwable -> L20
        if (r12.exists() == true) goto L11;
        r12.createNewFile();     // Catch: Exception -> L15 Throwable -> L20
    L11:
        f8940b = r12;     // Catch: Exception -> L15 Throwable -> L20
        if (Logger.debug() == false) goto L17;
        Logger.d(f8939a, "prepare PersistentFile success. fileName=" + f8940b);     // Catch: Exception -> L15 Throwable -> L20
    L17:
        File r13 = f8940b;     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return r13;
    L15:
        e = move-exception;
        Logger.e(f8939a, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private static File b(Context r10) {
        File r11 = f8941c;
        if (r11 == null) goto L5;
        return r11;
    L5:
        File r12 = new File(r10.getFilesDir(), "wschannel");
        f8941c = r12;
        if (r12.exists() == true) goto L9;
        f8941c.mkdirs();
    L9:
        return f8941c;
    }
}
