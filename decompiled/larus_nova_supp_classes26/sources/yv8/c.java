package yv8;

import android.app.Application;
import android.content.Intent;
import android.os.Process;
import com.larus.common.apphost.AppHost;
import com.larus.network.m;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a() {
        Application r0 = AppHost.a.getApplication();
        Intent r1 = r0.getPackageManager().getLaunchIntentForPackage(r0.getPackageName());
        if (r1 != null) goto L6;
        return "SetTestEnv failed for null launchIntent";
    L6:
        r1.addFlags(67108864);
        r0.startActivity(r1);
        Process.killProcess(Process.myPid());
        System.exit(0);
        return "";
    }

    @JvmStatic
    public static final String b() {
        Lazy r0 = m.a;
        m.c("", "");
        Thread.sleep(10);     // Catch: InterruptedException -> L12
        String r1 = a();
        if (r1.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        return r1;
    L10:
        return "SetTestEnv success with online environment.";
    L7:
        r2 = false;
    L12:
        e = move-exception;
        return "SetTestEnv failed for exception occurred with message " + e.getMessage();
    }
}
