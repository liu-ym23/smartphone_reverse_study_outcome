package com.ss.android.lark.conditional.access.utils;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final ArrayList<String> a = null;
    public static final ScheduledExecutorService b = null;
    public static final boolean c = false;
    public static final boolean d = false;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.a.add(Calendar.getInstance().getTime() + ": " + this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c() {
    }

    static {
        a = new ArrayList();
        b = CoreThreadPool.getDefault().getSingleScheduledThreadPool("FilePolicyLog");
        c = DevEnvUtil.isDebugMode(LarkContext.getApplication());
        d = DevEnvUtil.isDevelopPackage(LarkContext.getApplication());
    }

    public static void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (c == false) goto L5;
    L6:
        b.execute(new a(r2));
        return;
    L5:
        if (d == true) goto L6;
    }

    public static void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter("PolicyEngine.checkPointcutIsControlledByFactors return result, but validateUid != mUserId", "msg");
        ScsLogger.e(r2, "PolicyEngine.checkPointcutIsControlledByFactors return result, but validateUid != mUserId");
    }

    public static void a(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "msg");
        ScsLogger.a(r1, r2);
        if (r3 == false) goto L6;
        c(r2);
        return;
    }

    public static void b(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "msg");
        ScsLogger.d(r1, r2);
        if (r3 == false) goto L6;
        c(r2);
        return;
    }
}
