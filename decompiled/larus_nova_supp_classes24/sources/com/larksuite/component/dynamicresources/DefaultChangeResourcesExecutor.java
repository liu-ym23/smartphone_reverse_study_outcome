package com.larksuite.component.dynamicresources;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
class DefaultChangeResourcesExecutor implements DynamicResourcesFacade$ChangeResourcesExecutor {

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    public DefaultChangeResourcesExecutor() {
    }

    @Override // com.larksuite.component.dynamicresources.DynamicResourcesFacade$ChangeResourcesExecutor
    public <T> void execute(DynamicResourcesFacade$ChangeResourcesExecutor.b<T> r3, DynamicResourcesFacade$ChangeResourcesExecutor.a<T> r4) {
        Looper r0 = Looper.myLooper();
        Looper r1 = Looper.getMainLooper();
        if (r0 != r1) goto L5;
        r3.run();
        r4.run();
        return;
    L5:
        Log.i("DynamicResources", "not in main thread, curr thread is " + ThreadMethodProxy.currentThread());
        new Handler(r1).post(new a());
    }
}
