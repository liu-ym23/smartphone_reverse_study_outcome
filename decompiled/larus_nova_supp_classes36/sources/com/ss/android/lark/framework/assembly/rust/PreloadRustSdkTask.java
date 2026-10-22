package com.ss.android.lark.framework.assembly.rust;

import android.content.Context;
import android.os.Process;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PreloadRustSdkTask extends AsyncLaunchTask {

    public class a implements Runnable {
        @JvmStatic
        public static void a() {
            Intrinsics.checkNotNullParameter("lark", "libName");
            FLogger r0 = FLogger.a;
            r0.i("Librarian_loadLib", "loadLibrary start libName -> lark");
            com.bytedance.librarian.a.c("lark");
            r0.i("Librarian_loadLib", "loadLibrary success by librarian -> lark");
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = Process.getThreadPriority(Process.myTid());     // Catch: Throwable -> L12
            Process.setThreadPriority(-4);     // Catch: Throwable -> L6
            a();     // Catch: Throwable -> L6
        L8:
            Process.setThreadPriority(r0);     // Catch: Throwable -> L12
            return;
        L6:
            th = move-exception;
            Log.i("PreloadRustSdkTask", th);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Process.setThreadPriority(r0);     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }

        public a() {
        }
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            int r0 = Process.getThreadPriority(Process.myTid());     // Catch: Throwable -> L9
            Process.setThreadPriority(-4);     // Catch: Throwable -> L6
            jcb.b.c().preload();     // Catch: Throwable -> L6
            ((xzb.a) ApiUtils.getApi(xzb.a.class)).getSession();     // Catch: Throwable -> L6
            Process.setThreadPriority(r0);     // Catch: Throwable -> L9
            return;
        L6:
            th = move-exception;
            Process.setThreadPriority(r0);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public b() {
        }
    }

    public PreloadRustSdkTask() {
    }

    public final void a(Context r2) {
        Log.i("PreloadRustSdkTask", "start load domain config");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a());
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new b());
    }
}
