package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m3 {
    public static m3 c;
    public final Context a;
    public ArrayList b;

    public final int b() {
        Intent r0 = a(this.a, new IntentFilter((String) p2.a(16777217, 0, 0, "6c5f6d", new byte[]{38, 111, 66, 0, 6, 122, 49, 12, 109, 56, 51, 100, 72, 6, 71, 114, 54, 86, 109, 57, 41, 47, 100, 51, 61, 71, 16, 112, 93, 9, 4, 73, 103, 60, 46, 86, 17})));
        if (r0 != null) goto L6;
        return -1;
    L6:
        return Math.round(((r0.getIntExtra((String) p2.a(16777217, 0, 0, "2db633", new byte[]{47, 99, 7, 71, 0}), -1) / r0.getIntExtra((String) p2.a(16777217, 0, 0, "69af85", new byte[]{52, 56, 19, 30, 2}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public final int d() {
        Intent r0 = a(this.a, new IntentFilter((String) p2.a(16777217, 0, 0, "a3ca1d", new byte[]{113, 63, 20, 7, 1, 122, 102, 92, 59, 63, 100, 52, 30, 1, 64, 114, 97, 6, 59, 62, 126, ByteCompanionObject.MAX_VALUE, 50, 52, 58, 71, 71, 32, 11, 14, 83, 25, 49, 59, 41, 86, 70})));
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getIntExtra((String) p2.a(16777217, 0, 0, "82cfd0", new byte[]{57, 60, 5, 21, 92, 34, 63}), -1);
    }

    public m3(Context r2) {
        this.a = null;
        this.b = new ArrayList();
        this.a = r2;
    }

    public static m3 c(Context r2) {
        if (c != null) goto L15;
        monitor-enter(m3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new m3(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m3.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r10);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r10, 0, null, null, 2, r9);     // Catch: Exception -> L36
        int r2 = r1.result;     // Catch: Exception -> L36
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L19;
        return r9.registerReceiver(null, r10);
    L19:
        return r1.intent;
    L21:
        return new Intent();
    L23:
        return r9.registerReceiver(null, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r9.registerReceiver(null, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r9, null, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r9.registerReceiver(null, r10);
    }
}
