package com.ss.android.lark.officesdk.integrator.im;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.preview.actions.ActionImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements Runnable {
    public final /* synthetic */ IGetDataCallback<Object> a;

    public i(ActionImpl.onActionTriggered.1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onError(new ErrorResult("IIMApi is unavailable"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
