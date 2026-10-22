package w4;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.crash.Npth;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f13379a = true;

    static {
    }

    public static void a() {
        if (f13379a == true) goto L10;
        return;
    L10:
        int r10 = Npth.f1468a;     // Catch: Throwable -> L7
        Reflect.on(Npth.class.newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, new Object[]{2616, "4.2.228.21-doubao"});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
