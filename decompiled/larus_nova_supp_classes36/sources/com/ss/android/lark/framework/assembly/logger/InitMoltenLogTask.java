package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import com.bytedance.lark.sdk.log.MoltenLog;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.g;
import com.ss.android.lark.utils.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/framework/assembly/logger/InitMoltenLogTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "isAsync", "", "logger-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitMoltenLogTask extends AbstractLaunchTask<InitMoltenLogTask> {
    public InitMoltenLogTask() {
    }

    public final void a(Context r12) {
        String r0 = z.c(r12);
        boolean r2 = false;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = "main";
    L8:
        boolean r3 = g.a;
        boolean r4 = DevEnvUtil.isDebugMode(r12);
        String r13 = a0.d(r12);
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r13, "logDir");
        Intrinsics.checkNotNullParameter(r0, "processName");
        if (g.a == true) goto L32;
        g.a = true;
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L27
        String r10 = System.getProperty("molten_ffi.molten_log.lib_name");     // Catch: Exception -> L27
        if (r10 != null) goto L15;
    L16:
        r2 = true;
    L17:
        if (r2 == false) goto L19;
        System.setProperty("molten_ffi.molten_log.lib_name", "lark");     // Catch: Exception -> L27
    L19:
        if (r4 == false) goto L21;
        int r5 = MoltenLog.a;     // Catch: Exception -> L27
        MoltenLog.a.a(MoltenLog.Level.TRACE);     // Catch: Exception -> L27
    L22:
        PolarisFileWrapper r6 = new PolarisFileWrapper(r13, "molten");     // Catch: Exception -> L27
        if (r6.exists() == true) goto L25;
        r6.mkdirs();     // Catch: Exception -> L27
    L25:
        String r14 = r6.getAbsolutePath();     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r14, "logPath");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r0, "processName");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r14, "logPath");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r0, "processName");     // Catch: Exception -> L27
        Log.i("MoltenInitializer", "molten logger init status=" + MoltenLog.b(r0, r14) + " cost: " + (System.currentTimeMillis() - r8) + "ms");     // Catch: Exception -> L27
        return;
    L21:
        int r7 = MoltenLog.a;     // Catch: Exception -> L27
        MoltenLog.a.a(MoltenLog.Level.INFO);     // Catch: Exception -> L27
        goto L22
    L15:
        if (r10.length() != 0) goto L17;
    L27:
        e = move-exception;
        Log.e("MoltenInitializer", "molten logger init error", e);
        return;
    L32:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
