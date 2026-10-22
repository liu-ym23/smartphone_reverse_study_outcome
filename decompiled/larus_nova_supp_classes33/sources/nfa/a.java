package nfa;

import android.app.Activity;
import android.app.ActivityManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void stopService() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.a().getCurrentActivity() == null) goto L14;
        IAgentAppIntentIDL r1 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r1 == null) goto L7;
        r1.terminateService();
    L7:
        Activity r2 = r0.a().getCurrentActivity();
        Intrinsics.checkNotNull(r2);
        Object r3 = r2.getSystemService("activity");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.ActivityManager");
    L12:
        e = move-exception;
        e.printStackTrace();
        FLogger.a.i("AppStopServiceManager", "stop service failed: " + e.getMessage());
        return;
    L9:
        if (((ActivityManager) r3).clearApplicationUserData() == false) goto L18;
        System.exit(0);     // Catch: Exception -> L12
        FLogger.a.i("AppStopServiceManager", "stop service success，now exit doubao pc and aikernel service");     // Catch: Exception -> L12
        return;
    L18:
        return;
    L14:
        FLogger.a.i("AppStopServiceManager", "stopService failed , currentActivity is null");
    }
}
