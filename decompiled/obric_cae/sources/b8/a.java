package b8;

import android.annotation.SuppressLint;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f3132a = null;

    static {
        f3132a = new ArrayList();
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static synchronized boolean a() {
        monitor-enter(a.class);
        ArrayList r8 = f3132a;     // Catch: Throwable -> L18
        if (r8.contains("monitorcollector-lib") == false) goto L22;
        monitor-exit(a.class);
        return true;
    L22:
        System.loadLibrary("monitorcollector-lib");     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        r8.add("monitorcollector-lib");     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        monitor-exit(a.class);
        return true;
    L15:
        System.mapLibraryName("monitorcollector-lib");     // Catch: Throwable -> L18
        return false;
    L14:
        return false;
    L18:
        th = move-exception;
        throw th;
    }
}
