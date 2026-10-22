package y4;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.v;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13676a = "ttnet_debug_mode";

    static {
    }

    private static boolean a() {
        if (TTNetInit.ENV.RELEASE == TTNetInit.getEnv()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(Context r10) {
        if (a() == true) goto L6;
        Logger.d(f13676a, "debug_mode close");
        return;
    L6:
        d(r10);
    }

    public static void c() {
        Logger.setLogLevel(2);
        v.b(Logger.getLogLevel());
    }

    private static void d(Context r10) {
        Logger.d(f13676a, "debug_mode open");
        if (b.b(r10) == false) goto L6;
        c();
        return;
    }

    public static boolean e() {
        if (a() == true) goto L7;
        return false;
    L7:
        return b.c(TTNetInit.getTTNetDepend().getContext());
    }
}
